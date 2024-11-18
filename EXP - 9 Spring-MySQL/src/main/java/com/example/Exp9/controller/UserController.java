package com.giridharan.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.giridharan.todo.model.User;
import com.giridharan.todo.repository.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, @ModelAttribute User user) {
        user.setId(id);
        userRepository.save(user);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "redirect:/";
    }
}
