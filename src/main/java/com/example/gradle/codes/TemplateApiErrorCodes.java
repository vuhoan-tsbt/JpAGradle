package com.example.gradle.codes;

import com.example.gradle.codes.ErrorCode;

public enum TemplateApiErrorCodes implements ErrorCode {
    JSON_FORMAT_CHECK("COMMON-FM00002.id", "COMMON-FM00002.message"),
    DATE_FORMAT_CHECK("COMMON-FM00003.id", "COMMON-FM00003.message"),
    ISO_DATE_FORMAT_CHECK("COMMON-FM00001.id", "COMMON-FM00001.message"),
    DEFAULT_ERROR("DOMAIN-COM0001.id", "DOMAIN-COM0001.message");

    /**
     *
     */
    private final String errIdCode;

    private final String messageCode;

    /**
     * @param errIdCode
     * @param messageCode
     */
    TemplateApiErrorCodes(String errIdCode, String messageCode) {
        this.errIdCode = errIdCode;
        this.messageCode = messageCode;
    }

    /**
     * @return the errIdCode
     */
    @Override
    public String getErrIdCode() {
        return this.errIdCode;
    }

    /**
     * @return the messageCode
     */
    @Override
    public String getMessageCode() {
        return this.messageCode;
    }
}
