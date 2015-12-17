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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.21 build 41006.1700)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.admin.forms.gpadmin;

import ims.admin.forms.gpadmin.GenForm.ctnGPDetailsContainer.lyrGPDetailsLayer.tabGPDetailsContainer.grdContactsRow;
import ims.admin.forms.gpadmin.GenForm.ctnGPDetailsContainer.lyrGPDetailsLayer.tabGPDetailsContainer.grdMappingsRow;
import ims.admin.vo.enums.GPAction;
import ims.configuration.gen.ConfigFlag;
import ims.core.resource.people.vo.GpRefVo;
import ims.core.vo.CommChannelVo;
import ims.core.vo.CommChannelVoCollection;
import ims.core.vo.GP;
import ims.core.vo.GpToPracticesVo;
import ims.core.vo.GpToPracticesVoCollection;
import ims.core.vo.LocSiteVo;
import ims.core.vo.OrganisationWithSitesVo;
import ims.core.vo.PersonName;
import ims.core.vo.TaxonomyMap;
import ims.core.vo.TaxonomyMapCollection;
import ims.core.vo.lookups.GPStatus;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.Control;
import ims.framework.FormName;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.delegates.CancelArgs;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;

public class Logic extends BaseLogic
{
	private static final Integer COL_PRACTICENAME = new Integer(1);
	private static final Integer COL_PASCODE = new Integer(2);
	private static final Integer COL_PRIMARY = new Integer(3);
	private static final Integer COL_ADDRESS = new Integer(4);
	
	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		initialize();
		
