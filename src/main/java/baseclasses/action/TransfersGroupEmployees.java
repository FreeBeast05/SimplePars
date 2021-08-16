package baseclasses.action;

import baseclasses.entities.Department;
import baseclasses.entities.Employee;
import baseclasses.entities.GoodTransfer;
import baseclasses.entities.OldAvgSalary;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TransfersGroupEmployees {
    public static void transfersGroup(Map<String, Department> departmentMap) {
        for (Department department1 : departmentMap.values()) {
            BigDecimal oldAvgSalaryIn1 = department1.getAvgSalary();
            List<Employee> employeeList1 = department1.getListEmployers();
            List<GoodTransfer> goodTransfers = new ArrayList<>();
            Set<List<Employee>> setSubsets = GenerateSubsets.generateSetOfAllSubsets(employeeList1);
            Set<List<Employee>> newSetSubsets = setSubsets.stream()
                    .filter(s -> filterSubsets(department1, s, oldAvgSalaryIn1, goodTransfers))
                    .collect(Collectors.toSet());
            for (Department department2 : departmentMap.values()) {
                if (!department1.equals(department2)) {
                    BigDecimal oldAvgSalaryIn2 = department2.getAvgSalary();
                    Set<List<Employee>> goodSubsets = newSetSubsets.stream()
                            .filter(s -> filterSubsetsForAddEmp(department2, s, oldAvgSalaryIn2, goodTransfers))
                            .collect(Collectors.toSet());
                    Set<GoodTransfer> good = goodTransfers.stream()
                            .filter(s -> s.getNewAvgSalaryDep2().compareTo(BigDecimal.valueOf(-1)) != 0)
                            .collect(Collectors.toSet());
                    if (good.size() != 0) {
                        WritePossibleTransfers.writeTransfers(department1, department2, new OldAvgSalary(oldAvgSalaryIn1, oldAvgSalaryIn2), good);
                    }
                }
            }
        }
    }


    private static boolean filterSubsets(Department department, List<Employee> subsets, BigDecimal oldAvgSalary, List<GoodTransfer> goodTransfersList) {
        BigDecimal avgSalaryForSubsets = Department.getAvgSalaryForSublist(department.getListEmployers().stream()
                .filter(s -> !(subsets.contains(s)))
                .collect(Collectors.toList()));
        boolean result = avgSalaryForSubsets.compareTo(oldAvgSalary) > 0;
        if (result) {
            goodTransfersList.add(new GoodTransfer(subsets, avgSalaryForSubsets, BigDecimal.valueOf(-1)));
        }
        return result;
    }

    private static boolean filterSubsetsForAddEmp(Department department, List<Employee> subsets, BigDecimal oldAvgSalary, List<GoodTransfer> goodTransfersList) {
        BigDecimal avgSalaryForSubsetsAndDep = BigDecimal.ZERO;
        if (department.getListEmployers().size() > 0 && subsets.size() > 0) {
            avgSalaryForSubsetsAndDep = (department.getSumSalaryAllEmployee().add(Department.getSumSalaryForSublist(subsets)))
                    .divide(BigDecimal.valueOf(department.getListEmployers().size() + subsets.size()), 2, RoundingMode.HALF_UP);
        }
        boolean result = avgSalaryForSubsetsAndDep.compareTo(oldAvgSalary) > 0;
        if (result) {
            for (GoodTransfer transfer : goodTransfersList) {
                if (transfer.getSubListEmployee().equals(subsets)) {
                    transfer.setNewAvgSalaryDep2(avgSalaryForSubsetsAndDep);
                }
            }
        }
        return result;
    }


}
