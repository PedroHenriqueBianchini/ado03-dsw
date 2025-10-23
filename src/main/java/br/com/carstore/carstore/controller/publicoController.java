package br.com.carstore.carstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class publicoController {
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String autenticar(@RequestParam String email,
                             @RequestParam String senha,
                             Model model) {

        if (email.equals("admin@carstore.com") && senha.equals("123")) {
            return "redirect:/dashboard";
        } else {
            model.addAttribute("erro", "Email ou senha inválidos!");
            return "login";
        }
    }

    @GetMapping("/cadastro")
    public String cadastroPage() {
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrar(@RequestParam String nome,
                            @RequestParam String email,
                            @RequestParam String senha,
                            Model model) {
        model.addAttribute("mensagem", "Usuário cadastrado com sucesso!");
        return "login";
    }
}