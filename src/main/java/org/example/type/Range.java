package org.example.type;

public class Range {
    private int min;
    private int max;

    private Range(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public static Range of(int min, int max) {
        if(min > max) {
            throw new IllegalArgumentException("min must be lower than max");
        }
        if(min < 0 || max < 0) {
            throw new IllegalArgumentException("min and max must be positive");
        }
        return new Range(min, max);
    }

    public boolean numberIsInRange(int number) {
        return number >= min && number <= max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
