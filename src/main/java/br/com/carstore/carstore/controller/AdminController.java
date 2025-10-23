package br.com.carstore.carstore.controller;

import br.com.carstore.carstore.model.CarDTO;
import br.com.carstore.carstore.service.CarService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final CarService carService;

    public AdminController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<CarDTO> cars = carService.findAll();
        model.addAttribute("cars", cars);
        model.addAttribute("carDTO", new CarDTO()); // <- adicione isto
        return "admin/dashboard";
    }

    @GetMapping("/cars/new")
    public String newCarForm(Model model) {
        model.addAttribute("carDTO", new CarDTO());
        return "admin/car-form";
    }

    @PostMapping("/cars")
    public String createCar(@Valid @ModelAttribute CarDTO carDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "admin/car-form";
        }

        carService.save(carDTO);
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/cars/edit/{id}")
    public String editCarForm(@PathVariable int id, Model model) {
        CarDTO car = carService.findById(id);
        if (car == null) {
            return "redirect:/admin/dashboard";
        }
        model.addAttribute("carDTO", car);
        return "admin/car-edit";
    }

    @PostMapping("/cars/update/{id}")
    public String updateCar(@PathVariable int id, @Valid @ModelAttribute CarDTO carDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            carDTO.setId(id);
            model.addAttribute("carDTO", carDTO);
            return "admin/car-edit";
        }

        carService.update(id, carDTO);
        return "redirect:/admin/dashboard";
    }

    @PostMapping("/cars/delete/{id}")
    public String deleteCar(@PathVariable int id) {
        carService.deleteById(id);
        return "redirect:/admin/dashboard";
    }
}