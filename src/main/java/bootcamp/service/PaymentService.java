package bootcamp.service;

import bootcamp.model.invoice.Invoice;
import bootcamp.model.payment.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class PaymentService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${supplier-a.url}")
    String supplier_a_url;

    @Value("${supplier-b.url}")
    String supplier_b_url;

    @Value("${supplier-c.url}")
    String supplier_c_url;

    public boolean makePayment(int supplier, double total){
        UriComponentsBuilder builder;
        boolean complete = false;
        Payment payment = new Payment(total);
        switch(supplier){
            case 0:
                builder = UriComponentsBuilder.fromUriString("http://" + supplier_a_url + "/payment").port(8080);
                complete = restTemplate.postForObject(builder.toUriString(), payment, Boolean.class);
                break;
            case 1:
                builder = UriComponentsBuilder.fromUriString("http://" + supplier_b_url + "/payment").port(8080);
                complete = restTemplate.postForObject(builder.toUriString(), payment, Boolean.class);
                break;
            case 2:
                builder = UriComponentsBuilder.fromUriString("http://" + supplier_c_url + "/payment").port(8080);
                complete = restTemplate.postForObject(builder.toUriString(), payment, Boolean.class);
                break;
            default:
                break;
        }
        return complete;
    }

}
