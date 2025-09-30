package org.example.task2;

import java.util.Arrays;

public class Cart {
    private Item[] items;
    private int size;

    public Cart() {
        this.items = new Item[10]; // внутрішня реалізація — масив
    }

    public void add(Item item) {
        if (item == null) return;
        ensureCapacity(size + 1);
        items[size++] = item;
    }

    /** Видалення за id (нічого не робить, якщо не знайдено) */
    public void removeById(long id) {
        int idx = findIndexById(id);
        if (idx == -1) return;
        // зсув
        for (int i = idx; i < size - 1; i++) {
            items[i] = items[i + 1];
        }
        items[--size] = null;
    }

    public int size() { return size; }

    /** Безпечний доступ до елемента за індексом (тільки читання) */
    public Item get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return items[index];
    }

    /** Сума по кошику */
    public double total() {
        double sum = 0;
        for (int i = 0; i < size; i++) sum += items[i].getPrice();
        return sum;
    }

    /** Повертає копію актуальної частини масиву (щоб не світити внутрішній стан) */
    public Item[] toArray() {
        return Arrays.copyOf(items, size);
    }

    private int findIndexById(long id) {
        for (int i = 0; i < size; i++) {
            if (items[i].getId() == id) return i;
        }
        return -1;
    }

    private void ensureCapacity(int need) {
        if (need <= items.length) return;
        int newCap = Math.max(items.length * 2, need);
        items = Arrays.copyOf(items, newCap);
    }

    @Override
    public String toString() {
        return "Cart{items=" + Arrays.toString(toArray()) + "}\n";
    }
}
