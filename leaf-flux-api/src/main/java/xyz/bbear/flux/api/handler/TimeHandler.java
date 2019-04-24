package xyz.bbear.flux.api.handler;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * TimeHandler.
 *
 * @author xiongliu wu 2019-04-24 19:13
 */
@Component
public class TimeHandler {

    public Mono<ServerResponse> getTime(ServerRequest serverRequest){
        return ServerResponse.ok().body(Mono.just("Now is " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))),String.class);
    }

    public Mono<ServerResponse> getDate(ServerRequest serverRequest){
        return ServerResponse.ok().body(Mono.just("Now is " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))),String.class);
    }

    public Mono<ServerResponse> timeInterval(ServerRequest serverRequest) {
        return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM).body(
                Flux.interval(Duration.ofSeconds(1)).
                        map(l -> LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))),
                String.class);
    }
}
