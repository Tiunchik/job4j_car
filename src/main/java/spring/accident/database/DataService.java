/**
 * Package spring.accident.programm for
 *
 * @author Maksim Tiunchik
 */
package spring.accident.database;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import spring.accident.models.Accident;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Class DataService -
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 21.04.2020
 */
@Service
@Scope("singleton")
@Transactional
public class DataService {

    @Autowired
    AccidentRepository accidentRepository;

    public List<Accident> findAll() {
        return Lists.newArrayList(accidentRepository.findAll());
    }

    public Accident save(Accident accident) {
        return accidentRepository.save(accident);
    }

}
