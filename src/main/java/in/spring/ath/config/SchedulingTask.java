package in.spring.ath.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableAsync
@Component
public class SchedulingTask {

	@Async  // Used for Parallel Process it doesn't wait for last process executed
	@Scheduled(fixedRate = 100)
	public void execute() throws InterruptedException {
		System.out.println("Scheduler Executing...");
		for(int i=0;i<10;i++) {
			System.out.println(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
			Thread.sleep(100);
		}
	}
}
