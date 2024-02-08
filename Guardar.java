import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Guardar {
    public static void guardar(ArrayList<String> lista_Alumnos, String nombreArchivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (String elemento : lista_Alumnos) {
                writer.write(elemento);
                writer.newLine();  // Agrega una nueva línea después de cada elemento
            }
        }
    }
}