//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.3-b24-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.07.22 at 11:41:15 AM EST 
//


package tcav.plmxmlpdm.type;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.NamedNodeMap;
import tcav.plmxmlpdm.base.AttributeBase;
import tcav.plmxmlpdm.*;
import tcav.plmxmlpdm.classtype.UserValueDataType;
import tcav.plmxmlpdm.type.element.UserListElementType;
/*
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
*/

/**
 * 
 *       This element defines a list of user specified data items. Each item in the 
 *       list is of the same type - as specified by the 'type' attribute'.
 * 
 *       Attributes:
 * 
 *       type:           type of data items, i.e. int, ints, etc. 
 * 
 *       Elements:
 * 
 *       Item:           One element per data item.
 *       
 * 
 * <p>Java class for UserListDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserListDataType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.plmxml.org/Schemas/PLMXMLSchema}AttributeBase">
 *       &lt;choice>
 *         &lt;element name="Item" type="{http://www.plmxml.org/Schemas/PLMXMLSchema}UserListElementType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/choice>
 *       &lt;attribute name="type" type="{http://www.plmxml.org/Schemas/PLMXMLSchema}UserValueDataType" default="string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
//@XmlAccessorType(XmlAccessType.FIELD)
/*
 @XmlType(name = "UserListDataType", propOrder = {
    "item"
})
 */
public class UserListDataType extends AttributeBase {

    //@XmlElement(name = "Item")
    protected List<UserListElementType> item;
    
    //@XmlAttribute
    protected final String typeAttribute = "type";
    protected UserValueDataType type;
    
    public UserListDataType(Node node) {
        super(node);
        Node currentNode = node;
        NamedNodeMap attrib = currentNode.getAttributes();
        NodeList nodeList = currentNode.getChildNodes();
        
        String s = TagTools.getStringValue(attrib, typeAttribute);
        if(s != null)
            setType(UserValueDataType.fromValue(s));
        
        setTagType(TagTypeEnum.UserList);
        
        TagTypeEnum tagType;
        for (int i=0; i<nodeList.getLength(); i++) {
            currentNode = nodeList.item(i);
            tagType = TagTypeEnum.fromValue(currentNode.getNodeName());
            
            switch(tagType) {
                case Item:
                    getItem().add(new UserListElementType(currentNode));
                    break;
                    
                default:
                    break;
            }
        }

    }

    public List<UserListElementType> getItem() {
        if (item == null)
            item = new ArrayList<UserListElementType>();
        
        return this.item;
    }

    public UserValueDataType getType() {
        if (type == null)
            return UserValueDataType.STRING;
        else
            return type;
    }

    public void setType(UserValueDataType value) {
        this.type = value;
    }

}
