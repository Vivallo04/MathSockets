![logo](docs/logo.png) 
# MathSockets 
[![Gradle Package](https://github.com/Vivallo04/MathSockets/actions/workflows/gradle-publish.yml/badge.svg)](https://github.com/Vivallo04/MathSockets/actions/workflows/gradle-publish.yml) [![Java CI with Gradle](https://github.com/Vivallo04/MathSockets/actions/workflows/gradle.yml/badge.svg?branch=master)](https://github.com/Vivallo04/MathSockets/actions/workflows/gradle.yml)
- Doc [link](https://www.overleaf.com/9279542132rnkkgsrbsxyq) to OverLeaf
- Class Diagram [link](https://lucid.app/lucidchart/invitations/accept/inv_ecb42170-a261-42f3-b955-15b89e92216e?viewport_loc=-1707%2C-1590%2C5913%2C3003%2C0_0) to LucidChart


## Current Architecture of the Program
![MathSockets Class Diagram.png](docs/UML/MathSockets_Class_Diagram.png)


## Building

If you'd rather compile the source code on your own, follow these instructions.
First, make sure you have [JDK 16](https://adoptopenjdk.net/archive.html?variant=openjdk16&jvmVariant=hotspot) installed. **Other JDK versions will not work.** Open a terminal in the MathSockets directory and run the following commands:

### Windows
_Running:_ `gradlew desktop:run`  
_Building:_ `gradlew desktop:dist`  
_Sprite Packing:_ `gradlew tools:pack`

### Linux || Mac OS
_Running:_ `./gradlew desktop:run`  
_Building:_ `./gradlew desktop:dist`  
_Sprite Packing:_ `./gradlew tools:pack`


### Troubleshooting

#### Permission Denied
If 
the terminal returns `Permission denied` or `Command not found` on Mac/Linux, run `chmod +x ./gradlew` before running `./gradlew`. *This is a one-time procedure.*


## Documentation



## Math Sockets' State Machine
![MathSockets StateMachine.png](docs/UML/MathSocketsStateWorkflow.png)


## Feature Request
For feature requests and feedback you can create a new post [here](https://github.com/Vivallo04/MathSockets/issues).


## Download


 
## License
This project is licensed under the terms of the [GNU General Public License v3.0](LICENSE).
