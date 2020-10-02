package Laboratoriya.uchun.Laboratoriya.repository.user;

import Laboratoriya.uchun.Laboratoriya.model.user.Rating;
import Laboratoriya.uchun.Laboratoriya.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);
    boolean existsByUsername(String username);

    @Query(value = "update foydalanuvchi set test_time=:timel where username=:username returning test_time", nativeQuery = true)
    long testSessionTimeAdd(@Param("timel") long timel, @Param("username") String username);

    @Query(value = "select username from foydalanuvchi where role='USER' order by rating desc ", nativeQuery = true)
    List<String> usernames();

    @Query(value = "select rating from foydalanuvchi where role='USER' order by rating desc ", nativeQuery = true)
    List<Long> ratings();


//    @Query(value = "select new package.Rating(f.username, f.rating) from foydalanuvchi f where f.role='USER' order by f.rating desc", nativeQuery = true)
//    List<Rating> ratings();


    @Query(value = "UPDATE foydalanuvchi SET rating=rating+:amount where username=:username returning rating", nativeQuery = true)
    long addRating(@Param("username") String username, @Param("amount") long amount);

//    String getUserByUsername(String username);
    @Query(value = "select rating from foydalanuvchi where userame=:username", nativeQuery = true)
    long getRating(@Param("username") String username);
//    @Query(value = "select foydalanuvchi.rating from foydalanuvchi where foydalanuvchi.username=username:username", nativeQuery = true)
//    long getUserRating(@Param("username") String username);
}
