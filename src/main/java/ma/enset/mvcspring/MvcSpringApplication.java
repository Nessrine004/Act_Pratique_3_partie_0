package ma.enset.mvcspring;

import ma.enset.mvcspring.entities.Product;
import ma.enset.mvcspring.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MvcSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MvcSpringApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args -> {
            Product product = Product.builder()
                            .name("Computer").price(5400).quantity(50)
                            .build();
            productRepository.save(new Product(null, "Computer", 5000, 11));

            productRepository.save(Product.builder().name("Printer").price(4900).quantity(3).build());
            productRepository.save(Product.builder().name("Smart Phone").price(1200).quantity(2).build());
            productRepository.findAll().forEach(p->{
                System.out.println(p.toString());
            });
        };

    }

}
