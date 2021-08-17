package baseclasses.entities;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class GoodTransfer {
    private List<Employee> subListEmployee;
    private BigDecimal newAvgSalaryDep1, newAvgSalaryDep2;
    private BigDecimal oldAvgSalaryDep1, oldAvgSalaryDep2;

    public GoodTransfer(List<Employee> subListEmployee, BigDecimal newAvgSalaryDep1, BigDecimal newAvgSalaryDep2, BigDecimal oldAvgSalaryDep1, BigDecimal oldAvgSalaryDep2) {
        this.subListEmployee = subListEmployee;
        this.newAvgSalaryDep1 = newAvgSalaryDep1;
        this.newAvgSalaryDep2 = newAvgSalaryDep2;
        this.oldAvgSalaryDep1 = oldAvgSalaryDep1;
        this.oldAvgSalaryDep2 = oldAvgSalaryDep2;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodTransfer transfer = (GoodTransfer) o;
        return Objects.equals(subListEmployee, transfer.subListEmployee) && Objects.equals(newAvgSalaryDep1, transfer.newAvgSalaryDep1) && Objects.equals(newAvgSalaryDep2, transfer.newAvgSalaryDep2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subListEmployee, newAvgSalaryDep1, newAvgSalaryDep2);
    }

    public BigDecimal getOldAvgSalaryDep1() {
        return oldAvgSalaryDep1;
    }

    public void setOldAvgSalaryDep1(BigDecimal oldAvgSalaryDep1) {
        this.oldAvgSalaryDep1 = oldAvgSalaryDep1;
    }

    public BigDecimal getOldAvgSalaryDep2() {
        return oldAvgSalaryDep2;
    }

    public void setOldAvgSalaryDep2(BigDecimal oldAvgSalaryDep2) {
        this.oldAvgSalaryDep2 = oldAvgSalaryDep2;
    }
}
