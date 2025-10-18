package com.product.product;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@OpenAPIDefinition(
        info = @Info(
                title= "Product Service Rest Api Documentation",
                description = "Product Service REST API",
                version = "v1",
                contact = @Contact(
                        name="Sachin Kumar",
                        email="sk31817@gmail.com"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Sharepint URL PROduct Service API",
                url = "testing.com"
        )

)
@SpringBootApplication
public class ProductApplication {

    public static void main(String[] args) {


        SpringApplication.run(ProductApplication.class, args);



    }




}
