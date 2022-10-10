package ru.geekbrains.marketautumn.services;
// 2. поднять сервис
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.marketautumn.dto.Product;
import ru.geekbrains.marketautumn.repo.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor //заинжектить репозиторий
public class ProductServices {

    //поставить именно final для правильности
    private final ProductRepository repository;

    public Product getProductsById (Long id)
    {
        return repository.productById(id);
    }

    public List<Product> GetAllProducts()
    {
        return repository.allProducts();
    }

}
