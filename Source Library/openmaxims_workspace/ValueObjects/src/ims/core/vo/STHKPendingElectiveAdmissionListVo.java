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
 * Linked to core.admin.pas.PendingElectiveAdmission business object (ID: 1014100012).
 */
public class STHKPendingElectiveAdmissionListVo extends ims.core.admin.pas.vo.PendingElectiveAdmissionRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public STHKPendingElectiveAdmissionListVo()
	{
	}
	public STHKPendingElectiveAdmissionListVo(Integer id, int version)
	{
		super(id, version);
	}
	public STHKPendingElectiveAdmissionListVo(ims.core.vo.beans.STHKPendingElectiveAdmissionListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.pasevent = bean.getPasEvent() == null ? null : bean.getPasEvent().buildVo();
		this.allocatedward = bean.getAllocatedWard() == null ? null : bean.getAllocatedWard().buildVo();
		this.comments = bean.getComments();
		this.tcidate = bean.getTCIDate() == null ? null : bean.getTCIDate().buildDate();
		this.tcitime = bean.getTCITime() == null ? null : bean.getTCITime().buildTime();
		this.managementintention = bean.getManagementIntention() == null ? null : ims.core.vo.lookups.ManagementIntention.buildLookup(bean.getManagementIntention());
		this.procedures = ims.core.vo.ProcedureLiteVoCollection.buildFromBeanCollection(bean.getProcedures());
		this.activealerts = bean.getActiveAlerts();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.STHKPendingElectiveAdmissionListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.pasevent = bean.getPasEvent() == null ? null : bean.getPasEvent().buildVo(map);
		this.allocatedward = bean.getAllocatedWard() == null ? null : bean.getAllocatedWard().buildVo(map);
		this.comments = bean.getComments();
		this.tcidate = bean.getTCIDate() == null ? null : bean.getTCIDate().buildDate();
		this.tcitime = bean.getTCITime() == null ? null : bean.getTCITime().buildTime();
		this.managementintention = bean.getManagementIntention() == null ? null : ims.core.vo.lookups.ManagementIntention.buildLookup(bean.getManagementIntention());
		this.procedures = ims.core.vo.ProcedureLiteVoCollection.buildFromBeanCollection(bean.getProcedures());
		this.activealerts = bean.getActiveAlerts();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.STHKPendingElectiveAdmissionListVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.STHKPendingElectiveAdmissionListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.STHKPendingElectiveAdmissionListVoBean();
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
		if(fieldName.equals("ALLOCATEDWARD"))
			return getAllocatedWard();
		if(fieldName.equals("COMMENTS"))
			return getComments();
		if(fieldName.equals("TCIDATE"))
			return getTCIDate();
		if(fieldName.equals("TCITIME"))
			return getTCITime();
		if(fieldName.equals("MANAGEMENTINTENTION"))
			return getManagementIntention();
		if(fieldName.equals("PROCEDURES"))
			return getProcedures();
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
	public boolean getAllocatedWardIsNotNull()
	{
		return this.allocatedward != null;
	}
	public ims.core.vo.LocationLiteVo getAllocatedWard()
	{
		return this.allocatedward;
	}
	public void setAllocatedWard(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.allocatedward = value;
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
	public boolean getTCIDateIsNotNull()
	{
		return this.tcidate != null;
	}
	public ims.framework.utils.Date getTCIDate()
	{
		return this.tcidate;
	}
	public void setTCIDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.tcidate = value;
	}
	public boolean getTCITimeIsNotNull()
	{
		return this.tcitime != null;
	}
	public ims.framework.utils.Time getTCITime()
	{
		return this.tcitime;
	}
	public void setTCITime(ims.framework.utils.Time value)
	{
		this.isValidated = false;
		this.tcitime = value;
	}
	public boolean getManagementIntentionIsNotNull()
	{
		return this.managementintention != null;
	}
	public ims.core.vo.lookups.ManagementIntention getManagementIntention()
	{
		return this.managementintention;
	}
	public void setManagementIntention(ims.core.vo.lookups.ManagementIntention value)
	{
		this.isValidated = false;
		this.managementintention = value;
	}
	public boolean getProceduresIsNotNull()
	{
		return this.procedures != null;
	}
	public ims.core.vo.ProcedureLiteVoCollection getProcedures()
	{
		return this.procedures;
	}
	public void setProcedures(ims.core.vo.ProcedureLiteVoCollection value)
	{
		this.isValidated = false;
		this.procedures = value;
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
		if(this.allocatedward != null)
		{
			if(!this.allocatedward.isValidated())
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
		if(this.pasevent == null)
			listOfErrors.add("pasEvent is mandatory");
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
		if(this.allocatedward == null)
			listOfErrors.add("AllocatedWard is mandatory");
		if(this.allocatedward != null)
		{
			String[] listOfOtherErrors = this.allocatedward.validate();
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
				listOfErrors.add("The length of the field [comments] in the value object [ims.core.vo.STHKPendingElectiveAdmissionListVo] is too big. It should be less or equal to 1500");
		if(this.tcidate == null)
			listOfErrors.add("TCIDate is mandatory");
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
	
		STHKPendingElectiveAdmissionListVo clone = new STHKPendingElectiveAdmissionListVo(this.id, this.version);
		
		if(this.pasevent == null)
			clone.pasevent = null;
		else
			clone.pasevent = (ims.core.vo.PasEventForSTHKListVo)this.pasevent.clone();
		if(this.allocatedward == null)
			clone.allocatedward = null;
		else
			clone.allocatedward = (ims.core.vo.LocationLiteVo)this.allocatedward.clone();
		clone.comments = this.comments;
		if(this.tcidate == null)
			clone.tcidate = null;
		else
			clone.tcidate = (ims.framework.utils.Date)this.tcidate.clone();
		if(this.tcitime == null)
			clone.tcitime = null;
		else
			clone.tcitime = (ims.framework.utils.Time)this.tcitime.clone();
		if(this.managementintention == null)
			clone.managementintention = null;
		else
			clone.managementintention = (ims.core.vo.lookups.ManagementIntention)this.managementintention.clone();
		if(this.procedures == null)
			clone.procedures = null;
		else
			clone.procedures = (ims.core.vo.ProcedureLiteVoCollection)this.procedures.clone();
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
		if (!(STHKPendingElectiveAdmissionListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A STHKPendingElectiveAdmissionListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((STHKPendingElectiveAdmissionListVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((STHKPendingElectiveAdmissionListVo)obj).getBoId());
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
		if(this.allocatedward != null)
			count++;
		if(this.comments != null)
			count++;
		if(this.tcidate != null)
			count++;
		if(this.tcitime != null)
			count++;
		if(this.managementintention != null)
			count++;
		if(this.procedures != null)
			count++;
		if(this.activealerts != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected ims.core.vo.PasEventForSTHKListVo pasevent;
	protected ims.core.vo.LocationLiteVo allocatedward;
	protected String comments;
	protected ims.framework.utils.Date tcidate;
	protected ims.framework.utils.Time tcitime;
	protected ims.core.vo.lookups.ManagementIntention managementintention;
	protected ims.core.vo.ProcedureLiteVoCollection procedures;
	protected Boolean activealerts;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
