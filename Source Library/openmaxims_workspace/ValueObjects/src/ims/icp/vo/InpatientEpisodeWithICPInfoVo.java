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

package ims.icp.vo;

/**
 * Linked to core.admin.pas.Inpatient Episode business object (ID: 1014100000).
 */
public class InpatientEpisodeWithICPInfoVo extends ims.core.admin.pas.vo.InpatientEpisodeRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public InpatientEpisodeWithICPInfoVo()
	{
	}
	public InpatientEpisodeWithICPInfoVo(Integer id, int version)
	{
		super(id, version);
	}
	public InpatientEpisodeWithICPInfoVo(ims.icp.vo.beans.InpatientEpisodeWithICPInfoVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.pasevent = bean.getPasEvent() == null ? null : bean.getPasEvent().buildVo();
		this.admissiondatetime = bean.getAdmissionDateTime() == null ? null : bean.getAdmissionDateTime().buildDateTime();
		this.icpinfo = bean.getICPInfo() == null ? null : bean.getICPInfo().buildVo();
		this.bednumber = bean.getBedNumber();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.icp.vo.beans.InpatientEpisodeWithICPInfoVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.pasevent = bean.getPasEvent() == null ? null : bean.getPasEvent().buildVo(map);
		this.admissiondatetime = bean.getAdmissionDateTime() == null ? null : bean.getAdmissionDateTime().buildDateTime();
		this.icpinfo = bean.getICPInfo() == null ? null : bean.getICPInfo().buildVo(map);
		this.bednumber = bean.getBedNumber();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.icp.vo.beans.InpatientEpisodeWithICPInfoVoBean bean = null;
		if(map != null)
			bean = (ims.icp.vo.beans.InpatientEpisodeWithICPInfoVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.icp.vo.beans.InpatientEpisodeWithICPInfoVoBean();
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
		if(fieldName.equals("PASEVENT"))
			return getPasEvent();
		if(fieldName.equals("ADMISSIONDATETIME"))
			return getAdmissionDateTime();
		if(fieldName.equals("ICPINFO"))
			return getICPInfo();
		if(fieldName.equals("BEDNUMBER"))
			return getBedNumber();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPasEventIsNotNull()
	{
		return this.pasevent != null;
	}
	public ims.core.vo.PasEventShortVo getPasEvent()
	{
		return this.pasevent;
	}
	public void setPasEvent(ims.core.vo.PasEventShortVo value)
	{
		this.isValidated = false;
		this.pasevent = value;
	}
	public boolean getAdmissionDateTimeIsNotNull()
	{
		return this.admissiondatetime != null;
	}
	public ims.framework.utils.DateTime getAdmissionDateTime()
	{
		return this.admissiondatetime;
	}
	public void setAdmissionDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.admissiondatetime = value;
	}
	public boolean getICPInfoIsNotNull()
	{
		return this.icpinfo != null;
	}
	public ims.icp.vo.PatientICPLiteVo getICPInfo()
	{
		return this.icpinfo;
	}
	public void setICPInfo(ims.icp.vo.PatientICPLiteVo value)
	{
		this.isValidated = false;
		this.icpinfo = value;
	}
	public boolean getBedNumberIsNotNull()
	{
		return this.bednumber != null;
	}
	public String getBedNumber()
	{
		return this.bednumber;
	}
	public static int getBedNumberMaxLength()
	{
		return 10;
	}
	public void setBedNumber(String value)
	{
		this.isValidated = false;
		this.bednumber = value;
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.admin.vo.CareContextRefVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
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
		if(this.bednumber != null)
			if(this.bednumber.length() > 10)
				listOfErrors.add("The length of the field [bednumber] in the value object [ims.icp.vo.InpatientEpisodeWithICPInfoVo] is too big. It should be less or equal to 10");
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
	
		InpatientEpisodeWithICPInfoVo clone = new InpatientEpisodeWithICPInfoVo(this.id, this.version);
		
		if(this.pasevent == null)
			clone.pasevent = null;
		else
			clone.pasevent = (ims.core.vo.PasEventShortVo)this.pasevent.clone();
		if(this.admissiondatetime == null)
			clone.admissiondatetime = null;
		else
			clone.admissiondatetime = (ims.framework.utils.DateTime)this.admissiondatetime.clone();
		if(this.icpinfo == null)
			clone.icpinfo = null;
		else
			clone.icpinfo = (ims.icp.vo.PatientICPLiteVo)this.icpinfo.clone();
		clone.bednumber = this.bednumber;
		clone.carecontext = this.carecontext;
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
		if (!(InpatientEpisodeWithICPInfoVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A InpatientEpisodeWithICPInfoVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((InpatientEpisodeWithICPInfoVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((InpatientEpisodeWithICPInfoVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.pasevent != null)
			count++;
		if(this.admissiondatetime != null)
			count++;
		if(this.icpinfo != null)
			count++;
		if(this.bednumber != null)
			count++;
		if(this.carecontext != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.core.vo.PasEventShortVo pasevent;
	protected ims.framework.utils.DateTime admissiondatetime;
	protected ims.icp.vo.PatientICPLiteVo icpinfo;
	protected String bednumber;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
