/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HungrySquirrel;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Luke
 */
public class HungrySquirrelGame {
    public static void main (String[] args){
     
        Maze tree = new Maze("C:/Users/Luke/Documents/NetBeansProjects"
                + "/LukeRamsey/LukeRamsey/Maze.txt");
        tree.display();
        Squirrel steve;
        while(true)
        {
            try
            {
                steve = new Squirrel();
                break;
            }
            catch (InputMismatchException m)
            {
                System.out.println("Only integers can be accepted as "
                        + "coordinates. Please try again.");
            }
        }
        Chipmunk jerry = new Chipmunk();
        Chipmunk jessie = new Chipmunk();
        Chipmunk nickey = new Chipmunk();
        System.out.println("\n");
        Nuts[] squirrelFood = new Nuts[5];
        for(int i = 0; i < 5; i ++)
        {
            double n = Math.random();
            if (n < 0.5)
            {
                squirrelFood[i] = new Almond();
            }
            else
            {
                squirrelFood[i] = new Peanut();
            }
        }
        PoisonousMushroom[] badFood = new PoisonousMushroom[5];
        for (int i = 0; i < 5; i++)
        {
            badFood[i] = new PoisonousMushroom();
        }
        System.out.println("Welcome to the Hungry Squirrel Game. "
                + "Enter the commands u, d, l, r, to move Up, Down, "
                + "Left, and Right respectively, or enter i for instructions. "
                + "Collect all the nuts, but don't let the Chipmunks "
                + "beat you!\n");
        tree.display();
        Scanner gameControls = new Scanner(System.in);
        while(!gameControls.hasNext("done"))
        {
            if (gameControls.hasNext("i"))
            {
                System.out.println("Once the 5 nuts are taken from the tree, "
                        + "the game ends.\nAlmonds: +5 points. "
                        + "Peanuts: +10 points and give a +1 "
                        + "speed.\nMushrooms: -15 points and speed set to 1.\n"
                        + "Chipmunks: walking into them is -5 points and if "
                        + "they run into you -10 points.\nChipmunks can also "
                        + "gather your nuts, so be fast! Don't let them "
                        + "outscore you or get more nuts\nIf your points < 0 "
                        + "the Squirrel dies, so be careful out there.");
                gameControls.next();
            }
            else if (gameControls.hasNext("u"))
            {
                nickey.motion();
                jessie.motion();
                jerry.motion();
                steve.moveUp();
                tree.display();
                gameControls.next();
            }
            else if (gameControls.hasNext("d"))
            {
                nickey.motion();
                jessie.motion();
                jerry.motion();
                steve.moveDown();
                tree.display();
                gameControls.next();
            }
            else if (gameControls.hasNext("l"))
            {
                nickey.motion();
                jessie.motion();
                jerry.motion();
                steve.moveLeft();
                tree.display();
                gameControls.next();
            }
            else if (gameControls.hasNext("r"))
            {
                nickey.motion();
                jessie.motion();
                jerry.motion();
                steve.moveRight();
                tree.display();
                gameControls.next();
             
            }
            else
            {
                gameControls.next();
            }
            if (steve.points < 0)
            {
                System.exit(0);
            }
            if (steve.nutsCollected + jerry.nutsCollected 
                    + jessie.nutsCollected + nickey.nutsCollected == 5)
            {
                System.out.println("Score: Squirrel " + steve.statCheck() 
                        + " Chipmunks: " + jerry.statCheck() + ", " 
                        + jessie.statCheck() + ", " + nickey.statCheck());
                if (steve.points > jerry.points + jessie.points + nickey.points 
                        && steve.nutsCollected > 2)
                {    
                    System.out.println("Squirrel collected nuts and beat "
                            + "the Chipmunks! Total points " + steve.points 
                            +"\nThank you for playing this game");
                    System.exit(0);
                }
                else if (steve.points <= jerry.points + jessie.points + 
                        nickey.points)
                {
                    System.out.println("The Chipmunks outscored you, please try"
                            + " again.\nGame over");
                    System.exit(0);
                }
                else
                {
                    System.out.println("The Chipmunks got more nuts then you, "
                            + "please try again.\nGame Over");
                    System.exit(0);
                }
            }
        }
    }
}
