/**
 * Package spring.accident.database for
 *
 * @author Maksim Tiunchik
 */

package spring.accident.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import spring.accident.models.Officer;

/**
 * Interface OfficerRepository -
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 26.04.2020
 */
public interface OfficerRepository extends PagingAndSortingRepository<Officer, Integer> {

    Officer findByLogin(String login);

}
