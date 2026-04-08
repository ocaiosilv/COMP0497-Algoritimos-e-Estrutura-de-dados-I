public class MeuArrayDinamico {
    private int[] dados;
    private int tamanho; // quantos elementos realmente existem

    public MeuArrayDinamico(int capacidadeInicial) {
        this.dados = new int[capacidadeInicial];
        this.tamanho = 0;
    }

    /** Dobra a capacidade do array interno. */
    private void resize() {
        int novosDados[] = new int[dados.length*2];
        for (int i = 0; i < tamanho; i++){
            novosDados[i] = dados[i];
        }
        dados = novosDados;
        // TODO 1a: crie um novo array com o dobro do tamanho
        // TODO 1b: copie cada elemento de ’dados’ para o novo array
        // TODO 1c: faca ’dados’ apontar para o novo array
    }

    /** Adiciona ’valor’ no final do array. */
    public void add(int valor) {
        if (tamanho == dados.length){
            resize();
        }
        dados[tamanho] = valor;
        tamanho++;
        // TODO 2a: se tamanho == dados.length, chame resize()
        // TODO 2b: coloque ’valor’ na posicao ’tamanho’
        // TODO 2c: incremente ’tamanho’
    }

    /** Retorna o elemento na posicao ’indice’. */
    public int get(int indice) {
        if (indice < 0 || indice >= tamanho)
            throw new IndexOutOfBoundsException("Indice invalido: " + indice);
        return dados[indice];
    }

    public int size() {
        return tamanho;
    }

    /** Imprime o array no formato [a, b, c]. */
    public void imprimir() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < tamanho; i++) {
            sb.append(dados[i]);
            if (i < tamanho - 1) sb.append(", ");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    // === Teste ===
    public static void main(String[] args) {
        MeuArrayDinamico arr = new MeuArrayDinamico(2);
        arr.add(10);
        arr.add(20);
        arr.imprimir(); // [10, 20]
        arr.add(30); // deve fazer resize aqui!
        arr.add(40);
        arr.imprimir(); // [10, 20, 30, 40]
        System.out.println("Tamanho: " + arr.size()); // 4
    }
}
