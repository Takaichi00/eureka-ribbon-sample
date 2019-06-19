package com.syamozi.sample.requester.eureka.eurekarequestersample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RibbonClient(name = "sayhello", configuration = SayHelloConfiguration.class)
public class EurekaRequesterSampleApplication {

  @LoadBalanced
  @Bean
  RestTemplate restTemplate(){
    return new RestTemplate();
  }

  @Autowired
  RestTemplate restTemplate;
  
  private String url = "http://sayhello";
  
  @RequestMapping(value = "/")
  public String home() {
    return restTemplate.getForObject(url, String.class);
  }

  public static void main(String[] args) {
    SpringApplication.run(EurekaRequesterSampleApplication.class, args);
  }

}
