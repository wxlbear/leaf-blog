package xyz.bbear.flux.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;
import xyz.bbear.flux.api.model.Home;
import xyz.bbear.flux.api.service.HomeService;

/**
 * HomeController.
 *
 * @author xiongliu wu 2019-04-24 17:05
 */
@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HomeService homeService;

    /**
     * 不是很明白Mono 是干吗的，加了Mono 返回的结果和未加是一样的，而且也没有感觉到异步的存在.
     * @param id id
     * @return Mono
     */
    @GetMapping("{id}")
    public Mono<Home> getHome(@PathVariable Long id){
        return Mono.just(this.homeService.get(id));
    }

}
