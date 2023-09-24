public class Arbol {

    Registro raiz;

    public Arbol() {
        // Constructor de la clase Arbol
        raiz = null; // Inicializa la raíz del árbol como nula
        System.out.println("Se ha creado arbol de registros"); // Muestra un mensaje de creación del árbol
    }

    public void insertarRegistro(int valor, String estudiante) {
        // Método para insertar un registro en el árbol
        raiz = insertarRecursivamente(raiz, valor, estudiante); // Llama al método recursivo para la inserción
    }

    private Registro insertarRecursivamente(Registro nodo, int valor, String estudiante) {
        // Método recursivo para la inserción de un registro en el árbol
        if (nodo == null) {
            return new Registro(valor, estudiante); // Si el nodo es nulo, crea un nuevo nodo con el valor especificado
        }
        if (valor < nodo.valor) {
            nodo.izquierdo = insertarRecursivamente(nodo.izquierdo, valor, estudiante); // Si el valor es menor, ve al subárbol
                                                                            // izquierdo
        } else if (valor > nodo.valor) {
            nodo.derecho = insertarRecursivamente(nodo.derecho, valor, estudiante); // Si el valor es mayor, ve al subárbol derecho
        }
        return nodo;
    }

    public void buscarYMostrarRecorrido(int valor, String tipoRecorrido) {
        // Método para buscar un valor en el árbol y mostrar el recorrido en el tipo
        // especificado
        if (tipoRecorrido.equalsIgnoreCase("preorden")) {
            System.out.print("Recorrido en Preorden: ");
            boolean resultado = buscarYMostrarPreorden(raiz, valor); // Llama al método de búsqueda en preorden
            System.out.println(resultado);
        } else if (tipoRecorrido.equalsIgnoreCase("inorden")) {
            System.out.print("Recorrido en Inorden: ");
            boolean resultado = buscarYMostrarInorden(raiz, valor); // Llama al método de búsqueda en inorden
            System.out.println(resultado);
        } else if (tipoRecorrido.equalsIgnoreCase("posorden")) {
            System.out.print("Recorrido en Posorden: ");
            boolean resultado = buscarYMostrarPosorden(raiz, valor); // Llama al método de búsqueda en posorden
            System.out.println(resultado);
        } else {
            System.out.println("Tipo de recorrido no válido."); // Muestra un mensaje si el tipo de recorrido no es
                                                                // válido
        }
    }

    private boolean buscarYMostrarPreorden(Registro nodo, int valor) {
        // Método recursivo para buscar y mostrar un valor en preorden
        if (nodo == null) {
            return false; // Si el nodo es nulo, retorna falso
        }
        System.out.print("(" + nodo.estudiante + " => " + nodo.valor + ") "); // Muestra el nombre del estudiante y el valor del nodo
        if (nodo.valor == valor) {
            return true; // Si encuentra el valor, retorna verdadero
        }
        // Realiza la búsqueda en los subárboles izquierdo y derecho
        if (buscarYMostrarPreorden(nodo.izquierdo, valor) || buscarYMostrarPreorden(nodo.derecho, valor)) {
            return true;
        }
        return false;
    }

    private boolean buscarYMostrarInorden(Registro nodo, int valor) {
        // Método recursivo para buscar y mostrar un valor en inorden
        if (nodo == null) {
            return false; // Si el nodo es nulo, retorna falso
        }
        // Realiza la búsqueda en el subárbol izquierdo
        if (buscarYMostrarInorden(nodo.izquierdo, valor)) {
            return true;
        }
        System.out.print("(" + nodo.estudiante + " => " + nodo.valor + ") "); // Muestra el nombre del estudiante y el valor del nodo
        if (nodo.valor == valor) {
            return true; // Si encuentra el valor, retorna verdadero
        }
        // Realiza la búsqueda en el subárbol derecho
        if (buscarYMostrarInorden(nodo.derecho, valor)) {
            return true;
        }
        return false;
    }

    private boolean buscarYMostrarPosorden(Registro nodo, int valor) {
        // Método recursivo para buscar y mostrar un valor en posorden
        if (nodo == null) {
            return false; // Si el nodo es nulo, retorna falso
        }
        // Realiza la búsqueda en los subárboles izquierdo y derecho
        if (buscarYMostrarPosorden(nodo.izquierdo, valor) || buscarYMostrarPosorden(nodo.derecho, valor)) {
            return true;
        }
        System.out.print("(" + nodo.estudiante + " => " + nodo.valor + ") "); // Muestra el nombre del estudiante y el valor del nodo
        if (nodo.valor == valor) {
            return true; // Si encuentra el valor, retorna verdadero
        }
        return false;
    }

    public void eliminarRegistro(int valor) {
        // Método para eliminar un valor del árbol
        raiz = eliminarRecursivamente(raiz, valor); // Llama al método de eliminación recursiva
    }

    private Registro eliminarRecursivamente(Registro nodo, int valor) {
        // Método recursivo para eliminar un valor del árbol
        if (nodo == null) {
            return nodo; // Si el nodo es nulo, no se puede eliminar
        }
        if (valor < nodo.valor) {
            nodo.izquierdo = eliminarRecursivamente(nodo.izquierdo, valor); // Ve al subárbol izquierdo
        } else if (valor > nodo.valor) {
            nodo.derecho = eliminarRecursivamente(nodo.derecho, valor); // Ve al subárbol derecho
        } else {
            // Caso 1: Nodo sin hijos o con un solo hijo
            if (nodo.izquierdo == null) {
                return nodo.derecho;
            } else if (nodo.derecho == null) {
                return nodo.izquierdo;
            }
            // Caso 2: Nodo con dos hijos, encuentra el sucesor inorden
            nodo.valor = encontrarMinimoValor(nodo.derecho);
            nodo.derecho = eliminarRecursivamente(nodo.derecho, nodo.valor); // Elimina el sucesor inorden
        }
        return nodo;
    }

    private int encontrarMinimoValor(Registro nodo) {
        // Método para encontrar el valor mínimo en un subárbol
        int minimoValor = nodo.valor;
        while (nodo.izquierdo != null) {
            minimoValor = nodo.izquierdo.valor;
            nodo = nodo.izquierdo;
        }
        return minimoValor;
    }

    public int encontrarMaximoValor() {
        Registro nodo = raiz;
        // Método para encontrar el valor máximo en un subárbol
        // A diferencia del método anterior lo que se requiere no es el mínimo entre algún nodo de compración sino el máximo de todo el árbol 
        int maximoValor = nodo.valor;
        while (nodo.derecho != null) {
            maximoValor = nodo.derecho.valor;
            nodo = nodo.derecho;
        }
        return maximoValor;
    }
}
