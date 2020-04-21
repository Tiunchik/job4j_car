/**
 * Package spring.accident.controllers for
 *
 * @author Maksim Tiunchik
 */
package spring.accident.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import spring.accident.programm.Logic;

/**
 * Class AccidentController - main web controller
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 20.04.2020
 */
@Controller
public class AccidentController {
    private static final Logger LOG = LogManager.getLogger(AccidentController.class.getName());

    /**
     * link to busness logic class
     */
    private Logic logic;

    @Autowired
    public void setLogic(Logic logic) {
        this.logic = logic;
    }

    @GetMapping("/main")
    public String getMainPage(ModelMap model) {
        model.addAttribute("accidents", logic.getAll());
        return "accident.jsp";
    }


}
