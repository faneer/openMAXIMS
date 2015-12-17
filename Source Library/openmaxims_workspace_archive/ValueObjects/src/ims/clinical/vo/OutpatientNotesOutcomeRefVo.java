//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
//#                                                                           #
//#  This program is free software: you can redistribute it and/or modify     #
//#  it under the terms of the GNU Affero General Public License as           #
//#  published by the Free Software Foundation, either version 3 of the       #
//#  License, or (at your option) any later version.                          # 
//#                                                                           #
//#  This program is distributed in the hope that it will be useful,          #
//#  but WITHOUT ANY WARRANTY; without even the implied warranty of           #
//#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the            #
//#  GNU Affero General Public License for more details.                      #
//#                                                                           #
//#  You should have received a copy of the GNU Affero General Public License #
//#  along with this program.  If not, see <http://www.gnu.org/licenses/>.    #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.clinical.vo;

/**
 * Linked to clinical.OutpatientNotesOutcome business object (ID: 1072100046).
 */
public class OutpatientNotesOutcomeRefVo extends ims.vo.ValueObjectRef implements ims.domain.IDomainGetter
{
	private static final long serialVersionUID = 1L;

	public OutpatientNotesOutcomeRefVo()
	{
	}
	public OutpatientNotesOutcomeRefVo(Integer id, int version)
	{
		super(id, version);
	}
	public final boolean getID_OutpatientNotesOutcomeIsNotNull()
	{
		return this.id != null;
	}
	public final Integer getID_OutpatientNotesOutcome()
	{
		return this.id;
	}
	public final void setID_OutpatientNotesOutcome(Integer value)
	{
		this.id = value;
	}
	public final int getVersion_OutpatientNotesOutcome()
	{
		return this.version;
	}
	public Object clone()
	{
		return new OutpatientNotesOutcomeRefVo(this.id, this.version);
	}
	public final OutpatientNotesOutcomeRefVo toOutpatientNotesOutcomeRefVo()
	{
		if(this.id == null)
			return this;
		return new OutpatientNotesOutcomeRefVo(this.id, this.version);
	}
	public boolean equals(Object obj)
	{
		if(!(obj instanceof OutpatientNotesOutcomeRefVo))
			return false;
		OutpatientNotesOutcomeRefVo compareObj = (OutpatientNotesOutcomeRefVo)obj;
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
		return "ims.clinical.domain.objects.OutpatientNotesOutcome";
	}
	public Class getDomainClass()
	{
		return ims.clinical.domain.objects.OutpatientNotesOutcome.class;
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
		if (!(obj instanceof OutpatientNotesOutcomeRefVo))
			throw new ClassCastException("A OutpatientNotesOutcomeRefVo object cannot be compared an Object of type " + obj.getClass().getName());
		if (this.id == null)
			return 1;
		if (((OutpatientNotesOutcomeRefVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((OutpatientNotesOutcomeRefVo)obj).getBoId());
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
		if(fieldName.equals("ID_OUTPATIENTNOTESOUTCOME"))
			return getID_OutpatientNotesOutcome();
		return super.getFieldValueByFieldName(fieldName);
	}
}
