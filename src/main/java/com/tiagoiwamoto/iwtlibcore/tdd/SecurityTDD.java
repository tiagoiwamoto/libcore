package com.tiagoiwamoto.iwtlibcore.tdd;

/*
    # Tiago Henrique Iwamoto
    # 60003083
    # tiago.iwamoto@midwayfinanceira.com.br
    # 17/02/2021 - 14:38
*/

import com.tiagoiwamoto.iwtlibcore.util.Security;

public class SecurityTDD {

    public static void main(String[] args) {
        String originalString = "howtodoinjava.com";

        String encryptedString = new Security().encrypt(originalString, "secretKey") ;
        String decryptedString = new Security().decrypt(encryptedString, "boooooooooom!!!!") ;

        System.out.println(originalString);
        System.out.println(encryptedString);
        System.out.println(decryptedString);
    }

}
