/**
 * Package spring.accident.sprconfig for
 *
 * @author Maksim Tiunchik
 */
package spring.accident.sprconfig;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Class SpringFolderScan -
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 20.04.2020
 */
@Configuration
@ComponentScan(basePackages = {"spring.accident.models", "spring.accident.programm"})
public class SpringFolderScan {
    private static final Logger LOG = LogManager.getLogger(SpringFolderScan.class.getName());

}
