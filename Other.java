//--------------------------------------------------------------------
// Class: Other
// Author: Nikolayeva Darya
// Remarks: It is a class of type Other
//SubClass of SingleFood
//------------------------------------------------------------------
public class Other extends SingleFood {
    private float gramsProtein;
    private float gramsFat;
    private float gramsSugar;

    // --------------------------------------------------------------------------------
    // Other constructor
    // Remark:such parameters[i] are given because in sample input FruitVeg has
    // input:
    // New(0) Single(1) Type(2) Cal(3) Protein(4) Fat(5) Sugar(6)
    // Description(7 and till end)
    // ---------------------------------------------------------------------------------
    public Other(String[] parameters) {
        calories = Integer.parseInt(parameters[3]);
        gramsProtein = Float.parseFloat(parameters[4]);
        gramsFat = Float.parseFloat(parameters[5]);
        gramsSugar = Float.parseFloat(parameters[6]);
        description = "";
        for (int i = 7; i < parameters.length; i++) {
            if (i > 7) {
                this.description += " ";
            }
            this.description += parameters[i];
        }
    }

    // --------------------------------------------------------------------------------
    // getProtein, getFat, getSugar, getType
    // Purpose: getters of instance variables of class Other
    // ---------------------------------------------------------------------------------
    public float getProtein() {
        return gramsProtein;
    }

    public float getFat() {
        return gramsFat;
    }

    public float getSugar() {
        return gramsSugar;
    }

    public void print() {
        System.out.println(
                getType() + " " + getDescription() + " " + getProtein() + " " + getFat() + " " + getSugar());
    }

    public String getType() {
        return "OTHER";
    }

}