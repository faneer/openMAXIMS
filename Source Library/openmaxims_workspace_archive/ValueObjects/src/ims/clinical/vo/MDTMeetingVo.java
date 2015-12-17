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

package ims.clinical.vo;

/**
 * Linked to clinical.MDTMeeting business object (ID: 1072100024).
 */
public class MDTMeetingVo extends ims.clinical.vo.MDTMeetingLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public MDTMeetingVo()
	{
	}
	public MDTMeetingVo(Integer id, int version)
	{
		super(id, version);
	}
	public MDTMeetingVo(ims.clinical.vo.beans.MDTMeetingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.mdtmeetingdate = bean.getMDTMeetingDate() == null ? null : bean.getMDTMeetingDate().buildDate();
		this.meetingnotes = ims.clinical.vo.MDTNotesVoCollection.buildFromBeanCollection(bean.getMeetingNotes());
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo();
		this.listpatientison = bean.getListPatientisOn() == null ? null : ims.clinical.vo.lookups.MDTListAorB.buildLookup(bean.getListPatientisOn());
		this.keydates = ims.clinical.vo.KeyDatesVoCollection.buildFromBeanCollection(bean.getKeyDates());
		this.systeminformation = bean.getSystemInformation() == null ? null : bean.getSystemInformation().buildSystemInformation();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.MDTMeetingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.mdtmeetingdate = bean.getMDTMeetingDate() == null ? null : bean.getMDTMeetingDate().buildDate();
		this.meetingnotes = ims.clinical.vo.MDTNotesVoCollection.buildFromBeanCollection(bean.getMeetingNotes());
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo(map);
		this.listpatientison = bean.getListPatientisOn() == null ? null : ims.clinical.vo.lookups.MDTListAorB.buildLookup(bean.getListPatientisOn());
		this.keydates = ims.clinical.vo.KeyDatesVoCollection.buildFromBeanCollection(bean.getKeyDates());
		this.systeminformation = bean.getSystemInformation() == null ? null : bean.getSystemInformation().buildSystemInformation();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.MDTMeetingVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.MDTMeetingVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.MDTMeetingVoBean();
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
		if(fieldName.equals("MEETINGNOTES"))
			return getMeetingNotes();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("LISTPATIENTISON"))
			return getListPatientisOn();
		if(fieldName.equals("KEYDATES"))
			return getKeyDates();
		if(fieldName.equals("SYSTEMINFORMATION"))
			return getSystemInformation();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getMeetingNotesIsNotNull()
	{
		return this.meetingnotes != null;
	}
	public ims.clinical.vo.MDTNotesVoCollection getMeetingNotes()
	{
		return this.meetingnotes;
	}
	public void setMeetingNotes(ims.clinical.vo.MDTNotesVoCollection value)
	{
		this.isValidated = false;
		this.meetingnotes = value;
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.vo.CareContextShortVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.vo.CareContextShortVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
	}
	public boolean getListPatientisOnIsNotNull()
	{
		return this.listpatientison != null;
	}
	public ims.clinical.vo.lookups.MDTListAorB getListPatientisOn()
	{
		return this.listpatientison;
	}
	public void setListPatientisOn(ims.clinical.vo.lookups.MDTListAorB value)
	{
		this.isValidated = false;
		this.listpatientison = value;
	}
	public boolean getKeyDatesIsNotNull()
	{
		return this.keydates != null;
	}
	public ims.clinical.vo.KeyDatesVoCollection getKeyDates()
	{
		return this.keydates;
	}
	public void setKeyDates(ims.clinical.vo.KeyDatesVoCollection value)
	{
		this.isValidated = false;
		this.keydates = value;
	}
	public boolean getSystemInformationIsNotNull()
	{
		return this.systeminformation != null;
	}
	public ims.vo.SystemInformation getSystemInformation()
	{
		return this.systeminformation;
	}
	public void setSystemInformation(ims.vo.SystemInformation value)
	{
		this.isValidated = false;
		this.systeminformation = value;
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
		if(this.meetingnotes != null)
		{
			if(!this.meetingnotes.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.keydates != null)
		{
			if(!this.keydates.isValidated())
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
		if(this.mdtmeetingdate == null)
			listOfErrors.add("MDTMeetingDate is mandatory");
		if(this.meetingnotes != null)
		{
			String[] listOfOtherErrors = this.meetingnotes.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.keydates != null)
		{
			String[] listOfOtherErrors = this.keydates.validate();
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
	
		MDTMeetingVo clone = new MDTMeetingVo(this.id, this.version);
		
		if(this.mdtmeetingdate == null)
			clone.mdtmeetingdate = null;
		else
			clone.mdtmeetingdate = (ims.framework.utils.Date)this.mdtmeetingdate.clone();
		if(this.meetingnotes == null)
			clone.meetingnotes = null;
		else
			clone.meetingnotes = (ims.clinical.vo.MDTNotesVoCollection)this.meetingnotes.clone();
		if(this.carecontext == null)
			clone.carecontext = null;
		else
			clone.carecontext = (ims.core.vo.CareContextShortVo)this.carecontext.clone();
		if(this.listpatientison == null)
			clone.listpatientison = null;
		else
			clone.listpatientison = (ims.clinical.vo.lookups.MDTListAorB)this.listpatientison.clone();
		if(this.keydates == null)
			clone.keydates = null;
		else
			clone.keydates = (ims.clinical.vo.KeyDatesVoCollection)this.keydates.clone();
		if(this.systeminformation == null)
			clone.systeminformation = null;
		else
			clone.systeminformation = (ims.vo.SystemInformation)this.systeminformation.clone();
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
		if (!(MDTMeetingVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A MDTMeetingVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		MDTMeetingVo compareObj = (MDTMeetingVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getMDTMeetingDate() == null && compareObj.getMDTMeetingDate() != null)
				return -1;
			if(this.getMDTMeetingDate() != null && compareObj.getMDTMeetingDate() == null)
				return 1;
			if(this.getMDTMeetingDate() != null && compareObj.getMDTMeetingDate() != null)
				retVal = this.getMDTMeetingDate().compareTo(compareObj.getMDTMeetingDate());
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.meetingnotes != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.listpatientison != null)
			count++;
		if(this.keydates != null)
			count++;
		if(this.systeminformation != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 5;
	}
	protected ims.clinical.vo.MDTNotesVoCollection meetingnotes;
	protected ims.core.vo.CareContextShortVo carecontext;
	protected ims.clinical.vo.lookups.MDTListAorB listpatientison;
	protected ims.clinical.vo.KeyDatesVoCollection keydates;
	protected ims.vo.SystemInformation systeminformation;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
