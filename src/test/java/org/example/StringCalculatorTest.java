package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    void empty_string_resolves_zero() {
        assertThat(StringCalculator.Add("")).isEqualTo(0);
    }
    @Test
    void one_number_in_string_resolves_number() {
        assertThat(StringCalculator.Add("1")).isEqualTo(1);
    }
    @Test
    void two_numbers_in_string_resolves_sum_numbers() {
        assertThat(StringCalculator.Add("1,2")).isEqualTo(3);
    }
    @Test
    void handle_an_unknown_amount_of_numbers_resolves_sum_numbers() {
        assertThat(StringCalculator.Add("1,2,3,4")).isEqualTo(10);
    }
    @Test
    void handle_new_lines_between_numbers_resolves_sum_numbers() {
        assertThat(StringCalculator.Add("1\n2")).isEqualTo(3);
    }
    @Test
    void handle_a_default_delimiter_resolves_sum_numbers() {
        assertThat(StringCalculator.Add("//[;]\n1;2")).isEqualTo(3);
    }
}
/*
Step 1:
"" -> 0 *
"1" -> 1 *
"1,2" -> 3 *
Step 2:
"1,2,3,4" -> 10 *
Step 3:
"1\n2" -> 3 *
Step 4:
“//[;]\n1;2” -> 3

 */
/*

 */