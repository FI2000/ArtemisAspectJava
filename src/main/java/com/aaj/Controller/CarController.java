package com.aaj.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/car") // optional base route
public class CarController {

    @GetMapping("/lamborghini")
    public void lamborghini() {
        // Empty method
    }

    @GetMapping("/mazda")
    public void mazda() {
        // Empty method
    }

    @GetMapping("/bugatti")
    public void bugatti() {
        // Empty method
    }

    @GetMapping("/ferrari")
    public void ferrari() {
        // Empty method
    }

    @GetMapping("/porsche")
    public void porsche() {
        // Empty method
    }

    @GetMapping("/audi")
    public void audi() {
        // Empty method
    }

    @GetMapping("/mercedes")
    public void mercedes() {
        // Empty method
    }

    @GetMapping("/bmw")
    public void bmw() {
        // Empty method
    }

    @GetMapping("/tesla")
    public void tesla() {
        // Empty method
    }

    @GetMapping("/rollsRoyce")
    public void rollsRoyce() {
        // Empty method
    }

}
