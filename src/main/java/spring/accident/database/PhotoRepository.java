package spring.accident.database;

import org.springframework.data.repository.PagingAndSortingRepository;
import spring.accident.models.Accident;
import spring.accident.models.Photo;

/**
 * Interface PhotoRepository -
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 16.05.2020
 */
public interface PhotoRepository extends PagingAndSortingRepository<Photo, Integer> {

    Photo findByAccident(Accident accident);

}
