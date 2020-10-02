package Laboratoriya.uchun.Laboratoriya.controller;

import Laboratoriya.uchun.Laboratoriya.model.Sozlar;
import Laboratoriya.uchun.Laboratoriya.repository.SozlarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Controller
public class SozlarController {
    @Autowired
    private SozlarRepository sozlarRepository;


    @GetMapping("/admin/soz-home")
    @PostMapping("/admin/soz-home")
    public String sozHome(Model model, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "") String keyword){
        Iterable<Sozlar> sozlars;
        Iterable<Sozlar> sozlarsC;
        List<Integer> pageCount = new ArrayList<>();
        int count;
        if (keyword.equals("")){


            if (sozlarRepository.countAll()%20==0){
                count=sozlarRepository.countAll()/20;
            }
            else {
                count=(sozlarRepository.countAll()/20)+1;
            }
            for (int i = 0; i < count; i++) {
                pageCount.add(i);
            }

            sozlars=sozlarRepository.limit(20,page*20);


        }


        else {

            sozlarsC=sozlarRepository.search(keyword);

            int counter=0;

            for (Object i : sozlarsC) {
                counter++;
            }

            sozlars=sozlarRepository.search2(keyword,page*20);

            if (counter%20==0){
                count=counter/20;
            }
            else {
                count=(counter/20)+1;
            }
            for (int i = 0; i < count; i++) {
                pageCount.add(i);
            }



        }
        model.addAttribute("keyword", keyword);

        model.addAttribute("currentPage", page);

        model.addAttribute("pageCount", pageCount);

        model.addAttribute("sozlar", sozlars);
//        System.out.println(sozlarRepository.countAll());

//        System.out.println(sozlarRepository.limit(5,5));
//
        return "soz-home";
    }


    //*****************************************
//    @RequestMapping("/soz-home")
//    public String simpleHome(Model model, @RequestParam String keyword){
//
//
//
//        Iterable<Sozlar> sozlars=sozlarRepository.findBySoz_togriIsLike(keyword);
//        model.addAttribute("sozlar", sozlars);
////        model.addAttribute("currentPage", page);
//
//
//
//        return "soz-home";
//    }
    //*****************************************



    @GetMapping("/admin/soz-add")
    public String sozAdd(Model model){
//        Iterable<SimpleTests> simpleTests=simpleTestRepository.findAll();
//        model.addAttribute("tests", simpleTests);

        return "soz-add";
    }

    @PostMapping("/admin/soz-add")
    public String sozAdd(@RequestParam String togri, @RequestParam String notogri, @RequestParam String misol){
        Sozlar sozlar=new Sozlar(togri,notogri,misol);
        sozlarRepository.save(sozlar);
        int count;
        if (sozlarRepository.countAll()%20==0){
            count=sozlarRepository.countAll()/20;
        }
        else {
            count=(sozlarRepository.countAll()/20)+1;
        }
        return "redirect:/admin/soz-home?page="+(count-1);
    }



    @GetMapping("/admin/{id}/soz-edit")
    public String sozEdit(@PathVariable(value = "id") Long id, Model model){
        if (!sozlarRepository.existsById(id)){
            return "redirect:/admin/soz-home";
        }
        Optional<Sozlar> post=sozlarRepository.findById(id);
        ArrayList<Sozlar> res=new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("sozlar", res);
        return "soz-edit";
    }



    @PostMapping("/admin/{id}/soz-edit")
    public String sozEdit(@PathVariable(value = "id") long id,@RequestParam String togri, @RequestParam String notogri, @RequestParam String misol){
        Sozlar sozlar=sozlarRepository.findById(id).orElseThrow();
        sozlar.setSoz_togri(togri);
        sozlar.setSoz_xato(notogri);
        sozlar.setMisol(misol);

        sozlarRepository.save(sozlar);
        return "redirect:/admin/soz-home?page="+(int)id/20;
    }

}
