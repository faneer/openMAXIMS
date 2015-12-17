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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 4084.19189)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.RefMan.domain.impl;

import ims.RefMan.domain.ClinicalNotesCustomControl;
import ims.RefMan.domain.base.impl.BasePatientDiagnosisDialogImpl;
import ims.RefMan.vo.CatsReferralForClinicalNotesVo;
import ims.RefMan.vo.CatsReferralRefVo;
import ims.RefMan.vo.ReferralClinicalNotesVo;
import ims.core.vo.DiagLiteVo;
import ims.core.vo.DiagLiteVoCollection;
import ims.domain.DomainFactory;
import ims.domain.exceptions.StaleObjectException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientDiagnosisDialogImpl extends BasePatientDiagnosisDialogImpl
{
	private static final long serialVersionUID = 1L;

	public DiagLiteVoCollection listDianosis(String diagSearch, String listOfExistingDiagnosis)
	{
		if(diagSearch == null)
			return null;
		
		diagSearch = diagSearch.trim().toUpperCase();
		
		if(diagSearch == null || diagSearch.length() == 0)
			return null;
		
		DomainFactory factory = getDomainFactory();
        Connection conection = factory.getJdbcConnection();
        
        StringBuffer sql = new StringBuffer();
        
        sql.append("select a.id, a.diagnosisn from core_diagnosis a LEFT OUTER JOIN core_diagnosis_keywords k ON a.id = k.id where (k.keyword like ? or a.diagnosisn like ?) and a.isactive = 1 ");
        
        if (listOfExistingDiagnosis != null && listOfExistingDiagnosis.trim().length() > 0)
		{
        	sql.append(" and a.id not in ("+listOfExistingDiagnosis+")");
		}
        
        sql.append(" order by upper(a.diagnosisn)");
        
        DiagLiteVoCollection diagnosisColl = new DiagLiteVoCollection();
        PreparedStatement ps;	
    		
        try 
        {
        	ps = conection.prepareCall(sql.toString());
        	ps.setString(1, diagSearch + "%");
        	ps.setString(2, diagSearch + "%");
        
        	ResultSet rs = ps.executeQuery();
        
        	while(rs.next())
        	{
        		DiagLiteVo vo = new DiagLiteVo();
        		vo.setID_Diagnosis(Integer.valueOf(rs.getString(1)));
        		vo.setDiagnosisName(rs.getString(2));
        		diagnosisColl.add(vo);
        	}
        }
        catch (SQLException e) 
        {
        	e.printStackTrace();
        }
        
        return diagnosisColl;
	}

	public Boolean saveReferralClinicalNotes(ReferralClinicalNotesVo referralClinicalNotes) throws StaleObjectException
	{
		ClinicalNotesCustomControl impl = (ClinicalNotesCustomControl) getDomainImpl(ClinicalNotesCustomControlImpl.class);
		return impl.saveReferralClinicalNotes(referralClinicalNotes);
	}

	public CatsReferralForClinicalNotesVo getReferral(CatsReferralRefVo referral)
	{
		ClinicalNotesCustomControl impl = (ClinicalNotesCustomControl) getDomainImpl(ClinicalNotesCustomControlImpl.class);
		return impl.getReferral(referral);
	}

	public ReferralClinicalNotesVo getReferralClinicalNotes(CatsReferralRefVo referral)
	{
		ClinicalNotesCustomControl impl = (ClinicalNotesCustomControl) getDomainImpl(ClinicalNotesCustomControlImpl.class);
		return impl.getReferralClinicalNotes(referral);
	}
}
