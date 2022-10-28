package drink;

public class TestOrder {
    public static void main(String[] args) {
        RestaurantOrder order1 = new RestaurantOrder(3);
        RestaurantOrder order2 = new RestaurantOrder(2);
        RestaurantOrder order3 = new RestaurantOrder(1);
        OrderManager manager = new OrderManager();
        Dish soup = new Dish("soup", "chicken", 60);
        Drink water = new Drink("water","usual");
        Drink lipton = new Drink("lipton", "lemon", 80);
        Dish meat = new Dish("meat", "beef", 200);
        order1.add(soup);
        order1.add(water);
        order1.add(lipton);
        System.out.println("first:");
        Item[] elements = order1.getArrayOrder();
        for (Item I: elements){
            System.out.println(I.getNAME());
        }
        System.out.println("sorted:");
        elements = order1.getSortedByCostArrayOrder();
        for (Item I: elements){
            System.out.println(I.getNAME() + " " + I.getCOST());
        }
        System.out.println("amount: " + order1.getAmount());
        System.out.println("fullcost: " + order1.getFullCost());
        System.out.println("Without water:");
        if (order1.remove("water")) {
            elements = order1.getArrayOrder();
            for (Item I : elements) {
                System.out.println(I.getNAME());
            }
        }
        order3.add(meat);
        order2.add(soup);
        order2.add(soup);
        order2.add(soup);
        System.out.println("second without last elements, because size is over");
        elements = order2.getArrayOrder();
        for (Item I : elements) {
            System.out.println(I.getNAME());
        }
        System.out.println("Unique:");
        elements = order2.getUniqueArrayOrder();
        for (Item I : elements) {
            System.out.println(I.getNAME());
        }
        manager.add(order1);
        manager.add(order2);
        manager.add(order3);
        System.out.println("Amount in manager: " + manager.getAmount());
    }
}
