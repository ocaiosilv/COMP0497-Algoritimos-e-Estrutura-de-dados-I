public class Josephus {
    public static void main(String[] args) {
        int N = 6; // numero de pessoas
        int M = 3; // salto ( elimina a cada M contagens )

        // --- Passo 1: Montar a lista circular ---
        Node primeiro = new Node(1);
        Node atual = primeiro;
        for (int i = 2; i <= N; i++) {
            // TODO : crie um novo Node com valor i
            Node newNode = new Node(i);
            // TODO : faca atual . next = novo
            atual.next = newNode;
            // TODO : avance atual para novo
            atual = atual.next;
        }
        atual.next = primeiro;
        // TODO : faca atual . next = primeiro ( fecha o circulo !)

        // --- Passo 2: Simular a eliminacao ---
        Node anterior = atual; // o no " antes " do atual
        atual = primeiro;

        System.out.println(" Ordem de eliminacao :");
        while (atual.next != atual) { // enquanto houver mais de 1

            // TODO : avance ( anterior , atual ) por M -1 posicoes
            for (int i = 0; i < M-1; i++) {
                anterior = atual;
                atual = atual.next;
            }
            // Isto e, repita M -1 vezes :
            // anterior = atual ;
            // atual = atual . next ;

            // TODO : elimine ’atual ’ fazendo anterior . next = atual . next
            anterior.next = atual.next;
            // TODO : imprima o eliminado : atual . item
            System.out.println(atual.item);
            // TODO : avance atual para anterior . next
            atual = anterior.next;
        }

        System.out.println("\n Sobrevivente : " + atual.item);

    }
}