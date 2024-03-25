package Week5Homework;

/**
 * A simple vending machine, where users can purchase items using coins.
 */
public class VendingMachine {
    /**
     * Simulates a vending machine that allows users to purchase items by inserting
     * coins. It calculates the change to be returned to the user after a purchase.
     * 
     * Rules:
     * 1. The ItemPrice must be a non-negative value.
     * 2. The CoinsInserted array must contain at least one coin value.
     * 3. The total value of coins inserted must be greater than or equal to the item
     * price.
     * 4. The function should calculate and return the change to be returned to the
     * user after deducting the item price.
     * 
     * @param itemPrice     The price of the item to be purchased.
     * @param coinsInserted An array containing the values of coins (e.g., 0.25 for
     *                      a quarter, 1.0 for a dollar) inserted by the user.
     * @return The change to be returned to the user.
     */
    public static float purchaseItem(float itemPrice, float[] coinsInserted) {
        if (itemPrice < 0) {
            throw new IllegalArgumentException("Item price cannot be negative.");
        }

        if (coinsInserted.length == 0) {
            throw new IllegalArgumentException("No coins inserted.");
        }

        float totalInserted = calculateTotalCoins(coinsInserted);
        if (totalInserted < itemPrice) {
            throw new IllegalArgumentException("Insufficient coins inserted.");
        }

        // Calculate change to be returned
        float change = totalInserted - itemPrice;

        // Return the change
        return change;
    }

    private static float calculateTotalCoins(float[] coins) {
        float total = 0;
        for (float coin : coins) {
            total += coin;
        }
        return total;
    }
}
