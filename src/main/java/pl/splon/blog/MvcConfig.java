package pl.splon.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import pl.splon.blog.models.handlers.LoginHandler;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

     final LoginHandler loginHandler;

    @Autowired
    public MvcConfig(LoginHandler loginHandler) {
        this.loginHandler = loginHandler;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginHandler);
    }
}
