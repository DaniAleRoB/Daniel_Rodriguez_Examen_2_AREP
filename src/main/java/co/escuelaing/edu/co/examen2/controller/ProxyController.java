package co.escuelaing.edu.co.examen2.controller;

import co.escuelaing.edu.co.examen2.service.HttpService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProxyController {

    private final HttpService httpService = new HttpService();

    private String service1 = System.getenv("SERVICE1_URL");
    private String service2 = System.getenv("SERVICE2_URL");

    @GetMapping("/factors")
    public String factors(@RequestParam String value) {

        try {
            return httpService.get(service1 + "/math/factors?value=" + value);
        } catch (Exception e) {
            return httpService.get(service2 + "/math/factors?value=" + value);
        }
    }

    @GetMapping("/primes")
    public String primes(@RequestParam String value) {

        try {
            return httpService.get(service1 + "/math/primes?value=" + value);
        } catch (Exception e) {
            return httpService.get(service2 + "/math/primes?value=" + value);
        }
    }
}