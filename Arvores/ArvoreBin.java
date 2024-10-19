import java.util.LinkedList;
import java.util.Queue;


public class ArvoreBin {
    private Node raiz;

    // Construtor sem parametros
    public ArvoreBin() {
        this.raiz = null;
    }

    // Construtor com parametro
    public ArvoreBin(Node raiz) {
        this.raiz = raiz;
    }

    // Get e set raiz;
    public Node getRaiz() {
        return raiz;
    }

    public void setRaiz(Node raiz) {
        this.raiz = raiz;
    }

    public boolean isEmpty() {
        return raiz == null;
    }

    // getDegree
    public int getDegree() {
        if (isEmpty()) {
            return 0;
        }
        return raiz.getHeight();
    }

    // getHeight
    public int getHeight() {
        if (isEmpty()) {
            return -1;
        }
        return raiz.getHeight();
    }

    // Percurso em ordem
    public void inOrder() {
        inOrderSuporte(raiz);
    }

    private void inOrderSuporte(Node node) {
        if (node != null) {
            inOrderSuporte(node.getEsquerda());
            System.out.print(node.getData() + " ");
            inOrderSuporte(node.getDireita());
        }
    }

    // Percurso em pré-ordem
    public void preOrderTraversal() {
        preOrderSuporte(raiz);
    }

    private void preOrderSuporte(Node node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            preOrderSuporte(node.getEsquerda());
            preOrderSuporte(node.getDireita());
        }
    }

    // Percurso em pós-ordem
    public void postOrderTraversal() {
        postOrderSuporte(raiz);
    }

    private void postOrderSuporte(Node node) {
        if (node != null) {
            postOrderSuporte(node.getEsquerda());
            postOrderSuporte(node.getDireita());
            System.out.print(node.getData() + " ");
        }
    }

    // Percurso por nível
    public void levelOrderTraversal() {
        if (raiz == null) {
            return;
        }

        Queue<Node> fila = new LinkedList<>();
        fila.add(raiz);
        StringBuilder sb = new StringBuilder();
        

        while (!fila.isEmpty()) {
            Node nodeAtual = fila.poll();
            sb.append(nodeAtual.getData() + " ");

            if (nodeAtual.getEsquerda() != null) {
                fila.add(nodeAtual.getEsquerda());
            }

            if (nodeAtual.getDireita() != null) {
                fila.add(nodeAtual.getDireita());
            }
        }
        
    sb.toString();
    System.out.println(sb);
    }
}
