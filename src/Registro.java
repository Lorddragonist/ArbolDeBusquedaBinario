public class Registro {
    int valor; // Valor almacenado en el registro
    Registro izquierdo; // Referencia al hijo izquierdo del registro
    Registro derecho; // Referencia al hijo derecho del registro
    String estudiante;

    public Registro(int valor, String estudiante) {
        // Constructor de la clase Registro
        this.valor = valor; // Inicializa el valor del registro con el valor proporcionado
        this.estudiante = estudiante; // Inicializa el nombre del estudiante con este registro
        this.izquierdo = null; // Inicializa la referencia al hijo izquierdo como nula
        this.derecho = null; // Inicializa la referencia al hijo derecho como nula
    }
}
