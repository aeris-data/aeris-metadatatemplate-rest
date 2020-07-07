package fr.aeris.metadatatemplate.rest;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableScheduling
@ComponentScan(basePackages = { "fr.aeris.metadatatemplate" })
public class MetadataTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetadataTemplateApplication.class, args);
	}

	@Bean
	public Filter etagFilter() {
		return new ShallowEtagHeaderFilter();
	}

}
