

// Assignment #: 5
//         Name: Michael Mayers
//    StudentID: Your id
//      Lecture: MWF 12:20-1:10
//  Description: inheritance to compute different characters
import java.util.*;
import java.lang.*;
public class PlayerParser extends Assignment5
{
    public static PlayerEntity parseNewPlayer(String lineToParse){
        ArrayList<String> google = new ArrayList<String>();
        String[] split = lineToParse.split("/");
        for (String s : split)
        {
            google.add(s);
        }
        boolean xy;
        
        if(google.get(5).toLowerCase().equals("melee"))
        {
         xy = false;
        }
        else
        {
         xy = true;
        }

        
        
        if(google.get(0).equals("Fighter")){
           
            Fighter x2 = new Fighter(Double.parseDouble(google.get(1)), google.get(2), Integer.parseInt(google.get(3)), Integer.parseInt(google.get(4)), xy);
            return x2;
        }
        else
        {
            
            Mage pei = new Mage(Double.parseDouble(google.get(1)), (String) google.get(2), Integer.parseInt(google.get(3)), Integer.parseInt(google.get(4)), Double.parseDouble(google.get(5)));
            return pei;
        } 

    }
}
