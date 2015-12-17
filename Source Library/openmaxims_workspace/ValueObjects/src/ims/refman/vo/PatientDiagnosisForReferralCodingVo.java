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
 * Linked to core.clinical.PatientDiagnosis business object (ID: 1003100016).
 */
public class PatientDiagnosisForReferralCodingVo extends ims.core.clinical.vo.PatientDiagnosisRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PatientDiagnosisForReferralCodingVo()
	{
	}
	public PatientDiagnosisForReferralCodingVo(Integer id, int version)
	{
		super(id, version);
	}
	public PatientDiagnosisForReferralCodingVo(ims.RefMan.vo.beans.PatientDiagnosisForReferralCodingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.diagnosis = bean.getDiagnosis() == null ? null : bean.getDiagnosis().buildVo();
		this.diagnosisdescription = bean.getDiagnosisDescription();
		this.diagnoseddate = bean.getDiagnosedDate() == null ? null : bean.getDiagnosedDate().buildPartialDate();
		this.primaryforcarespells = ims.RefMan.vo.CSPrimaryDiagnosisForReferralCodingVoCollection.buildFromBeanCollection(bean.getPrimaryForCareSpells());
		this.ispmh = bean.getIsPMH();
		this.authoringinfo = bean.getAuthoringInfo() == null ? null : bean.getAuthoringInfo().buildVo();
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo();
		this.diaglaterality = bean.getDiagLaterality() == null ? null : ims.core.vo.lookups.LateralityLRB.buildLookup(bean.getDiagLaterality());
		this.diagnosedonadmission = bean.getDiagnosedOnAdmission();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.PatientDiagnosisForReferralCodingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.diagnosis = bean.getDiagnosis() == null ? null : bean.getDiagnosis().buildVo(map);
		this.diagnosisdescription = bean.getDiagnosisDescription();
		this.diagnoseddate = bean.getDiagnosedDate() == null ? null : bean.getDiagnosedDate().buildPartialDate();
		this.primaryforcarespells = ims.RefMan.vo.CSPrimaryDiagnosisForReferralCodingVoCollection.buildFromBeanCollection(bean.getPrimaryForCareSpells());
		this.ispmh = bean.getIsPMH();
		this.authoringinfo = bean.getAuthoringInfo() == null ? null : bean.getAuthoringInfo().buildVo(map);
		this.currentstatus = bean.getCurrentStatus() == null ? null : bean.getCurrentStatus().buildVo(map);
		this.diaglaterality = bean.getDiagLaterality() == null ? null : ims.core.vo.lookups.LateralityLRB.buildLookup(bean.getDiagLaterality());
		this.diagnosedonadmission = bean.getDiagnosedOnAdmission();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.PatientDiagnosisForReferralCodingVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.PatientDiagnosisForReferralCodingVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.PatientDiagnosisForReferralCodingVoBean();
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
		if(fieldName.equals("DIAGNOSIS"))
			return getDiagnosis();
		if(fieldName.equals("DIAGNOSISDESCRIPTION"))
			return getDiagnosisDescription();
		if(fieldName.equals("DIAGNOSEDDATE"))
			return getDiagnosedDate();
		if(fieldName.equals("PRIMARYFORCARESPELLS"))
			return getPrimaryForCareSpells();
		if(fieldName.equals("ISPMH"))
			return getIsPMH();
		if(fieldName.equals("AUTHORINGINFO"))
			return getAuthoringInfo();
		if(fieldName.equals("CURRENTSTATUS"))
			return getCurrentStatus();
		if(fieldName.equals("DIAGLATERALITY"))
			return getDiagLaterality();
		if(fieldName.equals("DIAGNOSEDONADMISSION"))
			return getDiagnosedOnAdmission();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getDiagnosisIsNotNull()
	{
		return this.diagnosis != null;
	}
	public ims.core.vo.DiagnosisVo getDiagnosis()
	{
		return this.diagnosis;
	}
	public void setDiagnosis(ims.core.vo.DiagnosisVo value)
	{
		this.isValidated = false;
		this.diagnosis = value;
	}
	public boolean getDiagnosisDescriptionIsNotNull()
	{
		return this.diagnosisdescription != null;
	}
	public String getDiagnosisDescription()
	{
		return this.diagnosisdescription;
	}
	public static int getDiagnosisDescriptionMaxLength()
	{
		return 255;
	}
	public void setDiagnosisDescription(String value)
	{
		this.isValidated = false;
		this.diagnosisdescription = value;
	}
	public boolean getDiagnosedDateIsNotNull()
	{
		return this.diagnoseddate != null;
	}
	public ims.framework.utils.PartialDate getDiagnosedDate()
	{
		return this.diagnoseddate;
	}
	public void setDiagnosedDate(ims.framework.utils.PartialDate value)
	{
		this.isValidated = false;
		this.diagnoseddate = value;
	}
	public boolean getPrimaryForCareSpellsIsNotNull()
	{
		return this.primaryforcarespells != null;
	}
	public ims.RefMan.vo.CSPrimaryDiagnosisForReferralCodingVoCollection getPrimaryForCareSpells()
	{
		return this.primaryforcarespells;
	}
	public void setPrimaryForCareSpells(ims.RefMan.vo.CSPrimaryDiagnosisForReferralCodingVoCollection value)
	{
		this.isValidated = false;
		this.primaryforcarespells = value;
	}
	public boolean getIsPMHIsNotNull()
	{
		return this.ispmh != null;
	}
	public Boolean getIsPMH()
	{
		return this.ispmh;
	}
	public void setIsPMH(Boolean value)
	{
		this.isValidated = false;
		this.ispmh = value;
	}
	public boolean getAuthoringInfoIsNotNull()
	{
		return this.authoringinfo != null;
	}
	public ims.core.vo.AuthoringInformationVo getAuthoringInfo()
	{
		return this.authoringinfo;
	}
	public void setAuthoringInfo(ims.core.vo.AuthoringInformationVo value)
	{
		this.isValidated = false;
		this.authoringinfo = value;
	}
	public boolean getCurrentStatusIsNotNull()
	{
		return this.currentstatus != null;
	}
	public ims.RefMan.vo.PatientDiagnosisStatusForReferralCodingVo getCurrentStatus()
	{
		return this.currentstatus;
	}
	public void setCurrentStatus(ims.RefMan.vo.PatientDiagnosisStatusForReferralCodingVo value)
	{
		this.isValidated = false;
		this.currentstatus = value;
	}
	public boolean getDiagLateralityIsNotNull()
	{
		return this.diaglaterality != null;
	}
	public ims.core.vo.lookups.LateralityLRB getDiagLaterality()
	{
		return this.diaglaterality;
	}
	public void setDiagLaterality(ims.core.vo.lookups.LateralityLRB value)
	{
		this.isValidated = false;
		this.diaglaterality = value;
	}
	public boolean getDiagnosedOnAdmissionIsNotNull()
	{
		return this.diagnosedonadmission != null;
	}
	public Boolean getDiagnosedOnAdmission()
	{
		return this.diagnosedonadmission;
	}
	public void setDiagnosedOnAdmission(Boolean value)
	{
		this.isValidated = false;
		this.diagnosedonadmission = value;
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
		if(this.diagnosisdescription == null || this.diagnosisdescription.length() == 0)
			listOfErrors.add("DiagnosisDescription is mandatory");
		else if(this.diagnosisdescription.length() > 255)
			listOfErrors.add("The length of the field [diagnosisdescription] in the value object [ims.RefMan.vo.PatientDiagnosisForReferralCodingVo] is too big. It should be less or equal to 255");
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
	
		PatientDiagnosisForReferralCodingVo clone = new PatientDiagnosisForReferralCodingVo(this.id, this.version);
		
		if(this.diagnosis == null)
			clone.diagnosis = null;
		else
			clone.diagnosis = (ims.core.vo.DiagnosisVo)this.diagnosis.clone();
		clone.diagnosisdescription = this.diagnosisdescription;
		if(this.diagnoseddate == null)
			clone.diagnoseddate = null;
		else
			clone.diagnoseddate = (ims.framework.utils.PartialDate)this.diagnoseddate.clone();
		if(this.primaryforcarespells == null)
			clone.primaryforcarespells = null;
		else
			clone.primaryforcarespells = (ims.RefMan.vo.CSPrimaryDiagnosisForReferralCodingVoCollection)this.primaryforcarespells.clone();
		clone.ispmh = this.ispmh;
		if(this.authoringinfo == null)
			clone.authoringinfo = null;
		else
			clone.authoringinfo = (ims.core.vo.AuthoringInformationVo)this.authoringinfo.clone();
		if(this.currentstatus == null)
			clone.currentstatus = null;
		else
			clone.currentstatus = (ims.RefMan.vo.PatientDiagnosisStatusForReferralCodingVo)this.currentstatus.clone();
		if(this.diaglaterality == null)
			clone.diaglaterality = null;
		else
			clone.diaglaterality = (ims.core.vo.lookups.LateralityLRB)this.diaglaterality.clone();
		clone.diagnosedonadmission = this.diagnosedonadmission;
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
		if (!(PatientDiagnosisForReferralCodingVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PatientDiagnosisForReferralCodingVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PatientDiagnosisForReferralCodingVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PatientDiagnosisForReferralCodingVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.diagnosis != null)
			count++;
		if(this.diagnosisdescription != null)
			count++;
		if(this.diagnoseddate != null)
			count++;
		if(this.primaryforcarespells != null)
			count++;
		if(this.ispmh != null)
			count++;
		if(this.authoringinfo != null)
			count++;
		if(this.currentstatus != null)
			count++;
		if(this.diaglaterality != null)
			count++;
		if(this.diagnosedonadmission != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 9;
	}
	protected ims.core.vo.DiagnosisVo diagnosis;
	protected String diagnosisdescription;
	protected ims.framework.utils.PartialDate diagnoseddate;
	protected ims.RefMan.vo.CSPrimaryDiagnosisForReferralCodingVoCollection primaryforcarespells;
	protected Boolean ispmh;
	protected ims.core.vo.AuthoringInformationVo authoringinfo;
	protected ims.RefMan.vo.PatientDiagnosisStatusForReferralCodingVo currentstatus;
	protected ims.core.vo.lookups.LateralityLRB diaglaterality;
	protected Boolean diagnosedonadmission;
	private boolean isValidated = false;
	private boolean isBusy = false;
}