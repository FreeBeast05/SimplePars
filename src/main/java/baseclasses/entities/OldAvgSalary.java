package baseclasses.entities;

import java.math.BigDecimal;

public class OldAvgSalary {
    public OldAvgSalary(BigDecimal oldAvgSalaryIn1, BigDecimal oldAvgSalaryIn2) {
        this.oldAvgSalaryIn1 = oldAvgSalaryIn1;
        this.oldAvgSalaryIn2 = oldAvgSalaryIn2;
    }

    public BigDecimal getOldAvgSalaryIn1() {
        return oldAvgSalaryIn1;
    }

    public void setOldAvgSalaryIn1(BigDecimal oldAvgSalaryIn1) {
        this.oldAvgSalaryIn1 = oldAvgSalaryIn1;
    }

    public BigDecimal getOldAvgSalaryIn2() {
        return oldAvgSalaryIn2;
    }

    public void setOldAvgSalaryIn2(BigDecimal oldAvgSalaryIn2) {
        this.oldAvgSalaryIn2 = oldAvgSalaryIn2;
    }

    private BigDecimal oldAvgSalaryIn1, oldAvgSalaryIn2;
}
