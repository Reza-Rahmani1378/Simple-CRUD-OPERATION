package ir.maktab56.homework12.util.menu;

import ir.maktab56.homework12.domain.Student;
import ir.maktab56.homework12.domain.Teacher;
import ir.maktab56.homework12.service.AddressService;
import ir.maktab56.homework12.service.StudentService;
import ir.maktab56.homework12.service.TeacherService;
import ir.maktab56.homework12.service.dto.AddressDto;
import ir.maktab56.homework12.service.dto.StudentDto;
import ir.maktab56.homework12.service.dto.TeacherDto;
import ir.maktab56.homework12.util.ApplicationContext;
import ir.maktab56.homework12.util.menu.input.Input;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputInformationMenu {
    //   EntityManager entityManager =  HibernateUtil.getEntityManagerFactory().createEntityManager();
//    private static final TeacherService teacherService;
//    private static final StudentService studentService;
//    private static final AddressService addressService ;
    private static final CheckMenu check;
    private static final String FIRSTNAME_REGEX = "(?i)(^[a-z]+)[a-z .,-]((?! .,-)$){1,25}$";
    private static final String LASTNAME_REGEX = "(?i)(^[a-z]+)[a-z .,-]((?! .,-)$){1,25}$";
    private static final String BIRTH_DAY_REGEX = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$";
    private static final String CODE_REGEX = "^\\d{10}$";
    private static final String PHONE_NUMBER_REGEX = "(0/91)?[7-9][0-9]{9}";
    private static final String FIRSTNAME_WARNING =
            "The first name is between 1 and 25 characters.\n" +
                    "The first name can only start with an a-z (ignore case) character.\n" +
                    "After that the first name can contain a-z (ignore case) and [ '-,.].\n" +
                    "The first name can only end with an a-z (ignore case) character.";
    private static final String LASTNAME_WARNING =
            "The last name is between 1 and 25 characters.\n" +
                    "The last name can only start with an a-z (ignore case) character.\n" +
                    "After that the last name can contain a-z (ignore case) and [ '-,.].\n" +
                    "The last name can only end with an a-z (ignore case) character.";
    private static final String BIRTH_DAY_WARNING = "Your BirthDay is Wrong.";
    private static final String CODE_WARNING =
            "Your national code must be 10 digit, at least one letter and one number.";
    private static final String PHONE_NUMBER_WARNING =
            "Your mobile number must be country specific.";
    private static final String FIRSTNAME_MESSAGE = "Enter your firstName :";
    private static final String LASTNAME_MESSAGE = "Enter your lastName :";
    private static final String BIRTH_DAY_MESSAGE = "Enter Your BirthDay in This format(2010-3-24) :";
    private static final String CODE_MESSAGE = "Enter your national code :";
    private static final String SALARY_MESSAGE = "Enter your salary :";
    private static final String PHONE_NUMBER_MESSAGE = "Enter your phone number :";
    private static final String STATE_MESSAGE = "Enter your state :";
    private static final String CITY_MESSAGE = "Enter your city :";
    private static final String POSTAL_ADDRESS_MESSAGE = "Enter your postal address :";
    private static final String POSTAL_CODE_MESSAGE = "Enter your postal code :";

    static {
        check = new CheckMenu();
       /* teacherService = ApplicationContext.getTeacherService();
        studentService = ApplicationContext.getStudentService();
        addressService = ApplicationContext.getAddressService();*/
    }

    private List<String> availableCodes = new ArrayList<>();

    protected TeacherDto getTeacherDto() {
        String firstName = getFirstName();
        String lastName = getLastName();
        String code = getCode();
        Double salary = getSalary();
        Date birthDay = getBirthDay();

        return new TeacherDto(
                firstName,
                lastName,
                code,
                salary,
                birthDay
        );

    }

    protected AddressDto getAddressDto() {
        return new AddressDto(
                getPhoneNumber(),
                getState(),
                getCity(),
                getPostalAddress(),
                getPostalCode()
        );
    }

    protected StudentDto getStudentDto() {
        return new StudentDto(
                getFirstName(),
                getLastName(),
                getCode(),
                getBirthDay()
        );
    }

    protected TeacherDto setStudentDtoForTeacherDto(
            TeacherDto teacherDto,
            StudentDto studentDto,
            StudentService studentService,
            AddressService addressService
    ) {
        while (true) {
            Student student = studentService.getStudent(getStudentDto());
            System.out.println("Enter Information of Address(es) Student :");
            studentDto = setAddressDtoForStudentDto(studentDto, addressService);
            student.setAddresses(studentDto.getAddresses());
            teacherDto.getStudents().add(student);
            System.out.println("Do you want insert another student for this teacher?");
            boolean checkTeacher = check.runMenu();
            if (!checkTeacher)
                break;
        }
        return teacherDto;
    }


    protected StudentDto setAddressDtoForStudentDto(
            StudentDto studentDto,
            AddressService addressService) {
        while (true) {
            studentDto.getAddresses().add(addressService.getAddress(getAddressDto()));
            System.out.println("Do you want insert another address for this student? ");
            boolean checkStudent = check.runMenu();
            if (!checkStudent)
                break;
        }
        return studentDto;
    }

    protected StudentDto setTeacherDtoForStudentDto(
            StudentDto studentDto,
            TeacherService teacherService, AddressService addressService) {
        while (true) {
            Teacher teacher = teacherService.getTeacher(getTeacherDto());
            System.out.println("Enter Information of Address Teacher :");
            teacher.setAddress(addressService.getAddress(getAddressDto()));
            studentDto.getTeachers().add(teacher);
            System.out.println("Do you want insert another teacher for this student?");
            boolean checkTeacher = check.runMenu();
            if (!checkTeacher)
                break;
        }
        return studentDto;
    }

    protected String getCode() {

        TeacherService teacherService = ApplicationContext.getTeacherService();
        StudentService studentService = ApplicationContext.getStudentService();

        try {
            availableCodes.addAll(Arrays.asList(teacherService.getTeacherCodes()));
            availableCodes.addAll(Arrays.asList(studentService.getStudentCodes()));
            return new Input(
                    CODE_MESSAGE,
                    CODE_WARNING,
                    CODE_REGEX,
                    availableCodes
            ).getInputString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Input(
                CODE_MESSAGE,
                CODE_WARNING,
                CODE_REGEX,
                availableCodes
        ).getInputString();

    }

    protected String getFirstName() {
        return new Input(
                FIRSTNAME_MESSAGE,
                FIRSTNAME_WARNING,
                FIRSTNAME_REGEX,
                null).getInputString();
    }

    protected String getLastName() {
        return new Input(
                LASTNAME_MESSAGE,
                LASTNAME_WARNING,
                LASTNAME_REGEX,
                null).getInputString();
    }

    protected Date getBirthDay() {
        String birthday = new Input(
                BIRTH_DAY_MESSAGE,
                BIRTH_DAY_WARNING,
                BIRTH_DAY_REGEX,
                null).getInputString();
        return Date.valueOf(birthday);
    }

    protected Double getSalary() {
        return new Input(
                SALARY_MESSAGE,
                Double.MAX_VALUE,
                0.0,
                null).getInputDouble();
    }

    protected String getPhoneNumber() {
        return new Input(
                PHONE_NUMBER_MESSAGE,
                PHONE_NUMBER_WARNING,
                PHONE_NUMBER_REGEX,
                null
        ).getInputString();
    }

    protected String getState() {
        return new Input(
                STATE_MESSAGE
        ).getInputString();
    }

    protected String getCity() {
        return new Input(
                CITY_MESSAGE
        ).getInputString();
    }

    protected String getPostalAddress() {
        return new Input(
                POSTAL_ADDRESS_MESSAGE
        ).getInputString();
    }

    protected String getPostalCode() {
        return new Input(
                POSTAL_CODE_MESSAGE
        ).getInputString();
    }
}
