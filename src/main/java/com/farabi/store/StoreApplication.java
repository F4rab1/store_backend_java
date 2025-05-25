package com.farabi.store;

import com.farabi.store.services.ProductService;
import com.farabi.store.services.ProfileService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        var service =  context.getBean(ProductService.class);
        service.fetchProductsBySpecifications("Prod", BigDecimal.valueOf(1), null);
    }

}
