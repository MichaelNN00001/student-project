package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.AnswerCityRegister;
import edu.javacourse.studentorder.domain.Child;
import edu.javacourse.studentorder.domain.CityRegisterCheckerRespons;
import edu.javacourse.studentorder.domain.StudentOrder;
import edu.javacourse.studentorder.exception.CityRegisterException;

import java.util.Iterator;
import java.util.List;

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

            List<Child> children = so.getChildren();
            for (int i = 0; i<children.size(); i++) {
                CityRegisterCheckerRespons cans = personeChecker.checkPerson(children.get(i));
            }
            for(Iterator<Child> it = children.iterator(); it.hasNext(); ) {
                Child child = it.next();
                CityRegisterCheckerRespons cans = personeChecker.checkPerson(child);
            }
            for(Child child : children) {
                CityRegisterCheckerRespons cans = personeChecker.checkPerson(children.get(i));
            }


        } catch (CityRegisterException ex) {
            ex.printStackTrace(System.out);
        }
        AnswerCityRegister ans = new AnswerCityRegister();
        return ans;
    }
}
