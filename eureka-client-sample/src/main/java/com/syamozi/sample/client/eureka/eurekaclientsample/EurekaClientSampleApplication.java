package com.syamozi.sample.client.eureka.eurekaclientsample;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class EurekaClientSampleApplication {

  @RequestMapping(value = "/greeting")
  public String greet() {
//    log.info("Access /greeting");

    List<String> greetings = Arrays.asList("Hi there", "Greetings", "Salutations");
    Random rand = new Random();

    int randomNum = rand.nextInt(greetings.size());
    return greetings.get(randomNum);
  }

  @RequestMapping(value = "/")
  public String home() {
//    log.info("Access /");
    return "Hi!";
  }

  public static void main(String[] args) {
    SpringApplication.run(EurekaClientSampleApplication.class, args);
  }

}
