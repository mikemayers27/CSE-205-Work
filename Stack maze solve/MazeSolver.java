
// Assignment #: 11
//         Name: Michael Mayers
//    StudentID: 1221983412
//      Lecture: 12:20-1:10
//  Description: Maze Solver class

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MazeSolver {
    private Stack<Node> stack;
    private char[][] maze;
    private int eggFound;
    private int mHeight;
    private int mWidth;

    //This method is the constructor for MazeSolver
    public MazeSolver()
    {

        stack = new Stack<>();
        eggFound = 0;
        mHeight = 0;
        mWidth = 0;
    }

    //This method is depth first search and is used to traverse the maze
    public void depthFirstSearch() {

        Node n = new Node(0,0);
        stack.push(n);
        maze[0][0] = 'x';


        while(!stack.empty()) {
                Node s = stack.pop();
                int y = s.getY();
                int x = s.getX();


                if (maze[y][x] == 'E') {
                    eggFound++;
                }
                maze[y][x] = 'x';

                if (y >= 0 && x >= 0 && y+1 < mHeight && x < mWidth) {

                    if(maze[y+1][x] != '#' && maze[y+1][x] != 'x')
                    {

                            Node s2 = new Node(x,y+1);
                            stack.push(s2);


                    }
                }



                if(y >= 0 && x >= 0 && x+1 < mWidth && y < mHeight)
                {
                    if(maze[y][x+1] != '#' && maze[y][x+1] != 'x')
                    {


                        Node s4 = new Node(x+1,y);
                        stack.push(s4);
                    }
                }



                if(y > 0 && x > 0 && y < mHeight && x < mWidth)
                {
                    if(maze[y-1][x] != '#' && maze[y-1][x] != 'x')
                    {

                        Node s6 = new Node(x, y-1);
                        stack.push(s6);

                    }
                }



                if(y > 0 && x > 0 && x < mWidth && y < mHeight)
                {
                    if(maze[y][x-1] != '#' && maze[y][x-1] != 'x')
                    {


                        Node s8 = new Node(x-1,y);
                        stack.push(s8);

                }
            }
        }
    }

    //This method gets the amount of eggs found during the traversal
    public int getEggFound()
    {

        return eggFound;
    }

    //This method prints out the maze
    public void printMaze()
    {
        for(int i = 0; i < mHeight; i++)
        {
            for(int j = 0; j < mWidth; j++)
            {

                int a = 0;
                System.out.print(maze[i][j]);

            }
            System.out.println();
        }

    }
    // ************************************************************************************
    // ************** Utility method to read maze from user input *************************
    // ************************************************************************************
    //This method reads the maze input
    public void readMaze() {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Height of the maze: ");
            String line = reader.readLine();
            mHeight = Integer.parseInt(line);

            System.out.println("Width of the maze: ");
            line = reader.readLine();
            mWidth = Integer.parseInt(line);
            maze = new char[mHeight][mWidth];

            for (int i = 0; i < mHeight; i++) {
                line = reader.readLine();
                for (int j = 0; j < mWidth; j++) {
                    maze[i][j] = line.charAt(j);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

