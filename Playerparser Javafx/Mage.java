
// Assignment #: 5
//         Name: Michael Mayers
//    StudentID: Your id
//      Lecture: MWF 12:20-1:10
//  Description: inheritance to compute different characters

import java.text.DecimalFormat;
public class Mage extends PlayerEntity
{

    
    private double mana;
    public Mage(double health, String name, int stamina, int attack, double mana)
    {
        super(health, name, stamina, attack);
        this.mana = mana;
    }

    public void computeCombatPower()
    {
        double combatPoints3 = ((attack + health) * (1 + mana));
        combatPoints = (int) combatPoints3;
        
    }

    public String toString()
    {
        DecimalFormat f1 = new DecimalFormat("#%");
        return "\nMage Hero:" + super.toString() + "Mana:\t\t\t" + f1.format(mana) + "\n";
    }
}
