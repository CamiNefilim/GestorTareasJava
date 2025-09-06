package latinasincloud;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static List<Tarea> tareas = new ArrayList<Tarea>();
    private static Scanner scanner = new Scanner(
            System.in
    );

    public static void main(String[] args) {
        int opcion = 0;
        do{
            System.out.println("--- Gestor de tareas v2 ---");
            System.out.println("1. Agregar tarea.");
            System.out.println("2. Eliminar tarea.");
            System.out.println("3. Mostrar tareas.");
            System.out.println("4. Buscar tarea.");
            System.out.println("5. Salir.");
            System.out.print("> Ingrese una opción: ");
            opcion = scanner.nextInt();
            //Limpieza de buffer
            scanner.nextLine();
            switch (opcion){
                case 1:
                    agregarTarea();
                    break;
                case 2:
                    eliminarTarea();
                    break;
                case 3:
                    mostrarTareas();
                    break;
                case 4:
                    buscarTarea();
                    break;
                case 5:
                    System.out.println("Hasta luego!");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
                    break;
            }
        }while(opcion != 5);
        scanner.close();
    }

    private static void agregarTarea(){
        System.out.print("> Ingrese nombre de su tarea: ");
        String nombre = scanner.nextLine();
        if(nombre.isEmpty()) {
            System.out.println("La tarea no puede ser vacía.");
            return;
        }
        System.out.print("> Ingrese prioridad de su tarea (ALTA/BAJA): ");
        String prioridad = scanner.nextLine().toUpperCase();
        if(prioridad.isEmpty() || (!prioridad.equals("ALTA") && !prioridad.equals("BAJA"))){
            prioridad = "BAJA";
        }
        tareas.add(new Tarea(nombre,prioridad));
        System.out.println("La tarea ha sido agregada.");
    }

    private static void eliminarTarea(){
        System.out.print("> Ingrese el ID de la tarea a eliminar: ");
        int id = scanner.nextInt();
        //Limpieza de buffer
        scanner.nextLine();
        Tarea tareaEncontrada = null;
        for(Tarea tareaTemporal : tareas){
            if(tareaTemporal.getId() == id){
                tareaEncontrada = tareaTemporal;
                break;
            }
        }
        if(tareaEncontrada == null){
            System.out.println("No existe tarea con el ID ingresado.");
            return;
        }
        tareas.remove(tareaEncontrada);
        System.out.println("La tarea ha sido eliminada.");
    }

    private static void mostrarTareas(){
        if(tareas.isEmpty()){
            System.out.println("No hay tareas registradas.");
        }
        else {
            //Ordenar por prioridad
            /* Comparator.comparing(...)
               Es un método estático de la clase Comparator (desde Java 8).
               Sirve para construir un comparador a partir de una función que devuelve un atributo de tu objeto.

               Tarea::getPrioridad:
               Es una method reference (referencia a método).
               Significa “para cada objeto Tarea de la lista, llama a su método getPrioridad”.
            */
            tareas.sort(Comparator.comparing(Tarea::getPrioridad));
            for (int i = 0; i < tareas.size(); i++) {
                System.out.printf("ID: %d - Tarea: %s - Prioridad: %s.\n", tareas.get(i).getId(), tareas.get(i).getNombre(), tareas.get(i).getPrioridad());
            }
        }
    }

    private static void buscarTarea(){
        System.out.print("> Ingrese palabra clave para buscar: ");
        String palabraClave = scanner.nextLine();
        boolean encontreResultados = false;
        for(Tarea tarea : tareas){
            if(tarea.getNombre().toLowerCase().contains(palabraClave.toLowerCase())){
                encontreResultados = true;
                System.out.printf("ID: %d - Tarea: %s - Prioridad: %s.\n", tarea.getId(), tarea.getNombre(), tarea.getPrioridad());
            }
        }
        if(!encontreResultados){
            System.out.println("No hay tareas con palabra clave.");
        }
    }
}