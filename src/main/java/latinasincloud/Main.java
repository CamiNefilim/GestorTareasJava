package latinasincloud;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static List<String> tareas = new ArrayList<String>();
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
        System.out.print("> Ingrese su tarea: ");
        String tarea = scanner.nextLine();
        if(tarea.isEmpty()) {
            System.out.println("La tarea no puede ser vacía.");
            return;
        }
        tareas.add(tarea);
        System.out.println("La tarea ha sido agregada.");
    }

    private static void eliminarTarea(){
        System.out.print("> Ingrese el índice de la tarea a eliminar: ");
        int indice = scanner.nextInt();
        //Limpieza de buffer
        scanner.nextLine();
        String tareaEncontrada = tareas.get(indice);
        if(tareaEncontrada.isEmpty()){
            System.out.println("No existe tarea en el índice ingresado.");
            return;
        }
        tareas.remove(indice);
        System.out.println("La tarea ha sido eliminada.");
    }

    private static void mostrarTareas(){
        if(tareas.isEmpty()){
            System.out.println("No hay tareas registradas.");
        }
        else {
            for (int i = 0; i < tareas.size(); i++) {
                System.out.printf("Índice: %d - Tarea: %s.\n", i, tareas.get(i));
            }
        }
    }

    private static void buscarTarea(){
        System.out.print("> Ingrese palabra clave para buscar: ");
        String palabraClave = scanner.nextLine();
        boolean encontreResultados = false;
        for(String tarea : tareas){
            if(tarea.toLowerCase().contains(palabraClave.toLowerCase())){
                encontreResultados = true;
                System.out.printf("Índice: %d - Tarea: %s.\n", tareas.indexOf(tarea), tarea);
            }
        }
        if(!encontreResultados){
            System.out.println("No hay tareas con palabra clave.");
        }
    }
}