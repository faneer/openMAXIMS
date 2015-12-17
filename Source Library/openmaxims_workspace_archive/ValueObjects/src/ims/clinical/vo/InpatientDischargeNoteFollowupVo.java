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
 * Linked to clinical.InpatientDischargeNoteFollowup business object (ID: 1072100050).
 */
public class InpatientDischargeNoteFollowupVo extends ims.clinical.vo.InpatientDischargeNoteFollowupRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public InpatientDischargeNoteFollowupVo()
	{
	}
	public InpatientDischargeNoteFollowupVo(Integer id, int version)
	{
		super(id, version);
	}
	public InpatientDischargeNoteFollowupVo(ims.clinical.vo.beans.InpatientDischargeNoteFollowupVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicalnote = bean.getClinicalNote() == null ? null : bean.getClinicalNote().buildVo();
		this.outcome = bean.getOutcome() == null ? null : ims.clinical.vo.lookups.InpatientFollowUp.buildLookup(bean.getOutcome());
		this.reviewin = bean.getReviewIn();
		this.reviewinunits = bean.getReviewinUnits() == null ? null : ims.clinical.vo.lookups.ReviewInDuration.buildLookup(bean.getReviewinUnits());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.InpatientDischargeNoteFollowupVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicalnote = bean.getClinicalNote() == null ? null : bean.getClinicalNote().buildVo(map);
		this.outcome = bean.getOutcome() == null ? null : ims.clinical.vo.lookups.InpatientFollowUp.buildLookup(bean.getOutcome());
		this.reviewin = bean.getReviewIn();
		this.reviewinunits = bean.getReviewinUnits() == null ? null : ims.clinical.vo.lookups.ReviewInDuration.buildLookup(bean.getReviewinUnits());
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.InpatientDischargeNoteFollowupVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.InpatientDischargeNoteFollowupVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.InpatientDischargeNoteFollowupVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public Object getFieldValueByFieldName(String fieldName)
	{
		if(fieldName == null)
			throw new ims.framework.exceptions.CodingRuntimeException("Invalid field name");
		fieldName = fieldName.toUpperCase();
		if(fieldName.equals("CLINICALNOTE"))
			return getClinicalNote();
		if(fieldName.equals("OUTCOME"))
			return getOutcome();
		if(fieldName.equals("REVIEWIN"))
			return getReviewIn();
		if(fieldName.equals("REVIEWINUNITS"))
			return getReviewinUnits();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getClinicalNoteIsNotNull()
	{
		return this.clinicalnote != null;
	}
	public ims.core.vo.ClinicalNotesVo getClinicalNote()
	{
		return this.clinicalnote;
	}
	public void setClinicalNote(ims.core.vo.ClinicalNotesVo value)
	{
		this.isValidated = false;
		this.clinicalnote = value;
	}
	public boolean getOutcomeIsNotNull()
	{
		return this.outcome != null;
	}
	public ims.clinical.vo.lookups.InpatientFollowUp getOutcome()
	{
		return this.outcome;
	}
	public void setOutcome(ims.clinical.vo.lookups.InpatientFollowUp value)
	{
		this.isValidated = false;
		this.outcome = value;
	}
	public boolean getReviewInIsNotNull()
	{
		return this.reviewin != null;
	}
	public Integer getReviewIn()
	{
		return this.reviewin;
	}
	public void setReviewIn(Integer value)
	{
		this.isValidated = false;
		this.reviewin = value;
	}
	public boolean getReviewinUnitsIsNotNull()
	{
		return this.reviewinunits != null;
	}
	public ims.clinical.vo.lookups.ReviewInDuration getReviewinUnits()
	{
		return this.reviewinunits;
	}
	public void setReviewinUnits(ims.clinical.vo.lookups.ReviewInDuration value)
	{
		this.isValidated = false;
		this.reviewinunits = value;
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.admin.vo.CareContextRefVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
	}
	public boolean isValidated()
	{
		if(this.isBusy)
			return true;
		this.isBusy = true;
	
		if(!this.isValidated)
		{
			this.isBusy = false;
			return false;
		}
		if(this.clinicalnote != null)
		{
			if(!this.clinicalnote.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		this.isBusy = false;
		return true;
	}
	public String[] validate()
	{
		return validate(null);
	}
	public String[] validate(String[] existingErrors)
	{
		if(this.isBusy)
			return null;
		this.isBusy = true;
	
		java.util.ArrayList<String> listOfErrors = new java.util.ArrayList<String>();
		if(existingErrors != null)
		{
			for(int x = 0; x < existingErrors.length; x++)
			{
				listOfErrors.add(existingErrors[x]);
			}
		}
		if(this.clinicalnote != null)
		{
			String[] listOfOtherErrors = this.clinicalnote.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		int errorCount = listOfErrors.size();
		if(errorCount == 0)
		{
			this.isBusy = false;
			this.isValidated = true;
			return null;
		}
		String[] result = new String[errorCount];
		for(int x = 0; x < errorCount; x++)
			result[x] = (String)listOfErrors.get(x);
		this.isBusy = false;
		this.isValidated = false;
		return result;
	}
	public void clearIDAndVersion()
	{
		this.id = null;
		this.version = 0;
	}
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		InpatientDischargeNoteFollowupVo clone = new InpatientDischargeNoteFollowupVo(this.id, this.version);
		
		if(this.clinicalnote == null)
			clone.clinicalnote = null;
		else
			clone.clinicalnote = (ims.core.vo.ClinicalNotesVo)this.clinicalnote.clone();
		if(this.outcome == null)
			clone.outcome = null;
		else
			clone.outcome = (ims.clinical.vo.lookups.InpatientFollowUp)this.outcome.clone();
		clone.reviewin = this.reviewin;
		if(this.reviewinunits == null)
			clone.reviewinunits = null;
		else
			clone.reviewinunits = (ims.clinical.vo.lookups.ReviewInDuration)this.reviewinunits.clone();
		clone.carecontext = this.carecontext;
		clone.isValidated = this.isValidated;
		
		this.isBusy = false;
		return clone;
	}
	public int compareTo(Object obj)
	{
		return compareTo(obj, true);
	}
	public int compareTo(Object obj, boolean caseInsensitive)
	{
		if (obj == null)
		{
			return -1;
		}
		if(caseInsensitive); // this is to avoid eclipse warning only.
		if (!(InpatientDischargeNoteFollowupVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A InpatientDischargeNoteFollowupVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((InpatientDischargeNoteFollowupVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((InpatientDischargeNoteFollowupVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.clinicalnote != null)
			count++;
		if(this.outcome != null)
			count++;
		if(this.reviewin != null)
			count++;
		if(this.reviewinunits != null)
			count++;
		if(this.carecontext != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.core.vo.ClinicalNotesVo clinicalnote;
	protected ims.clinical.vo.lookups.InpatientFollowUp outcome;
	protected Integer reviewin;
	protected ims.clinical.vo.lookups.ReviewInDuration reviewinunits;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
