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
 * Linked to core.TransportBooking business object (ID: 1090100004).
 */
public class TransportBookingLiteVo extends ims.core.vo.TransportBookingRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TransportBookingLiteVo()
	{
	}
	public TransportBookingLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public TransportBookingLiteVo(ims.RefMan.vo.beans.TransportBookingLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.datebooked = bean.getDateBooked() == null ? null : bean.getDateBooked().buildDate();
		this.bookingreference = bean.getBookingReference();
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.TransportBookingLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.datebooked = bean.getDateBooked() == null ? null : bean.getDateBooked().buildDate();
		this.bookingreference = bean.getBookingReference();
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.TransportBookingLiteVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.TransportBookingLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.TransportBookingLiteVoBean();
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
		if(fieldName.equals("DATEBOOKED"))
			return getDateBooked();
		if(fieldName.equals("BOOKINGREFERENCE"))
			return getBookingReference();
		if(fieldName.equals("SYSINFO"))
			return getSysInfo();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDateBookedIsNotNull()
	{
		return this.datebooked != null;
	}
	public ims.framework.utils.Date getDateBooked()
	{
		return this.datebooked;
	}
	public void setDateBooked(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.datebooked = value;
	}
	public boolean getBookingReferenceIsNotNull()
	{
		return this.bookingreference != null;
	}
	public String getBookingReference()
	{
		return this.bookingreference;
	}
	public static int getBookingReferenceMaxLength()
	{
		return 25;
	}
	public void setBookingReference(String value)
	{
		this.isValidated = false;
		this.bookingreference = value;
	}
	public boolean getSysInfoIsNotNull()
	{
		return this.sysinfo != null;
	}
	public ims.vo.SystemInformation getSysInfo()
	{
		return this.sysinfo;
	}
	public void setSysInfo(ims.vo.SystemInformation value)
	{
		this.isValidated = false;
		this.sysinfo = value;
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
		if(this.datebooked == null)
			listOfErrors.add("DateBooked is mandatory");
		if(this.bookingreference == null || this.bookingreference.length() == 0)
			listOfErrors.add("BookingReference is mandatory");
		else if(this.bookingreference.length() > 25)
			listOfErrors.add("The length of the field [bookingreference] in the value object [ims.RefMan.vo.TransportBookingLiteVo] is too big. It should be less or equal to 25");
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
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
	
		TransportBookingLiteVo clone = new TransportBookingLiteVo(this.id, this.version);
		
		if(this.datebooked == null)
			clone.datebooked = null;
		else
			clone.datebooked = (ims.framework.utils.Date)this.datebooked.clone();
		clone.bookingreference = this.bookingreference;
		if(this.sysinfo == null)
			clone.sysinfo = null;
		else
			clone.sysinfo = (ims.vo.SystemInformation)this.sysinfo.clone();
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
		if (!(TransportBookingLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TransportBookingLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TransportBookingLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TransportBookingLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.datebooked != null)
			count++;
		if(this.bookingreference != null)
			count++;
		if(this.sysinfo != null)
			count++;
		if(this.carecontext != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.framework.utils.Date datebooked;
	protected String bookingreference;
	protected ims.vo.SystemInformation sysinfo;
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
