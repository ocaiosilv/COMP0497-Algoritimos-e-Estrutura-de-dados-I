class Node {
    public Object item; // dado armazenado (generico)
    public Node next;   // referencia ao proximo no

    public Node(Object x) {
        item = x;
        next = null;
    }

    public Node(Object x, Node n) {
        item = x;
        next = n;
    }

}

public class ListaSimples {
    private Node head;

    public ListaSimples() {
        this.head = null;
    }

    /** Insere 'item' no INICIO da lista (O(1)). */
    public void insertFirst(Object item) {
        Node novoNode = new Node(item, head); 
        head = novoNode; 
    }

    /** Percorre a lista e imprime todos os elementos. */
    public void imprimir() {
        Node atual = head;
        while (atual != null) {
            System.out.print(atual.item + " -> ");
            atual = atual.next;
        }
        System.out.println("null");
    }

        /** Retorna a referencia do primeiro no que contem ’item ’,
    ou null se nao encontrar . */
    public Node find(Object item) {
        Node atual = head;  
        while (atual != null) {
            if (atual.item.equals(item)){
                return atual;
            }
            atual = atual.next;
        }
        return null;
    }

    /** Insere um novo no com ’item ’ APOS o no ’x ’. */
    public void insertAfter(Node x, Object item) {
        if (x == null) return;
        Node novoNode = new Node(item);
        novoNode.next = x.next;
        x.next = novoNode;
    }

    public static void main(String[] args) {
        ListaSimples lista = new ListaSimples();
        lista.insertFirst("C");
        lista.insertFirst("B");
        lista.insertFirst("A");
        lista.imprimir(); // A -> B -> C -> null
        Node noB = lista . find ("B") ;
        if ( noB != null ) {
            lista . insertAfter ( noB , "B2");
        }
        lista . imprimir () ; // A -> B -> B2 -> C -> null
        Node noZ = lista . find ("Z") ;
        System . out . println (" Busca por Z: " + noZ ) ; // null
    }
}
