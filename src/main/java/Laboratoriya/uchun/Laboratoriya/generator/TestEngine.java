package Laboratoriya.uchun.Laboratoriya.generator;

import Laboratoriya.uchun.Laboratoriya.model.AbstractTest;
import Laboratoriya.uchun.Laboratoriya.model.SimpleTests;
import Laboratoriya.uchun.Laboratoriya.model.user.User;
import Laboratoriya.uchun.Laboratoriya.repository.SimpleTestRepository;
import Laboratoriya.uchun.Laboratoriya.service.test.TestService;
import Laboratoriya.uchun.Laboratoriya.service.user.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;


@Service
public final class TestEngine {

    private final TestService testService;
    private final UserService userService;


//    private final SimpleTestRepository simpleTestRepository;

    public TestEngine(TestService testService, UserService userService) {
        this.testService = testService;
        this.userService = userService;
//        this.simpleTestRepository = simpleTestRepository;
    }

//    public TestEngine(TestService testService) {
//        this.testService = testService;
//    }

    public static AbstractTest variantMixer(SimpleTests simpleTests){
        ArrayList<Integer> randomlist=RandomEngine.randomMultiTakrorlanmasin(4, 4);
        AbstractTest test=new AbstractTest();
//        ArrayList<String> temp=new ArrayList<>();
        String[] temp=new String[4];
        System.out.println(randomlist);
            assert randomlist != null;
//            temp.set(randomlist.get(0)-1, simpleTests.getV1());
//            temp.set(randomlist.get(1)-1, simpleTests.getV2());
//            temp.set(randomlist.get(2)-1, simpleTests.getV3());
//            temp.set(randomlist.get(3)-1, simpleTests.getV4t());
        temp[randomlist.get(0)-1]=simpleTests.getV1();
        temp[randomlist.get(1)-1]=simpleTests.getV2();
        temp[randomlist.get(2)-1]=simpleTests.getV3();
        temp[randomlist.get(3)-1]=simpleTests.getV4t();
        test.setId(simpleTests.getId());
//        test.setTime(simpleTests.getVaqt_qiyinlik_darajasi()*10);
            test.setAnswer(randomlist.get(3)-1);
            test.setQuestion(simpleTests.getSavol());
            test.setVariants(temp);
            test.setTime(simpleTests.getVaqt_qiyinlik_darajasi()*10);
        System.out.println("test = "+test);
            return test;
    }

    public AbstractTest one(){
        System.out.println(testService.countAll());
        SimpleTests simpleTests=testService.findById(RandomEngine.random(testService.countAll()));
        System.out.println("simple = "+simpleTests);
        userService.testSessionTimeAdd(System.currentTimeMillis(), SecurityContextHolder.getContext().getAuthentication().getName());
        return variantMixer(simpleTests);
    }
    public boolean checkAnswer(String answer, long id){
        return testService.findById(id).getV4t().equals(answer);
    }

    public int checkAmount(long id){
        SimpleTests simpleTests=testService.findById(id);
        return simpleTests.getVaqt_qiyinlik_darajasi()+simpleTests.getQiyinlik_darajasi();
    }

//    public static void main(String[] args) {
//        System.out.println(simpleTestRepository.countAll());
//    }

}
