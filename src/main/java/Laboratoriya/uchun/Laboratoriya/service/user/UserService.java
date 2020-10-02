package Laboratoriya.uchun.Laboratoriya.service.user;

import Laboratoriya.uchun.Laboratoriya.model.user.Rating;
import Laboratoriya.uchun.Laboratoriya.model.user.User;
import Laboratoriya.uchun.Laboratoriya.repository.user.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    private final PasswordEncoder passwordEncoder;


    public User findbyusername(String username){
        return userRepo.findByUsername(username);
    }

    public User update(User user){
        return userRepo.save(user);
    }

    public User save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (user.getUsername().equals("admin")){
            user.setRole("ADMIN");
        }
        else {
            user.setRole("USER");
            user.setTestTime(0L);
        }
        return userRepo.save(user);
    }

    public List<User> getAll(){
        return userRepo.findAll();
    }

    public boolean existsByUsername(String username){
        return userRepo.existsByUsername(username);
    }


    public List<Rating> ratings() {
        List<Rating> ratings=new ArrayList<>();
        List<String> usernames=userRepo.usernames();
        List<Long> ratings2=userRepo.ratings();
        for (int i = 0; i <ratings2.size() ; i++) {
            ratings.add(new Rating(usernames.get(i), ratings2.get(i)));
        }
        return ratings;
    }
//    public long getUserRating(String username){
//        return userRepo.getUserRating(username);
//    }

    public long addRating(String username, long amount){
        if (existsByUsername(username)){
            return userRepo.addRating(username, amount);
        }
        else return 0;
    }

    public long getRating(String username){
        return userRepo.getRating(username);
    }

    public long testSessionTimeAdd(long time, String username){
        if (existsByUsername(username)) {
            return userRepo.testSessionTimeAdd(time,username);
        }
        else return 0;

    }

}
