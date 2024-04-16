package edu.wgu.d387_sample_code.rest;

import edu.wgu.d387_sample_code.il8n.DisplayMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping( "/welcome")
public class WelcomeController {

    @GetMapping("/messages")
    public String[] main() {
        DisplayMessage displayMessage = new DisplayMessage();
        return displayMessage.getWelcomeMessage();
    }
}
