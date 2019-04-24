package xyz.bbear.flux.api.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;
import xyz.bbear.flux.api.model.Home;
import xyz.bbear.flux.api.service.HomeService;

/**
 * HomeHandler.
 *
 * @author xiongliu wu 2019-04-24 17:25
 */
@Component
public class HomeHandler {
    @Autowired
    private HomeService homeService;

    public Mono<ServerResponse> getHome(ServerRequest serverRequest){
        String id = serverRequest.pathVariable("id");
        Home home = this.homeService.get(Long.parseLong(id));
        return ServerResponse.ok().body(Mono.just(home),Home.class);
    }
}
