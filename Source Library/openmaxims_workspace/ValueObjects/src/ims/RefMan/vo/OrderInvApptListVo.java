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
 * Linked to RefMan.OrderInvAppt business object (ID: 1096100009).
 */
public class OrderInvApptListVo extends ims.RefMan.vo.OrderInvApptRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public OrderInvApptListVo()
	{
	}
	public OrderInvApptListVo(Integer id, int version)
	{
		super(id, version);
	}
	public OrderInvApptListVo(ims.RefMan.vo.beans.OrderInvApptListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.orderinvestigation = bean.getOrderInvestigation() == null ? null : new ims.ocrr.orderingresults.vo.OrderInvestigationRefVo(new Integer(bean.getOrderInvestigation().getId()), bean.getOrderInvestigation().getVersion());
		this.appointment = bean.getAppointment() == null ? null : new ims.scheduling.vo.Booking_AppointmentRefVo(new Integer(bean.getAppointment().getId()), bean.getAppointment().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.OrderInvApptListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.orderinvestigation = bean.getOrderInvestigation() == null ? null : new ims.ocrr.orderingresults.vo.OrderInvestigationRefVo(new Integer(bean.getOrderInvestigation().getId()), bean.getOrderInvestigation().getVersion());
		this.appointment = bean.getAppointment() == null ? null : new ims.scheduling.vo.Booking_AppointmentRefVo(new Integer(bean.getAppointment().getId()), bean.getAppointment().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.OrderInvApptListVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.OrderInvApptListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.OrderInvApptListVoBean();
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
		if(fieldName.equals("ORDERINVESTIGATION"))
			return getOrderInvestigation();
		if(fieldName.equals("APPOINTMENT"))
			return getAppointment();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getOrderInvestigationIsNotNull()
	{
		return this.orderinvestigation != null;
	}
	public ims.ocrr.orderingresults.vo.OrderInvestigationRefVo getOrderInvestigation()
	{
		return this.orderinvestigation;
	}
	public void setOrderInvestigation(ims.ocrr.orderingresults.vo.OrderInvestigationRefVo value)
	{
		this.isValidated = false;
		this.orderinvestigation = value;
	}
	public boolean getAppointmentIsNotNull()
	{
		return this.appointment != null;
	}
	public ims.scheduling.vo.Booking_AppointmentRefVo getAppointment()
	{
		return this.appointment;
	}
	public void setAppointment(ims.scheduling.vo.Booking_AppointmentRefVo value)
	{
		this.isValidated = false;
		this.appointment = value;
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
	
		OrderInvApptListVo clone = new OrderInvApptListVo(this.id, this.version);
		
		clone.orderinvestigation = this.orderinvestigation;
		clone.appointment = this.appointment;
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
		if (!(OrderInvApptListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A OrderInvApptListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((OrderInvApptListVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((OrderInvApptListVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.orderinvestigation != null)
			count++;
		if(this.appointment != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 2;
	}
	protected ims.ocrr.orderingresults.vo.OrderInvestigationRefVo orderinvestigation;
	protected ims.scheduling.vo.Booking_AppointmentRefVo appointment;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
