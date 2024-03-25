package Week5Homework;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class VendingMachineTest {
    @Test
    public void testcase1() {
        assertThrows(IllegalArgumentException.class,
                () -> VendingMachine.purchaseItem(-10.25f, new float[] { 1.0f, 2.0f }));
    }

    @Test
    public void testcase2() {
        assertThrows(IllegalArgumentException.class, () -> VendingMachine.purchaseItem(5.75f, new float[] {}));
    }

    @Test
    public void testcase3() {
        assertThrows(IllegalArgumentException.class,
                () -> VendingMachine.purchaseItem(50.5f, new float[] { 1.f, 2.f, 5.f, 0.25f }));
    }

    @Test
    public void testcase4() {
        assertEquals(0.05f, VendingMachine.purchaseItem(2.25f, new float[] {.25f, .25f, .25f, .25f, .25f, .25f, .25f, .25f, .1f, .1f, .1f}), 0.001);
    }
}
