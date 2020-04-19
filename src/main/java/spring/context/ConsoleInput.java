/**
 * Package spring.context for
 *
 * @author Maksim Tiunchik
 */
package spring.context;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * Class ConsoleInput - class for work with user via console
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 19.04.2020
 */
@Component
public class ConsoleInput {

    /**
     * inner logger
     */
    private static final Logger LOG = LogManager.getLogger(ConsoleInput.class.getName());

    /**
     * read answers of user in console
     */
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    /**
     * write text to user via console
     */
    private static final BufferedWriter WRITER = new BufferedWriter(new OutputStreamWriter(System.out));

    /**
     * ask user and get his answer
     *
     * @param question question to user
     * @return answer from user
     */
    public String askUsr(String question) {
        try {
            WRITER.write(question + "\n");
            WRITER.flush();
            return READER.readLine();
        } catch (IOException io) {
            LOG.error("IO error", io);
        }
        return null;
    }

}
