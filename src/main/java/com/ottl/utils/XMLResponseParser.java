package com.ottl.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;

/**
 * Utility class for parsing XML responses into Java objects.
 */
public class XMLResponseParser {

	/**
	 * Parses an XML response into an object of the specified class type.
	 *
	 * @param xmlResponse The XML response as a string.
	 * @param clazz       The class type to parse the XML into.
	 * @param <T>         The type parameter.
	 * @return An instance of the specified class type populated with data from the
	 *         XML response.
	 * @throws Exception If an error occurs during parsing or reflection.
	 */
	public static <T> T parseXml(String xmlResponse, Class<T> clazz) throws Exception {
		if (xmlResponse == null || clazz == null) {
			throw new IllegalArgumentException("xmlResponse and clazz cannot be null");
		}

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(new ByteArrayInputStream(xmlResponse.getBytes()));

		doc.getDocumentElement().normalize();

		T instance = clazz.getDeclaredConstructor().newInstance();
		parseFields(doc.getDocumentElement(), instance, clazz);

		return instance;
	}

	/**
	 * Parses fields of the given instance from the XML element.
	 *
	 * @param element  The XML element containing the data.
	 * @param instance The instance of the class to populate.
	 * @param clazz    The class type of the instance.
	 * @param <T>      The type parameter.
	 * @throws Exception If an error occurs during field parsing or setting values.
	 */
	private static <T> void parseFields(Element element, T instance, Class<?> clazz) throws Exception {
		if (element == null || instance == null || clazz == null) {
			return;
		}

		for (Field field : clazz.getDeclaredFields()) {
			field.setAccessible(true);

			XmlElementName annotation = field.getAnnotation(XmlElementName.class);
			String tagName = annotation != null ? annotation.value() : field.getName();

			String tagValue = getTagValue(tagName, element);

			if (tagValue != null) {
				try {
					Object convertedValue = convertValue(field.getType(), tagValue);
					field.set(instance, convertedValue);
				} catch (NumberFormatException e) {
					throw new IllegalArgumentException(
							"Failed to convert value for field " + tagName + ": " + e.getMessage());
				} catch (IllegalArgumentException e) {
					throw new IllegalArgumentException(
							"Unsupported field type for field " + tagName + ": " + e.getMessage());
				}
			} else {
				System.err.println("No value found for tag: " + tagName);
			}
		}
	}

	/**
	 * Retrieves the text content of the first occurrence of the specified tag in
	 * the XML element.
	 *
	 * @param tag     The name of the XML tag.
	 * @param element The XML element.
	 * @return The text content of the tag, or null if the tag is not found.
	 */
	private static String getTagValue(String tag, Element element) {
		NodeList nodeList = element.getElementsByTagName(tag);
		Node node = nodeList.item(0);
		if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
			Element tagElement = (Element) node;
			return tagElement.getTextContent().trim();
		}
		return null;
	}

	/**
	 * Converts a string value to the specified type.
	 *
	 * @param type  The class of the type to convert to.
	 * @param value The string value to convert.
	 * @return The converted value.
	 * @throws NumberFormatException    If the value cannot be parsed to the target
	 *                                  type.
	 * @throws IllegalArgumentException If the type is not supported.
	 */
	private static Object convertValue(Class<?> type, String value) {
		if (type == String.class) {
			return value;
		} else if (type == int.class || type == Integer.class) {
			return Integer.parseInt(value);
		} else if (type == long.class || type == Long.class) {
			return Long.parseLong(value);
		} else if (type == double.class || type == Double.class) {
			return Double.parseDouble(value);
		} else if (type == boolean.class || type == Boolean.class) {
			return Boolean.parseBoolean(value);
		} else {
			throw new IllegalArgumentException("Unsupported field type: " + type);
		}
	}
}
