package za.co.protogen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "za.co.protogen")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
