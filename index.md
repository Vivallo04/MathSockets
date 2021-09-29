![logo](logo.png) 
# Welcome to the MathSockets wiki

This page is the official documentation for the game Math Sockets. It explains the architecture of the program, the algorithms, and data structures used in the game. You'll also find some issues we ran into and the solution we (the team in charge of the development of the game) created for them. 

The video game MathSockets was created using the Java programming language and LibGDX as the main framework for rendering and Kryonet creating and handling the socket connection. LibGDX is a free and open-source game-development application framework written in the Java programming language with some C and C++ components for performance dependent code. It allows for the development of desktop and mobile games by using the same code base. 

# What is the game about? 

MathSockets is a board game for two online-players. The game consists of a n x n board, whereas the size of n is defined by the developers, the size we chose is 5 x 5. There are three different types of tiles: 
- Challenge Tile: The players will have to solve simple algebraic mathematical operations about addition, subtraction, multiplication and division two integer operands between 1 and 50. If the other player fails, they will have to move backwards one tile and if it gets the correct result, they will keep the current position. In either/or cases the current player will move forward one tile.
- Tunnel Tile: The player that reaches such tile moves forward a random number of tiles between 1 and 3.
- Trap Tile: This tile works in the same way as the Tunnel Tile but instead of moving forward, the players will move backwards.


## Index

- [Wiki Home](https://github.com/Vivallo04/MathSockets/wiki)
- [Specifications](https://github.com/Vivallo04/MathSockets/wiki/1.-Maintaining-the-Integrity-of-the-Specifications) 
- [Class Diagram](https://github.com/Vivallo04/MathSockets/wiki/Class-Diagram)
- [Design Patterns used in the solution](https://github.com/Vivallo04/MathSockets/wiki/Design-Patterns)
- [Game States](https://github.com/Vivallo04/MathSockets/wiki/Main-Game-States)
- [Data Structures](https://github.com/Vivallo04/MathSockets/wiki/Data-Structures)
- [Algorithms](https://github.com/Vivallo04/MathSockets/wiki/Algorithms)
- [Bugs](https://github.com/Vivallo04/MathSockets/wiki/Bugs)


## Contributors
1. @Vivallo04
2. @Noemi2002
3. @Crik845

---
## License
This project is licensed under the terms of the [GNU General Public License v3.0](LICENSE).


### References
“The catalog of design patterns,” Refactoring.Guru. [Online]. Available: https://refactoring.guru/design-patterns/catalog. [Accessed: 24- Sep-2021].

