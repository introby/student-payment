package by.intro.student.business;

import by.intro.student.dao.*;
import by.intro.student.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentOrderService {

    private static final Logger LOG = LoggerFactory.getLogger(StudentOrderService.class);

    @Autowired
    private StudentOrderRepository dao;
    @Autowired
    private StreetRepository daoStreet;
    @Autowired
    private StudentOrderStatusRepository daoStatus;
    @Autowired
    private PassportOfficeRepository daoPassport;
    @Autowired
    private RegisterOfficeRepository daoRegister;
    @Autowired
    private UniversityRepository daoUniversity;

    @Transactional
    public void testSave() {
        StudentOrder so = new StudentOrder();
        so.setStudentOrderDate(LocalDateTime.now());
        so.setStatus(daoStatus.getById(1L));

        Adult wife = buildPerson(true);
        Adult husband = buildPerson(false);
        so.setWife(wife);
        so.setHusband(husband);

        so.setCertificateNumber("CERTIFICATE");
        so.setRegisterOffice(daoRegister.getById(1L));
        so.setMarriageDate(LocalDate.now());

        dao.save(so);
    }

    @Transactional
    public void testGet() {
        List<StudentOrder> sos = dao.findAll();
        LOG.info(sos.get(0).getWife().getGivenName());
    }

    private Adult buildPerson(boolean wife) {
        Adult a = new Adult();
        a.setDateOfBirthday(LocalDate.now());
        Address address = new Address();
        address.setPostCode("190000");
        address.setBuilding("22");
        address.setExtension("B");
        address.setApartment("199");
        Street one = daoStreet.getById(1L);
        address.setStreet(one);
        a.setAddress(address);
        if (wife) {
            a.setSurName("Рюрик");
            a.setGivenName("Марфа");
            a.setPatronymic("Васильевна");
            a.setPassportSeries("WIFE_S");
            a.setPassportNumber("WIFE_N");
            a.setPassportOffice(daoPassport.getById(1L));
            a.setPassportIssueDate(LocalDate.now());
            a.setStudentNumber("12345");
            a.setUniversity(daoUniversity.getById(1L));
        } else {
            a.setSurName("Рюрик");
            a.setGivenName("Иван");
            a.setPatronymic("Васильевич");
            a.setPassportSeries("HUSBAND_S");
            a.setPassportNumber("HUSBAND_N");
            a.setPassportOffice(daoPassport.getById(1L));
            a.setPassportIssueDate(LocalDate.now());
            a.setStudentNumber("67890");
            a.setUniversity(daoUniversity.getById(1L));
        }

        return a;

    }
}
