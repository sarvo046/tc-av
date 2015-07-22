//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.3-b24-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.07.22 at 11:41:15 AM EST 
//


package tceav.manager.procedure.plmxmlpdm.UnusedRequiredTags;

import java.util.ArrayList;
import java.util.List;
import tceav.manager.procedure.plmxmlpdm.base.AttribOwnerBase;
import org.w3c.dom.Node;
/*
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
*/

/**
 * <p>Java class for TaskType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TaskType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plmxml.org/Schemas/PLMXMLSchema}AttribOwnerBase">
 *       &lt;sequence>
 *         &lt;element name="Signoff" type="{http://www.plmxml.org/Schemas/PLMXMLSchema}SignoffType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ReleaseStatus" type="{http://www.plmxml.org/Schemas/PLMXMLSchema}ReleaseStatusType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="referenceRefs">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.plmxml.org/Schemas/PLMXMLSchema}uriReferenceListType">
 *             &lt;minLength value="1"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="state" type="{http://www.plmxml.org/Schemas/PLMXMLSchema}TaskStateType" />
 *       &lt;attribute name="subTaskRefs" type="{http://www.plmxml.org/Schemas/PLMXMLSchema}uriReferenceListType" />
 *       &lt;attribute name="targetRefs">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.plmxml.org/Schemas/PLMXMLSchema}uriReferenceListType">
 *             &lt;minLength value="1"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
//@XmlAccessorType(XmlAccessType.FIELD)
/*
 @XmlType(name = "TaskType", propOrder = {
    "signoff",
    "releaseStatus"
})
 */
public class TaskType extends AttribOwnerBase {

    //@XmlElement(name = "Signoff")
    protected List<SignoffType> signoff;
    //@XmlElement(name = "ReleaseStatus")
    protected ReleaseStatusType releaseStatus;
    //@XmlAttribute
    protected List<String> referenceRefs;
    //@XmlAttribute
    protected TaskStateType state;
    //@XmlAttribute
    protected List<String> subTaskRefs;
    //@XmlAttribute
    protected List<String> targetRefs;
    
    public TaskType(Node node) {
        super(node);
    }

    /**
     * Gets the value of the signoff property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the signoff property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSignoff().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SignoffType }
     * 
     * 
     */
    public List<SignoffType> getSignoff() {
        if (signoff == null) {
            signoff = new ArrayList<SignoffType>();
        }
        return this.signoff;
    }

    /**
     * Gets the value of the releaseStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ReleaseStatusType }
     *     
     */
    public ReleaseStatusType getReleaseStatus() {
        return releaseStatus;
    }

    /**
     * Sets the value of the releaseStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReleaseStatusType }
     *     
     */
    public void setReleaseStatus(ReleaseStatusType value) {
        this.releaseStatus = value;
    }

    /**
     * Gets the value of the referenceRefs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the referenceRefs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReferenceRefs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getReferenceRefs() {
        if (referenceRefs == null) {
            referenceRefs = new ArrayList<String>();
        }
        return this.referenceRefs;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link TaskStateType }
     *     
     */
    public TaskStateType getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskStateType }
     *     
     */
    public void setState(TaskStateType value) {
        this.state = value;
    }

    /**
     * Gets the value of the subTaskRefs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subTaskRefs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubTaskRefs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSubTaskRefs() {
        if (subTaskRefs == null) {
            subTaskRefs = new ArrayList<String>();
        }
        return this.subTaskRefs;
    }

    /**
     * Gets the value of the targetRefs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the targetRefs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTargetRefs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTargetRefs() {
        if (targetRefs == null) {
            targetRefs = new ArrayList<String>();
        }
        return this.targetRefs;
    }

}
