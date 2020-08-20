package cm.beni.main.julia.security.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins(new String[] { "http://localhost:4200" }).allowedMethods("GET",
				"POST");
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**").allowedOrigins(new String[] { "http://localhost:4200" })
//						.allowedMethods(new String[] { "GET", "POST" });
//			}
//		};
//	}
}
