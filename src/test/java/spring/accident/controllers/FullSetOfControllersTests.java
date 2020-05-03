package spring.accident.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import spring.accident.database.DataService;
import spring.accident.models.Accident;
import spring.accident.models.Officer;
import spring.accident.models.PartID;
import spring.accident.models.Participant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@ComponentScan(basePackages = {"spring.accident.controllers"})
@SpringBootTest
@AutoConfigureMockMvc
public class FullSetOfControllersTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    DataService service;

    @Test
    @WithAnonymousUser
    public void whenGetLoginPageThenCheckContent() throws Exception {
        this.mvc.perform(
                get("/login").accept(MediaType.TEXT_HTML)
        )
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void whenGetAccidentPageThenCheckContent() throws Exception {
        List<Accident> temp = List.of(getAccident());

        given(this.service.findAllAccidents()).willReturn(temp);

        this.mvc.perform(
                get("/main").accept(MediaType.TEXT_HTML)
        )
                .andExpect(status().isOk())
                .andExpect(view().name("accident"));
        verify(this.service, times(1)).findAllAccidents();
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void whenAddNewAccidentToDBThenLoadAccidentPage() throws Exception {
        List<Accident> temp = List.of(getAccident());

        given(this.service.findByLogin("admin")).willReturn(getOfficer());

        given(this.service.findAllAccidents()).willReturn(temp);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.setAll(Map.of(
                "name", "Авария на мосту",
                "address", "Авария на мосту",
                "text", "Авария на мосту",
                "gettime", "2020-10-10T11:11"));

        this.mvc.perform(
                post("/main/add").params(map))
                .andExpect(status().isOk())
                .andExpect(view().name("accident"));

        verify(this.service, times(1)).findByLogin("admin");
        verify(this.service, times(1)).findAllAccidents();

    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void whenGetChagePageThenCheckStatus() throws Exception {

        given(this.service.findAccidentById(1)).willReturn(getAccident());

        this.mvc.perform(
                get("/change/1").accept(MediaType.TEXT_HTML)
        )
                .andExpect(status().isOk())
                .andExpect(view().name("change"));

        verify(this.service, times(1)).findAccidentById(1);
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void whenPostChagePageThenCheckStatus() throws Exception {

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.setAll(Map.of(
                "id", "1",
                "name", "Авария на мосту",
                "address", "Авария на мосту",
                "text", "Авария на мосту",
                "gettime", "2020-10-10T11:11"
        ));

        given(this.service.findAccidentById(1)).willReturn(getAccident());

        this.mvc.perform(
                post("/change").params(map)
        )
                .andExpect(status().isOk())
                .andExpect(view().name("accident"));

        verify(this.service, times(1)).findAccidentById(1);
        verify(this.service, times(1)).saveAccident(getAccident());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void whenGetTheInfoPageThenCheckStatus() throws Exception {
        List<Participant> temp = new ArrayList<>();

        given(this.service.findAccidentById(1)).willReturn(getAccident());

        given(this.service.findByAccidents(getAccident())).willReturn(temp);

        this.mvc.perform(
                get("/info/1").accept(MediaType.TEXT_HTML)
        )
                .andExpect(status().isOk())
                .andExpect(view().name("info"));

        verify(this.service, times(1)).findAccidentById(1);
        verify(this.service, times(1)).findByAccidents(getAccident());

    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void whenPostTheInfoPageThenCheckStatus() throws Exception {
        List<Participant> temp = new ArrayList<>();

        given(this.service.findAccidentById(1)).willReturn(getAccident());

        given(this.service.findByAccidents(getAccident())).willReturn(temp);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.setAll(Map.of(
                "iddata.firstName", "Pavel",
                "iddata.secondName", "Vasiliev",
                "iddata.passport", "4015",
                "description", "Driver"

        ));

        this.mvc.perform(
                post("/info/1").params(map)
        )
                .andExpect(status().isOk())
                .andExpect(view().name("info"));


        verify(this.service, times(1)).saveParticipant(getParticipant());
        verify(this.service, times(1)).findAccidentById(1);
        verify(this.service, times(1)).findByAccidents(getAccident());

    }

    private Officer getOfficer() {
        Officer officer = new Officer();
        officer.setLogin("admin");
        officer.setPassword("admin");
        officer.setDocserial(1);
        officer.setOfFirstName("Kokh");
        officer.setOfSecondName("Shredinger");
        return officer;
    }


    private Accident getAccident() {
        Accident accident = new Accident();
        accident.setId(1);
        accident.setName("Авария на мосту");
        accident.setText("Авария на мосту");
        accident.setAddress("Авария на мосту");
        accident.setOfficer(getOfficer());
        return accident;
    }

    private Participant getParticipant() {
        Participant part = new Participant();
        PartID id = new PartID();
        id.setFirstName("Pavel");
        id.setSecondName("Vasiliev");
        id.setPassport(4015);
        part.setIddata(id);
        part.setDescription("Driver");
        return part;
    }
}