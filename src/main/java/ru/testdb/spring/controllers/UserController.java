package ru.testdb.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.testdb.spring.models.User;
import ru.testdb.spring.services.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String usersPage(Model model) {
        model.addAttribute("listUser", userService.index());
        return "users";
    }

    @GetMapping("/show")
    public String show(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String create(@Valid @ModelAttribute("user") User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }

        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam(value = "id") int id) {
        model.addAttribute("user", userService.show(id));
        return "edit";
    }

    @PutMapping("/edit")
    public String update(@Valid @ModelAttribute("user") User user,
                         BindingResult bindingResult,
                         @RequestParam(value = "id") int id) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }

        userService.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam(value = "id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }
}