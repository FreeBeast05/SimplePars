package baseclasses.entities;

import java.math.BigDecimal;
import java.util.List;

public class GoodTransfer {
    private List<Employee> subListEmployee;
    private BigDecimal newAvgSalaryDep1, newAvgSalaryDep2;

    public GoodTransfer(List<Employee> subListEmployee, BigDecimal newAvgSalaryDep1, BigDecimal newAvgSalaryDep2) {
        this.subListEmployee = subListEmployee;
        this.newAvgSalaryDep1 = newAvgSalaryDep1;
        this.newAvgSalaryDep2 = newAvgSalaryDep2;
    }

    public List<Employee> getSubListEmployee() {
        return subListEmployee;
    }

    public void setSubListEmployee(List<Employee> subListEmployee) {
        this.subListEmployee = subListEmployee;
    }

    public BigDecimal getNewAvgSalaryDep1() {
        return newAvgSalaryDep1;
    }

    public void setNewAvgSalaryDep1(BigDecimal newAvgSalaryDep1) {
        this.newAvgSalaryDep1 = newAvgSalaryDep1;
    }

    public BigDecimal getNewAvgSalaryDep2() {
        return newAvgSalaryDep2;
    }

    public void setNewAvgSalaryDep2(BigDecimal newAvgSalaryDep2) {
        this.newAvgSalaryDep2 = newAvgSalaryDep2;
    }


}
