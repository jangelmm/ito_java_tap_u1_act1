import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {
    public static ArrayList<Alumno> lista_Alumnos = new ArrayList<>();

    public static void main(String[] args) {
        menu();
    }
    public static void menu(){
        JOptionPane.showMessageDialog(null, "BIENVENIDO AL PROGRAMA DE REGISTRO DE ALUMNOS");
        int opcion = 0;
        do{
            String mensaje = "\tREGISTRO DE ALUMNOS\nMenu:\n1. Insertar un nuevo alumno\n2. Imprimir alumnos \n3. Borrar todos los datos\n4. Salir y Guardar";
            opcion = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
            switch (opcion) {
                case 1:
                    insertar_Alumno();
                break;
                case 2:
                    imprimir_Alumnos();
                break;
                case 3:
                
                break;
                case 4:
                break;
                default:
                        JOptionPane.showMessageDialog(null, "Error opción no válida");
                    break;
            }
        }while(opcion != 4);
    }
    public static void insertar_Alumno(){
        String numero_Control = JOptionPane.showInputDialog("Ingrese el número de control: ");
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre: ");
        String apellido_Paterno = JOptionPane.showInputDialog("Ingrese apellido paterno: ");
        String apellido_Materno = JOptionPane.showInputDialog("Ingrese el apellido materno: ");
        char genero = JOptionPane.showInputDialog("Ingrese el genero [M (masculino), F (femenino), O (otro)]: ").charAt(0);
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Digite su edad: "));

        Alumno alumno = new Alumno(numero_Control, nombre, apellido_Paterno, apellido_Materno, genero, edad);

        lista_Alumnos.add(alumno);
    }
    public static void imprimir_Alumnos(){
        for (Alumno alumno : lista_Alumnos) {
            System.out.println(alumno.toString());
        }
    }
}
