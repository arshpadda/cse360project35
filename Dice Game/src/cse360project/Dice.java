package cse360project;

/**
 * @author Team35
 * @version April 15, 2016
 */

public class Dice {
    
    private int die1;   // Dice number 1
    //make as many int variable as dice you need 
             
    public int getDie1() {
       die1 = (int)(Math.random()*6) + 1;
       return die1;
    }
    //make the same number of getDie method.
 }

 