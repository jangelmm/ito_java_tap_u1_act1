import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeerTxtYCrearArrayList {
    public static ArrayList<String> leerTxtYCrearArrayList(String nombreArchivo) throws IOException {
        ArrayList<String> lista = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                lista.add(linea);
            }
        }

        return lista;
    }
}