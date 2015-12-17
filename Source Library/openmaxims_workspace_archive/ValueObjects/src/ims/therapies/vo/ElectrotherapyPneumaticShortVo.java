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

package ims.therapies.vo;

/**
 * Linked to therapies.treatment.ElectrotherapyPneumatic business object (ID: 1044100008).
 */
public class ElectrotherapyPneumaticShortVo extends ims.therapies.treatment.vo.ElectrotherapyPneumaticRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ElectrotherapyPneumaticShortVo()
	{
	}
	public ElectrotherapyPneumaticShortVo(Integer id, int version)
	{
		super(id, version);
	}
	public ElectrotherapyPneumaticShortVo(ims.therapies.vo.beans.ElectrotherapyPneumaticShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo();
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.authoringcp = bean.getAuthoringCP() == null ? null : bean.getAuthoringCP().buildVo();
		this.warninggiven = bean.getWarningGiven() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getWarningGiven());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.beans.ElectrotherapyPneumaticShortVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo(map);
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.authoringcp = bean.getAuthoringCP() == null ? null : bean.getAuthoringCP().buildVo(map);
		this.warninggiven = bean.getWarningGiven() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getWarningGiven());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.beans.ElectrotherapyPneumaticShortVoBean bean = null;
		if(map != null)
			bean = (ims.therapies.vo.beans.ElectrotherapyPneumaticShortVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.therapies.vo.beans.ElectrotherapyPneumaticShortVoBean();
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
		if(fieldName.equals("CLINICALCONTACT"))
			return getClinicalContact();
		if(fieldName.equals("AUTHORINGDATETIME"))
			return getAuthoringDateTime();
		if(fieldName.equals("AUTHORINGCP"))
			return getAuthoringCP();
		if(fieldName.equals("WARNINGGIVEN"))
			return getWarningGiven();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getClinicalContactIsNotNull()
	{
		return this.clinicalcontact != null;
	}
	public ims.core.vo.ClinicalContactShortVo getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.vo.ClinicalContactShortVo value)
	{
		this.isValidated = false;
		this.clinicalcontact = value;
	}
	public boolean getAuthoringDateTimeIsNotNull()
	{
		return this.authoringdatetime != null;
	}
	public ims.framework.utils.DateTime getAuthoringDateTime()
	{
		return this.authoringdatetime;
	}
	public void setAuthoringDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.authoringdatetime = value;
	}
	public boolean getAuthoringCPIsNotNull()
	{
		return this.authoringcp != null;
	}
	public ims.core.vo.Hcp getAuthoringCP()
	{
		return this.authoringcp;
	}
	public void setAuthoringCP(ims.core.vo.Hcp value)
	{
		this.isValidated = false;
		this.authoringcp = value;
	}
	public boolean getWarningGivenIsNotNull()
	{
		return this.warninggiven != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getWarningGiven()
	{
		return this.warninggiven;
	}
	public void setWarningGiven(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.warninggiven = value;
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
		if(this.authoringcp != null)
		{
			if(!this.authoringcp.isValidated())
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
		if(this.clinicalcontact == null)
			listOfErrors.add("ClinicalContact is mandatory");
		if(this.authoringdatetime == null)
			listOfErrors.add("AuthoringDateTime is mandatory");
		if(this.authoringcp == null)
			listOfErrors.add("AuthoringCP is mandatory");
		if(this.authoringcp != null)
		{
			String[] listOfOtherErrors = this.authoringcp.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.warninggiven == null)
			listOfErrors.add("WarningGiven is mandatory");
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
	
		ElectrotherapyPneumaticShortVo clone = new ElectrotherapyPneumaticShortVo(this.id, this.version);
		
		if(this.clinicalcontact == null)
			clone.clinicalcontact = null;
		else
			clone.clinicalcontact = (ims.core.vo.ClinicalContactShortVo)this.clinicalcontact.clone();
		if(this.authoringdatetime == null)
			clone.authoringdatetime = null;
		else
			clone.authoringdatetime = (ims.framework.utils.DateTime)this.authoringdatetime.clone();
		if(this.authoringcp == null)
			clone.authoringcp = null;
		else
			clone.authoringcp = (ims.core.vo.Hcp)this.authoringcp.clone();
		if(this.warninggiven == null)
			clone.warninggiven = null;
		else
			clone.warninggiven = (ims.core.vo.lookups.YesNoUnknown)this.warninggiven.clone();
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
		if (!(ElectrotherapyPneumaticShortVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ElectrotherapyPneumaticShortVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		ElectrotherapyPneumaticShortVo compareObj = (ElectrotherapyPneumaticShortVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_ElectrotherapyPneumatic() == null && compareObj.getID_ElectrotherapyPneumatic() != null)
				return -1;
			if(this.getID_ElectrotherapyPneumatic() != null && compareObj.getID_ElectrotherapyPneumatic() == null)
				return 1;
			if(this.getID_ElectrotherapyPneumatic() != null && compareObj.getID_ElectrotherapyPneumatic() != null)
				retVal = this.getID_ElectrotherapyPneumatic().compareTo(compareObj.getID_ElectrotherapyPneumatic());
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
		if(this.clinicalcontact != null)
			count++;
		if(this.authoringdatetime != null)
			count++;
		if(this.authoringcp != null)
			count++;
		if(this.warninggiven != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.core.vo.ClinicalContactShortVo clinicalcontact;
	protected ims.framework.utils.DateTime authoringdatetime;
	protected ims.core.vo.Hcp authoringcp;
	protected ims.core.vo.lookups.YesNoUnknown warninggiven;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
