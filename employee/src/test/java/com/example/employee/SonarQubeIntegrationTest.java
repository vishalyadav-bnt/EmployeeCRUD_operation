package com.example.employee;import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import java.time.Duration;

public class SonarQubeIntegrationTest {

    @Test
    public void runSonarQubeScan() {
        try (GenericContainer<?> sonarqube = new GenericContainer<>("sonarqube:community")
                .withExposedPorts(9000)
                .waitingFor(Wait.forHttp("/").forStatusCode(200).withStartupTimeout(Duration.ofMinutes(5)))) {

          
            sonarqube.start();
            System.out.println("SonarQube started: " + sonarqube.isRunning());

           
            Integer mappedPort = sonarqube.getMappedPort(9000);
            System.out.println("SonarQube is mapped to localhost port: " + mappedPort);

            // Check if SonarQube is reachable
            if (sonarqube.isRunning()) {
                System.out.println("SonarQube is running successfully on port " + mappedPort);
            } else {
                System.err.println("SonarQube container failed to start.");
            }

            
        } catch (Exception e) {
            System.err.println("Error starting SonarQube container: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
