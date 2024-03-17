class Ecommerce {
    public static double calculateTotalPrice(CartItem[] cart, double taxRate, double discount) {
        double totalPrice = 0;
        for (CartItem item : cart) {
            totalPrice += item.unitPrice * item.quantity;
        }
        totalPrice *= (100.0 - taxRate) / 100.0;
        totalPrice -= discount;
        return totalPrice;
    }

    public static void main(String[] args) {
        CartItem[] cart = {
            new CartItem("item 1", 5, 20.0),
            new CartItem("item 2", 10, 30.0)
        };
        double taxRate = 5.0;
        double discount = 5.0;
        System.out.println(calculateTotalPrice(cart, taxRate, discount)); // 375.0
    }
}