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

package ims.ocrr.vo.beans;

public class PathologySpecimenVoBean extends ims.vo.ValueObjectBean
{
	public PathologySpecimenVoBean()
	{
	}
	public PathologySpecimenVoBean(ims.ocrr.vo.PathologySpecimenVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.specimensource = vo.getSpecimenSource() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecimenSource().getBean();
		this.sitecd = vo.getSiteCd() == null ? null : (ims.vo.LookupInstanceBean)vo.getSiteCd().getBean();
		this.resultconclusioncomments = vo.getResultConclusionComments() == null ? null : vo.getResultConclusionComments().getBeanCollection();
		this.coltimefillersupplied = vo.getColTimeFillerSupplied();
		this.colldatetimeplacer = vo.getCollDateTimePlacer() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCollDateTimePlacer().getBean();
		this.receiveddatetime = vo.getReceivedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getReceivedDateTime().getBean();
		this.receivedtimesupplied = vo.getReceivedTimeSupplied();
		this.investigations = vo.getInvestigations() == null ? null : vo.getInvestigations().getBeanCollection();
		this.order = vo.getOrder() == null ? null : (ims.ocrr.vo.beans.NewResultOcsOrderVoBean)vo.getOrder().getBean();
		this.fillerordnum = vo.getFillerOrdNum();
		this.discipline = vo.getDiscipline() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getDiscipline().getBean();
		this.ispatientcollect = vo.getIsPatientCollect();
		this.isawaitingcollection = vo.getIsAwaitingCollection();
		this.colldatetimefiller = vo.getCollDateTimeFiller() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCollDateTimeFiller().getBean();
		this.requestedtype = vo.getRequestedType() == null ? null : (ims.vo.LookupInstanceBean)vo.getRequestedType().getBean();
		this.placerordnum = vo.getPlacerOrdNum();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.ocrr.vo.PathologySpecimenVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.specimensource = vo.getSpecimenSource() == null ? null : (ims.vo.LookupInstanceBean)vo.getSpecimenSource().getBean();
		this.sitecd = vo.getSiteCd() == null ? null : (ims.vo.LookupInstanceBean)vo.getSiteCd().getBean();
		this.resultconclusioncomments = vo.getResultConclusionComments() == null ? null : vo.getResultConclusionComments().getBeanCollection();
		this.coltimefillersupplied = vo.getColTimeFillerSupplied();
		this.colldatetimeplacer = vo.getCollDateTimePlacer() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCollDateTimePlacer().getBean();
		this.receiveddatetime = vo.getReceivedDateTime() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getReceivedDateTime().getBean();
		this.receivedtimesupplied = vo.getReceivedTimeSupplied();
		this.investigations = vo.getInvestigations() == null ? null : vo.getInvestigations().getBeanCollection();
		this.order = vo.getOrder() == null ? null : (ims.ocrr.vo.beans.NewResultOcsOrderVoBean)vo.getOrder().getBean(map);
		this.fillerordnum = vo.getFillerOrdNum();
		this.discipline = vo.getDiscipline() == null ? null : (ims.core.vo.beans.ServiceLiteVoBean)vo.getDiscipline().getBean(map);
		this.ispatientcollect = vo.getIsPatientCollect();
		this.isawaitingcollection = vo.getIsAwaitingCollection();
		this.colldatetimefiller = vo.getCollDateTimeFiller() == null ? null : (ims.framework.utils.beans.DateTimeBean)vo.getCollDateTimeFiller().getBean();
		this.requestedtype = vo.getRequestedType() == null ? null : (ims.vo.LookupInstanceBean)vo.getRequestedType().getBean();
		this.placerordnum = vo.getPlacerOrdNum();
	}

