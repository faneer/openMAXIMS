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

package ims.clinical.vo.beans;

public class DischargeMedicationDetailsVoBean extends ims.vo.ValueObjectBean
{
	public DischargeMedicationDetailsVoBean()
	{
	}
	public DischargeMedicationDetailsVoBean(ims.clinical.vo.DischargeMedicationDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.medicationrecommendations = vo.getMedicationRecommendations();
		this.ttarequired = vo.getTTARequired() == null ? null : (ims.vo.LookupInstanceBean)vo.getTTARequired().getBean();
		this.ttas = vo.getTTAs() == null ? null : vo.getTTAs().getBeanCollection();
		this.admissionmedicationchanges = vo.getAdmissionMedicationChanges() == null ? null : vo.getAdmissionMedicationChanges().getBeanCollection();
		if(vo.getTTAComments() != null)
		{
			this.ttacomments = new ims.vo.RefVoBean[vo.getTTAComments().size()];
			for(int ttacomments_i = 0; ttacomments_i < vo.getTTAComments().size(); ttacomments_i++)
			{
				this.ttacomments[ttacomments_i] = new ims.vo.RefVoBean(vo.getTTAComments().get(ttacomments_i).getBoId(),vo.getTTAComments().get(ttacomments_i).getBoVersion());
			}
		}
		this.ttareceived = vo.getTTAReceived();
	}

	public void populate(ims.vo.ValueObjectBeanMap map, ims.clinical.vo.DischargeMedicationDetailsVo vo)
	{
		this.id = vo.getBoId();
		this.version = vo.getBoVersion();
		this.carecontext = vo.getCareContext() == null ? null : new ims.vo.RefVoBean(vo.getCareContext().getBoId(), vo.getCareContext().getBoVersion());
		this.medicationrecommendations = vo.getMedicationRecommendations();
		this.ttarequired = vo.getTTARequired() == null ? null : (ims.vo.LookupInstanceBean)vo.getTTARequired().getBean();
		this.ttas = vo.getTTAs() == null ? null : vo.getTTAs().getBeanCollection();
		this.admissionmedicationchanges = vo.getAdmissionMedicationChanges() == null ? null : vo.getAdmissionMedicationChanges().getBeanCollection();
		if(vo.getTTAComments() != null)
		{
			this.ttacomments = new ims.vo.RefVoBean[vo.getTTAComments().size()];
			for(int ttacomments_i = 0; ttacomments_i < vo.getTTAComments().size(); ttacomments_i++)
			{
				this.ttacomments[ttacomments_i] = new ims.vo.RefVoBean(vo.getTTAComments().get(ttacomments_i).getBoId(),vo.getTTAComments().get(ttacomments_i).getBoVersion());
			}
		}
		this.ttareceived = vo.getTTAReceived();
	}

	public ims.clinical.vo.DischargeMedicationDetailsVo buildVo()
	{
		return this.buildVo(new ims.vo.ValueObjectBeanMap());
	}

	public ims.clinical.vo.DischargeMedicationDetailsVo buildVo(ims.vo.ValueObjectBeanMap map)
	{
		ims.clinical.vo.DischargeMedicationDetailsVo vo = null;
		if(map != null)
			vo = (ims.clinical.vo.DischargeMedicationDetailsVo)map.getValueObject(this);
		if(vo == null)
		{
			vo = new ims.clinical.vo.DischargeMedicationDetailsVo();
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
	public ims.vo.RefVoBean getCareContext()
	{
		return this.carecontext;
	}
	public void setCareContext(ims.vo.RefVoBean value)
	{
		this.carecontext = value;
	}
	public String getMedicationRecommendations()
	{
		return this.medicationrecommendations;
	}
	public void setMedicationRecommendations(String value)
	{
		this.medicationrecommendations = value;
	}
	public ims.vo.LookupInstanceBean getTTARequired()
	{
		return this.ttarequired;
	}
	public void setTTARequired(ims.vo.LookupInstanceBean value)
	{
		this.ttarequired = value;
	}
	public ims.clinical.vo.beans.TTAMedicationVoBean[] getTTAs()
	{
		return this.ttas;
	}
	public void setTTAs(ims.clinical.vo.beans.TTAMedicationVoBean[] value)
	{
		this.ttas = value;
	}
	public ims.clinical.vo.beans.AdmissionMedicationChangesVoBean[] getAdmissionMedicationChanges()
	{
		return this.admissionmedicationchanges;
	}
	public void setAdmissionMedicationChanges(ims.clinical.vo.beans.AdmissionMedicationChangesVoBean[] value)
	{
		this.admissionmedicationchanges = value;
	}
	public ims.vo.RefVoBean[] getTTAComments()
	{
		return this.ttacomments;
	}
	public void setTTAComments(ims.vo.RefVoBean[] value)
	{
		this.ttacomments = value;
	}
	public Boolean getTTAReceived()
	{
		return this.ttareceived;
	}
	public void setTTAReceived(Boolean value)
	{
		this.ttareceived = value;
	}

	private Integer id;
	private int version;
	private ims.vo.RefVoBean carecontext;
	private String medicationrecommendations;
	private ims.vo.LookupInstanceBean ttarequired;
	private ims.clinical.vo.beans.TTAMedicationVoBean[] ttas;
	private ims.clinical.vo.beans.AdmissionMedicationChangesVoBean[] admissionmedicationchanges;
	private ims.vo.RefVoBean[] ttacomments;
	private Boolean ttareceived;
}
