package com.b2b.home.axisclient;

/**
 * Created by Home on 23-01-2017.
 */

public class Encoder {

    public static  String encode(String amt,String num,String IFSC,String ack){
        return amt+"*"+num+"*"+IFSC+"*"+ack;
    }
}
