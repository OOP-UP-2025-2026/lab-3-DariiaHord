package org.example.task2;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setDimension("length", length);
        setDimension("width", width);
        setDimension("height", height);
    }

    // закритий валідуючий “сеттер”
    private void setDimension(String name, double value) {
        if (value <= 0) {
            throw new IllegalArgumentException(name + " must be > 0");
        }
        switch (name) {
            case "length" -> this.length = value;
            case "width"  -> this.width  = value;
            case "height" -> this.height = value;
        }
    }

    /** Повна площа поверхні: 2(lw + lh + wh) */
    public double surfaceArea() {
        return 2 * (length * width + length * height + width * height);
    }

    /** Площа бічної поверхні: 2h(l + w) */
    public double lateralSurfaceArea() {
        return 2 * height * (length + width);
    }

    /** Об’єм: l*w*h */
    public double volume() {
        return length * width * height;
    }
}
