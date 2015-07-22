/*
 * XMLTableModel.java
 *
 * Created on 31 July 2007, 20:25
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package tcav.gui.procedure;

import javax.swing.table.*;
import java.util.List;
import tcav.procedure.ProcedureManager;
import tcav.plmxmlpdm.*;
import tcav.plmxmlpdm.type.*;
import tcav.plmxmlpdm.type.element.*;
import tcav.plmxmlpdm.base.*;

/**
 *
 * @author NZR4DL
 */
public class XMLTableModel extends AbstractTableModel implements TableModel {
    private NodeReference nr;
    private ProcedureManager pm;
    
    /**
     * Creates a new instance of XMLTableModel
     */
    public XMLTableModel(NodeReference nr, ProcedureManager pm) {
        this.nr = nr;
        this.pm = pm;
    }
    
    public XMLTableModel() {
        this(null, null);
    }
    
    public Class getColumnClass(int columnIndex) {
        return String.class;
    }
    
    public int getColumnCount() {
        return 2;
    }
    
    public String getColumnName(int columnIndex) {
        switch(columnIndex){
            case 0:
                return "Name";
                
            case 1:
                return "Value";
                
            default:
                return "";
        }
    }
    
    public int getRowCount() {
        if((nr == null) || (pm == null))
            return 0;
        
        switch(nr.getClassType()) {
            case WorkflowTemplate:
                return 12;
                
            case WorkflowAction:
                return 6;
                
            case WorkflowHandler:
                return 4;
                
            case WorkflowBusinessRule:
                return 6;
                
            case WorkflowBusinessRuleHandler:
                return 6;
                
            case WorkflowSignoffProfile:
                return 9;
                
            case Organisation:
                return 4;
                
            case Role:
                return 4;
                
            case Arguments:
            case UserData:
                return 5;
                
            case UserValue:
                return 15;
                
            case AssociatedDataSet:
            case AssociatedFolder:
            case AssociatedForm:
                return 6;
                
            case ValidationResults:
                return 5;
                
            default:
                return 0;
        }
        
    }
    
