package ru.tsarev.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.tsarev.entities.User;
import ru.tsarev.services.UserService;

@Controller
@AllArgsConstructor
public class UserController {
    private UserService userService;
    @GetMapping("login")
    public String getRegistration(Model model) {
        model.addAttribute("userReg", new User());
        return "enter";
    }

    @PostMapping("reg")
    public String addNewUser(@ModelAttribute("userReg") User user) {
        userService.addUser(user);
        return "redirect:login";
    }
}
