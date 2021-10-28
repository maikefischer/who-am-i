package com.who.am.i.game.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean(name = "dtoMapper")
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
