package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    final private ProductRepository repository;
    final private ProductSearcher searcher;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
        ProductMatcher matcher = new ProductMatcher();
        searcher = new ProductSearcher(matcher, repository);
    }

    public void save(Product product){
        repository.save(product);
    }

    public Product[] searchBy(String text) {
        return searcher.searchBy(text);
    }
}

class ProductMatcher {
    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (book.getAuthor().equalsIgnoreCase(search)) {
                return true;
            }
            return false;
        } else if(product instanceof Smartphone){
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getName().equalsIgnoreCase(search)){
                return true;
            }
            if (smartphone.getVendor().equalsIgnoreCase(search)){
                return true;
            }
            return false;
        } else {
            return false;
        }
    }
}

class ProductSearcher {
    ProductMatcher matcher;
    ProductRepository repository;

    public ProductSearcher(ProductMatcher matcher, ProductRepository repository) {
        this.matcher = matcher;
        this.repository = repository;
    }

    public Product[] searchBy(String text) {
        List<Product> result = new ArrayList<>();
        for (Product product : repository.findAll()) {
            if (matcher.matches(product, text)){
                result.add(product);
            }
        }

        Product[] resultArray = new Product[result.size()];
        result.toArray(resultArray);

        return resultArray;
    }
}
