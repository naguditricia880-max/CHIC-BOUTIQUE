public class Boutique {
    public static void main(String[] args) {
        String[] items = { "Shirt", "Trousers", "Shoes", "Dress" };
        double[] prices = { 25000.00, 40000.00, 60000.00, 55000.00 };

        System.out.println("+----------------------+----------------+");
        System.out.println("| Item                 | Price (UGX)    |");
        System.out.println("+----------------------+----------------+");
        for (int index = 0; index < items.length; index++) {
            System.out.printf("| %-20s | %,14.2f |%n", items[index], prices[index]);
        }
        System.out.println("+----------------------+----------------+");

        int shirtQuantity = 4;
        int trousersQuantity = 2;
        int shoesQuantity = 2;
        int dressQuantity = 3;

        double shirtSubtotal = calculateSubtotal(prices[0], shirtQuantity);
        double trousersSubtotal = calculateSubtotal(prices[1], trousersQuantity);
        double shoesSubtotal = calculateSubtotal(prices[2], shoesQuantity);
        double dressSubtotal = calculateSubtotal(prices[3], dressQuantity);

        double total = shirtSubtotal + trousersSubtotal + shoesSubtotal + dressSubtotal;

        System.out.println("=== Receipt ===");
        printReceipt(items[0], prices[0], shirtQuantity, shirtSubtotal);
        printReceipt(items[1], prices[1], trousersQuantity, trousersSubtotal);
        printReceipt(items[2], prices[2], shoesQuantity, shoesSubtotal);
        printReceipt(items[3], prices[3], dressQuantity, dressSubtotal);
        System.out.printf("Total: UGX %,.2f%n", total);
    }

    private static double calculateSubtotal(double price, int quantity) {
        return price * quantity;
    }

    private static void printReceipt(String item, double price, int quantity, double subtotal) {
        System.out.printf("%s: %,d x UGX %,.2f = UGX %,.2f%n", item, quantity, price, subtotal);
    }
}
