import java.util.ArrayList;
import java.util.List;

public class Cart {

    // Updated variable access modifier
    private int userAge;
    private final List<Product> cart;

    // init age and init empty cart list
    public Cart(int age) {
        userAge = age;
        cart = new ArrayList<>();
    }

    /**
     * Calculates the final cost after all savings and tax has been applied. Also checks
     * that the user is of age to purchase alcohol if it is in their cart at checkout.
     * Sales tax is always AZ tax.
     * <p>Calculation is based off of the following prices and deals:
     * Dairy -> $3
     * Meat -> $10
     * Produce -> $2 or 3 for $5
     * Alcohol -> $8
     * Frozen Food -> $5
     * Alcohol + Frozen Food -> $10
     * <p>If there is an alcohol product in the cart and the user is under 21, then an
     * UnderAgeException should be thrown.
     *
     * @return double totalCost
     * @throws UnderAgeException
     */
    public double calcCost() throws UnderAgeException {
        //implement me, will be important for assignment 4 (nothing to do here for assignment 3)
        return 0;
    }

    /**
     * calculates how much was saved in the current shopping cart based on the deals,
     * returns the saved amount throws exception if alcohol is bought from underage person
     * TODO: Create node graph for this method in assign 4: create white box tests and fix the method,
     * reach at least 98% coverage
     *
     * @return saved amount
     * @throws UnderAgeException if age is under 18
     */
    public int amountSaved() throws UnderAgeException {

        // update method name Amount_saved -> amountSaved
        int subTotal = 0;
        int costAfterSavings = 0;

        double produce_counter = 0;
        int alcoholCounter = 0;
        int frozenFoodCounter = 0;

        // maybe we can remove dairy from this method cause we are not using this anywhere
        int dairyCounter = 0;

        // updated to for enhance loop
        for (Product product : cart) {
            subTotal += product.getCost();
            costAfterSavings = costAfterSavings + product.getCost();

            // string should compare using .equals method not ==
            // similar update for all other if/else if
            if (product.getClass().toString().equals(Produce.class.toString())) {
                produce_counter++;

                if (produce_counter >= 3) {
                    costAfterSavings -= 1;
                    produce_counter = 0;
                }
            } else if (product.getClass().toString().equals(Alcohol.class.toString())) {
                alcoholCounter++;
                if (userAge < 21) {
                    throw new UnderAgeException("The User is not of age to purchase alcohol!");
                }
            } else if (product.getClass().toString().equals(FrozenFood.class.toString())) {
                frozenFoodCounter++;
            }

            // if dairy removed this should be removed too
            else if (product.getClass().toString().equals(Dairy.class.toString())) {
                dairyCounter++;
            }

            if (alcoholCounter >= 1 && frozenFoodCounter >= 1) {
                costAfterSavings += 3;
                alcoholCounter--;
                frozenFoodCounter--;
            }
        }

        return subTotal - costAfterSavings;
    }

    // Gets the tax based on state and the total
    public double getTax(double totalBT, String uSState) {
        double newTotal = 0;
        switch (uSState) {
            case "AZ":
                return totalBT * .08;
            case "CA":
                return totalBT * .09;
            case "NY":
                return totalBT * .1;
            case "CO":
                return totalBT * .07;
            default:
                return totalBT;
        }
    }


    /**
     * Add product in cart list
     *
     * @param product need to add
     */
    public void addItem(Product product) {
        cart.add(product);
    }

    /*
     * Updated method name RemoveItem -> removeItem
     */

    /**
     * The method will remove product from cart
     *
     * @param productToRemove product that need to remove
     * @return ture if removed else false
     */
    public boolean removeItem(Product productToRemove) {
        /*
         * removed : boolean test = false;
         */
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i) == productToRemove) {
                cart.remove(i);

                /*
                remove test return true
                 */
                return true;
            }
        }
        return false;
    }

    /**
     * Calculate total cost of all products
     *
     * @return totalCost, if cart is empty return 0
     */
    public double getCost() {

        // if cart is empty
        if (cart.size() == 0) {
            return 0;
        }

        // calculate total cart amount
        int total = 0;
        for (Product product : cart) {
            total += product.getCost();
        }

        return total;
    }

    // ’SER316 TASK 2 SPOTBUGS FIX
/*    *//*
     * Updated : added required all getter, setter
     *//*
    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public List<Product> getCart() {
        return cart;
    }*/
}
