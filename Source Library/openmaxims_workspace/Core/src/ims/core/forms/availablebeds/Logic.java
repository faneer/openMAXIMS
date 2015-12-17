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
// This code was generated by Ander Telleria using IMS Development Environment (version 1.66 build 3261.22124)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.availablebeds;

import ims.configuration.gen.ConfigFlag;
import ims.core.forms.availablebeds.GenForm.grdAvailableBedsRow;
import ims.core.forms.currentinpatientlistcomponent.GenForm;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.AvailableBedsVo;
import ims.core.vo.BedSpaceStateLiteVo;
import ims.core.vo.BedSpaceStateLiteVoCollection;
import ims.core.vo.LocMostVo;
import ims.core.vo.LocationLiteVo;
import ims.core.vo.LocationLiteVoCollection;
import ims.core.vo.lookups.LocationType;
import ims.core.vo.lookups.WardBayStatus;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.Control;
import ims.framework.FormName;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.PresentationLogicException;

import com.ims.query.builder.client.QueryBuilderClient;
import com.ims.query.builder.client.SeedValue;
import com.ims.query.builder.client.exceptions.QueryBuilderClientException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	private static final int COL_BED_NO = 3;
	@Override
	protected void onQmbWardTextSubmited(String value) throws ims.framework.exceptions.PresentationLogicException
	{
		if (form.cmbHospital().getValue() == null)
		{
			engine.showMessage("Please select a Hospital.");
			return;
		}
	
		LocationLiteVoCollection wards = domain.listWards(form.cmbHospital().getValue().getID_Location(), value);
		if (wards!=null)
		{
			for (LocationLiteVo item: wards)
				form.qmbWard().newRow(item, item.getName());
		}
		if (wards.size() == 1) //WDEV-22223
		{	
			form.qmbWard().setValue(wards.get(0));
		}	
		else
		{			
			form.qmbWard().showOpened();
		}	
	}
	
	@Override
	protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clearControls();
		form.lbl6().setValue("Total: 0");

		form.getGlobalContext().STHK.setAvailableBedsListFilter(null);
		form.getContextMenus().hideAllGenericGridMenuItems();

		//Clear the selected patient information in the Engine
		form.getGlobalContext().Core.setPatientShort(null);
		form.getGlobalContext().Core.setPatientToBeDisplayed(null);
		form.getLocalContext().setSortOrderBedNo(null);
		engine.setPatientInfo("Please enter Patient ID or Surname and/or Forename");
	}
	
	private void clearControls() 
	{
		form.grdAvailableBeds().getRows().clear();
		
		form.cmbHospital().setValue(null);
		form.qmbWard().clear();
		form.qmbWard().setValue(null);
		form.cmbBedStatus().setValue(null);
		form.cmbBedType().setValue(null);
		form.cmbSideRoom().setValue(null);
	}
	@Override
	protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		search();
	}

	private void search() 
	{
		AvailableBedsVo beds = populateDataFromScreen();
		
		form.getGlobalContext().STHK.setAvailableBedsListFilter(beds);
		form.getContextMenus().hideAllGenericGridMenuItems();

		form.grdAvailableBeds().getRows().clear();
		form.lbl6().setValue("Total: 0"); // WDEV-18099 
		BedSpaceStateLiteVoCollection availableBeds = null;
		form.getLocalContext().setSortOrderBedNo(null);
		
		if (beds.countFieldsWithValue() > 0)
		{
			availableBeds  = domain.listAvailableBeds(beds);
		}
		else
		{
			engine.showMessage("Please enter some valid search criteria.", "Invalid search criteria", MessageButtons.OK, MessageIcon.ERROR);
			return;
		}
		
		if (availableBeds == null || availableBeds.size() == 0)
		{
			engine.showMessage("No bed records match your search criteria.", "No data found", MessageButtons.OK, MessageIcon.WARNING);
			return;
		}
		if (availableBeds != null)
			form.lbl6().setValue("Total: " + String.valueOf(availableBeds.size()));
		
		if (availableBeds.size() >1)
		{	
			form.getLocalContext().setSortOrderBedNo(SortOrder.ASCENDING);
			availableBeds.sort(BedSpaceStateLiteVo.getBedNumberComparator(form.getLocalContext().getSortOrderBedNo()));
		}
		populateGrid(availableBeds);	
	}
	
	private void populateGrid(BedSpaceStateLiteVoCollection availableBeds) 
	{	
		form.grdAvailableBeds().getRows().clear();
		
		if (availableBeds == null)
			return;
		
		for (BedSpaceStateLiteVo item: availableBeds)
		 {
				grdAvailableBedsRow row = form.grdAvailableBeds().getRows().newRow();

				row.setColWard(item.getWardIsNotNull() && item.getWard().getNameIsNotNull() ? item.getWard().getName() : "");
				row.setTooltipForColWard(item.getWardIsNotNull() && item.getWard().getNameIsNotNull() ? item.getWard().getName() : "");//WDEV-22737
				row.setColLocation(item.getBedSpaceIsNotNull() && item.getBedSpace().getWardTypeIsNotNull() ? item.getBedSpace().getWardType().toString() : "");
				row.setTooltipForColLocation(item.getBedSpaceIsNotNull() && item.getBedSpace().getWardTypeIsNotNull() ? item.getBedSpace().getWardType().toString() : "");//WDEV-22737
				//WDEV-18010
				row.setColBedNumber(item.getBedSpaceIsNotNull() && item.getBedSpace().getBedNumberIsNotNull() ? item.getBedSpace().getBedNumber() : "");
				row.setTooltipForColBedNumber(item.getBedSpace() != null && item.getBedSpace().getBedNumberIsNotNull() ? item.getBedSpace().getBedNumber() : "");
				row.setColBedType(item.getBedSpaceIsNotNull() && item.getBedSpace().getBedSpaceTypeIsNotNull() ? item.getBedSpace().getBedSpaceType().toString() : "");
				row.setTooltipForColBedType(item.getBedSpaceIsNotNull() && item.getBedSpace().getBedSpaceTypeIsNotNull() ? item.getBedSpace().getBedSpaceType().toString() : "");//WDEV-22737
				row.setColBedStatus(item.getBedSpaceIsNotNull() && item.getCurrentBedStatusIsNotNull() && item.getCurrentBedStatus().getBedStatusIsNotNull() ? item.getCurrentBedStatus().getBedStatus().toString() : "");
				row.setTooltipForColBedStatus(item.getBedSpaceIsNotNull() && item.getCurrentBedStatusIsNotNull() && item.getCurrentBedStatus().getBedStatusIsNotNull() ? item.getCurrentBedStatus().getBedStatus().toString() : "");//WDEV-22737
				row.setColComments(item.getCommentIsNotNull() ? item.getComment().toString() : "");
				//WDEV-8334
				row.setTooltipForColComments(item.getCommentIsNotNull() ? item.getComment().toString() : "");
				if (ConfigFlag.UI.BED_INFO_UI_TYPE.getValue().equals("MAXIMS")) //WDEV-20328
				{
					row.setColWardStatus(getWardStatusTextDisplay(item.getWardStatus()));
					row.setTooltipForColWardStatus(getWardStatusTextDisplay(item.getWardStatus()));//WDEV-22737
				}
				row.setValue(item);
		 }		
	}
	private String getWardStatusTextDisplay(WardBayStatus wardStatus)
	{
		if (wardStatus == null || WardBayStatus.OPEN.equals(wardStatus))
			return "<div style =\"color:#008000;padding-top: 5px;\">" + WardBayStatus.OPEN.getText() + "</div>"; //WDEV-20770
		else if (WardBayStatus.CLOSED.equals(wardStatus))
			return "<div style =\"color:#FF0000;padding-top: 5px;\">" + WardBayStatus.CLOSED.getText() + "</div>";
		else if  (WardBayStatus.BLOCKED.equals(wardStatus))
			return "<div style =\"color:#FFBF00;padding-top: 5px;\">" + WardBayStatus.BLOCKED.getText() + "</div>";
		
		return null;
	}

	private AvailableBedsVo populateDataFromScreen() 
	{
		AvailableBedsVo beds=new AvailableBedsVo();
		if (form.qmbWard()!=null)
			beds.setWard(form.qmbWard().getValue());
		if (form.cmbBedStatus()!=null)
			beds.setBedStatus(form.cmbBedStatus().getValue());
		if (form.cmbBedType()!=null)
			beds.setBedType(form.cmbBedType().getValue());
		if (form.cmbSideRoom()!=null)
			beds.setWardType(form.cmbSideRoom().getValue());
		if (form.cmbHospital()!=null)
			beds.setHospital(form.cmbHospital().getValue());
		return beds;
	}

	@Override
	protected void onCmbHospitalValueChanged() throws PresentationLogicException 
	{
		form.qmbWard().clear();
	}
	
	
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException 
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.GenericGrid.Add:
				addEditComment();
			break;
		}
	}

	private void addEditComment() 
	{
		if (form.grdAvailableBeds().getSelectedRow() != null
			&& form.grdAvailableBeds().getSelectedRow().getValue() != null)
		{
			BedSpaceStateLiteVo voBedState = domain.getBedSpaceState(form.grdAvailableBeds().getSelectedRow().getValue());
			form.getGlobalContext().Core.setCommentDialogString(voBedState.getComment());
			form.grdAvailableBeds().getSelectedRow().setValue(voBedState);
			engine.open(form.getForms().Core.CommentDialog);
		}
	}

	private void updateContextMenus()
	{
		form.getContextMenus().hideAllGenericGridMenuItems();
		form.getContextMenus().getGenericGridAddItem().setText("Add/Edit Comment");
		form.getContextMenus().getGenericGridAddItem().setVisible(true);
	}



	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException 
	{
		
	}
	
	//WDEV-18420
	public void open() 
	{
		loadHospitals();
		if (form.cmbHospital().getValue() == null && engine.getCurrentLocation() != null)
		{
			//Try and load the logged in location as a ward
			LocMostVo voLoc = domain.getLocation((LocationRefVo)engine.getCurrentLocation());
			LocationLiteVo currentHospital = domain.getCurrentHospital(engine.getCurrentLocation()); //WDEV-20707
			if (voLoc != null && voLoc.getTypeIsNotNull()
				&& voLoc.getType().equals(LocationType.WARD))
			{
				//form.cmbHospital().setValue(voLoc.getParentLocation());
				form.cmbHospital().setValue(currentHospital); //WDEV-20707
				
				form.qmbWard().newRow(voLoc, voLoc.getName());
				form.qmbWard().setValue(voLoc);
			}
		}
	}
	
	private void refreshSearchCriteria() 
	{
		AvailableBedsVo voFilter = form.getGlobalContext().STHK.getAvailableBedsListFilter();
		
		if (voFilter != null)
		{
			form.cmbSideRoom().setValue(voFilter.getWardType());
			form.cmbBedType().setValue(voFilter.getBedType());
			form.cmbBedStatus().setValue(voFilter.getBedStatus());
			form.cmbHospital().setValue(voFilter.getHospital());
			
			form.qmbWard().setValue(null);
			for(int i = 0 ; voFilter.getWardIsNotNull() && i < form.qmbWard().getValues().size() ; i++)
			{
				LocationLiteVo voWard = (LocationLiteVo)form.qmbWard().getValues().get(i);
				if (voWard.getID_Location().equals(voFilter.getWard().getID_Location()))
					form.qmbWard().setValue((LocationLiteVo)form.qmbWard().getValues().get(i));
			}
			if ( form.qmbWard().getValue() == null&& voFilter.getWardIsNotNull())
			{
				form.qmbWard().newRow(voFilter.getWard(), voFilter.getWard().getName());
				form.qmbWard().setValue(voFilter.getWard());
			}
					
			search();
		}
	}

	private void loadHospitals() 
	{
		LocationLiteVoCollection voColl = domain.listActiveHospitalsLite();
		for (int i = 0 ; voColl != null && i < voColl.size() ; i++)
		{
			form.cmbHospital().newRow(voColl.get(i), voColl.get(i).getName());
			
			if (engine.getCurrentLocation() != null 
				&& voColl.get(i).getID_Location().equals(engine.getCurrentLocation().getID()))
				form.cmbHospital().setValue(voColl.get(i));
		}
	}

	@Override
	protected void onGrdAvailableBedsSelectionChanged() throws PresentationLogicException
	{
		updateContextMenus();
	}

	public void refresh() 
	{
		if (form.getGlobalContext().STHK.getAvailableBedsListFilterIsNotNull())
			refreshSearchCriteria();
	}

	@Override
	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException 
	{
		if(formName.equals(form.getForms().Core.CommentDialog) && result.equals(DialogResult.OK))
		{
			BedSpaceStateLiteVo voBSS = form.grdAvailableBeds().getSelectedRow().getValue();
			voBSS.setComment(form.getGlobalContext().Core.getCommentDialogString());
			
			String [] errors = voBSS.validate();
			if (errors != null)
			{
				engine.showErrors(errors);
				return;
			}
			
			try 
			{
				domain.saveBedSpaceState(voBSS);
			} 
			catch (DomainInterfaceException e) 
			{
				engine.showMessage(e.getMessage());
				return;
			} 
			catch (StaleObjectException e) 
			{
				engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			}
			
			form.grdAvailableBeds().getSelectedRow().setColComments(form.getGlobalContext().Core.getCommentDialogString());
			form.grdAvailableBeds().getSelectedRow().setTooltipForColComments(form.getGlobalContext().Core.getCommentDialogString());
		}
	}

	@Override
	protected void onBtnPrintReportClick() throws PresentationLogicException
	{
		String urlQueryServer = ConfigFlag.GEN.QUERY_SERVER_URL.getValue();
		String urlReportServer = ConfigFlag.GEN.REPORT_SERVER_URL.getValue();

		
		if(form.qmbWard().getValue()==null)		
		{
			engine.showMessage("Please select a ward !");
			return;
		}
		
		//we need a better way to do this
		Object[] obj = domain.getSystemReportAndTemplate(new Integer(296));
		
		if(obj == null || obj.length < 2)
		{
			engine.showMessage("I could not get the report and template !");
			return;
		}
		
		if(obj[0] == null || obj[1] == null)
		{
			engine.showMessage("The report has not been deployed !");
			return;
		}
		
		QueryBuilderClient client = new QueryBuilderClient(urlQueryServer, engine.getSessionId());
				
		client.addSeed(new SeedValue("Ward",  form.qmbWard().getValue().getID_Location().intValue(), Integer.class));
				
		String resultUrl = "";
		try
		{
			resultUrl = client.buildReportAsUrl((String)obj[0], (String)obj[1], urlReportServer, "PDF", "", 1);
		} 
		catch (QueryBuilderClientException e1)
		{
			engine.showMessage("Error creating report: " + e1.getMessage());
			return;
		}
		
		engine.openUrl(resultUrl);
		
	}

	@Override
	protected void onGrdAvailableBedsGridHeaderClicked(int column) throws PresentationLogicException
	{		
		if (COL_BED_NO == column)
		{
			BedSpaceStateLiteVoCollection gridValues = form.grdAvailableBeds().getValues();
			if (gridValues.size() < 2)
				return;
			BedSpaceStateLiteVo selVal = form.grdAvailableBeds().getValue();
			
			form.getLocalContext().setSortOrderBedNo(SortOrder.ASCENDING.equals(form.getLocalContext().getSortOrderBedNo()) ? SortOrder.DESCENDING : SortOrder.ASCENDING);
			gridValues.sort(BedSpaceStateLiteVo.getBedNumberComparator(form.getLocalContext().getSortOrderBedNo()));
			
			populateGrid(gridValues);
			if (selVal != null)
			{
				form.grdAvailableBeds().setValue(selVal);
			}
		}
		updateContextMenus();
	}


