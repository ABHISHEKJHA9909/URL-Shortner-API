package com.abhishekjha.urlshortner;
import java.util.Random;

public class hashgenerator {

    static String getHashString(){
        Random rand = new Random();
        int length = rand.nextInt(7) + 4;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (rand.nextBoolean()) {
                char c = (char) (rand.nextInt(26) + 'a');
                sb.append(c);
            } else {
                int digit = rand.nextInt(10);
                sb.append(digit);
            }
        }

        String randomString = sb.toString();
        return randomString;
    }
}
