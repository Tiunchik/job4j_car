package spring.accident.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

/**
 * Class Photo - data model for accident photos
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 16.05.2020
 */
@Entity
@Component
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    private Accident accident;

    @Column(nullable = false)
    private byte[] photo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Accident getAccident() {
        return accident;
    }

    public void setAccident(Accident accident) {
        this.accident = accident;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Photo photo1 = (Photo) o;
        return id == photo1.id
                && accident.equals(photo1.accident)
                && Arrays.equals(photo, photo1.photo);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, accident);
        result = 31 * result + Arrays.hashCode(photo);
        return result;
    }
}
