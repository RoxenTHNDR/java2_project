package lambda;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Widget {
    private int value;
    private String name;

    public static final int LOWER_VALUE  = -10;
    public static final int UPPER_VALUE  =  90;

    public Widget() {
        this.value = getRandomInt(LOWER_VALUE, UPPER_VALUE);
        this.name = getRandomString();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
    public int getRandomInt(int lower, int upper) {
        return ThreadLocalRandom.current().nextInt(lower, upper);
    }


    // https://stackoverflow.com/questions/20536566/creating-a-random-string-with-a-z-and-0-9-in-java
    public String getRandomString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();
    }

    @Override
    public String toString() {
        return "Widget{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}
