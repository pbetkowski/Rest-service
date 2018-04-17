package mainPackage.controller;

import mainPackage.model.User;
import mainPackage.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
@RestController
@CrossOrigin
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/userList", method = GET)
    @ResponseBody
    public List<User> userList ()
    {
        List<User> list = new ArrayList<>();
        for (int i = 1; i <userRepository.count()+1; i++) {
            list.add(userRepository.findOne(i));
        }
        return list;
    }

    //http://localhost:8443/create_user?name=Jan&surname=Janowski&pesel=88355552
    @RequestMapping(name = "/createUser", method = GET)
    public User createUser(@RequestParam(value = "name") String name,
                           @RequestParam(value = "surname") String surname,
                           @RequestParam(value = "pesel") String pesel
                           )
    {
        User newUser = new User(null, name, surname, pesel);
        return userRepository.save(newUser);
    }
}
