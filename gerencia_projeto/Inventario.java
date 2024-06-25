import java.util.*;

public class Inventario {
    public ArrayList<Produto> listaProdutos = new ArrayList<>();

    public List<Produto> getListaProdutos(){
        return listaProdutos;
    }

    public boolean isEmpty(){
        return listaProdutos.isEmpty();
    }

    public boolean removerItem(String nome) {
        for(Produto produto:listaProdutos){
            if (produto.getNome().equalsIgnoreCase(nome)) {
                listaProdutos.remove(produto);
                return true;
            }
        }
        return false;
    }

    public boolean editaProduto(String nome) {
        for(Produto produto: listaProdutos){
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }

    public void editaQuantidade(int quantidade) {
        for(Produto produto: listaProdutos){
            produto.setQuantidade(quantidade);
    }
}

}
