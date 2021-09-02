package ir.maktab56.homework12.util;

import com.github.javafaker.Faker;
import ir.maktab56.homework12.domain.Address;
import ir.maktab56.homework12.service.AddressService;

import java.util.stream.IntStream;

public class InsertTable {

    /*public static void insertTeacher() {
        TeacherService teacherService = ApplicationContext.getTeacherService();
        Faker faker = new Faker();
        IntStream.range(0, 15).forEach(i -> {
            Teacher teacher = new Teacher();
            teacher.setFirstName(
                    faker.name().firstName()
            );
            teacher.setLastName(
                    faker.name().lastName()
            );
            teacher.setSalary(
                    faker.number().randomDouble(19 , 1L , 10000000L)
            );
            teacher.setTeacherCode(
                    UUID.randomUUID().toString()
            );
            teacher.setBirthDay(
                    faker.date().birthday()
            );

            teacherService.save(teacher);
        });
    }*/

    /*public static void insertStudent() {
        StudentService studentService = ApplicationContext.getStudentService();
        Faker faker = new Faker();
        IntStream.range(0,15).forEach( i -> {
            Student student = new Student();
            student.setFirstName(
                    faker.name().firstName()
            );
            student.setLastName(
                    faker.name().lastName()
            );
            student.setStudentCode(
                    UUID.randomUUID().toString()
            );
            student.setBirthDay(
                    faker.date().birthday()
            );
        });
    }*/

    public static void insertAddress() {
        AddressService addressService = ApplicationContext.getAddressService();
        Faker faker = new Faker();
        IntStream.range(0, 15).forEach(i -> {
            Address address = new Address();
            address.setNumber(
                    faker.phoneNumber().phoneNumber()
            );
            address.setPostalAddress(
                    faker.address().streetAddress()
//                    faker.address().streetAddressNumber()
            );
            address.setPostalCode(
                    faker.address().zipCode()
            );
            address.setCity(
                    faker.address().city()
            );
            address.setState(
                    faker.address().state()
            );
        });
    }
}
