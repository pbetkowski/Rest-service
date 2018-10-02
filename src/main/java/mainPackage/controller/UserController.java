package mainPackage.controller;

import javafx.application.Application;
import mainPackage.model.User;
import mainPackage.service.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    //25.10.2018 // 11 godzina
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    ResponseEntity<Collection<User>> getPojazd() {
        Collection<User> response = userRepository.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET)
    ResponseEntity<User> getUserById(@PathVariable Integer id) {
        User user = userRepository.findOne(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/createUser", method = PUT)
    ResponseEntity<User> createNewUser(@RequestBody User user) {
        User response = userRepository.save(user);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @RequestMapping(value = "deleteUser/{qid}", method = DELETE)
    public ResponseEntity deleteQuestion(@PathVariable Integer qid) {
        userRepository.delete(qid);

        return new ResponseEntity(HttpStatus.OK);
    }

}
// zapytanie o pojedynczy obiekt json, lub listę jsonów

//    final Logger log = LoggerFactory.getLogger(Application.class);
//    RestTemplate restTemplate = new RestTemplateBuilder().build();
//
//    User user = restTemplate.getForObject("http://localhost:8443/user/getUser", User.class);
//
//        System.out.println(user);
//                log.info(user.toString());
//
//                RestTemplate restTemplate = new RestTemplate();
//                ResponseEntity<List<User>> response = restTemplate.exchange(
//        "http://localhost:8443/user/getUser",
//        HttpMethod.GET,
//        null,
//        new ParameterizedTypeReference<List<User>>(){});
//        List<User> employees = response.getBody();
//
//        employees.forEach(m -> System.out.println(m));