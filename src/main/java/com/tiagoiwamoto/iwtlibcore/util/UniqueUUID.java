package com.tiagoiwamoto.iwtlibcore.util;

/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 17/02/2021 - 13:34
*/

import java.io.Serializable;
import java.security.SecureRandom;

public class UniqueUUID implements Serializable {

    private static final long serialVersionUID = 7560644914092676183L;

    private static final long MSB = 0x8000000000000000L;

    /**
     * Generate a random id.
     * @return a string with a value generated
     */
    public String generate() {
        SecureRandom ng = new SecureRandom();
        return Long.toHexString(MSB | ng.nextLong()) + Long.toHexString(MSB | ng.nextLong());
    }
}
