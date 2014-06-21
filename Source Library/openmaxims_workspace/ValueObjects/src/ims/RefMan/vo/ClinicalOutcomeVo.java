// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo;

/**
 * Linked to RefMan.ClinicalOutcome business object (ID: 1072100092).
 */
public class ClinicalOutcomeVo extends ims.RefMan.vo.ClinicalOutcomeLiteVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ClinicalOutcomeVo()
	{
	}
	public ClinicalOutcomeVo(Integer id, int version)
	{
		super(id, version);
	}
	public ClinicalOutcomeVo(ims.RefMan.vo.beans.ClinicalOutcomeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicaloutcome = bean.getClinicalOutcome() == null ? null : bean.getClinicalOutcome().buildVo();
		this.date = bean.getDate() == null ? null : bean.getDate().buildDate();
		this.procedure = bean.getProcedure() == null ? null : bean.getProcedure().buildVo();
		this.clinicaloutcomecontext = bean.getClinicalOutcomeContext() == null ? null : ims.RefMan.vo.lookups.ClinicalOutcomeContext.buildLookup(bean.getClinicalOutcomeContext());
		this.catsreferral = bean.getCatsReferral() == null ? null : new ims.RefMan.vo.CatsReferralRefVo(new Integer(bean.getCatsReferral().getId()), bean.getCatsReferral().getVersion());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo();
		this.actioncomments = bean.getActionComments();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.ClinicalOutcomeVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicaloutcome = bean.getClinicalOutcome() == null ? null : bean.getClinicalOutcome().buildVo(map);
		this.date = bean.getDate() == null ? null : bean.getDate().buildDate();
		this.procedure = bean.getProcedure() == null ? null : bean.getProcedure().buildVo(map);
		this.clinicaloutcomecontext = bean.getClinicalOutcomeContext() == null ? null : ims.RefMan.vo.lookups.ClinicalOutcomeContext.buildLookup(bean.getClinicalOutcomeContext());
		this.catsreferral = bean.getCatsReferral() == null ? null : new ims.RefMan.vo.CatsReferralRefVo(new Integer(bean.getCatsReferral().getId()), bean.getCatsReferral().getVersion());
		this.authoringinformation = bean.getAuthoringInformation() == null ? null : bean.getAuthoringInformation().buildVo(map);
		this.actioncomments = bean.getActionComments();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.ClinicalOutcomeVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.ClinicalOutcomeVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.ClinicalOutcomeVoBean();
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
		if(fieldName.equals("CATSREFERRAL"))
			return getCatsReferral();
		if(fieldName.equals("AUTHORINGINFORMATION"))
			return getAuthoringInformation();
		if(fieldName.equals("ACTIONCOMMENTS"))
			return getActionComments();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getCatsReferralIsNotNull()
	{
		return this.catsreferral != null;
	}
	public ims.RefMan.vo.CatsReferralRefVo getCatsReferral()
	{
		return this.catsreferral;
	}
	public void setCatsReferral(ims.RefMan.vo.CatsReferralRefVo value)
	{
		this.isValidated = false;
		this.catsreferral = value;
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
	public boolean getActionCommentsIsNotNull()
	{
		return this.actioncomments != null;
	}
	public String getActionComments()
	{
		return this.actioncomments;
	}
	public static int getActionCommentsMaxLength()
	{
		return 1000;
	}
	public void setActionComments(String value)
	{
		this.isValidated = false;
		this.actioncomments = value;
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
		if(this.clinicaloutcome == null)
			listOfErrors.add("Clinical Outcome is mandatory");
		if(this.date == null)
			listOfErrors.add("Clinical Outcome Date is mandatory");
		if(this.clinicaloutcomecontext == null)
			listOfErrors.add("Clinical Outcome Context is mandatory");
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
		if(this.actioncomments != null)
			if(this.actioncomments.length() > 1000)
				listOfErrors.add("The length of the field [actioncomments] in the value object [ims.RefMan.vo.ClinicalOutcomeVo] is too big. It should be less or equal to 1000");
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
	
		ClinicalOutcomeVo clone = new ClinicalOutcomeVo(this.id, this.version);
		
		if(this.clinicaloutcome == null)
			clone.clinicaloutcome = null;
		else
			clone.clinicaloutcome = (ims.clinicaladmin.vo.ClinicalOutcomeConfigLiteVo)this.clinicaloutcome.clone();
		if(this.date == null)
			clone.date = null;
		else
			clone.date = (ims.framework.utils.Date)this.date.clone();
		if(this.procedure == null)
			clone.procedure = null;
		else
			clone.procedure = (ims.RefMan.vo.ClinicalOutcomeProcedureVo)this.procedure.clone();
		if(this.clinicaloutcomecontext == null)
			clone.clinicaloutcomecontext = null;
		else
			clone.clinicaloutcomecontext = (ims.RefMan.vo.lookups.ClinicalOutcomeContext)this.clinicaloutcomecontext.clone();
		clone.catsreferral = this.catsreferral;
		if(this.authoringinformation == null)
			clone.authoringinformation = null;
		else
			clone.authoringinformation = (ims.core.vo.AuthoringInformationVo)this.authoringinformation.clone();
		clone.actioncomments = this.actioncomments;
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
		if (!(ClinicalOutcomeVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ClinicalOutcomeVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ClinicalOutcomeVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ClinicalOutcomeVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.catsreferral != null)
			count++;
		if(this.authoringinformation != null)
			count++;
		if(this.actioncomments != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 3;
	}
	protected ims.RefMan.vo.CatsReferralRefVo catsreferral;
	protected ims.core.vo.AuthoringInformationVo authoringinformation;
	protected String actioncomments;
	private boolean isValidated = false;
	private boolean isBusy = false;
}