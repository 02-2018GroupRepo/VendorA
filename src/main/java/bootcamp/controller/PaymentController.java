package bootcamp.controller;

import bootcamp.model.payment.Payment;
import bootcamp.service.InvoiceService;
import bootcamp.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class PaymentController {
    @Autowired
    InvoiceService invoiceService;

    @Autowired
    PaymentService paymentService;

    @PostMapping("/payment")
    public Boolean payment(@RequestBody Payment payment) {
        return invoiceService.verifyPaymentWithInvoice(payment);
    }
}
