package wifi4eu.wifi4eu.service.abac;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@EnableScheduling
public class CronAbac {
    int counter = 0;

    @Scheduled(fixedRate = 5000)
    public void test() {
        System.out.println("Hello! The time is " + new Date().toString() + ", and the counter is at " + counter);
        counter += 5;
    }
}
