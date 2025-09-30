package org.example.task2;

public class Main {
    public static void main(String[] args) {
        // ===== Task 1: Box =====
        Box box = new Box(2, 3, 4);
        System.out.println("Surface area: " + box.surfaceArea());
        System.out.println("Lateral area: " + box.lateralSurfaceArea());
        System.out.println("Volume: " + box.volume());
        System.out.println();

        // ===== Task 2: Item/Cart/Order =====
        Cart cart = new Cart();
        cart.add(new Item(1, "Samsung Galaxy S23", 27999));
        cart.add(new Item(2, "Lenovo IdeaPad 3", 19499));
        cart.add(new Item(3, "LG 55\" 4K Smart TV", 15999));
        cart.add(new Item(4, "Bosch Serie 6 Пральна машина", 14799));

        System.out.println(cart);
        cart.removeById(3);
        System.out.println(cart);

        Order order = new Order(1L, "John");
        System.out.println(order.formOrderBill(cart));
        System.out.println();

        // ===== Task 3: IntStack =====
        IntStack st = new IntStack();
        st.push(10);
        st.push(20);
        st.push(30);
        System.out.println("peek = " + st.peek()); // 30
        System.out.println("pop = " + st.pop());   // 30
        System.out.println("size = " + st.size()); // 2
        System.out.println("isEmpty = " + st.isEmpty()); // false
        st.clear();
        System.out.println("after clear isEmpty = " + st.isEmpty()); // true
    }
}
