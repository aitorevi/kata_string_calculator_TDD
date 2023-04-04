package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    void empty_string_resolves_zero() {
        assertThat(StringCalculator.Add("")).isEqualTo(0);
    }
}

/*
Crear una simple calculadora String con una firma de método:
---------------
int Suma(cadena números)
---------------
El método puede tomar hasta dos números, separados por comas, y devolverá su suma.
por ejemplo "" o "1" o "1,2" como entradas.
(para una cadena vacía devolverá 0)
Sugerencias:
------
 - Empieza con el caso de prueba más simple de una cadena vacía y pasa a uno y dos números.
 - Acuérdate de resolver las cosas de la forma más sencilla posible para obligarte a escribir pruebas en las que no habías pensado.
 - Recuerda refactorizar después de cada prueba superada

Traducción realizada con la versión gratuita del traductor www.DeepL.com/Translator
 */