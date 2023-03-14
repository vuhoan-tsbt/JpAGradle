package com.example.gradle.codes;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.lang.Nullable;

public class ErrorCodesUtil {
    private ErrorCodesUtil() {}

    public static String getErrId(MessageSource messageSource, ErrorCode errorCode) {
        return getMessageInternal(messageSource, errorCode.getErrIdCode(), "", null);
    }

    public static String getErrId(MessageSource messageSource, ErrorCode errorCode, String defaultErrId) {
        return getMessageInternal(messageSource, errorCode.getErrIdCode(), defaultErrId, null);
    }

    public static String getMessage(MessageSource messageSource, ErrorCode errorCode, String defaultMessage) {
        return getMessageInternal(messageSource, errorCode.getMessageCode(), defaultMessage, null);
    }

    public static String getMessage(MessageSource messageSource, ErrorCode errorCode, String defaultMessage,
                                    @Nullable String[] args) {
        return getMessageInternal(messageSource, errorCode.getMessageCode(), defaultMessage, args);
    }

    private static String getMessageInternal(MessageSource messageSource, String code, String defaultString,
                                             @Nullable String[] args) {
        return messageSource.getMessage(code, args, defaultString, LocaleContextHolder.getLocale());
    }
}
