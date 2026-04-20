# String Calculator Kata (TDD)

Solución paso a paso a la clásica [String Calculator Kata](https://osherove.com/tdd-kata-1) de Roy Osherove, practicando TDD estricto con ciclos **red → green → refactor**.

El objetivo no es solo implementar la calculadora, sino **dejar visible el camino**: cada requisito nuevo entra por un test que falla, se hace pasar con el mínimo código, y solo entonces se refactoriza. El historial de commits es el propio diario del ejercicio.

## Contenido

- `src/main/java/org/example/StringCalculator.java` — método estático `Add(String)`
- `src/main/java/org/example/NegativeNumberException.java` — excepción de dominio
- `src/test/java/org/example/StringCalculatorTest.java` — 10 tests que cubren todos los steps resueltos
- `pom.xml` — Maven + JUnit 5 + AssertJ

## Requisitos

- Java 17+
- Maven 3.9+

## Cómo ejecutar

```bash
# Lanzar los tests
mvn test

# Compilar
mvn package
```

## Requisitos cubiertos (checklist de Osherove)

- [x] **Step 1** — `""` → `0`, `"1"` → `1`, `"1,2"` → `3`
- [x] **Step 2** — cantidad arbitraria de números: `"1,2,3,4"` → `10`
- [x] **Step 3** — saltos de línea como delimitador: `"1\n2,3"` → `6`
- [x] **Step 4** — delimitador custom: `"//[;]\n1;2"` → `3`
- [x] **Step 5** — negativos lanzan `NegativeNumberException` listando todos los que aparecen: `"-1,3,-9"` → `negatives not allowed, (-1)(-9)`
- [x] **Step 6** — números `> 1000` se ignoran: `"2,1001"` → `2`
- [ ] **Step 7** — delimitadores multi-carácter (`//[***]\n`) — pendiente como próxima iteración
- [ ] **Step 8** — múltiples delimitadores custom (`//[*][%]\n`) — pendiente

## Ejemplo de uso

```java
StringCalculator.Add("");                  // 0
StringCalculator.Add("1,2,3");             // 6
StringCalculator.Add("1\n2,3");            // 6
StringCalculator.Add("//[;]\n1;2;3");      // 6
StringCalculator.Add("2,1001");            // 2 (1001 ignorado)

StringCalculator.Add("-1,3,-9");
// throws NegativeNumberException:
// "negatives not allowed, (-1)(-9)"
```

## Cómo leer el historial

Los commits siguen el patrón:

```
Test(red):      <nombre_del_test>   ← test que falla
Test(green):    <nombre_del_test>   ← mínimo código para pasar
Test(refactor): <nombre_del_test>   ← limpieza sin romper nada
```

Recorrer los 24 commits en orden equivale a reproducir la kata desde cero viendo cómo crece el diseño.

```bash
git log --oneline --reverse
```

## Reglas TDD aplicadas

- Un test rojo antes de cualquier código de producción
- Mínimo código para poner el test en verde (sin adelantarse al siguiente step)
- Refactor solo con la suite en verde
- Nombres de test expresivos que describen **intención**, no implementación

## Notas y limitaciones conocidas

- El delimitador custom actual asume **un solo carácter** dentro de `//[x]\n`; ampliarlo a multi-carácter es trivial pero queda como próximo ciclo
- `Add` es estático: sacrificio consciente a favor de la brevedad del kata, no un patrón recomendado para producción
