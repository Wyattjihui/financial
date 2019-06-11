package com.bawei.manager;

import com.bawei.swagger.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Import(SwaggerConfiguration.class)
@EnableSwagger2
@SpringBootApplication
@EntityScan(basePackages = {"com.bawei.entity"})
public class ManagerApp {
    public static void main(String[] args) {
        SpringApplication.run(ManagerApp.class,args);
    }
}
