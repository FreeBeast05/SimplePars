package baseclasses.action;

import baseclasses.entities.Department;
import baseclasses.entities.GoodTransfer;
import baseclasses.entities.OldAvgSalary;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;


public class WritePossibleTransfers {
    private static final String PATH = Main.path2;

    public static void writeTransfers(Department department1, Department department2, OldAvgSalary oldAvgSalary, Set<GoodTransfer> goodTransfers) {
        String fromTo = "Из '" + department1.getTitle() + "' в '" + department2.getTitle() + "':\n";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH, true))) {
            writer.write(fromTo);
            int i = 1;
            for (GoodTransfer transfer : goodTransfers) {
                writer.write("Группа " + i++ + ":" + "\n");
                String groupStr = transfer.getSubListEmployee()
                        .stream().map(s -> s.getFirstName() + " " + s.getSecondName())
                        .reduce("", (s, s2) -> s + s2 + "\n").trim();
                writer.write(groupStr + "\n");
                writer.write("Средняя зарплата в старом отделе:" + "\n \t \t" + "до перевода - "
                        + oldAvgSalary.getOldAvgSalaryIn1() + "\n \t \t" + "после перевода - " + transfer.getNewAvgSalaryDep1() + "\n");
                writer.write("Средняя зарплата в новом отделе:" + "\n \t \t" + "до перевода - "
                        + oldAvgSalary.getOldAvgSalaryIn2() + "\n \t \t" + "после перевода - " + transfer.getNewAvgSalaryDep2() + "\n\n");

            }
        } catch (IOException ioException) {
            System.out.println("Возникла ошибка вывода");
        }


    }
}
