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
			    "\"TxnRefNo\": \"A0P0ACCL51115119\",\n" +
			    "\"ProxyNumber\": \"000000012786\",\n" +
			    "\"ProductCode\": \"MCCAEM\"\n" +
			"}";




		ApiCallClass.callMethodByName("accountClosure", header, jsonString);

	}
}
