import java.util.Random;

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

    public ListaContigua llenarLista1() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(21);
        ListaContigua lista = new ListaContigua(numeroAleatorio);

        for (int i = 0; i < numeroAleatorio - 1; i++) {
            int num = random.nextInt(501) + 50;
            lista.agregar(num);
        }

        return lista;

    }

}
