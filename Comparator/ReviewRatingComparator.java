// Assignment: Assignment 8
// Name: Michael Mayers
// StudentID: 1221983412
// Lecture: M/W/F 12:20-110
// Description: reviewrating comparator
import java.util.Comparator;
public class ReviewRatingComparator implements Comparator<Restaurant>
{
   public int compare(Restaurant restaurant1, Restaurant restaurant2)
   {
   int a = 0;
   if(restaurant1.getStars() != restaurant2.getStars())
   {
   a = restaurant1.getStars() - restaurant2.getStars();
   }
   else if(!(restaurant1.getRestaurantName().equals(restaurant2.getRestaurantName())))
   {
      a = restaurant1.getRestaurantName().compareTo(restaurant2.getRestaurantName());
   }
   else if(!(restaurant1.getLocation().equals(restaurant2.getLocation())))
   {
      a = a = restaurant1.getLocation().compareTo(restaurant2.getLocation());
   }
   else
   a = restaurant1.getReview().compareTo(restaurant2.getReview());
   
   
   return a;
   }
   
 }
 
   
   