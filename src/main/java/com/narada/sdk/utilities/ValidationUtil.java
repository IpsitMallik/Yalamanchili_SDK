package com.narada.sdk.utilities;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class ValidationUtil {
	/**
	 * field validation method.
	 * 
	 * @param fieldName The name of the field.
	 * @param value     The value of the field.
	 * @param required  Whether the field is required.
	 * @param min       The minimum length of the field value.
	 * @param max       The maximum length of the field value.
	 * @throws ValidationFailedException if validation fails.
	 */
	public static void validateField(String fieldName, String value, boolean required, int min, int max)
			throws ValidationFailedException {
		if (required && StringUtils.isEmpty(value)) {
			throw new ValidationFailedException(fieldName + ": Field is required");
		} else if (StringUtils.isNotEmpty(value)) {
			if ((min != -1 && value.length() < min) || (max != -1 && value.length() > max)) {
				if (min == max) {
					throw new ValidationFailedException(fieldName + ": value should be of length " + min);
				} else {
					throw new ValidationFailedException(
							fieldName + ": value should be between " + min + " and " + max + " characters");
				}
			}
		}
	}

	/**
	 * date validation method.
	 * 
	 * @param fieldName The name of the field.
	 * @param value     The value of the field.
	 * @param required  Whether the field is required.
	 * @param min       The minimum length of the field value.
	 * @param max       The maximum length of the field value.
	 * @param format    The format to check
	 * @throws ValidationFailedException if validation fails.
	 */
	public static void validateDate(String fieldName, String value, boolean required, int min, int max, String format)
			throws ValidationFailedException {
		if (required && StringUtils.isEmpty(value)) {
			throw new ValidationFailedException(fieldName + ": Field is required");
		}
		if (StringUtils.isNotEmpty(value)) {
			if ((min != -1 && value.length() < min) || (max != -1 && value.length() > max)) {
				throw new ValidationFailedException(
						fieldName + ": value should be between " + min + " and " + max + " range");
			}
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				sdf.setLenient(false);
				sdf.parse(value);
			} catch (Exception e) {
				throw new ValidationFailedException(fieldName + ": is not valid format");
			}
		}
	}

	/**
	 * pattern-based field validation method.
	 * 
	 * @param field    The name of the field.
	 * @param value    The value of the field.
	 * @param required Whether the field is required.
	 * @param min      The minimum length of the field value.
	 * @param max      The maximum length of the field value.
	 * @param pattern  The pattern to validate against.
	 * @throws ValidationFailedException if validation fails.
	 */
	public static void validatePattern(String field, String value, boolean required, int min, int max, Pattern pattern)
			throws ValidationFailedException {
		if (required && StringUtils.isEmpty(value)) {
			throw new ValidationFailedException(field + ": Field is required");
		}
		if (StringUtils.isNotEmpty(value)) {
			if ((min != -1 && value.length() < min) || (max != -1 && value.length() > max)) {
				throw new ValidationFailedException(
						field + ": value should be between " + min + " and " + max + " range");
			}
			if (!pattern.matcher(value).matches()) {
				throw new ValidationFailedException(field + ": is not a valid format");
			}
		}
	}

	/**
	 * Enumeration-based field validation method.
	 * 
	 * @param field    The name of the field being validated.
	 * @param value    The value of the field being validated.
	 * @param required Whether the field is required.
	 * @param min      The minimum length of the field value.
	 * @param max      The maximum length of the field value.
	 * @param lookup   The list of accepted values for validation.
	 * @throws ValidationFailedException if validation fails.
	 */
	public static void validateEnumeration(String field, String value, boolean required, int min, int max,
			List<String> lookup) throws ValidationFailedException {
		if (required && StringUtils.isEmpty(value)) {
			throw new ValidationFailedException(field + ": Field is required");
		}
		if (StringUtils.isNotEmpty(value)) {
			if ((min != -1 && value.length() < min) || (max != -1 && value.length() > max)) {
				throw new ValidationFailedException(
						field + ": value should be between " + min + " and " + max + " range");
			}
			if (!lookup.contains(value)) {
				throw new ValidationFailedException(field + ": is not an accepted value");
			}
		}
	}
}
