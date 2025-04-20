//--------------------------------------------------------------------
// Class: NewFood
// Author: Nikolayeva Darya
// Remarks: Abstract Class representing food
//SubClass of ListItem and superclass of whole food hierarchy
//------------------------------------------------------------------
public abstract class NewFood extends ListItem {
    protected String description;
    protected int calories;

    // --------------------------------------------------------------------------------
    // NewFood()
    // Purpose: defualt constructor
    // ---------------------------------------------------------------------------------
    public NewFood() {
        this.description = "";
        this.calories = 0;
    }

    // --------------------------------------------------------------------------------
    // NewFood()
    // Purpose: constructor
    // Input parameters: String description, int calories
    // ---------------------------------------------------------------------------------
    public NewFood(String description, int calories) {
        this.description = description;
        this.calories = calories;
    }

    // --------------------------------------------------------------------------------
    // getProtein, getFat, getSugar, getType, print
    // Purpose: all are abstract methods, made abstract so that subclasses would
    // have to use them
    // Remark: Does not have implementation here, but because of polymorphism needed
    // version of those methods will be called based on its dynamic type at a
    // runtime
    // ---------------------------------------------------------------------------------
    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    public abstract float getProtein();

    public abstract float getFat();

    public abstract float getSugar();

    public abstract String getType();

    public abstract void print();

}
