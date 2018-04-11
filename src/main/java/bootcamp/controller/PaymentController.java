package bootcamp.controller;

import bootcamp.model.payment.Payment;
import bootcamp.service.InvoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PaymentController {
    @Autowired
    InvoiceService invoiceService;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/payment")
    public Boolean payment(@RequestBody Payment payment) {
        log.info("Received payment of: " + payment.getPaymentForProduct());
        return invoiceService.verifyPaymentWithInvoice(payment);
    }
}
