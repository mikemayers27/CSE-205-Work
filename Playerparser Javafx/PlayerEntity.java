
// Assignment #: 5
//         Name: Michael Mayers
//    StudentID: Your id
//      Lecture: MWF 12:20-1:10
//  Description: inheritance to compute different characters
public abstract class PlayerEntity
{
    protected double health;
    protected String entityName;
    protected int stamina;
    protected int attack;
    protected int combatPoints;

    public PlayerEntity(double health1, String name1, int stamina1, int attack1)
    {

        health = health1;
        entityName = name1;
        stamina = stamina1;
        attack = attack1;
    }


    public int getCombatPoints()
    {
         
        return combatPoints;
    }

    public abstract void computeCombatPower();


    public String toString()
    {
        return "\nHero name:\t\t" + entityName + "\nCurrent Health:\t\t" + health + "\nStamina:\t\t" + stamina + "\nAttack Damage:\t\t" + attack + "\nCurrent Combat Points:\t" + combatPoints + "\n";
    }

   /*public double computeCombatPower()
   {
      return combat;
   }*/


}