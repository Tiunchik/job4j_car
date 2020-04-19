/**
 * Package spring.context for
 *
 * @author Maksim Tiunchik
 */
package spring.context;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Store -
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 19.04.2020
 */
public class Store {
    /**
     * Array store
     */
    private final List<String> data = new ArrayList<String>();

    /**
     * put to array
     *
     * @param value putted value
     */
    public void add(String value) {
        data.add(value);
    }

    /**
     * get all positions from array
     *
     * @return all positions that is contained into array
     */
    public List<String> getAll() {
        return data;
    }

}
