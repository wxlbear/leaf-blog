package xyz.bbear.flux.api.config;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import xyz.bbear.flux.api.handler.HomeHandler;
import xyz.bbear.flux.api.handler.TimeHandler;

/**
 * RoutingConfiguration.
 *
 * @author xiongliu wu 2019-04-24 17:25
 */
@Configuration
public class RoutingConfiguration {

    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction(HomeHandler homeHandler) {
        return RouterFunctions.route(GET("/flux/home/{id}").and(accept(APPLICATION_JSON)), homeHandler::getHome);
    }

    @Bean
    public RouterFunction<ServerResponse> timeRouteFunction(TimeHandler timeHandler){
        return RouterFunctions.route(GET("/time").and(accept(APPLICATION_JSON)), timeHandler::getTime)
                .andRoute(GET("/date").and(accept(APPLICATION_JSON)), timeHandler::getDate)
                .andRoute(GET("/times"), timeHandler::timeInterval);
    }

}
