package com.codeup.ovalleblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.ThreadLocalRandom;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String guess() {
        return "dice-guess";
    }

    @GetMapping("/roll-dice/{n}")
    public String result(@PathVariable int n, Model model) {
        String message;
        int randomNum1 = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        int randomNum2 = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        int randomNum3 = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        int randomNum4 = ThreadLocalRandom.current().nextInt(1, 6 + 1);

        if (n == randomNum1 || n == randomNum2 || n == randomNum3 || n == randomNum4){
            message = "Yay, you guessed correctly!";
        } else {
            message = "Sorry, guess again";
        }

        model.addAttribute("randomNumber1", randomNum1);
        model.addAttribute("randomNumber2", randomNum2);
        model.addAttribute("randomNumber3", randomNum3);
        model.addAttribute("randomNumber4", randomNum4);
        model.addAttribute("guess", n);
        model.addAttribute("message", message);

        return "dice-result";
    }
}
