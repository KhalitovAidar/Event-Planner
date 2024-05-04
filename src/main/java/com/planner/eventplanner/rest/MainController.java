package com.planner.eventplanner.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/community")
public class MainController {
    //Todo: not name - form
    @PostMapping("/create-post")
    @PreAuthorize("hasRole('ADMIN')")
    public void createPost(@RequestParam String name) {

    }
}
