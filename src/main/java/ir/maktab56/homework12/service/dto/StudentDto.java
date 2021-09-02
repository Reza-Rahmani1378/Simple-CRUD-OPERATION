package ir.maktab56.homework12.service.dto;

import ir.maktab56.homework12.domain.Address;
import ir.maktab56.homework12.domain.Teacher;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentDto {
    private String firstName;

    private String lastName;

    private String studentCode;

    private Date birthDay;
    private List<Address> addresses = new ArrayList<>();
    private Set<Teacher> teachers = new HashSet<>();

    public StudentDto() {

    }

    public StudentDto(String firstName, String lastName, String studentCode, Date birthDay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentCode = studentCode;
        this.birthDay = birthDay;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
