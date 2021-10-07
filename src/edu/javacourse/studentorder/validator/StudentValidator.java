package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.AnswerChildren;
import edu.javacourse.studentorder.domain.AnswerStudent;
import edu.javacourse.studentorder.domain.StudentOrder;

public class StudentValidator {
    String hostName;
    String login;
    String password;

    public AnswerStudent checkStudent(StudentOrder so) {
        System.out.println("checkStudent is running: " + hostName + ", " + login + ", " + password);
        return new AnswerStudent();
    }
}
