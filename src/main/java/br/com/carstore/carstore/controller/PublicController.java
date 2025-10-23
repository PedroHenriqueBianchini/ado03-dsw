package br.com.carstore.carstore.controller;

import br.com.carstore.carstore.model.CarDTO;
import br.com.carstore.carstore.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/public")
public class PublicController {

    private final CarService carService;

    public PublicController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String publicHome(Model model) {
        List<CarDTO> cars = carService.findAll();
        model.addAttribute("cars", cars);
        return "public/home";
    }
}