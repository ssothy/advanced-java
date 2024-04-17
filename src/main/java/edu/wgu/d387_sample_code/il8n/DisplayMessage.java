package edu.wgu.d387_sample_code.il8n;

import java.util.ResourceBundle;


public class DisplayMessage {

    private final ResourceBundle englishBundle;
    private final ResourceBundle frenchBundle;

    public DisplayMessage() {
        this.englishBundle = ResourceBundle.getBundle("welcome_en_US");
        this.frenchBundle = ResourceBundle.getBundle("welcome_fr_CA");
    }

    public String[] getWelcomeMessage() {
        String englishMessage = englishBundle.getString("welcome");
        String frenchMessage = frenchBundle.getString("welcome");
        return new String[]{englishMessage, frenchMessage};
    }
}