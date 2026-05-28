package com.proyecto.shreg.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.proyecto.shreg.repository.PeticionRepository;
import com.proyecto.shreg.model.Peticion;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final PeticionRepository peticionRepository;

    public HomeController(PeticionRepository peticionRepository) {
        this.peticionRepository = peticionRepository;
    }

    @GetMapping("/")
    public String inicio() {
        return "index";
    }

    @GetMapping("/nueva/{habitacion}")
    public String nuevaPeticion(@PathVariable String habitacion, Model model) {
        model.addAttribute("habitacion", habitacion);
        return "nuevaPeticion";
    }

    @GetMapping("/gracias")
    public String gracias() {
        return "gracias";
    }

    @GetMapping("/peticiones")
    public String verPeticiones(Model model, HttpSession session) {

        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/";
        }

        model.addAttribute("listaPeticiones", peticionRepository.findAll());
        return "peticiones";
    }

    @GetMapping("/enProceso/{id}")
    public String enProceso(@PathVariable int id) {

        Peticion peticion = peticionRepository.findById(id).orElse(null);

        if (peticion != null) {
            peticion.setEstado("En proceso");
            peticionRepository.save(peticion);
        }

        return "redirect:/peticiones";
    }

    @GetMapping("/completar/{id}")
    public String completarPeticion(@PathVariable int id) {

        Peticion peticion = peticionRepository.findById(id).orElse(null);

        if (peticion != null) {
            peticion.setEstado("Completada");
            peticionRepository.save(peticion);
        }

        return "redirect:/peticiones";
    }

    @GetMapping("/recepcion")
    public String recepcion(HttpSession session) {

        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/login";
        }

        return "recepcion";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/guardar")
    public String guardarPeticion(
            Integer habitacion,
            String tipo,
            String comentario) {

        Peticion nuevaPeticion = new Peticion(habitacion, tipo, comentario);

        peticionRepository.save(nuevaPeticion);

        return "gracias";
    }

    @PostMapping("/validarLogin")
    public String validarLogin(
            String usuario,
            String password,
            Model model,
            HttpSession session) {

        if (usuario.equals("recepcion") && password.equals("1234")) {
            session.setAttribute("usuarioLogueado", true);
            return "redirect:/login";
        }

        model.addAttribute("error", true);
        return "index";
    }

    @PostMapping("/peticiones/guardar")
    public String guardarPeticion(
            @RequestParam String categoria,
            @RequestParam String tipo,
            @RequestParam Integer habitacion) {

        Peticion peticion = new Peticion();

        peticion.setCategoria(categoria);
        peticion.setTipo(tipo);
        peticion.setHabitacion(habitacion);
        peticion.setEstado("Pendiente");
        peticion.setFechaCreacion(LocalDateTime.now());

        peticionRepository.save(peticion);

        return "redirect:/gracias";
    }
}
