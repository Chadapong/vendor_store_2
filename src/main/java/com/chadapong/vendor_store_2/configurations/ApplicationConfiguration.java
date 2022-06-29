package com.chadapong.vendor_store_2.configurations;



import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@Configuration
@EnableJpaRepositories(basePackages = {"com.chadapong.repositories"})
@EntityScan(basePackages={"com.chadapong.models"})

@ComponentScan(basePackages = {"com.chadapong.vendor_store_2.services","package com.chadapong.exceptions"})
public class ApplicationConfiguration {

  
}
