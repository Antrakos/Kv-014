package edu.softserve.zoo;

import edu.softserve.zoo.config.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * @author Taras Zubrei
 */
@SpringBootConfiguration
@EnableAutoConfiguration
@Import(WebConfig.class)
public class ZooApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZooApplication.class, args);
    }
}
