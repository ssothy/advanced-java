package edu.wgu.d387_sample_code.rest;

import edu.wgu.d387_sample_code.il8n.DisplayMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping( "/welcome")
public class WelcomeController {

    @GetMapping("/messages")
    public ResponseEntity<Map<String, String[]>> getWelcomeMessages() {
        DisplayMessage displayMessage = new DisplayMessage();

        CompletableFuture<String[]> englishFuture = CompletableFuture.supplyAsync(displayMessage::getWelcomeMessage);

        CompletableFuture<String[]> frenchFuture = CompletableFuture.supplyAsync(displayMessage::getWelcomeMessage);

        CompletableFuture.allOf(englishFuture, frenchFuture).join();

        String[] englishMessages = englishFuture.join();
        String[] frenchMessages = frenchFuture.join();

        System.out.println("English Message: " + englishMessages[0]);
        System.out.println("French Message: " + frenchMessages[1]);

        Map<String, String[]> response = new HashMap<>();
        response.put("messages", new String[]{englishMessages[0], frenchMessages[1]});

        return ResponseEntity.ok(response);
    }
}