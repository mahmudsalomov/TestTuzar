package Laboratoriya.uchun.Laboratoriya.model.user;

import lombok.Data;

@Data
public class UserRegistrationFields {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
