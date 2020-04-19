/**
 * Package spring.context for
 *
 * @author Maksim Tiunchik
 */
package spring.context;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * Class StartUI -
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 19.04.2020
 */
@Component
public class StartUI {

    private static final Logger LOG = LogManager.getLogger(StartUI.class.getName());

    private final Store store;

    private final ConsoleInput input;

    public StartUI(Store store, ConsoleInput input) {
        this.store = store;
        this.input = input;
    }

    public void add(String question) {
        String value = input.askUsr(question);
        if (value != null) {
            store.add(value);
        }
    }

    public void print() {
        for (String value : store.getAll()) {
            System.out.println(value);
        }
    }
}
