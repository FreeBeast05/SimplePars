package baseclasses.correctnessdata;

import exceptions.NotValidDataException;
import exceptions.NotValidSalaryException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Pattern;

public class ValidEmployee {

    public static void validNameOrSecondName(String name) throws NotValidDataException {
        if (!Pattern.matches("^[А-Я]{1}[а-яё]{1,25}$", name)) {
            throw new NotValidDataException("Введены не корректные фамимия или имя сотрудника '" + name + "'");
        }
    }

    public static BigDecimal validSalary(String salary, String firstName, String secondName) {
        BigDecimal bigDecimalSalary = new BigDecimal(salary);
        if (!bigDecimalSalary.setScale(2, RoundingMode.CEILING).equals(new BigDecimal(salary))){
            throw new NotValidSalaryException(String.format("Введена некорректая зарплата сотрудника %s %s", firstName, secondName));
        }
        if (bigDecimalSalary.compareTo(BigDecimal.ZERO) < 0) {
            throw new NotValidSalaryException(String.format("Введена отрицательная зарплата сотрудника %s %s", firstName, secondName));
        }
        else return bigDecimalSalary;
    }



}
