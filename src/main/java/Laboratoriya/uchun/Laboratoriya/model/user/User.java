package Laboratoriya.uchun.Laboratoriya.model.user;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "foydalanuvchi")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private Long rating;
    private Long testTime;

}
