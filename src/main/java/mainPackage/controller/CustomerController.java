package mainPackage.controller;

import mainPackage.model.Customer;
import mainPackage.service.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;


    @RequestMapping(value = "/customers", method = GET)
    public Iterable<Customer> getUsers() {
        return customerRepository.findAll();
    }

}