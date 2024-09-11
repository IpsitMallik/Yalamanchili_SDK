package com.narada.sdk.utilities;

public class EncryptionResult {
    private String encryptedXml;
    private String encryptedSessionKey;

    public EncryptionResult(String encryptedXml, String encryptedSessionKey) {
        this.encryptedXml = encryptedXml;
        this.encryptedSessionKey = encryptedSessionKey;
    }

    public String getEncryptedXml() {
        return encryptedXml;
    }

    public String getEncryptedSessionKey() {
        return encryptedSessionKey;
    }
}
