package cn.com.taiji.actual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//@EnableCaching
public class ActualApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActualApplication.class, args);
    }

}

