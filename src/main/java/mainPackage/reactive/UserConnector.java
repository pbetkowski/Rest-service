package mainPackage.reactive;

import lombok.AllArgsConstructor;
import mainPackage.model.User;
import mainPackage.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@AllArgsConstructor
public class UserConnector {

    @Autowired
    private UserRepository userRepository;

    public Flux<User> getAll() {
        return Flux.fromIterable(userRepository.findAll());
    }
}
