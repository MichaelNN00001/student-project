package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.AnswerChildren;
import edu.javacourse.studentorder.domain.StudentOrder;

public class ChildrenValidator {
    String hostName;
    String login;
    String password;

    public AnswerChildren checkChildren(StudentOrder so) {
        System.out.println("checkChidren is running: "+ hostName + ", " + login + ", " + password);
        return new AnswerChildren();
    }
}
