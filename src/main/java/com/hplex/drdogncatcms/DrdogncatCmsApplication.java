package com.hplex.drdogncatcms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DrdogncatCmsApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DrdogncatCmsApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(DrdogncatCmsApplication.class, args);
    }

}
