package churd.cafe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = {"churd.metrics.filter"})
public class ChurdsCafeWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChurdsCafeWebApplication.class, args);
    }

}
