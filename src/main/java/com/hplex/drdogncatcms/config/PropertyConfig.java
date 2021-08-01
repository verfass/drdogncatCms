package com.hplex.drdogncatcms.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@RequiredArgsConstructor
@PropertySource("classpath:drdogncatcms/properties/system.properties")
public class PropertyConfig {

    private final Environment environment;		// 빈 주입을 받습니다.

    public String getProperty(String key){
        return environment.getProperty(key);
    }

}
