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
import org.springframework.web.bind.annotation.RequestParam;

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
    private final AdminService adminservice;


//===============================index===============================//

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/home")
    public String getHome() {
        return "home";
    }

//==============================admin=================================//

    @PostMapping(value = "/home")
    public String login(@ModelAttribute Admin admin, Model model) {
        if (adminservice.autenticate(admin.getUsername(), admin.getPassword())) {
            return "/home";
        } else {
            model.addAttribute("mensagem", "Falha na autenticação");
            return "/";
        }
    }

    
//==============================animal===============================//
    @GetMapping("/animals")
    public String animal(Model model) {
        List<Animal> animals = animalservice.getAllAnimals();
        model.addAttribute("animals", animals);
        return "animals";
    }

//    @GetMapping("/animal")
//    public String animal(Animal animal) {
//        return "newanimal";
//    }
//
//
//    @PostMapping("/animal")
//    public String newAnimal(@ModelAttribute("animal") Animal animal) {
//        log.info("Novo animal cadastrado");
//        animalservice.add(animal);
//        return "newanimal";
//    }

    @GetMapping("/addAnimal")
    public String getAddAnimal(){
        return "new-animal";
    }

    @PostMapping("/addAnimal")
    public String newGuest(@RequestParam String tamanho,
                           @RequestParam String n_cientifico,
                           @RequestParam Integer id_habitat,
                           @RequestParam String especie,
                           @RequestParam Integer id_vet,
                           @RequestParam Integer idade,
                           @RequestParam Float peso,
                           @RequestParam String nome) {
        Animal newAnimal = Animal.builder()
                .nome(nome)
                .tamanho(tamanho)
                .n_cientifico(n_cientifico)
                .id_habitat(id_habitat)
                .especie(especie)
                .id_vet(id_vet)
                .idade(idade)
                .peso(peso)
                .build();

        animalservice.saveAnimal(newAnimal);

        return "redirect:/animals";
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
        return "ordered-animals-a";

    }

    @GetMapping("/orderedanimalztoa")
    public String orderedAnimalZtoA(Model model) {
        List<Animal> animais = animalservice.orderAnimalZtoA();
        model.addAttribute("animais", animais);
        return "ordered-animals-z";
    }


    //============================funcionarios============================//



    @GetMapping("/funcionarios")
    public String funcionario(Model model) {
        List<Funcionario> funcionarios = funcionarioservice.getAllFuncionarios();
        model.addAttribute("funcionarios", funcionarios);
        return "funcionarios";
    }

    @GetMapping("/addFuncionario")
    public String getAddGuest(){
        return "new-funcionario";
    }

    @PostMapping("/addFuncionario")
    public String newGuest(@RequestParam String pnome,
                           @RequestParam String snome,
                           @RequestParam String cpf,
                           @RequestParam String telefone,
                           @RequestParam Float salario,
                           @RequestParam Integer horas_trabalho) {
        Funcionario newFuncionario = Funcionario.builder()
                .pnome(pnome)
                .snome(snome)
                .cpf(cpf)
                .telefone(telefone)
                .salario(salario)
                .horas_trabalho(horas_trabalho)
                .build();

        funcionarioservice.saveFuncionario(newFuncionario);

        return "redirect:/funcionarios";
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