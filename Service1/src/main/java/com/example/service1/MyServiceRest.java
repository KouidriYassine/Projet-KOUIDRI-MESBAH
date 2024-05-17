package com.example.service1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;

@RestController
public class MyServiceRest {

    @GetMapping("/generateRandomNumber")
    public String generateRandomNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt();
        return "Le nombre aléatoire généré est : " + randomNumber;
    }
}
