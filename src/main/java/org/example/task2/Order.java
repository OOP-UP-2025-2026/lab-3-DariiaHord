package org.example.task2;

public class Order {
    private final long id;
    private final String customer;

    public Order(long id, String customer) {
        if (id <= 0) throw new IllegalArgumentException("id must be > 0");
        if (customer == null || customer.isBlank()) throw new IllegalArgumentException("customer is required");
        this.id = id;
        this.customer = customer;
    }

    public String formOrderBill(Cart cart) {
        StringBuilder b = new StringBuilder();
        b.append("Order number ").append(this.id).append(" for customer ").append(this.customer)
                .append("\n------------------\n");

        for (int i = 0; i < cart.size(); i++) {
            Item it = cart.get(i);
            b.append("Item id: ").append(it.getId())
                    .append(" name: ").append(it.getName())
                    .append(" price: ").append(it.getPrice())
                    .append("\n");
        }

        b.append("------------------\n")
                .append("Total sum: ").append(cart.total());

        return b.toString();
    }
}
