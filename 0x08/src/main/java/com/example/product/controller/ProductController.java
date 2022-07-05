package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.model.ProductRepository;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @RequestMapping(method = RequestMethod.GET, path = "/allProducts")
    @ApiResponse(code = 10, message = "Required fields not informed.")
    public String buscarListagem(){
        return repository.getAllProducts().toString();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/findProductById/{id}")
    @ApiResponse(code = 11, message = "Warning - the process returned more than 1000 products.")
    public String buscarProdutoPorId(@RequestParam("id") Integer id){
        return repository.getProductById(id).toString();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/addProduct")
    @ApiResponse(code = 12, message = "The field id not informed. This information is required.")
    public Product adicionarProduto(@RequestBody Product produto){
        repository.addProduct(produto);
        return produto;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/updateProduct")
    @ApiResponse(code = 14, message = "No information has been updated. The new information is the same as recorded in the database.")
    public Product atualizarProduto(@RequestBody Product produto){
        repository.updateProduct(produto);
        return produto;
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/removeProduct")
    @ApiResponse(code = 13, message = "User not allowed to remove a product from this category")
    public List<Product> removerProduto(@RequestBody Product produto){
        repository.removeProduct(produto);
        return repository.getAllProducts();
    }

    @GetMapping("/adicionarLista")
    public List<Product> adicionarListaProduto(@RequestBody List<Product> produtos){
        repository.addList(produtos);
        return repository.getAllProducts();
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "BEM VINDO À PRODUCT REST API.";
    }
}
