package org.example;

import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

public class StringCalculator {

    public static void main(String[] args) {

    }

    public static Integer Add(String numbers) {
        if (!numbers.equals("")) {
            List<Integer> numbersIntOfSum = transformTextToValues(numbers);
            return sumAll(numbersIntOfSum);
        }
        return 0;
    }
    private static List<Integer> transformTextToValues(String numbers) {
        // remplazar salto por coma
        var regexForReplaceDelimiter = extractDelimiter(numbers);
        if (!regexForReplaceDelimiter.equals("")){
            List<String> numbersTextOfSum = extractNumbersText(numbers.substring(6), regexForReplaceDelimiter);
            return numbersTextOfSum.stream().map(Integer::valueOf).toList();
        }
        numbers = numbers.replaceAll("\n",",");
        List<String> numbersTextOfSum = extractNumbersText(numbers, ",");
        return numbersTextOfSum.stream().map(Integer::valueOf).toList();
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
