package br.com.unifal.zoobool.controller;

import br.com.unifal.zoobool.entity.*;
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

    private final HabitatService habitatservice;

    private final ManutencaoService manutencaoservice;

    private final ZeladorService zeladorservice;

    private final VeterinarioService veterinarioservice;

    private final TratadorService tratadorservice;

    private final ReptilService reptilservice;

    private final MamiferoService mamiferoservice;


//===============================index===============================//

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/home")
    public String getHome() {
        return "home";
    }

    
//==============================animal===============================//
    @GetMapping("/animals")
    public String animal(Model model) {
        List<Animal> animals = animalservice.getAllAnimals();
        model.addAttribute("animals", animals);
        return "animals";
    }


    @GetMapping("/animal")
    public String animal(Animal animal) {
        return "newanimal";
    }


    @PostMapping("/animal")
    public String newAnimal(@ModelAttribute("animal") Animal animal) {
        log.info("Novo animal cadastrado");
        animalservice.add(animal);
        return "newanimal";
    }


    @GetMapping("/mamiferos")
    public String mamifero(Model model) {
        List<Mamifero> mamiferos = mamiferoservice.getAllMamiferos();
        model.addAttribute("mamiferos", mamiferos);
        return "mamiferos";
    }

    @GetMapping("/repteis")
    public String Reptil(Model model) {
        List<Reptil> repteis = reptilservice.getAllRepteis();
        model.addAttribute("repteis", repteis);
        return "repteis";
    }


    @GetMapping("/orderedanimalatoz")
    public String orderedAnimalAtoZ(Model model) {
        List<Animal> animais = animalservice.orderAnimalAtoZ();
        model.addAttribute("animais", animais);
        return "ordered-animals";

    }

    @GetMapping("/orderedanimalztoa")
    public String orderedAnimalZtoA(Model model) {
        List<Animal> animais = animalservice.orderAnimalZtoA();
        model.addAttribute("animais", animais);
        return "ordered-animals";

    }


    //============================funcionarios============================//
    @GetMapping("/funcionarios")
    public String funcionario(Model model) {
        List<Funcionario> funcionarios = funcionarioservice.getAllFuncionarios();
        model.addAttribute("funcionarios", funcionarios);
        return "funcionarios";
    }


    //==============================alas=================================//
    @GetMapping("/alas")
    public String ala(Model model) {
        List<Ala> alas = alaservice.getAllAlas();
        model.addAttribute("alas", alas);
        return "alas";
    }


    //=============================habitats==============================//
    @GetMapping("/habitats")
    public String habitat(Model model) {
        List<Habitat> habitats = habitatservice.getAllHabitats();
        model.addAttribute("habitats", habitats);
        return "habitats";
    }


    //==========================manutencoes=============================//
    @GetMapping("/manutencoes")
    public String manutencao(Model model) {
        List<Manutencao> manutencoes = manutencaoservice.getAllManutencoes();
        model.addAttribute("manutencoes", manutencoes);
        return "manutencoes";
    }


    @GetMapping("/zeladores")
    public String zelador(Model model) {
        List<Zelador> zeladores = zeladorservice.getAllZeladores();
        model.addAttribute("zeladores", zeladores);
        return "zeladores";
    }

    @GetMapping("/veterinarios")
    public String veterinario(Model model) {
        List<Veterinario> veterinarios = veterinarioservice.getAllVeterinarios();
        model.addAttribute("veterinarios", veterinarios);
        return "veterinarios";
    }

    @GetMapping("/tratadores")
    public String tratador(Model model) {
        List<Tratador> tratadores = tratadorservice.getAllTratadores();
        model.addAttribute("tratadores", tratadores);
        return "tratadores";
    }
}