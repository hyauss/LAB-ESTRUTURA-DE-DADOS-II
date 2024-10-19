public class BST extends ArvoreBin {

    // Método para buscar um nó na BST com a chave data
    public Node search(String data) {
        return searchData(getRaiz(), data);
    }

    private Node searchData(Node node, String data) {
        if (node == null) {
            return null; // Retorna null se o nó não for encontrado
        }
        if (node.getData().equals(data)) {
            return node; // Retorna o nó se o dado for encontrado
        }
        if (data.compareTo(node.getData()) > 0) { // Se o dado for maior, busca na subárvore direita
            return searchData(node.getDireita(), data);
        } else { // Se o dado for menor, busca na subárvore esquerda
            return searchData(node.getEsquerda(), data);
        }
    }

    // Método para inserir um novo nó na BST
    public void insert(String data) {
        if (search(data) != null) {
            throw new RuntimeException("Nó com chave " + data + " já existe na BST.");
        }
        setRaiz(insertData(getRaiz(), data));
    }

    private Node insertData(Node node, String data) {
        if (node == null) {
            return new Node(data, null, null, null); // Cria um novo nó se a posição for nula
        }
        if (data.compareTo(node.getData()) > 0) { // Insere na subárvore direita
            Node novoDireita = insertData(node.getDireita(), data);
            node.setDireita(novoDireita);
            novoDireita.setPai(node); // Define o pai do nó inserido
        } else if (data.compareTo(node.getData()) < 0) { // Insere na subárvore esquerda
            Node novoEsquerda = insertData(node.getEsquerda(), data);
            node.setEsquerda(novoEsquerda);
            novoEsquerda.setPai(node);
        }
        return node;
    }

    // Método para remover um nó da BST
    public void remove(String data) {
        if (search(data) == null) {
            throw new RuntimeException("Nó com chave " + data + " não encontrado na BST.");
        }
        setRaiz(removeData(getRaiz(), data));
    }

    private Node removeData(Node node, String data) {
        if (node == null) {
            return null;
        }
        if (data.compareTo(node.getData()) < 0) { // Se o dado for menor, busca na subárvore esquerda
            node.setEsquerda(removeData(node.getEsquerda(), data));
        } else if (data.compareTo(node.getData()) > 0) { // Se o dado for maior, busca na subárvore direita
            node.setDireita(removeData(node.getDireita(), data));
        } else { // Se o dado for encontrado
            if (node.isLeaf()) {
                return null; // Nó folha, pode ser removido diretamente
            } else if (node.getEsquerda() == null) { // Um filho à direita
                return node.getDireita();
            } else if (node.getDireita() == null) { // Um filho à esquerda
                return node.getEsquerda();
            } else {
                // Dois filhos: substitui o valor pelo menor valor da subárvore direita
                Node min = findMin(node.getDireita());
                node.setData(min.getData());
                node.setDireita(removeData(node.getDireita(), min.getData()));
            }
        }
        return node;
    }

    // Método para encontrar o menor nó da BST
    public Node findMin() {
        return findMin(getRaiz());
    }

    private Node findMin(Node node) {
        if (node == null) {
            return null;
        }
        while (node.getEsquerda() != null) {
            node = node.getEsquerda(); // Vai para o nó mais à esquerda
        }
        return node;
    }

    // Método para encontrar o maior nó da BST
    public Node findMax() {
        return findMax(getRaiz());
    }

    private Node findMax(Node node) {
        if (node == null) {
            return null;
        }
        while (node.getDireita() != null) {
            node = node.getDireita(); // Vai para o nó mais à direita
        }
        return node;
    }

    // Método para encontrar o predecessor de um nó
    public Node findPredecessor(String data) {
        Node node = search(data);
        if (node == null) {
            return null;
        }
        return findPredecessor(node);
    }

    private Node findPredecessor(Node node) {
        if (node.getEsquerda() != null) {
            return findMax(node.getEsquerda()); // O predecessor está na subárvore esquerda
        }
        Node current = node;
        Node pai = node.getPai();
        while (pai != null && current == pai.getEsquerda()) {
            current = pai;
            pai = pai.getPai();
        }
        return pai;
    }

    // Método para encontrar o sucessor de um nó
    public Node findSuccessor(String data) {
        Node node = search(data);
        if (node == null) {
            return null;
        }
        return findSuccessor(node);
    }

    private Node findSuccessor(Node node) {
        if (node.getDireita() != null) {
            return findMin(node.getDireita()); // O sucessor está na subárvore direita
        }
        Node current = node;
        Node pai = node.getPai();
        while (pai != null && current == pai.getDireita()) {
            current = pai;
            pai = pai.getPai();
        }
        return pai;
    }

    // Método para limpar a árvore (remover todos os nós)
    public void clear() {
        setRaiz(null); // Remove a raiz e todas as conexões
    }
}
