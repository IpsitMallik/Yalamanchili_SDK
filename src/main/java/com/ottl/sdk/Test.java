package com.ottl.sdk;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ottl.soapclient.RequestHeader;

public class Test {
	public static void main(String[] args) throws JsonProcessingException {
		Bus bus = BusFactory.newInstance().createBus();
		BusFactory.setDefaultBus(bus);

		NaradaSystem ns = new NaradaSystem();

		RequestHeader header = ns.getHeader("API", "123456123456");
		String jsonString = "{\n" +
				"  \"TxnRefNo\": \"ASDHFG03612308\",\n" +
				"  \"ProxyNumber\": \"000000012869\",\n" +
				"  \"CustomerId\": \"\"\n" +
				"}";

		// ApiCallClass.callMethodByName("blockLockUnlockCard", header, jsonString);
		String res = ns.invokeServiceMethod("getCardDetails", header, jsonString);
		System.out.println(res);
	}
}
