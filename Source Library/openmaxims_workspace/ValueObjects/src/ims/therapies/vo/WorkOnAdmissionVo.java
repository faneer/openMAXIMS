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

package ims.therapies.vo;

/**
 * Linked to therapies.workLeisureDriving.WorkOnAdmission business object (ID: 1019100078).
 */
public class WorkOnAdmissionVo extends ims.therapies.workleisuredriving.vo.WorkOnAdmissionRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public WorkOnAdmissionVo()
	{
	}
	public WorkOnAdmissionVo(Integer id, int version)
	{
		super(id, version);
	}
	public WorkOnAdmissionVo(ims.therapies.vo.beans.WorkOnAdmissionVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.authoringcp = bean.getAuthoringCP() == null ? null : bean.getAuthoringCP().buildVo();
		this.presentcareer = bean.getPresentCareer();
		this.pastqualifications = bean.getPastQualifications();
		this.employername = bean.getEmployerName();
		this.employeraddress = bean.getEmployerAddress();
		this.employerphone = bean.getEmployerPhone();
		this.benefitadvice = bean.getBenefitAdvice();
		this.worksiteassessment = bean.getWorkSiteAssessment() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getWorkSiteAssessment());
		this.worksiteassesscomment = bean.getWorkSiteAssessComment();
		this.referdea = bean.getReferDEA() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getReferDEA());
		this.deacomment = bean.getDEAComment();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.therapies.vo.beans.WorkOnAdmissionVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.carecontext = bean.getCareContext() == null ? null : new ims.core.admin.vo.CareContextRefVo(new Integer(bean.getCareContext().getId()), bean.getCareContext().getVersion());
		this.authoringdatetime = bean.getAuthoringDateTime() == null ? null : bean.getAuthoringDateTime().buildDateTime();
		this.authoringcp = bean.getAuthoringCP() == null ? null : bean.getAuthoringCP().buildVo(map);
		this.presentcareer = bean.getPresentCareer();
		this.pastqualifications = bean.getPastQualifications();
		this.employername = bean.getEmployerName();
		this.employeraddress = bean.getEmployerAddress();
		this.employerphone = bean.getEmployerPhone();
		this.benefitadvice = bean.getBenefitAdvice();
		this.worksiteassessment = bean.getWorkSiteAssessment() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getWorkSiteAssessment());
		this.worksiteassesscomment = bean.getWorkSiteAssessComment();
		this.referdea = bean.getReferDEA() == null ? null : ims.core.vo.lookups.YesNoUnknown.buildLookup(bean.getReferDEA());
		this.deacomment = bean.getDEAComment();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.therapies.vo.beans.WorkOnAdmissionVoBean bean = null;
		if(map != null)
			bean = (ims.therapies.vo.beans.WorkOnAdmissionVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.therapies.vo.beans.WorkOnAdmissionVoBean();
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
		if(fieldName.equals("CARECONTEXT"))
			return getCareContext();
		if(fieldName.equals("AUTHORINGDATETIME"))
			return getAuthoringDateTime();
		if(fieldName.equals("AUTHORINGCP"))
			return getAuthoringCP();
		if(fieldName.equals("PRESENTCAREER"))
			return getPresentCareer();
		if(fieldName.equals("PASTQUALIFICATIONS"))
			return getPastQualifications();
		if(fieldName.equals("EMPLOYERNAME"))
			return getEmployerName();
		if(fieldName.equals("EMPLOYERADDRESS"))
			return getEmployerAddress();
		if(fieldName.equals("EMPLOYERPHONE"))
			return getEmployerPhone();
		if(fieldName.equals("BENEFITADVICE"))
			return getBenefitAdvice();
		if(fieldName.equals("WORKSITEASSESSMENT"))
			return getWorkSiteAssessment();
		if(fieldName.equals("WORKSITEASSESSCOMMENT"))
			return getWorkSiteAssessComment();
		if(fieldName.equals("REFERDEA"))
			return getReferDEA();
		if(fieldName.equals("DEACOMMENT"))
			return getDEAComment();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCareContextIsNotNull()
	{
		return this.carecontext != null;
	}
	public ims.core.admin.vo.CareContextRefVo getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.core.admin.vo.CareContextRefVo value)
	{
		this.isValidated = false;
		this.carecontext = value;
	}
	public boolean getAuthoringDateTimeIsNotNull()
	{
		return this.authoringdatetime != null;
	}
	public ims.framework.utils.DateTime getAuthoringDateTime()
	{
		return this.authoringdatetime;
	}
	public void setAuthoringDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.authoringdatetime = value;
	}
	public boolean getAuthoringCPIsNotNull()
	{
		return this.authoringcp != null;
	}
	public ims.core.vo.Hcp getAuthoringCP()
	{
		return this.authoringcp;
	}
	public void setAuthoringCP(ims.core.vo.Hcp value)
	{
		this.isValidated = false;
		this.authoringcp = value;
	}
	public boolean getPresentCareerIsNotNull()
	{
		return this.presentcareer != null;
	}
	public String getPresentCareer()
	{
		return this.presentcareer;
	}
	public static int getPresentCareerMaxLength()
	{
		return 1000;
	}
	public void setPresentCareer(String value)
	{
		this.isValidated = false;
		this.presentcareer = value;
	}
	public boolean getPastQualificationsIsNotNull()
	{
		return this.pastqualifications != null;
	}
	public String getPastQualifications()
	{
		return this.pastqualifications;
	}
	public static int getPastQualificationsMaxLength()
	{
		return 1000;
	}
	public void setPastQualifications(String value)
	{
		this.isValidated = false;
		this.pastqualifications = value;
	}
	public boolean getEmployerNameIsNotNull()
	{
		return this.employername != null;
	}
	public String getEmployerName()
	{
		return this.employername;
	}
	public static int getEmployerNameMaxLength()
	{
		return 100;
	}
	public void setEmployerName(String value)
	{
		this.isValidated = false;
		this.employername = value;
	}
	public boolean getEmployerAddressIsNotNull()
	{
		return this.employeraddress != null;
	}
	public String getEmployerAddress()
	{
		return this.employeraddress;
	}
	public static int getEmployerAddressMaxLength()
	{
		return 1000;
	}
	public void setEmployerAddress(String value)
	{
		this.isValidated = false;
		this.employeraddress = value;
	}
	public boolean getEmployerPhoneIsNotNull()
	{
		return this.employerphone != null;
	}
	public String getEmployerPhone()
	{
		return this.employerphone;
	}
	public static int getEmployerPhoneMaxLength()
	{
		return 50;
	}
	public void setEmployerPhone(String value)
	{
		this.isValidated = false;
		this.employerphone = value;
	}
	public boolean getBenefitAdviceIsNotNull()
	{
		return this.benefitadvice != null;
	}
	public String getBenefitAdvice()
	{
		return this.benefitadvice;
	}
	public static int getBenefitAdviceMaxLength()
	{
		return 1000;
	}
	public void setBenefitAdvice(String value)
	{
		this.isValidated = false;
		this.benefitadvice = value;
	}
	public boolean getWorkSiteAssessmentIsNotNull()
	{
		return this.worksiteassessment != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getWorkSiteAssessment()
	{
		return this.worksiteassessment;
	}
	public void setWorkSiteAssessment(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.worksiteassessment = value;
	}
	public boolean getWorkSiteAssessCommentIsNotNull()
	{
		return this.worksiteassesscomment != null;
	}
	public String getWorkSiteAssessComment()
	{
		return this.worksiteassesscomment;
	}
	public static int getWorkSiteAssessCommentMaxLength()
	{
		return 1000;
	}
	public void setWorkSiteAssessComment(String value)
	{
		this.isValidated = false;
		this.worksiteassesscomment = value;
	}
	public boolean getReferDEAIsNotNull()
	{
		return this.referdea != null;
	}
	public ims.core.vo.lookups.YesNoUnknown getReferDEA()
	{
		return this.referdea;
	}
	public void setReferDEA(ims.core.vo.lookups.YesNoUnknown value)
	{
		this.isValidated = false;
		this.referdea = value;
	}
	public boolean getDEACommentIsNotNull()
	{
		return this.deacomment != null;
	}
	public String getDEAComment()
	{
		return this.deacomment;
	}
	public static int getDEACommentMaxLength()
	{
		return 1000;
	}
	public void setDEAComment(String value)
	{
		this.isValidated = false;
		this.deacomment = value;
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
		if(this.authoringcp != null)
		{
			if(!this.authoringcp.isValidated())
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
		if(this.authoringdatetime == null)
			listOfErrors.add("Authoring Date/Time is a mandatory field");
		if(this.authoringcp == null)
			listOfErrors.add("Authoring HCP is a mandatory field");
		if(this.authoringcp != null)
		{
			String[] listOfOtherErrors = this.authoringcp.validate();
			if(listOfOtherErrors != null)
			{
				for(int x = 0; x < listOfOtherErrors.length; x++)
				{
					listOfErrors.add(listOfOtherErrors[x]);
				}
			}
		}
		if(this.presentcareer != null)
			if(this.presentcareer.length() > 1000)
				listOfErrors.add("The length of the field [presentcareer] in the value object [ims.therapies.vo.WorkOnAdmissionVo] is too big. It should be less or equal to 1000");
		if(this.pastqualifications != null)
			if(this.pastqualifications.length() > 1000)
				listOfErrors.add("The length of the field [pastqualifications] in the value object [ims.therapies.vo.WorkOnAdmissionVo] is too big. It should be less or equal to 1000");
		if(this.employername != null)
			if(this.employername.length() > 100)
				listOfErrors.add("The length of the field [employername] in the value object [ims.therapies.vo.WorkOnAdmissionVo] is too big. It should be less or equal to 100");
		if(this.employeraddress != null)
			if(this.employeraddress.length() > 1000)
				listOfErrors.add("The length of the field [employeraddress] in the value object [ims.therapies.vo.WorkOnAdmissionVo] is too big. It should be less or equal to 1000");
		if(this.employerphone != null)
			if(this.employerphone.length() > 50)
				listOfErrors.add("The length of the field [employerphone] in the value object [ims.therapies.vo.WorkOnAdmissionVo] is too big. It should be less or equal to 50");
		if(this.benefitadvice != null)
			if(this.benefitadvice.length() > 1000)
				listOfErrors.add("The length of the field [benefitadvice] in the value object [ims.therapies.vo.WorkOnAdmissionVo] is too big. It should be less or equal to 1000");
		if(this.worksiteassesscomment != null)
			if(this.worksiteassesscomment.length() > 1000)
				listOfErrors.add("The length of the field [worksiteassesscomment] in the value object [ims.therapies.vo.WorkOnAdmissionVo] is too big. It should be less or equal to 1000");
		if(this.deacomment != null)
			if(this.deacomment.length() > 1000)
				listOfErrors.add("The length of the field [deacomment] in the value object [ims.therapies.vo.WorkOnAdmissionVo] is too big. It should be less or equal to 1000");
		if(this.countFieldsWithValue() < 1)
		{
			listOfErrors.add("A minimum of 1 data fields must be entered");
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
	
		WorkOnAdmissionVo clone = new WorkOnAdmissionVo(this.id, this.version);
		
		clone.carecontext = this.carecontext;
		if(this.authoringdatetime == null)
			clone.authoringdatetime = null;
		else
			clone.authoringdatetime = (ims.framework.utils.DateTime)this.authoringdatetime.clone();
		if(this.authoringcp == null)
			clone.authoringcp = null;
		else
			clone.authoringcp = (ims.core.vo.Hcp)this.authoringcp.clone();
		clone.presentcareer = this.presentcareer;
		clone.pastqualifications = this.pastqualifications;
		clone.employername = this.employername;
		clone.employeraddress = this.employeraddress;
		clone.employerphone = this.employerphone;
		clone.benefitadvice = this.benefitadvice;
		if(this.worksiteassessment == null)
			clone.worksiteassessment = null;
		else
			clone.worksiteassessment = (ims.core.vo.lookups.YesNoUnknown)this.worksiteassessment.clone();
		clone.worksiteassesscomment = this.worksiteassesscomment;
		if(this.referdea == null)
			clone.referdea = null;
		else
			clone.referdea = (ims.core.vo.lookups.YesNoUnknown)this.referdea.clone();
		clone.deacomment = this.deacomment;
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
		if (!(WorkOnAdmissionVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A WorkOnAdmissionVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((WorkOnAdmissionVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((WorkOnAdmissionVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.presentcareer != null)
			count++;
		if(this.pastqualifications != null)
			count++;
		if(this.employername != null)
			count++;
		if(this.employeraddress != null)
			count++;
		if(this.employerphone != null)
			count++;
		if(this.benefitadvice != null)
			count++;
		if(this.worksiteassessment != null)
			count++;
		if(this.worksiteassesscomment != null)
			count++;
		if(this.referdea != null)
			count++;
		if(this.deacomment != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 10;
	}
	protected ims.core.admin.vo.CareContextRefVo carecontext;
	protected ims.framework.utils.DateTime authoringdatetime;
	protected ims.core.vo.Hcp authoringcp;
	protected String presentcareer;
	protected String pastqualifications;
	protected String employername;
	protected String employeraddress;
	protected String employerphone;
	protected String benefitadvice;
	protected ims.core.vo.lookups.YesNoUnknown worksiteassessment;
	protected String worksiteassesscomment;
	protected ims.core.vo.lookups.YesNoUnknown referdea;
	protected String deacomment;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
