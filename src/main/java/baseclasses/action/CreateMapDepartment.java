package baseclasses.action;

import baseclasses.Department;
import baseclasses.Employee;
import baseclasses.correctnessdata.ValidEmployee;
import exceptions.NotValidDataException;
import exceptions.NotValidSalaryException;

import java.math.BigDecimal;
import java.util.Map;

public class CreateMapDepartment {
    public static void createMapDepartment(String s, Map<String, Department> departmentMap) {
        try {
            String[] sPars = s.split(";");
            if (sPars.length == 5) {
                String firstName = sPars[1].trim(), secondName = sPars[2].trim();
                String titleDepartment = sPars[3].trim(), salaryStr = sPars[4].trim();
                int id = Integer.parseInt(sPars[0]);
                BigDecimal salary = ValidEmployee.validSalary(salaryStr, firstName, secondName);// валидна ли зарплата
                ValidEmployee.validNameOrSecondName(firstName); // валидно ли имя
                ValidEmployee.validNameOrSecondName(firstName); // валидна ли фамилия
                Employee employee = new Employee(id, firstName, secondName, salary);
                if (!departmentMap.containsKey(titleDepartment)) {
                    departmentMap.put(titleDepartment, new Department(titleDepartment));
                }
                departmentMap.get(titleDepartment).addEmployer(employee);
            } else if (s.equals("")) {
            } else {
                System.out.println("Количество входных параметров сотрудника неверны - сотрудник не добавлен ни в какой отдел");
            }
        } catch (NotValidSalaryException | NotValidDataException e) {
            System.out.println(e.getMessage());
        }
    }
}
