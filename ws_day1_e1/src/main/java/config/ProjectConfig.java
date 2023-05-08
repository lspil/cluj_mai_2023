package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import repositories.ProductRepository;

@Configuration
@ComponentScan(basePackages = {"services", "repositories", "aspects"})
@EnableAspectJAutoProxy
public class ProjectConfig {

//  @Bean
//  ProductService productService1() {
//    return new ProductService();
//  }
//
//  @Bean
//  ProductService productService2() {
//    return new ProductService();
//  }

  @Bean
  ProductRepository productRepository1() {
    return new ProductRepository();
  }

}
