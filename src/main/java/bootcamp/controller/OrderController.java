package bootcamp.controller;

import bootcamp.model.invoice.Invoice;
import bootcamp.model.order.Order;
import bootcamp.model.products.Product;
import bootcamp.service.InvoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class OrderController {
    @Autowired
    InvoiceService invoiceService;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/order")
    public Invoice order(@RequestBody Order order) {
        log.info("Received order of: ID= " + order.getId() + " Quantity=" + order.getQuantity());
        return invoiceService.createInvoice(order);
    }
}
