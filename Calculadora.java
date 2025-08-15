// Calculadora en JOptionPane
// Autor : Daniel Achiri 
import java.util.*;
import javax.swing.*;
public class Calculadora {
    public static void main(String[] args){
        boolean confirmacion = true;
        double num1 = 0, num2, resultado = 0;
        int seleccion;
        boolean conservar = false, operador_validez = true;
        String num1_string, operador, operacion = "";
        ArrayList <String> historial = new ArrayList<String>();
        JOptionPane.showMessageDialog(null, "---Bienvenido a la Calculadora---\n-Solo dos numeros.\n-Operaciones: Suma, Resta, Multiplicación, Divición, Porcentaje y Módulo"
        +"\n-Se puede conservar o descartar un numero despues de una operacion\n-Al final se mostrara el historial de las operaciones");
        while (confirmacion) {
            if (conservar){
                num1 = resultado;
            }
            else {
                num1_string = JOptionPane.showInputDialog("Ingrese el primer numero: ");
                num1 = Double.parseDouble(num1_string);
            }
            operador = (JOptionPane.showInputDialog("Ingrese la operacion\nSuma( + )\nResta( - )\nMultiplicación( * )\nDivición( / )\nPorcentaje ( % )\nMódulo( mod )").trim());
            num2 = input_numero2("Ingrese el segundo numero");
            switch (operador) {
                case "+" :
                resultado = num1 + num2;
                break;
                ////////////////////////
                case "-" : 
                resultado = num1 - num2;
                break;
                //////////////////////
                case "*" : 
                case "x" :
                case "X" :
                resultado = num1*num2;
                break;
                ///////////////////////
                case "/" : 
                while (true) {
                    if (num2 == 0){
                        num2 = input_numero2("Numero invalido (no se puede dividir entre 0).\nIngrese el segundo numero"); 
                    }
                    else {
                        break;
                    }
                }
                resultado = num1 /num2 ;
                break;
                /////////////////////////
                case "%" :  
                resultado = num1/100 * num2;
                break;
                //////////////////////////
                case "mod" : 
                resultado = num1 % num2;
                break;
                ////////////////////////
                default :
                JOptionPane.showMessageDialog(null, "Operador invalido");
                operador_validez = false;
                break;
            }
            JOptionPane.showMessageDialog(null, "El resultado es: "+resultado);
            seleccion = JOptionPane.showConfirmDialog(null, "¿Quieres hacer otra operacion?", "Confirmacion", JOptionPane.YES_NO_OPTION);
            confirmacion = (seleccion == JOptionPane.YES_OPTION);
            if (confirmacion && operador_validez){
                int eleccion_conservar_numero = JOptionPane.showConfirmDialog(null, "¿Conservar el numero?", "Confirmacion",JOptionPane.YES_NO_OPTION);
                conservar = (eleccion_conservar_numero == JOptionPane.YES_OPTION);
            }
            operacion = num1+" "+operador+" "+num2+" = "+resultado;
            historial.add(operacion);
            operador_validez = true;
        }
        mostrarHistorial(historial);
        JOptionPane.showMessageDialog(null, "¡Gracias por usar la calculadora!");
    }
    public static double input_numero2(String texto){
        String numero_string = JOptionPane.showInputDialog(texto);
        double numero = Double.parseDouble(numero_string);
        return numero;
    }
    public static void mostrarHistorial(ArrayList<String> operaciones){
        String stringMostrado = "";
        int i = 1;
        for (String n : operaciones){
            stringMostrado += (i +". "+ n + "\n");
            i++; 
        }
        JOptionPane.showMessageDialog(null, "---Historial---\n"+stringMostrado);
    }
    
}