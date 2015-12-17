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

package ims.icp.vo;

/**
 * Linked to ICPs.Configuration.ICPStage business object (ID: 1060100001).
 */
public class ICPStageViewVo extends ims.icps.configuration.vo.ICPStageRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ICPStageViewVo()
	{
	}
	public ICPStageViewVo(Integer id, int version)
	{
		super(id, version);
	}
	public ICPStageViewVo(ims.icp.vo.beans.ICPStageViewVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.sequence = bean.getSequence();
		this.helpurl = bean.getHelpURL();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.beans.ICPStageViewVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.sequence = bean.getSequence();
		this.helpurl = bean.getHelpURL();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.beans.ICPStageViewVoBean bean = null;
		if(map != null)
			bean = (ims.icp.vo.beans.ICPStageViewVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.icp.vo.beans.ICPStageViewVoBean();
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
		if(fieldName.equals("NAME"))
			return getName();
		if(fieldName.equals("SEQUENCE"))
			return getSequence();
		if(fieldName.equals("HELPURL"))
			return getHelpURL();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getNameIsNotNull()
	{
		return this.name != null;
	}
	public String getName()
	{
		return this.name;
	}
	public static int getNameMaxLength()
	{
		return 50;
	}
	public void setName(String value)
	{
		this.isValidated = false;
		this.name = value;
	}
	public boolean getSequenceIsNotNull()
	{
		return this.sequence != null;
	}
	public Integer getSequence()
	{
		return this.sequence;
	}
	public void setSequence(Integer value)
	{
		this.isValidated = false;
		this.sequence = value;
	}
	public boolean getHelpURLIsNotNull()
	{
		return this.helpurl != null;
	}
	public String getHelpURL()
	{
		return this.helpurl;
	}
	public static int getHelpURLMaxLength()
	{
		return 255;
	}
	public void setHelpURL(String value)
	{
		this.isValidated = false;
		this.helpurl = value;
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
		if(this.name == null || this.name.length() == 0)
			listOfErrors.add("Name is mandatory");
		else if(this.name.length() > 50)
			listOfErrors.add("The length of the field [name] in the value object [ims.icp.vo.ICPStageViewVo] is too big. It should be less or equal to 50");
		if(this.sequence == null)
			listOfErrors.add("Sequence is mandatory");
		if(this.helpurl != null)
			if(this.helpurl.length() > 255)
				listOfErrors.add("The length of the field [helpurl] in the value object [ims.icp.vo.ICPStageViewVo] is too big. It should be less or equal to 255");
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
	
		ICPStageViewVo clone = new ICPStageViewVo(this.id, this.version);
		
		clone.name = this.name;
		clone.sequence = this.sequence;
		clone.helpurl = this.helpurl;
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
		if (!(ICPStageViewVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ICPStageViewVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ICPStageViewVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ICPStageViewVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.name != null)
			count++;
		if(this.sequence != null)
			count++;
		if(this.helpurl != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected String name;
	protected Integer sequence;
	protected String helpurl;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
