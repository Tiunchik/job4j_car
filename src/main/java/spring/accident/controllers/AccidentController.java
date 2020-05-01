/**
 * Package spring.accident.controllers for
 *
 * @author Maksim Tiunchik
 */
package spring.accident.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import spring.accident.models.Accident;
import spring.accident.models.Officer;
import spring.accident.programm.Logic;

import java.security.Principal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
     * link to business logic class
     */
    @Autowired
    private Logic logic;

    /**
     * constructor, set linj to Logic class
     *
     * @param logic logic
     */
    public AccidentController(Logic logic) {
        this.logic = logic;
    }

    /**
     * provide main page
     *
     * @param model model with data for thymeleaf
     * @return main page
     */
    @GetMapping(path = {"/", "/main"})
    public String getAccidentPage(
            ModelMap model) {
        model.addAttribute("accidents", logic.getAll());
        return "accident";
    }

    /**
     * execute adding of new accident to  database
     *
     * @param model     model, contains req/resp info
     * @param accident  collected by spring from sent request
     * @param time      get info from gettime row form request
     * @param principal inner information of session about current user
     * @return main page with added accident
     */
    @PostMapping(path = {"/main/add"})
    public String postMain(
            ModelMap model,
            @ModelAttribute("accident") Accident accident,
            @RequestParam("gettime") String time,
            Principal principal) {
        String login = principal.getName();
        Officer officer = logic.findByLogin(login);
        if (accident.getTime() == null) {
            accident.setTime(parseTime(time));
        }
        accident.setOfficer(officer);
        logic.saveAccident(accident);
        return getAccidentPage(model);
    }

    /**
     * change information about accident
     *
     * @param model    model, contains req/resp info
     * @param accident collected by spring from sended request
     * @param time     get info from gettime row form request
     * @return main page with changed accident
     */
    @PostMapping(path = {"/change"})
    public String getChangePage(
            ModelMap model,
            @RequestParam("gettime") String time,
            @ModelAttribute("accident") Accident accident) {
        Accident oldaccident = logic.findAccidentById(accident.getId());
        accident.setMembo(oldaccident.getMembo());
        if (accident.getTime() == null) {
            accident.setTime(parseTime(time));
        }
        logic.saveAccident(accident);
        return getAccidentPage(model);
    }

    /**
     * get list for changing
     *
     * @param model    model, contains req/resp info
     * @param id id of accident for changing
     * @return change.html list
     */
    @GetMapping(path = {"/change/{id}"})
    public String getChangePage(
            ModelMap model,
            @PathVariable int id) {
        Accident accident = logic.findAccidentById(id);
        model.addAttribute("accident", accident);
        return "change";
    }

    /**
     * inner method for parsing html date to sql timestamp
     *
     * @param time
     * @return
     */
    private Timestamp parseTime(String time) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
            Date parsedDate = dateFormat.parse(time);
            return new Timestamp(parsedDate.getTime());
        } catch (ParseException e) {
            LOG.error("Parse date error", e);
        }
        return null;
    }
}
