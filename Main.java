import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {
    public static ArrayList<Alumno> lista_Alumnos = new ArrayList<>();
    public static String nombre_Archivo;
    public static File archivo;

    public static void main(String[] args) throws IOException {
        boolean continuar = false;
        do{
            JOptionPane.showMessageDialog(null, "BIENVENIDO AL PROGRAMA DE REGISTRO DE ALUMNOS", "Tópicos Avanzados de Programación", 1);
            char opcion = JOptionPane.showInputDialog("Selecciona una de las siguiente opciones: \n'C'. Crear un archivo nuevo \n'A'. Abrir un archivo existente \nPresione 'Cancel' para salir").charAt(0);
            if(opcion == 'C'){
                nombre_Archivo = "AlumnosSistemas"+insertar_Fecha()+".txt";
                System.out.println(nombre_Archivo);
                archivo = new File(nombre_Archivo);
                menu();
            }
            if (opcion == 'A') {
                nombre_Archivo = JOptionPane.showInputDialog("Digite el nombre del Archivo a trabajar: ");
                archivo = new File(nombre_Archivo);

                if (archivo.exists()) {
                    menu();
                } else {
                    char reiniciar = JOptionPane.showInputDialog(null, "Lo siento el archivo no ha sido encontrado :/ \nQuiere intentarlo nuevamante (Y/n): ", "Tópicos Avanzados de Programación", 2).charAt(0);
                    if(reiniciar == 'Y' || reiniciar == 'y'){
                        continuar = true;
                    }
                }
            }
        }while(continuar);
    }
    public static void menu() throws IOException{
        int opcion = 0;
        do{
            String mensaje = "\tREGISTRO DE ALUMNOS\nMenu:\n1. Insertar un nuevo alumno\n2. Leer los datos guardados \n3. Guardar el estado actual de la información \n4. Imprimir los alumnos \n5. Borrar todos los datos  \n6. Salir (Asegurese de guardar los datos antes)";
            opcion = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
            switch (opcion) {
                case 1:
                    insertar_Alumno();
                break;
                case 2:
                    leer_Datos();
                break;
                case 3:
                    guardar_Datos();
                break;
                case 4:
                    imprimir_Alumnos();
                break;
                case 5:
                    reiniciar();
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
            mensaje.append("N. Control: ").append(a.getNumero_Control()).append("\n");
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
        lista_Texto = Leer.leer(nombre_Archivo);

        for (String elemento : lista_Texto) {
            String[] datos = elemento.split(","); 
            
            Alumno a = new Alumno(datos[0], datos[1], datos[2], datos[3], datos[4].charAt(0), Integer.parseInt(datos[5]));
            lista_Alumnos.add(a);
        }
    }
    public static void guardar_Datos() throws IOException{
        ArrayList<String> lista_Texto = new ArrayList<>();

        for (Alumno a : lista_Alumnos) {
            lista_Texto.add(a.getNumero_Control()+","+a.getNombre()+","+a.getApellido_Paterno()+","+a.getApellido_Materno()+","+a.getGenero()+","+a.getEdad());
        }
        Guardar.guardar(lista_Texto, nombre_Archivo);
        
        lista_Alumnos.clear();
    }
    public static String insertar_Fecha() {
        LocalDateTime fechaYHoraActual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy_HH.mm");
        String fechaYHoraFormateada = fechaYHoraActual.format(formatter);
        return fechaYHoraFormateada;
    }
}
