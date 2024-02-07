import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GuardarArrayListEnTxt {
    public static void guardarEnTxt(ArrayList<String> lista, String nombreArchivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (String elemento : lista) {
                writer.write(elemento);
                writer.newLine();  // Agrega una nueva línea después de cada elemento
            }
        }
    }
}