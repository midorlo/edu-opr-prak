/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apex
 */
public class Vorgesetzter extends Mitarbeiter {

    private int bestLimit;
    
    public Vorgesetzter(String name) {
        
        super(name);
        super.position = "Vorgesetzter";
        bestLimit = -1;
        
    }
    
    public void setzteBestelllimit(int limit) {
        
        this.bestLimit = limit;
        
    }
    
    @Override
    public String gibInfo() {
        
        StringBuffer infotext = new StringBuffer();
        String vorgesetzter = "";
        
        if (super.vorgesetzter != null) {
            vorgesetzter = ". Mein Vorgesetzter ist " + super.vorgesetzter.name;
        }

        infotext.append("Ich bin Vorgesetzter, Name " + super.name + vorgesetzter + 
                ". Mein Bestelllimit" + " ist " + ((bestLimit == -1) ? super.bestLimit : this.bestLimit) + " EUR.");
        
        return infotext.toString();
    }    
    
    @Override
    public boolean darfBestellen(int limit) {
        
        return limit <= ((bestLimit == -1) ? super.bestLimit : this.bestLimit);
        
    }
    
    @Override
    public String gibHierarchie() {
        
        return ((this.vorgesetzter != null) ? this.vorgesetzter.gibHierarchie() + "\nVorgesetzter " + 
                this.name : "Vorgesetzter " + this.name);
    
    }
    
}