/*	private void updateMenuOptions()
	{
		form.getContextMenus().Core.hideAllBedManagerMenuMenuItems();
		
		if (form.cmbBedStatus().getValue().equals(BedStatus.AVAILABLE))
		{
			form.getContextMenus().Core.getBedManagerMenuADMITItem().setVisible(form.grdAvailableBeds().getValue() != null);
			form.getContextMenus().Core.getBedManagerMenuADMITItem().setEnabled(form.grdAvailableBeds().getValue() != null);
			form.getContextMenus().Core.getBedManagerMenuREQUIRES_CLEANINGItem().setVisible(form.grdAvailableBeds().getValue() != null);
			form.getContextMenus().Core.getBedManagerMenuREQUIRES_CLEANINGItem().setEnabled(form.grdAvailableBeds().getValue() != null);
			form.getContextMenus().Core.getBedManagerMenuCLOSEItem().setVisible(form.grdAvailableBeds().getValue() != null);
			form.getContextMenus().Core.getBedManagerMenuCLOSEItem().setEnabled(form.grdAvailableBeds().getValue() != null);
		}
		else if (form.cmbBedStatus().getValue().equals(BedStatus.CLOSED))
		{
			form.getContextMenus().Core.getBedManagerMenuREOPENItem().setVisible(form.grdAvailableBeds().getValue() != null);
			form.getContextMenus().Core.getBedManagerMenuREOPENItem().setEnabled(form.grdAvailableBeds().getValue() != null);

		}
	}
	@Override
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException 
	{
		AvailableBedsVo vo = form.grdAvailableBeds().getSelectedRow().getValue();
		if (vo != null)
		{
			BedSpaceRefVo voRef = new BedSpaceRefVo();
			voRef.setID_BedSpace(vo.getID_BedSpaceState());
			
			form.getGlobalContext().Core.setSelectedBedSpaceState( domain.getBedSpaceState(voRef));
			engine.open(form.getForms().Core.BedInfoDialog);
		}
	}
*/
}
