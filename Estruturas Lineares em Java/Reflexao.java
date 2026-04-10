/*
A) Custo da inserção no meio.
Por que inserir no meio de um array é mais lento que inserir no meio de uma lista
encadeada? Pense no que cada estrutura precisa fazer com os elementos existentes.
    R: Porque ao inserir um dado numa posição no meio de uma array é necessário mover todos os dados apartir daquela posição em 1 casa e alocar aquele novo espaço criado com o novo dado, ja na lista encadeada
    só é necessário que o .next do anterior a posição requerida seja o Node do dado novo, e que o .next do Node do dado novo seja o Node para que o .next do anterior apontava anteriormente.



b) Custo de acesso por índice.
Para acessar o k-ésimo elemento, qual estrutura é mais rápida – o array ou a lista? Por
quê?
    R: A array é mais rápida pois é possível acessar a posição K em tempo O(1) (array[k]), ja na lista encadeada é necessário atravessar ela em O(n) até chegar no k-ésimo elemento.



c) Circularidade.
Seria possível resolver o Problema de Josephus usando um array em vez de uma lista
circular? Se sim, como ficaria a remoção? Seria mais ou menos eficiente?
    R:Dá sim pra resolver, assim que se definem M e N (sendo N a quantidade de pessoas), criamos uma array com esse tamanho N. Depois, preenche a array usando um for da primeira posição até a última com números que representam as "pessoas", começando em 1 e somando +1 até preencher.
    Depois, dá pra definir um while que vai rodar enquanto a quantidade de pessoas dessa lista for maior que 1. Antes dele, define uma variável que será o ponteiro para as posições na array, começando na posição 0.
    Então, dentro do while se soma M - 1 ao ponteiro, essa soma será como o pulo vai funcionar( M-1 por conta da array começar na pos 0), mas para garantir que ao somar M o ponteiro não ultrapasse o tamanho máximo da array (que seria N - 1), fazemos um laço while pra enquanto esse valor for maior que length - 1, basta subtrair o tamanho total da array de ponteiro,
    até o ponteiro parar em uma posição válida como se fosse na lista encadeada "circulando".
        Exemplo:
        Se a array tem 9 pessoas (índices de 0 a 8) e o ponteiro chega em 10, faz:
            10 - 9 = 1
        ficando dentro do escopo de índices possiveis.
    Depois disso, faz outro loop que será responsável por "remover" a pessoa naquela posição do ponteiro. Basicamente ele vai copiando o valor da posição i+1 para i, deslocando os elementos à direita uma posição para a esquerda sem chegar na úlitma pos pra não dar nullPointerException;
        Exemplo:
        (1,2,3,4,5,6) -> pessoa 3° eliminada == (1,2,4,5,6,6)
    Ultima coisa é criar uma nova array com tamanho da array atual -1 de tamanho, copiando os elementos da array antiga para a nova, ignorando o último valor (Ja que ele foi "duplicado" no loop anterior). Depois disso, torna a array antiga = a array nova para conseguir finalizar a remoção.
    Esse processo se repete até que o tamanho da lista seja 1, e então o valor restante é retornado.
    "           class Solution {
                    public int Josephus(int n, int m) {
                        int[] people = new int[n];
                        for(int i = 1; i <= people.length; i++) {                            ->O(N)
                            people[i-1] = i;
                        }
                        int pointer = 0; -> O(1)
                        while (people.length > 1) {                                          ->O(N)
                            pointer = pointer + m-1 ;   -> O(1)
                            if (pointer > people.length - 1) {                               ->O(1)
                                pointer = pointer % people.length;
                            }
                            for(int i = pointer; i < people.length -1 ; i++){                   ->O(N)
                                people[i] = people[i+1];
                            }
                            int[] peopleNew = new int[people.length - 1]; 
                            for(int i = 0; i < peopleNew.length ; i++){                         -> O(N)
                                peopleNew[i] = people[i] ;
                            }
                            people = peopleNew;        -> o(1)
                        }
                        return people[0]; -> O(1)
                        
                    }
                }"

    A remoção é justamente a parte que usa copia todos os números da posição de exclusão i em diante para i-1 até a lenght da array -1(para que não de NullPointerException) e em seguida se cria uma copia dessa array sem a última posição
    para que se encurte a array.

    Quanto a eficiência, ficaria O(N) + O(N) * ((O(1) + O(1) + O(n) + O(n) + O(1))) + O(1)   que fica, O(N) * O(N) == O(n²), sendo assim num geral ele seria mais lento que na lista encadeada, que seria O(N x M) ja que seria o tempo de construir (N) + 
    (M) que seriam as repetições de pular, porém, se N = M no modelo de nodes, fica O( N x N) que também é o(n²).

*/