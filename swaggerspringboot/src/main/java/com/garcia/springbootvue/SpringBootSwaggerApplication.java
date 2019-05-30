package com.garcia.springbootvue;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class SpringBootSwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSwaggerApplication.class, args);
	}

	// Bootstrap some test data into the in-memory database
    @Bean
    ApplicationRunner init(PostRepository repository) {  
        return args -> {  
            Stream.of("1", "2", "3", "4", "5").forEach(name -> {  
                    Post post = new Post();  
                    post.setTitle("Title "+name);
                    post.setMessage("Message "+name); 
                    repository.save(post);  
            });  
            repository.findAll().forEach(System.out::println);  
        };  
    }  
    
	//Permit local from the CORS
//	@Bean
//	public FilterRegistrationBean simpleCorsFilter() {
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		CorsConfiguration config = new CorsConfiguration();
//		config.setAllowCredentials(true);
//		// *** URL below needs to match the Vue client URL and port ***
//		config.setAllowedOrigins(Collections.singletonList("http://localhost:8080"));
//		config.setAllowedMethods(Collections.singletonList("*"));
//		config.setAllowedHeaders(Collections.singletonList("*"));
//		source.registerCorsConfiguration("/**", config);
//		FilterRegistrationBean bean = new FilterRegistrationBean<>(new CorsFilter(source));
//		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
//		return bean;
//	}
	
//	@Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//            	registry.addMapping("/**")
//                .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
//            }
//        };
//    }
}
