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

package ims.core.vo;

/**
 * Linked to core.admin.pas.Inpatient Episode business object (ID: 1014100000).
 */
public class STHKCurrentInpatientListVo extends ims.core.admin.pas.vo.InpatientEpisodeRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public STHKCurrentInpatientListVo()
	{
	}
	public STHKCurrentInpatientListVo(Integer id, int version)
	{
		super(id, version);
	}
	public STHKCurrentInpatientListVo(ims.core.vo.beans.STHKCurrentInpatientListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.pasevent = bean.getPasEvent() == null ? null : bean.getPasEvent().buildVo();
		this.estdischargedate = bean.getEstDischargeDate() == null ? null : bean.getEstDischargeDate().buildDate();
		this.comments = bean.getComments();
		this.wardtype = bean.getWardType() == null ? null : ims.core.vo.lookups.WardType.buildLookup(bean.getWardType());
		this.bed = bean.getBed() == null ? null : bean.getBed().buildVo();
		this.isconfirmeddischarge = bean.getIsConfirmedDischarge();
		this.confirmeddischargedatetime = bean.getConfirmedDischargeDateTime() == null ? null : bean.getConfirmedDischargeDateTime().buildDateTime();
		this.isonhomeleave = bean.getIsOnHomeLeave();
		this.expecteddateofreturn = bean.getExpectedDateOfReturn() == null ? null : bean.getExpectedDateOfReturn().buildDate();
		this.expectedtimeofreturn = bean.getExpectedTimeOfReturn() == null ? null : bean.getExpectedTimeOfReturn().buildTime();
		this.activealerts = bean.getActiveAlerts();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.STHKCurrentInpatientListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.pasevent = bean.getPasEvent() == null ? null : bean.getPasEvent().buildVo(map);
		this.estdischargedate = bean.getEstDischargeDate() == null ? null : bean.getEstDischargeDate().buildDate();
		this.comments = bean.getComments();
		this.wardtype = bean.getWardType() == null ? null : ims.core.vo.lookups.WardType.buildLookup(bean.getWardType());
		this.bed = bean.getBed() == null ? null : bean.getBed().buildVo(map);
		this.isconfirmeddischarge = bean.getIsConfirmedDischarge();
		this.confirmeddischargedatetime = bean.getConfirmedDischargeDateTime() == null ? null : bean.getConfirmedDischargeDateTime().buildDateTime();
		this.isonhomeleave = bean.getIsOnHomeLeave();
		this.expecteddateofreturn = bean.getExpectedDateOfReturn() == null ? null : bean.getExpectedDateOfReturn().buildDate();
		this.expectedtimeofreturn = bean.getExpectedTimeOfReturn() == null ? null : bean.getExpectedTimeOfReturn().buildTime();
		this.activealerts = bean.getActiveAlerts();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.STHKCurrentInpatientListVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.STHKCurrentInpatientListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.STHKCurrentInpatientListVoBean();
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
		if(fieldName.equals("ESTDISCHARGEDATE"))
			return getEstDischargeDate();
		if(fieldName.equals("COMMENTS"))
			return getComments();
		if(fieldName.equals("WARDTYPE"))
			return getWardType();
		if(fieldName.equals("BED"))
			return getBed();
		if(fieldName.equals("ISCONFIRMEDDISCHARGE"))
			return getIsConfirmedDischarge();
		if(fieldName.equals("CONFIRMEDDISCHARGEDATETIME"))
			return getConfirmedDischargeDateTime();
		if(fieldName.equals("ISONHOMELEAVE"))
			return getIsOnHomeLeave();
		if(fieldName.equals("EXPECTEDDATEOFRETURN"))
			return getExpectedDateOfReturn();
		if(fieldName.equals("EXPECTEDTIMEOFRETURN"))
			return getExpectedTimeOfReturn();
		if(fieldName.equals("ACTIVEALERTS"))
			return getActiveAlerts();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getPasEventIsNotNull()
	{
		return this.pasevent != null;
	}
	public ims.core.vo.PasEventForSTHKListVo getPasEvent()
	{
		return this.pasevent;
	}
	public void setPasEvent(ims.core.vo.PasEventForSTHKListVo value)
	{
		this.isValidated = false;
		this.pasevent = value;
	}
	public boolean getEstDischargeDateIsNotNull()
	{
		return this.estdischargedate != null;
	}
	public ims.framework.utils.Date getEstDischargeDate()
	{
		return this.estdischargedate;
	}
	public void setEstDischargeDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.estdischargedate = value;
	}
	public boolean getCommentsIsNotNull()
	{
		return this.comments != null;
	}
	public String getComments()
	{
		return this.comments;
	}
	public static int getCommentsMaxLength()
	{
		return 1500;
	}
	public void setComments(String value)
	{
		this.isValidated = false;
		this.comments = value;
	}
	public boolean getWardTypeIsNotNull()
	{
		return this.wardtype != null;
	}
	public ims.core.vo.lookups.WardType getWardType()
	{
		return this.wardtype;
	}
	public void setWardType(ims.core.vo.lookups.WardType value)
	{
		this.isValidated = false;
		this.wardtype = value;
	}
	public boolean getBedIsNotNull()
	{
		return this.bed != null;
	}
	public ims.core.vo.BedSpaceStateListVo getBed()
	{
		return this.bed;
	}
	public void setBed(ims.core.vo.BedSpaceStateListVo value)
	{
		this.isValidated = false;
		this.bed = value;
	}
	public boolean getIsConfirmedDischargeIsNotNull()
	{
		return this.isconfirmeddischarge != null;
	}
	public Boolean getIsConfirmedDischarge()
	{
		return this.isconfirmeddischarge;
	}
	public void setIsConfirmedDischarge(Boolean value)
	{
		this.isValidated = false;
		this.isconfirmeddischarge = value;
	}
	public boolean getConfirmedDischargeDateTimeIsNotNull()
	{
		return this.confirmeddischargedatetime != null;
	}
	public ims.framework.utils.DateTime getConfirmedDischargeDateTime()
	{
		return this.confirmeddischargedatetime;
	}
	public void setConfirmedDischargeDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.confirmeddischargedatetime = value;
	}
	public boolean getIsOnHomeLeaveIsNotNull()
	{
		return this.isonhomeleave != null;
	}
	public Boolean getIsOnHomeLeave()
	{
		return this.isonhomeleave;
	}
	public void setIsOnHomeLeave(Boolean value)
	{
		this.isValidated = false;
		this.isonhomeleave = value;
	}
	public boolean getExpectedDateOfReturnIsNotNull()
	{
		return this.expecteddateofreturn != null;
	}
	public ims.framework.utils.Date getExpectedDateOfReturn()
	{
		return this.expecteddateofreturn;
	}
	public void setExpectedDateOfReturn(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.expecteddateofreturn = value;
	}
	public boolean getExpectedTimeOfReturnIsNotNull()
	{
		return this.expectedtimeofreturn != null;
	}
	public ims.framework.utils.Time getExpectedTimeOfReturn()
	{
		return this.expectedtimeofreturn;
	}
	public void setExpectedTimeOfReturn(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.expectedtimeofreturn = value;
	}
	public boolean getActiveAlertsIsNotNull()
	{
		return this.activealerts != null;
	}
	public Boolean getActiveAlerts()
	{
		return this.activealerts;
	}
	public void setActiveAlerts(Boolean value)
	{
		this.isValidated = false;
		this.activealerts = value;
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
		if(this.pasevent != null)
		{
			if(!this.pasevent.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.bed != null)
		{
			if(!this.bed.isValidated())
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
		if(this.pasevent != null)
		{
			String[] listOfOtherErrors = this.pasevent.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.comments != null)
			if(this.comments.length() > 1500)
				listOfErrors.add("The length of the field [comments] in the value object [ims.core.vo.STHKCurrentInpatientListVo] is too big. It should be less or equal to 1500");
		if(this.bed != null)
		{
			String[] listOfOtherErrors = this.bed.validate();
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
	
		STHKCurrentInpatientListVo clone = new STHKCurrentInpatientListVo(this.id, this.version);
		
		if(this.pasevent == null)
			clone.pasevent = null;
		else
			clone.pasevent = (ims.core.vo.PasEventForSTHKListVo)this.pasevent.clone();
		if(this.estdischargedate == null)
			clone.estdischargedate = null;
		else
			clone.estdischargedate = (ims.framework.utils.Date)this.estdischargedate.clone();
		clone.comments = this.comments;
		if(this.wardtype == null)
			clone.wardtype = null;
		else
			clone.wardtype = (ims.core.vo.lookups.WardType)this.wardtype.clone();
		if(this.bed == null)
			clone.bed = null;
		else
			clone.bed = (ims.core.vo.BedSpaceStateListVo)this.bed.clone();
		clone.isconfirmeddischarge = this.isconfirmeddischarge;
		if(this.confirmeddischargedatetime == null)
			clone.confirmeddischargedatetime = null;
		else
			clone.confirmeddischargedatetime = (ims.framework.utils.DateTime)this.confirmeddischargedatetime.clone();
		clone.isonhomeleave = this.isonhomeleave;
		if(this.expecteddateofreturn == null)
			clone.expecteddateofreturn = null;
		else
			clone.expecteddateofreturn = (ims.framework.utils.Date)this.expecteddateofreturn.clone();
		if(this.expectedtimeofreturn == null)
			clone.expectedtimeofreturn = null;
		else
			clone.expectedtimeofreturn = (ims.framework.utils.Time)this.expectedtimeofreturn.clone();
		clone.activealerts = this.activealerts;
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
		if (!(STHKCurrentInpatientListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A STHKCurrentInpatientListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((STHKCurrentInpatientListVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((STHKCurrentInpatientListVo)obj).getBoId());
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
		if(this.estdischargedate != null)
			count++;
		if(this.comments != null)
			count++;
		if(this.wardtype != null)
			count++;
		if(this.bed != null)
			count++;
		if(this.isconfirmeddischarge != null)
			count++;
		if(this.confirmeddischargedatetime != null)
			count++;
		if(this.isonhomeleave != null)
			count++;
		if(this.expecteddateofreturn != null)
			count++;
		if(this.expectedtimeofreturn != null)
			count++;
		if(this.activealerts != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 11;
	}
	protected ims.core.vo.PasEventForSTHKListVo pasevent;
	protected ims.framework.utils.Date estdischargedate;
	protected String comments;
	protected ims.core.vo.lookups.WardType wardtype;
	protected ims.core.vo.BedSpaceStateListVo bed;
	protected Boolean isconfirmeddischarge;
	protected ims.framework.utils.DateTime confirmeddischargedatetime;
	protected Boolean isonhomeleave;
	protected ims.framework.utils.Date expecteddateofreturn;
	protected ims.framework.utils.Time expectedtimeofreturn;
	protected Boolean activealerts;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
