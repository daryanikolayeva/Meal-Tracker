//--------------------------------------------------------------------
// Class: Grain
// Author: Nikolayeva Darya
// Remarks: It is a class of type Grain
//SubClass of SingleFood
//------------------------------------------------------------------
public class Grain extends SingleFood {
    private float gramsProtein;
    private float gramsFat;
    private String plantName;

    // --------------------------------------------------------------------------------
    // Grain constructor
    // Remark:such parameters[i] are given because in sample input FruitVeg has
    // input is Newfood(0) Single(1) Type(2) Calories(3) Protein (4)
    // Fat(5) Plant Name(6) Description(7 and till end)
    // ---------------------------------------------------------------------------------
    public Grain(String[] parameters) {
        calories = Integer.parseInt(parameters[3]);
        gramsProtein = Float.parseFloat(parameters[4]);
        gramsFat = Float.parseFloat(parameters[5]);
        plantName = parameters[6];
        description = "";
        for (int i = 7; i < parameters.length; i++) {
            if (i > 7) {
                this.description += " ";
            }
            this.description += parameters[i];
        }
    }

    // --------------------------------------------------------------------------------
    // getProtein, getFat, getSugar, getAnimalName
    // Purpose: getters of instance variables of class Grain
    // Remark: getSugar returns 0, since only class Other contains sugar, but for
    // better use of polymorphism every other subclasses of NewFood has it as well,
    // just returns 0
    // ---------------------------------------------------------------------------------

    public float getProtein() {
        return gramsProtein;
    }

    public float getFat() {
        return gramsFat;
    }

    public float getSugar() {
        return 0;
    }

    public String getPlantName() {
        return plantName;
    }

    public void print() {
        System.out.println(
                getType() + " " + getDescription() + " " + getProtein() + " " + getFat() + " " + getPlantName());
    }

    public String getType() {
        return "GRAIN";
    }

}