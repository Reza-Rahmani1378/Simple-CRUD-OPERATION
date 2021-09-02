package ir.maktab56.homework12.domain;

import ir.maktab56.homework12.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = Address.TABLE_NAME)
public class Address extends BaseEntity<Long> {
    public static final String TABLE_NAME = "address_table";
    public static final String NUMBER = "number";
    public static final String STATE_NAME = "state_name";
    public static final String CITY_NAME = "city_name";
    public static final String POSTAL_ADDRESS_NAME = "postal_address";
    public static final String POSTAL_CODE_NAME = "postal_code";


    @Column(name = NUMBER, nullable = false)
    private String number;

    @Column(name = STATE_NAME)
    private String state;

    @Column(name = CITY_NAME)
    private String city;

    @Column(name = POSTAL_ADDRESS_NAME)
    private String postalAddress;

    @Column(name = POSTAL_CODE_NAME)
    private String postalCode;

    @OneToOne(mappedBy = "address")
    private Teacher teacher;


    /*@ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;*/


    public Address(String number, String state, String city, String postalAddress, String postalCode) {
        this.number = number;
        this.state = state;
        this.city = city;
        this.postalAddress = postalAddress;
        this.postalCode = postalCode;
    }

    public Address(String number, String state, String city, String postalAddress, String postalCode, Teacher teacher) {
        this(number, state, city, postalAddress, postalCode);
        this.postalCode = postalCode;
    }

    public Address() {

    }

    @Override
    public String toString() {
        return "Address{" +
                "number='" + number + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", postalAddress='" + postalAddress + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    /*public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }*/
}