    public Object getValueAt(int rowIndex, int columnIndex) {
        if((nr == null) || (pm == null))
            return null;
        
        switch(nr.getClassType()){
            case WorkflowTemplate:
                return getWorkflowTemplateValueAt(rowIndex, columnIndex);
                
            case WorkflowAction:
                return getWorkflowActionValueAt(rowIndex, columnIndex);
                
            case WorkflowHandler:
                return getWorkflowHandlerValueAt(rowIndex, columnIndex);
                
            case WorkflowBusinessRule:
                return getWorkflowBusinessRuleValueAt(rowIndex, columnIndex);
                
            case WorkflowBusinessRuleHandler:
                return getWorkflowBusinessRuleHandlerValueAt(rowIndex, columnIndex);
                
            case WorkflowSignoffProfile:
                return getWorkflowSignoffProfileValueAt(rowIndex, columnIndex);
                
            case Organisation:
                return getOrganisationValueAt(rowIndex, columnIndex);
                
            case Role:
                return getRoleValueAt(rowIndex, columnIndex);
                
            case Arguments:
            case UserData:
                return getUserDataValueAt(rowIndex, columnIndex);
                
            case UserValue:
                return getUserValueAt(rowIndex, columnIndex);
                
            case AssociatedDataSet:
                return getAssociatedDataSetValueAt(rowIndex, columnIndex);
                
            case AssociatedFolder:
                return getAssociatedFolderValueAt(rowIndex, columnIndex);
                
            case AssociatedForm:
                return getAssociatedFormValueAt(rowIndex, columnIndex);
                
            case ValidationResults:
                return getValidationResultsValueAt(rowIndex, columnIndex);
                
            default:
                return null;
        }
        
    }
    
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        
    }
    
    private Object getUserDataValueAt(int rowIndex, int columnIndex) {
        AttribOwnerBase aob = pm.getAttribOwnerBase(nr.getParentId());
        UserDataType ud = (UserDataType)aob.getAttribute().get(aob.getAttributeIdIndex(nr.getId()));
        switch(rowIndex){
            case 0:
                if(columnIndex == 0)
                    return "Id";
                else
                    return ud.getId();
            case 1:
                if(columnIndex == 0)
                    return "Name";
                else
                    return ud.getName();
            case 2:
                if(columnIndex == 0)
                    return "Description";
                else
                    return ud.getDescription();
            case 3:
                if(columnIndex == 0)
                    return "Procedure Type";
                else
                    return nr.getClassType().value();
            case 4:
                if(columnIndex == 0)
                    return "Type";
                else
                    return ud.getType();
            default:
                return null;
        }
    }
    
    private Object getUserValueAt(int rowIndex, int columnIndex) {
        AttribOwnerBase aob = pm.getAttribOwnerBase(nr.getParentId());
        UserDataType ud = (UserDataType)aob.getAttribute().get(aob.getAttributeIdIndex(nr.getId()));
        UserDataElementType uv = ud.getUserValue().get(nr.getIndex());
        switch(rowIndex){
            case 0:
                if(columnIndex == 0)
                    return "Title";
                else
                    return uv.getTitle();
            case 1:
                if(columnIndex == 0)
                    return "Procedure Type";
                else
                    return nr.getClassType().value();
            case 2:
                if(columnIndex == 0)
                    return "Value";
                else
                    return uv.getValue();
            case 3:
                if(columnIndex == 0)
                    return "Type";
                else
                    return uv.getType();
            case 4:
                if(columnIndex == 0)
                    return "Data Reference";
                else {
                    if((ud.getUserValue().get(nr.getIndex()).getDataRef() != null) &&
                            (!ud.getUserValue().get(nr.getIndex()).getDataRef().equals("")))
                        return pm.getAttribOwnerBase(uv.getDataRef()).getName();
                    else
                        return null;
                }
            case 5:
                if(columnIndex == 0)
                    return "Editable";
                else
                    return uv.isEditable();
            case 6:
                if(columnIndex == 0)
                    return "Format";
                else
                    return uv.getFormat();
            case 7:
                if(columnIndex == 0)
                    return "Max Exclusive";
                else
                    return uv.getMaxExclusive();
            case 8:
                if(columnIndex == 0)
                    return "Max Inclusive";
                else
                    return uv.getMaxInclusive();
            case 9:
                if(columnIndex == 0)
                    return "Max Length";
                else
                    return uv.getMaxLength();
            case 10:
                if(columnIndex == 0)
                    return "Min Exclusive";
                else
                    return uv.getMinExclusive();
            case 11:
                if(columnIndex == 0)
                    return "Min Inclusive";
                else
                    return uv.getMinInclusive();
            case 12:
                if(columnIndex == 0)
                    return "Min Length";
                else
                    return uv.getMinLength();
            case 13:
                if(columnIndex == 0)
                    return "Step Value";
                else
                    return uv.getStepValue();
            case 14:
                if(columnIndex == 0)
                    return "User List";
                else {
                    if(uv.getUserList() != null)
                        return uv.getUserList().getType()+" Need more coding";
                    else
                        return null;
                }
            default:
                return null;
        }
    }
    
    private Object getWorkflowTemplateValueAt(int rowIndex, int columnIndex) {
        WorkflowTemplateType wt = pm.getWorkflowTemplates().get(pm.getIdIndex(nr.getId()));
        switch(rowIndex){
            case 0:
                if(columnIndex == 0)
                    return "Id";
                else
                    return wt.getId();
            case 1:
                if(columnIndex == 0)
                    return "Name";
                else
                    return wt.getName();
            case 2:
                if(columnIndex == 0)
                    return "Description";
                else
                    return wt.getDescription();
            case 3:
                if(columnIndex == 0)
                    return "Procedure Type";
                else
                    return nr.getClassType().value();
            case 4:
                if(columnIndex == 0)
                    return "Sign Off Quorum";
                else
                    return wt.getSignoffQuorum();
            case 5:
                if(columnIndex == 0)
                    return "Classification";
                else
                    return wt.getTemplateClassification().value();
            case 6:
                if(columnIndex == 0)
                    return "Show in Process Stage";
                else
                    return wt.isShowInProcessStage();
            case 7:
                if(columnIndex == 0)
                    return "Parent Task";
                else {
                    if((wt.getParentTaskTemplateRef() != null) && (!wt.getParentTaskTemplateRef().equals("")))
                        return pm.getAttribOwnerBase(wt.getParentTaskTemplateRef()).getName();
                    else
                        return null;
                }
            case 8:
                if(columnIndex == 0)
                    return "Stage";
                else
                    return wt.getStage().value();
            case 9:
                if(columnIndex == 0)
                    return "Object Type";
                else
                    return wt.getObjectType();
            case 10:
                if(columnIndex == 0)
                    return "Key";
                else
                    return wt.getIconKey();
            case 11:
                if(columnIndex == 0)
                    return "Task Description";
                else {
                    UserListDataType uld = wt.getTaskDescription();
                    if(uld != null)
                        return uld.getItem().get(0).getValue();
                    else
                        return null;
                }
            default:
                return null;
        }
    }
    
    private Object getWorkflowActionValueAt(int rowIndex, int columnIndex) {
        WorkflowActionType wa = pm.getWorkflowActions().get(pm.getIdIndex(nr.getId()));
        switch(rowIndex){
            case 0:
                if(columnIndex == 0)
                    return "Id";
                else
                    return wa.getId();
            case 1:
                if(columnIndex == 0)
                    return "Name";
                else
                    return wa.getName();
            case 2:
                if(columnIndex == 0)
                    return "Description";
                else
                    return wa.getDescription();
            case 3:
                if(columnIndex == 0)
                    return "Procedure Type";
                else
                    return nr.getClassType().value();
            case 4:
                if(columnIndex == 0)
                    return "Action Type";
                else
                    return wa.getActionType();
            case 5:
                if(columnIndex == 0)
                    return "Parent Process";
                else {
                    if((!wa.getParentRef().equals("")) && (wa.getParentRef() != null))
                        return pm.getAttribOwnerBase(wa.getParentRef()).getName();
                    else
                        return null;
                }
            default:
                return null;
        }
    }
    
    private Object getWorkflowHandlerValueAt(int rowIndex, int columnIndex) {
        WorkflowHandlerType wh = pm.getWorkflowHandlers().get(pm.getIdIndex(nr.getId()));
        switch(rowIndex){
            case 0:
                if(columnIndex == 0)
                    return "Id";
                else
                    return wh.getId();
            case 1:
                if(columnIndex == 0)
                    return "Name";
                else
                    return wh.getName();
            case 2:
                if(columnIndex == 0)
                    return "Description";
                else
                    return wh.getDescription();
            case 3:
                if(columnIndex == 0)
                    return "Procedure Type";
                else
                    return nr.getClassType().value();
            default:
                return null;
        }
    }
    
    private Object getWorkflowBusinessRuleValueAt(int rowIndex, int columnIndex) {
        WorkflowBusinessRuleType wbr = pm.getWorkflowBusinessRules().get(pm.getIdIndex(nr.getId()));
        switch(rowIndex){
            case 0:
                if(columnIndex == 0)
                    return "Id";
                else
                    return wbr.getId();
            case 1:
                if(columnIndex == 0)
                    return "Name";
                else
                    return wbr.getName();
            case 2:
                if(columnIndex == 0)
                    return "Description";
                else
                    return wbr.getDescription();
            case 3:
                if(columnIndex == 0)
                    return "Procedure Type";
                else
                    return nr.getClassType().value();
            case 4:
                if(columnIndex == 0)
                    return "Sign Off Quorum";
                else
                    return wbr.getRuleQuorum();
            case 5:
                if(columnIndex == 0)
                    return "Parent Action";
                else
                    return wbr.getParentRef();
            default:
                return null;
        }
    }
    
    private Object getWorkflowBusinessRuleHandlerValueAt(int rowIndex, int columnIndex) {
        WorkflowBusinessRuleHandlerType wbrh = pm.getWorkflowBusinessRuleHandlers().get(pm.getIdIndex(nr.getId()));
        switch(rowIndex){
            case 0:
                if(columnIndex == 0)
                    return "Id";
                else
                    return wbrh.getId();
            case 1:
                if(columnIndex == 0)
                    return "Name";
                else
                    return wbrh.getName();
            case 2:
                if(columnIndex == 0)
                    return "Description";
                else
                    return wbrh.getDescription();
            case 3:
                if(columnIndex == 0)
                    return "Procedure Type";
                else
                    return nr.getClassType().value();
            case 4:
                if(columnIndex == 0)
                    return "Negated";
                else
                    return wbrh.isNegated();
            case 5:
                if(columnIndex == 0)
                    return "Overide";
                else
                    return wbrh.isOverride();
            default:
                return null;
        }
    }
    
    private Object getWorkflowSignoffProfileValueAt(int rowIndex, int columnIndex) {
        WorkflowSignoffProfileType wsp =
                pm.getWorkflowSignoffProfiles().get(pm.getIdIndex(nr.getId()));
        switch(rowIndex){
            case 0:
                if(columnIndex == 0)
                    return "Id";
                else
                    return wsp.getId();
            case 1:
                if(columnIndex == 0)
                    return "Name";
                else
                    return wsp.getName();
            case 2:
                if(columnIndex == 0)
                    return "Description";
                else
                    return wsp.getDescription();
            case 3:
                if(columnIndex == 0)
                    return "Procedure Type";
                else
                    return nr.getClassType().value();
            case 4:
                if(columnIndex == 0)
                    return "Sign Off Quorum";
                else
                    return wsp.getSignoffQuorum();
            case 5:
                if(columnIndex == 0)
                    return "Number of Sign Offs";
                else
                    return wsp.getNumberOfSignoffs();
            case 6:
                if(columnIndex == 0)
                    return "Allow Sub Groups";
                else
                    return wsp.isAllowSubgroups();
            case 7:
                if(columnIndex == 0)
                    return "Role Reference";
                else {
                    if((wsp.getRoleRef() != null) && (!wsp.getRoleRef().equals("")))
                        return pm.getAttribOwnerBase(wsp.getRoleRef()).getId()
                        +" "+
                                pm.getAttribOwnerBase(wsp.getRoleRef()).getName();
                    else
                        return null;
                }
            case 8:
                if(columnIndex == 0)
                    return "Group Reference";
                else {
                    if((wsp.getGroupRef() != null) && (!wsp.getGroupRef().equals("")))
                        return pm.getAttribOwnerBase(wsp.getGroupRef()).getId()
                        +" "+
                                pm.getAttribOwnerBase(wsp.getGroupRef()).getName();
                    else
                        return null;
                }
            default:
                return null;
        }
    }
    
    private Object getOrganisationValueAt(int rowIndex, int columnIndex){
        OrganisationType o = pm.getOrganisations().get(pm.getIdIndex(nr.getId()));
        switch(rowIndex){
            case 0:
                if(columnIndex == 0)
                    return "Id";
                else
                    return o.getId();
            case 1:
                if(columnIndex == 0)
                    return "Name";
                else
                    return o.getName();
            case 2:
                if(columnIndex == 0)
                    return "Description";
                else
                    return o.getDescription();
            case 3:
                if(columnIndex == 0)
                    return "Procedure Type";
                else
                    return nr.getClassType().value();
            default:
                return null;
        }
    }
    
    private Object getRoleValueAt(int rowIndex, int columnIndex) {
        RoleType r = pm.getRoles().get(pm.getIdIndex(nr.getId()));
        switch(rowIndex){
            case 0:
                if(columnIndex == 0)
                    return "Id";
                else
                    return r.getId();
            case 1:
                if(columnIndex == 0)
                    return "Name";
                else
                    return r.getName();
            case 2:
                if(columnIndex == 0)
                    return "Description";
                else
                    return r.getDescription();
            case 3:
                if(columnIndex == 0)
                    return "Procedure Type";
                else
                    return nr.getClassType().value();
            default:
                return null;
        }
    }
    
    private Object getAssociatedDataSetValueAt(int rowIndex, int columnIndex) {
        AttribOwnerBase aob = pm.getAttribOwnerBase(nr.getParentId());
        AssociatedDataSetType ad = (AssociatedDataSetType)aob.getAttribute().get(aob.getAttributeIdIndex(nr.getId()));
        switch(rowIndex){
            case 0:
                if(columnIndex == 0)
                    return "Id";
                else
                    return ad.getId();
            case 1:
                if(columnIndex == 0)
                    return "Name";
                else
                    return ad.getName();
            case 2:
                if(columnIndex == 0)
                    return "Description";
                else
                    return ad.getDescription();
            case 3:
                if(columnIndex == 0)
                    return "Procedure Type";
                else
                    return nr.getClassType().value();
            case 4:
                if(columnIndex == 0)
                    return "Role";
                else
                    return ad.getRole();
            case 5:
                if(columnIndex == 0)
                    return "DataSet Reference";
                else {
                    if(pm.getIdClass(ad.getDataSetRef()) == TagTypeEnum.WorkflowSignoffProfile){
                        WorkflowSignoffProfileType wsp =
                                pm.getWorkflowSignoffProfiles().get(pm.getIdIndex(ad.getDataSetRef()));
                        return "Sign Off Profile: "+ad.getId();
                    }
                    return null;
                }
            default:
                return null;
        }
    }
    
    private Object getAssociatedFolderValueAt(int rowIndex, int columnIndex) {
        AttribOwnerBase aob = pm.getAttribOwnerBase(nr.getParentId());
        AssociatedFolderType af = (AssociatedFolderType)aob.getAttribute().get(aob.getAttributeIdIndex(nr.getId()));
        switch(rowIndex){
            case 0:
                if(columnIndex == 0)
                    return "Id";
                else
                    return af.getId();
            case 1:
                if(columnIndex == 0)
                    return "Name";
                else
                    return af.getName();
            case 2:
                if(columnIndex == 0)
                    return "Description";
                else
                    return af.getDescription();
            case 3:
                if(columnIndex == 0)
                    return "Procedure Type";
                else
                    return nr.getClassType().value();
            case 4:
                if(columnIndex == 0)
                    return "Role";
                else
                    return af.getRole();
            case 5:
                if(columnIndex == 0)
                    return "Folder Reference";
                else {
                    if(pm.getIdClass(af.getFolderRef()) == TagTypeEnum.WorkflowSignoffProfile){
                        WorkflowSignoffProfileType wsp =
                                pm.getWorkflowSignoffProfiles().get(pm.getIdIndex(af.getFolderRef()));
                        return "Sign Off Profile: "+af.getId();
                    }
                    return null;
                }
            default:
                return null;
        }
    }
    
    private Object getAssociatedFormValueAt(int rowIndex, int columnIndex) {
        AttribOwnerBase aob = pm.getAttribOwnerBase(nr.getParentId());
        AssociatedFormType af = (AssociatedFormType)aob.getAttribute().get(aob.getAttributeIdIndex(nr.getId()));
        switch(rowIndex){
            case 0:
                if(columnIndex == 0)
                    return "Id";
                else
                    return af.getId();
            case 1:
                if(columnIndex == 0)
                    return "Name";
                else
                    return af.getName();
            case 2:
                if(columnIndex == 0)
                    return "Description";
                else
                    return af.getDescription();
            case 3:
                if(columnIndex == 0)
                    return "Procedure Type";
                else
                    return nr.getClassType().value();
            case 4:
                if(columnIndex == 0)
                    return "Role";
                else
                    return af.getRole();
            case 5:
                if(columnIndex == 0)
                    return "Folder Reference";
                else {
                    if(pm.getIdClass(af.getFormRef()) == TagTypeEnum.WorkflowSignoffProfile){
                        WorkflowSignoffProfileType wsp =
                                pm.getWorkflowSignoffProfiles().get(pm.getIdIndex(af.getFormRef()));
                        return "Sign Off Profile: "+af.getId();
                    }
                    return null;
                }
            default:
                return null;
        }
    }
    
    private Object getValidationResultsValueAt(int rowIndex, int columnIndex) {
        AttribOwnerBase aob = pm.getAttribOwnerBase(nr.getParentId());
        ValidationResultsType vr = (ValidationResultsType)aob.getAttribute().get(aob.getAttributeIdIndex(nr.getId()));
        switch(rowIndex){
            case 0:
                if(columnIndex == 0)
                    return "Id";
                else
                    return vr.getId();
            case 1:
                if(columnIndex == 0)
                    return "Name";
                else
                    return vr.getName();
            case 2:
                if(columnIndex == 0)
                    return "Description";
                else
                    return vr.getDescription();
            case 3:
                if(columnIndex == 0)
                    return "Application";
                else
                    return vr.getApplication();
            case 4:
                if(columnIndex == 0)
                    return "Procedure Type";
                else
                    return nr.getClassType().value();
            default:
                return null;
        }
    }
    
}