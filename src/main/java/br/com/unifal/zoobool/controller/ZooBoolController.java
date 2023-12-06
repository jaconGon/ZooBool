package br.com.unifal.zoobool.controller;

import br.com.unifal.zoobool.entity.Manutencao;
import br.com.unifal.zoobool.entity.Ala;
import br.com.unifal.zoobool.entity.Animal;
import br.com.unifal.zoobool.entity.Funcionario;
import br.com.unifal.zoobool.entity.Habitat;
import br.com.unifal.zoobool.service.*;
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

    private final AnimalService animalservice;

    private final FuncionarioService funcionarioservice;

    private final AlaService alaservice;

    private final HabitatService habitatService;

    private final ManutencaoService manutencaoService;

    @GetMapping("/")
    public String getHome(){
        return "home";
    }

    @GetMapping("/animals")
    public String animal(Model model){
        List<Animal> animals = animalservice.getAllAnimals();
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
        animalservice.add(animal);
        return "newanimal";
    }


    @GetMapping("/funcionarios")
    public String funcionario(Model model){
        List<Funcionario> funcionarios = funcionarioservice.getAllFuncionarios();
        model.addAttribute("funcionarios", funcionarios);
        return "funcionarios";
    }

    @GetMapping("/alas")
    public String ala(Model model){
        List<Ala> alas = alaservice.getAllAlas();
        model.addAttribute("alas", alas);
        return "alas";
    }

    @GetMapping("/habitats")
    public String habitat(Model model){
        List<Habitat> habitats = habitatService.getAllHabitats();
        model.addAttribute("habitats", habitats);
        return "habitats";
    }

    @GetMapping("/manutencoes")
    public String manutencao(Model model){
        List<Manutencao> manutencoes = manutencaoService.getAllManutencoes();
        model.addAttribute("manutencoes", manutencoes);
        return "manutencoes";
    }

}
