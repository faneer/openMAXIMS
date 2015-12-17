// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo;

/**
 * Linked to RefMan.AwaitingClinicalInfo business object (ID: 1096100044).
 */
public class AwaitingClinicalInfoVo extends ims.RefMan.vo.AwaitingClinicalInfoRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AwaitingClinicalInfoVo()
	{
	}
	public AwaitingClinicalInfoVo(Integer id, int version)
	{
		super(id, version);
	}
	public AwaitingClinicalInfoVo(ims.RefMan.vo.beans.AwaitingClinicalInfoVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicalinfoawaiting = ims.RefMan.vo.lookups.AwaitingClinicalInformationTypeCollection.buildFromBeanCollection(bean.getClinicalInfoAwaiting());
		this.otherclinicalinformation = bean.getOtherClinicalInformation();
		this.clinicalinforeceived = ims.RefMan.vo.lookups.AwaitingClinicalInformationTypeCollection.buildFromBeanCollection(bean.getClinicalInfoReceived());
		this.dateawaitingclinicalinfo = bean.getDateAwaitingClinicalInfo() == null ? null : bean.getDateAwaitingClinicalInfo().buildDateTime();
		this.dateclinicalinforeceived = bean.getDateClinicalInfoReceived() == null ? null : bean.getDateClinicalInfoReceived().buildDateTime();
		this.proceedwithtriage = bean.getProceedWithTriage();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.AwaitingClinicalInfoVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicalinfoawaiting = ims.RefMan.vo.lookups.AwaitingClinicalInformationTypeCollection.buildFromBeanCollection(bean.getClinicalInfoAwaiting());
		this.otherclinicalinformation = bean.getOtherClinicalInformation();
		this.clinicalinforeceived = ims.RefMan.vo.lookups.AwaitingClinicalInformationTypeCollection.buildFromBeanCollection(bean.getClinicalInfoReceived());
		this.dateawaitingclinicalinfo = bean.getDateAwaitingClinicalInfo() == null ? null : bean.getDateAwaitingClinicalInfo().buildDateTime();
		this.dateclinicalinforeceived = bean.getDateClinicalInfoReceived() == null ? null : bean.getDateClinicalInfoReceived().buildDateTime();
		this.proceedwithtriage = bean.getProceedWithTriage();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.AwaitingClinicalInfoVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.AwaitingClinicalInfoVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.AwaitingClinicalInfoVoBean();
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
		if(fieldName.equals("CLINICALINFOAWAITING"))
			return getClinicalInfoAwaiting();
		if(fieldName.equals("OTHERCLINICALINFORMATION"))
			return getOtherClinicalInformation();
		if(fieldName.equals("CLINICALINFORECEIVED"))
			return getClinicalInfoReceived();
		if(fieldName.equals("DATEAWAITINGCLINICALINFO"))
			return getDateAwaitingClinicalInfo();
		if(fieldName.equals("DATECLINICALINFORECEIVED"))
			return getDateClinicalInfoReceived();
		if(fieldName.equals("PROCEEDWITHTRIAGE"))
			return getProceedWithTriage();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getClinicalInfoAwaitingIsNotNull()
	{
		return this.clinicalinfoawaiting != null;
	}
	public ims.RefMan.vo.lookups.AwaitingClinicalInformationTypeCollection getClinicalInfoAwaiting()
	{
		return this.clinicalinfoawaiting;
	}
	public void setClinicalInfoAwaiting(ims.RefMan.vo.lookups.AwaitingClinicalInformationTypeCollection value)
	{
		this.isValidated = false;
		this.clinicalinfoawaiting = value;
	}
	public boolean getOtherClinicalInformationIsNotNull()
	{
		return this.otherclinicalinformation != null;
	}
	public String getOtherClinicalInformation()
	{
		return this.otherclinicalinformation;
	}
	public static int getOtherClinicalInformationMaxLength()
	{
		return 1500;
	}
	public void setOtherClinicalInformation(String value)
	{
		this.isValidated = false;
		this.otherclinicalinformation = value;
	}
	public boolean getClinicalInfoReceivedIsNotNull()
	{
		return this.clinicalinforeceived != null;
	}
	public ims.RefMan.vo.lookups.AwaitingClinicalInformationTypeCollection getClinicalInfoReceived()
	{
		return this.clinicalinforeceived;
	}
	public void setClinicalInfoReceived(ims.RefMan.vo.lookups.AwaitingClinicalInformationTypeCollection value)
	{
		this.isValidated = false;
		this.clinicalinforeceived = value;
	}
	public boolean getDateAwaitingClinicalInfoIsNotNull()
	{
		return this.dateawaitingclinicalinfo != null;
	}
	public ims.framework.utils.DateTime getDateAwaitingClinicalInfo()
	{
		return this.dateawaitingclinicalinfo;
	}
	public void setDateAwaitingClinicalInfo(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.dateawaitingclinicalinfo = value;
	}
	public boolean getDateClinicalInfoReceivedIsNotNull()
	{
		return this.dateclinicalinforeceived != null;
	}
	public ims.framework.utils.DateTime getDateClinicalInfoReceived()
	{
		return this.dateclinicalinforeceived;
	}
	public void setDateClinicalInfoReceived(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.dateclinicalinforeceived = value;
	}
	public boolean getProceedWithTriageIsNotNull()
	{
		return this.proceedwithtriage != null;
	}
	public Boolean getProceedWithTriage()
	{
		return this.proceedwithtriage;
	}
	public void setProceedWithTriage(Boolean value)
	{
		this.isValidated = false;
		this.proceedwithtriage = value;
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
		if(this.otherclinicalinformation != null)
			if(this.otherclinicalinformation.length() > 1500)
				listOfErrors.add("The length of the field [otherclinicalinformation] in the value object [ims.RefMan.vo.AwaitingClinicalInfoVo] is too big. It should be less or equal to 1500");
		if(this.dateawaitingclinicalinfo == null)
			listOfErrors.add("Awaiting Clinical Information date is mandatory");
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
	
		AwaitingClinicalInfoVo clone = new AwaitingClinicalInfoVo(this.id, this.version);
		
		if(this.clinicalinfoawaiting == null)
			clone.clinicalinfoawaiting = null;
		else
			clone.clinicalinfoawaiting = (ims.RefMan.vo.lookups.AwaitingClinicalInformationTypeCollection)this.clinicalinfoawaiting.clone();
		clone.otherclinicalinformation = this.otherclinicalinformation;
		if(this.clinicalinforeceived == null)
			clone.clinicalinforeceived = null;
		else
			clone.clinicalinforeceived = (ims.RefMan.vo.lookups.AwaitingClinicalInformationTypeCollection)this.clinicalinforeceived.clone();
		if(this.dateawaitingclinicalinfo == null)
			clone.dateawaitingclinicalinfo = null;
		else
			clone.dateawaitingclinicalinfo = (ims.framework.utils.DateTime)this.dateawaitingclinicalinfo.clone();
		if(this.dateclinicalinforeceived == null)
			clone.dateclinicalinforeceived = null;
		else
			clone.dateclinicalinforeceived = (ims.framework.utils.DateTime)this.dateclinicalinforeceived.clone();
		clone.proceedwithtriage = this.proceedwithtriage;
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
		if (!(AwaitingClinicalInfoVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AwaitingClinicalInfoVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((AwaitingClinicalInfoVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((AwaitingClinicalInfoVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.clinicalinfoawaiting != null)
			count++;
		if(this.otherclinicalinformation != null)
			count++;
		if(this.clinicalinforeceived != null)
			count++;
		if(this.dateawaitingclinicalinfo != null)
			count++;
		if(this.dateclinicalinforeceived != null)
			count++;
		if(this.proceedwithtriage != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.RefMan.vo.lookups.AwaitingClinicalInformationTypeCollection clinicalinfoawaiting;
	protected String otherclinicalinformation;
	protected ims.RefMan.vo.lookups.AwaitingClinicalInformationTypeCollection clinicalinforeceived;
	protected ims.framework.utils.DateTime dateawaitingclinicalinfo;
	protected ims.framework.utils.DateTime dateclinicalinforeceived;
	protected Boolean proceedwithtriage;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
