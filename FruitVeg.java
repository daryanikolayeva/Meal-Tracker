//--------------------------------------------------------------------
// Class: FruitVeg
// Author: Nikolayeva Darya
// Remarks: It is a class of type FruitVeg
//SubClass of SingleFood
//------------------------------------------------------------------
public class FruitVeg extends SingleFood {
    private String fruitVegName;

    // --------------------------------------------------------------------------------
    // FruitVeg constructor
    // Remark:such parameters[i] are given because in sample input FruitVeg has
    // input:
    // Newfood(0) Single(1) Type(2) Callories(3) NameFruit(4)
    // Description(5 and till end)
    // ---------------------------------------------------------------------------------
    public FruitVeg(String[] parameters) {
        calories = Integer.parseInt(parameters[3]);
        fruitVegName = parameters[4];
        description = "";
        for (int i = 5; i < parameters.length; i++) {
            if (i > 5) {
                this.description += " ";
            }
            this.description += parameters[i];
        }
    }

    // --------------------------------------------------------------------------------
    // getName, getFat, getSugar,getProtein, getType
    // Purpose: getters of instance variables of class FruitVeg
    // Remark: getSugar, getProtein, getFat all return 0, since FruitVeg doesn't
    // have those values, but for
    // better use of polymorphism it just returns 0
    // ---------------------------------------------------------------------------------
    public String getName() {
        return fruitVegName;
    }

    public float getSugar() {
        return 0;
    }

    public float getProtein() {
        return 0;
    }

    public float getFat() {
        return 0;
    }

    public void print() {
        System.out.println(getType() + " " + getDescription() + " " + getName());
    }

    public String getType() {
        return "FRUITVEG";
    }
}
