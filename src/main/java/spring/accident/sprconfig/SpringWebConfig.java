/**
 * Package spring.accident.sprconfig for
 *
 * @author Maksim Tiunchik
 */
package spring.accident.sprconfig;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


/**
 * Class SpringWebConfig -
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 20.04.2020
 */
@EnableWebMvc
@Configuration
@ComponentScan("spring.accident.controllers")
public class SpringWebConfig implements WebMvcConfigurer {
    private static final Logger LOG = LogManager.getLogger(SpringWebConfig.class.getName());

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver view = new InternalResourceViewResolver();
        view.setViewClass(JstlView.class);
        view.setPrefix("/WEB-INF/views/");
        //view.setSuffix(".jsp");
        return view;
    }
}
