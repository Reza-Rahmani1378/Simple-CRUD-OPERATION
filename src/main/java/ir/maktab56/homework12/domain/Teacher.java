package ir.maktab56.homework12.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = Teacher.TABLE_NAME)
public class Teacher extends User {
    public static final String TABLE_NAME = "teacher_table";
    public static final String TEACHER_CODE = "teacher_code";
    public static final String SALARY = "salary";
    public static final String BIRTH_DAY = "birth_day";
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "teacher_student_join_table",
            joinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id")
    )
    Set<Student> students = new HashSet<>();
    /*@Embedded
    private User user;*/
    @Column(name = TEACHER_CODE, unique = true, nullable = false)
    private String teacherCode;
    @Column(name = SALARY, precision = 19, scale = 5, columnDefinition = "DECIMAL(19,5)")
    private Double salary;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    public Teacher() {

    }

    public Teacher(String firstName, String lastName, String teacherCode, Double salary, Date birthDay) {
        super(firstName, lastName, birthDay);
        this.teacherCode = teacherCode;
        this.salary = salary;
    }

    public Teacher(String firstName, String lastName, String teacherCode, Double salary, Date birthDay, Address address) {
        super(firstName, lastName, birthDay);
        this.teacherCode = teacherCode;
        this.salary = salary;
        this.address = address;
    }


    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + getId() + '\'' +
                "firstName='" + getFirstName() + '\'' +
                "lastName='" + getLastName() + '\'' +
                "teacherCode='" + teacherCode + '\'' +
                ", salary=" + salary +
                ", Address=" + address +
                '}';
    }

    /*public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/

    public String getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
