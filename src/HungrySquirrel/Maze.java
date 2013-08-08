/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HungrySquirrel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Luke
 */
public class Maze {
    
    
    static int maxMazeRow = 20;
    static int maxMazeColumn = 50;
    public static char[][] maze;
    BufferedReader superRead;
    Maze(String fileName)
    {
        create(fileName);
        this.maze = maze;
    }
    int create(String fileName)
    {
        File mazeTemplate = new File(fileName);
        maze = new char[maxMazeRow][maxMazeColumn];
        try 
        {
            FileReader read = new FileReader(mazeTemplate);
            superRead = new BufferedReader(read);
        }
        catch (FileNotFoundException noMaze)
        {
            System.out.println("Please input a maze");
            System.exit(0);
        }
        try 
        {
            for (int i = 0; i < maxMazeRow; i++)
            {
                String row = superRead.readLine();
                for (int j = 0; j < maxMazeColumn; j++)
                {
                    maze[i][j] = row.charAt(j);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace(System.out);
        }
        return 1;
    }
    
    public static Boolean available(int row, int column)
    {
        if (row > maxMazeRow - 1 || row < 0)
        {
            System.out.println("Invalid row entry");
            System.exit(0);
        }
        if (column > maxMazeColumn -1 || column < 0)
        {
            System.out.println("Invalid column entry");
            System.exit(0);
        }
        char spot = maze[row][column];
        if (spot == ' ')
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    static void display()
    {
        for(int i = 0; i < maxMazeRow; i++)
        {
            String line = "";
            for(int j = 0; j < maxMazeColumn; j++)
            {
                line += maze[i][j];
            }
            System.out.println(line);
        }
       System.out.println();
    }
    
}
