package th.ac.utc.shop.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import th.ac.utc.shop.Model.Product;
import th.ac.utc.shop.service.InMemoryProductService;
import th.ac.utc.shop.service.ProductService;

@RestController
public class ProductController {
    private final ProductService productService = new InMemoryProductService();


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
}