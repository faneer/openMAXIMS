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
 * Linked to RefMan.PreAssessmentOutcome business object (ID: 1096100083).
 */
public class PreAssessmentOutcomeForWorklistVo extends ims.RefMan.vo.PreAssessmentOutcomeRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PreAssessmentOutcomeForWorklistVo()
	{
	}
	public PreAssessmentOutcomeForWorklistVo(Integer id, int version)
	{
		super(id, version);
	}
	public PreAssessmentOutcomeForWorklistVo(ims.RefMan.vo.beans.PreAssessmentOutcomeForWorklistVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.waitingfordetails = ims.RefMan.vo.PreAssessmentInformationVoCollection.buildFromBeanCollection(bean.getWaitingForDetails());
		this.fittoproceed = bean.getFitToProceed();
		this.detailsoutstanding = bean.getDetailsOutstanding();
		this.preassessmentappointment = bean.getPreAssessmentAppointment() == null ? null : bean.getPreAssessmentAppointment().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.PreAssessmentOutcomeForWorklistVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.waitingfordetails = ims.RefMan.vo.PreAssessmentInformationVoCollection.buildFromBeanCollection(bean.getWaitingForDetails());
		this.fittoproceed = bean.getFitToProceed();
		this.detailsoutstanding = bean.getDetailsOutstanding();
		this.preassessmentappointment = bean.getPreAssessmentAppointment() == null ? null : bean.getPreAssessmentAppointment().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.PreAssessmentOutcomeForWorklistVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.PreAssessmentOutcomeForWorklistVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.PreAssessmentOutcomeForWorklistVoBean();
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
		if(fieldName.equals("WAITINGFORDETAILS"))
			return getWaitingForDetails();
		if(fieldName.equals("FITTOPROCEED"))
			return getFitToProceed();
		if(fieldName.equals("DETAILSOUTSTANDING"))
			return getDetailsOutstanding();
		if(fieldName.equals("PREASSESSMENTAPPOINTMENT"))
			return getPreAssessmentAppointment();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getWaitingForDetailsIsNotNull()
	{
		return this.waitingfordetails != null;
	}
	public ims.RefMan.vo.PreAssessmentInformationVoCollection getWaitingForDetails()
	{
		return this.waitingfordetails;
	}
	public void setWaitingForDetails(ims.RefMan.vo.PreAssessmentInformationVoCollection value)
	{
		this.isValidated = false;
		this.waitingfordetails = value;
	}
	public boolean getFitToProceedIsNotNull()
	{
		return this.fittoproceed != null;
	}
	public Boolean getFitToProceed()
	{
		return this.fittoproceed;
	}
	public void setFitToProceed(Boolean value)
	{
		this.isValidated = false;
		this.fittoproceed = value;
	}
	public boolean getDetailsOutstandingIsNotNull()
	{
		return this.detailsoutstanding != null;
	}
	public Boolean getDetailsOutstanding()
	{
		return this.detailsoutstanding;
	}
	public void setDetailsOutstanding(Boolean value)
	{
		this.isValidated = false;
		this.detailsoutstanding = value;
	}
	public boolean getPreAssessmentAppointmentIsNotNull()
	{
		return this.preassessmentappointment != null;
	}
	public ims.RefMan.vo.BookAppointmentForPreAssessmentWorklistVo getPreAssessmentAppointment()
	{
		return this.preassessmentappointment;
	}
	public void setPreAssessmentAppointment(ims.RefMan.vo.BookAppointmentForPreAssessmentWorklistVo value)
	{
		this.isValidated = false;
		this.preassessmentappointment = value;
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
	
		PreAssessmentOutcomeForWorklistVo clone = new PreAssessmentOutcomeForWorklistVo(this.id, this.version);
		
		if(this.waitingfordetails == null)
			clone.waitingfordetails = null;
		else
			clone.waitingfordetails = (ims.RefMan.vo.PreAssessmentInformationVoCollection)this.waitingfordetails.clone();
		clone.fittoproceed = this.fittoproceed;
		clone.detailsoutstanding = this.detailsoutstanding;
		if(this.preassessmentappointment == null)
			clone.preassessmentappointment = null;
		else
			clone.preassessmentappointment = (ims.RefMan.vo.BookAppointmentForPreAssessmentWorklistVo)this.preassessmentappointment.clone();
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
		if (!(PreAssessmentOutcomeForWorklistVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PreAssessmentOutcomeForWorklistVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PreAssessmentOutcomeForWorklistVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PreAssessmentOutcomeForWorklistVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.waitingfordetails != null)
			count++;
		if(this.fittoproceed != null)
			count++;
		if(this.detailsoutstanding != null)
			count++;
		if(this.preassessmentappointment != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.RefMan.vo.PreAssessmentInformationVoCollection waitingfordetails;
	protected Boolean fittoproceed;
	protected Boolean detailsoutstanding;
	protected ims.RefMan.vo.BookAppointmentForPreAssessmentWorklistVo preassessmentappointment;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
