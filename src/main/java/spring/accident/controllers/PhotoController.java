package spring.accident.controllers;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import spring.accident.database.DataService;
import spring.accident.models.Accident;
import spring.accident.models.Photo;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Class PhotoController -
 *
 * @author Maksim Tiunchik (senebh@gmail.com)
 * @version 0.1
 * @since 16.05.2020
 */
@Controller
public class PhotoController {

    private final Logger log = LoggerFactory.getLogger(PhotoController.class);

    @Autowired
    DataService repository;

    /**
     * load photo from database for viewing
     *
     * @param id accident id number
     * @param response servlet responce for sending photo bytes
     * @throws IOException -
     */
    @GetMapping("/load/{id}")
    public void getPhoto(@PathVariable int id, HttpServletResponse response) throws IOException {
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        Accident accident = new Accident();
        accident.setId(id);
        Photo photo = repository.findByAccident(accident);
        IOUtils.copy(new ByteArrayInputStream(photo.getPhoto()), response.getOutputStream());
    }
}
