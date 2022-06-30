package api;

import org.springframework.boot.convert.PeriodFormat;

import java.time.LocalDate;
import java.time.Period;

import static java.lang.Integer.parseInt;

public class Calculator {

    public Double sum(Double number1, Double number2) {
        try{
            return number1 + number2;
        } catch (NullPointerException e){
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }
    }

    public Double sub(Double number1, Double number2) {
        try{
            return number1 - number2;
        } catch(NullPointerException e){
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }
    }

    public Double divide (Double number1, Double number2)  {

        if(number2 == 0){
            throw new ArithmeticException("Divisão por zero não é permitido.");
        }
        if(number1 == null && number2 == null) {
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }
        return number1 / number2;
    }

    public Integer factorial(Integer factorial) {
        int fator = 1;
        try{
            for(int i = 0; i <= factorial; i++){
                fator *= i;
            }
            return fator;
        } catch (NullPointerException e){
            throw new NullPointerException("Número é obrigatório.");
        }
    }

    // Exemplos:
    // Integer = 1 -> Binary = 1
    // Integer = 5 -> Binary = 101
    // Integer = 20 -> Binary = 10100
    public Integer integerToBinary(Integer integer) {
        return Integer.parseInt(Integer.toBinaryString(integer));
    }

    // Exemplos:
    // Integer = 1 -> Hexadecimal = "1"
    // Integer = 5 -> Hexadecimal = "37"
    // Integer = 170 -> Binary = "AA"
    public String integerToHexadecimal(Integer integer) {
        return Integer.toHexString(integer).toUpperCase();
    }

    // Exemplos
    // Date 1 = LocalDate.of(2020, 3, 15);
    // Date 2 = LocalDate.of(2020, 3, 29)
    // Total de dias = 14
    public int calculeDayBetweenDate(LocalDate date1, LocalDate date2) {
        Period period = Period.between(date1, date2);
        return period.getDays();
    }
}
