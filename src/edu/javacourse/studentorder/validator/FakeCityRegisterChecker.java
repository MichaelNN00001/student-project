package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.CityRegisterCheckerRespons;
import edu.javacourse.studentorder.domain.Person;
import edu.javacourse.studentorder.exception.CityRegisterException;

public class FakeCityRegisterChecker implements CityRegisterChecker {
    public CityRegisterCheckerRespons checkPerson(Person person)
            throws CityRegisterException {

        return null;
    }

}