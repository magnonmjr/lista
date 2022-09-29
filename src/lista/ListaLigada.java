package lista;

public class ListaLigada {
    Node primeiro;

    /* construtor */
    ListaLigada() {
        primeiro = null;
    }

    void addInicio(int chave) {
        if (vazia()) {
            primeiro = new Node(chave);
            return;
        }

        Node novo = new Node(chave);
        novo.proximo = primeiro;
        primeiro = novo;
    }

    void addFim(int chave) {

        if (vazia()) {
            addInicio(chave);
            return;
        }

        addFim(null, primeiro, chave);
    }

    void addFim(Node anterior, Node atual, int chave) {
        if (atual == null) {
            anterior.proximo = new Node(chave);
            return;
        }

        addFim(atual, atual.proximo, chave);
    }

    void removeInicio() {
        primeiro = primeiro.proximo;
    }

    void removeFim() {
        if (vazia()) {
            System.out.println("Nao ha elementos na lista");
        }
        removeFim(null, primeiro);
    }

    void removeFim(Node anterior, Node atual) {
        if (atual == null) {
            anterior = atual;
            return;
        }

        removeFim(atual, atual.proximo);
    }

    void remove(int chave) {

        if (primeiro.chave == chave) {
            removeInicio();
            return;
        }

        remove(null, primeiro, chave);
    }

    void remove(Node anterior, Node atual, int chave) {
        if (chave == atual.chave) {
            anterior.proximo = atual.proximo;
            return;
        }

        remove(atual, atual.proximo, chave);
    }

    void imprimeIterativo() {
        Node x;
        for (x = primeiro; x != null; x = x.proximo) {
            System.out.println(x.chave);
        }
    }

    void imprime() {
        imprime(primeiro);
    }

    void imprime(Node x) {
        if (x == null) {
            return;
        }

        System.out.println(x.chave);
        imprime(x.proximo);
    }


    boolean vazia() {
        return primeiro == null;
    }

}
