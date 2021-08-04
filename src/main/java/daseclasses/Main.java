package daseclasses;

import java.io.*;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import exceptions.NotValidDataException;
import exceptions.NotValidDepartamentException;
import exceptions.NotValidSalaryException;

public class Main {
    public static void main(String[] args) {

        String file = args[0];
        List < Department > listDepartament = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "Cp1251"))) {
            String s;
            while ((s = br.readLine()) != null) {
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



            }
        } catch(FileNotFoundException | UnsupportedEncodingException e) {
            System.out.println("Файл не найден или кодиравка файла не известна");
    } catch (IOException e) {
            e.printStackTrace();
        } finally{
        System.out.println(listDepartament.get(2));
        System.out.println(listDepartament.get(2).getAvgSalary());
        }
    }
}
