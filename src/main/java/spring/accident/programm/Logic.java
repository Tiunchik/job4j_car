/**
 * Package spring.accident.programm for
 *
 * @author Maksim Tiunchik
 */
package spring.accident.programm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import spring.accident.database.DataService;
import spring.accident.models.Accident;
import spring.accident.models.Officer;
import spring.accident.models.Participant;

import java.util.LinkedList;
import java.util.List;

/**
 * Class Logic - main class that contains logic of application
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 20.04.2020
 */
@Service
@Scope("singleton")
@Qualifier("logic")
public class Logic {

    /**
     * inner logger
     */
    private static final Logger LOG = LogManager.getLogger(Logic.class.getName());

    /**
     * link to database
     */
    @Autowired
    private DataService base;

    /**
     * Constructor, set base
     *
     * @param base DataService example
     */
    public Logic(DataService base) {
        this.base = base;
    }

    /**
     * provide full list of saved accidents
     *
     * @return list of saved accidents
     */
    public List<Accident> getAll() {
        List<Accident> list = new LinkedList<>();
        base.findAllAccidents().forEach(list::add);
        return list;
    }

    /**
     * save or update accident
     *
     * @param accident accient for saving or updating
     * @return saved accident
     */
    public Accident saveAccident(Accident accident) {
        return base.saveAccident(accident);
    }

    /**
     * find accident by ID
     *
     * @param id id of searched accident
     * @return inded accident or null
     */
    public Accident findAccidentById(int id) {
        return base.findAccidentById(id);
    }

    /**
     * check is there officer thath have passed login and password and return example of finded object r null
     *
     * @param login login of officer
     * @param password password of officer
     * @return example of officer or null
     */
    public Officer checkUser(String login, String password) {
        Officer officer = base.findOfficerByLogin(login);
        if (officer != null && officer.getPassword().equals(password)) {
            return officer;
        }
        return null;
    }

    /**
     * find list of partisipants that hold to certian accident
     *
     * @param accident accident for searching
     * @return list pf partisipants
     */
    public List<Participant> findByAccidents(Accident accident) {
        return base.findByAccidents(accident);
    }

    /**
     * save partrispant to database
     *
     * @param participant partisipant for saving
     */
    public void savePartisipant(Participant participant) {
        base.saveParticipant(participant);
    }

    /**
     * find officer by login
     *
     * @param login login of officer
     * @return officer or null
     */
    public Officer findByLogin(String login) {
        return base.findByLogin(login);
    }
}
