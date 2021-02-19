package Laboratoriya.uchun.Laboratoriya.generator;

import java.util.ArrayList;

// TASODIFIY SONLAR MOTORI
public final class RandomEngine {

    public static void main(String[] args) {
        System.out.println(randomMultiTakrorlanmasin(4,4));
    }


    // Bitta tasodifiy natural son qaytaradigan metod
    public static Integer random(Integer chegara){
        return ((int) (Math.random() * chegara) +1);
    }



    // Berilga a va b oraliqdagi tasodifiy natural son qaytaradigan metod
    public static Integer randomInterval(Integer a, Integer b){
        if (a<b){
            return random(b-a)+(a-1);
        } else {
            if (a>b){
                return random(a-b)+(b-1);
            }
            else {
                return 0;
            }
        }
    }





    // Bir nechta tasodifiy natural son qaytaradigan metod.
    public static ArrayList<Integer> randomMulti(Integer chegara, Integer soni){
        ArrayList<Integer> randoms = new ArrayList<>();
        for (int i = 0; i <soni ; i++) {
            randoms.add(random(chegara));
        }
        return randoms;
    }


    // Bir nechta tasodifiy takrorlanmaydigan natural son qaytaradigan metod, bunda soni<=chegara bo'lishi kerak, aks holda null qaytaradi
    public static ArrayList<Integer> randomMultiTakrorlanmasin(Integer chegara, Integer soni) {
        ArrayList<Integer> randoms = new ArrayList<Integer>();
        int tempRandom;
        if (soni <= chegara) {


            for (int i = 0; i < soni; i++) {
                boolean bool = true;
                tempRandom = random(chegara);
                while (bool) {
                    if (randoms.contains(tempRandom)) {
                        tempRandom = random(chegara);
                    } else {
                        randoms.add(tempRandom);
                        bool = false;
                    }


                }


            }


            return randoms;
        }
        return null;
    }


}

