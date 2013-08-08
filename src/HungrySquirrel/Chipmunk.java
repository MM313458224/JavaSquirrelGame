/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HungrySquirrel;

/**
 *
 * @author Luke
 */
public class Chipmunk extends Squirrel {
    
    Chipmunk()
    {
        points = 0;
        nutsCollected = 0;
        speed = 3;
    }
    
    @Override
    public void create()
    {
        int xc = (int)(Math.random() * 50);
        int yc = (int)(Math.random() * 20);
        while (Maze.maze[yc][xc] != ' ')
        {
             xc = (int)(Math.random() * 50);
             yc = (int)(Math.random() * 20);
        }
        x = xc;
        y = yc;
        Maze.maze[y][x] = 'C';
    }
    
    @Override
    public char getSymbol()
    {
        symbol = 'C';
        return symbol;
    }
    
    @Override
    public String statCheck()
    {
        return "(Chipmunks Points: " + points + ", Chipmunks Nuts: " 
                + nutsCollected +", Chipmunk Speed: " + speed + ")";
    }
    
    @Override
    public void almondMessage()
    {
        System.out.println("The Chipmunk stole your almond! " + statCheck());
    }
    
    @Override
    public void peanutMessage()
    {
        System.out.println("The Chipmunk stole your peanut! " + statCheck());
    }
    
    @Override
    public void mushroomMessage()
    {
        System.out.println("The Chipmunk ate a poisonous mushroom.  He is"
                + " feeling sick " + statCheck());
    }
    
    @Override
    public void chipmunk()
    {
        if (points >= 0)
        {   
            speed = 1;
            System.out.println("The Chipmunks are fighting. "
                    + "Now's your chance!");
        }
        else
        {
            death();
        }
    }
    
    @Override
    public void deathMessage()
    {
        System.out.println("The Chipmunk died. Poor guy");
    }
    
    @Override
    public void bully()
    {
        if (points>= 0)
        {
            create();
            System.out.println("The Chipmunks are fighting. "
                    + "Now's your chance!");
        }
        else
        {
            death();
        }
    }
    
    @Override
    void moveLeft()
    {
        if (Maze.maze[y][x-1] == '*')
        {
            double n = Math.random();
            if (n<.33)
            {
                moveUp();
            }
            else if (n>=.33 & n<.66)
            {
                moveDown();
            }
            else
            {
                moveRight();
            }
        }
        else
        {
            super.moveLeft();
        }
    }
    
    @Override
    void moveRight()
    {
        if (Maze.maze[y][x+1] == '*')
        {
            double n = Math.random();
            if (n<.33)
            {
                moveUp();
            }
            else if (n>=.33 & n<.66)
            {
                moveDown();
            }
            else
            {
                moveLeft();
            }
        }
        else
        {
            super.moveRight();
        }
    }
        
    @Override
    void moveUp()
    {
        if (Maze.maze[y-1][x] == '*')
        {
            double n = Math.random();
            if (n<.33)
            {
                moveLeft();
            }
            else if (n>=.33 & n<.66)
            {
                moveRight();
            }
            else
            {
                moveDown();
            }
        }
        else
        {
            super.moveUp();
        }
    }
    
    @Override
    void moveDown()
    {
        if (Maze.maze[y+1][x] == '*')
        {
            double n = Math.random();
            if (n<.33)
            {
                moveLeft();
            }
            else if (n>=.33 & n<.66)
            {
                moveRight();
            }
            else
            {
                moveUp();
            }
        }
        else
        {
            super.moveDown();
        }
    }
    
    public void motion()
    {
        if (!(points < 0))
        {
            double n = Math.random();
            if (squirrelX < x)
            {
                if (n <= .1)
                {
                    moveRight();
                }
                else if (n > .1 && n <= .5)
                {
                    moveLeft();
                }
            }
            else if (squirrelX > x)
            {
                if (n <= .1)
                {
                    moveLeft();
                }
                else if (n > .1 && n <= .5)
                {
                    moveRight();
                }
            }
            else 
            {
                if (squirrelY < y)
                {
                    if (n <= .2)
                    {
                        moveUp();
                    }
                    else if (n > .2)
                    {
                        moveDown();
                    }
                }
                else
                {
                    if (n <= .2)
                    {
                        moveDown();
                    }
                    else if (n > .2)
                    {
                        moveUp();
                    }
                }
            }
            if (squirrelY < y)
            {
                if (n > .5 && n <= .6)
                {
                    moveUp();
                }
                else if (n > .6)
                {
                    moveDown();
                }
            }
            else if (squirrelY > y)
            {
                if (n > .5 && n <= .6)
                {
                    moveDown();
                }
                else if (n > .6)
                {
                    moveUp();
                }
            }
            else 
            {
                if (squirrelX < x)
                {
                    if (n <= .2)
                    {
                        moveRight();
                    }
                    else if (n > .2)
                    {
                        moveLeft();
                    }
                }
                else
                {
                    if (n <= .2)
                    {
                        moveLeft();
                    }
                    else if (n > .2)
                    {
                        moveRight();
                    }
                }
            }
        }
    }
}
