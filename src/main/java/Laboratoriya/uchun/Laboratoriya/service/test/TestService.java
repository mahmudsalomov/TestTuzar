package Laboratoriya.uchun.Laboratoriya.service.test;

import Laboratoriya.uchun.Laboratoriya.model.SimpleTests;
import Laboratoriya.uchun.Laboratoriya.repository.SimpleTestRepository;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private final SimpleTestRepository simpleTestRepository;

    public TestService(SimpleTestRepository simpleTestRepository) {
        this.simpleTestRepository = simpleTestRepository;
    }

    public SimpleTests findById(long id){
        return simpleTestRepository.findById(id);
    }

    public Integer countAll(){
        return simpleTestRepository.countAll();
    }



}
