/**
 * Package spring.beans for
 *
 * @author Maksim Tiunchik
 */
package spring.beans;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.context.ConsoleInput;
import spring.context.StartUI;
import spring.context.Store;

/**
 * Class SpringDi - first using of Spring Context class
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 19.04.2020
 */
public class SpringDi {

    /**
     * main
     *
     * @param args args
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Store.class);
        context.register(ConsoleInput.class);
        context.register(StartUI.class);
        context.refresh();

        StartUI ui = context.getBean(StartUI.class);

        ui.add("Please write a word");
        ui.print();

    }

}
