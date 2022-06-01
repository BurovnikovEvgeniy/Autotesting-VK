package Utils;

import java.util.List;
import java.util.Random;

public class RandomValueGenerator<T> {
    private static final Random random = new Random();
    List<T> listValue;
    T randomValue;

    public RandomValueGenerator(List<T> listValue) {
        if (listValue.isEmpty()) {
            throw new IllegalArgumentException("The list of possible options is empty");
        }
        this.listValue = listValue;
    }

    public T generate() {
        randomValue = listValue.get(random.nextInt(listValue.size()));
        return randomValue;
    }

    public T get() {
        if (randomValue == null) {
            throw new NullPointerException("Random value was not created");
        }
        return randomValue;
    }

    public boolean contains(T value) {
        return listValue.contains(value);
    }
}
