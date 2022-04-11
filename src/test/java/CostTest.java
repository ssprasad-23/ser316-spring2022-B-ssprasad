import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CostTest {

    private final Class<Cart> classUnderTest;

    @SuppressWarnings("unchecked")
    public CostTest(Object classUnderTest) {
        this.classUnderTest = (Class<Cart>) classUnderTest;
    }

    // Define all classes to be tested
    @Parameterized.Parameters
    public static Collection<Object[]> cartClassUnderTest() {
        Object[][] classes = {
                {Cart.class},
                {Cart.class},
                {Cart.class},
                {Cart.class},
                {Cart.class},
                {Cart.class}
        };
        return Arrays.asList(classes);
    }

    private Cart createCart(int age) throws Exception {
        Constructor<Cart> constructor = classUnderTest.getConstructor(Integer.TYPE);
        return constructor.newInstance(age);
    }

    // A sample Cart

    Cart cart;
    double cartExpected;


    @org.junit.Before
    public void setUp() throws Exception {

        // all carts should be set up like this

        // cart created with an age 40 shopper
        cart = createCart(40);
        for (int i = 0; i < 2; i++) {
            cart.addItem(new Alcohol());
        }
        for(int i = 0; i < 3; i++) {
            cart.addItem(new Dairy());
        }
        for(int i = 0; i < 4; i++) {
            cart.addItem(new Meat());
        }

        // expected value will for getCost Method
        cartExpected = 65.0;
    }

    @Test
    public void getCost() throws UnderAgeException {
        double amount = cart.getCost();
        assertEquals(cartExpected, amount, .01);
    }
}
