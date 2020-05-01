/**
 * Package spring.accident.models for
 *
 * @author Maksim Tiunchik
 */
package spring.accident.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


/**
 * Class Officer - model of data for officer
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 25.04.2020
 */
@Entity
@Component
public class Officer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int docserial;

    private String ofFirstName;

    private String ofSecondName;

    private String ofRang;

    @Column(unique = true)
    private String login;

    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;

    @OneToMany(mappedBy = "officer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Accident> accidents = new HashSet<>();

    public int getDocserial() {
        return docserial;
    }

    public void setDocserial(int docserial) {
        this.docserial = docserial;
    }

    public String getOfFirstName() {
        return ofFirstName;
    }

    public void setOfFirstName(String ofFirstName) {
        this.ofFirstName = ofFirstName;
    }

    public String getOfSecondName() {
        return ofSecondName;
    }

    public void setOfSecondName(String ofSecondName) {
        this.ofSecondName = ofSecondName;
    }

    public String getOfRang() {
        return ofRang;
    }

    public void setOfRang(String ofRang) {
        this.ofRang = ofRang;
    }

    public Set<Accident> getAccidents() {
        return accidents;
    }

    public void setAccidents(Set<Accident> accidents) {
        this.accidents = accidents;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Officer officer = (Officer) o;
        return docserial == officer.docserial
                && Objects.equals(ofFirstName, officer.ofFirstName)
                && Objects.equals(ofSecondName, officer.ofSecondName)
                && Objects.equals(ofRang, officer.ofRang);
    }

    @Override
    public int hashCode() {
        return Objects.hash(docserial, ofFirstName, ofSecondName, ofRang);
    }

    @Override
    public String toString() {
        return "User{"
                + "docserial=" + docserial
                + ", ofFirstName='" + ofFirstName + '\''
                + ", ofSecondName='" + ofSecondName + '\''
                + ", ofRang='" + ofRang + '\''
                + '}';
    }
}
