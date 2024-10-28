package com.ottl.utils;

import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.List;

/**
 * A utility class for generating XML representations of objects.
 */
public class XmlGeneratorUtil {

	private Document doc;

	/**
	 * Creates a new XML Document.
	 * 
	 * @throws XmlGenerationException if an error occurs during Document creation
	 */
	public XmlGeneratorUtil() throws XmlGenerationException {
		try {
			this.doc = createDocument();
		} catch (Exception e) {
			throw new XmlGenerationException("Failed to create XML Document", e);
		}
	}

	private Document createDocument() throws Exception {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		return docBuilder.newDocument();
	}

	/**
	 * Converts a Document object to a string without spaces between elements and
	 * encodes XML entity characters.
	 * 
	 * @return a string representation of the Document
	 * @throws XmlGenerationException if an error occurs during transformation
	 */
	public String documentToString() throws XmlGenerationException {
		return transformDocumentToString(doc);
	}

	/**
	 * Creates an XML document with a single CDATA section containing the full XML
	 * content.
	 *
	 * @param xmlContent the XML content to include inside the CDATA section
	 * @return the CDATA wrapped XML content
	 */
	public String wrapInCData(String xmlContent) throws XmlGenerationException {
		try {
			DocumentFragment fragment = doc.createDocumentFragment();
            Text cdata = doc.createCDATASection(xmlContent);
            fragment.appendChild(cdata);
            return transformDocumentFragmentToString(fragment);
		} catch (Exception e) {
			throw new XmlGenerationException("Failed to wrap XML content in CDATA", e);
		}
	}

	/**
	 * Converts a Document object to a string without spaces between elements and
	 * encodes XML entity characters.
	 * 
	 * @param doc the Document to convert to a string
	 * @return a string representation of the Document
	 * @throws XmlGenerationException if an error occurs during transformation
	 */
	private String transformToString(DOMSource source) throws XmlGenerationException {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "no");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            transformer.transform(source, result);
            return writer.toString();
        } catch (Exception e) {
            throw new XmlGenerationException("Failed to transform XML to string", e);
        }
    }

	/**
	 * Helper method to create and append a child element to a parent element.
	 * 
	 * @param parent      the parent Element to which the child will be appended
	 * @param tagName     the name of the child element
	 * @param textContent the text content of the child element
	 */
	private void appendChild(Element parent, String tagName, String textContent) {
		if (textContent != null && !textContent.isEmpty()) {
			Element element = doc.createElement(tagName);
			element.appendChild(doc.createTextNode(textContent));
			parent.appendChild(element);
		}
	}

	public Document getDocument() {
		return doc;
	}

	private String transformDocumentToString(Document doc) throws XmlGenerationException {
        return transformToString(new DOMSource(doc));
    }

    private String transformDocumentFragmentToString(DocumentFragment fragment) throws XmlGenerationException {
        return transformToString(new DOMSource(fragment));
    }

	/**
	 * Recursively adds elements to the XML document using reflection.
	 * 
	 * @param parent the parent Element to which the child elements will be added
	 * @param object the object whose fields are to be added as XML elements
	 * @throws XmlGenerationException if an error occurs during reflection or XML
	 *                                generation
	 */
	public void addElementsUsingReflection(Element parent, Object object) throws XmlGenerationException {
		if (object == null)
			return;

		try {
			Field[] fields = object.getClass().getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				Object value = field.get(object);

				if (value != null) {
					XmlElementName xmlElementName = field.getAnnotation(XmlElementName.class);
					String tagName = (xmlElementName != null) ? xmlElementName.value() : field.getName();

					if (value instanceof String || value instanceof Number || value instanceof Boolean) {
						appendChild(parent, tagName, value.toString());
					} else if (value instanceof List) {
						for (Object item : (List<?>) value) {
							Element childElement = parent.getOwnerDocument().createElement(tagName);
							parent.appendChild(childElement);
							addElementsUsingReflection(childElement, item);
						}
					} else {
						Element childElement = parent.getOwnerDocument().createElement(tagName);
						parent.appendChild(childElement);
						addElementsUsingReflection(childElement, value);
					}
				}
			}
		} catch (IllegalAccessException e) {
			throw new XmlGenerationException("Failed to access field via reflection", e);
		}
	}
}
