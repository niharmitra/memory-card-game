# Design Document - Memory

<b>Game Description:</b>
A single player implementation of the card game Memory, also known as Concentration.

## Runtime instructions
This is a Java project that is played from the command-line. In an IDE, the project files can be imported and the game can be played in the IDE console. <br />
If using the command-line directly, use `javac *.java` to compile all the .java files. Then execute the program using `java -cp . com.niharmitra.Main`

Playing the game just requires following the displayed instructions. Type user input with the keyboard and hit enter to send it.

## Testing instructions
This project uses JUnit to test certain features. The tests are in the `test/` directory and can be run using an IDE or the command-line (the IDE is recommended).

## Design choices:
<b>Code design choices:</b>
As this project is currently only designed to run one card game, the central design choices were to minimize bloat while keeping a readable and extensible object-oriented design. <br />
The rationale for each class:
 
* `Card`: An essential data structure to store all the aspects of each card.
* `Deck`: Makes shuffling easier and accesses cards using 1 index rather than 0 index.
* `Game`: The central game engine to run all game-specific features without relying on the Main class. Tracks score and game progress. Prints out game status information.
* `Main`: Starts the program and handles all user input. Monitors the game state, validates user input, handles game exit and prints out instructions.

<b>Gameplay design choices:</b>
As a minimalistic command-line application with 52 cards in play, it did not seem appropriate to design a visual UI. Instead, a feature that listed all the remaining card indices was added to prevent frustration at forgetting which cards remained unmatched. Quitting is allowed at any point, and the current score can be checked while playing.
A feature that cleared the screen after an unsuccessful match was tested and removed, because the output looked choppy. Since scrolling can be used to "cheat" regardless, it seemed unnecessary.

## Tool choices
Language: Java was the language of choice. Java is a popular language that is very readable. It helps maintain a type-safe object-oriented design and comes with the features needed for a command-line application. It also has platform cross-compatibility and higher-level features such as easy exception handling and a popular testing suite library.

JUnit: The most popular testing library for Java. It automates testing and is quick to set up and use. Allows for easy testing of all the classes, including in isolation, which helped test the architecture and design before the game was completely functional. Unit tests also make tests repeatable and accessing edge cases easier. 