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

package ims.emergency.vo.beans;

public class TriageKPIUnboundDBVoBean extends ims.vo.ValueObjectBean
{
	public TriageKPIUnboundDBVoBean()
	{
	}
	public TriageKPIUnboundDBVoBean(ims.emergency.vo.TriageKPIUnboundDBVo vo)
	{
		this.breachwarning = vo.getBreachWarning();
		this.breachedkpi = vo.getBreachedKPI();
		this.typerow = vo.getTypeRow();
		this.breachwarningflashingtext = vo.getBreachWarningFlashingText() == null ? null : (ims.vo.LookupInstanceBean)vo.getBreachWarningFlashingText().getBean();
		this.breachwarningtextcolour = vo.getBreachWarningTextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getBreachWarningTextColour().getBean();
		this.breachwarningflashingtextcolour = vo.getBreachWarningFlashingTextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getBreachWarningFlashingTextColour().getBean();
		this.breachwarningbackgroundcolour = vo.getBreachWarningBackgroundColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getBreachWarningBackgroundColour().getBean();
		this.breachedkpiflashingtext = vo.getBreachedKPIFlashingText() == null ? null : (ims.vo.LookupInstanceBean)vo.getBreachedKPIFlashingText().getBean();
		this.breachedkpitextcolour = vo.getBreachedKPITextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getBreachedKPITextColour().getBean();
		this.breachedkpiflashingtextcolour = vo.getBreachedKPIFlashingTextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getBreachedKPIFlashingTextColour().getBean();
		this.breachedkpibackgroundcolour = vo.getBreachedKPIBackgroundColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getBreachedKPIBackgroundColour().getBean();
		this.defaultrowcolour = vo.getDefaultRowColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getDefaultRowColour().getBean();
		this.defaultfontcolour = vo.getDefaultFontColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getDefaultFontColour().getBean();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.emergency.vo.TriageKPIUnboundDBVo vo)
	{
		this.breachwarning = vo.getBreachWarning();
		this.breachedkpi = vo.getBreachedKPI();
		this.typerow = vo.getTypeRow();
		this.breachwarningflashingtext = vo.getBreachWarningFlashingText() == null ? null : (ims.vo.LookupInstanceBean)vo.getBreachWarningFlashingText().getBean();
		this.breachwarningtextcolour = vo.getBreachWarningTextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getBreachWarningTextColour().getBean();
		this.breachwarningflashingtextcolour = vo.getBreachWarningFlashingTextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getBreachWarningFlashingTextColour().getBean();
		this.breachwarningbackgroundcolour = vo.getBreachWarningBackgroundColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getBreachWarningBackgroundColour().getBean();
		this.breachedkpiflashingtext = vo.getBreachedKPIFlashingText() == null ? null : (ims.vo.LookupInstanceBean)vo.getBreachedKPIFlashingText().getBean();
		this.breachedkpitextcolour = vo.getBreachedKPITextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getBreachedKPITextColour().getBean();
		this.breachedkpiflashingtextcolour = vo.getBreachedKPIFlashingTextColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getBreachedKPIFlashingTextColour().getBean();
		this.breachedkpibackgroundcolour = vo.getBreachedKPIBackgroundColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getBreachedKPIBackgroundColour().getBean();
		this.defaultrowcolour = vo.getDefaultRowColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getDefaultRowColour().getBean();
		this.defaultfontcolour = vo.getDefaultFontColour() == null ? null : (ims.framework.utils.beans.ColorBean)vo.getDefaultFontColour().getBean();
	}

