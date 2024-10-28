package com.ottl.model;

import com.ottl.utils.XmlElementName;

public class StatusResponse {
	@XmlElementName("TxnRefNo")
	private String txnRefNo;
	
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
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("StatusResponse [txnRefNo=").append(txnRefNo)
               .append("]");
        return builder.toString();
    }
}
