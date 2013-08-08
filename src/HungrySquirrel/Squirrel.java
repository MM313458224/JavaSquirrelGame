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
public class Squirrel extends Entity {
    
    int points;
    int nutsCollected;
    int speed;
    int squirrelX;
    int squirrelY;
    Squirrel()
    {
        points = 0;
        nutsCollected = 0;
        speed = 1;
        getSymbol();
        create();
        squirrelX = x;
        squirrelY = y;
    }
    
    @Override
    public void create()
    {
        try
        {
        System.out.println("Enter the squirrel position:");
        Scanner inputValue = new Scanner(System.in);
        System.out.print("x = ");
        x = inputValue.nextInt();
        while (x < 0 || x > Maze.maxMazeColumn - 1)
        {
            System.out.println("That x is out of bounds.  "
                    + "Please enter an integer from 0 to 49.");
            System.out.print("x = ");
            x = inputValue.nextInt();
        }
        System.out.print("y = ");
        y = inputValue.nextInt();
        while(y < 0 || y > Maze.maxMazeRow -1)
        {
            System.out.println("That y is out of bounds.  "
                    + "Please enter an integer from 0 to 19.");
            System.out.print("y = ");
            y = inputValue.nextInt();
        }
        while (Maze.available(y,x) == false)
        {
            System.out.println("Im sorry, that spot is taken.  Please pick a new squirrel position.");
            System.out.print("x = ");
            x = inputValue.nextInt();
            while (x < 0 || x > Maze.maxMazeColumn - 1)
            {
                System.out.println("That x is out of bounds.  "
                        + "Please enter an integer from 0 to 49.");
                System.out.print("x = ");
                x = inputValue.nextInt();
            }
            System.out.print("y = ");
            inputValue = new Scanner(System.in);
            y = inputValue.nextInt();
            while(y < 0 || y > Maze.maxMazeRow -1)
            {
                System.out.println("That y is out of bounds.  "
                        + "Please enter an integer from 0 to 19.");
                System.out.print("y = ");
                y = inputValue.nextInt();
            }
        }
        }
        catch (InputMismatchException m)
        {
            throw m;
        }
        System.out.println ("The squirrel is at (" + x + ", " + y + ")");
        Maze.maze[y][x] = '@';
        Maze.display();
    }
    
    @Override
    public char getSymbol()
    {
        symbol = '@';
        return symbol;
    }
    
    void moveLeft()
    {
        for (int i = 0; i < speed; i++)
        {
            if (Maze.maze[y][x-1] == 'A')
            {
                almond();
                i = speed - 1;                
            }
            else if (Maze.maze[y][x-1] == 'P')
            {
                peanut();
                i = speed - 1;                
            }
            else if (Maze.maze[y][x-1] == 'M')
            {
                i = 0;
                mushroom();                
            }
            else if (Maze.maze[y][x-1] == 'C')
            {
                i = 0;
                chipmunk();
                return;
            }
            else if (Maze.maze[y][x] != getSymbol())
            {
                bully();
                return;
            }
            if (points < 0)
            {
                death();
                move(x, y, x - 1, y, 'X');
                break;
            }
            move(x, y, x - 1, y, getSymbol());
        }
    }
    
    void moveRight()
    {
        for (int i = 0; i < speed; i++)
        {
            if (Maze.maze[y][x+1] == 'A')
            {
                almond();
                i = speed - 1;
            }
            else if (Maze.maze[y][x+1] == 'P')
            {
                peanut();
                i = speed - 1;
            }
            else if (Maze.maze[y][x+1] == 'M')
            {
                i = 0;
                mushroom();
            }
            else if (Maze.maze[y][x+1] == 'C')
            {
                i = 0;
                chipmunk();
                return;
            }
            else if (Maze.maze[y][x] != getSymbol())
            {
                bully();
                return;
            }
            if (points < 0)
            {
                death();
                move(x, y, x + 1, y, 'X');
                break;
            }         
            move(x, y, x + 1, y, getSymbol());
        }
    }
    
