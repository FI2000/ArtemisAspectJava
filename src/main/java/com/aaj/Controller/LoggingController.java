package com.aaj.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") // optional base route
public class LoggingController {

    @GetMapping("/mug")
    public String mug() {
        return "This is a blue coffee mug";
    }

    @GetMapping("/novel")
    public String novel() {
        return "This is a paperback novel titled 'The Mysterious Island'";
    }

    @GetMapping("/usb")
    public String usb() {
        return "This is a USB flash drive with a keychain";
    }

    @GetMapping("/succulent")
    public String succulent() {
        return "This is a potted succulent plant";
    }

    @GetMapping("/watch")
    public String watch() {
        return "This is a vintage pocket watch";
    }

    @GetMapping("/toy")
    public String toy() {
        return "This is a small plush toy of a panda";
    }

    @GetMapping("/earbuds")
    public String earbuds() {
        return "This is a pair of wireless earbuds in a charging case";
    }

}
