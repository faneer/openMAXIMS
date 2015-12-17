// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo;

/**
 * Linked to RefMan.ClinicalOutcomeContextProcedureRequiredConfig business object (ID: 1096100057).
 */
public class ClinicalOutcomeContextProcedureRequiredConfigRefVo extends ims.vo.ValueObjectRef implements ims.domain.IDomainGetter
{
	private static final long serialVersionUID = 1L;

	public ClinicalOutcomeContextProcedureRequiredConfigRefVo()
	{
	}
	public ClinicalOutcomeContextProcedureRequiredConfigRefVo(Integer id, int version)
	{
		super(id, version);
	}
	public final boolean getID_ClinicalOutcomeContextProcedureRequiredConfigIsNotNull()
	{
		return this.id != null;
	}
	public final Integer getID_ClinicalOutcomeContextProcedureRequiredConfig()
	{
		return this.id;
	}
	public final void setID_ClinicalOutcomeContextProcedureRequiredConfig(Integer value)
	{
		this.id = value;
	}
	public final int getVersion_ClinicalOutcomeContextProcedureRequiredConfig()
	{
		return this.version;
	}
	public Object clone()
	{
		return new ClinicalOutcomeContextProcedureRequiredConfigRefVo(this.id, this.version);
	}
	public final ClinicalOutcomeContextProcedureRequiredConfigRefVo toClinicalOutcomeContextProcedureRequiredConfigRefVo()
	{
		if(this.id == null)
			return this;
		return new ClinicalOutcomeContextProcedureRequiredConfigRefVo(this.id, this.version);
	}
	public boolean equals(Object obj)
	{
		if(!(obj instanceof ClinicalOutcomeContextProcedureRequiredConfigRefVo))
			return false;
		ClinicalOutcomeContextProcedureRequiredConfigRefVo compareObj = (ClinicalOutcomeContextProcedureRequiredConfigRefVo)obj;
		if(this.id != null && compareObj.getBoId() != null)
			return this.id.equals(compareObj.getBoId());
		if(this.id != null && compareObj.getBoId() == null)
			return false;
		if(this.id == null && compareObj.getBoId() != null)
			return false;
		return super.equals(obj);
	}
	public int hashCode()
	{
		if(this.id != null)
			return this.id.intValue();
		return super.hashCode();
	}
	public boolean isValidated()
	{
		return true;
	}
	public String[] validate()
	{
		return null;
	}
	public String getBoClassName()
	{
		return "ims.RefMan.domain.objects.ClinicalOutcomeContextProcedureRequiredConfig";
	}
	public Class getDomainClass()
	{
		return ims.RefMan.domain.objects.ClinicalOutcomeContextProcedureRequiredConfig.class;
	}
	public String getIItemText()
	{
		return toString();
	}
	public String toString()
	{
		return this.getClass().toString() + " (ID: " + (this.id == null ? "null" : this.id.toString()) + ")";
	}
	public int compareTo(Object obj)
	{
		if (obj == null)
			return -1;
		if (!(obj instanceof ClinicalOutcomeContextProcedureRequiredConfigRefVo))
			throw new ClassCastException("A ClinicalOutcomeContextProcedureRequiredConfigRefVo object cannot be compared an Object of type " + obj.getClass().getName());
		if (this.id == null)
			return 1;
		if (((ClinicalOutcomeContextProcedureRequiredConfigRefVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ClinicalOutcomeContextProcedureRequiredConfigRefVo)obj).getBoId());
	}
	// this method is not needed. It is here for compatibility purpose only.
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if(caseInsensitive); // this is to avoid Eclipse warning
		return compareTo(obj);
	}

	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("ID_CLINICALOUTCOMECONTEXTPROCEDUREREQUIREDCONFIG"))
			return getID_ClinicalOutcomeContextProcedureRequiredConfig();
		return super.getFieldValueByFieldName(fieldName);
	}
}
