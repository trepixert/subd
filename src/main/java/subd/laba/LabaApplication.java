package subd.laba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(value = "subd.laba.models")
public class LabaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabaApplication.class, args);
    }

}
