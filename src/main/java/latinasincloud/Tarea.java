package latinasincloud;

public class Tarea {
    private static int contadorId = 1;
    private int id;
    private String nombre;
    private String prioridad;

    //Constructores
    public Tarea(){}
    public Tarea(String nombre, String prioridad) {
        this.id = contadorId++;
        this.nombre = nombre;
        this.prioridad = prioridad;
    }

    //Métodos
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }
}
