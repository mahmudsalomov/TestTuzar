package Laboratoriya.uchun.Laboratoriya.controller;

import Laboratoriya.uchun.Laboratoriya.model.Bolimlar;
import Laboratoriya.uchun.Laboratoriya.repository.BolimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class BolimController {

    @Autowired
    private BolimRepository bolimRepository;



    @GetMapping("/admin/bolim-details")
    public String bolim(Model model){
        model.addAttribute("mavzular", bolimRepository.findAll());
        return "mavzu/bolim-details";

    }

//    @PostMapping("/bolim-details")
//    public String bolim(Model model){
//
//        model.addAttribute("mavzular", bolimRepository.findAll());
//
//        return "mavzu/bolim-details";
//    }

    @GetMapping("/admin/bolim-details/add")
    @PostMapping("/admin/bolim-details/add")
    public String bolimAdd(@RequestParam(defaultValue = "") String newmavzu){
        if (!newmavzu.equals("")){
            Bolimlar bolimlar=new Bolimlar(newmavzu);
            bolimRepository.save(bolimlar);
//            Math.abs(4);
        }

        return "redirect:/admin/bolim-details";
    }

    @GetMapping("/admin/bolim-details/{id}/remove")
    @PostMapping("/admin/bolim-details/{id}/remove")
    public String bolimRemove(@PathVariable(value = "id") long id){
        bolimRepository.deleteById(id);
        return "redirect:/admin/bolim-details";
    }

    @GetMapping("/admin/bolim-details/bolim-edit")
    @PostMapping("/admin/bolim-details/bolim-edit")
    public String bolimedit(@RequestParam long id, Model model, @RequestParam(defaultValue = "") String mavzu){
//        Bolimlar bolimlar=bolimRepository.findById(id).orElseThrow();
        Optional<Bolimlar> bolimlar=bolimRepository.findById(id);
        bolimlar.get().setNomi(mavzu);
        bolimRepository.save(bolimlar.get());
        model.addAttribute("mavzular", bolimRepository.findAll());

        return "redirect:/admin/bolim-details";
    }


}
