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

package ims.clinical.vo;

/**
 * Linked to clinical.ClinicalCorrespondence business object (ID: 1072100040).
 */
public class ClinicalCorrespondenceLiteVo extends ims.clinical.vo.ClinicalCorrespondenceRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ClinicalCorrespondenceLiteVo()
	{
	}
	public ClinicalCorrespondenceLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public ClinicalCorrespondenceLiteVo(ims.clinical.vo.beans.ClinicalCorrespondenceLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo();
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo();
		this.verifyinghcp = bean.getVerifyingHCP() == null ? null : bean.getVerifyingHCP().buildVo();
		this.verifyingdatetime = bean.getVerifyingDateTime() == null ? null : bean.getVerifyingDateTime().buildDateTime();
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo();
		this.opdnotes = bean.getOPDNotes() == null ? null : bean.getOPDNotes().buildVo();
		this.hasobjectivenote = bean.getHasObjectiveNote();
		this.hasplannote = bean.getHasPlanNote();
		this.hasinstructionsnote = bean.getHasInstructionsNote();
		this.inpatientdischargesummary = bean.getInpatientDischargeSummary() == null ? null : bean.getInpatientDischargeSummary().buildVo();
		this.type = bean.getType() == null ? null : ims.clinical.vo.lookups.ClinicalCorrespondenceType.buildLookup(bean.getType());
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : bean.getEpisodeOfCare().buildVo();
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.beans.ClinicalCorrespondenceLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicalcontact = bean.getClinicalContact() == null ? null : bean.getClinicalContact().buildVo(map);
		this.carecontext = bean.getCareContext() == null ? null : bean.getCareContext().buildVo(map);
		this.verifyinghcp = bean.getVerifyingHCP() == null ? null : bean.getVerifyingHCP().buildVo(map);
		this.verifyingdatetime = bean.getVerifyingDateTime() == null ? null : bean.getVerifyingDateTime().buildDateTime();
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo(map);
		this.opdnotes = bean.getOPDNotes() == null ? null : bean.getOPDNotes().buildVo(map);
		this.hasobjectivenote = bean.getHasObjectiveNote();
		this.hasplannote = bean.getHasPlanNote();
		this.hasinstructionsnote = bean.getHasInstructionsNote();
		this.inpatientdischargesummary = bean.getInpatientDischargeSummary() == null ? null : bean.getInpatientDischargeSummary().buildVo(map);
		this.type = bean.getType() == null ? null : ims.clinical.vo.lookups.ClinicalCorrespondenceType.buildLookup(bean.getType());
		this.episodeofcare = bean.getEpisodeOfCare() == null ? null : bean.getEpisodeOfCare().buildVo(map);
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.beans.ClinicalCorrespondenceLiteVoBean bean = null;
		if(map != null)
			bean = (ims.clinical.vo.beans.ClinicalCorrespondenceLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.clinical.vo.beans.ClinicalCorrespondenceLiteVoBean();
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
		if(fieldName.equals("CLINICALCONTACT"))
			return getClinicalContact();
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("VERIFYINGHCP"))
			return getVerifyingHCP();
		if(fieldName.equals("VERIFYINGDATETIME"))
			return getVerifyingDateTime();
		if(fieldName.equals("CURRENTSTATUS"))
			return getCurrentStatus();
		if(fieldName.equals("OPDNOTES"))
			return getOPDNotes();
		if(fieldName.equals("HASOBJECTIVENOTE"))
			return getHasObjectiveNote();
		if(fieldName.equals("HASPLANNOTE"))
			return getHasPlanNote();
		if(fieldName.equals("HASINSTRUCTIONSNOTE"))
			return getHasInstructionsNote();
		if(fieldName.equals("INPATIENTDISCHARGESUMMARY"))
			return getInpatientDischargeSummary();
		if(fieldName.equals("TYPE"))
			return getType();
		if(fieldName.equals("EPISODEOFCARE"))
			return getEpisodeOfCare();
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getClinicalContactIsNotNull()
	{
		return this.clinicalcontact != null;
	}
	public ims.core.vo.ClinicalContactShortVo getClinicalContact()
	{
		return this.clinicalcontact;
	}
	public void setClinicalContact(ims.core.vo.ClinicalContactShortVo value)
	{
		this.isValidated = false;
		this.clinicalcontact = value;
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.vo.CareContextListVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.vo.CareContextListVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
	}
	public boolean getVerifyingHCPIsNotNull()
	{
		return this.verifyinghcp != null;
	}
	public ims.core.vo.HcpLiteVo getVerifyingHCP()
	{
		return this.verifyinghcp;
	}
	public void setVerifyingHCP(ims.core.vo.HcpLiteVo value)
	{
		this.isValidated = false;
		this.verifyinghcp = value;
	}
	public boolean getVerifyingDateTimeIsNotNull()
	{
		return this.verifyingdatetime != null;
	}
	public ims.framework.utils.DateTime getVerifyingDateTime()
	{
		return this.verifyingdatetime;
	}
	public void setVerifyingDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.verifyingdatetime = value;
	}
	public boolean getCurrentStatusIsNotNull()
	{
		return this.currentstatus != null;
	}
	public ims.clinical.vo.CorrespondenceStatusVo getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.clinical.vo.CorrespondenceStatusVo value)
	{
		this.isValidated = false;
		this.currentstatus = value;
	}
	public boolean getOPDNotesIsNotNull()
	{
		return this.opdnotes != null;
	}
	public ims.clinical.vo.OutpatientNotesOutcomeVo getOPDNotes()
	{
		return this.opdnotes;
	}
	public void setOPDNotes(ims.clinical.vo.OutpatientNotesOutcomeVo value)
	{
		this.isValidated = false;
		this.opdnotes = value;
	}
	public boolean getHasObjectiveNoteIsNotNull()
	{
		return this.hasobjectivenote != null;
	}
	public Boolean getHasObjectiveNote()
	{
		return this.hasobjectivenote;
	}
	public void setHasObjectiveNote(Boolean value)
	{
		this.isValidated = false;
		this.hasobjectivenote = value;
	}
	public boolean getHasPlanNoteIsNotNull()
	{
		return this.hasplannote != null;
	}
	public Boolean getHasPlanNote()
	{
		return this.hasplannote;
	}
	public void setHasPlanNote(Boolean value)
	{
		this.isValidated = false;
		this.hasplannote = value;
	}
	public boolean getHasInstructionsNoteIsNotNull()
	{
		return this.hasinstructionsnote != null;
	}
	public Boolean getHasInstructionsNote()
	{
		return this.hasinstructionsnote;
	}
	public void setHasInstructionsNote(Boolean value)
	{
		this.isValidated = false;
		this.hasinstructionsnote = value;
	}
	public boolean getInpatientDischargeSummaryIsNotNull()
	{
		return this.inpatientdischargesummary != null;
	}
	public ims.clinical.vo.InpatientDischargeNoteFollowupVo getInpatientDischargeSummary()
	{
		return this.inpatientdischargesummary;
	}
	public void setInpatientDischargeSummary(ims.clinical.vo.InpatientDischargeNoteFollowupVo value)
	{
		this.isValidated = false;
		this.inpatientdischargesummary = value;
	}
	public boolean getTypeIsNotNull()
	{
		return this.type != null;
	}
	public ims.clinical.vo.lookups.ClinicalCorrespondenceType getType()
	{
		return this.type;
	}
	public void setType(ims.clinical.vo.lookups.ClinicalCorrespondenceType value)
	{
		this.isValidated = false;
		this.type = value;
	}
	public boolean getEpisodeOfCareIsNotNull()
	{
		return this.episodeofcare != null;
	}
	public ims.core.vo.EpisodeofCareShortVo getEpisodeOfCare()
	{
		return this.episodeofcare;
	}
	public void setEpisodeOfCare(ims.core.vo.EpisodeofCareShortVo value)
	{
		this.isValidated = false;
		this.episodeofcare = value;
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
		if(this.verifyinghcp != null)
		{
			if(!this.verifyinghcp.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.currentstatus != null)
		{
			if(!this.currentstatus.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.opdnotes != null)
		{
			if(!this.opdnotes.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.inpatientdischargesummary != null)
		{
			if(!this.inpatientdischargesummary.isValidated())
			{
				this.isBusy = false;
				return false;
			}
		}
		if(this.authoringinformation != null)
		{
			if(!this.authoringinformation.isValidated())
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
		if(this.carecontext == null)
			listOfErrors.add("CareContext is mandatory");
		if(this.verifyinghcp != null)
		{
			String[] listOfOtherErrors = this.verifyinghcp.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.currentstatus == null)
			listOfErrors.add("CurrentStatus is mandatory");
		if(this.currentstatus != null)
		{
			String[] listOfOtherErrors = this.currentstatus.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.opdnotes != null)
		{
			String[] listOfOtherErrors = this.opdnotes.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.inpatientdischargesummary != null)
		{
			String[] listOfOtherErrors = this.inpatientdischargesummary.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.type == null)
			listOfErrors.add("Type is mandatory");
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
	
		ClinicalCorrespondenceLiteVo clone = new ClinicalCorrespondenceLiteVo(this.id, this.version);
		
		if(this.clinicalcontact == null)
			clone.clinicalcontact = null;
		else
			clone.clinicalcontact = (ims.core.vo.ClinicalContactShortVo)this.clinicalcontact.clone();
		if(this.carecontext == null)
			clone.carecontext = null;
		else
			clone.carecontext = (ims.core.vo.CareContextListVo)this.carecontext.clone();
		if(this.verifyinghcp == null)
			clone.verifyinghcp = null;
		else
			clone.verifyinghcp = (ims.core.vo.HcpLiteVo)this.verifyinghcp.clone();
		if(this.verifyingdatetime == null)
			clone.verifyingdatetime = null;
		else
			clone.verifyingdatetime = (ims.framework.utils.DateTime)this.verifyingdatetime.clone();
		if(this.currentstatus == null)
			clone.currentstatus = null;
		else
			clone.currentstatus = (ims.clinical.vo.CorrespondenceStatusVo)this.currentstatus.clone();
		if(this.opdnotes == null)
			clone.opdnotes = null;
		else
			clone.opdnotes = (ims.clinical.vo.OutpatientNotesOutcomeVo)this.opdnotes.clone();
		clone.hasobjectivenote = this.hasobjectivenote;
		clone.hasplannote = this.hasplannote;
		clone.hasinstructionsnote = this.hasinstructionsnote;
		if(this.inpatientdischargesummary == null)
			clone.inpatientdischargesummary = null;
		else
			clone.inpatientdischargesummary = (ims.clinical.vo.InpatientDischargeNoteFollowupVo)this.inpatientdischargesummary.clone();
		if(this.type == null)
			clone.type = null;
		else
			clone.type = (ims.clinical.vo.lookups.ClinicalCorrespondenceType)this.type.clone();
		if(this.episodeofcare == null)
			clone.episodeofcare = null;
		else
			clone.episodeofcare = (ims.core.vo.EpisodeofCareShortVo)this.episodeofcare.clone();
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
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
		if (!(ClinicalCorrespondenceLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ClinicalCorrespondenceLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ClinicalCorrespondenceLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ClinicalCorrespondenceLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.clinicalcontact != null)
			count++;
		if(this.carecontext != null)
			count++;
		if(this.verifyinghcp != null)
			count++;
		if(this.verifyingdatetime != null)
			count++;
		if(this.currentstatus != null)
			count++;
		if(this.opdnotes != null)
			count++;
		if(this.hasobjectivenote != null)
			count++;
		if(this.hasplannote != null)
			count++;
		if(this.hasinstructionsnote != null)
			count++;
		if(this.inpatientdischargesummary != null)
			count++;
		if(this.type != null)
			count++;
		if(this.episodeofcare != null)
			count++;
		if(this.authoringinformation != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 13;
	}
	protected ims.core.vo.ClinicalContactShortVo clinicalcontact;
	protected ims.core.vo.CareContextListVo carecontext;
	protected ims.core.vo.HcpLiteVo verifyinghcp;
	protected ims.framework.utils.DateTime verifyingdatetime;
	protected ims.clinical.vo.CorrespondenceStatusVo currentstatus;
	protected ims.clinical.vo.OutpatientNotesOutcomeVo opdnotes;
	protected Boolean hasobjectivenote;
	protected Boolean hasplannote;
	protected Boolean hasinstructionsnote;
	protected ims.clinical.vo.InpatientDischargeNoteFollowupVo inpatientdischargesummary;
	protected ims.clinical.vo.lookups.ClinicalCorrespondenceType type;
	protected ims.core.vo.EpisodeofCareShortVo episodeofcare;
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
