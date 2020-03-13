package com.queue.your.patient;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.queue.your.patient.infrastructure.Profiles;

@ExtendWith(SpringExtension.class)
@ActiveProfiles(profiles = {Profiles.TEST})
@ContextConfiguration
@SpringBootTest(
        classes = {Application.class, TestConfiguration.class},
        webEnvironment = SpringBootTest.WebEnvironment.NONE
)
public class IntegrationTest {
}
