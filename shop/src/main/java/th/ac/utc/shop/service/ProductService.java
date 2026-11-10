package th.ac.utc.shop.service;
import java.util.List;
import java.util.Optional;
import th.ac.utc.shop.model.Product;
public interface ProductService {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    List<Product> search(String keyword);

}