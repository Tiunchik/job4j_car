/**
 * Package spring.accident.models for
 *
 * @author Maksim Tiunchik
 */
package spring.accident.models;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

/**
 * Class PartID - embendded part of partisipant
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 26.04.2020
 */
@Embeddable
@Component
public class PartID implements Serializable {

    private String firstName;

    private String secondName;

    private int passport;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getPassport() {
        return passport;
    }

    public void setPassport(int passport) {
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PartID partID = (PartID) o;
        return passport == partID.passport
                && Objects.equals(firstName, partID.firstName)
                && Objects.equals(secondName, partID.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, passport);
    }

    @Override
    public String toString() {
        return "PartID{"
                + "firstName='" + firstName + '\''
                + ", secondName='" + secondName + '\''
                + ", passport=" + passport
                + '}';
    }
}
