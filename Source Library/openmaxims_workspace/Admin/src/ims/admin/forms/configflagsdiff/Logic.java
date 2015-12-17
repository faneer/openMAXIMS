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
// This code was generated by Gabriel Maxim using IMS Development Environment (version 1.80 build 4968.18547)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.admin.forms.configflagsdiff;

import ims.admin.vo.FlagCategoryVo;
import ims.configuration.AFlag;
import ims.configuration.EnvironmentConfig;
import ims.configuration.gen.ConfigFlag;
import ims.configuration.gen.ConfigFlag.DOM;
import ims.configuration.gen.ConfigFlag.DTO;
import ims.configuration.gen.ConfigFlag.FW;
import ims.configuration.gen.ConfigFlag.GEN;
import ims.configuration.gen.ConfigFlag.HL7;
import ims.configuration.gen.ConfigFlag.RCHTIM;
import ims.configuration.gen.ConfigFlag.UI;
import ims.core.vo.ConfigFlagListVo;
import ims.core.vo.ConfigFlagListVoCollection;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.enumerations.FormMode;
import ims.framework.enumerations.SortMode;
import ims.framework.enumerations.SortOrder;
import ims.framework.utils.Color;
import ims.framework.utils.DateTime;
import ims.framework.utils.DateTimeFormat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Logic extends BaseLogic
{
	private static final int COL_GROUP = 0;
	private static final int COL_FLAG = 1;
	private static final int COL_DEFAULT = 2;
	private static final int COL_CURRENT = 3;
	private static final int COL_UPD_DATE = 4;

	private static final long serialVersionUID = 1L;


	private static final FlagCategoryVo DOM = createCategory("DOM", "Data");
	private static final FlagCategoryVo DTO = createCategory("DTO", "DTO");
	private static final FlagCategoryVo FW = createCategory("FW", "Framework");
	private static final FlagCategoryVo GEN = createCategory("GEN", "General");
	private static final FlagCategoryVo HL7 = createCategory("HL7", "HL7 Engine");
	private static final FlagCategoryVo RCHTIM = createCategory("RCHTIM", "RCHT HL7 Interface");
	private static final FlagCategoryVo UI = createCategory("UI", "User Interface");

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();
	}

	private void open()
	{
		form.setMode(FormMode.VIEW);
		form.dyngrdFlags().getRows().clear();
		form.getLocalContext().setCategorySortOrder(SortOrder.ASCENDING);
		populateGrid(new ArrayList<ConfigFlagAndCategory>());
		addEnvironmentConfig();
	}

	private void initialize()
	{
		initializeFlagsGrid();


	}
	private void addEnvironmentConfig()
	{

		if (Boolean.TRUE.equals(EnvironmentConfig.getShowSQL()))
		{
			DynamicGridRow row = form.dyngrdFlags().getRows().newRow();
			row.setSelectable(Boolean.FALSE);
			row.setReadOnly(Boolean.TRUE);
			DynamicGridCell cell = row.getCells().newCell(getColumn(COL_GROUP), DynamicCellType.STRING);
			cell.setValue("Environment Config");
			cell.setReadOnly(Boolean.TRUE);
			cell = row.getCells().newCell(getColumn(COL_FLAG), DynamicCellType.STRING);
			cell.setValue("SHOW_SQL");
			cell = row.getCells().newCell(getColumn(COL_DEFAULT), DynamicCellType.STRING);
			cell.setValue("");
			cell = row.getCells().newCell(getColumn(COL_CURRENT), DynamicCellType.STRING);
			String showSql = String.valueOf(EnvironmentConfig.getShowSQL());
			row.setTextColor(Color.FireBrick);
			row.setBackColor(Color.CadetBlue);
			cell.setValue(showSql);
			row.setSelectable(Boolean.FALSE);
			row.setReadOnly(Boolean.TRUE);
			row.setValue("Environment Config - SHOW SQL" );
		}
		if (!"WARN".equals(EnvironmentConfig.GetLoggingLevel().toString().toUpperCase()))
		{
			DynamicGridRow row = form.dyngrdFlags().getRows().newRow();
			row.setSelectable(Boolean.FALSE);
			row.setReadOnly(Boolean.TRUE);
			DynamicGridCell cell = row.getCells().newCell(getColumn(COL_GROUP), DynamicCellType.STRING);
			cell.setValue("Environment Config");
			cell.setReadOnly(Boolean.TRUE);
			cell = row.getCells().newCell(getColumn(COL_FLAG), DynamicCellType.STRING);
			cell.setValue("LOGGING_LEVEL");
			cell = row.getCells().newCell(getColumn(COL_DEFAULT), DynamicCellType.STRING);
			cell.setValue("<b>WARN</b>");
			cell = row.getCells().newCell(getColumn(COL_CURRENT), DynamicCellType.STRING);
			cell.setValue(EnvironmentConfig.GetLoggingLevel().toString());
			row.setTextColor(Color.FireBrick);
			row.setBackColor(Color.CadetBlue);
			row.setSelectable(Boolean.FALSE);
			row.setReadOnly(Boolean.TRUE);
			row.setValue("Environment Config - Logging Level");
		}

		if (Boolean.TRUE.equals(EnvironmentConfig.getHibernateUseSQLComments()))
		{
			DynamicGridRow row = form.dyngrdFlags().getRows().newRow();
			row.setSelectable(Boolean.FALSE);
			row.setReadOnly(Boolean.TRUE);
			DynamicGridCell cell = row.getCells().newCell(getColumn(COL_GROUP), DynamicCellType.STRING);
			cell.setValue("Environment Config");
			cell.setReadOnly(Boolean.TRUE);
			cell = row.getCells().newCell(getColumn(COL_FLAG), DynamicCellType.STRING);
			cell.setValue("HIBERNATE_USE_SQL_COMMENTS");
			cell = row.getCells().newCell(getColumn(COL_DEFAULT), DynamicCellType.STRING);
			cell.setValue("");
			cell = row.getCells().newCell(getColumn(COL_CURRENT), DynamicCellType.STRING);
			String useSqlComm = String.valueOf(EnvironmentConfig.getHibernateUseSQLComments());
			cell.setValue(useSqlComm);
			row.setTextColor(Color.FireBrick);
			row.setBackColor(Color.CadetBlue);
			row.setSelectable(Boolean.FALSE);
			row.setReadOnly(Boolean.TRUE);
			row.setValue("Environment Config - Hibernate use SQL comments");
		}
		if (EnvironmentConfig.getResultSetDefaultMax() > 0)

		{
			DynamicGridRow row = form.dyngrdFlags().getRows().newRow();
			row.setSelectable(Boolean.FALSE);
			row.setReadOnly(Boolean.TRUE);
			DynamicGridCell cell = row.getCells().newCell(getColumn(COL_GROUP), DynamicCellType.STRING);
			cell.setValue("Environment Config");
			cell.setReadOnly(Boolean.TRUE);
			cell = row.getCells().newCell(getColumn(COL_FLAG), DynamicCellType.STRING);
			cell.setValue("RESULT_SET_DEFAULT_MAX");
			cell = row.getCells().newCell(getColumn(COL_DEFAULT), DynamicCellType.STRING);
			cell.setValue("");
			cell = row.getCells().newCell(getColumn(COL_CURRENT), DynamicCellType.STRING);
			cell.setValue(String.valueOf(EnvironmentConfig.getResultSetDefaultMax()));
			row.setTextColor(Color.FireBrick);
			row.setBackColor(Color.CadetBlue);
			row.setSelectable(Boolean.FALSE);
			row.setReadOnly(Boolean.TRUE);
			row.setValue("Environment Config - Result Set Default Max");
		}
		if (EnvironmentConfig.getResultSetTopMax() > 0)
		{
			DynamicGridRow row = form.dyngrdFlags().getRows().newRow();
			DynamicGridCell cell = row.getCells().newCell(getColumn(COL_GROUP), DynamicCellType.STRING);
			cell.setValue("Environment Config");
			row.setSelectable(Boolean.FALSE);
			row.setReadOnly(Boolean.TRUE);
			cell = row.getCells().newCell(getColumn(COL_FLAG), DynamicCellType.STRING);
			cell.setValue("RESULT_TOP_MAX");
			cell = row.getCells().newCell(getColumn(COL_DEFAULT), DynamicCellType.HTMLVIEW);
			cell.setValue("");
			cell = row.getCells().newCell(getColumn(COL_CURRENT), DynamicCellType.STRING);
			cell.setValue(String.valueOf(EnvironmentConfig.getResultSetTopMax()));
			row.setTextColor(Color.FireBrick);
			row.setBackColor(Color.CadetBlue);
			row.setSelectable(Boolean.FALSE);
			row.setReadOnly(Boolean.TRUE);
			row.setValue("Environment Config - Result Set Top Max");
		}
	}

	private void initializeFlagsGrid()
	{
		form.dyngrdFlags().clear();

		DynamicGridColumn col = form.dyngrdFlags().getColumns().newColumn("Group", COL_GROUP);
		col.setWidth(85);
		col.setCanGrow(Boolean.TRUE);
		col.setReadOnly(Boolean.TRUE);
		col.setSortMode(SortMode.AUTOMATIC);

		col = form.dyngrdFlags().getColumns().newColumn("Configuration Flag", COL_FLAG);
		col.setWidth(300);
		col.setCanGrow(Boolean.TRUE);
		col.setReadOnly(Boolean.TRUE);
		col.setSortMode(SortMode.AUTOMATIC);

		col = form.dyngrdFlags().getColumns().newColumn("Default Value",COL_DEFAULT);
		col.setWidth(175);
		col.setCanGrow(Boolean.TRUE);
		col.setReadOnly(Boolean.TRUE);

		col = form.dyngrdFlags().getColumns().newColumn("Current Value",COL_CURRENT);
		col.setWidth(200);
		col.setCanGrow(Boolean.TRUE);
		col.setReadOnly(Boolean.TRUE);

		col = form.dyngrdFlags().getColumns().newColumn("Last Updated Date/Time",COL_UPD_DATE);
		col.setWidth(-1);
		col.setCanGrow(Boolean.TRUE);
		col.setReadOnly(Boolean.TRUE);
		col.setSortMode(SortMode.MANUAL);
	}

	private void populateGrid(ArrayList<ConfigFlagAndCategory> flagsandcategory) 
	{
		if (flagsandcategory == null || flagsandcategory.size() == 0)
		{	
			ConfigFlagListVoCollection savedFlags = domain.listSavedConfigFlags();
			if (savedFlags == null)
				return ;

			flagsandcategory = new ArrayList<ConfigFlagAndCategory>();

			for (int x = 0; x < savedFlags.size(); x++)
			{
				ConfigFlagListVo savedFlag = savedFlags.get(x);
				if (savedFlag == null)
					continue;

				ConfigFlagAndCategory configFlag = getConfigFlagFromConfig(savedFlag);
				if (configFlag != null && configFlag.getFlag() != null)
				{	
					if ((savedFlag.getValue() == null && getDefaultValue(configFlag) != null) || (savedFlag.getValue() != null && Boolean.TRUE.equals(!savedFlag.getValue().equals(getDefaultValue(configFlag)))))
					{

						flagsandcategory.add(configFlag);
					}
				}
			}
		}
		if (form.getLocalContext().getCategorySortOrderIsNotNull() && flagsandcategory != null)
		{	
			Collections.sort(flagsandcategory, new FlagCatComparator(form.getLocalContext().getCategorySortOrder()));
		}
		form.dyngrdFlags().getRows().clear();
		for (int i=0; i< flagsandcategory.size(); i++)
		{
			addConfigFlagRow(flagsandcategory.get(i));
		}


	}	

	private void addConfigFlagRow(ConfigFlagAndCategory configFlag) 
	{
		if(configFlag == null || configFlag.getCategory() == null || configFlag.getSavedFlag() == null)
			return;

		DynamicGridRow row = form.dyngrdFlags().getRows().newRow();
		String defaultValue = getDefaultValue(configFlag);

		if (Boolean.TRUE.equals(configFlag.getSavedFlag().getIsSystem().booleanValue()))
		{
			row.setBackColor(Color.CadetBlue);
		}
		row.setSelectable(Boolean.FALSE);
		row.setReadOnly(Boolean.TRUE);

		DynamicGridCell grpcell = row.getCells().newCell(getColumn(COL_GROUP), DynamicCellType.STRING);
		grpcell.setValue(configFlag.getCategory().getNameIsNotNull() ? configFlag.getCategory().getName() : "");
		grpcell.setTooltip(getToolTip(configFlag.getSavedFlag(), defaultValue));
		grpcell.setReadOnly(Boolean.TRUE);

		DynamicGridCell flagcell = row.getCells().newCell(getColumn(COL_FLAG), DynamicCellType.STRING);
		flagcell.setValue(configFlag.getSavedFlag().getName());
		flagcell.setTooltip(getToolTip(configFlag.getSavedFlag(), defaultValue));

		flagcell = row.getCells().newCell(getColumn(COL_DEFAULT), DynamicCellType.HTMLVIEW);
		flagcell.setValue("<b>" + defaultValue + "</b>" );
		flagcell.setTooltip(getToolTip(configFlag.getSavedFlag(), defaultValue));

		flagcell = row.getCells().newCell(getColumn(COL_CURRENT),DynamicCellType.STRING);
		flagcell.setValue(configFlag.getSavedFlag().getValueIsNotNull() ? configFlag.getSavedFlag().getValue() : "");
		flagcell.setTooltip(getToolTip(configFlag.getSavedFlag(), defaultValue));

		flagcell = row.getCells().newCell(getColumn(COL_UPD_DATE),DynamicCellType.STRING);
		flagcell.setValue(configFlag.getSavedFlag().getSystemInformationIsNotNull() && configFlag.getSavedFlag().getSystemInformation().getLastupdateDateTime() != null ? configFlag.getSavedFlag().getSystemInformation().getLastupdateDateTime().toString(DateTimeFormat.STANDARD) : configFlag.getSavedFlag().getSystemInformation().getCreationDateTime().toString(DateTimeFormat.STANDARD));
		flagcell.setTooltip(getToolTip(configFlag.getSavedFlag(), defaultValue));
		row.setValue(configFlag);
	}


	private static FlagCategoryVo createCategory(String key, String name)
	{
		FlagCategoryVo vo = new FlagCategoryVo();
		vo.setKey(key);
		vo.setName(name);
		return vo;
	}

	private String getToolTip (ConfigFlagListVo flag, String defaultValue)
	{
		StringBuffer sb = new StringBuffer();
		if (flag != null)
		{	
			String grp = getConfigFlagFromConfig(flag).getCategory() != null ? getConfigFlagFromConfig(flag).getCategory().getName() : "";
			sb.append("<b>Group: </b>" + grp);
			if (flag.getNameIsNotNull())
			{	
				sb.append("<br><b>Name: </b>" + flag.getName());
				String defaultVal = defaultValue != null ? defaultValue : "No Default";
				sb.append("<br><b>Default Value: </b>" + defaultVal);
			}
			sb.append("<br><b>Current Value: </b>" + flag.getValue());

			if (flag.getIsSystemIsNotNull())
			{	
				String sys = flag.getIsSystem() ? flag.getIsSystem().toString() : "false";	
				sb.append("<br><b>System Flag: </b>" + sys);
			}
			if (flag.getSystemInformationIsNotNull())
			{	
				sb.append("<br><b>Creation User: </b>" + flag.getSystemInformation().getCreationUser().toString());
				sb.append("<br><b>Creation Date/Time: </b>" + flag.getSystemInformation().getCreationDateTime().toString(DateTimeFormat.STANDARD));
				String updUser = flag.getSystemInformation().getLastupdateUser() != null ? flag.getSystemInformation().getLastupdateUser().toString() : flag.getSystemInformation().getCreationUser().toString();
				sb.append("<br><b>Last Updating User: </b>" + updUser);
				String updDate = flag.getSystemInformation().getLastupdateDateTime() != null ? flag.getSystemInformation().getLastupdateDateTime().toString(DateTimeFormat.STANDARD) : flag.getSystemInformation().getCreationDateTime().toString(DateTimeFormat.STANDARD);
				sb.append("<br><b>Last Updated Date/Time: </b>" + updDate);
			}
		}
		return sb.toString();
	}

	private String getDefaultValue(ConfigFlagAndCategory flagVo)
	{
		if(flagVo == null || flagVo.getFlag() == null)
			return null;

		return flagVo.getFlag().getDefaultValAsString();

	}

	public ConfigFlagAndCategory getConfigFlagFromConfig(ConfigFlagListVo savedFlag)
	{
		if (savedFlag == null || savedFlag.getName() == null) return null;

		AFlag[] flags = ConfigFlag.getFlags(UI.class);
		for (int i = 0; i < flags.length; i++)
		{
			AFlag flag = flags[i];
			if (flag.getName().equals(savedFlag.getName()))
				return new ConfigFlagAndCategory(UI, flag, savedFlag);
		}

		flags = ConfigFlag.getFlags(FW.class);
		for (int i = 0; i < flags.length; i++)
		{
			AFlag flag = flags[i];
			if (flag.getName().equals(savedFlag.getName())) 
				return  new ConfigFlagAndCategory(FW, flag, savedFlag);
		}

		flags = ConfigFlag.getFlags(DOM.class);
		for (int i = 0; i < flags.length; i++)
		{
			AFlag flag = flags[i];
			if (flag.getName().equals(savedFlag.getName())) 
				return  new ConfigFlagAndCategory(DOM, flag, savedFlag);
		}

		flags = ConfigFlag.getFlags(GEN.class);
		for (int i = 0; i < flags.length; i++)
		{
			AFlag flag = flags[i];
			if (flag.getName().equals(savedFlag.getName())) 
				return  new ConfigFlagAndCategory(GEN, flag, savedFlag);
		}

		flags = ConfigFlag.getFlags(DTO.class);
		for (int i = 0; i < flags.length; i++)
		{
			AFlag flag = flags[i];
			if (flag.getName().equals(savedFlag.getName())) 
				return  new ConfigFlagAndCategory(DTO, flag, savedFlag);
		}

		flags = ConfigFlag.getFlags(HL7.class);
		for (int i = 0; i < flags.length; i++)
		{
			AFlag flag = flags[i];
			if (flag.getName().equals(savedFlag.getName())) 
				return  new ConfigFlagAndCategory(HL7, flag, savedFlag);
		}

		flags = ConfigFlag.getFlags(RCHTIM.class);
		for (int i = 0; i < flags.length; i++)
		{
			AFlag flag = flags[i];
			if (flag.getName().equals(savedFlag.getName())) 
				return  new ConfigFlagAndCategory(RCHTIM, flag, savedFlag);
		}

		return null;
	}

	private DynamicGridColumn getColumn(Integer colFieldName) 
	{
		return form.dyngrdFlags().getColumns().getByIdentifier(colFieldName);
	}	

	@Override
	protected void onBtnCloseClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.OK);
	}

	public class ConfigFlagAndCategory
	{
		FlagCategoryVo category;
		AFlag 		   flag;
		ConfigFlagListVo savedflag;

		public ConfigFlagAndCategory(FlagCategoryVo cat, AFlag flg, ConfigFlagListVo svdflag)
		{
			category = cat;
			flag = flg;
			savedflag = svdflag;
		}

		public FlagCategoryVo getCategory()
		{
			return this.category;
		}

		public AFlag getFlag()
		{
			return this.flag;
		}
		public ConfigFlagListVo getSavedFlag()
		{
			return this.savedflag;

		}
		public DateTime getDisplayDate()
		{	
			DateTime displayDate = null;

			if (savedflag.getSystemInformation().getLastupdateDateTime() != null)
			{
				displayDate = this.savedflag.getSystemInformation().getLastupdateDateTime();
			}
			else if (savedflag.getSystemInformation().getLastupdateDateTime() == null && savedflag.getSystemInformation().getCreationDateTime() != null)
			{	
				displayDate =  this.savedflag.getSystemInformation().getCreationDateTime();
			}	
			return displayDate;
		}
	}


	class FlagCatComparator implements Comparator<ConfigFlagAndCategory>
	{
		private int order =1;
		public FlagCatComparator()
		{
			order = 1;
		}
		public FlagCatComparator(SortOrder order)
		{
			this.order = SortOrder.DESCENDING.equals(order) ? -1 : 1;
		}

		public int compare(ConfigFlagAndCategory o1, ConfigFlagAndCategory o2)
		{
			if (o1 != null && o1.getFlag() != null && o2!=null && o2.getCategory() != null)
			{
				int compareResult = order*o1.getCategory().getKey().compareToIgnoreCase(o2.getCategory().getKey());

				if(compareResult == 0)
				{
					if(o1.getFlag() != null && o2.getFlag() != null)
						return o1.getFlag().getName().compareToIgnoreCase(o2.getFlag().getName());

					if(o1.getFlag() == null)
						return -1*order;

					if(o2.getFlag() == null)
						return order;
				}

				return compareResult;
			}
			if (o1 == null || !(o1.getCategory() != null))
				return -1*order;

			if (o2 == null || !(o2.getCategory() != null))
				return order;

			return 0;
		}	
	}


	private class DateTimeComparator implements Comparator<ConfigFlagAndCategory>
	{
		private int order =1;

		private DateTimeComparator()
		{
			order = 1;
		}
		private DateTimeComparator(SortOrder order)
		{
			this.order = SortOrder.DESCENDING.equals(order)?-1:1;
		}

		public int compare(ConfigFlagAndCategory o1, ConfigFlagAndCategory o2)
		{
			if (o1 != null && o1.getSavedFlag().getSystemInformation() != null && o1.getDisplayDate() != null && o2 != null && o2.getSavedFlag().getSystemInformation() != null && o2.getDisplayDate() != null) 
			{
				return order*o1.getDisplayDate().compareTo(o2.getDisplayDate());
			}
			if (o1 == null || !(o1.getDisplayDate() != null))
				return -1*order;
			if (o2 == null || !(o2.getDisplayDate() != null))
				return order;

			return 0;
		}	
	}	

	private ArrayList<ConfigFlagAndCategory> getValuesFromGrid() 
	{
		if(form.dyngrdFlags().getRows().size() == 0)
			return null;

		ArrayList<ConfigFlagAndCategory> values = new ArrayList<ConfigFlagAndCategory>();

		for(int i=0; i<form.dyngrdFlags().getRows().size(); i++)
		{
			Object val = form.dyngrdFlags().getRows().get(i).getValue();
			if (val != null && val instanceof ConfigFlagAndCategory)
			{	
				values.add((ConfigFlagAndCategory) form.dyngrdFlags().getRows().get(i).getValue());
			}	
		}

		return values;
	}

	@Override
	protected void onDyngrdFlagsColumnHeaderClicked(DynamicGridColumn column)
	{
		int colID = form.dyngrdFlags().getColumns().indexOf(column);
		ArrayList<ConfigFlagAndCategory> values = getValuesFromGrid();

		if (values != null)
		{	
			switch (colID)
			{

			case COL_UPD_DATE:
				form.getLocalContext().setCategorySortOrder(null);
				form.getLocalContext().setUpdatedDateTimeSortOrder((SortOrder.ASCENDING.equals(form.getLocalContext().getUpdatedDateTimeSortOrder()) ? SortOrder.DESCENDING : SortOrder.ASCENDING));
				Collections.sort(values, new DateTimeComparator(form.getLocalContext().getUpdatedDateTimeSortOrder()));
				break;
			}
		}
		populateGrid(values);
		addEnvironmentConfig();
	}
}
