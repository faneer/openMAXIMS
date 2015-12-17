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
 * Linked to core.clinical.ReferralLetterDetails business object (ID: 1003100093).
 */
public class ReferralLetterDetailsClinicListListVo extends ims.core.clinical.vo.ReferralLetterDetailsRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public ReferralLetterDetailsClinicListListVo()
	{
	}
	public ReferralLetterDetailsClinicListListVo(Integer id, int version)
	{
		super(id, version);
	}
	public ReferralLetterDetailsClinicListListVo(ims.RefMan.vo.beans.ReferralLetterDetailsClinicListListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.isdadreferral = bean.getIsDADReferral();
		this.end18ww = bean.getEnd18WW() == null ? null : bean.getEnd18WW().buildDate();
		this.dadubrn = bean.getDadUbrn();
		this.interpreterrequired = bean.getInterpreterRequired() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getInterpreterRequired());
		this.language = bean.getLanguage() == null ? null : ims.core.vo.lookups.Language.buildLookup(bean.getLanguage());
		this.otherlanguage = bean.getOtherLanguage();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.beans.ReferralLetterDetailsClinicListListVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.isdadreferral = bean.getIsDADReferral();
		this.end18ww = bean.getEnd18WW() == null ? null : bean.getEnd18WW().buildDate();
		this.dadubrn = bean.getDadUbrn();
		this.interpreterrequired = bean.getInterpreterRequired() == null ? null : ims.core.vo.lookups.YesNo.buildLookup(bean.getInterpreterRequired());
		this.language = bean.getLanguage() == null ? null : ims.core.vo.lookups.Language.buildLookup(bean.getLanguage());
		this.otherlanguage = bean.getOtherLanguage();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.beans.ReferralLetterDetailsClinicListListVoBean bean = null;
		if(map != null)
			bean = (ims.RefMan.vo.beans.ReferralLetterDetailsClinicListListVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.RefMan.vo.beans.ReferralLetterDetailsClinicListListVoBean();
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
		if(fieldName.equals("ISDADREFERRAL"))
			return getIsDADReferral();
		if(fieldName.equals("END18WW"))
			return getEnd18WW();
		if(fieldName.equals("DADUBRN"))
			return getDadUbrn();
		if(fieldName.equals("INTERPRETERREQUIRED"))
			return getInterpreterRequired();
		if(fieldName.equals("LANGUAGE"))
			return getLanguage();
		if(fieldName.equals("OTHERLANGUAGE"))
			return getOtherLanguage();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getIsDADReferralIsNotNull()
	{
		return this.isdadreferral != null;
	}
	public Boolean getIsDADReferral()
	{
		return this.isdadreferral;
	}
	public void setIsDADReferral(Boolean value)
	{
		this.isValidated = false;
		this.isdadreferral = value;
	}
	public boolean getEnd18WWIsNotNull()
	{
		return this.end18ww != null;
	}
	public ims.framework.utils.Date getEnd18WW()
	{
		return this.end18ww;
	}
	public void setEnd18WW(ims.framework.utils.Date value)
	{
		this.isValidated = false;
		this.end18ww = value;
	}
	public boolean getDadUbrnIsNotNull()
	{
		return this.dadubrn != null;
	}
	public String getDadUbrn()
	{
		return this.dadubrn;
	}
	public static int getDadUbrnMaxLength()
	{
		return 50;
	}
	public void setDadUbrn(String value)
	{
		this.isValidated = false;
		this.dadubrn = value;
	}
	public boolean getInterpreterRequiredIsNotNull()
	{
		return this.interpreterrequired != null;
	}
	public ims.core.vo.lookups.YesNo getInterpreterRequired()
	{
		return this.interpreterrequired;
	}
	public void setInterpreterRequired(ims.core.vo.lookups.YesNo value)
	{
		this.isValidated = false;
		this.interpreterrequired = value;
	}
	public boolean getLanguageIsNotNull()
	{
		return this.language != null;
	}
	public ims.core.vo.lookups.Language getLanguage()
	{
		return this.language;
	}
	public void setLanguage(ims.core.vo.lookups.Language value)
	{
		this.isValidated = false;
		this.language = value;
	}
	public boolean getOtherLanguageIsNotNull()
	{
		return this.otherlanguage != null;
	}
	public String getOtherLanguage()
	{
		return this.otherlanguage;
	}
	public static int getOtherLanguageMaxLength()
	{
		return 255;
	}
	public void setOtherLanguage(String value)
	{
		this.isValidated = false;
		this.otherlanguage = value;
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
		if(this.dadubrn != null)
			if(this.dadubrn.length() > 50)
				listOfErrors.add("The length of the field [dadubrn] in the value object [ims.RefMan.vo.ReferralLetterDetailsClinicListListVo] is too big. It should be less or equal to 50");
		if(this.otherlanguage != null)
			if(this.otherlanguage.length() > 255)
				listOfErrors.add("The length of the field [otherlanguage] in the value object [ims.RefMan.vo.ReferralLetterDetailsClinicListListVo] is too big. It should be less or equal to 255");
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
	
		ReferralLetterDetailsClinicListListVo clone = new ReferralLetterDetailsClinicListListVo(this.id, this.version);
		
		clone.isdadreferral = this.isdadreferral;
		if(this.end18ww == null)
			clone.end18ww = null;
		else
			clone.end18ww = (ims.framework.utils.Date)this.end18ww.clone();
		clone.dadubrn = this.dadubrn;
		if(this.interpreterrequired == null)
			clone.interpreterrequired = null;
		else
			clone.interpreterrequired = (ims.core.vo.lookups.YesNo)this.interpreterrequired.clone();
		if(this.language == null)
			clone.language = null;
		else
			clone.language = (ims.core.vo.lookups.Language)this.language.clone();
		clone.otherlanguage = this.otherlanguage;
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
		if (!(ReferralLetterDetailsClinicListListVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A ReferralLetterDetailsClinicListListVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((ReferralLetterDetailsClinicListListVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((ReferralLetterDetailsClinicListListVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.isdadreferral != null)
			count++;
		if(this.end18ww != null)
			count++;
		if(this.dadubrn != null)
			count++;
		if(this.interpreterrequired != null)
			count++;
		if(this.language != null)
			count++;
		if(this.otherlanguage != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 6;
	}
	protected Boolean isdadreferral;
	protected ims.framework.utils.Date end18ww;
	protected String dadubrn;
	protected ims.core.vo.lookups.YesNo interpreterrequired;
	protected ims.core.vo.lookups.Language language;
	protected String otherlanguage;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