		// Screen called from WorkQueue - display Patient and Case
		if (form.getGlobalContext().NTPF.getTargetObjectIdIsNotNull())
		{
			form.getLocalContext().setGPVo(domain.getGP(form.getGlobalContext().NTPF.getTargetObjectId()));
			form.lnkBack().setVisible(true);
			form.getLocalContext().setPreviousForm(getPrevForm());			
			form.customControlGpSearch().setValue(form.getLocalContext().getGPVo());
			getSelectedGP();			
			editInstance();
		}
		else 
		{
			form.lnkBack().setVisible(false);
			// Screen called as dialog. Open in edit mode and populate search criteria if possible
			if ((engine.getFormName().equals(form.getForms().Admin.GPAdminDialog)) && (!form.getGlobalContext().NTPF.getTargetObjectIdIsNotNull()))
			{
				newInstance();
				//populate the previous search criteria into the details panel. 
				if (form.getGlobalContext().Core.getGPDetailsIsNotNull())
				{
					populateName(form.getGlobalContext().Core.getGPDetails().getNameIsNotNull() ? form.getGlobalContext().Core.getGPDetails().getName() : null);
					populateMappingsGrid(form.getGlobalContext().Core.getGPDetails().getCodeMappingsIsNotNull() ? form.getGlobalContext().Core.getGPDetails().getCodeMappings() : null);
				}
				//clear the global context as this is only search criteria and is no longer needed. 
				form.getGlobalContext().Core.setGPDetails(null);
			}
			else
			{
				open();
			}
		}
	}
	
	private void initialize()
	{		
		if (engine.getFormName().equals(form.getForms().Admin.GPAdminDialog))
			form.btnClose().setVisible(true);
		else
			form.btnClose().setVisible(false);
		
		form.ctnGPDetails().setCollapsed(true);
		//WDEV-18377
		form.customControlGpSearch().initialize(true, true);
		form.customControlGpSearch().setSearchButtonAsDefault();
		formatPracticesSurgeryGrid();
	}
	
	private void formatPracticesSurgeryGrid()
	{
		form.ctnGPDetails().lyrGPDetails().tabPractices().dyngrdPractices().clear();
		form.ctnGPDetails().lyrGPDetails().tabPractices().dyngrdPractices().setSelectable(true);
		
		DynamicGridColumn column = form.ctnGPDetails().lyrGPDetails().tabPractices().dyngrdPractices().getColumns().newColumn("Name");
		column.setIdentifier(COL_PRACTICENAME);
		column.setWidth(300);
		column.setDynamicWidthSupported(true);

		column = form.ctnGPDetails().lyrGPDetails().tabPractices().dyngrdPractices().getColumns().newColumn("PAS Code");
		column.setIdentifier(COL_PASCODE);
		column.setWidth(60);
		column.setDynamicWidthSupported(true);
		
		column = form.ctnGPDetails().lyrGPDetails().tabPractices().dyngrdPractices().getColumns().newColumn("Primary");
		column.setIdentifier(COL_PRIMARY);
		column.setWidth(60);
		column.setDynamicWidthSupported(true);
		
		column = form.ctnGPDetails().lyrGPDetails().tabPractices().dyngrdPractices().getColumns().newColumn("Address");
		column.setIdentifier(COL_ADDRESS);
		column.setWidth(-1);
		column.setDynamicWidthSupported(true);
	}

	private void open()
	{			
		if (form.getLocalContext().getGPVoIsNotNull())
		{
			//
			form.customControlGpSearch().setValue((GpRefVo)form.getLocalContext().getGPVo());
			getSelectedGP();
		}			
		form.setMode(FormMode.VIEW);
	}
	
	/**
	 * Gets the value of the custom control grid selection. If not null, populates the instance controls. 
	 * @param null
	 * @return null
	 */
	private void getSelectedGP()
	{
		GP voGp = form.customControlGpSearch().getFullGpVo();
		if (voGp != null)
		{
			form.getLocalContext().setGPVo(voGp);
			populateInstanceControl(voGp);
		}
	}
	
	private void updateControlsState()
	{
		if (form.getMode().equals(FormMode.EDIT))
		{
			form.setcustomControlGpSearchEnabled(false);
			form.customControlGpSearch().setVisibleContextMenu(Boolean.FALSE);
			form.getContextMenus().getGPAdminContactsADDItem().setVisible(true);
			form.getContextMenus().getGPAdminContactsREMOVEItem().setVisible(form.ctnGPDetails().lyrGPDetails().tabGPDetails().grdContacts().getSelectedRowIndex() >= 0);
			form.getContextMenus().getGPAdminMappingsADDItem().setVisible(true);		
			form.getContextMenus().getGPAdminMappingsREMOVEItem().setVisible(form.ctnGPDetails().lyrGPDetails().tabGPDetails().grdMappings().getSelectedRowIndex() >= 0);
			form.getContextMenus().getGpPracticeGridSearchAddPracticeItem().setVisible(true);
			form.getContextMenus().getGpPracticeGridRemovePracticeItem().setVisible((form.ctnGPDetails().lyrGPDetails().tabPractices().dyngrdPractices().getValue() instanceof GpToPracticesVo || form.ctnGPDetails().lyrGPDetails().tabPractices().dyngrdPractices().getValue() instanceof OrganisationWithSitesVo));
			form.btnClose().setEnabled(false);
			form.ctnGPDetails().setCollapsed(false);
			
			form.ctnGPDetails().lyrGPDetails().tabGPDetails().cmbGPStatus().setEnabled(!engine.getFormName().equals(form.getForms().Admin.GPAdminDialog) || (engine.getFormName().equals(form.getForms().Admin.GPAdminDialog)) && (form.lnkBack().isVisible()));
		}
		else
		{
			form.setcustomControlGpSearchEnabled(true);
			form.customControlGpSearch().setVisibleContextMenu(Boolean.TRUE);
			form.btnEdit().setVisible(form.customControlGpSearch().getValue() != null);
			form.getContextMenus().getGPAdminContactsADDItem().setVisible(false);
			form.getContextMenus().getGPAdminContactsREMOVEItem().setVisible(false);
			form.getContextMenus().getGPAdminMappingsADDItem().setVisible(false);	
			form.getContextMenus().getGPAdminMappingsREMOVEItem().setVisible(false);
			form.getContextMenus().getGpPracticeGridSearchAddPracticeItem().setVisible(false);
			form.getContextMenus().getGpPracticeGridRemovePracticeItem().setVisible(false);
			form.ctnGPDetails().setCollapsed(!(form.customControlGpSearch().getValue() != null));
			form.btnClose().setEnabled(true);
		}		
	}

	private FormName getPrevForm()
	{
		if (engine.getPreviousNonDialogFormName().equals(form.getForms().NTPF.WorkQueue))
			return form.getForms().NTPF.WorkQueue;
		else if (engine.getPreviousNonDialogFormName().equals(form.getForms().NTPF.WorkQueue2))
			return form.getForms().NTPF.WorkQueue2;
		return null;
	}

	private void populateInstanceControl(GP gp)
	{
		clearInstanceControls();
		populateScreenFromData(gp);
		
		form.ctnGPDetails().lyrGPDetails().showtabGPDetails();
		updateControlsState();
	}

	private void clearInstanceControls() 
	{
		form.ctnGPDetails().lyrGPDetails().tabGPDetails().cmbGPStatus().setValue(null);
		form.ctnGPDetails().lyrGPDetails().tabGPDetails().cmbTitle().setValue(null);
		form.ctnGPDetails().lyrGPDetails().tabGPDetails().grdContacts().getRows().clear();
		form.ctnGPDetails().lyrGPDetails().tabGPDetails().grdContacts().setValue(null);
		form.ctnGPDetails().lyrGPDetails().tabGPDetails().grdMappings().getRows().clear();
		form.ctnGPDetails().lyrGPDetails().tabGPDetails().grdMappings().setValue(null);
		form.ctnGPDetails().lyrGPDetails().tabGPDetails().txtForename().setValue(null);
		form.ctnGPDetails().lyrGPDetails().tabGPDetails().txtMiddlename().setValue(null);
		form.ctnGPDetails().lyrGPDetails().tabGPDetails().txtSurname().setValue(null);
		form.ctnGPDetails().lyrGPDetails().tabPractices().dyngrdPractices().getRows().clear();
		form.ctnGPDetails().lyrGPDetails().tabPractices().dyngrdPractices().setValue(null);
	}

	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		editInstance();
	}

	private void editInstance()
	{
		form.setMode(FormMode.EDIT);
		form.ctnGPDetails().lyrGPDetails().tabGPDetails().cmbTitle().setFocus();		
	}

	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		newInstance();
	}

	private void newInstance()
	{
		form.getLocalContext().setGPVo(null);
		clearScreen();
		form.setMode(FormMode.EDIT);
		
		form.ctnGPDetails().lyrGPDetails().showtabGPDetails();
		
		if ((!form.getGlobalContext().NTPF.getTargetObjectIdIsNotNull()) && (engine.getFormName().equals(form.getForms().Admin.GPAdminDialog)))
			form.ctnGPDetails().lyrGPDetails().tabGPDetails().cmbGPStatus().setValue(GPStatus.TOBECODED);
		form.ctnGPDetails().lyrGPDetails().tabGPDetails().cmbTitle().setFocus();
	}

	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}

	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save()) 
		{
			open();
		}
	}

	/**
	 * Checks UI rules for save. Populates GP from screen. Attempts save and catches exceptions. 
	 * @return boolean indicating success
	 */
	private boolean save() 
	{
		if (form.ctnGPDetails().lyrGPDetails().tabGPDetails().txtSurname().getValue() == null)
		{
			engine.showMessage("'Surname' is a mandatory field");
			form.ctnGPDetails().lyrGPDetails().tabGPDetails().txtSurname().setFocus();
			return false;
		}
		
		//WDEV-19661
		if (form.ctnGPDetails().lyrGPDetails().tabGPDetails().cmbGPStatus().getValue() == null)
		{
			engine.showMessage("'Status' is a mandatory field");
			form.ctnGPDetails().lyrGPDetails().tabGPDetails().cmbGPStatus().setFocus();
			return false;
		}
		
		if (form.ctnGPDetails().lyrGPDetails().tabPractices().dyngrdPractices().getRows().size() == 0)
		{
			engine.showMessage("Please enter a Practice for the selected GP");
			return false;
		}
		if (!isPrimaryPracticeMarked())
		{
			engine.showMessage("Please select a Primary Practice for the selected GP");
			return false;
		}

		GP voGP = populateDataFromScreen(form.getLocalContext().getGPVo());
		
		String[] arrErrors = voGP.validate();
		if (arrErrors != null)
		{
			engine.showErrors(arrErrors);
			return false;
		}

		try
		{
			voGP = domain.saveGp(voGP); 
			form.getLocalContext().setGPVo(voGP);
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			populateInstanceControl(voGP);
			return false;
		} 
		catch (UniqueKeyViolationException e) 
		{
			engine.showMessage(e.getMessage());
			populateInstanceControl(voGP);
			return false;
		}
		
		if ((engine.getFormName().equals(form.getForms().Admin.GPAdminDialog)) && (!form.getGlobalContext().NTPF.getTargetObjectIdIsNotNull()))
		{
			form.getGlobalContext().Core.setGPDetails(voGP);
			form.getGlobalContext().NTPF.setNewGPCreated(Boolean.TRUE);
			form.getGlobalContext().NTPF.setTargetObjectId(null);
			engine.close(DialogResult.OK);
		}
		return true;
	}

	private boolean isPrimaryPracticeMarked()
	{
		DynamicGridRow pRow;
		for(int i = 0;i < form.ctnGPDetails().lyrGPDetails().tabPractices().dyngrdPractices().getRows().size(); i++)
		{
			pRow = form.ctnGPDetails().lyrGPDetails().tabPractices().dyngrdPractices().getRows().get(i);
			DynamicGridCell cell = pRow.getCells().get(form.ctnGPDetails().lyrGPDetails().tabPractices().dyngrdPractices().getColumns().getByIdentifier(COL_PRIMARY));
			if (cell != null && cell.getValue() != null && cell.getValue().equals(Boolean.TRUE))
				return true; 
		}
		return false;
	}
	
	protected void clearScreen()
	{
		form.customControlGpSearch().clear();
		clearInstanceControls();	
	}

	/**
	 * The GP parameter is updated to match what is on screen and returned. 
	 * @param GP
	 * @return GP
	 */
	protected GP populateDataFromScreen(GP value)
	{		
		value = super.populateDataFromScreen(value);	

		value.setName(getName());
		value.setStatus(form.ctnGPDetails().lyrGPDetails().tabGPDetails().cmbGPStatus().getValue());
		value.setCodeMappings(getCodeMappings());
		value.setCommChannels(getCommChannels());
		value.setPractices(getPractices());
		return value;
	}
	
	private PersonName getName() 
	{
		PersonName name = new PersonName();
		name.setSurname(form.ctnGPDetails().lyrGPDetails().tabGPDetails().txtSurname().getValue());
		name.setForename(form.ctnGPDetails().lyrGPDetails().tabGPDetails().txtForename().getValue());
		name.setMiddleName(form.ctnGPDetails().lyrGPDetails().tabGPDetails().txtMiddlename().getValue());
		name.setTitle(form.ctnGPDetails().lyrGPDetails().tabGPDetails().cmbTitle().getValue());
		return name;
	}

	/**
	 * Returns a collection of all practices in the Details panel grid. 
	 * @param null
	 * @return GpToPracticesVoCollection
	 */
	private GpToPracticesVoCollection getPractices() 
	{
		GpToPracticesVoCollection voPracts = new GpToPracticesVoCollection();
		for (int i = 0; i < form.ctnGPDetails().lyrGPDetails().tabPractices().dyngrdPractices().getRows().size(); i++)
		{
			Object obj = form.ctnGPDetails().lyrGPDetails().tabPractices().dyngrdPractices().getRows().get(i).getValue();
			if ( obj != null && obj instanceof GpToPracticesVo)
			{
				GpToPracticesVo voGpToPractice = (GpToPracticesVo)obj;
				DynamicGridRow pRow = form.ctnGPDetails().lyrGPDetails().tabPractices().dyngrdPractices().getRows().get(i);
				if (pRow != null)
				{
					DynamicGridCell cellPrimary = pRow.getCells().get(form.ctnGPDetails().lyrGPDetails().tabPractices().dyngrdPractices().getColumns().getByIdentifier(COL_PRIMARY));
					if (cellPrimary != null && cellPrimary.getValue() != null && cellPrimary.getValue().equals(Boolean.TRUE))
						voGpToPractice.setIsPrimaryPractice(Boolean.TRUE);
					else
						voGpToPractice.setIsPrimaryPractice(Boolean.FALSE);
					
					DynamicGridCell cellPasCode = pRow.getCells().get(form.ctnGPDetails().lyrGPDetails().tabPractices().dyngrdPractices().getColumns().getByIdentifier(COL_PASCODE));
					voGpToPractice.setGpCode((String)cellPasCode.getValue());
				}
				voPracts.add(voGpToPractice);
			}
		}
		return voPracts;
	}

	/**
	 * Returns a collection of all taxonomy mapping populated on screen.
	 * @param null
	 * @return TaxonomyMapCollection
	 */
	private TaxonomyMapCollection getCodeMappings()
	{
		TaxonomyMapCollection coll = new TaxonomyMapCollection();
		for (int i = 0; i < form.ctnGPDetails().lyrGPDetails().tabGPDetails().grdMappings().getRows().size(); i++)
		{
			grdMappingsRow row = form.ctnGPDetails().lyrGPDetails().tabGPDetails().grdMappings().getRows().get(i);
			if (row.getcolExtCodeType() != null && row.getcolCode() != null)
			{
				TaxonomyMap map = new TaxonomyMap();
				map.setTaxonomyName(row.getcolExtCodeType());
				map.setTaxonomyCode(row.getcolCode());
				coll.add(map);
			}
		}
		return coll;
	}

	/**
	 * Returns a collection of all comms channels populated on screen. 
	 * @param null
	 * @return CommChannelVoCollection
	 */
	private CommChannelVoCollection getCommChannels()
	{
		CommChannelVoCollection coll = new CommChannelVoCollection();
		for (int i = 0; i < form.ctnGPDetails().lyrGPDetails().tabGPDetails().grdContacts().getRows().size(); i++)
		{
			grdContactsRow row = form.ctnGPDetails().lyrGPDetails().tabGPDetails().grdContacts().getRows().get(i);
			if (row.getcolContactType() != null && row.getcolContactValue() != null)
			{
				CommChannelVo comm = new CommChannelVo();
				comm.setChannelType(row.getcolContactType());
				comm.setCommValue(row.getcolContactValue());
				coll.add(comm);
			}
		}
		return coll;
	}

	/**
	 * Populated the screen based on the GP parameter.
	 * @param GP
	 * @return null
	 */
	protected void populateScreenFromData(GP value)
	{
		if (value == null)
			return;
		
		clearInstanceControls();	
		
		form.ctnGPDetails().lyrGPDetails().tabGPDetails().cmbGPStatus().setValue(value.getStatusIsNotNull() ? value.getStatus() : null);
		populateName(value.getName());
		populatePractices(value.getPractices());		
		populateMappingsGrid(value.getCodeMappings());
		populateContactsGrid(value.getCommChannels());
	}
 
	/**
	 * Displays the given PersonName on the GP details panel
	 * @param PersonName
	 * @return null
	 */
	private void populateName(PersonName name) 
	{
		if (name != null)
		{
			form.ctnGPDetails().lyrGPDetails().tabGPDetails().txtSurname().setValue(name.getSurnameIsNotNull() ? name.getSurname() : "");
			form.ctnGPDetails().lyrGPDetails().tabGPDetails().txtForename().setValue(name.getForenameIsNotNull() ? name.getForename() : "");
			form.ctnGPDetails().lyrGPDetails().tabGPDetails().txtMiddlename().setValue(name.getMiddleNameIsNotNull() ? name.getMiddleName() : "");
			form.ctnGPDetails().lyrGPDetails().tabGPDetails().cmbTitle().setValue(name.getTitleIsNotNull() ? name.getTitle() : null);
		}
	}

	/**
	 * Loops through each practice of the given GpToPracticesVoCollection calling adding them to the grid
	 * @param GpToPracticesVoCollection
	 * @return null
	 */
	private void populatePractices(GpToPracticesVoCollection voPracticeColl)
	{
		if (voPracticeColl != null)
		{
			for(int x = 0; x < voPracticeColl.size(); x++)
			{
				addPracticeRow(voPracticeColl.get(x));
			}
		}
	}

	private void addPracticeRow(GpToPracticesVo voPractice)
	{
		editPracticeRow(voPractice, form.ctnGPDetails().lyrGPDetails().tabPractices().dyngrdPractices().getRows().newRow());
	}
	
	/**
	 * Addes the given GpToPracticesVo as the next row in the practices grid. 
	 * @param GpToPracticesVo
	 */
	private void editPracticeRow(GpToPracticesVo voPractice, DynamicGridRow row)
	{
		if (voPractice != null && row != null)
		{
			DynamicGridColumn nameColumn = form.ctnGPDetails().lyrGPDetails().tabPractices().dyngrdPractices().getColumns().getByIdentifier(COL_PRACTICENAME);
			if(nameColumn == null)
				return;
			
			row.setBackColor(Color.Beige);
			row.setBold(true);
			
			DynamicGridCell cell = row.getCells().newCell(nameColumn, DynamicCellType.STRING);
			String name = ""; 
			if ( voPractice.getPracticeIsNotNull() && voPractice.getPractice().getNameIsNotNull())
				name = voPractice.getPractice().getName();
			
			cell.setValue(name);
			cell.setTooltip(name);
			cell.setWidth(300);
			cell.setReadOnly(true);
			
			cell = row.getCells().newCell(form.ctnGPDetails().lyrGPDetails().tabPractices().dyngrdPractices().getColumns().getByIdentifier(COL_PASCODE), DynamicCellType.STRING);
			cell.setValue(voPractice.getGpCode());
			cell.setWidth(60);
			cell.setIntMaxLength(40);//WDEV-15431
			
			cell = row.getCells().newCell(form.ctnGPDetails().lyrGPDetails().tabPractices().dyngrdPractices().getColumns().getByIdentifier(COL_PRIMARY), DynamicCellType.BOOL);
			cell.setValue(voPractice.getIsPrimaryPractice());
			cell.setAutoPostBack(true);
			cell.setWidth(60);
			
			cell = row.getCells().newCell(form.ctnGPDetails().lyrGPDetails().tabPractices().dyngrdPractices().getColumns().getByIdentifier(COL_ADDRESS), DynamicCellType.STRING);
			cell.setReadOnly(true);//WDEV-15431
			if (voPractice.getPracticeIsNotNull() && voPractice.getPractice().getAddressIsNotNull() && voPractice.getPractice().getAddress() != null)
			{
				String strAddress = voPractice.getPractice().getAddress().toDisplayString();
				if(strAddress.endsWith(","))
				{
					strAddress = strAddress.substring(0,strAddress.length()-1);
				
				}
				
				
				cell.setValue(strAddress);
				cell.setTooltip(strAddress);
				cell.setWidth(-1);
			}		
			
			row.setCollapsedImage(form.getImages().Admin.Organisation);
			row.setExpandedImage(form.getImages().Admin.Organisation);
			
			// if the site is using surgeries, display them on screen. otherwise, skip.
			if (ConfigFlag.DOM.GP_USE_SURGERIES.getValue())
			{
				if (voPractice.getPracticeIsNotNull() && voPractice.getPractice().getLocationSitesIsNotNull())
				{
					voPractice.getPractice().getLocationSites().sort();
					for(int x = 0; x < voPractice.getPractice().getLocationSites().size(); x++)
					{
						populateSurgeries(voPractice.getPractice().getLocationSites().get(x), row);
					}
					row.setExpanded(true);
				}
			}
			
			row.setSelectable(true);
			row.setValue(voPractice);
		}
	}

	/**
	 * Addes the given LocSiteVo to the given DynamicGridRow in the practices grid. 
	 * @param LocSiteVo
	 * @param DynamicGridRow
	 */
	private void populateSurgeries(LocSiteVo voSurgery, DynamicGridRow rowPractice)
	{
		if (voSurgery != null && rowPractice != null)
		{
			DynamicGridRow rowSurgery = null;
			rowSurgery = rowPractice.getRows().newRow();

			DynamicGridColumn nameColumn = form.ctnGPDetails().lyrGPDetails().tabPractices().dyngrdPractices().getColumns().getByIdentifier(COL_PRACTICENAME);
			if(nameColumn == null)
				return;
			
			DynamicGridCell cell = rowSurgery.getCells().newCell(nameColumn, DynamicCellType.STRING);
			String name = ""; 
			if (voSurgery.getNameIsNotNull())
				name = voSurgery.getName();
			
			cell.setValue(name);
			cell.setTooltip(name);
			cell.setWidth(300);
			cell.setReadOnly(true);
			
			cell = rowSurgery.getCells().newCell(form.ctnGPDetails().lyrGPDetails().tabPractices().dyngrdPractices().getColumns().getByIdentifier(COL_ADDRESS), DynamicCellType.STRING);
			cell.setReadOnly(true);//WDEV-15431
			if (voSurgery.getAddress() != null)
			{
				String strAddress = voSurgery.getAddress().toDisplayString();
				if(strAddress.endsWith(","))
				{
					strAddress = strAddress.substring(0,strAddress.length()-1);
				
				}
				
				
				cell.setValue(strAddress);
				cell.setTooltip(strAddress);
				cell.setWidth(-1);
			}
			
			rowSurgery.setCollapsedImage(form.getImages().Admin.LocationSite);
			rowSurgery.setExpandedImage(form.getImages().Admin.LocationSite);
			rowSurgery.setSelectable(false);
		}
	}

	/**
	 * Populates the taxonomy mapping grid using the given TaxonomyMapCollection
	 * @param TaxonomyMapCollection
	 */
	private void populateMappingsGrid(TaxonomyMapCollection coll)
	{
		form.ctnGPDetails().lyrGPDetails().tabGPDetails().grdMappings().getRows().clear();
		
		if (coll != null)
		{
			for (int i = 0; i < coll.size(); i++)
			{
				TaxonomyMap map = coll.get(i);
				grdMappingsRow row = form.ctnGPDetails().lyrGPDetails().tabGPDetails().grdMappings().getRows().newRow();
				row.setcolExtCodeType(map.getTaxonomyName());
				row.setcolCode(map.getTaxonomyCode());
				row.setTooltipForcolCode(map.getTaxonomyCode());
				row.setValue(map);
			}	
		}			
	}

	/**
	 * Populates the comms channels grid using the given CommChannelVoCollection
	 * @param CommChannelVoCollection
	 */
	private void populateContactsGrid(CommChannelVoCollection coll)
	{
		form.ctnGPDetails().lyrGPDetails().tabGPDetails().grdContacts().getRows().clear();
		
		if (coll != null)
		{
			for (int i = 0; i < coll.size(); i++)
			{
				CommChannelVo chan = coll.get(i);
				grdContactsRow row = form.ctnGPDetails().lyrGPDetails().tabGPDetails().grdContacts().getRows().newRow();
				row.setcolContactType(chan.getChannelType());
				row.setcolContactValue(chan.getCommValue());
				row.setTooltipForcolContactValue(chan.getCommValue());
				row.setValue(chan);
			}	
		}		
	}

	protected void onImbAddGPPracticeClick()
	{
		engine.open(form.getForms().Admin.GPPracticeSelect);
	}

	protected void onFormDialogClosed(FormName formName, DialogResult result) throws PresentationLogicException
	{
		if(form.getMode().equals(FormMode.EDIT))
			// on successful close of the PracticeSearch dialog, add the practice global context to the grid
			if(result.equals(DialogResult.OK) && form.getGlobalContext().Admin.getPracticeIsNotNull())
			{
				OrganisationWithSitesVo voOrganisation = form.getGlobalContext().Admin.getPractice();
				if(voOrganisation != null &&
						voOrganisation.validate() == null)
				{
					/*GpToPracticesVo voGpToPractice = new GpToPracticesVo();
					voGpToPractice.setPractice(voOrganisation);
					voGpToPractice.setGp(form.getLocalContext().getGPVo());
					
					if(practiceAdded(voOrganisation) == false)
					{
						addPracticeRow(voGpToPractice);
					}
					else
					{
						DynamicGridRow row = getPracticeRow(form.getGlobalContext().Admin.getPractice());
						if(row != null)
						{
							//Clear any children surgeries - (e.g. covers the case when surgeries were removed)
							row.getRows().clear();
							editPracticeRow(voGpToPractice, row);
						}
						else
						{
							addPracticeRow(voGpToPractice);
						}
					}*/
					//WDEV-16516
					GpToPracticesVo voGpToPractice = null;
					DynamicGridRow row = getPracticeRow(voOrganisation);
					if(row != null && row.getValue() instanceof GpToPracticesVo)
					{
						//Clear any children surgeries - (e.g. covers the case when surgeries were removed)
						voGpToPractice = (GpToPracticesVo) row.getValue();
						voGpToPractice.setPractice(voOrganisation);
						voGpToPractice.setGp(form.getLocalContext().getGPVo());
						row.getRows().clear();
						editPracticeRow(voGpToPractice, row);
					}
					else
					{
						voGpToPractice = new GpToPracticesVo();
						voGpToPractice.setPractice(voOrganisation);
						voGpToPractice.setGp(form.getLocalContext().getGPVo());
						addPracticeRow(voGpToPractice);
					}
					
				}
			}
	}

	private boolean practiceAdded(OrganisationWithSitesVo practice)
	{
		//Don't add null value
		if(practice == null)
			return true;
		
		for (int i = 0; i < form.ctnGPDetails().lyrGPDetails().tabPractices().dyngrdPractices().getRows().size(); i++)
		{
			Object objVal = form.ctnGPDetails().lyrGPDetails().tabPractices().dyngrdPractices().getRows().get(i).getValue() ;
			if(objVal instanceof GpToPracticesVo)
			{
				if(practice.equals(((GpToPracticesVo)objVal).getPractice()))
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	private DynamicGridRow getPracticeRow(OrganisationWithSitesVo practice)
	{
		//Don't add null value
		if(practice == null)
			return null;
		
		for (int i = 0; i < form.ctnGPDetails().lyrGPDetails().tabPractices().dyngrdPractices().getRows().size(); i++)
		{
			Object objVal = form.ctnGPDetails().lyrGPDetails().tabPractices().dyngrdPractices().getRows().get(i).getValue() ;
			if(objVal instanceof GpToPracticesVo)
			{
				if(practice.equals(((GpToPracticesVo)objVal).getPractice()))
				{
					return form.ctnGPDetails().lyrGPDetails().tabPractices().dyngrdPractices().getRows().get(i);
				}
			}
		}
		
		return null;
	}

	/**
	 * Removes a selected practice from the grid
	 * @param null
	 * @return null
	 */
	private void removePractice()
	{
		if (form.ctnGPDetails().lyrGPDetails().tabPractices().dyngrdPractices().getRows().size() == 0)
		{
			engine.showMessage("There are no GP Practices to remove");
			return;
		}
		form.ctnGPDetails().lyrGPDetails().tabPractices().dyngrdPractices().getRows().remove(form.ctnGPDetails().lyrGPDetails().tabPractices().dyngrdPractices().getSelectedRow());
		updateControlsState();
	}

	protected void onBtnCloseClick() throws PresentationLogicException
	{
		form.getGlobalContext().NTPF.setTargetObjectId(null);
		engine.close(DialogResult.OK);
	}

	protected void onLnkBackClick() throws PresentationLogicException
	{
		if (engine.getFormName().equals(form.getForms().Admin.GPAdminDialog))
			engine.close(DialogResult.OK);
		else
		{
			form.getGlobalContext().NTPF.setTargetObjectId(null);

			if (form.getLocalContext().getPreviousFormIsNotNull())
				engine.open(form.getLocalContext().getPreviousForm());
		}
	}

	protected void onFormClosing(CancelArgs args) throws PresentationLogicException
	{
		form.getGlobalContext().NTPF.setTargetObjectId(null);
		form.getGlobalContext().Admin.setInvisibleRemoveContextMenu(null);
	}

	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.GPAdminMappings.ADD :
				form.ctnGPDetails().lyrGPDetails().tabGPDetails().grdMappings().getRows().newRow();
				break;
			case GenForm.ContextMenus.GPAdminMappings.REMOVE:
				form.ctnGPDetails().lyrGPDetails().tabGPDetails().grdMappings().getRows().remove(form.ctnGPDetails().lyrGPDetails().tabGPDetails().grdMappings().getSelectedRowIndex());
				updateControlsState();
				break;			
			case GenForm.ContextMenus.GPAdminContacts.ADD :
				form.ctnGPDetails().lyrGPDetails().tabGPDetails().grdContacts().getRows().newRow();
				break;
			case GenForm.ContextMenus.GPAdminContacts.REMOVE :
				form.ctnGPDetails().lyrGPDetails().tabGPDetails().grdContacts().getRows().remove(form.ctnGPDetails().lyrGPDetails().tabGPDetails().grdContacts().getSelectedRowIndex());
				updateControlsState();
				break;
			case GenForm.ContextMenus.GpPracticeGrid.RemovePractice :
				removePractice();
				break;
			case GenForm.ContextMenus.GpPracticeGrid.SearchAddPractice :
				searchPractice(false);		//wdev-10649
				break;
			default :
				break;
		}
	}

	protected void onFormModeChanged()
	{
		updateControlsState();
	}

	private void searchPractice(Boolean bolArg)
	{
		form.getLocalContext().setUpdatePractice(null);
		form.getGlobalContext().Admin.setInvisibleRemoveContextMenu(Boolean.TRUE);
		
		if(bolArg.equals(Boolean.TRUE))	//wdev-10649
			engine.open(form.getForms().Admin.GPPracticeSelect ,new Object[]{Boolean.FALSE});  //wdev-10649
		else
			engine.open(form.getForms().Admin.GPPracticeSelect);  //wdev-10649
	}

	protected void onGrdContactsSelectionChanged() 
	{
		updateControlsState();			
	}

	protected void onGrdMappingsSelectionChanged() 
	{
		updateControlsState();			
	}

	/** 
	 * Catches all events thrown by the CustomControlGpSearch. Clear button, Search button and
	 * a selection in the grid. Custom control handles actual events, here need only to set 
	 * the form to the correct state after the action
	 * @param null
	 * @return null
	 */
	protected void onCustomControlGpSearchValueChanged() throws PresentationLogicException
	{
		GPAction action = form.customControlGpSearch().getActionEvent();

		if (action != null)
		{
			if (action.equals(GPAction.CLEAR))
			{
				form.customControlGpSearch().setValue(null);
				form.getLocalContext().setGPVo(null);
				clearScreen();
				form.setMode(FormMode.VIEW);
			}
			if (action.equals(GPAction.SEARCH))
			{
				form.ctnGPDetails().setCollapsed(true);
				clearInstanceControls();
				form.setMode(FormMode.VIEW);
			}
			if (action.equals(GPAction.SELECT))
			{
				getSelectedGP();
				form.setMode(FormMode.VIEW);
			}
			if(action.equals(GPAction.NEW))
			{
				newInstance();	
			}
			if(action.equals(GPAction.EDIT))
			{
				editInstance();
			}
		}
	}

	protected void onDyngrdPracticesRowSelectionChanged(DynamicGridRow row)
	{
		updateControlsState();
	}

	protected void onDyngrdPracticesCellValueChanged(DynamicGridCell cell)
	{
		if (cell.getType().getID() == DynamicCellType.BOOL.getID())
		{
			if (cell.getValue().equals(Boolean.TRUE))
			{
				DynamicGridRow pRow;
				for (int i = 0; i < form.ctnGPDetails().lyrGPDetails().tabPractices().dyngrdPractices().getRows().size();i++)
				{
					pRow = form.ctnGPDetails().lyrGPDetails().tabPractices().dyngrdPractices().getRows().get(i);
					DynamicGridCell cellPrimary = pRow.getCells().get(form.ctnGPDetails().lyrGPDetails().tabPractices().dyngrdPractices().getColumns().getByIdentifier(COL_PRIMARY));
					cellPrimary.setValue(Boolean.FALSE);
					//WDEV-16516
					if(pRow.getValue() instanceof GpToPracticesVo)
					{
						((GpToPracticesVo) pRow.getValue()).setIsPrimaryPractice(false);
					}
				}
				cell.setValue(Boolean.TRUE);
				//WDEV-16516
				if(cell.getRow().getValue()  instanceof GpToPracticesVo)
				{
					((GpToPracticesVo) cell.getRow().getValue()).setIsPrimaryPractice(true);
				}
			}
		}
	}

	@Override
	protected void onBtnPracticeClick() throws PresentationLogicException {
		searchPractice(true);	//wdev-10649	
	}
}
