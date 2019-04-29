package churd.cafe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * https://spring.io/guides/gs/serving-web-content/#initial
 * If you are using Maven, you can run the application using ./mvnw spring-boot:run. Or you can build the JAR file with ./mvnw clean package. Then you can run the JAR file:
 *
 * java -jar target/gs-serving-web-content-0.1.0.jar
 */
@SpringBootApplication
@ServletComponentScan(basePackages = {"churd.metrics.filter"})
public class ChurdsCafeWebApplication {

    // TODO: add README detail about including ServletComponentScan for spring to load the web filter

    // TODO: clean up comments into readme

    public static void main(String[] args) {
        SpringApplication.run(ChurdsCafeWebApplication.class, args);
    }

}
