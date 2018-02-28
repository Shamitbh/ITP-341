// Shamit Bhatia
// Shamitbh@usc.edu
// ITP 341
// Fall 2017

/* EDIT THIS FILE */

package itp341.javareview.superhero;

public class HeroBattle {

    public String play() {
        String displayBattleInfo = "";
        Superhero s1 = new Superhero("Superman");
        Superhero s2 = new Superhero("Batman");
        // Initial stats for heroes:
        displayBattleInfo += ("HEROES\n" + s1.getHeroStats() + "\n" + s2.getHeroStats() + "\n\nFIGHT!\n");


        int roundNum = 1;
        while (!s1.isInjured() && !s2.isInjured()) {
            // Decrease s1 health points by s2 attack value
            s1.setHealthPoints(s1.getHealthPoints() - s2.getAttackValue());
            // Decrease s2 health points by s1 attack value
            s2.setHealthPoints(s2.getHealthPoints() - s1.getAttackValue());

            // Generate fight number and hero's status
            displayBattleInfo += ("====== Round "+roundNum + " ======\n");
            displayBattleInfo += (s1.getHeroStats() + "\n");
            displayBattleInfo += (s2.getHeroStats() + "\n\n");

            // Increment round number
            roundNum++;
        }

        if (s1.isInjured() && s2.isInjured()) {
            // Fight ended in a tie
            displayBattleInfo += "It's a tie!\n";
        }
        else if (s1.isInjured() && !s2.isInjured()) {
            // Fight ended with s2 winning
            displayBattleInfo += (s2.getName() + " won!\n");
        }
        else{
            // Fight ended with s1 winning
            displayBattleInfo += (s1.getName() + " won!\n");
        }
        return displayBattleInfo;
    }

}
