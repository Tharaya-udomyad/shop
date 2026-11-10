package th.ac.utc.shop.controller;

import java.util.List;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import th.ac.utc.shop.model.Product;
import th.ac.utc.shop.service.InMemoryProductService;
import th.ac.utc.shop.service.ProductService;
import java.text.NumberFormat;
@RequiredArgsConstructor
@RestController
public class ReportController {
//    private final ProductService productService = new InMemoryProductService();
private final ProductService productService;
//    public ReportController(ProductService productService) {
//        this.productService = productService;
//    }
    private final NumberFormat priceFormatter;
    @GetMapping("/report")
    public Map<String, Object> report() {
        List<Product> all = productService.findAll();
        double total = all.stream().mapToDouble(Product::getTotalValue).sum();
        return Map.of("count", all.size(),
                "totalValue", priceFormatter.format(total));
    }

    }

