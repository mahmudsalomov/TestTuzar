package Laboratoriya.uchun.Laboratoriya.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class AbstractTest {
    private Long id;
    private String question;
//    private ArrayList<String> variants;
    private String[] variants;
//    private String A;
//    private String B;
//    private String C;
//    private String D;
    private Integer answer;
    private long time;
}
