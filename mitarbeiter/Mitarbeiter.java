/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apex
 */
public class Mitarbeiter {
    
    public static int bestLimit = 20;
    
    public String name;
    public Vorgesetzter vorgesetzter;
    public String position;

    public Mitarbeiter(String Name) {
        
        this.name = Name;
        position = "Mitarbeiter";
    
    }
    
    public static void setzeAllgemeinesLimit(int limit) {
        
        Mitarbeiter.bestLimit= limit;
    
    }

    public void setzeVorgesetzten(Vorgesetzter chef) {
        
        this.vorgesetzter = chef;
    
    }

    public boolean darfBestellen(int limit) {
        
        return limit <= bestLimit;
        
    }
    
    public String gibInfo() {
        
        StringBuffer infotext = new StringBuffer();
        
        if (vorgesetzter != null) {
            infotext.append("Ich bin Mitarbeiter, Name " + name + ". Mein Vorgesetzter ist " + 
                    vorgesetzter.name + ". Mein Bestelllimit ist " + bestLimit + " EUR.");
        } else if (vorgesetzter != null && name.equals(vorgesetzter.name)) { //TODO
            infotext.append("Ich bin Vorgesetzter, Name " + name + ". Mein Bestelllimit ist " + bestLimit 
                    + " EUR.");
        } else if (vorgesetzter == null) {
            infotext.append("Ich bin freier Mitarbeiter, Name " + name + ". Mein Bestelllimit ist " + 
                    bestLimit + " EUR.");
        }
        
        return infotext.toString();
    }
    
    public String gibHierarchie() {
        
        return ((vorgesetzter != null) ? vorgesetzter.gibHierarchie() + "\nMitarbeiter " + this.name 
                : "freier Mitarbeiter " + this.name);
    
    }
    
}
