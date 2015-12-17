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
 * Linked to core.configuration.AppForm business object (ID: 1021100001).
 */
public class AppFormForTrackingVo extends ims.core.configuration.vo.AppFormRefVo implements ims.vo.ImsCloneable, Comparable, ims.framework.interfaces.IAppForm
{
	private static final long serialVersionUID = 1L;

	public AppFormForTrackingVo()
	{
	}
	public AppFormForTrackingVo(Integer id, int version)
	{
		super(id, version);
	}
	public AppFormForTrackingVo(ims.emergency.vo.beans.AppFormForTrackingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.namespace = bean.getNamespace() == null ? null : bean.getNamespace().buildVo();
		this.name = bean.getName();
		this.aliasname = bean.getAliasName();
		this.caption = bean.getCaption();
		this.isdialog = bean.getIsDialog();
		this.iscomponent = bean.getIsComponent();
		this.canbeinnavigation = bean.getCanBeInNavigation();
		this.canbeintopbuttons = bean.getCanBeInTopButtons();
		this.isalias = bean.getIsAlias();
		this.logicclass = bean.getLogicClass();
		this.accessclass = bean.getAccessClass();
		this.domainimpl = bean.getDomainImpl();
		this.helplink = bean.getHelpLink();
		this.rieboclassname = bean.getRieBoClassName();
		this.issystem = bean.getIsSystem();
		this.menuactions = ims.admin.vo.MenuActionVoCollection.buildFromBeanCollection(bean.getMenuActions());
		this.informationbarvisible = bean.getInformationBarVisible();
		this.description = bean.getDescription();
		this.image = bean.getImage() == null ? null : bean.getImage().buildVo();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.beans.AppFormForTrackingVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.namespace = bean.getNamespace() == null ? null : bean.getNamespace().buildVo(map);
		this.name = bean.getName();
		this.aliasname = bean.getAliasName();
		this.caption = bean.getCaption();
		this.isdialog = bean.getIsDialog();
		this.iscomponent = bean.getIsComponent();
		this.canbeinnavigation = bean.getCanBeInNavigation();
		this.canbeintopbuttons = bean.getCanBeInTopButtons();
		this.isalias = bean.getIsAlias();
		this.logicclass = bean.getLogicClass();
		this.accessclass = bean.getAccessClass();
		this.domainimpl = bean.getDomainImpl();
		this.helplink = bean.getHelpLink();
		this.rieboclassname = bean.getRieBoClassName();
		this.issystem = bean.getIsSystem();
		this.menuactions = ims.admin.vo.MenuActionVoCollection.buildFromBeanCollection(bean.getMenuActions());
		this.informationbarvisible = bean.getInformationBarVisible();
		this.description = bean.getDescription();
		this.image = bean.getImage() == null ? null : bean.getImage().buildVo(map);
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.beans.AppFormForTrackingVoBean bean = null;
		if(map != null)
			bean = (ims.emergency.vo.beans.AppFormForTrackingVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.emergency.vo.beans.AppFormForTrackingVoBean();
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
		if(fieldName.equals("NAMESPACE"))
			return getNamespace();
		if(fieldName.equals("NAME"))
			return getName();
		if(fieldName.equals("ALIASNAME"))
			return getAliasName();
		if(fieldName.equals("CAPTION"))
			return getCaption();
		if(fieldName.equals("ISDIALOG"))
			return getIsDialog();
		if(fieldName.equals("ISCOMPONENT"))
			return getIsComponent();
		if(fieldName.equals("CANBEINNAVIGATION"))
			return getCanBeInNavigation();
		if(fieldName.equals("CANBEINTOPBUTTONS"))
			return getCanBeInTopButtons();
		if(fieldName.equals("ISALIAS"))
			return getIsAlias();
		if(fieldName.equals("LOGICCLASS"))
			return getLogicClass();
		if(fieldName.equals("ACCESSCLASS"))
			return getAccessClass();
		if(fieldName.equals("DOMAINIMPL"))
			return getDomainImpl();
		if(fieldName.equals("HELPLINK"))
			return getHelpLink();
		if(fieldName.equals("RIEBOCLASSNAME"))
			return getRieBoClassName();
		if(fieldName.equals("ISSYSTEM"))
			return getIsSystem();
		if(fieldName.equals("MENUACTIONS"))
			return getMenuActions();
		if(fieldName.equals("INFORMATIONBARVISIBLE"))
			return getInformationBarVisible();
		if(fieldName.equals("DESCRIPTION"))
			return getDescription();
		if(fieldName.equals("IMAGE"))
			return getImage();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getNamespaceIsNotNull()
	{
		return this.namespace != null;
	}
	public ims.admin.vo.AppNamespace getNamespace()
	{
		return this.namespace;
	}
	public void setNamespace(ims.admin.vo.AppNamespace value)
	{
		this.isValidated = false;
		this.namespace = value;
	}
	public boolean getNameIsNotNull()
	{
		return this.name != null;
	}
	public String getName()
	{
		return this.name;
	}
	public static int getNameMaxLength()
	{
		return 100;
	}
	public void setName(String value)
	{
		this.isValidated = false;
		this.name = value;
	}
	public boolean getAliasNameIsNotNull()
	{
		return this.aliasname != null;
	}
	public String getAliasName()
	{
		return this.aliasname;
	}
	public static int getAliasNameMaxLength()
	{
		return 100;
	}
	public void setAliasName(String value)
	{
		this.isValidated = false;
		this.aliasname = value;
	}
	public boolean getCaptionIsNotNull()
	{
		return this.caption != null;
	}
	public String getCaption()
	{
		return this.caption;
	}
	public static int getCaptionMaxLength()
	{
		return 100;
	}
	public void setCaption(String value)
	{
		this.isValidated = false;
		this.caption = value;
	}
	public boolean getIsDialogIsNotNull()
	{
		return this.isdialog != null;
	}
	public Boolean getIsDialog()
	{
		return this.isdialog;
	}
	public void setIsDialog(Boolean value)
	{
		this.isValidated = false;
		this.isdialog = value;
	}
	public boolean getIsComponentIsNotNull()
	{
		return this.iscomponent != null;
	}
	public Boolean getIsComponent()
	{
		return this.iscomponent;
	}
	public void setIsComponent(Boolean value)
	{
		this.isValidated = false;
		this.iscomponent = value;
	}
	public boolean getCanBeInNavigationIsNotNull()
	{
		return this.canbeinnavigation != null;
	}
	public Boolean getCanBeInNavigation()
	{
		return this.canbeinnavigation;
	}
	public void setCanBeInNavigation(Boolean value)
	{
		this.isValidated = false;
		this.canbeinnavigation = value;
	}
	public boolean getCanBeInTopButtonsIsNotNull()
	{
		return this.canbeintopbuttons != null;
	}
	public Boolean getCanBeInTopButtons()
	{
		return this.canbeintopbuttons;
	}
	public void setCanBeInTopButtons(Boolean value)
	{
		this.isValidated = false;
		this.canbeintopbuttons = value;
	}
	public boolean getIsAliasIsNotNull()
	{
		return this.isalias != null;
	}
	public Boolean getIsAlias()
	{
		return this.isalias;
	}
	public void setIsAlias(Boolean value)
	{
		this.isValidated = false;
		this.isalias = value;
	}
	public boolean getLogicClassIsNotNull()
	{
		return this.logicclass != null;
	}
	public String getLogicClass()
	{
		return this.logicclass;
	}
	public static int getLogicClassMaxLength()
	{
		return 200;
	}
	public void setLogicClass(String value)
	{
		this.isValidated = false;
		this.logicclass = value;
	}
	public boolean getAccessClassIsNotNull()
	{
		return this.accessclass != null;
	}
	public String getAccessClass()
	{
		return this.accessclass;
	}
	public static int getAccessClassMaxLength()
	{
		return 200;
	}
	public void setAccessClass(String value)
	{
		this.isValidated = false;
		this.accessclass = value;
	}
	public boolean getDomainImplIsNotNull()
	{
		return this.domainimpl != null;
	}
	public String getDomainImpl()
	{
		return this.domainimpl;
	}
	public static int getDomainImplMaxLength()
	{
		return 200;
	}
	public void setDomainImpl(String value)
	{
		this.isValidated = false;
		this.domainimpl = value;
	}
	public boolean getHelpLinkIsNotNull()
	{
		return this.helplink != null;
	}
	public String getHelpLink()
	{
		return this.helplink;
	}
	public static int getHelpLinkMaxLength()
	{
		return 200;
	}
	public void setHelpLink(String value)
	{
		this.isValidated = false;
		this.helplink = value;
	}
	public boolean getRieBoClassNameIsNotNull()
	{
		return this.rieboclassname != null;
	}
	public String getRieBoClassName()
	{
		return this.rieboclassname;
	}
	public static int getRieBoClassNameMaxLength()
	{
		return 500;
	}
	public void setRieBoClassName(String value)
	{
		this.isValidated = false;
		this.rieboclassname = value;
	}
	public boolean getIsSystemIsNotNull()
	{
		return this.issystem != null;
	}
	public Boolean getIsSystem()
	{
		return this.issystem;
	}
	public void setIsSystem(Boolean value)
	{
		this.isValidated = false;
		this.issystem = value;
	}
	public boolean getMenuActionsIsNotNull()
	{
		return this.menuactions != null;
	}
	public ims.admin.vo.MenuActionVoCollection getMenuActions()
	{
		return this.menuactions;
	}
	public void setMenuActions(ims.admin.vo.MenuActionVoCollection value)
	{
		this.isValidated = false;
		this.menuactions = value;
	}
	public boolean getInformationBarVisibleIsNotNull()
	{
		return this.informationbarvisible != null;
	}
	public Boolean getInformationBarVisible()
	{
		return this.informationbarvisible;
	}
	public void setInformationBarVisible(Boolean value)
	{
		this.isValidated = false;
		this.informationbarvisible = value;
	}
	public boolean getDescriptionIsNotNull()
	{
		return this.description != null;
	}
	public String getDescription()
	{
		return this.description;
	}
	public static int getDescriptionMaxLength()
	{
		return 255;
	}
	public void setDescription(String value)
	{
		this.isValidated = false;
		this.description = value;
	}
	public boolean getImageIsNotNull()
	{
		return this.image != null;
	}
	public ims.admin.vo.AppImageVo getImage()
	{
		return this.image;
	}
	public void setImage(ims.admin.vo.AppImageVo value)
	{
		this.isValidated = false;
		this.image = value;
	}
	/**
	* IAppForm interface methods
	*/
	public int getFormId()
		{
			if (this.getID_AppForm() == null)
				return 0;
			else
				return this.getID_AppForm().intValue();
		}
		public boolean isDialog()
		{
			if (this.getIsDialog() == null)
				return false;
			else 
				return this.getIsDialog().booleanValue();
		}
		public boolean canBeInNavigation()
		{
			if (this.getCanBeInNavigation() == null)
				return false;
			else 
				return this.getCanBeInNavigation().booleanValue();
		}
		public boolean canBeInTopButtons()
		{
			if (this.getCanBeInTopButtons() == null)
				return false;
			else 
				return this.getCanBeInTopButtons().booleanValue();		
		}
	
		public boolean isComponent()
		{
			if (this.getIsComponent() == null)
				return false;
			else 
				return this.getIsComponent().booleanValue();
		}
		public boolean isAlias()
		{
			if (this.getIsAlias() == null)
				return false;
			else 
				return this.getIsAlias().booleanValue();
		}
		public String getGenFormPackageName()
		{
			String formsPackage = "ims." + namespace.getName().toLowerCase() + ".forms." +  name.toLowerCase(); 
			return formsPackage;
		}
		public String getModule()
		{
			StringBuffer sb = new StringBuffer(this.namespace.getName().length() + 1 + this.name.length());
			sb.append(this.namespace.getName());
			sb.append('.');
			sb.append(this.name);
			return sb.toString();
		}
		public boolean isSystem()
		{
			if (this.getIsSystem() == null)
				return false;
			else 
				return this.getIsSystem().booleanValue();
		}
		public boolean isInformationBarVisible()
		{
			if(this.getInformationBarVisible() == null)
				return false;
			else
				return this.getInformationBarVisible().booleanValue();
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
		if(this.name == null || this.name.length() == 0)
			listOfErrors.add("Name is mandatory");
		else if(this.name.length() > 100)
			listOfErrors.add("The length of the field [name] in the value object [ims.emergency.vo.AppFormForTrackingVo] is too big. It should be less or equal to 100");
		if(this.aliasname != null)
			if(this.aliasname.length() > 100)
				listOfErrors.add("The length of the field [aliasname] in the value object [ims.emergency.vo.AppFormForTrackingVo] is too big. It should be less or equal to 100");
		if(this.caption == null || this.caption.length() == 0)
			listOfErrors.add("Caption is mandatory");
		else if(this.caption.length() > 100)
			listOfErrors.add("The length of the field [caption] in the value object [ims.emergency.vo.AppFormForTrackingVo] is too big. It should be less or equal to 100");
		if(this.isdialog == null)
			listOfErrors.add("IsDialog is mandatory");
		if(this.iscomponent == null)
			listOfErrors.add("IsComponent is mandatory");
		if(this.canbeinnavigation == null)
			listOfErrors.add("CanBeInNavigation is mandatory");
		if(this.canbeintopbuttons == null)
			listOfErrors.add("CanBeInTopButtons is mandatory");
		if(this.isalias == null)
			listOfErrors.add("IsAlias is mandatory");
		if(this.logicclass != null)
			if(this.logicclass.length() > 200)
				listOfErrors.add("The length of the field [logicclass] in the value object [ims.emergency.vo.AppFormForTrackingVo] is too big. It should be less or equal to 200");
		if(this.accessclass != null)
			if(this.accessclass.length() > 200)
				listOfErrors.add("The length of the field [accessclass] in the value object [ims.emergency.vo.AppFormForTrackingVo] is too big. It should be less or equal to 200");
		if(this.domainimpl != null)
			if(this.domainimpl.length() > 200)
				listOfErrors.add("The length of the field [domainimpl] in the value object [ims.emergency.vo.AppFormForTrackingVo] is too big. It should be less or equal to 200");
		if(this.helplink != null)
			if(this.helplink.length() > 200)
				listOfErrors.add("The length of the field [helplink] in the value object [ims.emergency.vo.AppFormForTrackingVo] is too big. It should be less or equal to 200");
		if(this.rieboclassname != null)
			if(this.rieboclassname.length() > 500)
				listOfErrors.add("The length of the field [rieboclassname] in the value object [ims.emergency.vo.AppFormForTrackingVo] is too big. It should be less or equal to 500");
		if(this.issystem == null)
			listOfErrors.add("IsSystem is mandatory");
		if(this.description == null || this.description.length() == 0)
			listOfErrors.add("Description is mandatory");
		else if(this.description.length() > 255)
			listOfErrors.add("The length of the field [description] in the value object [ims.emergency.vo.AppFormForTrackingVo] is too big. It should be less or equal to 255");
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
	
		AppFormForTrackingVo clone = new AppFormForTrackingVo(this.id, this.version);
		
		if(this.namespace == null)
			clone.namespace = null;
		else
			clone.namespace = (ims.admin.vo.AppNamespace)this.namespace.clone();
		clone.name = this.name;
		clone.aliasname = this.aliasname;
		clone.caption = this.caption;
		clone.isdialog = this.isdialog;
		clone.iscomponent = this.iscomponent;
		clone.canbeinnavigation = this.canbeinnavigation;
		clone.canbeintopbuttons = this.canbeintopbuttons;
		clone.isalias = this.isalias;
		clone.logicclass = this.logicclass;
		clone.accessclass = this.accessclass;
		clone.domainimpl = this.domainimpl;
		clone.helplink = this.helplink;
		clone.rieboclassname = this.rieboclassname;
		clone.issystem = this.issystem;
		if(this.menuactions == null)
			clone.menuactions = null;
		else
			clone.menuactions = (ims.admin.vo.MenuActionVoCollection)this.menuactions.clone();
		clone.informationbarvisible = this.informationbarvisible;
		clone.description = this.description;
		if(this.image == null)
			clone.image = null;
		else
			clone.image = (ims.admin.vo.AppImageVo)this.image.clone();
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
		if (!(AppFormForTrackingVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A AppFormForTrackingVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((AppFormForTrackingVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((AppFormForTrackingVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.namespace != null)
			count++;
		if(this.name != null)
			count++;
		if(this.aliasname != null)
			count++;
		if(this.caption != null)
			count++;
		if(this.isdialog != null)
			count++;
		if(this.iscomponent != null)
			count++;
		if(this.canbeinnavigation != null)
			count++;
		if(this.canbeintopbuttons != null)
			count++;
		if(this.isalias != null)
			count++;
		if(this.logicclass != null)
			count++;
		if(this.accessclass != null)
			count++;
		if(this.domainimpl != null)
			count++;
		if(this.helplink != null)
			count++;
		if(this.rieboclassname != null)
			count++;
		if(this.issystem != null)
			count++;
		if(this.menuactions != null)
			count++;
		if(this.informationbarvisible != null)
			count++;
		if(this.description != null)
			count++;
		if(this.image != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 19;
	}
	protected ims.admin.vo.AppNamespace namespace;
	protected String name;
	protected String aliasname;
	protected String caption;
	protected Boolean isdialog;
	protected Boolean iscomponent;
	protected Boolean canbeinnavigation;
	protected Boolean canbeintopbuttons;
	protected Boolean isalias;
	protected String logicclass;
	protected String accessclass;
	protected String domainimpl;
	protected String helplink;
	protected String rieboclassname;
	protected Boolean issystem;
	protected ims.admin.vo.MenuActionVoCollection menuactions;
	protected Boolean informationbarvisible;
	protected String description;
	protected ims.admin.vo.AppImageVo image;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
