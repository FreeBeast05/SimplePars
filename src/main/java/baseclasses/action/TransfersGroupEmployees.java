package baseclasses.action;

import baseclasses.entities.Department;
import baseclasses.entities.Employee;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class TransfersGroupEmployees {
    public static void transfersGroup(Map<String, Department> departmentMap) {
        for (Department department1 : departmentMap.values()) {
            BigDecimal oldSumSalaryIn1 = department1.getSumSalaryAllEmployee();
            BigDecimal oldAvgSalaryIn1 = department1.getAvgSalary();
            int numberOfEmployeesIn1 = department1.getListEmployers().size();
            List<Employee> employeeList1 = department1.getListEmployers();
            for (Department department2 : departmentMap.values()) {
                if (!department1.equals(department2)) {
                    BigDecimal oldSumSalaryIn2 = department2.getSumSalaryAllEmployee();
                    BigDecimal oldAvgSalaryIn2 = department2.getAvgSalary();
                    int numberOfEmployeesIn2 = department2.getListEmployers().size();
                    List<List<Employee>> setSubsets = GenerateSubsets.generateSetOfAllSubsets(employeeList1);
                    Map<List<Employee>, List<BigDecimal>> goodSubsets = findGoodGroup(setSubsets, oldSumSalaryIn1, oldAvgSalaryIn1, oldSumSalaryIn2, oldAvgSalaryIn2, numberOfEmployeesIn1, numberOfEmployeesIn2);
                    if (!goodSubsets.isEmpty()) {
                        WritePossibleTransfers.writeTransfers(department1, department2, oldAvgSalaryIn1,
                                oldAvgSalaryIn2, goodSubsets);
                    }
                }
            }
        }
    }

    private static Map<List<Employee>, List<BigDecimal>> findGoodGroup(List<List<Employee>> setSubsets, BigDecimal oldSumSalaryIn1, BigDecimal oldAvgSalaryIn1,
                                                                       BigDecimal oldSumSalaryIn2, BigDecimal oldAvgSalaryIn2, int numberOfEmployeesIn1, int numberOfEmployeesIn2) {
        Map<List<Employee>, List<BigDecimal>> goodSets = new HashMap<>();
        for (List<Employee> subsets : setSubsets) {
            BigDecimal sumAllSalaryTransfers = subsets.stream().map(Employee::getSalary).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
            int numberEmpTrans = subsets.size();
            BigDecimal newAvgSalaryDep1 = calculationNewAvgSalaryDropEmp(oldSumSalaryIn1, sumAllSalaryTransfers, numberOfEmployeesIn1, numberEmpTrans);
            BigDecimal newAvgSalaryDep2 = calculationNewAvgSalaryAddEmp(oldSumSalaryIn2, sumAllSalaryTransfers, numberOfEmployeesIn2, numberEmpTrans);
            if (newAvgSalaryDep1.compareTo(oldAvgSalaryIn1) > 0 && newAvgSalaryDep2.compareTo(oldAvgSalaryIn2) > 0) {
                goodSets.put(subsets, new ArrayList<>(Arrays.asList(newAvgSalaryDep1, newAvgSalaryDep2)));
            }
        }
        return goodSets;
    }


    private static BigDecimal calculationNewAvgSalaryDropEmp(BigDecimal sumSalary, BigDecimal sumAllSalaryTransfers, int sizeOld, int sizeNew) {
        if (sizeOld == sizeNew) {
            return BigDecimal.ZERO; // если группа перевода равна всем сотрудникам
        } else {
            return sumSalary.subtract(sumAllSalaryTransfers).divide(BigDecimal.valueOf(sizeOld - sizeNew), 2, RoundingMode.HALF_UP); //  если сотрудников больше чем один
        }
        //Вариант, когда сотрудников меньше 0, невозможен

    }

    private static BigDecimal calculationNewAvgSalaryAddEmp(BigDecimal sumSalary, BigDecimal sumAllSalaryTransfers, int sizeOld, int sizeNew) {
        return sumSalary.add(sumAllSalaryTransfers).divide(BigDecimal.valueOf(sizeOld + sizeNew), 2, RoundingMode.HALF_UP); //  варианты деления на ноль невозможны
    }

}
