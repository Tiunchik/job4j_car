/**
 * Package spring.accident.controllers for
 *
 * @author Maksim Tiunchik
 */
package spring.accident.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import spring.accident.models.Accident;
import spring.accident.models.Participant;
import spring.accident.programm.Logic;

import java.lang.reflect.Parameter;
import java.util.List;

/**
 * Class InfoController -
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 26.04.2020
 */
@Controller
public class InfoController {
    private static final Logger LOG = LogManager.getLogger(InfoController.class.getName());

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
    public InfoController(Logic logic) {
        this.logic = logic;
    }

    /**
     * get info list of accident
     *
     * @param model model, contains req/resp info
     * @param id    id of accident
     * @return info.html list
     */
    @GetMapping(path = {"/info/{id}"})
    public String getInfoPage(
            ModelMap model,
            @PathVariable int id) {
        Accident accident = logic.findAccidentById(id);
        List<Participant> list = logic.findByAccidents(accident);
        model.addAttribute("accident", accident);
        model.addAttribute("partisipants", list);
        return "info";
    }

    /**
     * add participant to accident
     *
     * @param participant collected by spring from sent request
     * @param id          id of accient
     * @param model       model, contains req/resp info
     * @return info.html list
     */
    @PostMapping(path = {"/info/{id}"})
    public String saveComment(
            @ModelAttribute("partisipant") Participant participant,
            @PathVariable int id,
            ModelMap model) {
        logic.savePartisipant(participant);
        Accident accident = logic.findAccidentById(id);
        List<Participant> list = logic.findByAccidents(accident);
        model.addAttribute("accident", accident);
        model.addAttribute("partisipants", list);
        return "info";
    }
}
