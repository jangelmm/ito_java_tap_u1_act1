public class Alumno{
    private String numero_Control;
    private String nombre;
    private String apellido_Paterno;
    private String apellido_Materno;
    private char genero;
    private int edad;
    
    public Alumno(String numero_Control, String nombre, String apellido_Paterno, String apellido_Materno, char genero,
            int edad) {
        this.numero_Control = numero_Control;
        this.nombre = nombre;
        this.apellido_Paterno = apellido_Paterno;
        this.apellido_Materno = apellido_Materno;
        this.genero = genero;
        this.edad = edad;
    }

    public String getNumero_Control() {
        return numero_Control;
    }

    public void setNumero_Control(String numero_Control) {
        this.numero_Control = numero_Control;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_Paterno() {
        return apellido_Paterno;
    }

    public void setApellido_Paterno(String apellido_Paterno) {
        this.apellido_Paterno = apellido_Paterno;
    }

    public String getApellido_Materno() {
        return apellido_Materno;
    }

    public void setApellido_Materno(String apellido_Materno) {
        this.apellido_Materno = apellido_Materno;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}