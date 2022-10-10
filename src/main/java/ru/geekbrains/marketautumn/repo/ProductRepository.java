package ru.geekbrains.marketautumn.repo;
// 3. поднять репозиторий.

import org.springframework.stereotype.Repository;
import ru.geekbrains.marketautumn.dto.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init()
    {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L,"Car",600L),
                new Product(2L,"House",1002L),
                new Product(2L,"Boat",300L)
        ));
    }

    public List<Product> allProducts()
    {
        return products;
    }

    public Product productById(Long id)
    {
        return products.stream().filter(p->p.getId().equals(id)).findFirst().orElseThrow(()->new RuntimeException("No gifts"));
    }

}
