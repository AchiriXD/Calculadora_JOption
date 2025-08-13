// Calculadora en JOptionPane
// Autor : Daniel Achiri 
import javax.swing.*;
public class calculadora {
    public static void main(String[] args){
        boolean confirmacion = true;
        double num1, num2;
        int seleccion;
        JOptionPane.showMessageDialog(null, "Bienvenido a la calculadora");
        while (confirmacion) {
            String num1_string = JOptionPane.showInputDialog("Ingrese el primer numero: ");
            num1 = Double.parseDouble(num1_string);
            String operacion = JOptionPane.showInputDialog("Ingrese la operacion");
            switch (operacion) {
                case "+" :
                    num2 = input_numero2();
                    JOptionPane.showMessageDialog(null, "El resultado es: "+(num1 + num2));
                    break;
                case "-" :
                    num2 = input_numero2();
                    JOptionPane.showMessageDialog(null, "El resultado es: "+(num1 - num2));
                    break;
                case "*" :
                case "x" :
                case "X" :
                    num2 = input_numero2();
                    JOptionPane.showMessageDialog(null, "El resultado es: "+(num1 * num2));
                    break;
                case "/" :
                    num2 = input_numero2();
                    while (true) {
                        if (num2 == 0){
                            num2 = input_numero2("Numero invalido (no se puede dividir entre 0).\nIngrese el segundo numero"); 
                        }
                        else {
                            break;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "El resultado es: "+(num1 / num2));
                    break;
                default :
                    JOptionPane.showMessageDialog(null, "Operador invalido");
                    break;
            }
            seleccion = JOptionPane.showConfirmDialog(null, "¿Quieres hacer otra operacion?", "Confirmacion", JOptionPane.YES_NO_OPTION);
            confirmacion = (seleccion == JOptionPane.YES_OPTION);
        }
    }
    public static double input_numero2(){
        String numero_string = JOptionPane.showInputDialog("Ingrese el segundo numero:");
        double numero = Double.parseDouble(numero_string);
        return numero;
    }
    public static double input_numero2(String texto){
        String numero_string = JOptionPane.showInputDialog(texto);
        double numero = Double.parseDouble(numero_string);
        return numero;
    }
    
}