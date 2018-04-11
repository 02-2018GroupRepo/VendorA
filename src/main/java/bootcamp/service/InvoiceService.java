package bootcamp.service;

import bootcamp.model.company.Company;
import bootcamp.model.invoice.Invoice;
import bootcamp.model.order.Order;
import bootcamp.model.payment.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
public class InvoiceService {
    @Autowired
    Company company;

    @Autowired
    InventoryService inventoryService;

    @Autowired
    ProductService productService;

    private Map<Integer, Invoice> invoiceMap = new HashMap<>();
    private int counter = 1;

    public Invoice getInvoiceByInvoiceId(int invoiceId) {
        return this.invoiceMap.get(invoiceId);
    }

    public Invoice createInvoice(Order order) {
        Invoice invoice = new Invoice(counter++, productService.getProductById(order.getId()), order.getQuantity());
        addInvoiceToInvoiceMap(invoice);
        return invoice;
    }

    public void addInvoiceToInvoiceMap(Invoice invoice) {
        this.invoiceMap.put(invoice.getInvoiceId(), invoice);
    }

    public Boolean verifyPaymentWithInvoice(Payment payment) {
        BigDecimal retail_price = getInvoiceByInvoiceId(payment.getInvoiceId()).getProduct().getRetail_price();
        BigDecimal count = BigDecimal.valueOf(getInvoiceByInvoiceId(payment.getInvoiceId()).getCount());
        if (payment.getTotal() == (retail_price.multiply(count))) {
            // Add cash to our company
            company.addCash(payment.getTotal().doubleValue());

            // Get invoice and use it to modify inventory, and check for restock
            Invoice invoice = getInvoiceByInvoiceId(payment.getInvoiceId());
            inventoryService.removeFromInventory(invoice.getProduct().getId(), invoice.getCount());
            inventoryService.checkInventoryForRestock();
            return new Boolean(true);
        } else {
            return new Boolean(false);
        }
    }
}
