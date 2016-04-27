package cse360project;

/**
 * @author Team35
 * @version April 29, 2016
 */
/**
 * Dice class to get the value of the Dice.
 * @author Team35
 *
 */
public class Dice {
    
    private int die1;   // Dice number 1 
             
    //Rolls the Die and gives returns the Dice Value.
    public int getDie1() {
       die1 = (int)(Math.random()*6) + 1;
       return die1;
    }
 }

 