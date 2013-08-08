/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HungrySquirrel;

/**
 *
 * @author Luke
 */
public abstract class Nuts extends Entity {
    
    final int totalNuts = 5;
    static int nutritionPoints;
    
    int isNuts(char symbol)
    {
        if (symbol == 'P' || symbol == 'A')
        {
            return nutritionPoints;
        }
        else
        {
            return 0;
        }        
    }
    
    @Override
    public void create()
    {
        int xn = (int)(Math.random() * 50);
        int yn = (int)(Math.random() * 20);
        while (Maze.maze[yn][xn] != ' ')
        {
             xn = (int)(Math.random() * 50);
             yn = (int)(Math.random() * 20);
        }
        x = xn;
        y = yn;
        Maze.maze[y][x] = getSymbol();
    }
}
