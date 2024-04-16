package edu.wgu.d387_sample_code.il8n;


import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DisplayMessage {
    private static final ExecutorService messageExecutor = Executors.newFixedThreadPool(2);

    public String[] getWelcomeMessage() {
        Properties properties = new Properties();
        String[] welcomeMessages = new String[2];

        // Create CompletableFuture for each message retrieval
        CompletableFuture<Void> englishMessageFuture = CompletableFuture.runAsync(() -> {
            try {
                InputStream stream = new ClassPathResource("welcome_en_US.properties").getInputStream();
                properties.load(stream);
                welcomeMessages[0] = properties.getProperty("welcome");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, messageExecutor);

        CompletableFuture<Void> frenchMessageFuture = CompletableFuture.runAsync(() -> {
            try {
                InputStream stream = new ClassPathResource("welcome_fr_CA.properties").getInputStream();
                properties.load(stream);
                welcomeMessages[1] = properties.getProperty("welcome");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, messageExecutor);

        // Wait for both CompletableFuture to complete
        CompletableFuture.allOf(englishMessageFuture, frenchMessageFuture).join();

        return welcomeMessages;
    }
}
