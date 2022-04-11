import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WhiteBoxGiven {

    Cart cart;

    @Before
    public void setUp() throws Exception {
        cart = new Cart(45);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getTaxTest() {
        // state AZ
        assertEquals(4.0, cart.getTax(50, "AZ"), .01);
        // state CA
        assertEquals(4.5, cart.getTax(50, "CA"), .01);
        // state NY
        assertEquals(5, cart.getTax(50, "NY"), .01);
        // state CO
        assertEquals(3.5, cart.getTax(50, "CO"), .01);
        // state default
        assertEquals(50, cart.getTax(50, ""), .01);
    }

    @Test
    public void addItemTest() {
        cart = new Cart(45);
        cart.addItem(new Meat()); // after add product cost = 10
        assertEquals(10.0, cart.getCost(), .01);
        cart.addItem(new Dairy()); // after add product total cost = 13
        assertEquals(13.0, cart.getCost(), .01);
    }

    @Test
    public void removeItemTest() {
        cart = new Cart(45);
        Meat meat = new Meat();
        cart.addItem(meat); // after add product cost = 10

        // remove test
        assertEquals(10.0, cart.getCost(), .01);
        assertTrue(cart.removeItem(meat));

        // after add product total cost = 0
        assertEquals(0, cart.getCost(), .01);
    }

    @Test
    public void calcCostTest() {
        // will implemented in Assignment 4
    }

    @Test
    public void amountSavedTest() throws UnderAgeException {
        cart = new Cart(45);
        cart.addItem(new Alcohol()); // cost = 8
        cart.addItem(new FrozenFood()); // cost = 5
        cart.addItem(new Dairy()); // cost = 3
        cart.addItem(new Meat()); // cost = 10
        cart.addItem(new main.java.Produce()); // cost = 2
        cart.addItem(new Produce()); // cost = 2
        cart.addItem(new Produce()); // cost = 2

        int amountSaved = cart.amountSaved();
        assertEquals(-2, amountSaved);
    }

    @Test(expected = UnderAgeException.class)
    public void underAgeExceptionTest() throws UnderAgeException {
        cart = new Cart(15);
        cart.addItem(new Alcohol());
        cart.amountSaved(); // throw exception
    }

    @Test()
    public void getCostTest() throws UnderAgeException {
        Cart cart = new Cart(40);
        double cartExpected = 65.0;

        for (int i = 0; i < 2; i++) {
            cart.addItem(new Alcohol());
        }
        for(int i = 0; i < 3; i++) {
            cart.addItem(new Dairy());
        }
        for(int i = 0; i < 4; i++) {
            cart.addItem(new Meat());
        }

        double amount = cart.getCost();
        assertEquals(cartExpected, amount, .01);
    }
}