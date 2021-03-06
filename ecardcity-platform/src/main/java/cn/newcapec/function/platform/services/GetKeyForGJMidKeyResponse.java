
package cn.newcapec.function.platform.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetKeyForGJMidKeyResult" type="{http://tempuri.org/}Result" minOccurs="0"/>
 *         &lt;element name="encKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getKeyForGJMidKeyResult",
    "encKey"
})
@XmlRootElement(name = "GetKeyForGJMidKeyResponse")
public class GetKeyForGJMidKeyResponse {

    @XmlElement(name = "GetKeyForGJMidKeyResult")
    protected Result getKeyForGJMidKeyResult;
    protected String encKey;

    /**
     * Gets the value of the getKeyForGJMidKeyResult property.
     * 
     * @return
     *     possible object is
     *     {@link Result }
     *     
     */
    public Result getGetKeyForGJMidKeyResult() {
        return getKeyForGJMidKeyResult;
    }

    /**
     * Sets the value of the getKeyForGJMidKeyResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Result }
     *     
     */
    public void setGetKeyForGJMidKeyResult(Result value) {
        this.getKeyForGJMidKeyResult = value;
    }

    /**
     * Gets the value of the encKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEncKey() {
        return encKey;
    }

    /**
     * Sets the value of the encKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEncKey(String value) {
        this.encKey = value;
    }

}
