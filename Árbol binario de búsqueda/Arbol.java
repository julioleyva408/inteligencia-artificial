package binario;
//Se crea la clase arbol
public class Arbol {
    Nodo raiz;

    public Arbol() {
        raiz = null;
    }
    //Se crea el metodo vacio
    public boolean vacio() {
        return raiz == null;
    }

    public Nodo buscarNodo(int valor) {
        return buscarNodoRec(raiz, valor);
    }
    //Se crea el metodo buscarNodo
    private Nodo buscarNodoRec(Nodo nodo, int valor) {
        if (nodo == null || nodo.valor == valor) {
            return nodo;
        }
        if (valor < nodo.valor)
            return buscarNodoRec(nodo.izquierdo, valor);
        else
            return buscarNodoRec(nodo.derecho, valor);
    }

    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    private Nodo insertarRec(Nodo nodo, int valor) {
        if (nodo == null) {
            nodo = new Nodo(valor);
            return nodo;
        }
        if (valor < nodo.valor)
            nodo.izquierdo = insertarRec(nodo.izquierdo, valor);
        else if (valor > nodo.valor)
            nodo.derecho = insertarRec(nodo.derecho, valor);
        return nodo;
    }

    public void imprimirEnOrden() {
        imprimirEnOrdenRec(raiz);
    }

    private void imprimirEnOrdenRec(Nodo nodo) {
        if (nodo != null) {
            imprimirEnOrdenRec(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            imprimirEnOrdenRec(nodo.derecho);
        }
    }

    public static void main(String[] args) {
        Arbol arbol = new Arbol();

        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(70);
        arbol.insertar(60);
        arbol.insertar(80);

        System.out.println("Recorrido en orden del árbol: ");
        arbol.imprimirEnOrden();

        System.out.println("\n¿El árbol está vacío? " + arbol.vacio());

        Nodo nodoBuscado = arbol.buscarNodo(70);
        if (nodoBuscado != null) {
            System.out.println("Se encontró el nodo con valor " + nodoBuscado.valor);
        } else {
            System.out.println("No se encontró el nodo buscado");
        }
    }
}