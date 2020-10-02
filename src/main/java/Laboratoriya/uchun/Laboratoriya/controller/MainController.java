package Laboratoriya.uchun.Laboratoriya.controller;

import Laboratoriya.uchun.Laboratoriya.model.SimpleTests;
import Laboratoriya.uchun.Laboratoriya.model.Sozlar;
import Laboratoriya.uchun.Laboratoriya.repository.SimpleTestRepository;
import Laboratoriya.uchun.Laboratoriya.repository.SozlarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private SimpleTestRepository simpleTestRepository;

    @Autowired
    private SozlarRepository sozlarRepository;

    @GetMapping("/")
    public String home(Model model){
        return "main";
    }

//    @GetMapping("/soz-home")
//    @PostMapping("/soz-home")
//    public String sozHome(Model model, @RequestParam(defaultValue = "0") Integer page){
//        List<Integer> pageCount = new ArrayList<>();
//        int count;
//        if (sozlarRepository.countAll()%20==0){
//            count=sozlarRepository.countAll()/20;
//        }
//        else {
//            count=(sozlarRepository.countAll()/20)+1;
//        }
//        for (int i = 0; i < count; i++) {
//            pageCount.add(i);
//        }
//        model.addAttribute("pageCount", pageCount);
//        Iterable<Sozlar> sozlars=sozlarRepository.limit(20,page*20);
//        model.addAttribute("sozlar", sozlars);
////        System.out.println(sozlarRepository.countAll());
//
////        System.out.println(sozlarRepository.limit(5,5));
////
//        return "soz-home";
//    }
//
//
//
//    @GetMapping("/soz-add")
//    public String sozAdd(Model model){
////        Iterable<SimpleTests> simpleTests=simpleTestRepository.findAll();
////        model.addAttribute("tests", simpleTests);
//        return "soz-add";
//    }
//
//    @PostMapping("/soz-add")
//    public String sozAdd(@RequestParam String togri, @RequestParam String notogri, @RequestParam String misol){
//        Sozlar sozlar=new Sozlar(togri,notogri,misol);
//        sozlarRepository.save(sozlar);
//        return "redirect:/soz-home";
//    }
//
//
//
//    @GetMapping("{id}/soz-edit")
//    public String sozEdit(@PathVariable (value = "id") Long id,Model model){
//        if (!sozlarRepository.existsById(id)){
//            return "redirect:/soz-home";
//        }
//        Optional<Sozlar> post=sozlarRepository.findById(id);
//        ArrayList<Sozlar> res=new ArrayList<>();
//        post.ifPresent(res::add);
//        model.addAttribute("sozlar", res);
//        return "soz-edit";
//    }
//
//
//
//    @PostMapping("{id}/soz-edit")
//    public String sozEdit(@PathVariable(value = "id") long id,@RequestParam String togri, @RequestParam String notogri, @RequestParam String misol){
//        Sozlar sozlar=sozlarRepository.findById(id).orElseThrow();
//        sozlar.setSoz_togri(togri);
//        sozlar.setSoz_xato(notogri);
//        sozlar.setMisol(misol);
//
//        sozlarRepository.save(sozlar);
//        return "redirect:/soz-home";
//    }










//    @GetMapping("/simple-home")
//    @PostMapping("/simple-home")
//    public String simpleHome(Model model, @RequestParam(defaultValue = "0") Integer page){
//
//        List<Integer> pageCount = new ArrayList<>();
//        int count;
//        if (simpleTestRepository.countAll()%10==0){
//            count=simpleTestRepository.countAll()/10;
//        }
//        else {
//            count=(simpleTestRepository.countAll()/10)+1;
//        }
//        for (int i = 0; i < count; i++) {
//            pageCount.add(i);
//        }
//        model.addAttribute("pageCount", pageCount);
////        Iterable<Sozlar> sozlars=sozlarRepository.
//
//        Iterable<SimpleTests> simpleTests=simpleTestRepository.limit(10,page*10);;
//        model.addAttribute("tests", simpleTests);
//        return "simple-home";
//    }
//
//
//    @GetMapping("/simple-add")
//    public String simpleTestAdd(Model model){
//        return "simple-add";
//    }
//
//
//    @PostMapping("/simple-add")
//    public String simpleTestAdd(@RequestParam String savol, @RequestParam String v1, @RequestParam String v2, @RequestParam String v3,  @RequestParam String v4t, @RequestParam(defaultValue = "0") short qiyinlik_darajasi, @RequestParam(defaultValue = "0") short vaqt_qiyinlik_darajasi,@RequestParam(defaultValue = "") String misol, @RequestParam(defaultValue = "") String izoh){
//        SimpleTests simpleTests=new SimpleTests(savol,v1,v2,v3,v4t,qiyinlik_darajasi,vaqt_qiyinlik_darajasi,misol,izoh);
//        simpleTestRepository.save(simpleTests);
//        return "redirect:/simple-home";
//    }
//
//
//    @GetMapping("{id}/simple-edit")
//    public String simpleTestEdit(@PathVariable (value = "id") long id, Model model){
//        if (!simpleTestRepository.existsById(id)){
//            return "redirect:/simple-home";
//        }
//        Optional<SimpleTests> post=simpleTestRepository.findById(id);
//        ArrayList<SimpleTests> res=new ArrayList<>();
//        post.ifPresent(res::add);
//        model.addAttribute("tests", res);
//        return "simple-edit";
//    }
//
//
//    @PostMapping("{id}/simple-edit")
//    public String simpleTestEdit(@PathVariable(value = "id") long id,@RequestParam String savol, @RequestParam String v1, @RequestParam String v2, @RequestParam String v3,  @RequestParam String v4t, @RequestParam Short qiyinlik_darajasi, @RequestParam Short vaqt_qiyinlik_darajasi,@RequestParam(defaultValue = "") String misol, @RequestParam(defaultValue = "") String izoh){
//        SimpleTests simpleTests=simpleTestRepository.findById(id).orElseThrow();
//        simpleTests.setSavol(savol);
//        simpleTests.setV1(v1);
//        simpleTests.setV2(v2);
//        simpleTests.setV3(v3);
//        simpleTests.setV4t(v4t);
//        simpleTests.setQiyinlik_darajasi(qiyinlik_darajasi);
//        simpleTests.setVaqt_qiyinlik_darajasi(vaqt_qiyinlik_darajasi);
//        simpleTests.setMisol(misol);
//        simpleTests.setIzoh(izoh);
//
//        simpleTestRepository.save(simpleTests);
//        return "redirect:/simple-home";
//    }


//    @PostMapping("{id}/remove")
//    public String testPostDelete(@PathVariable(value = "id") long id){
//        SimpleTests post=simpleTestRepository.findById(id).orElseThrow();
//        simpleTestRepository.delete(post);
//        return "redirect:/";
//    }

}
