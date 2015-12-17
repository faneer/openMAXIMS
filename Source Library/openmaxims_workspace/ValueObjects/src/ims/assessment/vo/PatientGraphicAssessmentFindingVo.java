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

/**
 * Linked to Assessment.Instantiation.PatientGraphicAssessmentFinding business object (ID: 1003100051).
 */
public class PatientGraphicAssessmentFindingVo extends ims.assessment.instantiation.vo.PatientGraphicAssessmentFindingRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientGraphicAssessmentFindingVo()
	{
	}
	public PatientGraphicAssessmentFindingVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientGraphicAssessmentFindingVo(ims.assessment.vo.beans.PatientGraphicAssessmentFindingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.drawingid = bean.getDrawingId();
		this.graphicfinding = bean.getGraphicFinding() == null ? null : bean.getGraphicFinding().buildVo();
		this.areadrawn = bean.getAreaDrawn();
		this.areaname = bean.getAreaName();
		this.areadetails = bean.getAreaDetails();
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.iscopied = bean.getIsCopied();
		this.stage = ims.assessment.vo.PatientGraphicalAssessmentStageVoCollection.buildFromBeanCollection(bean.getStage());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.assessment.vo.beans.PatientGraphicAssessmentFindingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.drawingid = bean.getDrawingId();
		this.graphicfinding = bean.getGraphicFinding() == null ? null : bean.getGraphicFinding().buildVo(map);
		this.areadrawn = bean.getAreaDrawn();
		this.areaname = bean.getAreaName();
		this.areadetails = bean.getAreaDetails();
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.iscopied = bean.getIsCopied();
		this.stage = ims.assessment.vo.PatientGraphicalAssessmentStageVoCollection.buildFromBeanCollection(bean.getStage());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.assessment.vo.beans.PatientGraphicAssessmentFindingVoBean bean = null;
		if(map != null)
			bean = (ims.assessment.vo.beans.PatientGraphicAssessmentFindingVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.assessment.vo.beans.PatientGraphicAssessmentFindingVoBean();
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
		if(fieldName.equals("DRAWINGID"))
			return getDrawingId();
		if(fieldName.equals("GRAPHICFINDING"))
			return getGraphicFinding();
		if(fieldName.equals("AREADRAWN"))
			return getAreaDrawn();
		if(fieldName.equals("AREANAME"))
			return getAreaName();
		if(fieldName.equals("AREADETAILS"))
			return getAreaDetails();
		if(fieldName.equals("SYSINFO"))
			return getSysInfo();
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		if(fieldName.equals("ISCOPIED"))
			return getIsCopied();
		if(fieldName.equals("STAGE"))
			return getStage();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDrawingIdIsNotNull()
	{
		return this.drawingid != null;
	}
	public Integer getDrawingId()
	{
		return this.drawingid;
	}
	public void setDrawingId(Integer value)
	{
		this.isValidated = false;
		this.drawingid = value;
	}
	public boolean getGraphicFindingIsNotNull()
	{
		return this.graphicfinding != null;
	}
	public ims.core.vo.DrawingGraphicFindingVo getGraphicFinding()
	{
		return this.graphicfinding;
	}
	public void setGraphicFinding(ims.core.vo.DrawingGraphicFindingVo value)
	{
		this.isValidated = false;
		this.graphicfinding = value;
	}
	public boolean getAreaDrawnIsNotNull()
	{
		return this.areadrawn != null;
	}
	public String getAreaDrawn()
	{
		return this.areadrawn;
	}
	public static int getAreaDrawnMaxLength()
	{
		return 10000;
	}
	public void setAreaDrawn(String value)
	{
		this.isValidated = false;
		this.areadrawn = value;
	}
	public boolean getAreaNameIsNotNull()
	{
		return this.areaname != null;
	}
	public String getAreaName()
	{
		return this.areaname;
	}
	public static int getAreaNameMaxLength()
	{
		return 70;
	}
	public void setAreaName(String value)
	{
		this.isValidated = false;
		this.areaname = value;
	}
	public boolean getAreaDetailsIsNotNull()
	{
		return this.areadetails != null;
	}
	public String getAreaDetails()
	{
		return this.areadetails;
	}
	public static int getAreaDetailsMaxLength()
	{
		return 255;
	}
	public void setAreaDetails(String value)
	{
		this.isValidated = false;
		this.areadetails = value;
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
	public boolean getAuthoringInformationIsNotNull()
	{
		return this.authoringinformation != null;
	}
	public ims.core.vo.AuthoringInformationVo getAuthoringInformation()
	{
		return this.authoringinformation;
	}
	public void setAuthoringInformation(ims.core.vo.AuthoringInformationVo value)
	{
		this.isValidated = false;
		this.authoringinformation = value;
	}
	public boolean getIsCopiedIsNotNull()
	{
		return this.iscopied != null;
	}
	public Boolean getIsCopied()
	{
		return this.iscopied;
	}
	public void setIsCopied(Boolean value)
	{
		this.isValidated = false;
		this.iscopied = value;
	}
	public boolean getStageIsNotNull()
	{
		return this.stage != null;
	}
	public ims.assessment.vo.PatientGraphicalAssessmentStageVoCollection getStage()
	{
		return this.stage;
	}
	public void setStage(ims.assessment.vo.PatientGraphicalAssessmentStageVoCollection value)
	{
		this.isValidated = false;
		this.stage = value;
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
		if(this.authoringinformation != null)
		{
			if(!this.authoringinformation.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.stage != null)
		{
			if(!this.stage.isValidated())
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
		if(this.areaname != null)
			if(this.areaname.length() > 70)
				listOfErrors.add("The length of the field [areaname] in the value object [ims.assessment.vo.PatientGraphicAssessmentFindingVo] is too big. It should be less or equal to 70");
		if(this.areadetails != null)
			if(this.areadetails.length() > 255)
				listOfErrors.add("The length of the field [areadetails] in the value object [ims.assessment.vo.PatientGraphicAssessmentFindingVo] is too big. It should be less or equal to 255");
		if(this.authoringinformation != null)
		{
			String[] listOfOtherErrors = this.authoringinformation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.stage != null)
		{
			String[] listOfOtherErrors = this.stage.validate();
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
	
		PatientGraphicAssessmentFindingVo clone = new PatientGraphicAssessmentFindingVo(this.id, this.version);
		
		clone.drawingid = this.drawingid;
		if(this.graphicfinding == null)
			clone.graphicfinding = null;
		else
			clone.graphicfinding = (ims.core.vo.DrawingGraphicFindingVo)this.graphicfinding.clone();
		clone.areadrawn = this.areadrawn;
		clone.areaname = this.areaname;
		clone.areadetails = this.areadetails;
		if(this.sysinfo == null)
			clone.sysinfo = null;
		else
			clone.sysinfo = (ims.vo.SystemInformation)this.sysinfo.clone();
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		clone.iscopied = this.iscopied;
		if(this.stage == null)
			clone.stage = null;
		else
			clone.stage = (ims.assessment.vo.PatientGraphicalAssessmentStageVoCollection)this.stage.clone();
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
		if (!(PatientGraphicAssessmentFindingVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientGraphicAssessmentFindingVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientGraphicAssessmentFindingVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientGraphicAssessmentFindingVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.drawingid != null)
			count++;
		if(this.graphicfinding != null)
			count++;
		if(this.areadrawn != null)
			count++;
		if(this.areaname != null)
			count++;
		if(this.areadetails != null)
			count++;
		if(this.sysinfo != null)
			count++;
		if(this.authoringinformation != null)
			count++;
		if(this.iscopied != null)
			count++;
		if(this.stage != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected Integer drawingid;
	protected ims.core.vo.DrawingGraphicFindingVo graphicfinding;
	protected String areadrawn;
	protected String areaname;
	protected String areadetails;
	protected ims.vo.SystemInformation sysinfo;
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	protected Boolean iscopied;
	protected ims.assessment.vo.PatientGraphicalAssessmentStageVoCollection stage;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
