package com.example.capstone;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JetSetGoApplicationTests {

	@Test
	void contextLoads() {
	}

}


//import lombok.AccessLevel;
//import lombok.experimental.FieldDefaults;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import sba.sms.models.Student;
//import sba.sms.utils.CommandLine;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.*;
//
//class StudentServiceTest {
//    static StudentService studentService;
//
//    @BeforeAll
//    public static void beforeAll() {
//        studentService = new StudentService();
//        CommandLine.addData();
//    }
//
//    @Test
//    void getAllStudents() {
//        List<Student> expected = new ArrayList<>(Arrays.asList(
//                new Student("reema@gmail.com", "reema brown", "password"),
//                new Student("annette@gmail.com", "annette allen", "password"),
//                new Student("anthony@gmail.com", "anthony gallegos", "password"),
//                new Student("ariadna@gmail.com", "ariadna ramirez", "password"),
//                new Student("bolaji@gmail.com", "bolaji saibu", "password"),
//                new Student("shirese@gmail.com", "shirese smith","password")
//
//        ));
//
//        assertThat(studentService.getAllStudents()).hasSameElementsAs(expected);
//
//    }
//
//
//}