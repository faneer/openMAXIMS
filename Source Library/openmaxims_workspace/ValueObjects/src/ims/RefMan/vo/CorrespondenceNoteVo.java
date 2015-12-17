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
 * Linked to RefMan.ReportNote business object (ID: 1096100040).
 */
public class CorrespondenceNoteVo extends ims.RefMan.vo.CorrespondenceNoteLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public CorrespondenceNoteVo()
	{
	}
	public CorrespondenceNoteVo(Integer id, int version)
	{
		super(id, version);
	}
	public CorrespondenceNoteVo(ims.RefMan.vo.beans.CorrespondenceNoteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.catsreferral = bean.getCatsReferral() == null ? null : new ims.RefMan.vo.CatsReferralRefVo(new Integer(bean.getCatsReferral().getId()), bean.getCatsReferral().getVersion());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.recordinginformation = bean.getRecordingInformation() == null ? null : bean.getRecordingInformation().buildVo();
		this.notetype = bean.getNoteType() == null ? null : ims.RefMan.vo.lookups.ReportNoteType.buildLookup(bean.getNoteType());
		this.reportnote = bean.getReportNote();
		this.notestatus = bean.getNoteStatus() == null ? null : ims.RefMan.vo.lookups.ReportNoteStatus.buildLookup(bean.getNoteStatus());
		this.copytogp = bean.getCopyToGP();
		this.copytopatient = bean.getCopyToPatient();
		this.copytosecondarycare = bean.getCopyToSecondaryCare();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.CorrespondenceNoteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.catsreferral = bean.getCatsReferral() == null ? null : new ims.RefMan.vo.CatsReferralRefVo(new Integer(bean.getCatsReferral().getId()), bean.getCatsReferral().getVersion());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.recordinginformation = bean.getRecordingInformation() == null ? null : bean.getRecordingInformation().buildVo(map);
		this.notetype = bean.getNoteType() == null ? null : ims.RefMan.vo.lookups.ReportNoteType.buildLookup(bean.getNoteType());
		this.reportnote = bean.getReportNote();
		this.notestatus = bean.getNoteStatus() == null ? null : ims.RefMan.vo.lookups.ReportNoteStatus.buildLookup(bean.getNoteStatus());
		this.copytogp = bean.getCopyToGP();
		this.copytopatient = bean.getCopyToPatient();
		this.copytosecondarycare = bean.getCopyToSecondaryCare();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.CorrespondenceNoteVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.CorrespondenceNoteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.CorrespondenceNoteVoBean();
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
		if(fieldName.equals("NOTETYPE"))
			return getNoteType();
		if(fieldName.equals("REPORTNOTE"))
			return getReportNote();
		if(fieldName.equals("NOTESTATUS"))
			return getNoteStatus();
		if(fieldName.equals("COPYTOGP"))
			return getCopyToGP();
		if(fieldName.equals("COPYTOPATIENT"))
			return getCopyToPatient();
		if(fieldName.equals("COPYTOSECONDARYCARE"))
			return getCopyToSecondaryCare();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getNoteTypeIsNotNull()
	{
		return this.notetype != null;
	}
	public ims.RefMan.vo.lookups.ReportNoteType getNoteType()
	{
		return this.notetype;
	}
	public void setNoteType(ims.RefMan.vo.lookups.ReportNoteType value)
	{
		this.isValidated = false;
		this.notetype = value;
	}
	public boolean getReportNoteIsNotNull()
	{
		return this.reportnote != null;
	}
	public String getReportNote()
	{
		return this.reportnote;
	}
	public static int getReportNoteMaxLength()
	{
		return 10000;
	}
	public void setReportNote(String value)
	{
		this.isValidated = false;
		this.reportnote = value;
	}
	public boolean getNoteStatusIsNotNull()
	{
		return this.notestatus != null;
	}
	public ims.RefMan.vo.lookups.ReportNoteStatus getNoteStatus()
	{
		return this.notestatus;
	}
	public void setNoteStatus(ims.RefMan.vo.lookups.ReportNoteStatus value)
	{
		this.isValidated = false;
		this.notestatus = value;
	}
	public boolean getCopyToGPIsNotNull()
	{
		return this.copytogp != null;
	}
	public Boolean getCopyToGP()
	{
		return this.copytogp;
	}
	public void setCopyToGP(Boolean value)
	{
		this.isValidated = false;
		this.copytogp = value;
	}
	public boolean getCopyToPatientIsNotNull()
	{
		return this.copytopatient != null;
	}
	public Boolean getCopyToPatient()
	{
		return this.copytopatient;
	}
	public void setCopyToPatient(Boolean value)
	{
		this.isValidated = false;
		this.copytopatient = value;
	}
	public boolean getCopyToSecondaryCareIsNotNull()
	{
		return this.copytosecondarycare != null;
	}
	public Boolean getCopyToSecondaryCare()
	{
		return this.copytosecondarycare;
	}
	public void setCopyToSecondaryCare(Boolean value)
	{
		this.isValidated = false;
		this.copytosecondarycare = value;
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
		if(this.recordinginformation != null)
		{
			if(!this.recordinginformation.isValidated())
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
		if(this.catsreferral == null)
			listOfErrors.add("CatsReferral is mandatory");
		if(this.authoringinformation == null)
			listOfErrors.add("AuthoringInformation is mandatory");
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
		if(this.recordinginformation == null)
			listOfErrors.add("RecordingInformation is mandatory");
		if(this.recordinginformation != null)
		{
			String[] listOfOtherErrors = this.recordinginformation.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.notetype == null)
			listOfErrors.add("NoteType is mandatory");
		if(this.reportnote == null || this.reportnote.length() == 0)
			listOfErrors.add("ReportNote is mandatory");
		if(this.notestatus == null)
			listOfErrors.add("NoteStatus is mandatory");
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
	
		CorrespondenceNoteVo clone = new CorrespondenceNoteVo(this.id, this.version);
		
		clone.catsreferral = this.catsreferral;
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		if(this.recordinginformation == null)
			clone.recordinginformation = null;
		else
			clone.recordinginformation = (ims.core.vo.AuthoringInformationVo)this.recordinginformation.clone();
		if(this.notetype == null)
			clone.notetype = null;
		else
			clone.notetype = (ims.RefMan.vo.lookups.ReportNoteType)this.notetype.clone();
		clone.reportnote = this.reportnote;
		if(this.notestatus == null)
			clone.notestatus = null;
		else
			clone.notestatus = (ims.RefMan.vo.lookups.ReportNoteStatus)this.notestatus.clone();
		clone.copytogp = this.copytogp;
		clone.copytopatient = this.copytopatient;
		clone.copytosecondarycare = this.copytosecondarycare;
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
		if (!(CorrespondenceNoteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A CorrespondenceNoteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((CorrespondenceNoteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((CorrespondenceNoteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.notetype != null)
			count++;
		if(this.reportnote != null)
			count++;
		if(this.notestatus != null)
			count++;
		if(this.copytogp != null)
			count++;
		if(this.copytopatient != null)
			count++;
		if(this.copytosecondarycare != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 6;
	}
	protected ims.RefMan.vo.lookups.ReportNoteType notetype;
	protected String reportnote;
	protected ims.RefMan.vo.lookups.ReportNoteStatus notestatus;
	protected Boolean copytogp;
	protected Boolean copytopatient;
	protected Boolean copytosecondarycare;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
