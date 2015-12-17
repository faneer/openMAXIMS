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
 * Linked to core.admin.pas.AdmissionDetail business object (ID: 1014100008).
 */
public class AdmissionDetailWithConsultantStaysForCodingVo extends ims.core.admin.pas.vo.AdmissionDetailRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AdmissionDetailWithConsultantStaysForCodingVo()
	{
	}
	public AdmissionDetailWithConsultantStaysForCodingVo(Integer id, int version)
	{
		super(id, version);
	}
	public AdmissionDetailWithConsultantStaysForCodingVo(ims.RefMan.vo.beans.AdmissionDetailWithConsultantStaysForCodingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.admissiondatetime = bean.getAdmissionDateTime() == null ? null : bean.getAdmissionDateTime().buildDateTime();
		this.consultantstays = ims.RefMan.vo.ConsultantStayForPatientCodingListVoCollection.buildFromBeanCollection(bean.getConsultantStays());
		this.awaitinghistology = ims.RefMan.vo.AwaitingHistologyVoCollection.buildFromBeanCollection(bean.getAwaitingHistology());
		this.los = bean.getLOS();
		this.codingstatus = bean.getCodingStatus() == null ? null : ims.core.vo.lookups.CodingStatus.buildLookup(bean.getCodingStatus());
		this.sourceofadmission = bean.getSourceOfAdmission() == null ? null : ims.core.vo.lookups.SourceOfAdmission.buildLookup(bean.getSourceOfAdmission());
		this.pasevent = bean.getPasEvent() == null ? null : bean.getPasEvent().buildVo();
		this.dischargeepisode = bean.getDischargeEpisode() == null ? null : bean.getDischargeEpisode().buildVo();
		this.codingcomments = ims.clinical.vo.CodingCommentVoCollection.buildFromBeanCollection(bean.getCodingComments());
		this.inpatientepisode = bean.getInpatientEpisode() == null ? null : new ims.core.admin.pas.vo.InpatientEpisodeRefVo(new Integer(bean.getInpatientEpisode().getId()), bean.getInpatientEpisode().getVersion());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.AdmissionDetailWithConsultantStaysForCodingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.admissiondatetime = bean.getAdmissionDateTime() == null ? null : bean.getAdmissionDateTime().buildDateTime();
		this.consultantstays = ims.RefMan.vo.ConsultantStayForPatientCodingListVoCollection.buildFromBeanCollection(bean.getConsultantStays());
		this.awaitinghistology = ims.RefMan.vo.AwaitingHistologyVoCollection.buildFromBeanCollection(bean.getAwaitingHistology());
		this.los = bean.getLOS();
		this.codingstatus = bean.getCodingStatus() == null ? null : ims.core.vo.lookups.CodingStatus.buildLookup(bean.getCodingStatus());
		this.sourceofadmission = bean.getSourceOfAdmission() == null ? null : ims.core.vo.lookups.SourceOfAdmission.buildLookup(bean.getSourceOfAdmission());
		this.pasevent = bean.getPasEvent() == null ? null : bean.getPasEvent().buildVo(map);
		this.dischargeepisode = bean.getDischargeEpisode() == null ? null : bean.getDischargeEpisode().buildVo(map);
		this.codingcomments = ims.clinical.vo.CodingCommentVoCollection.buildFromBeanCollection(bean.getCodingComments());
		this.inpatientepisode = bean.getInpatientEpisode() == null ? null : new ims.core.admin.pas.vo.InpatientEpisodeRefVo(new Integer(bean.getInpatientEpisode().getId()), bean.getInpatientEpisode().getVersion());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.AdmissionDetailWithConsultantStaysForCodingVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.AdmissionDetailWithConsultantStaysForCodingVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.AdmissionDetailWithConsultantStaysForCodingVoBean();
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
		if(fieldName.equals("ADMISSIONDATETIME"))
			return getAdmissionDateTime();
		if(fieldName.equals("CONSULTANTSTAYS"))
			return getConsultantStays();
		if(fieldName.equals("AWAITINGHISTOLOGY"))
			return getAwaitingHistology();
		if(fieldName.equals("LOS"))
			return getLOS();
		if(fieldName.equals("CODINGSTATUS"))
			return getCodingStatus();
		if(fieldName.equals("SOURCEOFADMISSION"))
			return getSourceOfAdmission();
		if(fieldName.equals("PASEVENT"))
			return getPasEvent();
		if(fieldName.equals("DISCHARGEEPISODE"))
			return getDischargeEpisode();
		if(fieldName.equals("CODINGCOMMENTS"))
			return getCodingComments();
		if(fieldName.equals("INPATIENTEPISODE"))
			return getInpatientEpisode();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getAdmissionDateTimeIsNotNull()
	{
		return this.admissiondatetime != null;
	}
	public ims.framework.utils.DateTime getAdmissionDateTime()
	{
		return this.admissiondatetime;
	}
	public void setAdmissionDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.admissiondatetime = value;
	}
	public boolean getConsultantStaysIsNotNull()
	{
		return this.consultantstays != null;
	}
	public ims.RefMan.vo.ConsultantStayForPatientCodingListVoCollection getConsultantStays()
	{
		return this.consultantstays;
	}
	public void setConsultantStays(ims.RefMan.vo.ConsultantStayForPatientCodingListVoCollection value)
	{
		this.isValidated = false;
		this.consultantstays = value;
	}
	public boolean getAwaitingHistologyIsNotNull()
	{
		return this.awaitinghistology != null;
	}
	public ims.RefMan.vo.AwaitingHistologyVoCollection getAwaitingHistology()
	{
		return this.awaitinghistology;
	}
	public void setAwaitingHistology(ims.RefMan.vo.AwaitingHistologyVoCollection value)
	{
		this.isValidated = false;
		this.awaitinghistology = value;
	}
	public boolean getLOSIsNotNull()
	{
		return this.los != null;
	}
	public Integer getLOS()
	{
		return this.los;
	}
	public void setLOS(Integer value)
	{
		this.isValidated = false;
		this.los = value;
	}
	public boolean getCodingStatusIsNotNull()
	{
		return this.codingstatus != null;
	}
	public ims.core.vo.lookups.CodingStatus getCodingStatus()
	{
		return this.codingstatus;
	}
	public void setCodingStatus(ims.core.vo.lookups.CodingStatus value)
	{
		this.isValidated = false;
		this.codingstatus = value;
	}
	public boolean getSourceOfAdmissionIsNotNull()
	{
		return this.sourceofadmission != null;
	}
	public ims.core.vo.lookups.SourceOfAdmission getSourceOfAdmission()
	{
		return this.sourceofadmission;
	}
	public void setSourceOfAdmission(ims.core.vo.lookups.SourceOfAdmission value)
	{
		this.isValidated = false;
		this.sourceofadmission = value;
	}
	public boolean getPasEventIsNotNull()
	{
		return this.pasevent != null;
	}
	public ims.RefMan.vo.PasEventForClinicalCodingWorklistVo getPasEvent()
	{
		return this.pasevent;
	}
	public void setPasEvent(ims.RefMan.vo.PasEventForClinicalCodingWorklistVo value)
	{
		this.isValidated = false;
		this.pasevent = value;
	}
	public boolean getDischargeEpisodeIsNotNull()
	{
		return this.dischargeepisode != null;
	}
	public ims.RefMan.vo.DischargedEpisodeForReferralExternalCodingVo getDischargeEpisode()
	{
		return this.dischargeepisode;
	}
	public void setDischargeEpisode(ims.RefMan.vo.DischargedEpisodeForReferralExternalCodingVo value)
	{
		this.isValidated = false;
		this.dischargeepisode = value;
	}
	public boolean getCodingCommentsIsNotNull()
	{
		return this.codingcomments != null;
	}
	public ims.clinical.vo.CodingCommentVoCollection getCodingComments()
	{
		return this.codingcomments;
	}
	public void setCodingComments(ims.clinical.vo.CodingCommentVoCollection value)
	{
		this.isValidated = false;
		this.codingcomments = value;
	}
	public boolean getInpatientEpisodeIsNotNull()
	{
		return this.inpatientepisode != null;
	}
	public ims.core.admin.pas.vo.InpatientEpisodeRefVo getInpatientEpisode()
	{
		return this.inpatientepisode;
	}
	public void setInpatientEpisode(ims.core.admin.pas.vo.InpatientEpisodeRefVo value)
	{
		this.isValidated = false;
		this.inpatientepisode = value;
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
		if(this.awaitinghistology != null)
		{
			if(!this.awaitinghistology.isValidated())
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
		if(this.awaitinghistology != null)
		{
			String[] listOfOtherErrors = this.awaitinghistology.validate();
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
	
		AdmissionDetailWithConsultantStaysForCodingVo clone = new AdmissionDetailWithConsultantStaysForCodingVo(this.id, this.version);
		
		if(this.admissiondatetime == null)
			clone.admissiondatetime = null;
		else
			clone.admissiondatetime = (ims.framework.utils.DateTime)this.admissiondatetime.clone();
		if(this.consultantstays == null)
			clone.consultantstays = null;
		else
			clone.consultantstays = (ims.RefMan.vo.ConsultantStayForPatientCodingListVoCollection)this.consultantstays.clone();
		if(this.awaitinghistology == null)
			clone.awaitinghistology = null;
		else
			clone.awaitinghistology = (ims.RefMan.vo.AwaitingHistologyVoCollection)this.awaitinghistology.clone();
		clone.los = this.los;
		if(this.codingstatus == null)
			clone.codingstatus = null;
		else
			clone.codingstatus = (ims.core.vo.lookups.CodingStatus)this.codingstatus.clone();
		if(this.sourceofadmission == null)
			clone.sourceofadmission = null;
		else
			clone.sourceofadmission = (ims.core.vo.lookups.SourceOfAdmission)this.sourceofadmission.clone();
		if(this.pasevent == null)
			clone.pasevent = null;
		else
			clone.pasevent = (ims.RefMan.vo.PasEventForClinicalCodingWorklistVo)this.pasevent.clone();
		if(this.dischargeepisode == null)
			clone.dischargeepisode = null;
		else
			clone.dischargeepisode = (ims.RefMan.vo.DischargedEpisodeForReferralExternalCodingVo)this.dischargeepisode.clone();
		if(this.codingcomments == null)
			clone.codingcomments = null;
		else
			clone.codingcomments = (ims.clinical.vo.CodingCommentVoCollection)this.codingcomments.clone();
		clone.inpatientepisode = this.inpatientepisode;
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
		if (!(AdmissionDetailWithConsultantStaysForCodingVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AdmissionDetailWithConsultantStaysForCodingVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((AdmissionDetailWithConsultantStaysForCodingVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((AdmissionDetailWithConsultantStaysForCodingVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.admissiondatetime != null)
			count++;
		if(this.consultantstays != null)
			count++;
		if(this.awaitinghistology != null)
			count++;
		if(this.los != null)
			count++;
		if(this.codingstatus != null)
			count++;
		if(this.sourceofadmission != null)
			count++;
		if(this.pasevent != null)
			count++;
		if(this.dischargeepisode != null)
			count++;
		if(this.codingcomments != null)
			count++;
		if(this.inpatientepisode != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 10;
	}
	protected ims.framework.utils.DateTime admissiondatetime;
	protected ims.RefMan.vo.ConsultantStayForPatientCodingListVoCollection consultantstays;
	protected ims.RefMan.vo.AwaitingHistologyVoCollection awaitinghistology;
	protected Integer los;
	protected ims.core.vo.lookups.CodingStatus codingstatus;
	protected ims.core.vo.lookups.SourceOfAdmission sourceofadmission;
	protected ims.RefMan.vo.PasEventForClinicalCodingWorklistVo pasevent;
	protected ims.RefMan.vo.DischargedEpisodeForReferralExternalCodingVo dischargeepisode;
	protected ims.clinical.vo.CodingCommentVoCollection codingcomments;
	protected ims.core.admin.pas.vo.InpatientEpisodeRefVo inpatientepisode;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
