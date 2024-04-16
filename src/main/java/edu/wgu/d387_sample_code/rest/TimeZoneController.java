package edu.wgu.d387_sample_code.rest;

import edu.wgu.d387_sample_code.il8n.TimeZoneConverter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping( "/welcome")
public class TimeZoneController {

    @GetMapping("/timezones")
    public String getTimeZones() {
        TimeZoneConverter converter = new TimeZoneConverter();

        String convertedTimes = converter.convertTimeZones();

        return convertedTimes;
    }
}
