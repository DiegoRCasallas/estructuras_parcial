
class Nodo<T> {
    T dato;
    Nodo<T> siguiente;

    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

// Clase para la Lista Enlazada Genérica
public class ListaEnlazada<T> {
    Nodo<T> cabeza;
    int tamano;

    // Constructor de la lista enlazada
    public ListaEnlazada() {
        this.cabeza = null;
    }

    public void agregarOrdenadmente(T dato) {
        if (isVacia()) {
            agregarAlInicio(dato);
            tamano++;
        }
        if ((Integer) dato < (Integer) cabeza.dato) {
            agregarAlInicio(dato);
            tamano++;
        }
        if ((Integer) dato > (Integer) cabeza.dato) {
            Nodo<T> actual = cabeza;
            int contador = 0;
            while (actual != null) {
                if ((Integer) dato < (Integer) actual.dato) {
                    insertarEnPosicion(contador, dato);
                }
                actual = actual.siguiente;
                contador++;

            }
        }
       
    }

    // Método para agregar un elemento al inicio de la lista
    public void agregarAlInicio(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
        tamano++;
    }

    // Método para agregar un elemento al final de la lista
    public void agregarAlFinal(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    public boolean isVacia() {
        return cabeza == null;
    }

    // Método para eliminar un elemento por su valor
    public void eliminarPorValor(T valor) {
        if (cabeza == null)
            return;

        if (cabeza.dato.equals(valor)) {
            cabeza = cabeza.siguiente;
            return;
        }

        Nodo<T> actual = cabeza;
        while (actual.siguiente != null && !actual.siguiente.dato.equals(valor)) {
            actual = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
        }
    }

    // Método para buscar un elemento en la lista
    public boolean buscar(T valor) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            if (actual.dato.equals(valor)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    // Método para imprimir la lista
    public void imprimirLista() {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            System.out.print((Integer) actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    // Método para obtener el tamaño de la lista
    public int obtenerTamano() {
        int tamano = 0;
        Nodo<T> actual = cabeza;
        while (actual != null) {
            tamano++;
            actual = actual.siguiente;
        }
        return tamano;
    }

    // Método para vaciar la lista
    public void vaciarLista() {
        cabeza = null;
    }

    // Método para obtener el elemento en una posición específica
    public T obtenerElementoEnPosicion(int posicion) {
        if (posicion < 0)
            throw new IndexOutOfBoundsException("Índice fuera de rango");

        Nodo<T> actual = cabeza;
        int contador = 0;
        while (actual != null) {
            if (contador == posicion) {
                return actual.dato;
            }
            contador++;
            actual = actual.siguiente;
        }

        throw new IndexOutOfBoundsException("Índice fuera de rango");
    }

    // Método para insertar un elemento en una posición específica
    public void insertarEnPosicion(int posicion, T dato) {
        if (posicion < 0)
            throw new IndexOutOfBoundsException("Índice fuera de rango");

        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (posicion == 0) {
            nuevoNodo.siguiente = cabeza;
            cabeza = nuevoNodo;
            return;
        }

        Nodo<T> actual = cabeza;
        int contador = 0;
        while (actual != null && contador < posicion - 1) {
            actual = actual.siguiente;
            contador++;
            tamano++;
        }

        if (actual == null)
            throw new IndexOutOfBoundsException("Índice fuera de rango");

        nuevoNodo.siguiente = actual.siguiente;
        actual.siguiente = nuevoNodo;

       
    }
    
}
