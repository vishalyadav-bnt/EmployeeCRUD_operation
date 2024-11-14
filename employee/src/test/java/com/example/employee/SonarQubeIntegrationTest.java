package com.example.employee;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import java.time.Duration;

public class SonarQubeIntegrationTest {
    @Test
    public void runSonarQubeScan() {
        // In the GitHub Action environment, SonarQube is already running as a service
        // This test should only start SonarQube when running locally
        if (System.getenv("GITHUB_ACTIONS") == null) {
            try (GenericContainer<?> sonarqube = new GenericContainer<>("sonarqube:community")
                    .withExposedPorts(9000)
                    .waitingFor(Wait.forHttp("/")
                            .forStatusCode(200)
                            .withStartupTimeout(Duration.ofMinutes(5)))) {
                
                sonarqube.start();
                System.out.println("SonarQube started: " + sonarqube.isRunning());
                
                Integer mappedPort = sonarqube.getMappedPort(9000);
                System.out.println("SonarQube is mapped to localhost port: " + mappedPort);
                
                if (sonarqube.isRunning()) {
                    System.out.println("SonarQube is running successfully on port " + mappedPort);
                    
                    // Set system property for Gradle to use
                    System.setProperty("sonar.host.url", "http://localhost:" + mappedPort);
                } else {
                    System.err.println("SonarQube container failed to start.");
                }
                
            } catch (Exception e) {
                System.err.println("Error starting SonarQube container: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("Running in GitHub Actions - skipping local SonarQube container");
        }
    }
}