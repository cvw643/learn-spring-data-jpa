package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

/**
 * @author YQ.Huang
 */
@SpringBootApplication
@RestController
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private SomethingRepository somethingRepository;

//    @GetMapping("/")
//    public Something createSomething() {
//        Something something = new Something();
//        byte[] content = {1, 'a'};
//        String base64 = Base64.getEncoder().encodeToString(content);
//        System.out.println(base64);
//        something.setContent(content);
//        somethingRepository.save(something);
//        return something;
//    }
//
//    @GetMapping("/{id}")
//    public Something getSomething(@PathVariable String id) {
//        Something something = somethingRepository.findOne(id);
//        if (something == null) {
//            throw new RuntimeException("Not Found");
//        }
//        return something;
//    }
}
