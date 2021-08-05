package daseclasses;

import exceptions.NotValidDataException;
import exceptions.NotValidSalaryException;

import java.math.BigDecimal;
import java.util.List;

public class CreateListDepartment {
    public static List<Department> createListDep(String s, List<Department> listDepartament){
        try {
            String[]sPars = s.split(";");
            if (sPars.length == 5) {
                String nameDepartament = sPars[3].trim();
                int id = Integer.parseInt(sPars[0]);
                BigDecimal salary = new BigDecimal(sPars[4].trim());
                ValidEmployee.validNameOrSecondName(sPars[1].trim()); // валидно ли имя
                ValidEmployee.validNameOrSecondName(sPars[2].trim()); // валидна ли фамилия
                ValidEmployee.validSalary(salary, id); // валидна ли зарплата
                Employee employee = new Employee(id, sPars[1], sPars[2], salary);
                if (listDepartament.stream().anyMatch(dep -> dep.getTitle().equals(nameDepartament))) {
                    ValidEmployee.addEmployee(listDepartament, nameDepartament, employee);
                } else {
                    listDepartament.add(new Department(nameDepartament));
                    ValidEmployee.addEmployee(listDepartament, nameDepartament, employee);
                }
            }
        } catch (NotValidDataException | NotValidSalaryException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Не известный формат заработной платы");
        }
        return listDepartament;

    }
}
