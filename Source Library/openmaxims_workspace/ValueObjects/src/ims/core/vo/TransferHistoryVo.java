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
 * Linked to core.admin.pas.TransferHistory business object (ID: 1014100016).
 */
public class TransferHistoryVo extends ims.core.admin.pas.vo.TransferHistoryRefVo implements ims.vo.ImsCloneable, Comparable
{
	private static final long serialVersionUID = 1L;

	public TransferHistoryVo()
	{
	}
	public TransferHistoryVo(Integer id, int version)
	{
		super(id, version);
	}
	public TransferHistoryVo(ims.core.vo.beans.TransferHistoryVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.transferringfromward = bean.getTransferringFromWard() == null ? null : bean.getTransferringFromWard().buildVo();
		this.markedfortransferoutdatetime = bean.getMarkedForTransferOutDateTime() == null ? null : bean.getMarkedForTransferOutDateTime().buildDateTime();
		this.acceptingorrejectingward = bean.getAcceptingOrRejectingWard() == null ? null : bean.getAcceptingOrRejectingWard().buildVo();
		this.accepttransferdatetime = bean.getAcceptTransferDateTime() == null ? null : bean.getAcceptTransferDateTime().buildDateTime();
		this.rejecttransferdatetime = bean.getRejectTransferDateTime() == null ? null : bean.getRejectTransferDateTime().buildDateTime();
	}
	public void populate(ims.vo.ValueObjectBeanMap map, ims.core.vo.beans.TransferHistoryVoBean bean)
	{
		this.id = bean.getId();
		this.version = bean.getVersion();
		this.transferringfromward = bean.getTransferringFromWard() == null ? null : bean.getTransferringFromWard().buildVo(map);
		this.markedfortransferoutdatetime = bean.getMarkedForTransferOutDateTime() == null ? null : bean.getMarkedForTransferOutDateTime().buildDateTime();
		this.acceptingorrejectingward = bean.getAcceptingOrRejectingWard() == null ? null : bean.getAcceptingOrRejectingWard().buildVo(map);
		this.accepttransferdatetime = bean.getAcceptTransferDateTime() == null ? null : bean.getAcceptTransferDateTime().buildDateTime();
		this.rejecttransferdatetime = bean.getRejectTransferDateTime() == null ? null : bean.getRejectTransferDateTime().buildDateTime();
	}
	public ims.vo.ValueObjectBean getBean()
	{
		return this.getBean(new ims.vo.ValueObjectBeanMap());
	}
	public ims.vo.ValueObjectBean getBean(ims.vo.ValueObjectBeanMap map)
	{
		ims.core.vo.beans.TransferHistoryVoBean bean = null;
		if(map != null)
			bean = (ims.core.vo.beans.TransferHistoryVoBean)map.getValueObjectBean(this);
		if (bean == null)
		{
			bean = new ims.core.vo.beans.TransferHistoryVoBean();
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
		if(fieldName.equals("TRANSFERRINGFROMWARD"))
			return getTransferringFromWard();
		if(fieldName.equals("MARKEDFORTRANSFEROUTDATETIME"))
			return getMarkedForTransferOutDateTime();
		if(fieldName.equals("ACCEPTINGORREJECTINGWARD"))
			return getAcceptingOrRejectingWard();
		if(fieldName.equals("ACCEPTTRANSFERDATETIME"))
			return getAcceptTransferDateTime();
		if(fieldName.equals("REJECTTRANSFERDATETIME"))
			return getRejectTransferDateTime();
		return super.getFieldValueByFieldName(fieldName);
	}
	public boolean getTransferringFromWardIsNotNull()
	{
		return this.transferringfromward != null;
	}
	public ims.core.vo.LocationLiteVo getTransferringFromWard()
	{
		return this.transferringfromward;
	}
	public void setTransferringFromWard(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.transferringfromward = value;
	}
	public boolean getMarkedForTransferOutDateTimeIsNotNull()
	{
		return this.markedfortransferoutdatetime != null;
	}
	public ims.framework.utils.DateTime getMarkedForTransferOutDateTime()
	{
		return this.markedfortransferoutdatetime;
	}
	public void setMarkedForTransferOutDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.markedfortransferoutdatetime = value;
	}
	public boolean getAcceptingOrRejectingWardIsNotNull()
	{
		return this.acceptingorrejectingward != null;
	}
	public ims.core.vo.LocationLiteVo getAcceptingOrRejectingWard()
	{
		return this.acceptingorrejectingward;
	}
	public void setAcceptingOrRejectingWard(ims.core.vo.LocationLiteVo value)
	{
		this.isValidated = false;
		this.acceptingorrejectingward = value;
	}
	public boolean getAcceptTransferDateTimeIsNotNull()
	{
		return this.accepttransferdatetime != null;
	}
	public ims.framework.utils.DateTime getAcceptTransferDateTime()
	{
		return this.accepttransferdatetime;
	}
	public void setAcceptTransferDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.accepttransferdatetime = value;
	}
	public boolean getRejectTransferDateTimeIsNotNull()
	{
		return this.rejecttransferdatetime != null;
	}
	public ims.framework.utils.DateTime getRejectTransferDateTime()
	{
		return this.rejecttransferdatetime;
	}
	public void setRejectTransferDateTime(ims.framework.utils.DateTime value)
	{
		this.isValidated = false;
		this.rejecttransferdatetime = value;
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
	
		TransferHistoryVo clone = new TransferHistoryVo(this.id, this.version);
		
		if(this.transferringfromward == null)
			clone.transferringfromward = null;
		else
			clone.transferringfromward = (ims.core.vo.LocationLiteVo)this.transferringfromward.clone();
		if(this.markedfortransferoutdatetime == null)
			clone.markedfortransferoutdatetime = null;
		else
			clone.markedfortransferoutdatetime = (ims.framework.utils.DateTime)this.markedfortransferoutdatetime.clone();
		if(this.acceptingorrejectingward == null)
			clone.acceptingorrejectingward = null;
		else
			clone.acceptingorrejectingward = (ims.core.vo.LocationLiteVo)this.acceptingorrejectingward.clone();
		if(this.accepttransferdatetime == null)
			clone.accepttransferdatetime = null;
		else
			clone.accepttransferdatetime = (ims.framework.utils.DateTime)this.accepttransferdatetime.clone();
		if(this.rejecttransferdatetime == null)
			clone.rejecttransferdatetime = null;
		else
			clone.rejecttransferdatetime = (ims.framework.utils.DateTime)this.rejecttransferdatetime.clone();
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
		if (!(TransferHistoryVo.class.isAssignableFrom(obj.getClass())))
		{
			throw new ClassCastException("A TransferHistoryVo object cannot be compared an Object of type " + obj.getClass().getName());
		}
		if (this.id == null)
			return 1;
		if (((TransferHistoryVo)obj).getBoId() == null)
			return -1;
		return this.id.compareTo(((TransferHistoryVo)obj).getBoId());
	}
	public synchronized static int generateValueObjectUniqueID()
	{
		return ims.vo.ValueObject.generateUniqueID();
	}
	public int countFieldsWithValue()
	{
		int count = 0;
		if(this.transferringfromward != null)
			count++;
		if(this.markedfortransferoutdatetime != null)
			count++;
		if(this.acceptingorrejectingward != null)
			count++;
		if(this.accepttransferdatetime != null)
			count++;
		if(this.rejecttransferdatetime != null)
			count++;
		return count;
	}
	public int countValueObjectFields()
	{
		return 5;
	}
	protected ims.core.vo.LocationLiteVo transferringfromward;
	protected ims.framework.utils.DateTime markedfortransferoutdatetime;
	protected ims.core.vo.LocationLiteVo acceptingorrejectingward;
	protected ims.framework.utils.DateTime accepttransferdatetime;
	protected ims.framework.utils.DateTime rejecttransferdatetime;
	private boolean isValidated = false;
	private boolean isBusy = false;
}
