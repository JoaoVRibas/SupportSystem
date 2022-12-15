/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supportsystem.testclass;

import java.math.BigInteger;

/**
 *
 * @author joao.vmr
 */
public class TestClass {
    
    private TestClass() {
        
    }

    public static String concatenarTexto(String s1, String s2) {
        StringBuilder buf = new StringBuilder();
        buf.append(s1);
        buf.append(s2);
        return buf.toString();
    }

    public static String fatorial(int numero) throws IllegalArgumentException {
        if (numero < 1) {
            
            throw new IllegalArgumentException("Parâmetro zero ou negativo (" + numero + ')');
        }

        BigInteger fat = new BigInteger("1");
        for (int i = 2; i <= numero; i++) {
            fat = fat.multiply(new BigInteger(String.valueOf(i)));
        }
        return fat.toString();
    }
    
    public static float somar(float numero1, float numero2){
        System.out.println(numero1);
        System.out.println(numero2);
        return numero1 + numero2;
    }
    
    public static float subtrair(float numero1, float numero2){
        return numero1 - numero2;
    }
    
    public static float dividir(float numero1, float numero2){
        return numero1 / numero2;
    }
    
    public static float multiplicar(float numero1, float numero2){
        return numero1 * numero2;
    }

    
}
