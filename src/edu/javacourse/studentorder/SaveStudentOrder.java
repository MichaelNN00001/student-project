package edu.javacourse.studentorder;

import edu.javacourse.studentorder.domain.AnswerChildren;
import edu.javacourse.studentorder.domain.other.Adult;
import edu.javacourse.studentorder.domain.StudentOrder;
import edu.javacourse.studentorder.validator.CityRegisterValidator;
import edu.javacourse.studentorder.validator.WeddingValidator;

public class SaveStudentOrder {

    public static void main(String[] args) {
        buildStudentOrder();
        StudentOrder so = new StudentOrder();
        long ans = saveStudentOrder(so);
        System.out.println(ans);
    }
    static long saveStudentOrder(StudentOrder studentOrder) {
        long answer = 199;
        System.out.println("saveStudentOrder" );
        return answer;
    }

    public static StudentOrder buildStudentOrder() {
        StudentOrder so = new StudentOrder();

        Adult husband = new Adult();
        

//        husband.setGivenName("Андрей");
//        husband.setSurName("Пипусиков");
//        husband.setPassportNumber("123456");
//        so.setHusband(husband);

//        String ans = husband.getPersonString();
//        System.out.println(ans);

        return so;
    }
}
