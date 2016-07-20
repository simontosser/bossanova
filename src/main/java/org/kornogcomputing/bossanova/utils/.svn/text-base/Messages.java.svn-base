package org.kornogcomputing.bossanova.utils;

import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * This class defines text which correspond to the key in file
 * messages_xx.properties files:
 *  
 * 
 * @author herve <herve@kornog-computing.com>
 */
public final class Messages {
	/**
	 * 
	 */
	private static ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	/**
	 * get message from the right messages.properties
	 * @param key String
	 * @return value in messages.properties
	 */
	public static String getString(final String key) {
		if (key == null || key.trim().isEmpty()) {
			return "";
		}

		messageSource.setBasename("messages");
		try {
			return messageSource.getMessage(key, null,
					LocaleContextHolder.getLocale());
		} catch (final NoSuchMessageException e) {
			return '!' + key + '!';
		}
	}
	/**
	 * constructor
	 */
	private Messages() {

	}
}