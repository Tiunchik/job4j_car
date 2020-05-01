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
import spring.accident.models.Officer;
import spring.accident.models.Participant;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Class DataService - class for providing access to database
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

    @Autowired
    OfficerRepository officerRepository;

    @Autowired
    ParticipantRepository participantRepository;

    public List<Accident> findAllAccidents() {
        return Lists.newArrayList(accidentRepository.findAll());
    }

    public Accident saveAccident(Accident accident) {
        return accidentRepository.save(accident);
    }

    public Accident findAccidentById(int id) {
        var acc = accidentRepository.findById(id).get();
        return acc;
    }

    public Officer findOfficerByLogin(String login) {
        return officerRepository.findByLogin(login);
    }

    public List<Participant> findByAccidents(Accident accident) {
        return participantRepository.findByAccidents(accident);
    }

    public Optional<Participant> getPartisipant(Participant participant) {
        return participantRepository.findById(participant.getIddata());
    }

    public Participant saveParticipant(Participant participant) {
        return participantRepository.save(participant);
    }

    public Officer findByLogin(String login) {
        return officerRepository.findByLogin(login);
    }

}
