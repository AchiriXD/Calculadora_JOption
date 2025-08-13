// Calculadora en JOptionPane
// Autor : Daniel Achiri 
import javax.swing.*;
public class calculadora {
    public static void main(String[] args){
        boolean confirmacion = true;
        double num1 = 0, num2, resultado = 0;
        int seleccion;
        boolean conservar = false, operador_validez = true;
        String num1_string, operacion;
        JOptionPane.showMessageDialog(null, "---Bienvenido a la Calculadora---\n-Solo dos numeros.\n-Operaciones: Suma, Resta, Multiplicasion, Divicion, Porcentaje y Modulo"
        +"\n-Se puede conservar o descartar un numero despues de una operacion");
        while (confirmacion) {
            if (conservar){
                num1 = resultado;
            }
            else {
                num1_string = JOptionPane.showInputDialog("Ingrese el primer numero: ");
                num1 = Double.parseDouble(num1_string);
            }
            operacion = JOptionPane.showInputDialog("Ingrese la operacion\nSuma( + )\nResta( - )\nMultiplicacion( * )\nDivision( / )\nPorcentaje ( % )\nMudulo( mod )");
            num2 = input_numero2("Ingrese el segundo numero");
            switch (operacion) {
                case "+" : ///////
                resultado = num1 + num2;
                JOptionPane.showMessageDialog(null, "El resultado es: "+resultado);
                break;
                case "-" : ///////
                resultado = num1 - num2;
                JOptionPane.showMessageDialog(null, "El resultado es: "+resultado);
                break;
                case "*" : ////////
                case "x" :
                case "X" :
                resultado = num1*num2;
                JOptionPane.showMessageDialog(null, "El resultado es: "+resultado);
                break;
                case "/" : ////////
                while (true) {
                    if (num2 == 0){
                        num2 = input_numero2("Numero invalido (no se puede dividir entre 0).\nIngrese el segundo numero"); 
                    }
                    else {
                        break;
                    }
                }
                resultado = num1 /num2 ;
                JOptionPane.showMessageDialog(null, "El resultado es: "+resultado);
                break;
                case "%" :  ///////////
                resultado = num1/100 * num2;
                JOptionPane.showMessageDialog(null, "El resultado es: "+resultado);
                break;
                case "mod" : ///////////
                resultado = num1 % num2;
                JOptionPane.showMessageDialog(null, "El resultado es: "+resultado);
                break;
                /////////////////////
                default :
                JOptionPane.showMessageDialog(null, "Operador invalido");
                operador_validez = false;
                break;
            }
            seleccion = JOptionPane.showConfirmDialog(null, "¿Quieres hacer otra operacion?", "Confirmacion", JOptionPane.YES_NO_OPTION);
            confirmacion = (seleccion == JOptionPane.YES_OPTION);
            if (confirmacion && operador_validez){
                int eleccion_conservar_numero = JOptionPane.showConfirmDialog(null, "¿Conservar el numero?", "Confirmacion",JOptionPane.YES_NO_OPTION);
                conservar = (eleccion_conservar_numero == JOptionPane.YES_OPTION);
            }
            operador_validez = true;
        }
    }
    public static double input_numero2(String texto){
        String numero_string = JOptionPane.showInputDialog(texto);
        double numero = Double.parseDouble(numero_string);
        return numero;
    }
    
}