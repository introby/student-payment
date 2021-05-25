package by.intro.student.domain;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Embeddable
public class Adult extends Person {

    private String passportSeries;
    private String passportNumber;
    private LocalDate passportIssueDate;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private PassportOffice passportOffice;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private University university;
    private String studentNumber;



    public String getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public LocalDate getPassportIssueDate() {
        return passportIssueDate;
    }

    public void setPassportIssueDate(LocalDate passportIssueDate) {
        this.passportIssueDate = passportIssueDate;
    }

    public PassportOffice getPassportOffice() {
        return passportOffice;
    }

    public void setPassportOffice(PassportOffice passportOffice) {
        this.passportOffice = passportOffice;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }
}
