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
public class AppUserShortVo extends ims.core.configuration.vo.AppUserRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public AppUserShortVo()
	{
	}
	public AppUserShortVo(Integer id, int version)
	{
		super(id, version);
	}
	public AppUserShortVo(ims.admin.vo.beans.AppUserShortVoBean bean)
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
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.admin.vo.beans.AppUserShortVoBean bean)
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
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.admin.vo.beans.AppUserShortVoBean bean = null;
		if(map != null)
			bean = (ims.admin.vo.beans.AppUserShortVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.admin.vo.beans.AppUserShortVoBean();
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
		if(fieldName.equals("USERNAME"))
			return getUsername();
		if(fieldName.equals("PASSWORD"))
			return getPassword();
		if(fieldName.equals("ENCODEDPASSWORD"))
			return getEncodedPassword();
		if(fieldName.equals("THEME"))
			return getTheme();
		if(fieldName.equals("PWDEXPDATE"))
			return getPwdExpDate();
		if(fieldName.equals("EFFECTIVEFROM"))
			return getEffectiveFrom();
		if(fieldName.equals("EFFECTIVETO"))
			return getEffectiveTo();
		if(fieldName.equals("ISACTIVE"))
			return getIsActive();
		if(fieldName.equals("USERREALNAME"))
			return getUserRealName();
		if(fieldName.equals("DEBUGMODE"))
			return getDebugMode();
		if(fieldName.equals("LDAPUSERNAME"))
			return getLDAPUsername();
		if(fieldName.equals("LDAPPASSWORD"))
			return getLDAPPassword();
		if(fieldName.equals("LOCKED"))
			return getLocked();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getUsernameIsNotNull()
	{
		return this.username != null;
	}
	public String getUsername()
	{
		return this.username;
	}
	public static int getUsernameMaxLength()
	{
		return 30;
	}
	public void setUsername(String value)
	{
		this.isValidated = false;
		this.username = value;
	}
	public boolean getPasswordIsNotNull()
	{
		return this.password != null;
	}
	public String getPassword()
	{
		return this.password;
	}
	public static int getPasswordMaxLength()
	{
		return 30;
	}
	public void setPassword(String value)
	{
		this.isValidated = false;
		this.password = value;
	}
	public boolean getEncodedPasswordIsNotNull()
	{
		return this.encodedpassword != null;
	}
	public String getEncodedPassword()
	{
		return this.encodedpassword;
	}
	public static int getEncodedPasswordMaxLength()
	{
		return 255;
	}
	public void setEncodedPassword(String value)
	{
		this.isValidated = false;
		this.encodedpassword = value;
	}
	public boolean getThemeIsNotNull()
	{
		return this.theme != null;
	}
	public String getTheme()
	{
		return this.theme;
	}
	public static int getThemeMaxLength()
	{
		return 20;
	}
	public void setTheme(String value)
	{
		this.isValidated = false;
		this.theme = value;
	}
	public boolean getPwdExpDateIsNotNull()
	{
		return this.pwdexpdate != null;
	}
	public ims.framework.utils.DateTime getPwdExpDate()
	{
		return this.pwdexpdate;
	}
	public void setPwdExpDate(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.pwdexpdate = value;
	}
	public boolean getEffectiveFromIsNotNull()
	{
		return this.effectivefrom != null;
	}
	public ims.framework.utils.DateTime getEffectiveFrom()
	{
		return this.effectivefrom;
	}
	public void setEffectiveFrom(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.effectivefrom = value;
	}
	public boolean getEffectiveToIsNotNull()
	{
		return this.effectiveto != null;
	}
	public ims.framework.utils.DateTime getEffectiveTo()
	{
		return this.effectiveto;
	}
	public void setEffectiveTo(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.effectiveto = value;
	}
	public boolean getIsActiveIsNotNull()
	{
		return this.isactive != null;
	}
	public Boolean getIsActive()
	{
		return this.isactive;
	}
	public void setIsActive(Boolean value)
	{
		this.isValidated = false;
		this.isactive = value;
	}
	public boolean getUserRealNameIsNotNull()
	{
		return this.userrealname != null;
	}
	public String getUserRealName()
	{
		return this.userrealname;
	}
	public static int getUserRealNameMaxLength()
	{
		return 255;
	}
	public void setUserRealName(String value)
	{
		this.isValidated = false;
		this.userrealname = value;
	}
	public boolean getDebugModeIsNotNull()
	{
		return this.debugmode != null;
	}
	public Boolean getDebugMode()
	{
		return this.debugmode;
	}
	public void setDebugMode(Boolean value)
	{
		this.isValidated = false;
		this.debugmode = value;
	}
	public boolean getLDAPUsernameIsNotNull()
	{
		return this.ldapusername != null;
	}
	public String getLDAPUsername()
	{
		return this.ldapusername;
	}
	public static int getLDAPUsernameMaxLength()
	{
		return 255;
	}
	public void setLDAPUsername(String value)
	{
		this.isValidated = false;
		this.ldapusername = value;
	}
	public boolean getLDAPPasswordIsNotNull()
	{
		return this.ldappassword != null;
	}
	public String getLDAPPassword()
	{
		return this.ldappassword;
	}
	public static int getLDAPPasswordMaxLength()
	{
		return 255;
	}
	public void setLDAPPassword(String value)
	{
		this.isValidated = false;
		this.ldappassword = value;
	}
	public boolean getLockedIsNotNull()
	{
		return this.locked != null;
	}
	public Boolean getLocked()
	{
		return this.locked;
	}
	public void setLocked(Boolean value)
	{
		this.isValidated = false;
		this.locked = value;
	}
	/**
	* copy(AppUserRole) : copy the contents of appuserrole into this short Vo
	*/
	public void copy(AppUserVo voAppUser) 
	{
		if(voAppUser == null)
			return;
		
		this.setID_AppUser(voAppUser.getID_AppUser());
		this.username = voAppUser.getUsername();
		this.setPassword(voAppUser.getPassword());
		this.isactive = voAppUser.getIsActive();
		this.effectivefrom = voAppUser.getEffectiveFrom();
		this.effectiveto = voAppUser.getEffectiveTo();
		this.pwdexpdate = voAppUser.getPwdExpDate();
		this.theme = voAppUser.getTheme();
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
		if(this.username == null || this.username.length() == 0)
			listOfErrors.add("Username is mandatory");
		else if(this.username.length() > 30)
			listOfErrors.add("The length of the field [username] in the value object [ims.admin.vo.AppUserShortVo] is too big. It should be less or equal to 30");
		if(this.password == null || this.password.length() == 0)
			listOfErrors.add("Password is mandatory");
		else if(this.password.length() > 30)
			listOfErrors.add("The length of the field [password] in the value object [ims.admin.vo.AppUserShortVo] is too big. It should be less or equal to 30");
		if(this.encodedpassword != null)
			if(this.encodedpassword.length() > 255)
				listOfErrors.add("The length of the field [encodedpassword] in the value object [ims.admin.vo.AppUserShortVo] is too big. It should be less or equal to 255");
		if(this.theme != null)
			if(this.theme.length() > 20)
				listOfErrors.add("The length of the field [theme] in the value object [ims.admin.vo.AppUserShortVo] is too big. It should be less or equal to 20");
		if(this.isactive == null)
			listOfErrors.add("IsActive is mandatory");
		if(this.ldapusername != null)
			if(this.ldapusername.length() > 255)
				listOfErrors.add("255");
		if(this.ldappassword != null)
			if(this.ldappassword.length() > 255)
				listOfErrors.add("255");
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
	
		AppUserShortVo clone = new AppUserShortVo(this.id, this.version);
		
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
		if (!(AppUserShortVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AppUserShortVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		AppUserShortVo compareObj = (AppUserShortVo)obj;
		int retVal = 0;
		if (retVal == 0)
		{
			if(this.getUsername() == null && compareObj.getUsername() != null)
				return -1;
			if(this.getUsername() != null && compareObj.getUsername() == null)
				return 1;
			if(this.getUsername() != null && compareObj.getUsername() != null)
			{
				if(caseInsensitive)
					retVal = this.getUsername().toLowerCase().compareTo(compareObj.getUsername().toLowerCase());
				else
					retVal = this.getUsername().compareTo(compareObj.getUsername());
			}
		}
		return retVal;
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.username != null)
			count++;
		if(this.password != null)
			count++;
		if(this.encodedpassword != null)
			count++;
		if(this.theme != null)
			count++;
		if(this.pwdexpdate != null)
			count++;
		if(this.effectivefrom != null)
			count++;
		if(this.effectiveto != null)
			count++;
		if(this.isactive != null)
			count++;
		if(this.userrealname != null)
			count++;
		if(this.debugmode != null)
			count++;
		if(this.ldapusername != null)
			count++;
		if(this.ldappassword != null)
			count++;
		if(this.locked != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 13;
	}
	protected String username;
	protected String password;
	protected String encodedpassword;
	protected String theme;
	protected ims.framework.utils.DateTime pwdexpdate;
	protected ims.framework.utils.DateTime effectivefrom;
	protected ims.framework.utils.DateTime effectiveto;
	protected Boolean isactive;
	protected String userrealname;
	protected Boolean debugmode;
	protected String ldapusername;
	protected String ldappassword;
	protected Boolean locked;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
