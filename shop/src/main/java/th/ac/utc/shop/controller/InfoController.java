package th.ac.utc.shop.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class InfoController {
    private final String shopName;
    private final double vatRate;
    private final Environment env;
    private final String developer;

    public InfoController(@Value("${shop.name:My Shop}") String shopName,
                          @Value("${shop.vat-rate:0.07}") double vatRate,
                          @Value("${shop.developer:Admin}") String developer,
                          Environment env) {
        this.shopName = shopName;
        this.vatRate = vatRate;
        this.developer = developer;
        this.env = env;
    }
    @GetMapping("/info")
    public Map<String, Object> info() {
        return Map.of(
                "shopName", shopName,
                "vatRate", vatRate,
                "developer", developer,
                "profiles", env.getActiveProfiles()
        );
    }
}
