package ir.maktab56.homework12.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = Student.TABLE_NAME)
public class Student extends User {
    public static final String TABLE_NAME = "student_table";
    public static final String STUDENT_CODE = "student_code";

    @Column(name = STUDENT_CODE)
    private String studentCode;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private List<Address> addresses = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "student_teacher_join_table",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "id"))
    private Set<Teacher> teachers = new HashSet<>();

    public Student() {

    }

    public Student(String firstName, String lastName, String studentCode, Date birthDay) {
        super(firstName, lastName, birthDay);
        this.studentCode = studentCode;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + getFirstName() + '\'' +
                "lastName='" + getLastName() + '\'' +
                "studentCode='" + studentCode + '\'' +
                '}';
    }
}
