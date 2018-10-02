package mainPackage.controller;

import mainPackage.model.Customer;
import mainPackage.service.CustomerRepository;
import org.hibernate.annotations.Formula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/customerList", method = GET)
    public List<Customer> customerList ()
    {
        return customerRepository.findAll();
    }
    @Scheduled(fixedRate = 60000)
    @RequestMapping(value = "/size", method = GET)
    public long getSize()
    {
        return customerRepository.count();
    }

}