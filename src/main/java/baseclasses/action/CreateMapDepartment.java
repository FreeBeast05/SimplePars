package baseclasses.action;

import baseclasses.correctnessdata.ValidEmployee;
import baseclasses.entities.Department;
import baseclasses.entities.Employee;
import exceptions.NotValidDataException;
import exceptions.NotValidSalaryException;

import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CreateMapDepartment {
    public static Map<String, Department> createMapDepartment(String[] path, String coding) {
        Map<String, Department> mapDepartment = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path[0]), coding))) {
            String s;
            while ((s = br.readLine()) != null) {
                try {
                    String[] sPars = s.split(";");
                    if (sPars.length == 5) {
                        String firstName = sPars[1].trim(), secondName = sPars[2].trim();
                        String titleDepartment = sPars[3].trim(), salaryStr = sPars[4].trim();
                        int id = Integer.parseInt(sPars[0].trim());
                        ValidEmployee.validAllParameter(firstName, secondName, salaryStr);
                        Employee employee = new Employee(id, firstName, secondName, new BigDecimal(salaryStr));
                        if (!mapDepartment.containsKey(titleDepartment)) {
                            mapDepartment.put(titleDepartment, new Department(titleDepartment));
                        }
                        mapDepartment.get(titleDepartment).addEmployer(employee);
                    } else if (s.equals("")) {
                        continue;
//                        ничего не делаем
                    } else {
                        System.out.println("Количество входных параметров сотрудника неверны - сотрудник не добавлен ни в какой отдел");
                    }
                } catch (NotValidSalaryException | NotValidDataException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (UnsupportedEncodingException e) {
            System.out.println("Кодировка файла не известна");
        } catch (IOException e) {
            System.out.println("Возникла ошибка ввода");
        }
        return mapDepartment;
    }

}
