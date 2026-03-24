package co.escuelaing.edu.co.examen2.controller;

import co.escuelaing.edu.co.examen2.model.Math;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/math")
public class MathController {

    @GetMapping("/factors")
    public Math factors(@RequestParam int value) {

        List<Integer> factors = new ArrayList<>();

        for (int i = 1; i <= value; i++) {
            if (value % i == 0) {
                factors.add(i);
            }
        }

        String output = listToString(factors);

        return new Math("factores", value, output);
    }

        @GetMapping("/primes")
    public Math primes(@RequestParam int value) {

        List<Integer> primes = new ArrayList<>();

        for (int i = 1; i <= value; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count == 2) {
                primes.add(i);
            }
            if (i == 1) {
                primes.add(1);
            }
        }

        String output = listToString(primes);

        return new Math("primos", value, output);
    }

    private String listToString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(",");
            }
        }

        return sb.toString();
    }
}
