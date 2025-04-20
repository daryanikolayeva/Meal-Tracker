//--------------------------------------------------------------------
// Class: CompositeFood
// Author: Nikolayeva Darya
// Remarks: It is a type of food. Composite Food 
//SubClass of NewFood. Stores FoodLibrary of singleFoods it contains
//------------------------------------------------------------------
public class CompositeFood extends NewFood {
    private FoodLibrary singleFoodsLibrary;

    // --------------------------------------------------------------------------------
    // CompositeFood constructor
    // Creates from String[]parameters
    // Where description start at index 3 and till the end
    // ---------------------------------------------------------------------------------
    public CompositeFood(String[] parameters) {
        super();
        singleFoodsLibrary = new FoodLibrary();
        description = "";
        for (int i = 3; i < parameters.length; i++) {
            if (i > 3) {
                this.description += " ";
            }
            this.description += parameters[i];
        }
    }

    public String getType() {
        return "COMPOSITE";
    }

    public void print() {
        System.out.println("Composite Food: " + description);
    }

    public void add(NewFood food) {
        singleFoodsLibrary.add(food);
    }

    public FoodLibrary getSingleFoodsLibrary() {
        return singleFoodsLibrary;
    }

    // --------------------------------------------------------------------------------
    // getProtein, getFat, getSugar, getCalories
    // Remark:all their values comes from running method getNutrientTotals(), which
    // returs total values of nutrients from FoodLibrary. So here it is called on
    // singleFoodsLibrary, which is instance variable of every CompositeFood class,
    // and stores its individual food items(ingridients)
    // -------------------------------------------------------------------------------
    public float getProtein() {
        float[] totals = singleFoodsLibrary.getNutrientTotals();
        return totals[0];
    }

    public float getFat() {
        float[] totals = singleFoodsLibrary.getNutrientTotals();
        return totals[1];
    }

    public float getSugar() {
        float[] totals = singleFoodsLibrary.getNutrientTotals();
        return totals[2];
    }

    public int getCalories() {
        float[] totals = singleFoodsLibrary.getNutrientTotals();
        return (int) totals[3];
    }

}
