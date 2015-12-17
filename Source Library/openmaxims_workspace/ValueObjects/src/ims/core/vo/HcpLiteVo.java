//#############################################################################
//#                                                                           #
//#  Copyright (C) <2015>  <IMS MAXIMS>                                       #
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
//#  IMS MAXIMS provides absolutely NO GUARANTEE OF THE CLINICAL SAFTEY of    #
//#  this program.  Users of this software do so entirely at their own risk.  #
//#  IMS MAXIMS only ensures the Clinical Safety of unaltered run-time        #
//#  software that it builds, deploys and maintains.                          #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.core.vo;

/**
 * Linked to core.resource.people.Hcp business object (ID: 1006100000).
 */
public class HcpLiteVo extends ims.core.resource.people.vo.HcpRefVo implements ims.vo.ImsCloneable, Comparable, ims.vo.interfaces.IHcp, ims.vo.interfaces.IMos
{
	private static final long serialVersionUID = 1L;

	public HcpLiteVo()
	{
	}
	public HcpLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public HcpLiteVo(ims.core.vo.beans.HcpLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.mos = bean.getMos() == null ? null : bean.getMos().buildVo();
		this.hcptype = bean.getHcpType() == null ? null : ims.core.vo.lookups.HcpDisType.buildLookup(bean.getHcpType());
		this.isactive = bean.getIsActive();
		this.ishcparesponsiblehcp = bean.getIsHCPaResponsibleHCP();
		this.isaresponsibleedclinician = bean.getIsAResponsibleEDClinician();
		this.ishcpaendoscopist = bean.getIsHCPaEndoscopist();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.HcpLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.mos = bean.getMos() == null ? null : bean.getMos().buildVo(map);
		this.hcptype = bean.getHcpType() == null ? null : ims.core.vo.lookups.HcpDisType.buildLookup(bean.getHcpType());
		this.isactive = bean.getIsActive();
		this.ishcparesponsiblehcp = bean.getIsHCPaResponsibleHCP();
		this.isaresponsibleedclinician = bean.getIsAResponsibleEDClinician();
		this.ishcpaendoscopist = bean.getIsHCPaEndoscopist();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.HcpLiteVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.HcpLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.HcpLiteVoBean();
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
		if(fieldName.equals("MOS"))
			return getMos();
		if(fieldName.equals("HCPTYPE"))
			return getHcpType();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("ISHCPARESPONSIBLEHCP"))
			return getIsHCPaResponsibleHCP();
		if(fieldName.equals("ISARESPONSIBLEEDCLINICIAN"))
			return getIsAResponsibleEDClinician();
		if(fieldName.equals("ISHCPAENDOSCOPIST"))
			return getIsHCPaEndoscopist();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getMosIsNotNull()
	{
		return this.mos != null;
	}
	public ims.core.vo.MemberOfStaffLiteVo getMos()
	{
		return this.mos;
	}
	public void setMos(ims.core.vo.MemberOfStaffLiteVo value)
	{
		this.isValidated = false;
		this.mos = value;
	}
	public boolean getHcpTypeIsNotNull()
	{
		return this.hcptype != null;
	}
	public ims.core.vo.lookups.HcpDisType getHcpType()
	{
		return this.hcptype;
	}
	public void setHcpType(ims.core.vo.lookups.HcpDisType value)
	{
		this.isValidated = false;
		this.hcptype = value;
	}
	public boolean getIsActiveIsNotNull()
	{
		return this.isactive != null;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isValidated = false;
		this.isactive = value;
	}
	public boolean getIsHCPaResponsibleHCPIsNotNull()
	{
		return this.ishcparesponsiblehcp != null;
	}
	public Boolean getIsHCPaResponsibleHCP()
	{
		return this.ishcparesponsiblehcp;
	}
	public void setIsHCPaResponsibleHCP(Boolean value)
	{
		this.isValidated = false;
		this.ishcparesponsiblehcp = value;
	}
	public boolean getIsAResponsibleEDClinicianIsNotNull()
	{
		return this.isaresponsibleedclinician != null;
	}
	public Boolean getIsAResponsibleEDClinician()
	{
		return this.isaresponsibleedclinician;
	}
	public void setIsAResponsibleEDClinician(Boolean value)
	{
		this.isValidated = false;
		this.isaresponsibleedclinician = value;
	}
	public boolean getIsHCPaEndoscopistIsNotNull()
	{
		return this.ishcpaendoscopist != null;
	}
	public Boolean getIsHCPaEndoscopist()
	{
		return this.ishcpaendoscopist;
	}
	public void setIsHCPaEndoscopist(Boolean value)
	{
		this.isValidated = false;
		this.ishcpaendoscopist = value;
	}
	/**
	* toString()
	*/
	public String toString()
	{
		if (this.mos != null && this.mos.getName() != null)
		{
			return this.mos.getName().toString();
		}
		else
		{
			return super.toString();
		}
	}
	/**
	* getName
	*/
	public ims.core.vo.PersonName getName()
	{
		if (mos == null) return null;
		else return mos.getName();
	}
	/**
	* IHcp interface methods
	*/
	public Integer getIHcpId()
	{
		return this.id;
	}
	public String getIHcpName()
	{
		ims.core.vo.PersonName name = getName();
		if(name != null)
			return name.toString();
			
		return null;
	}
	/**
	* IMos interface methods
	*/
	public Integer getIMosId()
	{
		if(mos!= null)
			return mos.getID_MemberOfStaff();
	
		return null;
	}
	
