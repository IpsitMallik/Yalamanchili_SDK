package com.ottl.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import com.ottl.soapclient.ObjectFactory;
import com.ottl.soapclient.RequestHeader;


/**
 * Utility class for creating and populating RequestHeader objects.
 */
public class RequestHeaderUtil {

    /**
     * Creates a new RequestHeader object populated with the provided details.
     *
     * @param apiKey      The API key to be used for the request.
     * @param channelType The type of channel through which the request is made.
     * @param msgRefNo    The message reference number for tracking the request.
     * @return A populated RequestHeader object.
     */
    public static RequestHeader createHeader(String channelType, String msgRefNo) {
        ObjectFactory objFact = new ObjectFactory();
        RequestHeader header = objFact.createRequestHeader();
        header.setApiUserId(Configuration.getUsername());
        header.setApiPasswd(Configuration.getPassword());
        header.setApiKey(null);
        header.setChannelType(channelType);
        header.setClientId(Configuration.getClientId());
        header.setMsgRefNo(padMsgRefNo(msgRefNo));
        header.setMsgTimeStamp(getCurrentTimestamp());
        header.setSessionKey(null);
        header.setToken(null);
        return header;
    }

    /**
     * Generates the current timestamp in the format "yyyyMMddHHmmss" based on the client's timezone.
     * If the specified timezone in Configuration is invalid, defaults to UTC.
     *
     * @return A string representing the current timestamp.
     */
    private static String getCurrentTimestamp() {
        ZoneId clientTimezone;
        try {
            clientTimezone = ZoneId.of(Configuration.getClientCountryZone());
        } catch (Exception e) {
            clientTimezone = ZoneId.of("UTC");
            System.err.println("Invalid time zone specified. Defaulting to UTC.");
        }
        LocalDateTime now = LocalDateTime.now(clientTimezone);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        return now.format(formatter);
    }

    /**
     * Pads the message reference number with leading zeros to ensure it has a length of 16 characters.
     *
     * @param msgRefNo The original message reference number.
     * @return A string with the message reference number padded to 12 characters.
     */
    private static String padMsgRefNo(String msgRefNo) {
        if (msgRefNo == null) {
            msgRefNo = "";
        }
        return String.format("%-16s", msgRefNo).replace(' ', '0');
    }
}
