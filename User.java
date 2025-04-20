//--------------------------------------------------------------------
// Class: User
// Author: Nikolayeva Darya
// Remarks: It is a class oof type User. 
//Made to create users, update their information, print their information
//------------------------------------------------------------------
public class User extends ListItem {
    private String userName;
    private float calories;
    private FoodLibrary meals;

    // --------------------------------------------------------------------------------
    // User()
    // Purpose: defualt constructor
    // ---------------------------------------------------------------------------------
    public User() {
        userName = " ";
        calories = 0;
        meals = new FoodLibrary();
    }

    // --------------------------------------------------------------------------------
    // User()
    // Purpose: constructor
    // Input parameters: String userName
    // Creates user with given username, 0 calories, and creates FoodLibrary to
    // store user's meal history
    // ---------------------------------------------------------------------------------
    public User(String userName) {
        this.userName = userName;
        calories = 0;
        meals = new FoodLibrary();
    }

    // --------------------------------------------------------------------------------
    // getDescription, getUserName, getCalories, getMeals
    // Purpose: getters of instances variables of class User
    // ---------------------------------------------------------------------------------
    public String getDescription() {
        return userName;
    }

    public String getUsername() {
        return userName;
    }

    public float getCalories() {
        return calories;
    }

    public FoodLibrary getMeals() {
        return meals;
    }

    // --------------------------------------------------------------------------------
    // addFoodItem
    // Purpose: adds food item to user's foodlibrary
    // Input:NewFood food( food that we need to add)
    // ---------------------------------------------------------------------------------
    public void addFoodItem(NewFood food) {
        meals.add(food);
        calories += food.getCalories();
    }

    // --------------------------------------------------------------------------------
    // printMeals
    // Purpose: prints meal history of user(Full histpry of meals with total
    // nutrients count)
    // ---------------------------------------------------------------------------------
    public void printMeals() {
        System.out.println("Meal history of user: " + userName);
        meals.printMeals();
    }

    // --------------------------------------------------------------------------------
    // printServings
    // Purpose: prints serving history of user( types of foods and their count)
    // ---------------------------------------------------------------------------------
    public void printServings() {
        System.out.println("Serving history for :" + userName);
        meals.printServings();
    }

}
