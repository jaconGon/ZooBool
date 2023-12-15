package br.com.unifal.zoobool.controller;

import br.com.unifal.zoobool.entity.*;
import br.com.unifal.zoobool.service.*;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@Controller
@AllArgsConstructor
public class ZooBoolController {

    private final AnimalService animalservice;
    private final FuncionarioService funcionarioservice;
    private final AlaService alaservice;

    private final HabitatService habitatservice;


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
        if (adminservice.authenticate(admin.getUsername(), admin.getPassword())) {
            return "/home";
        } else {
            model.addAttribute("mensagem", "Falha na autenticação");
            return "/";
        }
    }

    
//==============================animal===============================//
    @GetMapping("/animals")
    public String animal(Model model) {
        List<Animal> animais = animalservice.getAllAnimals();
        model.addAttribute("animais", animais);
        return "animals";
    }

    @GetMapping("/mamiferosanimals")
    public String animalMam(Model model) {
        List<Animal> animals = animalservice.findAnimaisComMamiferos();
        model.addAttribute("animals", animals);
        return "mamiferos-animals";
    }
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
                .peso(Double.valueOf(peso))
                .build();

        animalservice.saveAnimal(newAnimal);

        return "redirect:/animals";
    }

    @GetMapping("/deleteAnimal/{id_animal}")
    public String getAnimal(@PathVariable Integer id_animal, Model model) {
        animalservice.deleteAnimal(id_animal);
        List<Animal> animais = animalservice.getAllAnimals();
        model.addAttribute("animais", animais);
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

    @GetMapping("/filtrotam")
    public String filtro_tam(Model model) {
        List<Animal> animais = animalservice.filtroTam();
        model.addAttribute("animais", animais);
        return "filtered-animals-ta";

    }

    @GetMapping("/filtrotipo")
    public String filtro_tipo(Model model) {
        List<Animal> animais = animalservice.filtroTipo();
        model.addAttribute("animais", animais);
        return "filtered-animals-ti";

    }

    @GetMapping("/filtronome")
    public String filtro_nome(Model model) {
        List<Animal> animais = animalservice.filtroNome();
        model.addAttribute("animais", animais);
        return "filtered-animals-no";

    }

    @GetMapping("/filtropequenohab")
    public String filtro_HabPe(Model model) {
        List<Animal> animais = animalservice.filtroHabPe();
        model.addAttribute("animais", animais);
        return "filtered-animals-habpe";

    }

    @GetMapping("/filtrovetpeso")
    public String filtro_VetPe(Model model) {
        List<Animal> animais = animalservice.filtroVetPe();
        model.addAttribute("animais", animais);
        return "filtered-animals-vetpe";

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

    @GetMapping("/deleteFuncionario/{id_func}")
    public String getFuncionario(@PathVariable Integer id_func, Model model) {
        funcionarioservice.deleteFuncionario(id_func);
        List<Funcionario> funcionarios = funcionarioservice.getAllFuncionarios();
        model.addAttribute("funcionarios", funcionarios);
        return "redirect:/funcionarios";
    }


    @GetMapping("/funcionarioiddesc")
    public String funcionarioIdDesc(Model model) {
        List<Funcionario> funcionarios = funcionarioservice.funcionarioIdDesc();
        model.addAttribute("funcionarios", funcionarios);
        return "ordered-funcionarios1";

    }

    @GetMapping("/orderedfuncionarioatoz")
    public String orderedFuncionarioAtoZ(Model model) {
        List<Funcionario> funcionarios = funcionarioservice.orderFuncionarioAtoZ();
        model.addAttribute("funcionarios", funcionarios);
        return "ordered-funcionarios2";

    }

    @GetMapping("/orderedfuncionarioztoa")
    public String orderedFuncionarioZtoA(Model model) {
        List<Funcionario> funcionarios = funcionarioservice.orderFuncionarioZtoA();
        model.addAttribute("funcionarios", funcionarios);
        return "ordered-funcionarios3";

    }

    //==============================alas=================================//
    @GetMapping("/alas")
    public String ala(Model model) {
        List<Ala> alas = alaservice.getAllAlas();
        model.addAttribute("alas", alas);
        return "alas";
    }


    //=============================habitats==============================//
//    @GetMapping("/habitats")
//    public String habitat(Model model) {
//        List<Habitat> habitats = habitatservice.getAllHabitats();
//        model.addAttribute("habitats", habitats);
//        return "habitats";
//    }



    @GetMapping("/zeladores")
    public String zelador(Model model) {
        List<Zelador> zeladores = zeladorservice.getAllZeladores();
        model.addAttribute("zeladores", zeladores);
        return "zeladores";
    }

//    @GetMapping("/richzeladores")
//    public String zeladorRico(Model model) {
//        List<Zelador> zeladores = zeladorservice.findZeladoresWithHighSalary();
//        model.addAttribute("zeladores", zeladores);
//        return "filtered-zeladores";
//    }

    @GetMapping("/veterinarios")
    public String veterinario(Model model) {
        List<Veterinario> veterinarios = veterinarioservice.getAllVeterinarios();
        model.addAttribute("veterinarios", veterinarios);
        return "veterinarios";
    }

    @GetMapping("/vetmamiferos")
    public String vetMamiferos(Model model) {
        List<Veterinario> veterinarios = veterinarioservice.vetMamifero();
        model.addAttribute("veterinarios", veterinarios);
        return "vetmamiferos";
    }
//
    @GetMapping("/filtered-veterinarios")
    public String vetHoras(Model model) {
        List<Veterinario> veterinarios = veterinarioservice.findVeterinariosWithHighWorkHours();
        model.addAttribute("veterinarios", veterinarios);
        return "filtered-veterinarios";
    }

    @GetMapping("/tratadores")
    public String tratador(Model model) {
        List<Tratador> tratadores = tratadorservice.getAllTratadores();
        model.addAttribute("tratadores", tratadores);
        return "tratadores";
    }
    @GetMapping("/filtered-tratadores")
    public String filteredTratado(Model model) {
        List<Tratador> tratadores = tratadorservice.findTratadoresWithHighSalary();
        model.addAttribute("tratadores", tratadores);
        return "filtered-tratadores";
    }

}