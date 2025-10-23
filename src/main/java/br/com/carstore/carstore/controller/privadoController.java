package br.com.carstore.carstore.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

    @Controller
    public class privadoController {

        @GetMapping("/dashboard")
        public String dashboard() {
            return "dashboard";
        }

        @GetMapping("/perfil")
        public String perfil() {
            return "perfil";
        }

        @GetMapping("/logout")
        public String logout() {
            return "redireciona:/login";
        }
    }