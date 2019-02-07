package mainPackage.reactive;


import lombok.AllArgsConstructor;
import mainPackage.model.User;
import org.omg.CORBA.ServerRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;

@Component
@AllArgsConstructor
public class UserHandler {

    private UserService userService;


    public Mono<ServerResponse> getAll(ServerRequest serverRequest) {
        return Mono.just(serverRequest)
                .flatMap(request -> userService
                .getAllFromService()
                .collectList())
                .flatMap(this::okJsonResponse);
    }


    private Mono<ServerResponse> okJsonResponse(Object response) {
        return ServerResponse
                .ok()
                .contentType(APPLICATION_JSON)
                .body(fromObject(response));
    }
}
