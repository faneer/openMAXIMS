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

package ims.emergency.vo;

/**
 * Linked to emergency.Triage business object (ID: 1086100004).
 */
public class TriageForTrackingVo extends ims.emergency.vo.TriageRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TriageForTrackingVo()
	{
	}
	public TriageForTrackingVo(Integer id, int version)
	{
		super(id, version);
	}
	public TriageForTrackingVo(ims.emergency.vo.beans.TriageForTrackingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.triagestartdatetime = bean.getTriageStartDateTime() == null ? null : bean.getTriageStartDateTime().buildDateTime();
		this.currenttriagepriority = bean.getCurrentTriagePriority() == null ? null : ims.emergency.vo.lookups.TriagePriority.buildLookup(bean.getCurrentTriagePriority());
		this.mainpresentingproblem = bean.getMainPresentingProblem() == null ? null : bean.getMainPresentingProblem().buildVo();
		this.medicinterventionstartdatetime = bean.getMedicInterventionStartDateTime() == null ? null : bean.getMedicInterventionStartDateTime().buildDateTime();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.TriageForTrackingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.triagestartdatetime = bean.getTriageStartDateTime() == null ? null : bean.getTriageStartDateTime().buildDateTime();
		this.currenttriagepriority = bean.getCurrentTriagePriority() == null ? null : ims.emergency.vo.lookups.TriagePriority.buildLookup(bean.getCurrentTriagePriority());
		this.mainpresentingproblem = bean.getMainPresentingProblem() == null ? null : bean.getMainPresentingProblem().buildVo(map);
		this.medicinterventionstartdatetime = bean.getMedicInterventionStartDateTime() == null ? null : bean.getMedicInterventionStartDateTime().buildDateTime();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.TriageForTrackingVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.TriageForTrackingVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.TriageForTrackingVoBean();
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
		if(fieldName.equals("TRIAGESTARTDATETIME"))
			return getTriageStartDateTime();
		if(fieldName.equals("CURRENTTRIAGEPRIORITY"))
			return getCurrentTriagePriority();
		if(fieldName.equals("MAINPRESENTINGPROBLEM"))
			return getMainPresentingProblem();
		if(fieldName.equals("MEDICINTERVENTIONSTARTDATETIME"))
			return getMedicInterventionStartDateTime();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTriageStartDateTimeIsNotNull()
	{
		return this.triagestartdatetime != null;
	}
	public ims.framework.utils.DateTime getTriageStartDateTime()
	{
		return this.triagestartdatetime;
	}
	public void setTriageStartDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.triagestartdatetime = value;
	}
	public boolean getCurrentTriagePriorityIsNotNull()
	{
		return this.currenttriagepriority != null;
	}
	public ims.emergency.vo.lookups.TriagePriority getCurrentTriagePriority()
	{
		return this.currenttriagepriority;
	}
	public void setCurrentTriagePriority(ims.emergency.vo.lookups.TriagePriority value)
	{
		this.isValidated = false;
		this.currenttriagepriority = value;
	}
	public boolean getMainPresentingProblemIsNotNull()
	{
		return this.mainpresentingproblem != null;
	}
	public ims.emergency.vo.PatientProblemForTrackingVo getMainPresentingProblem()
	{
		return this.mainpresentingproblem;
	}
	public void setMainPresentingProblem(ims.emergency.vo.PatientProblemForTrackingVo value)
	{
		this.isValidated = false;
		this.mainpresentingproblem = value;
	}
	public boolean getMedicInterventionStartDateTimeIsNotNull()
	{
		return this.medicinterventionstartdatetime != null;
	}
	public ims.framework.utils.DateTime getMedicInterventionStartDateTime()
	{
		return this.medicinterventionstartdatetime;
	}
	public void setMedicInterventionStartDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.medicinterventionstartdatetime = value;
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
		if(this.triagestartdatetime == null)
			listOfErrors.add("TriageStartDateTime is mandatory");
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
	
		TriageForTrackingVo clone = new TriageForTrackingVo(this.id, this.version);
		
		if(this.triagestartdatetime == null)
			clone.triagestartdatetime = null;
		else
			clone.triagestartdatetime = (ims.framework.utils.DateTime)this.triagestartdatetime.clone();
		if(this.currenttriagepriority == null)
			clone.currenttriagepriority = null;
		else
			clone.currenttriagepriority = (ims.emergency.vo.lookups.TriagePriority)this.currenttriagepriority.clone();
		if(this.mainpresentingproblem == null)
			clone.mainpresentingproblem = null;
		else
			clone.mainpresentingproblem = (ims.emergency.vo.PatientProblemForTrackingVo)this.mainpresentingproblem.clone();
		if(this.medicinterventionstartdatetime == null)
			clone.medicinterventionstartdatetime = null;
		else
			clone.medicinterventionstartdatetime = (ims.framework.utils.DateTime)this.medicinterventionstartdatetime.clone();
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
		if (!(TriageForTrackingVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TriageForTrackingVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TriageForTrackingVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TriageForTrackingVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.triagestartdatetime != null)
			count++;
		if(this.currenttriagepriority != null)
			count++;
		if(this.mainpresentingproblem != null)
			count++;
		if(this.medicinterventionstartdatetime != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.framework.utils.DateTime triagestartdatetime;
	protected ims.emergency.vo.lookups.TriagePriority currenttriagepriority;
	protected ims.emergency.vo.PatientProblemForTrackingVo mainpresentingproblem;
	protected ims.framework.utils.DateTime medicinterventionstartdatetime;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
