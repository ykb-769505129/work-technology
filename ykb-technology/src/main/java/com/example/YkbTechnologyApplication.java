package com.example;

//import com.sun.deploy.association.utility.AppConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 76950
 */
//@SpringBootApplication
@SpringBootApplication(scanBasePackages = {"com"})
public class YkbTechnologyApplication {

    public static void main(String[] args) {
        SpringApplication.run(YkbTechnologyApplication.class, args);
    }

}
