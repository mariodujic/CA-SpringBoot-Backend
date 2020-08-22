package com.groundzero.camw;

import com.groundzero.camw.data.WriteJsonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class CamwApplication {

  private final WriteJsonService writeJsonService;

  public CamwApplication(WriteJsonService writeJsonService) {
    this.writeJsonService = writeJsonService;
  }

  public static void main(String[] args) {
    SpringApplication.run(CamwApplication.class, args);
  }

  @EventListener(ApplicationReadyEvent.class)
  public void doSomethingAfterStartup() {
    writeJsonService.writeJson();
  }
}
