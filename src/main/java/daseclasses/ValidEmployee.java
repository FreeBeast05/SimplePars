package daseclasses;

import exceptions.NotValidDataException;
import exceptions.NotValidDepartamentException;
import exceptions.NotValidSalaryException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ValidEmployee {

    public static void validNameOrSecondName(String name) throws NotValidDataException {
        if (!Pattern.matches("^[А-Я]{1}[а-яё]{1,25}$", name)) {
            throw new NotValidDataException("Введены не корректные фамимия или имя сотрудника '" + name + "'");
        }
    }

    public static void validSalary(BigDecimal salary, int id) {
        if (salary.compareTo(BigDecimal.ZERO) < 0) {
            throw new NotValidSalaryException("Введена отрицательная зарплата сотрудника с id номер " + id);
        }
    }

    public static void addEmployee(List<Department> listDepartament, String nameDepartament, Employee employee) {
        Department newDepart = listDepartament.stream().filter(department -> department.getTitle().equals(nameDepartament)).collect(Collectors.toList()).get(0);
        newDepart.addEmployer(employee);
    }

    public static void checkEmployeeTransfer(Department department1, Department department2){

    }

}
