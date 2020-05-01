/**
 * Package spring.accident.controllers for
 *
 * @author Maksim Tiunchik
 */
package spring.accident.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Class AccessController - controller for login
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 24.04.2020
 */
@Controller
public class AccessController {

    /**
     * provide logic page
     *
     * @return
     */
    @GetMapping(path = {"/login"})
    public String getLogicPage() {
        return "login";
    }
}
