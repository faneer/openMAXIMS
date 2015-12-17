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

package ims.ocrr.vo;

/**
 * Linked to OCRR.Configuration.PathSpecimenContainer business object (ID: 1058100007).
 */
public class PathSpecimenContainerDetailVo extends ims.ocrr.configuration.vo.PathSpecimenContainerRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public PathSpecimenContainerDetailVo()
	{
	}
	public PathSpecimenContainerDetailVo(Integer id, int version)
	{
		super(id, version);
	}
	public PathSpecimenContainerDetailVo(ims.ocrr.vo.beans.PathSpecimenContainerDetailVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.volume = bean.getVolume();
		this.volumeunits = bean.getVolumeUnits() == null ? null : ims.ocrr.vo.lookups.PathVolumeUnits.buildLookup(bean.getVolumeUnits());
		this.alternativevol = bean.getAlternativeVol();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.beans.PathSpecimenContainerDetailVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.name = bean.getName();
		this.volume = bean.getVolume();
		this.volumeunits = bean.getVolumeUnits() == null ? null : ims.ocrr.vo.lookups.PathVolumeUnits.buildLookup(bean.getVolumeUnits());
		this.alternativevol = bean.getAlternativeVol();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.beans.PathSpecimenContainerDetailVoBean bean = null;
		if(map != null)
			bean = (ims.ocrr.vo.beans.PathSpecimenContainerDetailVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.ocrr.vo.beans.PathSpecimenContainerDetailVoBean();
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
		if(fieldName.equals("NAME"))
			return getName();
		if(fieldName.equals("VOLUME"))
			return getVolume();
		if(fieldName.equals("VOLUMEUNITS"))
			return getVolumeUnits();
		if(fieldName.equals("ALTERNATIVEVOL"))
			return getAlternativeVol();
		return super.getFieldValueByFieldName(fieldName);
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
		return 50;
	}
	public void setName(String value)
	{
		this.isValidated = false;
		this.name = value;
	}
	public boolean getVolumeIsNotNull()
	{
		return this.volume != null;
	}
	public Float getVolume()
	{
		return this.volume;
	}
	public void setVolume(Float value)
	{
		this.isValidated = false;
		this.volume = value;
	}
	public boolean getVolumeUnitsIsNotNull()
	{
		return this.volumeunits != null;
	}
	public ims.ocrr.vo.lookups.PathVolumeUnits getVolumeUnits()
	{
		return this.volumeunits;
	}
	public void setVolumeUnits(ims.ocrr.vo.lookups.PathVolumeUnits value)
	{
		this.isValidated = false;
		this.volumeunits = value;
	}
	public boolean getAlternativeVolIsNotNull()
	{
		return this.alternativevol != null;
	}
	public Float getAlternativeVol()
	{
		return this.alternativevol;
	}
	public void setAlternativeVol(Float value)
	{
		this.isValidated = false;
		this.alternativevol = value;
	}
	/**
	* toString
	*/
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		if(this.name != null)
			sb.append(this.name);
		sb.append(" ( Cap: ");
		if(this.volume != null)
			sb.append(this.volume);
		else
		{
			sb.append("N/A )");
			return sb.toString();
		}
		sb.append(" ");
		if(this.volumeunits != null)
			sb.append(this.volumeunits);
		sb.append(" )");
		return sb.toString();
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
		else if(this.name.length() > 50)
			listOfErrors.add("The length of the field [name] in the value object [ims.ocrr.vo.PathSpecimenContainerDetailVo] is too big. It should be less or equal to 50");
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
	
		PathSpecimenContainerDetailVo clone = new PathSpecimenContainerDetailVo(this.id, this.version);
		
		clone.name = this.name;
		clone.volume = this.volume;
		if(this.volumeunits == null)
			clone.volumeunits = null;
		else
			clone.volumeunits = (ims.ocrr.vo.lookups.PathVolumeUnits)this.volumeunits.clone();
		clone.alternativevol = this.alternativevol;
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
		if (!(PathSpecimenContainerDetailVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A PathSpecimenContainerDetailVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((PathSpecimenContainerDetailVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((PathSpecimenContainerDetailVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.name != null)
			count++;
		if(this.volume != null)
			count++;
		if(this.volumeunits != null)
			count++;
		if(this.alternativevol != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 4;
	}
	protected String name;
	protected Float volume;
	protected ims.ocrr.vo.lookups.PathVolumeUnits volumeunits;
	protected Float alternativevol;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
