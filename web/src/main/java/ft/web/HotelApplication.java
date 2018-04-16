package ft.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan(basePackages = "ft")
@EntityScan(basePackages = "ft")
@EnableJpaRepositories(basePackages = "ft")
@SpringBootApplication
public class HotelApplication {
    private static Logger logger = LoggerFactory.getLogger(HotelApplication.class);

    public static void main(String[] args) {
         logger.debug("My debug message");
        SpringApplication.run(HotelApplication.class);
    }


}
