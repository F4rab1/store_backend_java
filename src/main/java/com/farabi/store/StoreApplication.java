package com.farabi.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StoreApplication {

    public  static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        var orderService = context.getBean(OrderService.class);
        var orderService2 = context.getBean(OrderService.class);
        var manager = context.getBean(NotificationManager.class);
        var resource = context.getBean(HeavyResource.class);
        orderService.placeOrder();
        manager.sendNotification("Order Placed");
        context.close();
    }

}
