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

package ims.admin.vo;

/**
 * Linked to core.configuration.AppUser business object (ID: 1021100004).
 */
public class AppUserShortWithNameVo extends ims.admin.vo.AppUserShortVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AppUserShortWithNameVo()
	{
	}
	public AppUserShortWithNameVo(Integer id, int version)
	{
		super(id, version);
	}
	public AppUserShortWithNameVo(ims.admin.vo.beans.AppUserShortWithNameVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.username = bean.getUsername();
		this.password = bean.getPassword();
		this.encodedpassword = bean.getEncodedPassword();
		this.theme = bean.getTheme();
		this.pwdexpdate = bean.getPwdExpDate() == null ? null : bean.getPwdExpDate().buildDateTime();
		this.effectivefrom = bean.getEffectiveFrom() == null ? null : bean.getEffectiveFrom().buildDateTime();
		this.effectiveto = bean.getEffectiveTo() == null ? null : bean.getEffectiveTo().buildDateTime();
		this.isactive = bean.getIsActive();
		this.userrealname = bean.getUserRealName();
		this.debugmode = bean.getDebugMode();
		this.ldapusername = bean.getLDAPUsername();
		this.ldappassword = bean.getLDAPPassword();
		this.locked = bean.getLocked();
		this.mosname = bean.getMosName() == null ? null : bean.getMosName().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.beans.AppUserShortWithNameVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.username = bean.getUsername();
		this.password = bean.getPassword();
		this.encodedpassword = bean.getEncodedPassword();
		this.theme = bean.getTheme();
		this.pwdexpdate = bean.getPwdExpDate() == null ? null : bean.getPwdExpDate().buildDateTime();
		this.effectivefrom = bean.getEffectiveFrom() == null ? null : bean.getEffectiveFrom().buildDateTime();
		this.effectiveto = bean.getEffectiveTo() == null ? null : bean.getEffectiveTo().buildDateTime();
		this.isactive = bean.getIsActive();
		this.userrealname = bean.getUserRealName();
		this.debugmode = bean.getDebugMode();
		this.ldapusername = bean.getLDAPUsername();
		this.ldappassword = bean.getLDAPPassword();
		this.locked = bean.getLocked();
		this.mosname = bean.getMosName() == null ? null : bean.getMosName().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.beans.AppUserShortWithNameVoBean bean = null;
		if(map != null)
			bean = (ims.admin.vo.beans.AppUserShortWithNameVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.admin.vo.beans.AppUserShortWithNameVoBean();
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
		if(fieldName.equals("MOSNAME"))
			return getMosName();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getMosNameIsNotNull()
	{
		return this.mosname != null;
	}
	public ims.core.vo.MemberOfStaffLiteVo getMosName()
	{
		return this.mosname;
	}
	public void setMosName(ims.core.vo.MemberOfStaffLiteVo value)
	{
		this.isValidated = false;
		this.mosname = value;
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
		if(this.mosname != null)
		{
			if(!this.mosname.isValidated())
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
		if(this.username == null || this.username.length() == 0)
			listOfErrors.add("Username is mandatory");
		else if(this.username.length() > 30)
			listOfErrors.add("The length of the field [username] in the value object [ims.admin.vo.AppUserShortWithNameVo] is too big. It should be less or equal to 30");
		if(this.password == null || this.password.length() == 0)
			listOfErrors.add("Password is mandatory");
		else if(this.password.length() > 30)
			listOfErrors.add("The length of the field [password] in the value object [ims.admin.vo.AppUserShortWithNameVo] is too big. It should be less or equal to 30");
		if(this.encodedpassword != null)
			if(this.encodedpassword.length() > 255)
				listOfErrors.add("The length of the field [encodedpassword] in the value object [ims.admin.vo.AppUserShortWithNameVo] is too big. It should be less or equal to 255");
		if(this.theme != null)
			if(this.theme.length() > 20)
				listOfErrors.add("The length of the field [theme] in the value object [ims.admin.vo.AppUserShortWithNameVo] is too big. It should be less or equal to 20");
		if(this.isactive == null)
			listOfErrors.add("IsActive is mandatory");
		if(this.ldapusername != null)
			if(this.ldapusername.length() > 255)
				listOfErrors.add("255");
		if(this.ldappassword != null)
			if(this.ldappassword.length() > 255)
				listOfErrors.add("255");
		if(this.mosname != null)
		{
			String[] listOfOtherErrors = this.mosname.validate();
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
	
		AppUserShortWithNameVo clone = new AppUserShortWithNameVo(this.id, this.version);
		
		clone.username = this.username;
		clone.password = this.password;
		clone.encodedpassword = this.encodedpassword;
		clone.theme = this.theme;
		if(this.pwdexpdate == null)
			clone.pwdexpdate = null;
		else
			clone.pwdexpdate = (ims.framework.utils.DateTime)this.pwdexpdate.clone();
		if(this.effectivefrom == null)
			clone.effectivefrom = null;
		else
			clone.effectivefrom = (ims.framework.utils.DateTime)this.effectivefrom.clone();
		if(this.effectiveto == null)
			clone.effectiveto = null;
		else
			clone.effectiveto = (ims.framework.utils.DateTime)this.effectiveto.clone();
		clone.isactive = this.isactive;
		clone.userrealname = this.userrealname;
		clone.debugmode = this.debugmode;
		clone.ldapusername = this.ldapusername;
		clone.ldappassword = this.ldappassword;
		clone.locked = this.locked;
		if(this.mosname == null)
			clone.mosname = null;
		else
			clone.mosname = (ims.core.vo.MemberOfStaffLiteVo)this.mosname.clone();
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
		if (!(AppUserShortWithNameVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AppUserShortWithNameVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((AppUserShortWithNameVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((AppUserShortWithNameVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = super.countFieldsWithValue();
		if(this.mosname != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return super.countValueObjectFields() + 1;
	}
	protected ims.core.vo.MemberOfStaffLiteVo mosname;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
