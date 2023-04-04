package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

public class StringCalculator {

    public static void main(String[] args) {

    }

    public static Integer Add(String numbers) throws NegativeNumberException {
        if (!numbers.equals("")) {
            List<Integer> numbersIntOfSum = transformTextToValues(numbers);
            return sumAll(numbersIntOfSum);
        }
        return 0;
    }
    private static List<Integer> transformTextToValues(String numbers) throws NegativeNumberException {
        var regexForReplaceDelimiter = extractDelimiter(numbers);
        if (!regexForReplaceDelimiter.equals("")){
            List<String> numbersTextOfSum = extractNumbersText(numbers.substring(6), regexForReplaceDelimiter);
            var numbersIntOfSum = numbersTextOfSum.stream().map(Integer::valueOf).toList();
            var negativeNumbers = extractNegativeNumbers(numbersIntOfSum);
            StringBuilder errorMessage = new StringBuilder("negatives not allowed, ");
            if (!negativeNumbers.isEmpty()) {
                for (Integer number : negativeNumbers) {
                    errorMessage.append("(").append(number).append(")");
                }
                throw new NegativeNumberException(errorMessage.toString());
            }
            return numbersIntOfSum;
        }
        numbers = numbers.replaceAll("\n",",");
        List<String> numbersTextOfSum = extractNumbersText(numbers, ",");
        return numbersTextOfSum.stream().map(Integer::valueOf).toList();
    }

    private static List<Integer> extractNegativeNumbers(List<Integer> numbersIntOfSum) {
        List<Integer> negativeNumbers = new ArrayList<>();
        for (Integer number : numbersIntOfSum) {
            if (number < 0) {
                negativeNumbers.add(number);
            }
        }
        return negativeNumbers;
    }
    private static List<String> extractNumbersText(String numbers, String regexForReplaceDelimiter) {
        return Arrays.stream(numbers.split(regexForReplaceDelimiter)).toList();
    }

    private static Integer sumAll(List<Integer> numbersIntOfSum) {
        return numbersIntOfSum.stream().reduce(0,Integer::sum);
    }
    private static String extractDelimiter(String numbers) {
        var delimiter = "";
        if (numbers.startsWith("//")) {
            delimiter = numbers.substring(3,4);
        }
        return delimiter;
    }

}
