// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo;

/**
 * Linked to RefMan.CATSReferralStatus business object (ID: 1096100007).
 */
public class CATSReferralStatusRefVo extends ims.vo.ValueObjectRef implements ims.domain.IDomainGetter
{
	private static final long serialVersionUID = 1L;

	public CATSReferralStatusRefVo()
	{
	}
	public CATSReferralStatusRefVo(Integer id, int version)
	{
		super(id, version);
	}
	public final boolean getID_CATSReferralStatusIsNotNull()
	{
		return this.id != null;
	}
	public final Integer getID_CATSReferralStatus()
	{
		return this.id;
	}
	public final void setID_CATSReferralStatus(Integer value)
	{
		this.id = value;
	}
	public final int getVersion_CATSReferralStatus()
	{
		return this.version;
	}
	public Object clone()
	{
		return new CATSReferralStatusRefVo(this.id, this.version);
	}
	public final CATSReferralStatusRefVo toCATSReferralStatusRefVo()
	{
		if(this.id == null)
			return this;
		return new CATSReferralStatusRefVo(this.id, this.version);
	}
	public boolean equals(Object obj)
	{
		if(!(obj instanceof CATSReferralStatusRefVo))
			return false;
		CATSReferralStatusRefVo compareObj = (CATSReferralStatusRefVo)obj;
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
		return "ims.RefMan.domain.objects.CATSReferralStatus";
	}
	public Class getDomainClass()
	{
		return ims.RefMan.domain.objects.CATSReferralStatus.class;
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
		if (!(obj instanceof CATSReferralStatusRefVo))
			throw new ClassCastException("A CATSReferralStatusRefVo object cannot be compared an Object of type " + obj.getClass().getName());
		if (this.id == null)
			return 1;
		if (((CATSReferralStatusRefVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((CATSReferralStatusRefVo)obj).getBoId());
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
		if(fieldName.equals("ID_CATSREFERRALSTATUS"))
			return getID_CATSReferralStatus();
		return super.getFieldValueByFieldName(fieldName);
	}
}
