package Laboratoriya.uchun.Laboratoriya.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Sozlar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String soz_togri;
    private String soz_xato;

    @Column(columnDefinition = "TEXT")
    private String misol;
//    private String misol;

    public Sozlar(String togri, String notogri, String misol) {
        this.soz_togri=togri;
        this.soz_xato=notogri;
        this.misol=misol;
    }
}
