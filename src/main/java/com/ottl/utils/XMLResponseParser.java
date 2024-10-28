package com.ottl.utils;

import org.json.JSONObject;
import org.json.XML;

/**
 * Utility class for parsing XML responses into Java objects.
 */
public class XMLResponseParser {

	/**
	 * Converts an XML response to a JSON string.
	 *
	 * @param xmlResponse The XML response as a string.
	 * @return A JSON string representation of the XML.
	 * @throws Exception If an error occurs during conversion.
	 */
	public static String parseXml(String xmlResponse) throws Exception {
		if (xmlResponse == null || xmlResponse.isEmpty()) {
			throw new IllegalArgumentException("XML response cannot be null or empty");
		}

		try {
			// Convert XML to JSON
			JSONObject jsonObject = XML.toJSONObject(xmlResponse);
			// Return JSON string with indentation
			return jsonObject.toString(4); // 4 is the indentation level
		} catch (Exception e) {
			throw new Exception("Failed to convert XML to JSON: " + e.getMessage(), e);
		}
	}

}
