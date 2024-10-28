package com.ottl.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * A centralized utility class for generating XML representations of various request objects.
 */
public class XmlRequestGenerator {
	private static final String DEFAULT_ROOT_ELEMENT_NAME = "RequestXml";
    private static final XmlGeneratorUtil xmlGeneratorUtil = new XmlGeneratorUtil();

    /**
     * Generates an XML representation of the provided request object.
     * 
     * @param requestObject the object to generate XML for
     * @return a string containing the XML representation of the request object
     * @throws XmlGenerationException if an error occurs during XML generation
     */
    public static String generateXml(Object requestObject) throws XmlGenerationException {
        if (requestObject == null) {
            throw new IllegalArgumentException("Request object cannot be null.");
        }

        try {
            Document doc = xmlGeneratorUtil.getDocument();
            Element rootElement = doc.createElement(DEFAULT_ROOT_ELEMENT_NAME);
            doc.appendChild(rootElement);

            xmlGeneratorUtil.addElementsUsingReflection(rootElement, requestObject);

            String xmlContent = xmlGeneratorUtil.documentToString();
            return xmlContent;
//            return xmlGeneratorUtil.wrapInCData(xmlContent);
        } catch (Exception e) {
            throw new XmlGenerationException("Failed to generate XML for the request object.", e);
        }
    }
}
