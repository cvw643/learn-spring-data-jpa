package demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;

/**
 * @author YQ.Huang
 */
@SpringBootApplication
public class TestApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(TestApplication.class).web(false).run(args);
    }
}
