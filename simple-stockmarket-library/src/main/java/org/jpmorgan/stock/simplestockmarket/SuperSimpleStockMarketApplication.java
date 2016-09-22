package org.jpmorgan.stock.simplestockmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class SuperSimpleStockMarketApplication extends SpringBootServletInitializer {
  
  public static void main(final String[] args) {

    System.setProperty("spring.config.name", "SuperSimpleStockMarket");
    SpringApplication.run(SuperSimpleStockMarketApplication.class, args);

  }

}
