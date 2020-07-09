package ch.nblotti.achilleus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@SpringBootApplication
@EnableScheduling
@EnableCaching
public class AchilleusApplication {

  public static void main(String[] args) {
    SpringApplication.run(AchilleusApplication.class, args);
  }



  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
    return restTemplateBuilder
      .setConnectTimeout(Duration.ofSeconds(30))
      .setReadTimeout(Duration.ofSeconds(30))
      .build();
  }

  @Bean
  public RestTemplate restTemplate() {
    RestTemplate rt = new RestTemplate();
    rt.getMessageConverters().add(new StringHttpMessageConverter());
    return rt;

  }


}
