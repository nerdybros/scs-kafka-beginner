package io.nerdybros.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.nerdybros.course.producer.Producer;

@RestController
@EnableAspectJAutoProxy
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private Producer produer;

	@PostMapping("/send")
	public void sendMessage(@RequestBody String message) {
		produer.sendMessage(message);
	}

	@PostMapping("/send-exactly-once")
	public void sendMessageExactlyOnce(@RequestBody String message) {
		produer.sendMessageExactlyOnce(message);
	}
}
