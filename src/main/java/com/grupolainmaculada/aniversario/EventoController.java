package com.grupolainmaculada.aniversario;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class EventoController {

    private final EventoRepository repository;

    @GetMapping
    public String index(Model model){
        model.addAttribute("evento", new Evento());
        return "index";
    }

    @PostMapping
    public String buscar(@Valid Evento evento, BindingResult result, Model model){
        if(result.hasErrors()){
            return "index";
        }
        Optional<Evento> opt = repository.findByNumeroDocumento(evento.getNumeroDocumento());
        if (opt.isPresent()){
            model.addAttribute("evento", opt.get());
            return "resultado";
        }else{
            model.addAttribute("mensaje","Invitado no encontrado");
            return "index";
        }
    }

    @PostMapping("/registrar-asistencia")
    public String registrarAsistencia(@Valid Evento evento, BindingResult result, Model model,
                                      Principal principal){
        if(result.hasErrors()){
            return "resultado";
        }
        Optional<Evento> opt = repository.findByNumeroDocumento(evento.getNumeroDocumento());
        if (opt.isPresent()){
            Evento e = opt.get();
            e.setFechaHoraIngreso(LocalDateTime.now());
            e.setAsistio(Boolean.TRUE);
            e.setRegistradoPor(principal.getName());
            repository.save(e);
            model.addAttribute("evento", opt.get());

        }
        return "redirect:/index";
    }
}