	public ims.ocrr.vo.PathologySpecimenVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.ocrr.vo.PathologySpecimenVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.ocrr.vo.PathologySpecimenVo vo = null;
		if(map != null)
			vo = (ims.ocrr.vo.PathologySpecimenVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.ocrr.vo.PathologySpecimenVo();
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
	public ims.vo.LookupInstanceBean getSpecimenSource()
	{
		return this.specimensource;
	}
	public void setSpecimenSource(ims.vo.LookupInstanceBean value)
	{
		this.specimensource = value;
	}
	public ims.vo.LookupInstanceBean getSiteCd()
	{
		return this.sitecd;
	}
	public void setSiteCd(ims.vo.LookupInstanceBean value)
	{
		this.sitecd = value;
	}
	public ims.ocrr.vo.beans.ResultCommentsLiteVoBean[] getResultConclusionComments()
	{
		return this.resultconclusioncomments;
	}
	public void setResultConclusionComments(ims.ocrr.vo.beans.ResultCommentsLiteVoBean[] value)
	{
		this.resultconclusioncomments = value;
	}
	public Boolean getColTimeFillerSupplied()
	{
		return this.coltimefillersupplied;
	}
	public void setColTimeFillerSupplied(Boolean value)
	{
		this.coltimefillersupplied = value;
	}
	public ims.framework.utils.beans.DateTimeBean getCollDateTimePlacer()
	{
		return this.colldatetimeplacer;
	}
	public void setCollDateTimePlacer(ims.framework.utils.beans.DateTimeBean value)
	{
		this.colldatetimeplacer = value;
	}
	public ims.framework.utils.beans.DateTimeBean getReceivedDateTime()
	{
		return this.receiveddatetime;
	}
	public void setReceivedDateTime(ims.framework.utils.beans.DateTimeBean value)
	{
		this.receiveddatetime = value;
	}
	public Boolean getReceivedTimeSupplied()
	{
		return this.receivedtimesupplied;
	}
	public void setReceivedTimeSupplied(Boolean value)
	{
		this.receivedtimesupplied = value;
	}
	public ims.ocrr.vo.beans.PathologySpecimenOrderInvestigationVoBean[] getInvestigations()
	{
		return this.investigations;
	}
	public void setInvestigations(ims.ocrr.vo.beans.PathologySpecimenOrderInvestigationVoBean[] value)
	{
		this.investigations = value;
	}
	public ims.ocrr.vo.beans.NewResultOcsOrderVoBean getOrder()
	{
		return this.order;
	}
	public void setOrder(ims.ocrr.vo.beans.NewResultOcsOrderVoBean value)
	{
		this.order = value;
	}
	public String getFillerOrdNum()
	{
		return this.fillerordnum;
	}
	public void setFillerOrdNum(String value)
	{
		this.fillerordnum = value;
	}
	public ims.core.vo.beans.ServiceLiteVoBean getDiscipline()
	{
		return this.discipline;
	}
	public void setDiscipline(ims.core.vo.beans.ServiceLiteVoBean value)
	{
		this.discipline = value;
	}
	public Boolean getIsPatientCollect()
	{
		return this.ispatientcollect;
	}
	public void setIsPatientCollect(Boolean value)
	{
		this.ispatientcollect = value;
	}
	public Boolean getIsAwaitingCollection()
	{
		return this.isawaitingcollection;
	}
	public void setIsAwaitingCollection(Boolean value)
	{
		this.isawaitingcollection = value;
	}
	public ims.framework.utils.beans.DateTimeBean getCollDateTimeFiller()
	{
		return this.colldatetimefiller;
	}
	public void setCollDateTimeFiller(ims.framework.utils.beans.DateTimeBean value)
	{
		this.colldatetimefiller = value;
	}
	public ims.vo.LookupInstanceBean getRequestedType()
	{
		return this.requestedtype;
	}
	public void setRequestedType(ims.vo.LookupInstanceBean value)
	{
		this.requestedtype = value;
	}
	public String getPlacerOrdNum()
	{
		return this.placerordnum;
	}
	public void setPlacerOrdNum(String value)
	{
		this.placerordnum = value;
	}

	private Integer id;
	private int version;
	private ims.vo.LookupInstanceBean specimensource;
	private ims.vo.LookupInstanceBean sitecd;
	private ims.ocrr.vo.beans.ResultCommentsLiteVoBean[] resultconclusioncomments;
	private Boolean coltimefillersupplied;
	private ims.framework.utils.beans.DateTimeBean colldatetimeplacer;
	private ims.framework.utils.beans.DateTimeBean receiveddatetime;
	private Boolean receivedtimesupplied;
	private ims.ocrr.vo.beans.PathologySpecimenOrderInvestigationVoBean[] investigations;
	private ims.ocrr.vo.beans.NewResultOcsOrderVoBean order;
	private String fillerordnum;
	private ims.core.vo.beans.ServiceLiteVoBean discipline;
	private Boolean ispatientcollect;
	private Boolean isawaitingcollection;
	private ims.framework.utils.beans.DateTimeBean colldatetimefiller;
	private ims.vo.LookupInstanceBean requestedtype;
	private String placerordnum;
}
