package com.aaj.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trucks") // optional base route
public class TruckController {

    @GetMapping("/pickup")
    public void pickup() {
        // Empty method
    }

    @GetMapping("/semitruck")
    public void semitruck() {
        // Empty method
    }

    @GetMapping("/boxtruck")
    public void boxtruck() {
        // Empty method
    }

    @GetMapping("/dumptruck")
    public void dumptruck() {
        // Empty method
    }

    @GetMapping("/firetruck")
    public void firetruck() {
        // Empty method
    }

    @GetMapping("/garbagetruck")
    public void garbagetruck() {
        // Empty method
    }

    @GetMapping("/tanker")
    public void tanker() {
        // Empty method
    }

    @GetMapping("/towtruck")
    public void towtruck() {
        // Empty method
    }

    @GetMapping("/refrigerated")
    public void refrigerated() {
        // Empty method
    }

    @GetMapping("/flatbed")
    public void flatbed() {
        // Empty method
    }
}