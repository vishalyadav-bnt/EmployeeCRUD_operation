package com.example.employee;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
 
public class SonarQubeIntegrationTest {
 
    @Test
    public void runSonarQubeScan() {
        try (@SuppressWarnings("resource")
        GenericContainer<?> sonarqube = new GenericContainer<>("sonarqube:community")
                .withExposedPorts(9000)
                .waitingFor(Wait.forHttp("/").forStatusCode(200))) {
 
            sonarqube.start();
 
        }
    }
}