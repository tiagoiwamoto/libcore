package com.tiagoiwamoto.iwtlibcore.tdd;

/*
    # Tiago Henrique Iwamoto
    # 60003083
    # tiago.iwamoto@midwayfinanceira.com.br
    # 17/02/2021 - 13:56
*/

import com.tiagoiwamoto.iwtlibcore.util.UniqueUUID;

public class UuidTDD {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new UniqueUUID().generate());
        System.out.println(new UniqueUUID().generate());
        System.out.println(new UniqueUUID().generate());
        System.out.println(new UniqueUUID().generate());
        System.out.println(new UniqueUUID().generate());
    }

}
