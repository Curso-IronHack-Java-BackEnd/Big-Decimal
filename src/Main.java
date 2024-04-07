import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

import static java.math.RoundingMode.HALF_EVEN;

public class Main {
    public static void main(String[] args) {

        //pruebasBigDecimal();

        System.out.println("Vamos a realizar la siguiente operacion: (2.3 * x + 1.5) / (x - 0.8)");
        System.out.println("Usaremos diferentes valores, cuando quieras terminar introduce el valor 0.0");
        Scanner scan = new Scanner(System.in);      //Creo un objeto Scanner para guardar datos introducidos por teclado

        System.out.println("Escribe un valor para la variable x: ");   //Pregunta la usuario para que introduzca un valor para x


        String valorX = scan.nextLine();// Guardamos el valor de x inicial introducido por el usuario
        //Hacemos un bucle repitiendo la operacion hasta que se introduzca "0.0" como input
        while (!valorX.equals("0.0")) { //mientras que el valor de x sea distinto de "0.0"
            BigDecimal x = new BigDecimal(valorX); //Creamos un BigDecimal con el valor introducido y lo asignamos a x
            System.out.println("El resultado de la operacion para x = "+x+" es: "+operacionMatematica(x)); //LLamamos al metodo que calculara el resultado
            System.out.println("Introduce otro valor para x: "); //Volvemos a pedir otro valor para x
            valorX = scan.nextLine();//Volvemos a guardar el valor en x

        }
        scan.close();
        System.out.println("Operaciones terminadas!!!"); //Cuando el valor es "0.0" sale del bucle

    }
    //El metodo para calcular la formula recibe un BigDecimal que sera el valor introducido por el usuario
    public static BigDecimal operacionMatematica(BigDecimal x){
        //primero convertimos en BigDecimal el resto de valores constantes
        BigDecimal num1 = new BigDecimal("2.3");
        BigDecimal num2 = new BigDecimal("1.5");
        BigDecimal num3 = new BigDecimal("0.8");

        //Hacemos las operaciones y le aplicamos una escala de 5 y RoundingMode de HALF_EVEN
        BigDecimal result = x.multiply(num1).add(num2).divide(x.subtract(num3), 5 ,HALF_EVEN);
        return result; //Devolvemos el resultado
    }

    private static void pruebasBigDecimal() {
        BigDecimal num1 = new BigDecimal("2.3");
        BigDecimal num2 = new BigDecimal("1.5");

        BigDecimal suma = num1.add(num2);
        BigDecimal resta = num1.subtract(num2);
        BigDecimal multiplicacion = num1.multiply(num2);
        BigDecimal division = num1.divide(num2, 5, RoundingMode.HALF_UP);

        System.out.println("Num1: "+ num1+" || Num2: "+num2);
        System.out.println("Suma: "+ num1+" + "+num2+" = "+suma);
        System.out.println("Resta: "+ num1+" - "+num2+" = "+resta);
        System.out.println("Multiplicacion: "+ num1+" * "+num2+" = "+multiplicacion);
        System.out.println("Division: "+ num1+" / "+num2+" = "+division+" (5 decimales y roundingMode HALF_UP)");
    }

}