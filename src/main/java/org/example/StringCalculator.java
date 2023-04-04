package org.example;

import static java.lang.Integer.parseInt;

public class StringCalculator {

    public static void main(String[] args) {

    }

    public static Integer Add(String numbers) {
        if (!numbers.equals("")) {
            return parseInt(numbers);
        }
        return 0;
    }

}
