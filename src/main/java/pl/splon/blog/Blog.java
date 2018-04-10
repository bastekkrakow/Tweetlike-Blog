package pl.splon.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EntityScan(
		basePackageClasses = {Blog.class, Jsr310JpaConverters.class}
)

@EnableAsync
public class Blog {
	public static void main(String[] args) {
		SpringApplication.run(Blog.class, args);
	}
}
