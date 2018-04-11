package bootcamp.controller;

import bootcamp.model.invoice.Invoice;
import bootcamp.model.order.Order;
import bootcamp.model.products.Product;
import bootcamp.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class OrderController {
    @Autowired
    InvoiceService invoiceService;

    @PostMapping("/order")
    public Invoice order(@RequestBody Order order) {
        return invoiceService.createInvoice(order);
    }
}
