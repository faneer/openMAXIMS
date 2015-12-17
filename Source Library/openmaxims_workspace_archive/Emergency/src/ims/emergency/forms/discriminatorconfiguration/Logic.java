//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 4342.23748)
// Copyright (C) 1995-2012 IMS MAXIMS. All rights reserved.

package ims.emergency.forms.discriminatorconfiguration;

import ims.admin.helper.Keywords;
import ims.core.vo.KeywordVo;
import ims.core.vo.KeywordVoCollection;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.emergency.forms.discriminatorconfiguration.GenForm.grdDiscriminatorRow;
import ims.emergency.forms.discriminatorconfiguration.GenForm.grdKeywordsRow;
import ims.emergency.vo.DiscriminatorConfigVo;
import ims.emergency.vo.DiscriminatorConfigVoCollection;
import ims.framework.Control;
import ims.framework.enumerations.FormMode;
import ims.framework.enumerations.SortOrder;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;

import java.util.Comparator;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException
	{
		form.ccTaxonomyMappings().initialize();
		open();
	}

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if (save())
		{
			open();
		}
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clearInstanceControls();
		open();
	}

	@Override
	protected void onBtnEditClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
	}

	@Override
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		clearInstanceControls();
		form.getLocalContext().setSelectedItem(null);
		form.chkActive().setValue(true);
		form.setMode(FormMode.EDIT);
	}

	@Override
	protected void onCcTaxonomyMappingsValueChanged() throws ims.framework.exceptions.PresentationLogicException
	{
		// TODO Add your code here.
	}

	@Override
	protected void onGrdDiscriminatorSelectionChanged()
	{
		getSelectedInstance();
	}

	private void getSelectedInstance()
	{

		DiscriminatorConfigVo voDiscriminatorConfig = domain.getDiscriminatorConfig(form.grdDiscriminator().getSelectedRow().getValue());

		if (voDiscriminatorConfig == null)
		{
			return;
		}

		form.getLocalContext().setSelectedItem(voDiscriminatorConfig);
		clearInstanceControls();
		populateInstanceControls(voDiscriminatorConfig);
		updateControlsState();
	}

	@Override
	protected void onBtnSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.getLocalContext().setSelectedItem(null);
		doSearch();
	}

	private void doSearch()
	{

		/*
		 * if (form.txtSearch().getValue() == null ||
		 * form.txtSearch().getValue().length() < 3) { engine.showMessage(
		 * "Please enter a search string of at least 3 characters."); return; }
		 */

		populateDiscriminatorGrid(domain.listDiscriminators(form.txtSearch().getValue(), Boolean.valueOf(form.chkActiveOnly().getValue()), null)); // wdev-15985
		updateControlsState();
	}

	private void populateDiscriminatorGrid(DiscriminatorConfigVoCollection discriminators)
	{
		clearScreen();

		if (discriminators == null)
		{
			engine.showMessage("No Discriminators found for the search criteria.");
			form.getLocalContext().setSelectedItem(null);
			return;
		}

		// wdev-15985
		discriminators.sort(new DiscriminatorComparator(SortOrder.ASCENDING));

		for (int i = 0; i < discriminators.size(); i++)
		{
			grdDiscriminatorRow rowDiscriminator = form.grdDiscriminator().getRows().newRow();
			if (discriminators.get(i).getIsActiveIsNotNull() && !discriminators.get(i).getIsActive())
			{
				rowDiscriminator.setBold(false);
				rowDiscriminator.setTextColor(Color.Gray);
			}
			rowDiscriminator.setColDiscriminator(discriminators.get(i).getDiscriminatorName());
			rowDiscriminator.setValue(discriminators.get(i));
		}

	}

	private void clearScreen()
	{
		clearDiscriminatorGrid();
		clearInstanceControls();
	}

	private void clearDiscriminatorGrid()
	{
		form.grdDiscriminator().getRows().clear();
		form.grdDiscriminator().setValue(null);
	}

	public void open() throws ims.framework.exceptions.PresentationLogicException
	{

		if (form.getLocalContext().getSelectedItemIsNotNull())
		{
			form.getLocalContext().setSelectedItem(domain.getDiscriminatorConfig(form.getLocalContext().getSelectedItem()));

			form.txtSearch().setValue(form.getLocalContext().getSelectedItem().getDiscriminatorName());
			populateDiscriminatorGrid(domain.listDiscriminators(form.txtSearch().getValue(), Boolean.valueOf(form.chkActiveOnly().getValue()), form.getLocalContext().getSelectedItem())); // wdev-15985
			populateInstanceControls(form.getLocalContext().getSelectedItem());
			form.grdDiscriminator().setValue(form.getLocalContext().getSelectedItem());
		}
		else
		{
			form.grdDiscriminator().setValue(null);
		}

		form.txtSearch().setFocus();
		form.setMode(FormMode.VIEW);
	}

	private void populateInstanceControls(DiscriminatorConfigVo discriminatorConfig)
	{
		clearInstanceControls();

		if (discriminatorConfig == null)
			return;

		form.txtName().setValue(discriminatorConfig.getDiscriminatorName());
		form.txtDescriprion().setValue(discriminatorConfig.getDiscriminatorDescription());
		form.chkActive().setValue(discriminatorConfig.getIsActive());
		form.cmbDefaultPriority().setValue(discriminatorConfig.getDefaultTriagePriority());
		form.ccTaxonomyMappings().setValue(discriminatorConfig.getTaxonomyMap());

		populateGridKeywords(discriminatorConfig.getKeywords());

	}

	private void populateGridKeywords(KeywordVoCollection keywords)
	{
		if (keywords == null)
		{
			return;
		}

		for (int i = 0; i < keywords.size(); i++)
		{
			grdKeywordsRow rowKeyword = form.grdKeywords().getRows().newRow();
			rowKeyword.setColKeywords(keywords.get(i).getKeyword());
			rowKeyword.setValue(keywords.get(i));
		}

	}

	public void clearInstanceControls()
	{
		form.txtName().setValue(null);
		form.txtDescriprion().setValue(null);
		form.chkActive().setValue(null);
		form.cmbDefaultPriority().setValue(null);
		form.ccTaxonomyMappings().clear();
		form.grdKeywords().getRows().clear();
	}

	public void newInstance() throws ims.framework.exceptions.PresentationLogicException
	{
		form.setMode(FormMode.EDIT);
		updateControlsState();
	}

	public boolean save() throws ims.framework.exceptions.PresentationLogicException
	{

		if (form.txtName().getValue() != null && form.txtName().getValue().length() < 3)
		{
			engine.showMessage("Please enter a Discriminator name of length greater than 3 letters");
			return false;
		}

		DiscriminatorConfigVo discriminatorToSave = populateDataFromScreen(form.getLocalContext().getSelectedItem());

		String[] errors = discriminatorToSave.validate();
		if (errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}

		try
		{
			discriminatorToSave = domain.saveDiscriminatorConfig(discriminatorToSave);
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		}
		catch (UniqueKeyViolationException e)
		{
			engine.showMessage(e.getMessage());
			return false;
		}
		catch (DomainInterfaceException e)
		{
			engine.showMessage(e.getMessage());
			return false;
		}

		form.getLocalContext().setSelectedItem(discriminatorToSave);
		return true;
	}

	private DiscriminatorConfigVo populateDataFromScreen(DiscriminatorConfigVo discriminatorConfiguration)
	{
		if (discriminatorConfiguration == null)
		{
			discriminatorConfiguration = new DiscriminatorConfigVo();
		}

		discriminatorConfiguration.setDiscriminatorName(form.txtName().getValue());
		discriminatorConfiguration.setDiscriminatorDescription(form.txtDescriprion().getValue());
		discriminatorConfiguration.setIsActive(form.chkActive().getValue());
		discriminatorConfiguration.setDefaultTriagePriority(form.cmbDefaultPriority().getValue());
		discriminatorConfiguration.setTaxonomyMap(form.ccTaxonomyMappings().getValue());
		discriminatorConfiguration.setKeywords(getDiscriminatorKeywords());

		return discriminatorConfiguration;
	}

	private KeywordVoCollection getDiscriminatorKeywords()
	{
		KeywordVoCollection voKeywordVoCollection = new KeywordVoCollection();
		for (int i = 0; i < form.grdKeywords().getRows().size(); i++)
		{
			grdKeywordsRow row = form.grdKeywords().getRows().get(i);
			KeywordVo vo = row.getValue();

			if (vo == null)
			{
				vo = new KeywordVo();
			}

			if (row.getColKeywords() == null || row.getColKeywords().equals(""))
				continue;

			vo.setKeyword(row.getColKeywords());
			voKeywordVoCollection.add(vo);
		}

		return voKeywordVoCollection;
	}

	public void updateControlsState()
	{

		form.ccTaxonomyMappings().setMode(form.getMode());
		form.ccTaxonomyMappings().setComponentMode(form.getMode());

		if (form.getMode().equals(FormMode.VIEW))
		{
			form.ccTaxonomyMappings().setMode(FormMode.VIEW);
			form.btnEdit().setVisible(form.getLocalContext().getSelectedItemIsNotNull());
			form.getContextMenus().getKeywordAdminAddItem().setVisible(false);
			form.getContextMenus().getKeywordAdminMoveDownItem().setVisible(false);
			form.getContextMenus().getKeywordAdminMoveUpItem().setVisible(false);
			form.getContextMenus().getKeywordAdminRemoveAllItem().setVisible(false);
			form.getContextMenus().getKeywordAdminRestoreItem().setVisible(false);
			form.getContextMenus().getKeywordAdminRemoveItem().setVisible(false);
		}
		else
		{
			form.grdKeywords().setEnabled(true);
			form.grdKeywords().setReadOnly(false);
			form.getContextMenus().getKeywordAdminAddItem().setVisible(true);
			form.getContextMenus().getKeywordAdminMoveDownItem().setVisible(form.grdKeywords().canMoveCurrentDown());
			form.getContextMenus().getKeywordAdminMoveUpItem().setVisible(form.grdKeywords().canMoveCurrentUp());
			form.getContextMenus().getKeywordAdminRemoveAllItem().setVisible(form.grdKeywords().getRows().size() > 0);
			form.getContextMenus().getKeywordAdminRestoreItem().setVisible(form.grdKeywords().isEnabled());
			form.getContextMenus().getKeywordAdminRestoreItem().setVisible(form.grdKeywords().isEnabled());

			if (form.getLocalContext().getSelectedItemIsNotNull() && form.getLocalContext().getSelectedItem().getID_DiscriminatorConfigIsNotNull())
				form.getContextMenus().getKeywordAdminRestoreItem().setText("Restore defaults");
			else
				form.getContextMenus().getKeywordAdminRestoreItem().setText("Set to default");
		}

	}

	public void updateInstance()
	{
		// TODO: Add you code here.
	}

	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();
	}

	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
	{
		switch (menuItemID)
		{

			case GenForm.ContextMenus.KeywordAdmin.Add:
				addKeyword();
				break;
			case GenForm.ContextMenus.KeywordAdmin.Remove:
				removeKeyword();
				break;
			case GenForm.ContextMenus.KeywordAdmin.RemoveAll:
				removeAllKeywords();
				break;
			case GenForm.ContextMenus.KeywordAdmin.MoveUp:
				moveKeywordUp();
				break;
			case GenForm.ContextMenus.KeywordAdmin.MoveDown:
				moveKeywordDown();
				break;
			case GenForm.ContextMenus.KeywordAdmin.Restore:
				setDefaultKeywords();
				break;

		}

	}

	private void removeKeyword()
	{
		form.grdKeywords().removeSelectedRow();
		updateControlsState();
	}

	private void setDefaultKeywords()
	{
		form.grdKeywords().getRows().clear();

		if (form.txtName().getValue() == null)
		{
			engine.showMessage("Please add the Name before set default keywords!");
			return;
		}

		String[] keys = Keywords.generateKeywords(form.txtName().getValue());

		for (int i = 0; i < keys.length; i++)
		{
			grdKeywordsRow row = form.grdKeywords().getRows().newRow();
			row.setValue(new KeywordVo());
			row.setColKeywords(keys[i]);
		}

		updateControlsState();
	}

	private void moveKeywordUp()
	{
		form.grdKeywords().moveUp();
		updateControlsState();
	}

	private void moveKeywordDown()
	{
		form.grdKeywords().moveDown();
		updateControlsState();
	}

	private void removeAllKeywords()
	{
		form.grdKeywords().getRows().clear();
		updateControlsState();
	}

	private void addKeyword()
	{
		form.grdKeywords().getRows().newRow(true).setValue(new KeywordVo());
		updateControlsState();
	}

	@Override
	protected void onGrdKeywordsSelectionChanged() throws PresentationLogicException
	{
		updateControlsState();
	}

	// wdev-15985
	public class DiscriminatorComparator implements Comparator<DiscriminatorConfigVo>
	{
		private int direction = 1;

		public DiscriminatorComparator()
		{
			this(SortOrder.ASCENDING);
		}

		public DiscriminatorComparator(SortOrder order)
		{
			if (order == SortOrder.DESCENDING)
				direction = -1;
		}

		public int compare(DiscriminatorConfigVo ob1, DiscriminatorConfigVo ob2)
		{
			String discriminatorName1 = null;
			String discriminatorName2 = null;

			if (ob1 instanceof DiscriminatorConfigVo)
			{
				DiscriminatorConfigVo ps1 = (DiscriminatorConfigVo) ob1;
				discriminatorName1 = ps1.getDiscriminatorName().toUpperCase();
			}

			if (ob2 instanceof DiscriminatorConfigVo)
			{
				DiscriminatorConfigVo ps2 = (DiscriminatorConfigVo) ob2;
				discriminatorName2 = ps2.getDiscriminatorName().toUpperCase();
			}

			if (discriminatorName1 != null)
				return discriminatorName1.compareTo(discriminatorName2) * direction;
			if (discriminatorName2 != null)
				return (-1) * direction;

			return 0;
		}
	}
}
