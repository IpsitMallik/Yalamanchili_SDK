package com.narada.sdk;

import com.narada.sdk.models.CardDetailRequest;
import com.narada.sdk.models.RequestHeader;

public class TestMain {
    public static void main(String[] args) {
        System.out.println("hello");
        NaradaSystem ns = NaradaSystemFactory.getInstance();
        RequestHeader header = ns.getHeader("API", "123456123456");

        CardDetailRequest cdr = new CardDetailRequest();
        cdr.setTxnRefNo("01234567890123456789012345678901");
        cdr.setProxyNumber("012345678901");
        cdr.setCustomerId("");

        MainClass.callMethodByName("getCardDetails", header, cdr);
    }
}
