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

package ims.emergency.vo;

/**
 * Linked to core.configuration.EDSuppSummarySchedule business object (ID: 1028100091).
 */
public class EDSuppSummaryScheduleVo extends ims.core.configuration.vo.EDSuppSummaryScheduleRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public EDSuppSummaryScheduleVo()
	{
	}
	public EDSuppSummaryScheduleVo(Integer id, int version)
	{
		super(id, version);
	}
	public EDSuppSummaryScheduleVo(ims.emergency.vo.beans.EDSuppSummaryScheduleVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.generatedlettersno = bean.getGeneratedLettersNo();
		this.printagentto = bean.getPrintAgentTo();
		this.successfulemailsno = bean.getSuccessfulEmailsNo();
		this.failedemailsno = bean.getFailedEmailsNo();
		this.printedlettersno = bean.getPrintedLettersNo();
		this.configuredjobdetails = bean.getConfiguredJobDetails() == null ? null : new ims.core.configuration.vo.ConfiguredJobRefVo(new Integer(bean.getConfiguredJobDetails().getId()), bean.getConfiguredJobDetails().getVersion());
		this.systeminformation = bean.getSystemInformation() == null ? null : bean.getSystemInformation().buildSystemInformation();
		this.printlettersonly = bean.getPrintLettersOnly();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.EDSuppSummaryScheduleVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.generatedlettersno = bean.getGeneratedLettersNo();
		this.printagentto = bean.getPrintAgentTo();
		this.successfulemailsno = bean.getSuccessfulEmailsNo();
		this.failedemailsno = bean.getFailedEmailsNo();
		this.printedlettersno = bean.getPrintedLettersNo();
		this.configuredjobdetails = bean.getConfiguredJobDetails() == null ? null : new ims.core.configuration.vo.ConfiguredJobRefVo(new Integer(bean.getConfiguredJobDetails().getId()), bean.getConfiguredJobDetails().getVersion());
		this.systeminformation = bean.getSystemInformation() == null ? null : bean.getSystemInformation().buildSystemInformation();
		this.printlettersonly = bean.getPrintLettersOnly();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.EDSuppSummaryScheduleVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.EDSuppSummaryScheduleVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.EDSuppSummaryScheduleVoBean();
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
		if(fieldName.equals("GENERATEDLETTERSNO"))
			return getGeneratedLettersNo();
		if(fieldName.equals("PRINTAGENTTO"))
			return getPrintAgentTo();
		if(fieldName.equals("SUCCESSFULEMAILSNO"))
			return getSuccessfulEmailsNo();
		if(fieldName.equals("FAILEDEMAILSNO"))
			return getFailedEmailsNo();
		if(fieldName.equals("PRINTEDLETTERSNO"))
			return getPrintedLettersNo();
		if(fieldName.equals("CONFIGUREDJOBDETAILS"))
			return getConfiguredJobDetails();
		if(fieldName.equals("SYSTEMINFORMATION"))
			return getSystemInformation();
		if(fieldName.equals("PRINTLETTERSONLY"))
			return getPrintLettersOnly();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getGeneratedLettersNoIsNotNull()
	{
		return this.generatedlettersno != null;
	}
	public Integer getGeneratedLettersNo()
	{
		return this.generatedlettersno;
	}
	public void setGeneratedLettersNo(Integer value)
	{
		this.isValidated = false;
		this.generatedlettersno = value;
	}
	public boolean getPrintAgentToIsNotNull()
	{
		return this.printagentto != null;
	}
	public String getPrintAgentTo()
	{
		return this.printagentto;
	}
	public static int getPrintAgentToMaxLength()
	{
		return 500;
	}
	public void setPrintAgentTo(String value)
	{
		this.isValidated = false;
		this.printagentto = value;
	}
	public boolean getSuccessfulEmailsNoIsNotNull()
	{
		return this.successfulemailsno != null;
	}
	public Integer getSuccessfulEmailsNo()
	{
		return this.successfulemailsno;
	}
	public void setSuccessfulEmailsNo(Integer value)
	{
		this.isValidated = false;
		this.successfulemailsno = value;
	}
	public boolean getFailedEmailsNoIsNotNull()
	{
		return this.failedemailsno != null;
	}
	public Integer getFailedEmailsNo()
	{
		return this.failedemailsno;
	}
	public void setFailedEmailsNo(Integer value)
	{
		this.isValidated = false;
		this.failedemailsno = value;
	}
	public boolean getPrintedLettersNoIsNotNull()
	{
		return this.printedlettersno != null;
	}
	public Integer getPrintedLettersNo()
	{
		return this.printedlettersno;
	}
	public void setPrintedLettersNo(Integer value)
	{
		this.isValidated = false;
		this.printedlettersno = value;
	}
	public boolean getConfiguredJobDetailsIsNotNull()
	{
		return this.configuredjobdetails != null;
	}
	public ims.core.configuration.vo.ConfiguredJobRefVo getConfiguredJobDetails()
	{
		return this.configuredjobdetails;
	}
	public void setConfiguredJobDetails(ims.core.configuration.vo.ConfiguredJobRefVo value)
	{
		this.isValidated = false;
		this.configuredjobdetails = value;
	}
	public boolean getSystemInformationIsNotNull()
	{
		return this.systeminformation != null;
	}
	public ims.vo.SystemInformation getSystemInformation()
	{
		return this.systeminformation;
	}
	public void setSystemInformation(ims.vo.SystemInformation value)
	{
		this.isValidated = false;
		this.systeminformation = value;
	}
	public boolean getPrintLettersOnlyIsNotNull()
	{
		return this.printlettersonly != null;
	}
	public Boolean getPrintLettersOnly()
	{
		return this.printlettersonly;
	}
	public void setPrintLettersOnly(Boolean value)
	{
		this.isValidated = false;
		this.printlettersonly = value;
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
		if(this.printagentto != null)
			if(this.printagentto.length() > 500)
				listOfErrors.add("The length of the field [printagentto] in the value object [ims.emergency.vo.EDSuppSummaryScheduleVo] is too big. It should be less or equal to 500");
		if(this.configuredjobdetails == null)
			listOfErrors.add("ConfiguredJobDetails is mandatory");
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
	
		EDSuppSummaryScheduleVo clone = new EDSuppSummaryScheduleVo(this.id, this.version);
		
		clone.generatedlettersno = this.generatedlettersno;
		clone.printagentto = this.printagentto;
		clone.successfulemailsno = this.successfulemailsno;
		clone.failedemailsno = this.failedemailsno;
		clone.printedlettersno = this.printedlettersno;
		clone.configuredjobdetails = this.configuredjobdetails;
		if(this.systeminformation == null)
			clone.systeminformation = null;
		else
			clone.systeminformation = (ims.vo.SystemInformation)this.systeminformation.clone();
		clone.printlettersonly = this.printlettersonly;
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
		if (!(EDSuppSummaryScheduleVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A EDSuppSummaryScheduleVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((EDSuppSummaryScheduleVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((EDSuppSummaryScheduleVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.generatedlettersno != null)
			count++;
		if(this.printagentto != null)
			count++;
		if(this.successfulemailsno != null)
			count++;
		if(this.failedemailsno != null)
			count++;
		if(this.printedlettersno != null)
			count++;
		if(this.configuredjobdetails != null)
			count++;
		if(this.systeminformation != null)
			count++;
		if(this.printlettersonly != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 8;
	}
	protected Integer generatedlettersno;
	protected String printagentto;
	protected Integer successfulemailsno;
	protected Integer failedemailsno;
	protected Integer printedlettersno;
	protected ims.core.configuration.vo.ConfiguredJobRefVo configuredjobdetails;
	protected ims.vo.SystemInformation systeminformation;
	protected Boolean printlettersonly;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
