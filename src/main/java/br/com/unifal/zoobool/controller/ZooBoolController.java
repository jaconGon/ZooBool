package br.com.unifal.zoobool.controller;


import br.com.unifal.zoobool.entity.Animal;
import br.com.unifal.zoobool.service.AnimalService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Log4j2
@Controller
@AllArgsConstructor
public class ZooBoolController {

    private final AnimalService service;

    @GetMapping("/")
    public String getHome(){
        return "home";
    }

    @GetMapping("/animals")
    public String animal(Model model){
        List<Animal> animals = service.getAllAnimals();
        model.addAttribute("animals", animals);
        return "animals";
    }

    @GetMapping("/animal")
    public String animal(Animal animal){
        return "newanimal";
    }

    @PostMapping("/animal")
    public String newAnimal(@ModelAttribute("animal") Animal animal) {
        log.info("Novo animal cadastrado");
        service.add(animal);
        return "newanimal";
    }

}
