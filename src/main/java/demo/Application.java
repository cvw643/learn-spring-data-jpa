package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YQ.Huang
 */
@SpringBootApplication
@RestController
// NOTE: @EnableSpringDataWebSupport enabled by default in spring-boot
//@EnableSpringDataWebSupport
public class Application {

    @Autowired
    public Application(SomethingRepository somethingRepository) {
        this.somethingRepository = somethingRepository;
        if (somethingRepository.count() < 1)
            somethingRepository.save(new Something("1", "1", "2"));
    }

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    private final SomethingRepository somethingRepository;

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
    @GetMapping("/{id}")
    public Something getSomething(@PathVariable("id") Something something) {
//        Something something = somethingRepository.findOne(id);
        if (something == null) {
            throw new RuntimeException("Not Found");
        }
        return something;
    }

    @GetMapping
    public Page<Something> listSomething(Pageable pageable) {
        return somethingRepository.findAll(pageable);
    }
}
