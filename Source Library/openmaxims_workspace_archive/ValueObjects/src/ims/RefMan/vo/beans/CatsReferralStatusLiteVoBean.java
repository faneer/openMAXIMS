// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.vo.beans;

public class CatsReferralStatusLiteVoBean extends ims.vo.ValueObjectBean
{
	public CatsReferralStatusLiteVoBean()
	{
	}
	public CatsReferralStatusLiteVoBean(ims.RefMan.vo.CatsReferralStatusLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.referralstatus = vo.getReferralStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferralStatus().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.RefMan.vo.CatsReferralStatusLiteVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.referralstatus = vo.getReferralStatus() == null ? null : (ims.vo.LookupInstanceBean)vo.getReferralStatus().getBean();
	}

	public ims.RefMan.vo.CatsReferralStatusLiteVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.RefMan.vo.CatsReferralStatusLiteVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.RefMan.vo.CatsReferralStatusLiteVo vo = null;
		if(map != null)
			vo = (ims.RefMan.vo.CatsReferralStatusLiteVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.RefMan.vo.CatsReferralStatusLiteVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getId()
	{
		return this.id;
	}
	public void setId(Integer value)
	{
		this.id = value;
	}
	public int getVersion()
	{
		return this.version;
	}
	public void setVersion(int value)
	{
		this.version = value;
	}
	public ims.vo.LookupInstanceBean getReferralStatus()
	{
		return this.referralstatus;
	}
	public void setReferralStatus(ims.vo.LookupInstanceBean value)
	{
		this.referralstatus = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean referralstatus;
}
