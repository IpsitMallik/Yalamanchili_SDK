package com.ottl.model;

import com.ottl.utils.XmlElementName;

public class ChangePinRequest {
    @XmlElementName("TxnRefNo")
    private String txnRefNo;

    @XmlElementName("ProxyNumber")
    private String proxyNumber;

    @XmlElementName("EoldPinBlock")
    private String eOldPinBlock;

    @XmlElementName("EnewPinBlock")
    private String eNewPinBlock;

    /**
     * @return the transaction reference number
     */
    public String getTxnRefNo() {
        return txnRefNo;
    }

    /**
     * @param txnRefNo the transaction reference number to set
     */
    public void setTxnRefNo(String txnRefNo) {
        this.txnRefNo = txnRefNo;
    }

    /**
     * @return the proxy number
     */
    public String getProxyNumber() {
        return proxyNumber;
    }

    /**
     * @param proxyNumber the proxy number to set
     */
    public void setProxyNumber(String proxyNumber) {
        this.proxyNumber = proxyNumber;
    }

    /**
     * @return the encrypted old PIN block
     */
    public String getEOldPinBlock() {
        return eOldPinBlock;
    }

    /**
     * @param eOldPinBlock the encrypted old PIN block to set
     */
    public void setEOldPinBlock(String eOldPinBlock) {
        this.eOldPinBlock = eOldPinBlock;
    }

    /**
     * @return the encrypted new PIN block
     */
    public String getENewPinBlock() {
        return eNewPinBlock;
    }

    /**
     * @param eNewPinBlock the encrypted new PIN block to set
     */
    public void setENewPinBlock(String eNewPinBlock) {
        this.eNewPinBlock = eNewPinBlock;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ChangePinRequest [txnRefNo=").append(txnRefNo)
               .append(", proxyNumber=").append(proxyNumber)
               .append(", eOldPinBlock=").append(eOldPinBlock)
               .append(", eNewPinBlock=").append(eNewPinBlock)
               .append("]");
        return builder.toString();
    }
}
