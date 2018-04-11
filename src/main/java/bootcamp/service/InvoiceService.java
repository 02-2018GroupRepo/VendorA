package bootcamp.service;

import bootcamp.model.invoice.Invoice;
import bootcamp.model.payment.Payment;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
public class InvoiceService {
    private Map<Integer, Invoice> invoiceMap = new HashMap<>();

    public Invoice getInvoiceByInvoiceId(int invoiceId) {
        return this.invoiceMap.get(invoiceId);
    }

    public void addInvoiceToInvoiceMap(Invoice invoice) {
        this.invoiceMap.put(invoice.getInvoiceId(), invoice);
    }

    public Boolean verifyPaymentWithInvoice(Payment payment) {
        BigDecimal retail_price = getInvoiceByInvoiceId(payment.getInvoiceId()).getProduct().getRetail_price();
        BigDecimal count = BigDecimal.valueOf(getInvoiceByInvoiceId(payment.getInvoiceId()).getCount());
        if (payment.getTotal() == (retail_price.multiply(count))) {
            // add cash
            // subtract from inventory
            return new Boolean(true);
        } else {
            return new Boolean(false);
        }
    }
}
