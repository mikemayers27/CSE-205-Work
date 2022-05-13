
// Assignment #: 11
//         Name: Michael Mayers
//    StudentID: 1221983412
//      Lecture: 12:20-1:10
//  Description: Driver class

public class Assignment11 {

    //This is the main method
    public static void main(String[] args) {
        MazeSolver mazeSolver = new MazeSolver();
        mazeSolver.readMaze();

        System.out.println("Original maze: ");
        mazeSolver.printMaze();

        mazeSolver.depthFirstSearch();

        System.out.println("Maze after Easter Bunny traverse: ");
        mazeSolver.printMaze();

        if (mazeSolver.getEggFound() == 0)
            System.out.println("The Bunny was unable to recover the eggs, Easter is cancelled!");
        else
            System.out.println("The Easter Bunny found " + mazeSolver.getEggFound() + " egg(s)!");
    }
}
