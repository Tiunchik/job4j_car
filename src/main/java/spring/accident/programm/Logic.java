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
import org.springframework.stereotype.Component;
import spring.accident.models.Accident;

import java.util.List;

/**
 * Class Logic - main class that contains logic of application
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 20.04.2020
 */
@Component
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
    private DataBase base;

    /**
     * setter for base - for spring actions
     *
     * @param base link to DB
     */
    @Autowired
    public void setBase(DataBase base) {
        this.base = base;
    }

    /**
     * provide full list of saved accidents
     *
     * @return list of saved accidents
     */
    public List<Accident> getAll() {
        return base.getAll();
    }

}
