/**
 * Package spring.accident.database for
 *
 * @author Maksim Tiunchik
 */

package spring.accident.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import spring.accident.models.Accident;
import spring.accident.models.PartID;
import spring.accident.models.Participant;

import java.util.List;

/**
 * Interface ParticipantRepository -
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 26.04.2020
 */
public interface ParticipantRepository extends PagingAndSortingRepository<Participant, PartID> {

    List<Participant> findByAccidents(Accident accident);

}
