/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HelperClasses;

/**
 *
 * @author futur
 */
public class SalesRecord {

    private Long salesRecordId;
    private Long memberId;
    private double amountPaid;
    private double amountDue;

    public SalesRecord() {

    }

    public SalesRecord(Long salesRecordId, Long memberId, double amountPaid, double amountDue) {
        this.salesRecordId = salesRecordId;
        this.memberId = memberId;
        this.amountPaid = amountPaid;
        this.amountDue = amountDue;
    }

    public Long getSalesRecordId() {
        return salesRecordId;
    }

    public void setSalesRecordId(Long salesRecordId) {
        this.salesRecordId = salesRecordId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }

}
