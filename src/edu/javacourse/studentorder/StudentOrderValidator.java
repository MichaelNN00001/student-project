package edu.javacourse.studentorder;

import edu.javacourse.studentorder.domain.*;
import edu.javacourse.studentorder.mail.MailSender;
import edu.javacourse.studentorder.validator.ChildrenValidator;
import edu.javacourse.studentorder.validator.CityRegisterValidator;
import edu.javacourse.studentorder.validator.StudentValidator;
import edu.javacourse.studentorder.validator.WeddingValidator;

public class StudentOrderValidator {
    private CityRegisterValidator cityRegisterVal;
    private WeddingValidator weddingVal;
    private ChildrenValidator childrenVal;
    private StudentValidator studentVal;
    private MailSender mailSender;

    public StudentOrderValidator() {
        cityRegisterVal = new CityRegisterValidator();
        weddingVal = new WeddingValidator();
        childrenVal = new ChildrenValidator();
        mailSender = new MailSender();
    }

    public static void main(String[] args) {
        StudentOrderValidator sov = new StudentOrderValidator();
        sov.checkAll();
    }

    public void checkAll() {
        while (true) {
            StudentOrder so = readStudentOrder();
            if (so == null) {
                break;
            }
            AnswerCityRegister cityAnswer = checkCityRegister(so);
            if (!cityAnswer.success) {
                break;
            }
            AnswerWedding wedAnswer = checkWedding(so);
            if (!wedAnswer.success) {
                break;
            }
            AnswerChildren childAnswer = checkChildren(so);
            if (!childAnswer.success) {
                break;
            }
            AnswerStudent studAnswer = checkStudent(so);
            if (!studAnswer.success) {
                break;
            }
            sendMail(so);
         }
    }
    public StudentOrder readStudentOrder() {
        SaveStudentOrder.buildStudentOrder();
        return new StudentOrder();
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so) {
        return cityRegisterVal.checkCityRegister(so);
    }
    public AnswerWedding checkWedding(StudentOrder so) {
        return weddingVal.checkWedding(so);
    }
    public AnswerChildren checkChildren(StudentOrder so) {
        return childrenVal.checkChildren(so);
    }
    public AnswerStudent checkStudent(StudentOrder so) {
        return studentVal.checkStudent(so);
    }
    public void sendMail (StudentOrder so) {
        mailSender.sendMail(so);
    }
}
