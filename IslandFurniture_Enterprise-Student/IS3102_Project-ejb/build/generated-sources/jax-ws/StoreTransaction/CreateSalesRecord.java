
package StoreTransaction;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createSalesRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createSalesRecord">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="staffEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="storeID" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="posName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="itemsPurchasedSKU" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="itemsPurchasedQty" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="amountDue" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="amountPaid" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="amountPaidUsingPoints" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="loyaltyPointsDeducted" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="memberEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="receiptNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createSalesRecord", propOrder = {
    "staffEmail",
    "password",
    "storeID",
    "posName",
    "itemsPurchasedSKU",
    "itemsPurchasedQty",
    "amountDue",
    "amountPaid",
    "amountPaidUsingPoints",
    "loyaltyPointsDeducted",
    "memberEmail",
    "receiptNo"
})
public class CreateSalesRecord {

    protected String staffEmail;
    protected String password;
    protected Long storeID;
    protected String posName;
    protected List<String> itemsPurchasedSKU;
    @XmlElement(type = Integer.class)
    protected List<Integer> itemsPurchasedQty;
    protected Double amountDue;
    protected Double amountPaid;
    protected Double amountPaidUsingPoints;
    protected Integer loyaltyPointsDeducted;
    protected String memberEmail;
    protected String receiptNo;

    /**
     * Gets the value of the staffEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStaffEmail() {
        return staffEmail;
    }

    /**
     * Sets the value of the staffEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStaffEmail(String value) {
        this.staffEmail = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the storeID property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStoreID() {
        return storeID;
    }

    /**
     * Sets the value of the storeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStoreID(Long value) {
        this.storeID = value;
    }

    /**
     * Gets the value of the posName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosName() {
        return posName;
    }

    /**
     * Sets the value of the posName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosName(String value) {
        this.posName = value;
    }

    /**
     * Gets the value of the itemsPurchasedSKU property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemsPurchasedSKU property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemsPurchasedSKU().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getItemsPurchasedSKU() {
        if (itemsPurchasedSKU == null) {
            itemsPurchasedSKU = new ArrayList<String>();
        }
        return this.itemsPurchasedSKU;
    }

    /**
     * Gets the value of the itemsPurchasedQty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemsPurchasedQty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemsPurchasedQty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getItemsPurchasedQty() {
        if (itemsPurchasedQty == null) {
            itemsPurchasedQty = new ArrayList<Integer>();
        }
        return this.itemsPurchasedQty;
    }

    /**
     * Gets the value of the amountDue property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAmountDue() {
        return amountDue;
    }

    /**
     * Sets the value of the amountDue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAmountDue(Double value) {
        this.amountDue = value;
    }

    /**
     * Gets the value of the amountPaid property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAmountPaid() {
        return amountPaid;
    }

    /**
     * Sets the value of the amountPaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAmountPaid(Double value) {
        this.amountPaid = value;
    }

    /**
     * Gets the value of the amountPaidUsingPoints property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAmountPaidUsingPoints() {
        return amountPaidUsingPoints;
    }

    /**
     * Sets the value of the amountPaidUsingPoints property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAmountPaidUsingPoints(Double value) {
        this.amountPaidUsingPoints = value;
    }

    /**
     * Gets the value of the loyaltyPointsDeducted property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLoyaltyPointsDeducted() {
        return loyaltyPointsDeducted;
    }

    /**
     * Sets the value of the loyaltyPointsDeducted property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLoyaltyPointsDeducted(Integer value) {
        this.loyaltyPointsDeducted = value;
    }

    /**
     * Gets the value of the memberEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMemberEmail() {
        return memberEmail;
    }

    /**
     * Sets the value of the memberEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMemberEmail(String value) {
        this.memberEmail = value;
    }

    /**
     * Gets the value of the receiptNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceiptNo() {
        return receiptNo;
    }

    /**
     * Sets the value of the receiptNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceiptNo(String value) {
        this.receiptNo = value;
    }

}
