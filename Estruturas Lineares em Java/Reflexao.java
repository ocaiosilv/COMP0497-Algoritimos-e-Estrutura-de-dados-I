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
    R: Dá sim pra resolver, assim que se definir M e N a quantidade de pessoas com N cria a array com esse tamanho, preenche
    a array usando um for da primeira posição a última com números para indicar as "pessoas" começando em 1 e somando + 1, até preencher a lista, tendo isso, da pra definir um while que vai rodar enquanto a quantidade de pessoas dessa lista for maior que 1
    cria uma variavel que seria o ponteiro para as posições na array começando na posição 0, dai pra poder garantir que ao somar M o ponteiro não seja maior que o tamanho maximo da array que seria N -1, é possivel colocar um 
    while que vai checar se é maior que n-1, se for, ele faz o ponteiro que indica a posição (anteriormente somado a M-1(M-1 pela caracteristica de contagem de posições da array)) - o tamanho total da array, pois ai, se der por exemplo, 
    a array com 9 pessoas vai de 0 a 8 em posições, se o ponteiro der 10, ele vai pra 10-8 posição, que seria a 3° pessoa que fica na 2° posição da array. O outro loop, será para "remover" a pessoa naquela posição do ponteiro, 
    que basicamente copia o i+1 para posição i, "trazendo os números" em contexto visual (1,2,3,4,5,6) pessoa 3 elimidada, (1,2,4,5,6,6)-> pos eliminação, e então, so resta o ultimo loop que na verdade é a substituição da array 
    por uma copia com -1 posição, então ele cria uma array com o tamanho de pessoas -1, vai copiar de i pra i nas duas arrays a velha e a nova, porém a nova NÃO tem o ultimo numero da velha, e então só se é substituida a array 
    velha pela nova, começando o ciclo denovo até que o tamanho da lista seja 1.
    "           class Solution {
                    public int Josephus(int n, int m) {
                        int[] people = new int[n];
                        for(int i = 1; i <= people.length; i++) {
                            people[i-1] = i;
                        }
                        int pointer = 0;
                        while (people.length > 1) {
                            pointer = pointer + m-1 ;
                            while (pointer > people.length - 1) {
                                pointer = pointer - people.length;
                            }
                            for(int i = pointer; i < people.length -1 ; i++){
                                people[i] = people[i+1];
                            }
                            int[] peopleNew = new int[people.length - 1]; 
                            for(int i = 0; i < peopleNew.length ; i++){
                                peopleNew[i] = people[i] ;
                            }
                            people = peopleNew;
                        }
                        return people[0];
                        
                    }
                }"

    A remoção é justamente a parte que usa copia todos os números da posição de exclusão i em diante para i-1 até a lenght da array -1(para que não de NullPointerException) e em seguida se cria uma copia dessa array sem a última posição
    para que se encurte a array.

    Quanto a eficiência, 

*/