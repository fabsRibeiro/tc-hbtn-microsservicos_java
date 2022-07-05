package ProductAPI.src.main.java.com.example.product.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> list = new ArrayList<Product>();

    public List<Product> getAllProducts() {
        return list;
    }

    public Product getProductById(Integer id) {
        Product p = new Product();
        p.setId(id.longValue());
        return list.get(buscarPosicao(p));
    }

    public void addProduct(Product s) {
        list.add(s);
    }

    public void updateProduct(Product s) {
        if(list.get(buscarPosicao(s)) != null){
            list.remove(s);
            list.add(s);
        }
    }

    public void removeProduct(Product s) {
        list.remove(s);
    }

    public void addList(List<Product> listOfProducts) {
        list = listOfProducts;
    }

    public int buscarPosicao(Product p){
        int posicaoProduto = 0;
        for(int posicao = 0; posicao < list.size() ; posicao++ ){
            if(list.get(posicao).getId() == p.getId()) {
                posicaoProduto = posicao;
            }
        }
        return posicaoProduto;
    }
}