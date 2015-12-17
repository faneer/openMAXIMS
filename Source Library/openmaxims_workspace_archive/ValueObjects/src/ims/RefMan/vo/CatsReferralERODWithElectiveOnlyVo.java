// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo;

/**
 * Linked to RefMan.CatsReferral business object (ID: 1004100035).
 */
public class CatsReferralERODWithElectiveOnlyVo extends ims.RefMan.vo.CatsReferralRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CatsReferralERODWithElectiveOnlyVo()
	{
	}
	public CatsReferralERODWithElectiveOnlyVo(Integer id, int version)
	{
		super(id, version);
	}
	public CatsReferralERODWithElectiveOnlyVo(ims.RefMan.vo.beans.CatsReferralERODWithElectiveOnlyVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.journey = bean.getJourney() == null ? null : bean.getJourney().buildVo();
		this.electiveerod = ims.RefMan.vo.ReferralERODVoCollection.buildFromBeanCollection(bean.getElectiveEROD());
		this.electiveerodhistory = ims.RefMan.vo.ReferralERODVoCollection.buildFromBeanCollection(bean.getElectiveERODHistory());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.CatsReferralERODWithElectiveOnlyVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.journey = bean.getJourney() == null ? null : bean.getJourney().buildVo(map);
		this.electiveerod = ims.RefMan.vo.ReferralERODVoCollection.buildFromBeanCollection(bean.getElectiveEROD());
		this.electiveerodhistory = ims.RefMan.vo.ReferralERODVoCollection.buildFromBeanCollection(bean.getElectiveERODHistory());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.CatsReferralERODWithElectiveOnlyVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.CatsReferralERODWithElectiveOnlyVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.CatsReferralERODWithElectiveOnlyVoBean();
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
		if(fieldName.equals("JOURNEY"))
			return getJourney();
		if(fieldName.equals("ELECTIVEEROD"))
			return getElectiveEROD();
		if(fieldName.equals("ELECTIVEERODHISTORY"))
			return getElectiveERODHistory();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getJourneyIsNotNull()
	{
		return this.journey != null;
	}
	public ims.RefMan.vo.PatientPathwayJourneyForERODVo getJourney()
	{
		return this.journey;
	}
	public void setJourney(ims.RefMan.vo.PatientPathwayJourneyForERODVo value)
	{
		this.isValidated = false;
		this.journey = value;
	}
	public boolean getElectiveERODIsNotNull()
	{
		return this.electiveerod != null;
	}
	public ims.RefMan.vo.ReferralERODVoCollection getElectiveEROD()
	{
		return this.electiveerod;
	}
	public void setElectiveEROD(ims.RefMan.vo.ReferralERODVoCollection value)
	{
		this.isValidated = false;
		this.electiveerod = value;
	}
	public boolean getElectiveERODHistoryIsNotNull()
	{
		return this.electiveerodhistory != null;
	}
	public ims.RefMan.vo.ReferralERODVoCollection getElectiveERODHistory()
	{
		return this.electiveerodhistory;
	}
	public void setElectiveERODHistory(ims.RefMan.vo.ReferralERODVoCollection value)
	{
		this.isValidated = false;
		this.electiveerodhistory = value;
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
	
		CatsReferralERODWithElectiveOnlyVo clone = new CatsReferralERODWithElectiveOnlyVo(this.id, this.version);
		
		if(this.journey == null)
			clone.journey = null;
		else
			clone.journey = (ims.RefMan.vo.PatientPathwayJourneyForERODVo)this.journey.clone();
		if(this.electiveerod == null)
			clone.electiveerod = null;
		else
			clone.electiveerod = (ims.RefMan.vo.ReferralERODVoCollection)this.electiveerod.clone();
		if(this.electiveerodhistory == null)
			clone.electiveerodhistory = null;
		else
			clone.electiveerodhistory = (ims.RefMan.vo.ReferralERODVoCollection)this.electiveerodhistory.clone();
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
		if (!(CatsReferralERODWithElectiveOnlyVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CatsReferralERODWithElectiveOnlyVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((CatsReferralERODWithElectiveOnlyVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((CatsReferralERODWithElectiveOnlyVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.journey != null)
			count++;
		if(this.electiveerod != null)
			count++;
		if(this.electiveerodhistory != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.RefMan.vo.PatientPathwayJourneyForERODVo journey;
	protected ims.RefMan.vo.ReferralERODVoCollection electiveerod;
	protected ims.RefMan.vo.ReferralERODVoCollection electiveerodhistory;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
