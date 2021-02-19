package Laboratoriya.uchun.Laboratoriya.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SimpleTests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String savol;

    private String v1;
    private String v2;
    private String v3;
    private String v4t;

    @Column(columnDefinition = "TEXT")
    private String misol;

    @Column(columnDefinition = "TEXT")
    private String izoh;



    private short qiyinlik_darajasi;
    private short vaqt_qiyinlik_darajasi;

    private String bolim;

    public SimpleTests(String savol,String v1, String v2, String v3, String v4t, short qiyinlik_darajasi, short vaqt_qiyinlik_darajasi, String misol, String izoh, String bolim) {
        this.savol=savol;
        this.v1=v1;
        this.v2=v2;
        this.v3=v3;
        this.v4t=v4t;
        this.qiyinlik_darajasi=qiyinlik_darajasi;
        this.vaqt_qiyinlik_darajasi=vaqt_qiyinlik_darajasi;
        this.misol=misol;
        this.izoh=izoh;
        this.bolim=bolim;
    }
}
