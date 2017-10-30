package projecteuler;

import java.util.ArrayList;

/**
 *
 * @author Shmuel
 */
public class ProjectEuler {

    public static void main(String[] args) {

        int multipleOfThree = 0;
       
        int i = 0;
        while (3*i < 1000) {
            multipleOfThree += 3 * i++;
        }
        
        int multipleOfFive = 0;
        
        int j = 0;
        while (5*j < 1000) {
            multipleOfFive += 5 * j++;
        }
         
        int multipleOfFifteen = 0;
       
        int k = 0;
        while (15*k < 1000) {
            multipleOfFifteen += 15 * k++;
        }
        System.out.println(multipleOfFive+multipleOfThree - multipleOfFifteen);
        
//        int j =0;
//        int multip5 = 0;
//        while(multip5 < 10){
//            multip5 += 5*j++;
//        }
//        System.out.println(multip5);
    }
}
