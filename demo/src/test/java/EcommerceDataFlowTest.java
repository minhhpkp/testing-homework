import static org.junit.Assert.assertEquals;

import org.junit.Test;

import testing.homework.Ecommerce;
import testing.homework.Ecommerce.CartItem;

public class EcommerceDataFlowTest {
    @Test
    public void testcase1() {
        assertEquals(446.25,
                Ecommerce.calculateTotalPrice(new CartItem[] { new CartItem("trousers", 5, 100.0) }, 0.05, true),
                0.001);
    }

    @Test
    public void testcase2() {
        assertEquals(1391.51, Ecommerce.calculateTotalPrice(
                new CartItem[] { new CartItem("refrigerator", 1, 1395.0) }, 0.05, false), 0.001);
    }

    @Test
    public void testcase3() {
        assertEquals(57.65,
                Ecommerce.calculateTotalPrice(new CartItem[] { new CartItem("shirt", 2, 30.5) }, 0.05, true), 0.001);
    }

    @Test
    public void testcase4() {
        assertEquals(54.86,
                Ecommerce.calculateTotalPrice(new CartItem[] { new CartItem("socks", 10, 5.5) }, 0.05, false),
                0.001);
    }

    @Test
    public void testcase5() {
        assertEquals(10.5,
                Ecommerce.calculateTotalPrice(new CartItem[] { new CartItem("biscuit box", 1, 10.0) }, 0.05, false),
                0.001);
    }
}
