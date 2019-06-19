package com.syamozi.sample.requester.eureka.eurekarequestersample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaRequesterSampleApplication {

  RestTemplate restTemplate = new RestTemplate();
  
  private String url = "http://localhost:8081";
  
  @RequestMapping(value = "/")
  public String home() {
    return restTemplate.getForObject(url, String.class);
  }

  public static void main(String[] args) {
    SpringApplication.run(EurekaRequesterSampleApplication.class, args);
  }

}
