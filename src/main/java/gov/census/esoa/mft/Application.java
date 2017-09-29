package gov.census.esoa.mft;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Xiaolei on 2/12/17.
 */

@SpringBootApplication
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }


//    @Override
//    public void run(String... strings) throws Exception {
//
//    }
}
