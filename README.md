# Batman vs Superman

CSE 360 Spring 2016 Team 35

•	Alex Aguayo(akaguayo)
•	Vishal Chilka(vishalc10)
•	Shweta Choudhary(shwetachoudhary06)
•	Alexander Loizou(Ulrich282)
•	Arsh Padda(arshpadda)


To run the game, run the Project.java file.

The implementation of the project is a Java applet.  Project.java, PlayPanel.java, StatPanel.java, Stats.java, Character.java, and Dice.java are used.  ProjectTest.java and StatsTest.java contains unit tests.

The applet has a Play tab and a Stat tab.
Statistics are saved locally in a file called statistics.txt, if it doesn't exist it will be created.
When the applet is closed, statistics.txt is updated.

The game is for two to eight players and divided into rounds.
Each round has two players making simultaneous turns.
Each turn, players choose a weapon to attack with and a body part to defend.
Every weapon has a certain attack power, and a targeted body part.
If the other player is blocking the area your weapon attacks, damage is completely blocked.
Two dice are rolled to decide if an attack is a critical hit, if the sum is 12 the damage dealt is increased by 100%.

The fight ends when a player reaches zero health, and the survivor is the winner.
In the case where both players die simultaneously, the match is a draw.
The survivor advances to the next bracket if a tournament is ongoing.
