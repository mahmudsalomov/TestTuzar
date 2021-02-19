package Laboratoriya.uchun.Laboratoriya.controller;

import Laboratoriya.uchun.Laboratoriya.model.Bolimlar;
import Laboratoriya.uchun.Laboratoriya.model.SimpleTests;
import Laboratoriya.uchun.Laboratoriya.repository.BolimRepository;
import Laboratoriya.uchun.Laboratoriya.repository.SimpleTestRepository;
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
public class SimpleTestController {
    @Autowired
    private SimpleTestRepository simpleTestRepository;

    @Autowired
    private BolimRepository bolimRepository;
//    @Autowired
//    private SozlarRepository sozlarRepository;





    @GetMapping("/admin/simple-home")
    @PostMapping("/admin/simple-home")
    public String simpleHome(Model model, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "") String keyword){
        Iterable<SimpleTests> simpleTests;
        Iterable<SimpleTests> simpleTestsC;
        List<Integer> pageCount = new ArrayList<>();
        int count;

        if (keyword.equals("")){
            if (simpleTestRepository.countAll()%10==0){
                count=simpleTestRepository.countAll()/10;
            }
            else {
                count=(simpleTestRepository.countAll()/10)+1;
            }
            for (int i = 0; i < count; i++) {
                pageCount.add(i);
            }

//        Iterable<Sozlar> sozlars=sozlarRepository.

            simpleTests=simpleTestRepository.limit(10,page*10);
        }

        else {

            simpleTestsC=simpleTestRepository.search(keyword);

            int counter=0;

            for (Object i : simpleTestsC) {
                counter++;
            }

            simpleTests=simpleTestRepository.search2(keyword,page*10);

            if (counter%10==0){
                count=counter/10;
            }
            else {
                count=(counter/10)+1;
            }
            for (int i = 0; i < count; i++) {
                pageCount.add(i);
            }


        }

        model.addAttribute("pageCount", pageCount);

        model.addAttribute("keyword", keyword);

        model.addAttribute("tests", simpleTests);
        return "simple-home";
    }

//    //*****************************************
//    @PostMapping("/simple-home")
//    public String simpleHome(Model model, @RequestParam String search){
//        return "simple-home";
//    }
//    //*****************************************


    @GetMapping("/admin/simple-add")
    public String simpleTestAdd(Model model){
        Iterable<Bolimlar> bolimlarList=bolimRepository.findAll();
        model.addAttribute("bolimlar", bolimlarList );
        return "simple-add";
    }


    @PostMapping("/admin/simple-add")
    public String simpleTestAdd(@RequestParam String savol, @RequestParam String v1, @RequestParam String v2, @RequestParam String v3,  @RequestParam String v4t, @RequestParam(defaultValue = "0") short qiyinlik_darajasi, @RequestParam(defaultValue = "0") short vaqt_qiyinlik_darajasi,@RequestParam(defaultValue = "") String misol, @RequestParam(defaultValue = "") String izoh, @RequestParam(defaultValue = "") String bolim){
        SimpleTests simpleTests=new SimpleTests(savol,v1,v2,v3,v4t,qiyinlik_darajasi,vaqt_qiyinlik_darajasi,misol,izoh, bolim);
        simpleTestRepository.save(simpleTests);
//        Bolimlar bolimlar=new Bolimlar(bolim);
//        bolimlar.setNomi(bolim);
//        bolimRepository.save(bolimlar);
        int count;
        if (simpleTestRepository.countAll()%10==0){
//            System.out.println(simpleTestRepository.countAll());
            count=simpleTestRepository.countAll()/10;
        }
        else {
//            System.out.println(simpleTestRepository.countAll());
            count=(simpleTestRepository.countAll()/10)+1;
        }
        return "redirect:/admin/simple-home?page="+(count-1);
    }


    @GetMapping("/admin/{id}/simple-edit")
    public String simpleTestEdit(@PathVariable (value = "id") long id, Model model){
        if (!simpleTestRepository.existsById(id)){
            return "redirect:/admin/simple-home";
        }
        Optional<SimpleTests> post= Optional.ofNullable(simpleTestRepository.findById(id));
        ArrayList<SimpleTests> res=new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("tests", res);
        Iterable<Bolimlar> bolimlarList=bolimRepository.findAll();
        model.addAttribute("bolimlar", bolimlarList );
        return "simple-edit";
    }


    @PostMapping("/admin/{id}/simple-edit")
    public String simpleTestEdit(@PathVariable(value = "id") long id,@RequestParam String savol, @RequestParam String v1, @RequestParam String v2, @RequestParam String v3,  @RequestParam String v4t, @RequestParam Short qiyinlik_darajasi, @RequestParam Short vaqt_qiyinlik_darajasi,@RequestParam(defaultValue = "") String misol, @RequestParam(defaultValue = "") String izoh, @RequestParam(defaultValue = "") String bolim){
        SimpleTests simpleTests=simpleTestRepository.findById(id);
        simpleTests.setSavol(savol);
        simpleTests.setV1(v1);
        simpleTests.setV2(v2);
        simpleTests.setV3(v3);
        simpleTests.setV4t(v4t);
        simpleTests.setQiyinlik_darajasi(qiyinlik_darajasi);
        simpleTests.setVaqt_qiyinlik_darajasi(vaqt_qiyinlik_darajasi);
        simpleTests.setMisol(misol);
        simpleTests.setIzoh(izoh);
        simpleTests.setBolim(bolim);

        simpleTestRepository.save(simpleTests);
        return "redirect:/admin/simple-home?page="+(int)id/10;
    }
}
