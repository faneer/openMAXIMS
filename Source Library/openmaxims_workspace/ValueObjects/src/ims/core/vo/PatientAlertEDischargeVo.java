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
 * Linked to core.clinical.PatientAlert business object (ID: 1003100012).
 */
public class PatientAlertEDischargeVo extends ims.core.clinical.vo.PatientAlertRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientAlertEDischargeVo()
	{
	}
	public PatientAlertEDischargeVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientAlertEDischargeVo(ims.core.vo.beans.PatientAlertEDischargeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.alerttype = bean.getAlertType() == null ? null : ims.core.vo.lookups.AlertType.buildLookup(bean.getAlertType());
		this.iscurrentlyactivealert = bean.getIsCurrentlyActiveAlert();
		this.comments = bean.getComments();
		this.sourceofinformation = bean.getSourceofInformation() == null ? null : ims.core.vo.lookups.SourceofInformation.buildLookup(bean.getSourceofInformation());
		this.dateidentified = bean.getDateIdentified() == null ? null : bean.getDateIdentified().buildPartialDate();
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.includealertindischargereports = ims.core.vo.IncludeAlertInDischargeReportsVoCollection.buildFromBeanCollection(bean.getIncludeAlertInDischargeReports());
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.inactivationcomments = bean.getInactivationComments();
		this.inactivationauthoringinfo = bean.getInactivationAuthoringInfo() == null ? null : bean.getInactivationAuthoringInfo().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PatientAlertEDischargeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.alerttype = bean.getAlertType() == null ? null : ims.core.vo.lookups.AlertType.buildLookup(bean.getAlertType());
		this.iscurrentlyactivealert = bean.getIsCurrentlyActiveAlert();
		this.comments = bean.getComments();
		this.sourceofinformation = bean.getSourceofInformation() == null ? null : ims.core.vo.lookups.SourceofInformation.buildLookup(bean.getSourceofInformation());
		this.dateidentified = bean.getDateIdentified() == null ? null : bean.getDateIdentified().buildPartialDate();
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.patient = bean.getPatient() == null ? null : new ims.core.patient.vo.PatientRefVo(new Integer(bean.getPatient().getId()), bean.getPatient().getVersion());
		this.includealertindischargereports = ims.core.vo.IncludeAlertInDischargeReportsVoCollection.buildFromBeanCollection(bean.getIncludeAlertInDischargeReports());
		this.sysinfo = bean.getSysInfo() == null ? null : bean.getSysInfo().buildSystemInformation();
		this.inactivationcomments = bean.getInactivationComments();
		this.inactivationauthoringinfo = bean.getInactivationAuthoringInfo() == null ? null : bean.getInactivationAuthoringInfo().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PatientAlertEDischargeVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PatientAlertEDischargeVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PatientAlertEDischargeVoBean();
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
		if(fieldName.equals("ALERTTYPE"))
			return getAlertType();
		if(fieldName.equals("ISCURRENTLYACTIVEALERT"))
			return getIsCurrentlyActiveAlert();
		if(fieldName.equals("COMMENTS"))
			return getComments();
		if(fieldName.equals("SOURCEOFINFORMATION"))
			return getSourceofInformation();
		if(fieldName.equals("DATEIDENTIFIED"))
			return getDateIdentified();
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		if(fieldName.equals("PATIENT"))
			return getPatient();
		if(fieldName.equals("INCLUDEALERTINDISCHARGEREPORTS"))
			return getIncludeAlertInDischargeReports();
		if(fieldName.equals("SYSINFO"))
			return getSysInfo();
		if(fieldName.equals("INACTIVATIONCOMMENTS"))
			return getInactivationComments();
		if(fieldName.equals("INACTIVATIONAUTHORINGINFO"))
			return getInactivationAuthoringInfo();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAlertTypeIsNotNull()
	{
		return this.alerttype != null;
	}
	public ims.core.vo.lookups.AlertType getAlertType()
	{
		return this.alerttype;
	}
	public void setAlertType(ims.core.vo.lookups.AlertType value)
	{
		this.isValidated = false;
		this.alerttype = value;
	}
	public boolean getIsCurrentlyActiveAlertIsNotNull()
	{
		return this.iscurrentlyactivealert != null;
	}
	public Boolean getIsCurrentlyActiveAlert()
	{
		return this.iscurrentlyactivealert;
	}
	public void setIsCurrentlyActiveAlert(Boolean value)
	{
		this.isValidated = false;
		this.iscurrentlyactivealert = value;
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
		return 255;
	}
	public void setComments(String value)
	{
		this.isValidated = false;
		this.comments = value;
	}
	public boolean getSourceofInformationIsNotNull()
	{
		return this.sourceofinformation != null;
	}
	public ims.core.vo.lookups.SourceofInformation getSourceofInformation()
	{
		return this.sourceofinformation;
	}
	public void setSourceofInformation(ims.core.vo.lookups.SourceofInformation value)
	{
		this.isValidated = false;
		this.sourceofinformation = value;
	}
	public boolean getDateIdentifiedIsNotNull()
	{
		return this.dateidentified != null;
	}
	public ims.framework.utils.PartialDate getDateIdentified()
	{
		return this.dateidentified;
	}
	public void setDateIdentified(ims.framework.utils.PartialDate value)
	{
		this.isValidated = false;
		this.dateidentified = value;
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
	public boolean getPatientIsNotNull()
	{
		return this.patient != null;
	}
	public ims.core.patient.vo.PatientRefVo getPatient()
	{
		return this.patient;
	}
	public void setPatient(ims.core.patient.vo.PatientRefVo value)
	{
		this.isValidated = false;
		this.patient = value;
	}
	public boolean getIncludeAlertInDischargeReportsIsNotNull()
	{
		return this.includealertindischargereports != null;
	}
	public ims.core.vo.IncludeAlertInDischargeReportsVoCollection getIncludeAlertInDischargeReports()
	{
		return this.includealertindischargereports;
	}
	public void setIncludeAlertInDischargeReports(ims.core.vo.IncludeAlertInDischargeReportsVoCollection value)
	{
		this.isValidated = false;
		this.includealertindischargereports = value;
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
	public boolean getInactivationCommentsIsNotNull()
	{
		return this.inactivationcomments != null;
	}
	public String getInactivationComments()
	{
		return this.inactivationcomments;
	}
	public static int getInactivationCommentsMaxLength()
	{
		return 500;
	}
	public void setInactivationComments(String value)
	{
		this.isValidated = false;
		this.inactivationcomments = value;
	}
	public boolean getInactivationAuthoringInfoIsNotNull()
	{
		return this.inactivationauthoringinfo != null;
	}
	public ims.core.vo.AuthoringInformationVo getInactivationAuthoringInfo()
	{
		return this.inactivationauthoringinfo;
	}
	public void setInactivationAuthoringInfo(ims.core.vo.AuthoringInformationVo value)
	{
		this.isValidated = false;
		this.inactivationauthoringinfo = value;
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
		if(this.includealertindischargereports != null)
		{
			if(!this.includealertindischargereports.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.inactivationauthoringinfo != null)
		{
			if(!this.inactivationauthoringinfo.isValidated())
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
		if(this.alerttype == null)
			listOfErrors.add("AlertType is mandatory");
		if(this.comments != null)
			if(this.comments.length() > 255)
				listOfErrors.add("The length of the field [comments] in the value object [ims.core.vo.PatientAlertEDischargeVo] is too big. It should be less or equal to 255");
		if(this.sourceofinformation == null)
			listOfErrors.add("SourceofInformation is mandatory");
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
		if(this.patient == null)
			listOfErrors.add("Patient is mandatory");
		if(this.includealertindischargereports != null)
		{
			String[] listOfOtherErrors = this.includealertindischargereports.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.inactivationcomments != null)
			if(this.inactivationcomments.length() > 500)
				listOfErrors.add("The length of the field [inactivationcomments] in the value object [ims.core.vo.PatientAlertEDischargeVo] is too big. It should be less or equal to 500");
		if(this.inactivationauthoringinfo != null)
		{
			String[] listOfOtherErrors = this.inactivationauthoringinfo.validate();
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
	
		PatientAlertEDischargeVo clone = new PatientAlertEDischargeVo(this.id, this.version);
		
		if(this.alerttype == null)
			clone.alerttype = null;
		else
			clone.alerttype = (ims.core.vo.lookups.AlertType)this.alerttype.clone();
		clone.iscurrentlyactivealert = this.iscurrentlyactivealert;
		clone.comments = this.comments;
		if(this.sourceofinformation == null)
			clone.sourceofinformation = null;
		else
			clone.sourceofinformation = (ims.core.vo.lookups.SourceofInformation)this.sourceofinformation.clone();
		if(this.dateidentified == null)
			clone.dateidentified = null;
		else
			clone.dateidentified = (ims.framework.utils.PartialDate)this.dateidentified.clone();
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		clone.patient = this.patient;
		if(this.includealertindischargereports == null)
			clone.includealertindischargereports = null;
		else
			clone.includealertindischargereports = (ims.core.vo.IncludeAlertInDischargeReportsVoCollection)this.includealertindischargereports.clone();
		if(this.sysinfo == null)
			clone.sysinfo = null;
		else
			clone.sysinfo = (ims.vo.SystemInformation)this.sysinfo.clone();
		clone.inactivationcomments = this.inactivationcomments;
		if(this.inactivationauthoringinfo == null)
			clone.inactivationauthoringinfo = null;
		else
			clone.inactivationauthoringinfo = (ims.core.vo.AuthoringInformationVo)this.inactivationauthoringinfo.clone();
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
		if (!(PatientAlertEDischargeVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientAlertEDischargeVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientAlertEDischargeVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientAlertEDischargeVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.alerttype != null)
			count++;
		if(this.iscurrentlyactivealert != null)
			count++;
		if(this.comments != null)
			count++;
		if(this.sourceofinformation != null)
			count++;
		if(this.dateidentified != null)
			count++;
		if(this.authoringinformation != null)
			count++;
		if(this.patient != null)
			count++;
		if(this.includealertindischargereports != null)
			count++;
		if(this.sysinfo != null)
			count++;
		if(this.inactivationcomments != null)
			count++;
		if(this.inactivationauthoringinfo != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 11;
	}
	protected ims.core.vo.lookups.AlertType alerttype;
	protected Boolean iscurrentlyactivealert;
	protected String comments;
	protected ims.core.vo.lookups.SourceofInformation sourceofinformation;
	protected ims.framework.utils.PartialDate dateidentified;
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	protected ims.core.patient.vo.PatientRefVo patient;
	protected ims.core.vo.IncludeAlertInDischargeReportsVoCollection includealertindischargereports;
	protected ims.vo.SystemInformation sysinfo;
	protected String inactivationcomments;
	protected ims.core.vo.AuthoringInformationVo inactivationauthoringinfo;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
