/**
 * Package spring.accident.models for
 *
 * @author Maksim Tiunchik
 */
package spring.accident.models;

import org.springframework.stereotype.Component;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Class Participant - model of data for participant
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 25.04.2020
 */
@Entity
@Component
public class Participant {

    @EmbeddedId
    private PartID iddata;

    private String description;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Accident> accidents = new HashSet<>();

    public PartID getIddata() {
        return iddata;
    }

    public void setIddata(PartID iddata) {
        this.iddata = iddata;
    }

    public Set<Accident> getAccidents() {
        return accidents;
    }

    public void setAccidents(Set<Accident> accidents) {
        this.accidents = accidents;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Participant that = (Participant) o;
        return Objects.equals(iddata, that.iddata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iddata);
    }

    @Override
    public String toString() {
        return "Participant{"
                + "iddata=" + iddata
                + '}';
    }
}
