
//-----------------------------------------------
//Author        : Nikolayeva Darya
//Remarks       : This program is a meal tracker
//------------------------------------------------
import java.util.Scanner;
import java.io.*;

public class MealTracker {
    private static GenericLibrary userLibrary = new UserLibrary();
    private static GenericLibrary foodLibrary = new FoodLibrary();
    private static Scanner scanner;

    // ------------------------------------------------------
    // main
    // PURPOSE:reads command from text file and send them to process method
    // PARAMETERS:String[] args: reads from input line
    // ------------------------------------------------------
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Can't proceed with no input. Provide file name");
            return;
        }
        try {
            File fileName = new File(args[0]);
            scanner = new Scanner(fileName);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                process(line);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("File does not exist");
        } finally {
            scanner.close();
        }
    }

    // ------------------------------------------------------
    // process
    // PURPOSE:checks input(line), sends input to apporpriate function to process
    // the command
    // PARAMETERS:String line ( input from text file to process)
    // ------------------------------------------------------
    public static void process(String line) {
        String[] parameters = line.split(" ");
        if (parameters[0].equals("#")) {
            for (int i = 0; i < parameters.length; i++) {
                System.out.print(parameters[i] + " ");
            }
            System.out.println();
        }
        if (parameters[0].equals("NEWFOOD") && parameters[1].equals("SINGLE")) {
            processSingleNew(parameters);
            System.out.println("=============================================");
        }

        if (parameters[0].equals("NEWFOOD") && parameters[1].equals("COMPOSITE")) {
            processComposite(parameters);
            System.out.println("=============================================");

        }
        if (parameters[0].equals("NEWPROFILE")) {
            newProfile(parameters);
            System.out.println("=============================================");
        }
        if (parameters[0].equals("EAT")) {
            eat(parameters);
            System.out.println("=============================================");
        }
        if (parameters[0].equals("PRINTCALORIES")) {
            printCal(parameters);
            System.out.println("=============================================");
        }
        if (parameters[0].equals("PRINTSERVINGS")) {
            printServings(parameters);
            System.out.println("=============================================");
        }
        if (parameters[0].equals("PRINTMEALS")) {
            printMeals(parameters);
            System.out.println("=============================================");
        }
        if (parameters[0].equals("QUIT")) {
            System.out.println("Done");
            System.exit(0);
        }
    }

    // ------------------------------------------------------
    // processSingleNew
    // PURPOSE: processes command that creating NEWFOOD SINGLE depending on its
    // type, and adds it to FoodLibrary
    // PARAMETERS:String[] parameters:array of strings, where every string is a
    // parameter for creating new single food item
    // Remark:values in parameters[] and parameters.length requirments come from
    // assignment description, showing exact line format for different commands
    // ------------------------------------------------------
    public static void processSingleNew(String[] parameters) {
        if (parameters[2].equals("MEAT") && parameters.length >= 8) {
            ListItem foodItem = new Meat(parameters);
            foodLibrary.add(foodItem);
        } else if (parameters[2].equals("DAIRY") && parameters.length >= 8) {
            NewFood foodItem = new Dairy(parameters);
            foodLibrary.add(foodItem);
        } else if (parameters[2].equals("GRAIN") && parameters.length >= 8) {
            NewFood foodItem = new Grain(parameters);
            foodLibrary.add(foodItem);
        } else if (parameters[2].equals("OTHER") && parameters.length >= 8) {
            NewFood foodItem = new Other(parameters);
            foodLibrary.add(foodItem);
        } else if (parameters[2].equals("FRUITVEG") && parameters.length >= 6) {
            NewFood foodItem = new FruitVeg(parameters);
            foodLibrary.add(foodItem);
        }
        System.out.println("Food added");
    }

    // ------------------------------------------------------
    // processComposite
    // PURPOSE:adds compositeFood to Foodlibrary. Only if its individual ingridients
    // are already in foodLibrary
    // PARAMETERS:String[]parameters ( input from text file to process)
    // ------------------------------------------------------
    public static void processComposite(String[] parameters) {
        int ingredientCount = Integer.parseInt(parameters[2]);
        NewFood compositeFood = new CompositeFood(parameters);
        CompositeFood compositeFoodObj = new CompositeFood(parameters);
        for (int i = 0; i < ingredientCount; i++) {
            String line = scanner.nextLine();
            if (!foodLibrary.isFound(line)) {
                System.out.println("Can't add food, ingredient doesn't exist in library");
                return;
            }
            FoodLibrary library = (FoodLibrary) foodLibrary;
            compositeFoodObj.add(library.getFood(line));
        }

        foodLibrary.add(compositeFoodObj);
        System.out.println("Composite food added: " + compositeFood.getDescription());
    }

    // ------------------------------------------------------
    // newProfile
    // PURPOSE:creates new Profile taking username from input
    // Checks if this user already exist in UserLibrary. Doesnt add duplicates
    // PARAMETERS:String[]parameters( input from text file to process)
    // ------------------------------------------------------
    public static void newProfile(String[] parameters) {
        String username = parameters[1];
        if (username.length() < 5 || username.length() > 12 || username.contains(" ")) {
            System.out.println("Invalid username. It must be between 5 and 12 characters(no spaces)");
            return;
        }

        if (userLibrary.isFound(username)) {
            System.out.println("DUPLICATE USER");
        } else {
            User newUser = new User(username);
            userLibrary.add(newUser);
            System.out.println("NEW USER ADDED");
        }
    }

    // ------------------------------------------------------
    // eat
    // PURPOSE:adds food to specific user
    // Adds only if user exist and food in library exist
    // PARAMETERS:String[]parameters( input from text file to process)
    // ------------------------------------------------------
    public static void eat(String[] parameters) {
        String userName = parameters[1];
        String description = "";
        for (int i = 2; i < parameters.length; i++) {
            if (i > 2) {
                description += " ";
            }
            description += parameters[i];
        }
        if (!userLibrary.isFound(userName)) {
            System.out.println("USER NOT FOUND");
            return;
        }
        if (!foodLibrary.isFound(description)) {
            System.out.println("FOOD NOT FOUND");
            return;
        }
        UserLibrary name = (UserLibrary) userLibrary;
        User user = name.getUser(userName);
        FoodLibrary anotherFood = (FoodLibrary) foodLibrary;
        NewFood food = anotherFood.getFood(description);
        user.addFoodItem(food);
        System.out.println("Meal added");
    }

    // ------------------------------------------------------
    // printCal
    // PURPOSE:prints total callories for given user
    // If user doesnt exist in library, gives "User not found message"
    // PARAMETERS:String[]parameters ( input from text file to process)
    // ------------------------------------------------------
    public static void printCal(String[] parameters) {
        String userName = parameters[1];
        if (!userLibrary.isFound(userName)) {
            System.out.println("USER NOT FOUND");
        } else {
            UserLibrary name = (UserLibrary) userLibrary;
            User user = name.getUser(userName);
            System.out.println("Total calories " + user.getCalories());
        }
    }

    // ------------------------------------------------------
    // printServings
    // PURPOSE:prints the number of servings of each type of food the user has
    // consumed
    // Only for exsiting user in userLibrary
    // PARAMETERS:String[]parameters ( input from text file to process)
    // ------------------------------------------------------
    public static void printServings(String[] parameters) {
        String userName = parameters[1];
        if (!userLibrary.isFound(userName)) {
            System.out.println("USER NOT FOUND");
        } else {
            UserLibrary name = (UserLibrary) userLibrary;
            User user = name.getUser(userName);
            user.printServings();
        }
    }

    // ------------------------------------------------------
    // printMeals
    // PURPOSE: prints a list of everything the user has consumed
    // Only for exsiting user in userLibrary
    // PARAMETERS:String[]parameters ( input from text file to process)
    // ------------------------------------------------------
    public static void printMeals(String[] parameters) {
        String userName = parameters[1];
        if (!userLibrary.isFound(userName)) {
            System.out.println("USER NOT FOUND");
        } else {
            UserLibrary name = (UserLibrary) userLibrary;
            User user = name.getUser(userName);
            user.printMeals();
        }
    }

}
