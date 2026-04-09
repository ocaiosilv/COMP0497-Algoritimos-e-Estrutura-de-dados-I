class Node {
    public Object item; // dado armazenado (generico)
    public Node next;   // referencia ao proximo no

    // TODO : crie um construtor Node ( Object item ) que
    public Node(Object x) {
        item = x;
        next = null;
    }
    // inicializa this . item e coloca next = null

    // TODO : crie um segundo construtor Node ( Object item , Node next )
    public Node(Object x, Node n) {
        item = x;
        next = n;
    }
    // que permite ja encadear na criacao
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
        // TODO : percorra a lista comparando atual . item com ’item ’
        while (atual != null) {
            if (atual.item.equals(item)){
                return atual;
            }
            atual = atual.next;
        }
        // Use . equals () para comparar objetos !
        // Retorne ’atual ’ quando encontrar .
        // Se chegar ao fim ( null ), retorne null .
        return null;
    }

    /** Insere um novo no com ’item ’ APOS o no ’x ’. */
    public void insertAfter(Node x, Object item) {
        if (x == null) return;
        // TODO 1: crie um novo Node com ’item ’
        Node novoNode = new Node(item);
        // TODO 2: faca novo . next = x. next
        novoNode.next = x.next;
        x.next = novoNode;
        // TODO 3: faca x. next = novo
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