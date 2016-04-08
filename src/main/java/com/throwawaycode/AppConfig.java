package com.throwawaycode;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

@org.springframework.context.annotation.Configuration
public class AppConfig {
    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();

        String pathToExternalProperties = System.getProperty("properties.via.commandline");
        if (pathToExternalProperties != null) {
            addExternalAndAppProperties(propertyPlaceholderConfigurer, pathToExternalProperties);
        } else {
            onlyAddApplicationProperties(propertyPlaceholderConfigurer);
        }

        return propertyPlaceholderConfigurer;
    }

    private void addExternalAndAppProperties(PropertyPlaceholderConfigurer propertyPlaceholderConfigurer,
                                             String pathToExternalProperties) {

        propertyPlaceholderConfigurer.setLocations(new ClassPathResource("/application.properties"),
                new FileSystemResource(pathToExternalProperties));
    }

    private void onlyAddApplicationProperties(PropertyPlaceholderConfigurer propertyPlaceholderConfigurer) {
        propertyPlaceholderConfigurer.setLocations(new ClassPathResource("/application.properties"));
    }
}
