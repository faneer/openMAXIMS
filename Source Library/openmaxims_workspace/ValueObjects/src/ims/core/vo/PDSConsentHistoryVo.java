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

package ims.core.vo;

/**
 * Linked to core.patient.pdsConsentHistory business object (ID: 1001100032).
 */
public class PDSConsentHistoryVo extends ims.core.patient.vo.pdsConsentHistoryRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PDSConsentHistoryVo()
	{
	}
	public PDSConsentHistoryVo(Integer id, int version)
	{
		super(id, version);
	}
	public PDSConsentHistoryVo(ims.core.vo.beans.PDSConsentHistoryVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.date = bean.getDate() == null ? null : bean.getDate().buildDate();
		this.consent = bean.getConsent() == null ? null : ims.core.vo.lookups.PDSConsent.buildLookup(bean.getConsent());
		this.comment = bean.getComment();
		this.consenttype = bean.getConsentType() == null ? null : ims.core.vo.lookups.PDSConsentType.buildLookup(bean.getConsentType());
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.PDSConsentHistoryVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.date = bean.getDate() == null ? null : bean.getDate().buildDate();
		this.consent = bean.getConsent() == null ? null : ims.core.vo.lookups.PDSConsent.buildLookup(bean.getConsent());
		this.comment = bean.getComment();
		this.consenttype = bean.getConsentType() == null ? null : ims.core.vo.lookups.PDSConsentType.buildLookup(bean.getConsentType());
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.PDSConsentHistoryVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.PDSConsentHistoryVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.PDSConsentHistoryVoBean();
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
		if(fieldName.equals("DATE"))
			return getDate();
		if(fieldName.equals("CONSENT"))
			return getConsent();
		if(fieldName.equals("COMMENT"))
			return getComment();
		if(fieldName.equals("CONSENTTYPE"))
			return getConsentType();
		return super.getFieldValueByFieldName(fieldName);
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
	public boolean getConsentIsNotNull()
	{
		return this.consent != null;
	}
	public ims.core.vo.lookups.PDSConsent getConsent()
	{
		return this.consent;
	}
	public void setConsent(ims.core.vo.lookups.PDSConsent value)
	{
		this.isValidated = false;
		this.consent = value;
	}
	public boolean getCommentIsNotNull()
	{
		return this.comment != null;
	}
	public String getComment()
	{
		return this.comment;
	}
	public static int getCommentMaxLength()
	{
		return 500;
	}
	public void setComment(String value)
	{
		this.isValidated = false;
		this.comment = value;
	}
	public boolean getConsentTypeIsNotNull()
	{
		return this.consenttype != null;
	}
	public ims.core.vo.lookups.PDSConsentType getConsentType()
	{
		return this.consenttype;
	}
	public void setConsentType(ims.core.vo.lookups.PDSConsentType value)
	{
		this.isValidated = false;
		this.consenttype = value;
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
		if(this.comment != null)
			if(this.comment.length() > 500)
				listOfErrors.add("The length of the field [comment] in the value object [ims.core.vo.PDSConsentHistoryVo] is too big. It should be less or equal to 500");
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
	
		PDSConsentHistoryVo clone = new PDSConsentHistoryVo(this.id, this.version);
		
		if(this.date == null)
			clone.date = null;
		else
			clone.date = (ims.framework.utils.Date)this.date.clone();
		if(this.consent == null)
			clone.consent = null;
		else
			clone.consent = (ims.core.vo.lookups.PDSConsent)this.consent.clone();
		clone.comment = this.comment;
		if(this.consenttype == null)
			clone.consenttype = null;
		else
			clone.consenttype = (ims.core.vo.lookups.PDSConsentType)this.consenttype.clone();
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
		if (!(PDSConsentHistoryVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PDSConsentHistoryVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PDSConsentHistoryVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PDSConsentHistoryVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.date != null)
			count++;
		if(this.consent != null)
			count++;
		if(this.comment != null)
			count++;
		if(this.consenttype != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected ims.framework.utils.Date date;
	protected ims.core.vo.lookups.PDSConsent consent;
	protected String comment;
	protected ims.core.vo.lookups.PDSConsentType consenttype;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
