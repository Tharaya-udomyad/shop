package th.ac.utc.shop.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import th.ac.utc.shop.model.Product;
import th.ac.utc.shop.service.InMemoryProductService;
import th.ac.utc.shop.service.ProductService;

@RestController
public class ProductController {
//    private final ProductService productService = new InMemoryProductService();
private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> list() {
        return productService.findAll();
    }

    @GetMapping("/product")
    public Product one(@RequestParam Long id) {
        Product p = productService.findById(id).orElse(null);
        if (p != null) {
            System.out.println("Total value: " + p.getTotalValue()); // เรียกใช้ข้างในเมธอดแบบนี้ได้
        }
        return p;
    }
    @GetMapping("/products/search")
    public List<Product> search(@RequestParam String keyword) {
        return productService.search(keyword);
    }

    @GetMapping("/")
    public String index() {
        return "Welcome to my shop ";
    }

    @GetMapping("/products/add")
    public Product add(@RequestParam String name,
                       @RequestParam double price,
                       @RequestParam int stock) {
        return productService.save(new Product(null, name, price, stock));
    }


}
