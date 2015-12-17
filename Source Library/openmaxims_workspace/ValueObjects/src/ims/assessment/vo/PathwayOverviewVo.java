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

package ims.assessment.vo;


public class PathwayOverviewVo extends ims.vo.ValueObject implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PathwayOverviewVo()
	{
	}
	public PathwayOverviewVo(ims.assessment.vo.beans.PathwayOverviewVoBean bean)
	{
		this.pathwayprofilecomponentid = bean.getPathwayProfileComponentID();
		this.userassessmentid = bean.getUserAssessmentID();
		this.userassessmentname = bean.getUserAssessmentName();
		this.graphicassessmentid = bean.getGraphicAssessmentID();
		this.graphicassessmentname = bean.getGraphicAssessmentName();
		this.status = bean.getStatus();
		this.patientassessmentid = bean.getPatientAssessmentID();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.beans.PathwayOverviewVoBean bean)
	{
		this.pathwayprofilecomponentid = bean.getPathwayProfileComponentID();
		this.userassessmentid = bean.getUserAssessmentID();
		this.userassessmentname = bean.getUserAssessmentName();
		this.graphicassessmentid = bean.getGraphicAssessmentID();
		this.graphicassessmentname = bean.getGraphicAssessmentName();
		this.status = bean.getStatus();
		this.patientassessmentid = bean.getPatientAssessmentID();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.beans.PathwayOverviewVoBean bean = null;
		if(map != null)
			bean = (ims.assessment.vo.beans.PathwayOverviewVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.assessment.vo.beans.PathwayOverviewVoBean();
			map.addValueObjectBean(this, bean);
			bean.populate(map, this);
		}
		return bean;
	}
	public boolean getPathwayProfileComponentIDIsNotNull()
	{
		return this.pathwayprofilecomponentid != null;
	}
	public Integer getPathwayProfileComponentID()
	{
		return this.pathwayprofilecomponentid;
	}
	public void setPathwayProfileComponentID(Integer value)
	{
		this.isValidated = false;
		this.pathwayprofilecomponentid = value;
	}
	public boolean getUserAssessmentIDIsNotNull()
	{
		return this.userassessmentid != null;
	}
	public Integer getUserAssessmentID()
	{
		return this.userassessmentid;
	}
	public void setUserAssessmentID(Integer value)
	{
		this.isValidated = false;
		this.userassessmentid = value;
	}
	public boolean getUserAssessmentNameIsNotNull()
	{
		return this.userassessmentname != null;
	}
	public String getUserAssessmentName()
	{
		return this.userassessmentname;
	}
	public static int getUserAssessmentNameMaxLength()
	{
		return 255;
	}
	public void setUserAssessmentName(String value)
	{
		this.isValidated = false;
		this.userassessmentname = value;
	}
	public boolean getGraphicAssessmentIDIsNotNull()
	{
		return this.graphicassessmentid != null;
	}
	public Integer getGraphicAssessmentID()
	{
		return this.graphicassessmentid;
	}
	public void setGraphicAssessmentID(Integer value)
	{
		this.isValidated = false;
		this.graphicassessmentid = value;
	}
	public boolean getGraphicAssessmentNameIsNotNull()
	{
		return this.graphicassessmentname != null;
	}
	public String getGraphicAssessmentName()
	{
		return this.graphicassessmentname;
	}
	public static int getGraphicAssessmentNameMaxLength()
	{
		return 255;
	}
	public void setGraphicAssessmentName(String value)
	{
		this.isValidated = false;
		this.graphicassessmentname = value;
	}
	public boolean getStatusIsNotNull()
	{
		return this.status != null;
	}
	public String getStatus()
	{
		return this.status;
	}
	public static int getStatusMaxLength()
	{
		return 255;
	}
	public void setStatus(String value)
	{
		this.isValidated = false;
		this.status = value;
	}
	public boolean getPatientAssessmentIDIsNotNull()
	{
		return this.patientassessmentid != null;
	}
	public Integer getPatientAssessmentID()
	{
		return this.patientassessmentid;
	}
	public void setPatientAssessmentID(Integer value)
	{
		this.isValidated = false;
		this.patientassessmentid = value;
	}
	public final String getIItemText()
	{
		return toString();
	}
	public final Integer getBoId() 
	{
		return null;
	}
	public final String getBoClassName()
	{
		return null;
	}
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		if(!(obj instanceof PathwayOverviewVo))
			return false;
		PathwayOverviewVo compareObj = (PathwayOverviewVo)obj;
		if(this.getPathwayProfileComponentID() == null && compareObj.getPathwayProfileComponentID() != null)
			return false;
		if(this.getPathwayProfileComponentID() != null && compareObj.getPathwayProfileComponentID() == null)
			return false;
		if(this.getPathwayProfileComponentID() != null && compareObj.getPathwayProfileComponentID() != null)
			return this.getPathwayProfileComponentID().equals(compareObj.getPathwayProfileComponentID());
		return super.equals(obj);
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
	public Object clone()
	{
		if(this.isBusy)
			return this;
		this.isBusy = true;
	
		PathwayOverviewVo clone = new PathwayOverviewVo();
		
		clone.pathwayprofilecomponentid = this.pathwayprofilecomponentid;
		clone.userassessmentid = this.userassessmentid;
		clone.userassessmentname = this.userassessmentname;
		clone.graphicassessmentid = this.graphicassessmentid;
		clone.graphicassessmentname = this.graphicassessmentname;
		clone.status = this.status;
		clone.patientassessmentid = this.patientassessmentid;
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
		if (!(PathwayOverviewVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PathwayOverviewVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		PathwayOverviewVo compareObj = (PathwayOverviewVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getPathwayProfileComponentID() == null && compareObj.getPathwayProfileComponentID() != null)
				return -1;
			if(this.getPathwayProfileComponentID() != null && compareObj.getPathwayProfileComponentID() == null)
				return 1;
			if(this.getPathwayProfileComponentID() != null && compareObj.getPathwayProfileComponentID() != null)
				retVal = this.getPathwayProfileComponentID().compareTo(compareObj.getPathwayProfileComponentID());
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
		if(this.pathwayprofilecomponentid != null)
			count++;
		if(this.userassessmentid != null)
			count++;
		if(this.userassessmentname != null)
			count++;
		if(this.graphicassessmentid != null)
			count++;
		if(this.graphicassessmentname != null)
			count++;
		if(this.status != null)
			count++;
		if(this.patientassessmentid != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 7;
	}
	protected Integer pathwayprofilecomponentid;
	protected Integer userassessmentid;
	protected String userassessmentname;
	protected Integer graphicassessmentid;
	protected String graphicassessmentname;
	protected String status;
	protected Integer patientassessmentid;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
