package com.example.mac.swyhealthmonitoring;

/**
 * Created by sondos on 23/03/18.
 */

public class Bt {

    private static Bt instance;

    private Bt(){
    }

    public static Bt getInstance(){
        if(instance == null)
            instance = new Bt();
        return instance;
    }
}