	public String getIMosName()
	{
		ims.core.vo.PersonName name = getName();
		if(name != null)
			return name.toString();
			
		return null;
	}
	public Integer getIMosHcpId()
	{
		return this.id;
	}
	/**
	* toMedicLite() - will return null if the HCP is not of type Medic
	*/
	public ims.core.vo.MedicLiteVo toMedicLite()
	{
		if (ims.core.vo.lookups.HcpDisType.MEDICAL.equals(this.hcptype))
		{
			ims.core.vo.MedicLiteVo medic = new ims.core.vo.MedicLiteVo(this.id, this.version);
			medic.setIsActive(this.isactive);
			medic.setIsAResponsibleEDClinician(this.isaresponsibleedclinician);
			medic.setIsHCPaResponsibleHCP(this.ishcparesponsiblehcp);
			medic.setMos(this.mos);
				
			return medic;
		}
	
		return null;
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
	
		HcpLiteVo clone = new HcpLiteVo(this.id, this.version);
		
		if(this.mos == null)
			clone.mos = null;
		else
			clone.mos = (ims.core.vo.MemberOfStaffLiteVo)this.mos.clone();
		if(this.hcptype == null)
			clone.hcptype = null;
		else
			clone.hcptype = (ims.core.vo.lookups.HcpDisType)this.hcptype.clone();
		clone.isactive = this.isactive;
		clone.ishcparesponsiblehcp = this.ishcparesponsiblehcp;
		clone.isaresponsibleedclinician = this.isaresponsibleedclinician;
		clone.ishcpaendoscopist = this.ishcpaendoscopist;
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
		if (!(HcpLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A HcpLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		HcpLiteVo compareObj = (HcpLiteVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getMos() == null && compareObj.getMos() != null)
				return -1;
			if(this.getMos() != null && compareObj.getMos() == null)
				return 1;
			if(this.getMos() != null && compareObj.getMos() != null)
				retVal = this.getMos().compareTo(compareObj.getMos());
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
		if(this.mos != null)
			count++;
		if(this.hcptype != null)
			count++;
		if(this.isactive != null)
			count++;
		if(this.ishcparesponsiblehcp != null)
			count++;
		if(this.isaresponsibleedclinician != null)
			count++;
		if(this.ishcpaendoscopist != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected ims.core.vo.MemberOfStaffLiteVo mos;
	protected ims.core.vo.lookups.HcpDisType hcptype;
	protected Boolean isactive;
	protected Boolean ishcparesponsiblehcp;
	protected Boolean isaresponsibleedclinician;
	protected Boolean ishcpaendoscopist;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
