// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo;

/**
 * Linked to RefMan.ReviewPatientElectiveList business object (ID: 1096100069).
 */
public class ReviewPatientElectiveListVo extends ims.RefMan.vo.ReviewPatientElectiveListRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ReviewPatientElectiveListVo()
	{
	}
	public ReviewPatientElectiveListVo(Integer id, int version)
	{
		super(id, version);
	}
	public ReviewPatientElectiveListVo(ims.RefMan.vo.beans.ReviewPatientElectiveListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.reviewtype = bean.getReviewType() == null ? null : ims.RefMan.vo.lookups.ElectiveListReviewType.buildLookup(bean.getReviewType());
		this.reviewnotes = bean.getReviewNotes();
		this.revieweddate = bean.getReviewedDate() == null ? null : bean.getReviewedDate().buildDateTime();
		this.reviewedby = bean.getReviewedBy() == null ? null : bean.getReviewedBy().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.ReviewPatientElectiveListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.reviewtype = bean.getReviewType() == null ? null : ims.RefMan.vo.lookups.ElectiveListReviewType.buildLookup(bean.getReviewType());
		this.reviewnotes = bean.getReviewNotes();
		this.revieweddate = bean.getReviewedDate() == null ? null : bean.getReviewedDate().buildDateTime();
		this.reviewedby = bean.getReviewedBy() == null ? null : bean.getReviewedBy().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.ReviewPatientElectiveListVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.ReviewPatientElectiveListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.ReviewPatientElectiveListVoBean();
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
		if(fieldName.equals("REVIEWTYPE"))
			return getReviewType();
		if(fieldName.equals("REVIEWNOTES"))
			return getReviewNotes();
		if(fieldName.equals("REVIEWEDDATE"))
			return getReviewedDate();
		if(fieldName.equals("REVIEWEDBY"))
			return getReviewedBy();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getReviewTypeIsNotNull()
	{
		return this.reviewtype != null;
	}
	public ims.RefMan.vo.lookups.ElectiveListReviewType getReviewType()
	{
		return this.reviewtype;
	}
	public void setReviewType(ims.RefMan.vo.lookups.ElectiveListReviewType value)
	{
		this.isValidated = false;
		this.reviewtype = value;
	}
	public boolean getReviewNotesIsNotNull()
	{
		return this.reviewnotes != null;
	}
	public String getReviewNotes()
	{
		return this.reviewnotes;
	}
	public static int getReviewNotesMaxLength()
	{
		return 1000;
	}
	public void setReviewNotes(String value)
	{
		this.isValidated = false;
		this.reviewnotes = value;
	}
	public boolean getReviewedDateIsNotNull()
	{
		return this.revieweddate != null;
	}
	public ims.framework.utils.DateTime getReviewedDate()
	{
		return this.revieweddate;
	}
	public void setReviewedDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.revieweddate = value;
	}
	public boolean getReviewedByIsNotNull()
	{
		return this.reviewedby != null;
	}
	public ims.core.vo.MemberOfStaffLiteVo getReviewedBy()
	{
		return this.reviewedby;
	}
	public void setReviewedBy(ims.core.vo.MemberOfStaffLiteVo value)
	{
		this.isValidated = false;
		this.reviewedby = value;
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
		if(this.reviewedby != null)
		{
			if(!this.reviewedby.isValidated())
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
		if(this.reviewnotes != null)
			if(this.reviewnotes.length() > 1000)
				listOfErrors.add("The length of the field [reviewnotes] in the value object [ims.RefMan.vo.ReviewPatientElectiveListVo] is too big. It should be less or equal to 1000");
		if(this.revieweddate == null)
			listOfErrors.add("ReviewedDate is mandatory");
		if(this.reviewedby == null)
			listOfErrors.add("ReviewedBy is mandatory");
		if(this.reviewedby != null)
		{
			String[] listOfOtherErrors = this.reviewedby.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
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
	
		ReviewPatientElectiveListVo clone = new ReviewPatientElectiveListVo(this.id, this.version);
		
		if(this.reviewtype == null)
			clone.reviewtype = null;
		else
			clone.reviewtype = (ims.RefMan.vo.lookups.ElectiveListReviewType)this.reviewtype.clone();
		clone.reviewnotes = this.reviewnotes;
		if(this.revieweddate == null)
			clone.revieweddate = null;
		else
			clone.revieweddate = (ims.framework.utils.DateTime)this.revieweddate.clone();
		if(this.reviewedby == null)
			clone.reviewedby = null;
		else
			clone.reviewedby = (ims.core.vo.MemberOfStaffLiteVo)this.reviewedby.clone();
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
		if (!(ReviewPatientElectiveListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ReviewPatientElectiveListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ReviewPatientElectiveListVo compareObj = (ReviewPatientElectiveListVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getReviewedDate() == null && compareObj.getReviewedDate() != null)
				return -1;
			if(this.getReviewedDate() != null && compareObj.getReviewedDate() == null)
				return 1;
			if(this.getReviewedDate() != null && compareObj.getReviewedDate() != null)
				retVal = this.getReviewedDate().compareTo(compareObj.getReviewedDate());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.reviewtype != null)
			count++;
		if(this.reviewnotes != null)
			count++;
		if(this.revieweddate != null)
			count++;
		if(this.reviewedby != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.RefMan.vo.lookups.ElectiveListReviewType reviewtype;
	protected String reviewnotes;
	protected ims.framework.utils.DateTime revieweddate;
	protected ims.core.vo.MemberOfStaffLiteVo reviewedby;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
