/**
 * Package spring.context for
 *
 * @author Maksim Tiunchik
 */
package spring.context;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class Main - simple start class for manual check for context action
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 19.04.2020
 */
public class Main {

    private static final Logger LOG = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Context context = new Context();
        context.reg(Store.class);
        context.reg(ConsoleInput.class);
        context.reg(StartUI.class);

        StartUI ui = context.get(StartUI.class);

        ui.add("Please wtire a word");
        ui.print();
    }
}
