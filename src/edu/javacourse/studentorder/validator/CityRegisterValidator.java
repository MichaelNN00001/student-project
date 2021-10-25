package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.Child;
import edu.javacourse.studentorder.domain.Person;
import edu.javacourse.studentorder.domain.StudentOrder;
import edu.javacourse.studentorder.domain.register.AnswerCityRegister;
import edu.javacourse.studentorder.domain.register.AnswerCityRegisterItem;
import edu.javacourse.studentorder.domain.register.CityRegisterRespons;
import edu.javacourse.studentorder.exception.CityRegisterException;

public class CityRegisterValidator {
    public String hostName;
    protected int port;
    private String login;
    String password;

    private CityRegisterChecker personeChecker;

    public CityRegisterValidator() {
        personeChecker = new FakeCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so) {
        AnswerCityRegister ans = new AnswerCityRegister();
        ans.addItem(checkPerson(so.getHusband()));
        ans.addItem(checkPerson(so.getWife()));
        for(Child child : so.getChildren()) {
            ans.addItem(checkPerson(child));
        }
       return ans;
    }

    private AnswerCityRegisterItem checkPerson(Person person) {
        try {
                CityRegisterRespons cans = personeChecker.checkPerson(person);
        } catch (CityRegisterException ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }
}
