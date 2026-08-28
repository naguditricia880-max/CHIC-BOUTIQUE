public class Boutique {
    public static void main(String[] args) {
        String[] items = {"Shirt", "Trousers", "Shoes", "Dress"};
        double[] prices = {25000.00, 40000.00, 60000.00, 55000.00};

        System.out.println("+----------------------+----------------+");
        System.out.println("| Item                 | Price (UGX)    |");
        System.out.println("+----------------------+----------------+");
        for (int index = 0; index < items.length; index++) {
            System.out.printf("| %-20s | %,14.2f |%n", items[index], prices[index]);
        }
        System.out.println("+----------------------+----------------+");
    }
}
