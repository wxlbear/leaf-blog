package xyz.bbear.flux.api.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import xyz.bbear.flux.api.model.Home;

/**
 * HomeService.
 *
 * @author xiongliu wu 2019-04-24 17:09
 */
@Service
public class HomeService {

    private Map<Long, Home> mockDataMap = new HashMap<>();

    @PostConstruct
    public void init(){
        for (int i = 0; i < 10; i++) {
            Home home =new Home();
            home.setId((long)i);
            home.setNumber(new  Random().nextInt());
            home.setAddress("address_"+ i);
            mockDataMap.put((long)i,home);
        }
    }

    public Home get(Long id){
        return this.mockDataMap.get(id);
    }
}
