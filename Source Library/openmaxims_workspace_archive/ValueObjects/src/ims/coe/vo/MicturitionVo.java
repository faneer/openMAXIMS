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

package ims.coe.vo;

/**
 * Linked to nursing.assessment.Bladder Micturition business object (ID: 1015100002).
 */
public class MicturitionVo extends ims.nursing.assessment.vo.BladderMicturitionRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public MicturitionVo()
	{
	}
	public MicturitionVo(Integer id, int version)
	{
		super(id, version);
	}
	public MicturitionVo(ims.coe.vo.beans.MicturitionVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.urinarydiversion = bean.getUrinaryDiversion() == null ? null : ims.nursing.vo.lookups.UrinaryDiversion.buildLookup(bean.getUrinaryDiversion());
		this.appliancesused = bean.getAppliancesUsed();
		this.bladdermanagement = ims.nursing.vo.BladderManagementCollection.buildFromBeanCollection(bean.getBladderManagement());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.coe.vo.beans.MicturitionVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.urinarydiversion = bean.getUrinaryDiversion() == null ? null : ims.nursing.vo.lookups.UrinaryDiversion.buildLookup(bean.getUrinaryDiversion());
		this.appliancesused = bean.getAppliancesUsed();
		this.bladdermanagement = ims.nursing.vo.BladderManagementCollection.buildFromBeanCollection(bean.getBladderManagement());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.coe.vo.beans.MicturitionVoBean bean = null;
		if(map != null)
			bean = (ims.coe.vo.beans.MicturitionVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.coe.vo.beans.MicturitionVoBean();
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
		if(fieldName.equals("URINARYDIVERSION"))
			return getUrinaryDiversion();
		if(fieldName.equals("APPLIANCESUSED"))
			return getAppliancesUsed();
		if(fieldName.equals("BLADDERMANAGEMENT"))
			return getBladderManagement();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getUrinaryDiversionIsNotNull()
	{
		return this.urinarydiversion != null;
	}
	public ims.nursing.vo.lookups.UrinaryDiversion getUrinaryDiversion()
	{
		return this.urinarydiversion;
	}
	public void setUrinaryDiversion(ims.nursing.vo.lookups.UrinaryDiversion value)
	{
		this.isValidated = false;
		this.urinarydiversion = value;
	}
	public boolean getAppliancesUsedIsNotNull()
	{
		return this.appliancesused != null;
	}
	public String getAppliancesUsed()
	{
		return this.appliancesused;
	}
	public static int getAppliancesUsedMaxLength()
	{
		return 255;
	}
	public void setAppliancesUsed(String value)
	{
		this.isValidated = false;
		this.appliancesused = value;
	}
	public boolean getBladderManagementIsNotNull()
	{
		return this.bladdermanagement != null;
	}
	public ims.nursing.vo.BladderManagementCollection getBladderManagement()
	{
		return this.bladdermanagement;
	}
	public void setBladderManagement(ims.nursing.vo.BladderManagementCollection value)
	{
		this.isValidated = false;
		this.bladdermanagement = value;
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
		if(this.bladdermanagement != null)
		{
			if(!this.bladdermanagement.isValidated())
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
		if(this.bladdermanagement != null)
		{
			String[] listOfOtherErrors = this.bladdermanagement.validate();
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
	
		MicturitionVo clone = new MicturitionVo(this.id, this.version);
		
		if(this.urinarydiversion == null)
			clone.urinarydiversion = null;
		else
			clone.urinarydiversion = (ims.nursing.vo.lookups.UrinaryDiversion)this.urinarydiversion.clone();
		clone.appliancesused = this.appliancesused;
		if(this.bladdermanagement == null)
			clone.bladdermanagement = null;
		else
			clone.bladdermanagement = (ims.nursing.vo.BladderManagementCollection)this.bladdermanagement.clone();
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
		if (!(MicturitionVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A MicturitionVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		MicturitionVo compareObj = (MicturitionVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getID_BladderMicturition() == null && compareObj.getID_BladderMicturition() != null)
				return -1;
			if(this.getID_BladderMicturition() != null && compareObj.getID_BladderMicturition() == null)
				return 1;
			if(this.getID_BladderMicturition() != null && compareObj.getID_BladderMicturition() != null)
				retVal = this.getID_BladderMicturition().compareTo(compareObj.getID_BladderMicturition());
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
		if(this.urinarydiversion != null)
			count++;
		if(this.appliancesused != null)
			count++;
		if(this.bladdermanagement != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.nursing.vo.lookups.UrinaryDiversion urinarydiversion;
	protected String appliancesused;
	protected ims.nursing.vo.BladderManagementCollection bladdermanagement;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
