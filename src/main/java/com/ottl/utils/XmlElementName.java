package com.ottl.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation to specify custom XML element names.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface XmlElementName {
    String value();
}
