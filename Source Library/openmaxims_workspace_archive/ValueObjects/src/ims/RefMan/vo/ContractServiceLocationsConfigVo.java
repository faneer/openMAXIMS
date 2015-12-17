// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo;

/**
 * Linked to core.configuration.ContractServiceLocationsConfig business object (ID: 1028100065).
 */
public class ContractServiceLocationsConfigVo extends ims.core.configuration.vo.ContractServiceLocationsConfigRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ContractServiceLocationsConfigVo()
	{
	}
	public ContractServiceLocationsConfigVo(Integer id, int version)
	{
		super(id, version);
	}
	public ContractServiceLocationsConfigVo(ims.RefMan.vo.beans.ContractServiceLocationsConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.service = bean.getService() == null ? null : bean.getService().buildVo();
		this.location = bean.getLocation() == null ? null : bean.getLocation().buildVo();
		this.contractid = bean.getContractId();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.ContractServiceLocationsConfigVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.service = bean.getService() == null ? null : bean.getService().buildVo(map);
		this.location = bean.getLocation() == null ? null : bean.getLocation().buildVo(map);
		this.contractid = bean.getContractId();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.ContractServiceLocationsConfigVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.ContractServiceLocationsConfigVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.ContractServiceLocationsConfigVoBean();
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
		if(fieldName.equals("SERVICE"))
			return getService();
		if(fieldName.equals("LOCATION"))
			return getLocation();
		if(fieldName.equals("CONTRACTID"))
			return getContractId();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getServiceIsNotNull()
	{
		return this.service != null;
	}
	public ims.admin.vo.ServiceVoLiteVo getService()
	{
		return this.service;
	}
	public void setService(ims.admin.vo.ServiceVoLiteVo value)
	{
		this.isValidated = false;
		this.service = value;
	}
	public boolean getLocationIsNotNull()
	{
		return this.location != null;
	}
	public ims.admin.vo.ConfigLocationLiteVo getLocation()
	{
		return this.location;
	}
	public void setLocation(ims.admin.vo.ConfigLocationLiteVo value)
	{
		this.isValidated = false;
		this.location = value;
	}
	public boolean getContractIdIsNotNull()
	{
		return this.contractid != null;
	}
	public String getContractId()
	{
		return this.contractid;
	}
	public static int getContractIdMaxLength()
	{
		return 25;
	}
	public void setContractId(String value)
	{
		this.isValidated = false;
		this.contractid = value;
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
		if(this.service == null)
			listOfErrors.add("Service is mandatory");
		if(this.location == null)
			listOfErrors.add("Location is mandatory");
		if(this.contractid == null || this.contractid.length() == 0)
			listOfErrors.add("ContractId is mandatory");
		else if(this.contractid.length() > 25)
			listOfErrors.add("The length of the field [contractid] in the value object [ims.RefMan.vo.ContractServiceLocationsConfigVo] is too big. It should be less or equal to 25");
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
	
		ContractServiceLocationsConfigVo clone = new ContractServiceLocationsConfigVo(this.id, this.version);
		
		if(this.service == null)
			clone.service = null;
		else
			clone.service = (ims.admin.vo.ServiceVoLiteVo)this.service.clone();
		if(this.location == null)
			clone.location = null;
		else
			clone.location = (ims.admin.vo.ConfigLocationLiteVo)this.location.clone();
		clone.contractid = this.contractid;
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
		if (!(ContractServiceLocationsConfigVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ContractServiceLocationsConfigVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ContractServiceLocationsConfigVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ContractServiceLocationsConfigVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.service != null)
			count++;
		if(this.location != null)
			count++;
		if(this.contractid != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.admin.vo.ServiceVoLiteVo service;
	protected ims.admin.vo.ConfigLocationLiteVo location;
	protected String contractid;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
