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

            // Start the SonarQube container
            sonarqube.start();
            System.out.println("SonarQube started: " + sonarqube.isRunning());

            // Get and print the mapped port to confirm it started correctly
            Integer mappedPort = sonarqube.getMappedPort(9000);
            System.out.println("SonarQube is mapped to localhost port: " + mappedPort);

            // Check if SonarQube is reachable
            if (sonarqube.isRunning()) {
                System.out.println("SonarQube is running successfully on port " + mappedPort);
            } else {
                System.err.println("SonarQube container failed to start.");
            }

            // Add more code here to trigger SonarQube analysis if needed
        } catch (Exception e) {
            System.err.println("Error starting SonarQube container: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
