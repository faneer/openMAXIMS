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

package ims.RefMan.vo;

/**
 * Linked to clinical.AwaitingHistology business object (ID: 1072100116).
 */
public class AwaitingHistologyForPatientCodingListVo extends ims.clinical.vo.AwaitingHistologyRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AwaitingHistologyForPatientCodingListVo()
	{
	}
	public AwaitingHistologyForPatientCodingListVo(Integer id, int version)
	{
		super(id, version);
	}
	public AwaitingHistologyForPatientCodingListVo(ims.RefMan.vo.beans.AwaitingHistologyForPatientCodingListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.authoringmos = bean.getAuthoringMOS() == null ? null : new ims.core.resource.people.vo.MemberOfStaffRefVo(new Integer(bean.getAuthoringMOS().getId()), bean.getAuthoringMOS().getVersion());
		this.awaitinghistology = bean.getAwaitingHistology();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.AwaitingHistologyForPatientCodingListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.authoringmos = bean.getAuthoringMOS() == null ? null : new ims.core.resource.people.vo.MemberOfStaffRefVo(new Integer(bean.getAuthoringMOS().getId()), bean.getAuthoringMOS().getVersion());
		this.awaitinghistology = bean.getAwaitingHistology();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.AwaitingHistologyForPatientCodingListVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.AwaitingHistologyForPatientCodingListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.AwaitingHistologyForPatientCodingListVoBean();
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
		if(fieldName.equals("AUTHORINGDATETIME"))
			return getAuthoringDateTime();
		if(fieldName.equals("AUTHORINGMOS"))
			return getAuthoringMOS();
		if(fieldName.equals("AWAITINGHISTOLOGY"))
			return getAwaitingHistology();
		return super.getFieldValueByFieldName(fieldName);
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
	public boolean getAuthoringMOSIsNotNull()
	{
		return this.authoringmos != null;
	}
	public ims.core.resource.people.vo.MemberOfStaffRefVo getAuthoringMOS()
	{
		return this.authoringmos;
	}
	public void setAuthoringMOS(ims.core.resource.people.vo.MemberOfStaffRefVo value)
	{
		this.isValidated = false;
		this.authoringmos = value;
	}
	public boolean getAwaitingHistologyIsNotNull()
	{
		return this.awaitinghistology != null;
	}
	public Boolean getAwaitingHistology()
	{
		return this.awaitinghistology;
	}
	public void setAwaitingHistology(Boolean value)
	{
		this.isValidated = false;
		this.awaitinghistology = value;
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
		if(this.authoringdatetime == null)
			listOfErrors.add("AuthoringDateTime is mandatory");
		if(this.authoringmos == null)
			listOfErrors.add("AuthoringMOS is mandatory");
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
	
		AwaitingHistologyForPatientCodingListVo clone = new AwaitingHistologyForPatientCodingListVo(this.id, this.version);
		
		if(this.authoringdatetime == null)
			clone.authoringdatetime = null;
		else
			clone.authoringdatetime = (ims.framework.utils.DateTime)this.authoringdatetime.clone();
		clone.authoringmos = this.authoringmos;
		clone.awaitinghistology = this.awaitinghistology;
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
		if (!(AwaitingHistologyForPatientCodingListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AwaitingHistologyForPatientCodingListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((AwaitingHistologyForPatientCodingListVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((AwaitingHistologyForPatientCodingListVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.authoringdatetime != null)
			count++;
		if(this.authoringmos != null)
			count++;
		if(this.awaitinghistology != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 3;
	}
	protected ims.framework.utils.DateTime authoringdatetime;
	protected ims.core.resource.people.vo.MemberOfStaffRefVo authoringmos;
	protected Boolean awaitinghistology;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
