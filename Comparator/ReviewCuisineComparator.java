import java.util.Comparator;
// Assignment: Assignment 8
// Name: Michael Mayers
// StudentID: 1221983412
// Lecture: M/W/F 12:20-110
// Description: reviewcuisinecomparator
public class ReviewCuisineComparator implements Comparator<Restaurant>
{
   public int compare(Restaurant restaurant3, Restaurant restaurant4)
   {
      int a = restaurant3.getPriceRange() - restaurant4.getPriceRange();
      if(!(restaurant3.getCuisine().getName().equals(restaurant4.getCuisine().getName())))
      {
      return restaurant3.getCuisine().getName().compareTo(restaurant4.getCuisine().getName());
      }
      else if(a != 0)
      {
      return a;
      }
      else if(!(restaurant3.getRestaurantName().equals(restaurant4.getRestaurantName())))
   {
      return restaurant3.getRestaurantName().compareTo(restaurant4.getRestaurantName());
   }
   else if(!(restaurant3.getLocation().equals(restaurant4.getLocation())))
   {
      return restaurant3.getLocation().compareTo(restaurant4.getLocation());
   }
   else 
      
      return restaurant3.getReview().compareTo(restaurant4.getReview());
   
   }
   }
   
   
