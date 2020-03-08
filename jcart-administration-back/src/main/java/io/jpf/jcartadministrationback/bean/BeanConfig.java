package io.jpf.jcartadministrationback.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.SecureRandom;

@Configuration
public class BeanConfig {

    @Bean
    //SecureRandom 一个安全的随机类  出来的数是概率均衡的
    public SecureRandom secureRandom(){
        return new SecureRandom();
    }

}