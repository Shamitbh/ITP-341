// Shamit Bhatia
// Shamitbh@usc.edu
// ITP 341
// Fall 2017

/* EDIT THIS FILE */

package itp341.javareview.superhero;

public class Superhero {
    // Constants
    public static final int MAX_HEALTHPOINTS = 100;
    public static final int MAX_ATTACKVALUE = 20;
    public static final int MIN_HEALTHPOINTS = 0;
    public static final int MIN_ATTACKVALUE = 5;

    // Instance variables
    private String name;
    private int healthPoints;
    private int attackValue;

    // Constructor
    public Superhero(String superhero_name) {
        name = superhero_name;
        healthPoints = MAX_HEALTHPOINTS;
        // Random number from min_attack to max_attack
        int randNum = (int)((Math.random() * (MAX_ATTACKVALUE - MIN_ATTACKVALUE)) + MIN_ATTACKVALUE);
        attackValue = randNum;
    }

    // Mutators
    public void setName(String name) { this.name = name; }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void setAttackValue(int attackValue) {
        this.attackValue = attackValue;
    }

    // Accessors
    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getAttackValue() {
        return attackValue;
    }

    public String getHeroStats() {
        String printHero = ("Name: " + name + "\nHealth Points: " + healthPoints + "\nAttack Value: " + attackValue);
        return printHero;
    }

    public boolean isInjured() {
        if (healthPoints <= MIN_HEALTHPOINTS){
            return true;
        }
        else{
            return false;
        }
    }

    public void loseHealthPoints(int numPointsToSub) {
        // Subtract numPointsToSub from hero's healthPoints
        healthPoints -= numPointsToSub;
    }
}



