package org.example.task2;

import java.util.Arrays;

public class IntStack {
    private int[] data = new int[8];
    private int size = 0;

    public IntStack() {}

    
    public void push(int value) {
        ensureCapacity(size + 1);
        data[size++] = value;
    }


    public int pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        int v = data[--size];
        data[size] = 0;
        return v;
    }


    public int peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return data[size - 1];
    }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    public void clear() { Arrays.fill(data, 0, size, 0); size = 0; }

    private void ensureCapacity(int need) {
        if (need <= data.length) return;
        int newCap = Math.max(data.length * 2, need);
        data = Arrays.copyOf(data, newCap);
    }
}
