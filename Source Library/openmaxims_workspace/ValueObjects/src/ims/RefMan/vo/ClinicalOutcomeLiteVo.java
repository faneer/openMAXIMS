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
 * Linked to RefMan.ClinicalOutcome business object (ID: 1072100092).
 */
public class ClinicalOutcomeLiteVo extends ims.RefMan.vo.ClinicalOutcomeRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ClinicalOutcomeLiteVo()
	{
	}
	public ClinicalOutcomeLiteVo(Integer id, int version)
	{
		super(id, version);
	}
	public ClinicalOutcomeLiteVo(ims.RefMan.vo.beans.ClinicalOutcomeLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicaloutcome = bean.getClinicalOutcome() == null ? null : bean.getClinicalOutcome().buildVo();
		this.date = bean.getDate() == null ? null : bean.getDate().buildDate();
		this.procedure = bean.getProcedure() == null ? null : bean.getProcedure().buildVo();
		this.clinicaloutcomecontext = bean.getClinicalOutcomeContext() == null ? null : ims.RefMan.vo.lookups.ClinicalOutcomeContext.buildLookup(bean.getClinicalOutcomeContext());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.ClinicalOutcomeLiteVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.clinicaloutcome = bean.getClinicalOutcome() == null ? null : bean.getClinicalOutcome().buildVo(map);
		this.date = bean.getDate() == null ? null : bean.getDate().buildDate();
		this.procedure = bean.getProcedure() == null ? null : bean.getProcedure().buildVo(map);
		this.clinicaloutcomecontext = bean.getClinicalOutcomeContext() == null ? null : ims.RefMan.vo.lookups.ClinicalOutcomeContext.buildLookup(bean.getClinicalOutcomeContext());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.ClinicalOutcomeLiteVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.ClinicalOutcomeLiteVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.ClinicalOutcomeLiteVoBean();
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
		if(fieldName.equals("CLINICALOUTCOME"))
			return getClinicalOutcome();
		if(fieldName.equals("DATE"))
			return getDate();
		if(fieldName.equals("PROCEDURE"))
			return getProcedure();
		if(fieldName.equals("CLINICALOUTCOMECONTEXT"))
			return getClinicalOutcomeContext();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getClinicalOutcomeIsNotNull()
	{
		return this.clinicaloutcome != null;
	}
	public ims.clinicaladmin.vo.ClinicalOutcomeConfigLiteVo getClinicalOutcome()
	{
		return this.clinicaloutcome;
	}
	public void setClinicalOutcome(ims.clinicaladmin.vo.ClinicalOutcomeConfigLiteVo value)
	{
		this.isValidated = false;
		this.clinicaloutcome = value;
	}
	public boolean getDateIsNotNull()
	{
		return this.date != null;
	}
	public ims.framework.utils.Date getDate()
	{
		return this.date;
	}
	public void setDate(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.date = value;
	}
	public boolean getProcedureIsNotNull()
	{
		return this.procedure != null;
	}
	public ims.RefMan.vo.ClinicalOutcomeProcedureVo getProcedure()
	{
		return this.procedure;
	}
	public void setProcedure(ims.RefMan.vo.ClinicalOutcomeProcedureVo value)
	{
		this.isValidated = false;
		this.procedure = value;
	}
	public boolean getClinicalOutcomeContextIsNotNull()
	{
		return this.clinicaloutcomecontext != null;
	}
	public ims.RefMan.vo.lookups.ClinicalOutcomeContext getClinicalOutcomeContext()
	{
		return this.clinicaloutcomecontext;
	}
	public void setClinicalOutcomeContext(ims.RefMan.vo.lookups.ClinicalOutcomeContext value)
	{
		this.isValidated = false;
		this.clinicaloutcomecontext = value;
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
		if(this.clinicaloutcome == null)
			listOfErrors.add("Clinical Outcome is mandatory");
		if(this.date == null)
			listOfErrors.add("Clinical Outcome Date is mandatory");
		if(this.clinicaloutcomecontext == null)
			listOfErrors.add("Clinical Outcome Context is mandatory");
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
	
		ClinicalOutcomeLiteVo clone = new ClinicalOutcomeLiteVo(this.id, this.version);
		
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
		if (!(ClinicalOutcomeLiteVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ClinicalOutcomeLiteVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ClinicalOutcomeLiteVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ClinicalOutcomeLiteVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.clinicaloutcome != null)
			count++;
		if(this.date != null)
			count++;
		if(this.procedure != null)
			count++;
		if(this.clinicaloutcomecontext != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.clinicaladmin.vo.ClinicalOutcomeConfigLiteVo clinicaloutcome;
	protected ims.framework.utils.Date date;
	protected ims.RefMan.vo.ClinicalOutcomeProcedureVo procedure;
	protected ims.RefMan.vo.lookups.ClinicalOutcomeContext clinicaloutcomecontext;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
