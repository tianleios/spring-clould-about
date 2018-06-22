package com.tl;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Service;

@Service
public class Play implements SmartInitializingSingleton {

//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;

//    @KafkaListener(topics = {"first"})
//    public void receive(@Payload String msg, @Headers MessageHeaders headers) {
//        int a;
//    }


    @Override
    public void afterSingletonsInstantiated() {



    }
}
