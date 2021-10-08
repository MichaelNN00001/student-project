package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.AnswerCityRegister;
import edu.javacourse.studentorder.domain.CityRegisterCheckerRespons;
import edu.javacourse.studentorder.domain.StudentOrder;
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
        try {
            CityRegisterCheckerRespons hans = personeChecker.checkPerson(so.getHusband());
            CityRegisterCheckerRespons wans = personeChecker.checkPerson(so.getWife());
            CityRegisterCheckerRespons cans = personeChecker.checkPerson(so.getChild());
        } catch (CityRegisterException ex) {
            ex.printStackTrace();
        }
        AnswerCityRegister ans = new AnswerCityRegister();
        return ans;
    }
}
