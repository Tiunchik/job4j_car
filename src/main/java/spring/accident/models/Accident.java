/**
 * Package spring.accident.models for
 *
 * @author Maksim Tiunchik
 */
package spring.accident.models;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Class Accident - data model for accidents
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 20.04.2020
 */

@Component
@Scope("prototype")
public class Accident {
    private static final Logger LOG = LogManager.getLogger(Accident.class.getName());

    private int id;

    private String name;

    private String text;

    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Accident accident = (Accident) o;
        return id == accident.id
                && Objects.equals(name, accident.name)
                && Objects.equals(text, accident.text)
                && Objects.equals(address, accident.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, text, address);
    }

    @Override
    public String toString() {
        return "Accident{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", text='" + text + '\''
                + ", address='" + address + '\''
                + '}';
    }
}