	public ims.emergency.vo.TriageKPIUnboundDBVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.emergency.vo.TriageKPIUnboundDBVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.emergency.vo.TriageKPIUnboundDBVo vo = null;
		if(map != null)
			vo = (ims.emergency.vo.TriageKPIUnboundDBVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.emergency.vo.TriageKPIUnboundDBVo();
			map.addValueObject(this, vo);
			vo.populate(map, this);
		}
		return vo;
	}

	public Integer getBreachWarning()
	{
		return this.breachwarning;
	}
	public void setBreachWarning(Integer value)
	{
		this.breachwarning = value;
	}
	public Integer getBreachedKPI()
	{
		return this.breachedkpi;
	}
	public void setBreachedKPI(Integer value)
	{
		this.breachedkpi = value;
	}
	public String getTypeRow()
	{
		return this.typerow;
	}
	public void setTypeRow(String value)
	{
		this.typerow = value;
	}
	public ims.vo.LookupInstanceBean getBreachWarningFlashingText()
	{
		return this.breachwarningflashingtext;
	}
	public void setBreachWarningFlashingText(ims.vo.LookupInstanceBean value)
	{
		this.breachwarningflashingtext = value;
	}
	public ims.framework.utils.beans.ColorBean getBreachWarningTextColour()
	{
		return this.breachwarningtextcolour;
	}
	public void setBreachWarningTextColour(ims.framework.utils.beans.ColorBean value)
	{
		this.breachwarningtextcolour = value;
	}
	public ims.framework.utils.beans.ColorBean getBreachWarningFlashingTextColour()
	{
		return this.breachwarningflashingtextcolour;
	}
	public void setBreachWarningFlashingTextColour(ims.framework.utils.beans.ColorBean value)
	{
		this.breachwarningflashingtextcolour = value;
	}
	public ims.framework.utils.beans.ColorBean getBreachWarningBackgroundColour()
	{
		return this.breachwarningbackgroundcolour;
	}
	public void setBreachWarningBackgroundColour(ims.framework.utils.beans.ColorBean value)
	{
		this.breachwarningbackgroundcolour = value;
	}
	public ims.vo.LookupInstanceBean getBreachedKPIFlashingText()
	{
		return this.breachedkpiflashingtext;
	}
	public void setBreachedKPIFlashingText(ims.vo.LookupInstanceBean value)
	{
		this.breachedkpiflashingtext = value;
	}
	public ims.framework.utils.beans.ColorBean getBreachedKPITextColour()
	{
		return this.breachedkpitextcolour;
	}
	public void setBreachedKPITextColour(ims.framework.utils.beans.ColorBean value)
	{
		this.breachedkpitextcolour = value;
	}
	public ims.framework.utils.beans.ColorBean getBreachedKPIFlashingTextColour()
	{
		return this.breachedkpiflashingtextcolour;
	}
	public void setBreachedKPIFlashingTextColour(ims.framework.utils.beans.ColorBean value)
	{
		this.breachedkpiflashingtextcolour = value;
	}
	public ims.framework.utils.beans.ColorBean getBreachedKPIBackgroundColour()
	{
		return this.breachedkpibackgroundcolour;
	}
	public void setBreachedKPIBackgroundColour(ims.framework.utils.beans.ColorBean value)
	{
		this.breachedkpibackgroundcolour = value;
	}
	public ims.framework.utils.beans.ColorBean getDefaultRowColour()
	{
		return this.defaultrowcolour;
	}
	public void setDefaultRowColour(ims.framework.utils.beans.ColorBean value)
	{
		this.defaultrowcolour = value;
	}
	public ims.framework.utils.beans.ColorBean getDefaultFontColour()
	{
		return this.defaultfontcolour;
	}
	public void setDefaultFontColour(ims.framework.utils.beans.ColorBean value)
	{
		this.defaultfontcolour = value;
	}

	private Integer breachwarning;
	private Integer breachedkpi;
	private String typerow;
	private ims.vo.LookupInstanceBean breachwarningflashingtext;
	private ims.framework.utils.beans.ColorBean breachwarningtextcolour;
	private ims.framework.utils.beans.ColorBean breachwarningflashingtextcolour;
	private ims.framework.utils.beans.ColorBean breachwarningbackgroundcolour;
	private ims.vo.LookupInstanceBean breachedkpiflashingtext;
	private ims.framework.utils.beans.ColorBean breachedkpitextcolour;
	private ims.framework.utils.beans.ColorBean breachedkpiflashingtextcolour;
	private ims.framework.utils.beans.ColorBean breachedkpibackgroundcolour;
	private ims.framework.utils.beans.ColorBean defaultrowcolour;
	private ims.framework.utils.beans.ColorBean defaultfontcolour;
}
