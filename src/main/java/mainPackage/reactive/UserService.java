package mainPackage.reactive;


import lombok.AllArgsConstructor;
import mainPackage.model.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class UserService {

    private UserConnector userConnector;


    public Flux<User> getAllFromService() {
        return userConnector.getAll();
    }
}
