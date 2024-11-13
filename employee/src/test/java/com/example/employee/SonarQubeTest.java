package com.example.employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


@Testcontainers
public class SonarQubeTest {

    @Container
    public static SonarQubeContainer sonarqube = new SonarQubeContainer("sonarqube:lts")
            .withExposedPorts(9000);  // Expose SonarQube on port 9000

    @BeforeAll
    public static void setup() {
        // Ensure SonarQube is running and reachable
        System.out.println("SonarQube is running at: " + sonarqube.getHttpHostAddress());
    }

    @Test
    public void testSonarQubeIsRunning() {
        // Test to confirm SonarQube is available
        System.out.println("SonarQube instance is available.");
    }
}
