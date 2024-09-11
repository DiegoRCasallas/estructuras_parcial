public class ListaContigua {
    private int[] elementos;
    private int tamanio;
    private int capacidad;

    // Constructor
    public ListaContigua(int capacidadInicial) {
        this.capacidad = capacidadInicial;
        this.elementos = new int[capacidad];
        this.tamanio = 0;
    }

    // Métodos básicos
    public void agregar(int elemento) {
        if (tamanio == capacidad) {
            expandir();
        }
        elementos[tamanio] = elemento;
        tamanio++;
    }

    public int obtener(int indice) {
        if (indice < 0 || indice >= tamanio) {
            throw new IndexOutOfBoundsException();
        }
        return elementos[indice];
    }

    public void eliminar(int indice) {
        if (indice < 0 || indice >= tamanio) {
            throw new IndexOutOfBoundsException();
        }
        // Desplazar elementos a la izquierda
        for (int i = indice; i < tamanio - 1; i++) {
            elementos[i] = elementos[i + 1];
        }
        tamanio--;
    }

        
    
    private void expandir() {
        int nuevaCapacidad = capacidad * 2;
        int[] nuevosElementos = new int[nuevaCapacidad];
        System.arraycopy(elementos, 0, nuevosElementos, 0, tamanio);
        elementos = nuevosElementos;
        capacidad = nuevaCapacidad;
    }
}