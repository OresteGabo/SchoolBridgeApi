package io.gabo.schoolbridgeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SchoolBridgeApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolBridgeApiApplication.class, args);
    }

}



enum Gender{
    MALE,FEMALE,OTHER;
}
