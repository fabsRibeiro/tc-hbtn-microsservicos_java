package api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    @BeforeEach
    public static void set(){
        Calculator calculator = new Calculator();
    }

    @BeforeAll
    public static void setup(){
        new Calculator();
    }

    @Test
    void sumTest() {
        Calculator calculadora = new Calculator();
        Assertions.assertEquals(3.0,  calculadora.sum(1.0,2.0));
    }

    @Test
    public void numbersNullSumTest() {
        Calculator calculadora = new Calculator();
        String msg = "Número 1 e número 2 são obrigatórios.";
        String mensagem = assertThrows(NullPointerException.class, () ->{ calculadora.sum(null,null);}).getMessage();
        Assertions.assertEquals(msg, mensagem);
    }

    @Test
    void subTest() {
        Calculator calculadora = new Calculator();
        Assertions.assertEquals(1.0,  calculadora.sub(3.0,2.0));
    }

    @Test
    void divideTest() {
        Calculator calculadora = new Calculator();
        Assertions.assertEquals(3.0,  calculadora.divide(3.0,1.0));
    }

    @Test
    public void divisionByZeroTest() {
        Calculator calculadora = new Calculator();
        assertThrows(ArithmeticException.class, () -> calculadora.divide(6.0, 0.0));
    }

    @Test
    void factorialTest() {
        Calculator calculadora = new Calculator();
        Assertions.assertEquals(0,  calculadora.factorial(1));
    }

    @Test
    void integerToBinaryTest() {
        Calculator calculadora = new Calculator();
        Assertions.assertEquals(101,  calculadora.integerToBinary(5));
    }

    @Test
    void integerToHexadecimalTest() {
        Calculator calculadora = new Calculator();
        Assertions.assertEquals("65",  calculadora.integerToHexadecimal(101));
    }

    @Test
    void calculeDayBetweenDateTest() {
        Calculator calculadora = new Calculator();
        Assertions.assertEquals(14,  calculadora.calculeDayBetweenDate(
                LocalDate.of(2020, 3, 15),
                LocalDate.of(2020, 3, 29)));
    }
}
