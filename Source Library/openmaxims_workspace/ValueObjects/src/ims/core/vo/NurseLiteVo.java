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
 * Linked to core.resource.people.Nurse business object (ID: 1006100007).
 */
public class NurseLiteVo extends ims.core.resource.people.vo.NurseRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public NurseLiteVo()
	{
	}
	public NurseLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public NurseLiteVo(ims.core.vo.beans.NurseLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.mos = bean.getMos() == null ? null : bean.getMos().buildVo();
		this.isactive = bean.getIsActive();
		this.ishcparesponsiblehcp = bean.getIsHCPaResponsibleHCP();
		this.isalocalconsultant = bean.getIsALocalConsultant();
		this.isaresponsibleedclinician = bean.getIsAResponsibleEDClinician();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.NurseLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.mos = bean.getMos() == null ? null : bean.getMos().buildVo(map);
		this.isactive = bean.getIsActive();
		this.ishcparesponsiblehcp = bean.getIsHCPaResponsibleHCP();
		this.isalocalconsultant = bean.getIsALocalConsultant();
		this.isaresponsibleedclinician = bean.getIsAResponsibleEDClinician();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.NurseLiteVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.NurseLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.NurseLiteVoBean();
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
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("ISHCPARESPONSIBLEHCP"))
			return getIsHCPaResponsibleHCP();
		if(fieldName.equals("ISALOCALCONSULTANT"))
			return getIsALocalConsultant();
		if(fieldName.equals("ISARESPONSIBLEEDCLINICIAN"))
			return getIsAResponsibleEDClinician();
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
	public boolean getIsALocalConsultantIsNotNull()
	{
		return this.isalocalconsultant != null;
	}
	public Boolean getIsALocalConsultant()
	{
		return this.isalocalconsultant;
	}
	public void setIsALocalConsultant(Boolean value)
	{
		this.isValidated = false;
		this.isalocalconsultant = value;
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
		if(this.mos != null)
		{
			if(!this.mos.isValidated())
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
		if(this.mos != null)
		{
			String[] listOfOtherErrors = this.mos.validate();
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
	
		NurseLiteVo clone = new NurseLiteVo(this.id, this.version);
		
		if(this.mos == null)
			clone.mos = null;
		else
			clone.mos = (ims.core.vo.MemberOfStaffLiteVo)this.mos.clone();
		clone.isactive = this.isactive;
		clone.ishcparesponsiblehcp = this.ishcparesponsiblehcp;
		clone.isalocalconsultant = this.isalocalconsultant;
		clone.isaresponsibleedclinician = this.isaresponsibleedclinician;
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
		if (!(NurseLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A NurseLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((NurseLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((NurseLiteVo)obj).getBoId());
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
		if(this.isactive != null)
			count++;
		if(this.ishcparesponsiblehcp != null)
			count++;
		if(this.isalocalconsultant != null)
			count++;
		if(this.isaresponsibleedclinician != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.core.vo.MemberOfStaffLiteVo mos;
	protected Boolean isactive;
	protected Boolean ishcparesponsiblehcp;
	protected Boolean isalocalconsultant;
	protected Boolean isaresponsibleedclinician;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
