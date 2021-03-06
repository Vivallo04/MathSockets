const app = require('express')();
const server = require('http').Server(app);
const io = require('socket.io')(server);

// store the players in a list
let players = [];

// initialize the server on port 8080
server.listen(8080, function(){
    console.log("Server is now running...");
});


io.on('connection', function(socket){
    console.log("Player Connected!");
    socket.emit("SocketID", {
        id: socket.id
    });

    socket.broadcast.emit('newPlayer', {
        id: socket.id
    });

    socket.on('disconnect', function() {
        console.log("Player Disconnected");
        socket.broadcast.emit('playerDisconnected', { id: socket.id });
        for (var i = 0; i < players.length; i++) {
            if (players[i].id == socket.id) {
                players.splice(i, 1);
            }
        }
        server.close();
    });

    players.push(new player(socket.id, 0, 0));
});


function player(id, x, y) {
    this.id = id;
    this.x = x;
    this.y = y;
}