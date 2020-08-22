package com.groundzero.camw;

import com.groundzero.camw.data.AutoUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class CamwApplication {

  private final AutoUpdate autoUpdate;

  public CamwApplication(AutoUpdate autoUpdate) {
    this.autoUpdate = autoUpdate;
  }

  public static void main(String[] args) {
    SpringApplication.run(CamwApplication.class, args);
  }

  @EventListener(ApplicationReadyEvent.class)
  public void doSomethingAfterStartup() {
    autoUpdate.getData();
  }
}
