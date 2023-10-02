package com.aaj.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/micro")
public class MicroMobilityController {

    @GetMapping("/bicycle")
    public void bicycle() {
        // Empty method
    }

    @GetMapping("/scooter")
    public void scooter() {
        // Empty method
    }

    @GetMapping("/skateboard")
    public void skateboard() {
        // Empty method
    }

    @GetMapping("/rollerblades")
    public void rollerblades() {
        // Empty method
    }

    @GetMapping("/unicycle")
    public void unicycle() {
        // Empty method
    }

    @GetMapping("/hoverboard")
    public void hoverboard() {
        // Empty method
    }
}
