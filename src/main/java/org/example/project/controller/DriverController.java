package org.example.project.controller;

import jakarta.validation.Valid;
import org.example.project.model.Driver;
import org.example.project.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/drivers")
public class DriverController {

    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("drivers", driverService.getAllDrivers());
        return "driver_list";
    }

    @GetMapping("/detail/{index}")
    public String detail(Model model, @PathVariable  int index) {
        Driver driver = driverService.getDriverById(index);

        if (driver == null) {
            return "redirect:/drivers/";
        }

        model.addAttribute("driver", driver);
        return "driver_detail";
    }

    @GetMapping("/delete/{index}")
    public String delete(@PathVariable int index) {
        driverService.removeDriverById(index);
        return "redirect:/drivers/";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("driver", new Driver());
        model.addAttribute("edit", false);
        return "driver_edit";
    }

    @GetMapping("/edit/{index}")
    public String edit(Model model, @PathVariable int index) {
        Driver driver = driverService.getDriverById(index);

        if (driver == null) {
            return "redirect:/drivers/";
        }

        driver.setId(index);
        model.addAttribute("driver", driver);
        model.addAttribute("edit", true);

        return "driver_edit";
    }

    @PostMapping("/save")
    public String save(@Valid Driver driver, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("edit", driver.getId() != 0);
            return "driver_edit";
        }

        driverService.saveDriver(driver);
        return "redirect:/drivers/";
    }
}
