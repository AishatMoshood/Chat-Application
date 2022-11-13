package convinience_store.src.main.java.services;

import convinience_store.src.main.java.enums.Gender;
import convinience_store.src.main.java.enums.Qualification;
import convinience_store.src.main.java.models.Applicant;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerServiceTest {

    @Test
    void hire() {
        Applicant applicant = new Applicant(2,"Abdul", Gender.MALE,"ndgs@", Qualification.MSC,26);
        ManagerService managerService = new ManagerService();
        String actual = managerService.hire(applicant);
        String exp = "Congratulations Abdul you're hired";

        assertEquals(actual, exp);
    }
}