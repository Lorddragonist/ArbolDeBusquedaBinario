public class App {
    public static void main(String[] args) throws Exception {

        // Muestra un mensaje de inicio
        System.out.println("\nArbol de búsqueda binario, almacen de registros!\n");

        // Crea una instancia de la clase Arbol llamada "registros"
        Arbol registros = new Arbol();

        // Inserta varios registros en el árbol
        registros.insertarRegistro(95, "Ana");
        registros.insertarRegistro(80, "Sofía");
        registros.insertarRegistro(70, "Daniel");
        registros.insertarRegistro(85, "Cristian");
        registros.insertarRegistro(94, "Cristina");
        registros.insertarRegistro(97, "Maria José");

        int maximoRegistro;

        maximoRegistro = registros.encontrarMaximoValor();

        // Muestra un mensaje y realiza una búsqueda en 'preorden' para imprimir todos los elementos
        System.out.println("\nPara imprimir todos los registros en 'preorden' se busca el último nodo:");
        registros.buscarYMostrarRecorrido(maximoRegistro, "preorden");

        // Muestra un mensaje y realiza una búsqueda en 'inorden' para imprimir todos los elementos
        System.out.println("\nPara imprimir todos los registros en 'inorden' se busca el último nodo:");
        registros.buscarYMostrarRecorrido(maximoRegistro, "inorden");

        // Muestra un mensaje y realiza una búsqueda en 'posorden' para imprimir todos los elementos
        System.out.println("\nPara imprimir todos los registros en 'posorden' se busca la raíz:");
        registros.buscarYMostrarRecorrido(registros.raiz.valor, "posorden");
        System.out.println("\n");

        maximoRegistro = registros.encontrarMaximoValor();

        // Elimina el registro con valor 85 del árbol
        registros.eliminarRegistro(85);
        System.out.println("\nSe elimina el estudiante con calificación de 85\n");

        // Muestra un mensaje y realiza una búsqueda en 'preorden' para imprimir todos los elementos
        System.out.println("\nPara imprimir todos los registros en 'preorden' se busca el último nodo:");
        registros.buscarYMostrarRecorrido(maximoRegistro, "preorden");

        // Muestra un mensaje y realiza una búsqueda en 'inorden' para imprimir todos los elementos
        System.out.println("\nPara imprimir todos los registros en 'inorden' se busca el último nodo:");
        registros.buscarYMostrarRecorrido(maximoRegistro, "inorden");

        // Muestra un mensaje y realiza una búsqueda en 'posorden' para imprimir todos los elementos
        System.out.println("\nPara imprimir todos los registros en 'posorden' se busca la raíz:");
        registros.buscarYMostrarRecorrido(registros.raiz.valor, "posorden");
        System.out.println("\n");

    }
}
