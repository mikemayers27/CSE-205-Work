// Assignment: Assignment 8
// Name: Michael Mayers
// StudentID: 1221983412
// Lecture: M/W/F 12:20-110
// Description: driver

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.nio.file.FileAlreadyExistsException;

public class Assignment8 {
    public static void main(String[] args) {
        // Menu options
        char inputOpt = ' ';
        String inputLine;
        // Restaurant and Cuisine information
        String restaurantName, cuisineName;
        String review = null, location, signatureDish, priceRange;

        int rating = 0;
        // Output information
        String outFilename, inFilename;
        String outMsg, inMsg;
        // Restaurant manager
        ReviewManager reviewManager = new ReviewManager();
        // Operation result
        boolean opResult;     
        
        try {
            printMenu();
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader stdin = new BufferedReader(isr);

            do {
                System.out.print("\nWhat action would you like to perform?\n");
                inputLine = stdin.readLine().trim();
                if (inputLine.isEmpty()) {
                    continue;
                }
                inputOpt = inputLine.charAt(0);
                inputOpt = Character.toUpperCase(inputOpt);

                switch (inputOpt) {

                    case 'A': // Add a new Restaurant Review
                        System.out.print("Please enter the restaurant information:\n");
                        System.out.print("Enter the restaurant name:\n");
                        restaurantName = stdin.readLine().trim();
                        System.out.print("Enter the review:\n");
                        review = stdin.readLine().trim();
                        System.out.print("Enter the price range:\n");
                        priceRange = stdin.readLine().trim();
                        System.out.print("Enter the rating:\n");
                        rating = Integer.parseInt(stdin.readLine().trim());
                        System.out.print("Enter the cuisine name:\n");
                        cuisineName = stdin.readLine().trim();
                        System.out.print("Enter the location:\n");
                        location = stdin.readLine().trim();
                        System.out.print("Enter the signature dish\n");
                        signatureDish = stdin.readLine().trim();
                        if(reviewManager.addReview(restaurantName, rating, review, 
                        priceRange, cuisineName, location, signatureDish))
                        {
                           System.out.println("Restaurant added\n");
                        }
                        else
                        {
                           System.out.println("Restaurant NOT added\n");
                        }
                        break;
                        /*********************************************************************
                        * Complete the code by calling the addReview method.                 *
                        * If the review has been added successfully, show                    *
                        * "Restaurant added\n" on screen, otherwise "Restaurant NOT added\n" *
                        **********************************************************************/


                    case 'D': // Search a Restaurant
                        System.out.print("Please enter the restaurant name to search:\n");
                        restaurantName = stdin.readLine().trim();
                        System.out.print("Please enter the restaurant's location':\n");
                        location = stdin.readLine().trim();
                        if(reviewManager.restaurantExists(restaurantName, location) != -1)
                        {
                           System.out.println("Restaurant found. Here's the review:\n" + reviewManager.getRestaurant(reviewManager.restaurantExists(restaurantName, location)).getReview()); 
                        }
                        else
                        {
                           System.out.println("Restaurant not found. Please try again\n");
                        }
                        break;
                        /*********************************************************************
                        * Complete the code. If a restaurant review exists, print            *
                        * "Restaurant found. Here's the review:\n"                           *
                        * Otherwise, print "Restaurant not found. Please try again\n"        *
                        **********************************************************************/                 


                    case 'E': // Search a cuisine
                        System.out.print("Please enter the cuisine name to search:\n");
                        cuisineName = stdin.readLine().trim();
                        
                        
                        if(reviewManager.cuisineExists(cuisineName).get(0) != -1)
                        {
                           
                           int x = reviewManager.cuisineExists(cuisineName).size();
                           String y = "";
                           for(int i = 0; i < x; i++)
                           {
                              y += reviewManager.getRestaurant(reviewManager.cuisineExists(cuisineName).get(i)).toString();
                           }
                           System.out.printf("%d Restaurants matching %s cuisine were found:\n", x, cuisineName);
                           System.out.println(y);
                           
                        }
                        else
                        {
                           System.out.printf("Cuisine: %s was NOT found\n", cuisineName);
                        }
                        break;
                        /*******************************************************************************
                        * Complete the code. If a cuisine is found, show on the screen how many       *
                        * restaurants match that cuisine by printing                                  *
                        * "%s Restaurants matching %s cuisine were found:\n" followed by the reviews. *
                        * Otherwise, print "Cuisine: %s was NOT found\n"                              *
                        ******************************************************************************/   
                        
   
                    case 'L': // List restaurant's reviews
                        System.out.print("\n" + reviewManager.listReviews() + "\n");
                        break;
                        
                     /******************************************************************************************
                     * Complete the code by adding two cases:                                                  *
                     * case 'N': sorts the restaurant reviews by rating and prints "sorted by rating\n"        *
                     * case 'P': sorts the restaurant reviews by cuisine name and prints "sorted by cuisine\n" *
                     ******************************************************************************************/                        
                 
                   case 'N':
                        reviewManager.sortByRating();
                        System.out.println("sorted by rating\n");
                        
                        break;
                    
                   case 'P':
                        reviewManager.sortByCuisine();
                        System.out.println("sorted by cuisine\n");
                        
                        break;
                        
                    case 'Q': // Quit
                        break;

                    case 'R': // Remove a review
                        System.out.print("Please enter the restaurant name of the review to remove:\n");
                        restaurantName = stdin.readLine().trim();
                        System.out.print("Please enter the location to remove:\n");
                        location = stdin.readLine().trim();
                        
                        if(reviewManager.removeReview(restaurantName, location))
                        {
                           System.out.println(restaurantName + ", " + location + " was removed\n");
                           
                        }
                        else
                        {
                           System.out.println(restaurantName + ", " + location + " was NOT removed\n");
                        }
                        break;
                        /*******************************************************************************
                        * Complete the code. If a review for a certain restaurant at a given location  *
                        * is found, remove the review and print that it was removed. Otherwise         *
                        * print that it was NOT removed.                                               * 
                        *******************************************************************************/
                        
                        
                    case 'T': // Close reviewList
                        reviewManager.closeReviewManager();
                        System.out.print("Restaurant management system was reset\n");
                        break;

                    case 'U': // Write restaurant names and reviews to a text file
                        System.out.print("Please enter a file name that we will write to:\n");
                        outFilename = stdin.readLine().trim();
                        System.out.print("Please enter the name of the restaurant:\n");
                        restaurantName = stdin.readLine().trim();
                        System.out.println("Please enter a review to save locally:\n");
                        review = stdin.readLine().trim();
                        outMsg = restaurantName + "\n" + review + "\n";
                        
                        
                        /*************************************************************************************
                        * Add a try and catch block to write the string outMsg into the user-specified file  *
                        * Then, print in the screen that the file " is written\n"                            *
                        * In case of an IO Exception, print "Write string inside the file error\n"           *                                                             
                        *************************************************************************************/                    
                          try
                        {  
                           PrintWriter printer = new PrintWriter(outFilename);
                           printer.println(outMsg);
                           System.out.print(outFilename + " is written\n");
                           printer.close();
                      
                        } 
                        catch(IOException exists)
                        {
                           System.out.print("Write string inside the file error\n");
                        } 
                        break;  

                    case 'V': // Read strings from a text file
                        System.out.print("Please enter a file name which we will read from:\n");
                        inFilename = stdin.readLine().trim();
                        
                        /******************************************************************************************
                        * Add a try and catch block to read from the above text file. Confirm that the file       *
                        * " was read\n" and then print "The contents of the file are:\n" followed by the contents *
                        * In case of an IO Exception, print "Read string from file error\n"                       *  
                        * In case of a file not found exception, print that the file " was not found\n"           *                                                             
                        ******************************************************************************************/ 
                        String line;
                        int inputLine1, sum = 0;
                        try
                        {
                           FileReader fr = new FileReader(inFilename);
                           Scanner in = new Scanner(fr);
                           line = in.nextLine();
                           
                           while(in.hasNextLine())
                           {
                              line = in.nextLine();
                              inputLine1 = Integer.parseInt(line);
                              sum += inputLine1;
                           }
                           System.out.println(inFilename + " was read\n");
                           System.out.println("The contents of the file are:\n" + sum);
  
                        }
                        catch(FileNotFoundException y)
                        {
                           System.out.println(inFilename + " was not found\n");
                        }
                        
                        
                        break;
 
                    case 'W': // Serialize ReviewManager to a data file
                        System.out.print("Please enter a file name to write:\n");
                        outFilename = stdin.readLine().trim();
                        
                        /****************************************************************************
                        * Add a try and catch block to serialize ReviewManager to a data file.      *
                        * Catch two exceptions and print the corresponding messages on the screen:  *
                        * "Not serializable exception\n"                                            *
                        * "Data file written exception\n"                                           * 
                        ****************************************************************************/ 
                        try
                        {
                           FileOutputStream bytesToDisk = new FileOutputStream("reviewManager.object");
                           ObjectOutputStream objectToBytes = new ObjectOutputStream( bytesToDisk );
                           objectToBytes.writeObject(reviewManager);
                           objectToBytes.close();
                        } 
                        catch(NotSerializableException too)
                        {
                           System.out.println("Not serializable exception\n");
                        }
                        catch(FileAlreadyExistsException e)
                        {
                           System.out.println("Data file written exception\n");
                        }
                        break;
                        
                                          
                        

                    case 'X': // Deserialize ReviewManager from a data file
                        System.out.print("Please enter a file name which we will read from:\n");
                        inFilename = stdin.readLine().trim();
                        
                        /*****************************************************************************
                         * Add a try and catch block to deserialize ReviewManager from a data file.  *
                         * Catch three exceptions and print the corresponding messages on the screen:*
                         * "Class not found exception\n"                                             *
                         * "Not serializable exception\n"                                            * 
                         * "Data file read exception\n"                                              *
                         ****************************************************************************/ 
                         FileInputStream diskToStreamOfBytes = new FileInputStream("reviewManager.object");
                         ObjectInputStream objectToBytes = new ObjectInputStream(diskToStreamOfBytes); 
                         Object anyObject = null;
                         try
                         {
                              anyObject = objectToBytes.readObject();
                         }
                         catch(ClassNotFoundException cnfe)
                         {
                           System.out.print("Class not found exception\n");
                         }
                         catch(NotSerializableException ty)
                         {
                           System.out.println("Not serializable exception\n");
                         }
                         catch(IOException ui)
                         {
                              System.out.println("Data file read exception\n");
                         
                         }
                         objectToBytes.close();
                         break;
                         
                    case '?': // Display help
                        printMenu();
                        break;

                    default:
                        System.out.print("Unknown action\n");
                        break;
                }

            } while (inputOpt != 'Q' || inputLine.length() != 1);
        }
        catch (IOException exception) {
            System.out.print("IO Exception\n");
        }
    }

    public static void printMenu() {
        System.out.println("Welcome to Kelp! ");
        System.out.println("Find or post reviews for your favorite (and not so favorite) restaurants.");

        System.out.print("Choice\t\tAction\n" + "------\t\t------\n" + "A\t\tAdd a review\n"
                + "D\t\tSearch for a restaurant\n" + "E\t\tSearch for a cuisine\n"
                + "L\t\tList all reviews\n" + "N\t\tSort by stars\n" + "P\t\tSort by cuisine\n"
                + "Q\t\tQuit\n" + "R\t\tRemove a review\n"
                + "U\t\tAdd personal review to a local file\n" + "V\t\tRetrieve personal review from a local file\n"
                + "W\t\tSave reviews to a file\n"
                + "X\t\tUpload reviews from a file\n"
                + "T\t\t(admin) reset database\n"
                + "?\t\tDisplay Help\n");
    }
}