package baseclasses.action;

import baseclasses.entities.Department;
import baseclasses.entities.Employee;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


public class WritePossibleTransfers {
    private static final String PATH = Main.path2;
    public static void writeTransfers (Department department1, Department department2, BigDecimal oldAvgSalaryIn1, BigDecimal oldAvgSalaryIn2, Map<List<Employee>, List<BigDecimal>> goodSubsets){
        String fromTo = "Из "+department1.getTitle()+" в " + department2.getTitle() + ":\n";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH, true))) {
            writer.write(fromTo);
            int i =1;
            for (List<Employee> employee: goodSubsets.keySet()){
                writer.write("Группа "+ i++ + ":" + "\n");
                String groupEmp = employee.stream()
                        .map(s -> s.getFirstName()+" " + s.getSecondName())
                        .reduce("",(s, s2) -> s+ s2+"\n")
                        .trim();
                writer.write(groupEmp+"\n");
                writer.write("Средняя зарплата в старом отделе:" +"\n \t \t" +"до перевода - "+ oldAvgSalaryIn1+"\n \t \t" + "после перевода - " + goodSubsets.get(employee).get(0) + "\n");
                writer.write("Средняя зарплата в новом отделе:" +"\n \t \t" +"до перевода - "+ oldAvgSalaryIn2+"\n \t \t" + "после перевода -  " + goodSubsets.get(employee).get(1)  +"\n\n");
            }
            writer.write("\n");

        } catch (IOException e) {
            System.out.println("Возникла ошибка вывода");
        }

    }
}
