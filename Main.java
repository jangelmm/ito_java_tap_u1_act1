import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {
    public static ArrayList<Alumno> lista_Alumnos = new ArrayList<>();
    public static File archivo = new File("AlumnosSistemas.txt");

    public static void main(String[] args) throws IOException {
        menu();
    }
    public static void menu() throws IOException{
        JOptionPane.showMessageDialog(null, "BIENVENIDO AL PROGRAMA DE REGISTRO DE ALUMNOS");
        int opcion = 0;
        do{
            String mensaje = "\tREGISTRO DE ALUMNOS\nMenu:\n1. Insertar un nuevo alumno\n2. Imprimir alumnos \n3. Reiniciar \n4. Leer datos guardados \n5. Guardar  \n6. Salir";
            opcion = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
            switch (opcion) {
                case 1:
                    insertar_Alumno();
                break;
                case 2:
                    imprimir_Alumnos();
                break;
                case 3:
                    reiniciar();
                break;
                case 4:
                    leer_Datos();
                break;
                case 5:
                    guardar_Datos();
                break;
                case 6:
                break;
                default:
                        JOptionPane.showMessageDialog(null, "Error opción no válida");
                    break;
            }
        }while(opcion != 6);
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
    public static void imprimir_Alumnos() {
        StringBuilder mensaje = new StringBuilder();
        for (Alumno a : lista_Alumnos) {
            mensaje.append("Nombre: ").append(a.getNombre()).append("\n");
            mensaje.append("Apellido Paterno: ").append(a.getApellido_Paterno()).append("\n");
            mensaje.append("Apellido Materno: ").append(a.getApellido_Materno()).append("\n");
            mensaje.append("Género: ").append(a.getGenero()).append("\n");
            mensaje.append("Edad: ").append(a.getEdad()).append("\n\n");
        }
        // Mostrar el cuadro de diálogo con el contenido del StringBuilder
        JOptionPane.showMessageDialog(null, mensaje.toString(), "Lista de Alumnos", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void reiniciar(){
        lista_Alumnos.clear();
    }
    public static void leer_Datos() throws IOException{
        ArrayList<String> lista_Texto = new ArrayList<>();
        lista_Texto = Leer.leer("AlumnosSistemas.txt");

        for (String elemento : lista_Texto) {
            String[] datos = elemento.split(","); 

            Alumno a = new Alumno(datos[0], datos[1], datos[2], datos[3], datos[4].charAt(0), Integer.parseInt(datos[5]));
            lista_Alumnos.add(a);
        }
    }
    public static void guardar_Datos() throws IOException{
        ArrayList<String> lista_Texto = new ArrayList<>();

        if(lista_Alumnos.isEmpty()){
            LocalDateTime fechaYHoraActual = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String fechaYHoraFormateada = fechaYHoraActual.format(formatter);

            lista_Texto.add("INFORMACIÓN DE LOS ALUMNOS.......................................");
            lista_Texto.add("Fecha y Hora de registro: "+fechaYHoraFormateada+".................\n");
        }

        for (Alumno a : lista_Alumnos) {
            lista_Texto.add(a.getNombre()+","+a.getNombre()+","+a.getApellido_Paterno()+","+a.getApellido_Materno()+","+a.getGenero()+","+a.getEdad());
        }
        Guardar.guardar(lista_Texto, "AlumnosSistemas.txt");
    }
}
