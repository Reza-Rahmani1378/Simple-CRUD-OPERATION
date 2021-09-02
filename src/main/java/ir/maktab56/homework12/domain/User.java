package ir.maktab56.homework12.domain;

import ir.maktab56.homework12.base.domain.BaseEntity;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.sql.Date;

@MappedSuperclass
public class User extends BaseEntity<Long> implements Serializable {
    private String firstName;

    private String lastName;

    private Date birthDay;

    public User() {
    }

    public User(String firstName, String lastName, Date birthDay) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
