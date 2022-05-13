// Assignment: Assignment 8
// Name: Michael Mayers
// StudentID: 1221983412
// Lecture: M/W/F 12:20-110
// Description: sorts
import java.util.Comparator;
import java.util.ArrayList;
public class Sorts
{
public static void sort(ArrayList<Restaurant> reviewList, Comparator<Restaurant> xComparator)
{
   int min;
   for(int i = 0; i < reviewList.size()-1; i++)
   {
      min = i;
      
         for(int scan = i + 1; scan < reviewList.size(); scan++)
         {
            if(xComparator.compare(reviewList.get(scan),(reviewList.get(min))) < 0)
            {
             min = scan;
             
            }
         }
         Restaurant temp = reviewList.get(min);
             reviewList.set(min, reviewList.get(i));
             reviewList.set(i, temp);
   }
}
}