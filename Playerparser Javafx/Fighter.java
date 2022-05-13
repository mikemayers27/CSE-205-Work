import java.text.DecimalFormat;

// Assignment #: 5
//         Name: Michael Mayers
//    StudentID: Your id
//      Lecture: MWF 12:20-1:10
//  Description: inheritance to compute different characters
public class Fighter extends PlayerEntity
{
    private double armor;
    private int maxAttack;
    private boolean isRanged;
    public Fighter(double health, String name, int stamina, int attack, boolean isRanged)
    {
    
        super (health, name, stamina, attack);
        this.isRanged = isRanged;
     if(isRanged == true)
    {
      armor = .25;
      maxAttack = 125;
    }
    else
    {
      armor = .50;
      maxAttack = 100;
    }
    
    }
    
    public void computeCombatPower()
    {
        if(attack > maxAttack)
        {
            double combatPoints1 = (((maxAttack + health) * (1-armor)));
            combatPoints = (int) combatPoints1;

        }
        else
        {
            double combatPoints2 = ((attack + health) * (1-armor));
            combatPoints = (int) combatPoints2;
        }
        
    }
       
    public String toString()
    {
        
        
        DecimalFormat f1 = new DecimalFormat("0%");
        if(!isRanged)
        {
        return "\nFighter Hero:\t\t" + "Melee Type" + super.toString() + "Armor:\t\t" + f1.format(.50) + "\n";
        }
        else 
        {
         return "\nFighter Hero:\t\tRanged Type" + super.toString() + "Armor:\t\t" + f1.format(.25) + "\n";
        }
    }
}