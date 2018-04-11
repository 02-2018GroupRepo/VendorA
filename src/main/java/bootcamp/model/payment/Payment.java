package bootcamp.model.payment;

import java.math.BigDecimal;

public class Payment {
    private int invoiceId;
    private BigDecimal paymentForProduct;

    public int getInvoiceId() {
        return invoiceId;
    }
    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Payment() {}

    public Payment(int invoiceId, double total) {
        this.invoiceId = invoiceId;
        this.paymentForProduct = BigDecimal.valueOf(total);
    }

    public BigDecimal getPaymentForProduct() {
        return paymentForProduct;
    }

    public void setPaymentForProduct(BigDecimal total) {
        this.paymentForProduct = total;
    }
}
