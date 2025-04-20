//--------------------------------------------------------------------
// Class: FoodLibrary
// Author: Nikolayeva Darya
// Remarks: It is a library for storing foodItems. 
//SubClass of GenericLibrary
//------------------------------------------------------------------
public class FoodLibrary extends GenericLibrary {

    public NewFood getFood(String description) {
        return (NewFood) super.get(description);
    }

    // ------------------------------------------------------
    // add
    // PURPOSE: adds ListItem(which later casted to NewFood, since it is
    // FoodLibrary) to FoodLibrary
    // If item exists already, updates it
    // Overrides add method of its superclass since it needs to update exsiting food
    // ------------------------------------------------------
    public void add(ListItem food) {
        NewFood newFoodParam = (NewFood) food;
        if (isFound(newFoodParam.getDescription())) {
            Node current = top;
            while (current != null) {
                if (current.item.getDescription().equals(newFoodParam.getDescription())) {
                    current.item = newFoodParam;
                    System.out.println("Food updated");
                    return;
                }
                current = current.link;
            }
        }

        Node newNode = new Node(food, null);
        newNode.link = top;
        top = newNode;
    }

    // ------------------------------------------------------
    // printServings
    // PURPOSE:prints servings, count of every food type consumed
    // based on its dynamic type
    // ------------------------------------------------------
    public void printServings() {
        int fruitvegCount = 0;
        int dairyCount = 0;
        int meatCount = 0;
        int grainCount = 0;
        int otherCount = 0;
        Node current = getTop();
        while (current != null) {
            String type = ((NewFood) current.item).getType();
            if (type.equals("FRUITVEG")) {
                fruitvegCount++;
            } else if (type.equals("DAIRY")) {
                dairyCount++;
            } else if (type.equals("MEAT")) {
                meatCount++;
            } else if (type.equals("GRAIN")) {
                grainCount++;
            } else if (type.equals("OTHER")) {
                otherCount++;
            } else if (type.equals("COMPOSITE")) {
                CompositeFood composite = (CompositeFood) current.item;
                FoodLibrary library = composite.getSingleFoodsLibrary();
                int[] currValues = new int[] { fruitvegCount, dairyCount, meatCount, grainCount, otherCount };
                currValues = library.combineFoods(library, currValues);
                fruitvegCount = currValues[0];
                dairyCount = currValues[1];
                meatCount = currValues[2];
                grainCount = currValues[3];
                otherCount = currValues[4];
            }
            current = current.link;
        }
        System.out.println("Fruit and Vegetable: " + fruitvegCount);
        System.out.println("Dairy: " + dairyCount);
        System.out.println("Meat: " + meatCount);
        System.out.println("Grain: " + grainCount);
        System.out.println("Other: " + otherCount);
        System.out.println();
    }

    // ------------------------------------------------------
    // combineFoods
    // PURPOSE:helper method to combine total counts of food type of single food
    // items in the list and composite
    // REturn parameter: int[], to store those values
    // ------------------------------------------------------
    public int[] combineFoods(FoodLibrary library, int[] currValues) {
        Node current = getTop();
        while (current != null) {
            String type = ((NewFood) current.item).getType();
            if (type.equals("FRUITVEG")) {
                currValues[0]++;
            } else if (type.equals("DAIRY")) {
                currValues[1]++;
            } else if (type.equals("MEAT")) {
                currValues[2]++;
            } else if (type.equals("GRAIN")) {
                currValues[3]++;
            } else if (type.equals("OTHER")) {
                currValues[4]++;
            }
            current = current.link;
        }
        return currValues;
    }

    // ------------------------------------------------------
    // printMeals
    // PURPOSE:prints totals of nutrients of foodlibrary
    // ------------------------------------------------------
    public void printMeals() {
        Node current = getTop();
        float totalCalories = 0;
        float totalProtein = 0;
        float totalFat = 0;
        float totalSugar = 0;
        while (current != null) {
            NewFood food = (NewFood) current.item;
            totalCalories += food.getCalories();
            totalProtein += food.getProtein();
            totalFat += food.getFat();
            totalSugar += food.getSugar();
            food.print();
            current = current.link;
        }
        System.out.println("Totals:");
        System.out.println(totalCalories + " calories");
        System.out.println(totalProtein + " protein");
        System.out.println(totalFat + " fat");
        System.out.println(totalSugar + " sugar");
        System.out.println();
    }

    // ------------------------------------------------------
    // getNutrientsTotals
    // PURPOSE:helper method to get total Nutrients of foodLibrary
    // Return-float[]- array consisting of nutrients values
    // ------------------------------------------------------
    public float[] getNutrientTotals() {
        float totalProtein = 0;
        float totalFat = 0;
        float totalSugar = 0;
        float totalCalories = 0;
        Node current = getTop();
        while (current != null) {
            NewFood food = (NewFood) current.item;
            totalProtein += food.getProtein();
            totalFat += food.getFat();
            totalSugar += food.getSugar();
            totalCalories += food.getCalories();
            current = current.link;
        }
        return new float[] { totalProtein, totalFat, totalSugar, totalCalories };
    }
}
