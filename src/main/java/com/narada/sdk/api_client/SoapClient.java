package com.narada.sdk.api_client;

import com.narada.sdk.models.RequestHeader;

public class SoapClient {

    public static String constructSoapMessage(String requestXml, RequestHeader header) {
        StringBuilder soapMessage = new StringBuilder();
        soapMessage.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n")
                .append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" ")
                .append("xmlns:ser=\"http://services.api.ycs.com\" ")
                .append("xmlns:xsd=\"http://model.api.ycs.com/xsd\">\n")
                .append("    <soapenv:Header/>\n")
                .append("    <soapenv:Body>\n")
                .append("        <ser:serviceCall>\n")
                .append("            <ser:naradaRequest>\n")
                .append("                <xsd:requestBody>\n")
                .append("                    <xsd:request>").append(requestXml).append("</xsd:request>\n")
                .append("                </xsd:requestBody>\n")
                .append("                <xsd:requestHeader>\n")
                .append("                    <xsd:apiKey>").append(header.getApiKey()).append("</xsd:apiKey>\n")
                .append("                    <xsd:apiPasswd>").append(header.getApiPasswd())
                .append("</xsd:apiPasswd>\n")
                .append("                    <xsd:apiUserId>").append(header.getApiUserId())
                .append("</xsd:apiUserId>\n")
                .append("                    <xsd:channelType>").append(header.getChannelType())
                .append("</xsd:channelType>\n")
                .append("                    <xsd:clientId>").append(header.getClientId()).append("</xsd:clientId>\n")
                .append("                    <xsd:msgRefNo>").append(header.getMsgRefNo()).append("</xsd:msgRefNo>\n")
                .append("                    <xsd:msgTimeStamp>").append(header.getMsgTimeStamp())
                .append("</xsd:msgTimeStamp>\n")
                .append("                    <xsd:sessionKey>").append(header.getSessionKey())
                .append("</xsd:sessionKey>\n")
                .append("                    <xsd:token>").append(header.getToken()).append("</xsd:token>\n")
                .append("                </xsd:requestHeader>\n")
                .append("            </ser:naradaRequest>\n")
                .append("        </ser:serviceCall>\n")
                .append("    </soapenv:Body>\n")
                .append("</soapenv:Envelope>");

        return soapMessage.toString();
    }

}
