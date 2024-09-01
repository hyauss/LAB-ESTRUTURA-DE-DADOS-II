public class Node {
    private String data;
    private Node pai, esquerda, direita;

    public Node(String data, Node pai, Node esquerda, Node direita) {
        this.data = data;
        this.pai = pai;
        this.esquerda = esquerda;
        this.direita = direita;
    }

    public Node() {
        this("", null, null, null);
    }

    // Getter and Setter for data
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    // Getter and Setter for pai
    public Node getPai() {
        return pai;
    }

    public void setPai(Node pai) {
        this.pai = pai;
    }

    // Getter and Setter for esquerda
    public Node getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Node esquerda) {
        this.esquerda = esquerda;
    }

    // Getter and Setter for direita
    public Node getDireita() {
        return direita;
    }

    public void setDireita(Node direita) {
        this.direita = direita;
    }


public boolean isRoot() {
	return pai==null;

}

public boolean isLeaf() {
	return esquerda ==null && direita ==null;

}

public int getDegree() {
	if(esquerda!= null && direita!= null) {
		return 2;
	}else if(esquerda !=null || direita!=null) {
		return 1;
	}else {
		return 0;
	}
}

public int getLevel() {
    int level = 0;
    Node current = this; // Começa no nó atual
    
    while (current.getPai() != null) { // Sobe na árvore até a raiz
        current = current.getPai();
        level++;
    }
    
    return level;
}


public int getHeight() {
    // Uma folha (nó sem filhos) tem altura 0
    if (isLeaf()) {
        return 0;
    }

    int alturaEsquerda = (esquerda != null) ? esquerda.getHeight() : 0; // Altura da subárvore esquerda
    int alturaDireita = (direita != null) ? direita.getHeight() : 0; // Altura da subárvore direita

    // A altura do nó é 1 + a maior altura entre as subárvores esquerda e direita
    return 1 + Math.max(alturaEsquerda, alturaDireita);
}
}




