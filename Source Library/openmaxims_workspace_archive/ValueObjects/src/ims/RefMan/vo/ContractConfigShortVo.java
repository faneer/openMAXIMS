// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo;

/**
 * Linked to core.configuration.ContractConfig business object (ID: 1096100047).
 */
public class ContractConfigShortVo extends ims.RefMan.vo.ContractConfigLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ContractConfigShortVo()
	{
	}
	public ContractConfigShortVo(Integer id, int version)
	{
		super(id, version);
	}
	public ContractConfigShortVo(ims.RefMan.vo.beans.ContractConfigShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.contractid = bean.getContractId();
		this.contractname = bean.getContractName();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getStatus());
		this.contractorganisation = bean.getContractOrganisation() == null ? null : bean.getContractOrganisation().buildVo();
		this.daystorttbreachdate = bean.getDaysToRTTBreachDate();
		this.contracttype = bean.getContractType() == null ? null : ims.core.vo.lookups.ReferralManagementContractType.buildLookup(bean.getContractType());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.ContractConfigShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.contractid = bean.getContractId();
		this.contractname = bean.getContractName();
		this.status = bean.getStatus() == null ? null : ims.core.vo.lookups.PreActiveActiveInactiveStatus.buildLookup(bean.getStatus());
		this.contractorganisation = bean.getContractOrganisation() == null ? null : bean.getContractOrganisation().buildVo(map);
		this.daystorttbreachdate = bean.getDaysToRTTBreachDate();
		this.contracttype = bean.getContractType() == null ? null : ims.core.vo.lookups.ReferralManagementContractType.buildLookup(bean.getContractType());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.ContractConfigShortVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.ContractConfigShortVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.ContractConfigShortVoBean();
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
		if(fieldName.equals("CONTRACTORGANISATION"))
			return getContractOrganisation();
		if(fieldName.equals("DAYSTORTTBREACHDATE"))
			return getDaysToRTTBreachDate();
		if(fieldName.equals("CONTRACTTYPE"))
			return getContractType();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getContractOrganisationIsNotNull()
	{
		return this.contractorganisation != null;
	}
	public ims.core.vo.OrganisationLiteVo getContractOrganisation()
	{
		return this.contractorganisation;
	}
	public void setContractOrganisation(ims.core.vo.OrganisationLiteVo value)
	{
		this.isValidated = false;
		this.contractorganisation = value;
	}
	public boolean getDaysToRTTBreachDateIsNotNull()
	{
		return this.daystorttbreachdate != null;
	}
	public Integer getDaysToRTTBreachDate()
	{
		return this.daystorttbreachdate;
	}
	public void setDaysToRTTBreachDate(Integer value)
	{
		this.isValidated = false;
		this.daystorttbreachdate = value;
	}
	public boolean getContractTypeIsNotNull()
	{
		return this.contracttype != null;
	}
	public ims.core.vo.lookups.ReferralManagementContractType getContractType()
	{
		return this.contracttype;
	}
	public void setContractType(ims.core.vo.lookups.ReferralManagementContractType value)
	{
		this.isValidated = false;
		this.contracttype = value;
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
		if(this.contractid == null || this.contractid.length() == 0)
			listOfErrors.add("ContractId is mandatory");
		else if(this.contractid.length() > 25)
			listOfErrors.add("The length of the field [contractid] in the value object [ims.RefMan.vo.ContractConfigShortVo] is too big. It should be less or equal to 25");
		if(this.contractname == null || this.contractname.length() == 0)
			listOfErrors.add("ContractName is mandatory");
		else if(this.contractname.length() > 255)
			listOfErrors.add("The length of the field [contractname] in the value object [ims.RefMan.vo.ContractConfigShortVo] is too big. It should be less or equal to 255");
		if(this.status == null)
			listOfErrors.add("Status is mandatory");
		if(this.contractorganisation == null)
			listOfErrors.add("ContractOrganisation is mandatory");
		if(this.daystorttbreachdate == null)
			listOfErrors.add("DaysToRTTBreachDate is mandatory");
		if(this.contracttype == null)
			listOfErrors.add("ContractType is mandatory");
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
	
		ContractConfigShortVo clone = new ContractConfigShortVo(this.id, this.version);
		
		clone.contractid = this.contractid;
		clone.contractname = this.contractname;
		if(this.status == null)
			clone.status = null;
		else
			clone.status = (ims.core.vo.lookups.PreActiveActiveInactiveStatus)this.status.clone();
		if(this.contractorganisation == null)
			clone.contractorganisation = null;
		else
			clone.contractorganisation = (ims.core.vo.OrganisationLiteVo)this.contractorganisation.clone();
		clone.daystorttbreachdate = this.daystorttbreachdate;
		if(this.contracttype == null)
			clone.contracttype = null;
		else
			clone.contracttype = (ims.core.vo.lookups.ReferralManagementContractType)this.contracttype.clone();
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
		if (!(ContractConfigShortVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ContractConfigShortVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ContractConfigShortVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ContractConfigShortVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.contractorganisation != null)
			count++;
		if(this.daystorttbreachdate != null)
			count++;
		if(this.contracttype != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 3;
	}
	protected ims.core.vo.OrganisationLiteVo contractorganisation;
	protected Integer daystorttbreachdate;
	protected ims.core.vo.lookups.ReferralManagementContractType contracttype;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
