package org.example.project.controller;

import org.example.project.model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    List<Car> cars = new ArrayList<>();

    @GetMapping("/")
    public String list(Model model) {
        cars.add(new Car("1A2 3456", "red", 60.f, 5));
        model.addAttribute("cars", cars);
        return "list";
    }

    @GetMapping("/detail/{index}")
    public String detail(Model model, @PathVariable  int index) {
        if (index < 0 || index >= cars.size()) {
            return "redirect:/";
        }

        model.addAttribute("car", cars.get(index));
        return "detail";
    }
}
