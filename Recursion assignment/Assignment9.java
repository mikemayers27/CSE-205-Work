
// Assignment #: 9
//         Name: Michael Mayers
//    StudentID: 1221983412
//      Lecture: 12:20-1:10
//  Description: Driver class

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Assignment9 {

    public static void main(String[] args) {


        String inputLine;



        try {

            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader stdin = new BufferedReader(isr);

            do {

                printMenu();
                inputLine = stdin.readLine().trim();
                if(parseInt(inputLine) > 5 || parseInt(inputLine) < 1) {
                    System.out.println("Please choose a number between 1 and 5.");
                }
                switch (inputLine)
                {
                    case "1":
                        int[] integerarray = parseInts(stdin);

                        System.out.println("The largest number in the array is: " + largestnum(integerarray, 0, integerarray.length-1));
                        break;
                    case "2":
                        int[] integerarray2 = parseInts(stdin);
                        System.out.println("The product of all prime numbers in the array is: " + productprimenums(integerarray2, 0, integerarray2.length-1));
                        break;
                    case "3":
                        int[] integerarray3 = parseInts(stdin);
                        System.out.println("The largest sum of digits in the array is: " +  largestsumdigit(integerarray3, 0, integerarray3.length-1));
                        break;
                    case "4":
                        System.out.println("Please enter String:");
                        inputLine = stdin.readLine().trim();
                        String x = inputLine;
                        System.out.println("String after adjacent duplicate characters were removed: " + duplicateremover(x));
                    case "5":
                        break;
                }

            }while(!(inputLine.equals("5")));
        }catch(IOException e)
        {
        }
    }



    // Utility method for printing the menu
    public static void printMenu() {
        System.out.print("\nWhat would you like to do?\n\n");
        System.out.print("1: Find the largest number in an array of integers\n");
        System.out.print("2: Calculate the product of all prime numbers in an array of integers\n");
        System.out.print("3: Find the element with the largest sum of digits in an array of integers\n");
        System.out.print("4: Remove adjacent duplicate characters in a String\n");
        System.out.print("5: Quit\n\n");
    }

    // utility method for parsing integers from standard input
    public static int[] parseInts(BufferedReader reader) {
        String line = "";
        ArrayList<Integer> container = new ArrayList<>();
        try {
            System.out.print("Please enter integers:\n");
            line = reader.readLine();
            int num = parseInt(line);

            while (num > 0) {
                container.add(num);
                line = reader.readLine();
                num = parseInt(line);
            }

        } catch (IOException ex) {
            System.out.println("IO Exception");
        }

        int[] result = new int[container.size()];
        for(int i = 0; i < container.size(); i++){
            result[i] = container.get(i);
        }


        return result;
    }

    public static int largestnum(int[] array1, int start, int end)
    {
        if(start == end) {
            return array1[start];
        }
        else
        {
            int midIndex = (start + end)/2;
            int leftMax = largestnum(array1, start, midIndex);
            int rightMax = largestnum(array1, midIndex+1, end);
            if(leftMax > rightMax) {
                    return leftMax;
            }
            else
                return rightMax;

        }
        }


    public static boolean ifPrime(int x) {
        if(x != 2) {
            if(x < 1)
            {
                    return false;
            }
            else if(x > 2 && x % 2 == 0) {
                return false;
            }
            else if(x > 3 && x % 3 == 0)
                return false;
        }
        else if(x > 4 && x % 4 ==0) {
            return false;
        }
        else if(x > 5 && x % 5 == 0) {
            return false;
        }
        else if(x > 7 && x % 7 == 0) {
            return false;
        }
        else {
            return true;
        }
        return true;

    }

    public static int productprimenums(int[] array2, int start, int end) {
        int y=1;
            if(start == end) {
                    if(ifPrime(array2[start])) {
                        y*=array2[start];
                    }
                    return y;
            }
            /*else {
                int mid = (start + end)/2;
                int leftPrime = productprimenums(array2, start, mid);
                int rightPrime = productprimenums(array2, mid+1, end);

            }*/
          else {
              if(ifPrime(array2[start]) == true) {
                    y *= array2[start];
                }
            }
          return y*productprimenums(array2, start+1, end);
    }

   public static int largedigithelp(int h) {
        if(h >= 100 && h < 1000) {
           int y = h % 10;
           int x =h/10 % 10;
           int g = h/100;
           return y + x + g;
        }
        else if(h < 100)
        {
            int y = h % 10;
            int x = h / 10 % 10;
            return x + y;
        }
        else if(h <= 10)
        {
            int y = h / 10;
            return y;
        }
        else if ( h > 100 && h < 1000) {
            int y = h % 10;
            int x = y / 10;
            return x + y;
        }
        else if( h > 1000 && h < 10000) {
            int y = h % 10;
            int x = 0;
            return x + y;
        }
        else if(h > 100000) {
            int y = h % 10;
            int x = h/10 % 10;
            int a = h/100 % 10;
            int b = h/1000 % 10;
            int c = h/10000 % 10;
            int d = h/100000 % 10;
            return y + x + a + b + c + d;
        }
        else
            return h;

    }

    public static int largestsumdigit(int[] array3, int start, int end) {
        int y = 0;

        if (start == end) {

            if (y < largedigithelp(array3[start])) {

                return largedigithelp(array3[start]);
            } else {
                return y;
            }
        } else if (y < largedigithelp(array3[start])) {
            y = largedigithelp(array3[start]);

        }
        return Math.max(y, largestsumdigit(array3, start+1, end));

        //return largestsumdigit(array3, start + 1, end);
    }

    public static String duplicateremover(String x)
    {

        if(x.length() == 1)
        {
            return x;
        }
        else if(x.charAt(0) == x.charAt(1)) {
            return duplicateremover(x.substring(1));
        }
        else if(x.charAt(0) != x.charAt(1)) {
            return x.charAt(0) + duplicateremover(x.substring(1));
        }
        else
            return x;
    }

}
