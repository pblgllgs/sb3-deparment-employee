package com.pblgllgs.restfulapi.config;
/*
 *
 * @author pblgl
 * Created on 19-11-2024
 *
 */

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
