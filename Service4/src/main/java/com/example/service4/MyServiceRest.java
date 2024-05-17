package com.example.service4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyServiceRest {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/checkNumber")
    public String checkNumber() {
        // L'URL de votre service1 dans le cluster Kubernetes
        String service1Url = "http://service1.default.svc.cluster.local:8080/generateRandomNumber";
        
        // Appel à service1 pour obtenir le nombre aléatoire
        String response = restTemplate.getForObject(service1Url, String.class);

        // Extraction du nombre de la réponse
        int number = Integer.parseInt(response.split(":")[1].trim());

        // Déterminer si le nombre est pair ou impair
        if (number % 2 == 0) {
            return number + " est un nombre pair.";
        } else {
            return number + " est un nombre impair.";
        }
    }
}