    void moveUp()
    {
        for (int i = 0; i < speed; i++)
        {
            if (Maze.maze[y-1][x] == 'A')
            {            
                almond();
                i = speed - 1;
            }
            else if (Maze.maze[y-1][x] == 'P')
            {                
                peanut();
                i = speed - 1;
            }
            else if (Maze.maze[y-1][x] == 'M')
            {
                i = 0;
                mushroom();
            }
            else if (Maze.maze[y-1][x] == 'C')
            {
                i = 0;
                chipmunk();
                return;
            }
            else if (Maze.maze[y][x] != getSymbol())
            {
                bully();
                return;
            }
            if (points < 0)
            {
                death();
                move(x, y, x, y - 1, 'X');
                break;
            }
        move(x, y, x, y - 1, getSymbol());
        }
    }
    
    void moveDown()
    {
        for (int i = 0; i < speed; i++)
        {
            if (Maze.maze[y+1][x] == 'A')
            {
                almond();
                i = speed - 1;
            }
            else if (Maze.maze[y+1][x] == 'P')
            {
                peanut();
                i = speed - 1;
            }
            else if (Maze.maze[y+1][x] == 'M')
            {
                i = 0;
                mushroom();
            }
            else if (Maze.maze[y+1][x] == 'C')
            {
                i = 0;
                chipmunk();
                return;
            }
            else if (Maze.maze[y][x] != getSymbol())
            {
                bully();
                return;
            }
            if (points < 0)
            {
                death();
                move(x, y, x, y + 1, 'X');
                break;
            }
        move(x, y, x, y + 1, getSymbol());
        }
    }
    
    public String statCheck()
    {
        return "(Total Points: " + points + ", Total Nuts: " + nutsCollected + 
                ", Speed: " + speed + ")";
    }
    
    public void almondMessage()
    {
        System.out.println("!!!Squirrel got 5 points " + statCheck() + "!!!");
        squirrelX = x;
        squirrelY = y;
    }
    
    public void peanutMessage()
    {
        System.out.println("!!!Squirrel got 10 points and more energy! " 
                + statCheck() + "!!!");
        squirrelX = x;
        squirrelY = y;
    }
    
    public void mushroomMessage()
    {
        System.out.println("Oh no! Squirrel is getting sick. Lose 15 points "
                + "and reset speed " + statCheck());
        squirrelX = x;
        squirrelY = y;
    }
    
    public void deathMessage()
    {
        System.out.println("Squirrel is dead -_- Game Over");
    }
    
    public void almond()
    {
        points += 5;
        nutsCollected += 1;
        almondMessage();
    }
    
    public void peanut()
    {
        points += 10;
        nutsCollected += 1;
        speed += 1;
        peanutMessage();
    }
    
    public void mushroom()
    {
        points -= 15;
        speed = 1;
        mushroomMessage();
    }
    
    public void chipmunk()
    {
        points -= 5;
        speed = 1;
        squirrelX = x;
        squirrelY = y;
        System.out.println("Oh no! The Chipmunk blocks your path. Lose 5 points" 
                + " and reset speed " + statCheck());        
    }
    
    public void bully()
    {
        int i = 0;
        points -= 10;
        squirrelX = x;
        squirrelY = y;
        if (points >= 0)
        {
            speed = 1;
            System.out.println("The Chipmunk pushed you off the tree, "
                + "how rude! " + statCheck() + " Climb back on");            
            while (true)
            {
                try
                {
                    create();
                    break;
                }
                catch (InputMismatchException m)
                {
                    System.out.println("Only integers can be accepted as "
                            + "coordinates. Please try again.");
                }
            }
        }
        else
        {
            if(Maze.available(y-1,x))
            {
                y--;
            }
            else if (Maze.available(y+1, x))
            {
                y++;
            }
            else if (Maze.available(y, x-1))
            {
                x--;
            }
            else if (Maze.available(y, x+1))
            {
                x++;
            }
            System.out.println("The Chipmunk pushed you off the tree, "
                    + "how rude!" + statCheck());
            death();
        }
    }
    
    public void death()
    {
        points = -1;
        deathMessage();
        Maze.maze[y][x] = 'X';
    }
    
}