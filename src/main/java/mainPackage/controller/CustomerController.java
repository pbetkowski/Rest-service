package mainPackage.controller;

import mainPackage.model.Customer;
import mainPackage.service.CustomerRepository;
import org.hibernate.annotations.Formula;
import org.springframework.beans.factory.annotation.Autowired;
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
    @ResponseBody
    public List<Customer> customerList ()
    {
        List<Customer> list = new ArrayList<>();
        for (int i = 1; i <customerRepository.count()+1; i++) {
            list.add(customerRepository.findOne(i));
        }
        return list;
    }

    @RequestMapping(value = "/size", method = GET)
    public long getSize()
    {
        return customerRepository.count();
    }

}