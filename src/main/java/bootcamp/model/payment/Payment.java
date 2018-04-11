package bootcamp.model.payment;

import java.math.BigDecimal;

public class Payment {
    private BigDecimal total;

    public Payment(double total) {
        this.total = BigDecimal.valueOf(total);
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
