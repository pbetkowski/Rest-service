package mainPackage.controller;

import mainPackage.model.User;
import mainPackage.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    UserRepository userRepo;


    @RequestMapping(value = "/users", method = GET)
    public Iterable<User> getUsers() {
        return userRepo.findAll();
    }

}