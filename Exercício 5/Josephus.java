public class Josephus {
    public static void main(String[] args) {
        int N = 6; // numero de pessoas
        int M = 3; // salto ( elimina a cada M contagens )

        // --- Passo 1: Montar a lista circular ---
        Node primeiro = new Node(1);
        Node atual = primeiro;
        for (int i = 2; i <= N; i++) {
            
            Node newNode = new Node(i);
            
            atual.next = newNode;
            
            atual = atual.next;
        }
        atual.next = primeiro;
        

        // --- Passo 2: Simular a eliminacao ---
        Node anterior = atual; 
        atual = primeiro;

        System.out.println(" Ordem de eliminacao :");
        while (atual.next != atual) {

            
            for (int i = 0; i < M-1; i++) {
                anterior = atual;
                atual = atual.next;
            }
            
            anterior.next = atual.next;
            
            System.out.println(atual.item);
            
            atual = anterior.next;
        }

        System.out.println("\n Sobrevivente : " + atual.item);

    }
}
