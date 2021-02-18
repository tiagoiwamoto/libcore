package com.tiagoiwamoto.iwtlibcore.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


/*
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@gmail.com
 * linkedin.com/in/tiago-iwamoto
 * System specialist
 * 18/02/2021 | 07:45
 */

public class UniqueUUIDTest {

    @Test
    public void generate() {
        Assert.assertNotNull(new UniqueUUID().generate());
    }
}
