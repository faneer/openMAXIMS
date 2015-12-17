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
public class AdmissionDetailForPatientCodingListVo extends ims.core.admin.pas.vo.AdmissionDetailRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AdmissionDetailForPatientCodingListVo()
	{
	}
	public AdmissionDetailForPatientCodingListVo(Integer id, int version)
	{
		super(id, version);
	}
	public AdmissionDetailForPatientCodingListVo(ims.RefMan.vo.beans.AdmissionDetailForPatientCodingListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.pasevent = bean.getPasEvent() == null ? null : bean.getPasEvent().buildVo();
		this.admissiondatetime = bean.getAdmissionDateTime() == null ? null : bean.getAdmissionDateTime().buildDateTime();
		this.ward = bean.getWard() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getWard().getId()), bean.getWard().getVersion());
		this.consultant = bean.getConsultant() == null ? null : new ims.core.resource.people.vo.MedicRefVo(new Integer(bean.getConsultant().getId()), bean.getConsultant().getVersion());
		this.wardtype = bean.getWardType() == null ? null : ims.core.vo.lookups.WardType.buildLookup(bean.getWardType());
		this.estdischargedate = bean.getEstDischargeDate() == null ? null : bean.getEstDischargeDate().buildDateTime();
		this.admissiontransactiondatetime = bean.getAdmissionTransactionDateTime() == null ? null : bean.getAdmissionTransactionDateTime().buildDateTime();
		this.codingstatus = bean.getCodingStatus() == null ? null : ims.core.vo.lookups.CodingStatus.buildLookup(bean.getCodingStatus());
		this.codingcomments = ims.clinical.vo.CodingCommentVoCollection.buildFromBeanCollection(bean.getCodingComments());
		this.awaitinghistology = ims.RefMan.vo.AwaitingHistologyForPatientCodingListVoCollection.buildFromBeanCollection(bean.getAwaitingHistology());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.AdmissionDetailForPatientCodingListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.pasevent = bean.getPasEvent() == null ? null : bean.getPasEvent().buildVo(map);
		this.admissiondatetime = bean.getAdmissionDateTime() == null ? null : bean.getAdmissionDateTime().buildDateTime();
		this.ward = bean.getWard() == null ? null : new ims.core.resource.place.vo.LocationRefVo(new Integer(bean.getWard().getId()), bean.getWard().getVersion());
		this.consultant = bean.getConsultant() == null ? null : new ims.core.resource.people.vo.MedicRefVo(new Integer(bean.getConsultant().getId()), bean.getConsultant().getVersion());
		this.wardtype = bean.getWardType() == null ? null : ims.core.vo.lookups.WardType.buildLookup(bean.getWardType());
		this.estdischargedate = bean.getEstDischargeDate() == null ? null : bean.getEstDischargeDate().buildDateTime();
		this.admissiontransactiondatetime = bean.getAdmissionTransactionDateTime() == null ? null : bean.getAdmissionTransactionDateTime().buildDateTime();
		this.codingstatus = bean.getCodingStatus() == null ? null : ims.core.vo.lookups.CodingStatus.buildLookup(bean.getCodingStatus());
		this.codingcomments = ims.clinical.vo.CodingCommentVoCollection.buildFromBeanCollection(bean.getCodingComments());
		this.awaitinghistology = ims.RefMan.vo.AwaitingHistologyForPatientCodingListVoCollection.buildFromBeanCollection(bean.getAwaitingHistology());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.AdmissionDetailForPatientCodingListVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.AdmissionDetailForPatientCodingListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.AdmissionDetailForPatientCodingListVoBean();
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
		if(fieldName.equals("ADMISSIONDATETIME"))
			return getAdmissionDateTime();
		if(fieldName.equals("WARD"))
			return getWard();
		if(fieldName.equals("CONSULTANT"))
			return getConsultant();
		if(fieldName.equals("WARDTYPE"))
			return getWardType();
		if(fieldName.equals("ESTDISCHARGEDATE"))
			return getEstDischargeDate();
		if(fieldName.equals("ADMISSIONTRANSACTIONDATETIME"))
			return getAdmissionTransactionDateTime();
		if(fieldName.equals("CODINGSTATUS"))
			return getCodingStatus();
		if(fieldName.equals("CODINGCOMMENTS"))
			return getCodingComments();
		if(fieldName.equals("AWAITINGHISTOLOGY"))
			return getAwaitingHistology();
		return super.getFieldValueByFieldName(fieldName);
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
	public boolean getWardIsNotNull()
	{
		return this.ward != null;
	}
	public ims.core.resource.place.vo.LocationRefVo getWard()
	{
		return this.ward;
	}
	public void setWard(ims.core.resource.place.vo.LocationRefVo value)
	{
		this.isValidated = false;
		this.ward = value;
	}
	public boolean getConsultantIsNotNull()
	{
		return this.consultant != null;
	}
	public ims.core.resource.people.vo.MedicRefVo getConsultant()
	{
		return this.consultant;
	}
	public void setConsultant(ims.core.resource.people.vo.MedicRefVo value)
	{
		this.isValidated = false;
		this.consultant = value;
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
	public boolean getEstDischargeDateIsNotNull()
	{
		return this.estdischargedate != null;
	}
	public ims.framework.utils.DateTime getEstDischargeDate()
	{
		return this.estdischargedate;
	}
	public void setEstDischargeDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.estdischargedate = value;
	}
	public boolean getAdmissionTransactionDateTimeIsNotNull()
	{
		return this.admissiontransactiondatetime != null;
	}
	public ims.framework.utils.DateTime getAdmissionTransactionDateTime()
	{
		return this.admissiontransactiondatetime;
	}
	public void setAdmissionTransactionDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.admissiontransactiondatetime = value;
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
	public boolean getAwaitingHistologyIsNotNull()
	{
		return this.awaitinghistology != null;
	}
	public ims.RefMan.vo.AwaitingHistologyForPatientCodingListVoCollection getAwaitingHistology()
	{
		return this.awaitinghistology;
	}
	public void setAwaitingHistology(ims.RefMan.vo.AwaitingHistologyForPatientCodingListVoCollection value)
	{
		this.isValidated = false;
		this.awaitinghistology = value;
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
		if(this.codingcomments != null)
		{
			if(!this.codingcomments.isValidated())
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
		if(this.codingcomments != null)
		{
			String[] listOfOtherErrors = this.codingcomments.validate();
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
	
		AdmissionDetailForPatientCodingListVo clone = new AdmissionDetailForPatientCodingListVo(this.id, this.version);
		
		if(this.pasevent == null)
			clone.pasevent = null;
		else
			clone.pasevent = (ims.RefMan.vo.PasEventForClinicalCodingWorklistVo)this.pasevent.clone();
		if(this.admissiondatetime == null)
			clone.admissiondatetime = null;
		else
			clone.admissiondatetime = (ims.framework.utils.DateTime)this.admissiondatetime.clone();
		clone.ward = this.ward;
		clone.consultant = this.consultant;
		if(this.wardtype == null)
			clone.wardtype = null;
		else
			clone.wardtype = (ims.core.vo.lookups.WardType)this.wardtype.clone();
		if(this.estdischargedate == null)
			clone.estdischargedate = null;
		else
			clone.estdischargedate = (ims.framework.utils.DateTime)this.estdischargedate.clone();
		if(this.admissiontransactiondatetime == null)
			clone.admissiontransactiondatetime = null;
		else
			clone.admissiontransactiondatetime = (ims.framework.utils.DateTime)this.admissiontransactiondatetime.clone();
		if(this.codingstatus == null)
			clone.codingstatus = null;
		else
			clone.codingstatus = (ims.core.vo.lookups.CodingStatus)this.codingstatus.clone();
		if(this.codingcomments == null)
			clone.codingcomments = null;
		else
			clone.codingcomments = (ims.clinical.vo.CodingCommentVoCollection)this.codingcomments.clone();
		if(this.awaitinghistology == null)
			clone.awaitinghistology = null;
		else
			clone.awaitinghistology = (ims.RefMan.vo.AwaitingHistologyForPatientCodingListVoCollection)this.awaitinghistology.clone();
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
		if (!(AdmissionDetailForPatientCodingListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AdmissionDetailForPatientCodingListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((AdmissionDetailForPatientCodingListVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((AdmissionDetailForPatientCodingListVo)obj).getBoId());
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
		if(this.admissiondatetime != null)
			count++;
		if(this.ward != null)
			count++;
		if(this.consultant != null)
			count++;
		if(this.wardtype != null)
			count++;
		if(this.estdischargedate != null)
			count++;
		if(this.admissiontransactiondatetime != null)
			count++;
		if(this.codingstatus != null)
			count++;
		if(this.codingcomments != null)
			count++;
		if(this.awaitinghistology != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 10;
	}
	protected ims.RefMan.vo.PasEventForClinicalCodingWorklistVo pasevent;
	protected ims.framework.utils.DateTime admissiondatetime;
	protected ims.core.resource.place.vo.LocationRefVo ward;
	protected ims.core.resource.people.vo.MedicRefVo consultant;
	protected ims.core.vo.lookups.WardType wardtype;
	protected ims.framework.utils.DateTime estdischargedate;
	protected ims.framework.utils.DateTime admissiontransactiondatetime;
	protected ims.core.vo.lookups.CodingStatus codingstatus;
	protected ims.clinical.vo.CodingCommentVoCollection codingcomments;
	protected ims.RefMan.vo.AwaitingHistologyForPatientCodingListVoCollection awaitinghistology;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
