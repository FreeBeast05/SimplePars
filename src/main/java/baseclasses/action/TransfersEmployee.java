package baseclasses.action;

import baseclasses.Department;
import baseclasses.Employee;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TransfersEmployee {
    public static List<String> transfers(Map<String, Department> departmentMap) {
        List<String> possibleTransfers = new ArrayList<>();
        possibleTransfers.add("Employee, OldDepartment, NewDepartment, AvgSalaryInOldDepartment-AvgSalaryInOldDepartmentAfterTransfer, AvgSalaryInNewDepartment-AvgSalaryInNewDepartmentAfterTransfer");
        for (Department departmentFirst : departmentMap.values()) {
            for (Employee employee : departmentFirst.getListEmployers()) {
                for (Department departmentSecond : departmentMap.values()) {
                    if (!departmentFirst.getTitle().equals(departmentSecond.getTitle())) {
                        BigDecimal avgFirstDepartment = departmentFirst.getAvgSalary();
                        BigDecimal avgSecondDepartment = departmentSecond.getAvgSalary();
                        BigDecimal newAvgFirstDepartment = calculationNewAvgSalaryDropEmp(departmentFirst.getSumSalaryAllEmployee(), employee.getSalary(), departmentFirst.getListEmployers().size());
                        BigDecimal newAvgSecondDepartment = calculationNewAvgSalaryAddEmp(departmentSecond.getSumSalaryAllEmployee(), employee.getSalary(), departmentSecond.getListEmployers().size());
                        if ((newAvgFirstDepartment.compareTo(avgFirstDepartment)) > 0 && newAvgSecondDepartment.compareTo(avgSecondDepartment) > 0) {
                            String transit = employee.getFirstName() + " " + employee.getSecondName() + " " + departmentFirst.getTitle()
                                    + " " + departmentSecond.getTitle() + " " + avgFirstDepartment + "-"+newAvgFirstDepartment+" " + avgSecondDepartment+"-"+newAvgSecondDepartment;
                            possibleTransfers.add(transit);
                        }

                    }
                }
            }
        }
        return possibleTransfers;
    }

    private static BigDecimal calculationNewAvgSalaryDropEmp(BigDecimal sumSalary, BigDecimal salary, int size) {
        if (size == 1) {
            return BigDecimal.ZERO; // если сотрудник в отделе один значит средняя зп станет 0
        } else {
            return sumSalary.subtract(salary).divide(BigDecimal.valueOf(size - 1), 2, RoundingMode.HALF_UP); //  если сотрудников больше чем один
        }
        //Вариант, когда сотрудников меньше 0, невозможен, ограничение в цикле

    }

    private static BigDecimal calculationNewAvgSalaryAddEmp(BigDecimal sumSalary, BigDecimal salary, int size) {

        return sumSalary.add(salary).divide(BigDecimal.valueOf(size + 1), 2, RoundingMode.HALF_UP); //  варианты деления на ноль невозможны

    }
}
