const app = require('express')();
const server = require('http').Server(app);
const io = require('socket.io')(server);


let players = [];

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
    });


});