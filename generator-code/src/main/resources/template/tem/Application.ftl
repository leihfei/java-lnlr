package com.datababys;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
* Created by ${author} on ${.now}.
* 描述${moduleName} service api
* @author ${author}
*/

@SpringBootApplication
@EnableDiscoveryClient
public class ${className}Application {

public static void main(String[] args) {
        SpringApplication.run(${className}Application.class, args);
    }
}
