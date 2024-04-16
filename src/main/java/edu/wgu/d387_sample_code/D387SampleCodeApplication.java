package edu.wgu.d387_sample_code;


import edu.wgu.d387_sample_code.il8n.DisplayMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class D387SampleCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(D387SampleCodeApplication.class, args);

		DisplayMessage displayMessage = new DisplayMessage();

		Thread englishThread = new Thread(() -> {
			String[] messages = displayMessage.getWelcomeMessage();
			System.out.println("English Message: " + messages[0]);
		});

		Thread frenchThread = new Thread(() -> {
			String[] messages = displayMessage.getWelcomeMessage();
			System.out.println("French Message: " + messages[1]);
		});

		englishThread.start();
		frenchThread.start();
	}
}


