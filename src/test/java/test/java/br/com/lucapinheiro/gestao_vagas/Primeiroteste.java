package test.java.br.com.lucapinheiro.gestao_vagas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Primeiroteste {

    @Test
    public void needsToBeCalculateTwoNumbers() {
        int num1 = 10;
        int num2 = 20;
        int result = calculate(num1, num2);
        assertEquals(30, result);
    }

    public static int calculate(int num1, int num2) {
        return num1 + num2;
    }

}
