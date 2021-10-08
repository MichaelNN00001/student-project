package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.CityRegisterCheckerRespons;
import edu.javacourse.studentorder.domain.Person;
import edu.javacourse.studentorder.exception.CityRegisterException;

public interface CityRegisterChecker {
    CityRegisterCheckerRespons checkPerson(Person person) throws CityRegisterException;
}
