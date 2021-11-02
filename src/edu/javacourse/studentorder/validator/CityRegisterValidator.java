package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.Child;
import edu.javacourse.studentorder.domain.Person;
import edu.javacourse.studentorder.domain.StudentOrder;
import edu.javacourse.studentorder.domain.register.AnswerCityRegister;
import edu.javacourse.studentorder.domain.register.AnswerCityRegisterItem;
import edu.javacourse.studentorder.domain.register.CityRegisterRespons;
import edu.javacourse.studentorder.exception.CityRegisterException;
import edu.javacourse.studentorder.exception.TransportException;

public class CityRegisterValidator {
//    public String hostName;
//    protected int port;
//    private String login;
//    String password;
    private static final String IN_CODE = "NO_GRN";

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
        AnswerCityRegisterItem.CityStatus status = null;
        AnswerCityRegisterItem.CityError error = null;
        try {
            CityRegisterRespons tmp = personeChecker.checkPerson(person);
            status = tmp.isExisting() ?
                    AnswerCityRegisterItem.CityStatus.YES :
                    AnswerCityRegisterItem.CityStatus.NO;
        } catch (CityRegisterException ex) {
            ex.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(ex.getCode(),ex.getMessage());
        } catch (TransportException ex) {
            ex.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(IN_CODE,ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(IN_CODE,ex.getMessage());
        }

        return null;
    }
}
