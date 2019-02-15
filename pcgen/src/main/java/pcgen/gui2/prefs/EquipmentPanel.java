/*
 * Copyright 2010(C) James Dempsey
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package pcgen.gui2.prefs;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import pcgen.cdom.base.Constants;
import pcgen.core.SettingsHandler;
import pcgen.gui2.tools.Utility;
import pcgen.system.LanguageBundle;
import pcgen.system.PCGenSettings;

/**
 * The Class {@code EquipmentPanel} is responsible for
 * displaying equipment related preferences and allowing the 
 * preferences to be edited by the user.
 * 
 * 
 */
@SuppressWarnings("serial")
public class EquipmentPanel extends PCGenPrefsPanel
{
	private static final String IN_EQUIPMENT =
			LanguageBundle.getString("in_Prefs_equipment"); //$NON-NLS-1$

	// Used to create the entries for the max spell level combos
	private static final int SPELLLVLMIN = 0;
	private static final int SPELLLVLMAX = 9;

	private static final String IN_ALLOW_METAMAGIC =
			LanguageBundle.getString("in_Prefs_allowMetamagic"); //$NON-NLS-1$
	private static final String IN_ANY_AUTO_EQUIP =
			LanguageBundle.getString("in_Prefs_anyAutoEquip"); //$NON-NLS-1$
	private static final String IN_AUTO_EQUIP =
			LanguageBundle.getString("in_Prefs_autoEquip"); //$NON-NLS-1$
	private static final String IN_AUTO_EQUIP_RACE =
			LanguageBundle.getString("in_Prefs_autoEquipRace"); //$NON-NLS-1$
	private static final String IN_AUTO_EQUIP_MASTERWORK =
			LanguageBundle.getString("in_Prefs_autoEquipMasterwork"); //$NON-NLS-1$
	private static final String IN_AUTO_EQUIP_MAGIC =
			LanguageBundle.getString("in_Prefs_autoEquipMagic"); //$NON-NLS-1$
	private static final String IN_AUTO_EQUIP_EXOTIC =
			LanguageBundle.getString("in_Prefs_autoEquipExotic"); //$NON-NLS-1$
	private static final String IN_NO_AUTO_EQUIP =
			LanguageBundle.getString("in_Prefs_noAutoEquip"); //$NON-NLS-1$
	private static final String IN_POTION_MAX =
			LanguageBundle.getString("in_Prefs_potionMax"); //$NON-NLS-1$
	private static final String IN_WAND_MAX =
			LanguageBundle.getString("in_Prefs_wandMax"); //$NON-NLS-1$

	private final JCheckBox allowMetamagicInEqBuilder = new JCheckBox();
	private final JCheckBox autoMethod1 = new JCheckBox();
	private final JCheckBox autoMethod2 = new JCheckBox();
	private final JCheckBox autoMethod3 = new JCheckBox();
	private final JCheckBox autoMethod4 = new JCheckBox();
	private final JSpinner potionMaxLevel = new JSpinner();
	private final SpinnerNumberModel potionModel;
	private final JSpinner wandMaxLevel = new JSpinner();
	private final SpinnerNumberModel wandModel;
	private final JRadioButton autoEquipCreate;
	private final JRadioButton noAutoEquipCreate;

	/**
	 * Instantiates a new equipment panel.
	 */
	public EquipmentPanel()
	{
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		JLabel label;
		ButtonGroup exclusiveGroup;
		Border etched = null;
		TitledBorder title1 = BorderFactory.createTitledBorder(etched, IN_EQUIPMENT);

		title1.setTitleJustification(TitledBorder.LEFT);
		this.setBorder(title1);
		this.setLayout(gridbag);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.LINE_START;
		c.insets = new Insets(2, 2, 2, 2);
		exclusiveGroup = new ButtonGroup();

		Utility.buildConstraints(c, 0, 0, GridBagConstraints.REMAINDER, 1, 0, 0);
		allowMetamagicInEqBuilder.setText(IN_ALLOW_METAMAGIC);
		gridbag.setConstraints(allowMetamagicInEqBuilder, c);
		this.add(allowMetamagicInEqBuilder);

		Utility.buildConstraints(c, 0, 1, 2, 1, 0, 0);
		label = new JLabel(IN_POTION_MAX);
		gridbag.setConstraints(label, c);
		this.add(label);
		Utility.buildConstraints(c, 3, 1, 1, 1, 0, 0);

		potionModel = new SpinnerNumberModel(SPELLLVLMIN, SPELLLVLMIN, SPELLLVLMAX, 1);

		potionMaxLevel.setModel(potionModel);

		gridbag.setConstraints(potionMaxLevel, c);
		this.add(potionMaxLevel);

		Utility.buildConstraints(c, 0, 2, 2, 1, 0, 0);
		label = new JLabel(IN_WAND_MAX);
		gridbag.setConstraints(label, c);
		this.add(label);
		Utility.buildConstraints(c, 3, 2, 1, 1, 0, 0);

		wandModel = new SpinnerNumberModel(SPELLLVLMIN, SPELLLVLMIN, SPELLLVLMAX, 1);
		wandMaxLevel.setModel(wandModel);
		gridbag.setConstraints(wandMaxLevel, c);
		this.add(wandMaxLevel);

		Utility.buildConstraints(c, 0, 3, GridBagConstraints.REMAINDER, 1, 0, 0);
		label = new JLabel(IN_ANY_AUTO_EQUIP);
		gridbag.setConstraints(label, c);
		this.add(label);

		Utility.buildConstraints(c, 1, 4, GridBagConstraints.REMAINDER, 1, 0, 0);
		noAutoEquipCreate = new JRadioButton(IN_NO_AUTO_EQUIP);
		gridbag.setConstraints(noAutoEquipCreate, c);
		this.add(noAutoEquipCreate);
		exclusiveGroup.add(noAutoEquipCreate);

		Utility.buildConstraints(c, 1, 5, GridBagConstraints.REMAINDER, 1, 0, 0);
		autoEquipCreate = new JRadioButton(IN_AUTO_EQUIP);
		gridbag.setConstraints(autoEquipCreate, c);
		this.add(autoEquipCreate);
		exclusiveGroup.add(autoEquipCreate);

		Utility.buildConstraints(c, 0, 6, 1, 1, 0, 0);
		label = new JLabel(BLANK_TEXT);
		gridbag.setConstraints(label, c);
		this.add(label);

		Utility.buildConstraints(c, 1, 6, GridBagConstraints.REMAINDER, 1, 0, 0);
		autoMethod1.setText(IN_AUTO_EQUIP_RACE);
		gridbag.setConstraints(autoMethod1, c);
		this.add(autoMethod1);

		Utility.buildConstraints(c, 1, 7, GridBagConstraints.REMAINDER, 1, 0, 0);
		autoMethod2.setText(IN_AUTO_EQUIP_MASTERWORK);
		gridbag.setConstraints(autoMethod2, c);
		this.add(autoMethod2);

		Utility.buildConstraints(c, 1, 8, GridBagConstraints.REMAINDER, 1, 0, 0);
		autoMethod3.setText(IN_AUTO_EQUIP_MAGIC);
		gridbag.setConstraints(autoMethod3, c);
		this.add(autoMethod3);

		Utility.buildConstraints(c, 1, 9, GridBagConstraints.REMAINDER, 1, 0, 0);
		autoMethod4.setText(IN_AUTO_EQUIP_EXOTIC);
		gridbag.setConstraints(autoMethod4, c);
		this.add(autoMethod4);

		Utility.buildConstraints(c, 0, 20, 10, 1, 1, 1);
		c.fill = GridBagConstraints.BOTH;
		label = new JLabel();
		gridbag.setConstraints(label, c);
		this.add(label);
	}

	@Override
	public String getTitle()
	{
		return IN_EQUIPMENT;
	}

	@Override
	public void setOptionsBasedOnControls()
	{
		SettingsHandler.setMetamagicAllowedInEqBuilder(allowMetamagicInEqBuilder.isSelected());
		SettingsHandler.setMaxPotionSpellLevel(potionModel.getNumber().intValue());
		SettingsHandler.setMaxWandSpellLevel(wandModel.getNumber().intValue());
		SettingsHandler.setWantToLoadMasterworkAndMagic(false); // Turn it off temporarily so we can set the values
		SettingsHandler.setAutogen(Constants.AUTOGEN_RACIAL, autoMethod1.isSelected());
		SettingsHandler.setAutogen(Constants.AUTOGEN_MASTERWORK, autoMethod2.isSelected());
		SettingsHandler.setAutogen(Constants.AUTOGEN_MAGIC, autoMethod3.isSelected());
		SettingsHandler.setAutogen(Constants.AUTOGEN_EXOTIC_MATERIAL, autoMethod4.isSelected());

		SettingsHandler.setWantToLoadMasterworkAndMagic(noAutoEquipCreate.isSelected()); // Now set it properly
		PCGenSettings.OPTIONS_CONTEXT.setBoolean(PCGenSettings.OPTION_AUTOCREATE_MW_MAGIC_EQUIP,
			autoEquipCreate.isSelected());
	}

	@Override
	public void applyOptionValuesToControls()
	{
		allowMetamagicInEqBuilder.setSelected(SettingsHandler.isMetamagicAllowedInEqBuilder());
		potionModel.setValue(SettingsHandler.getMaxPotionSpellLevel());
		wandModel.setValue(SettingsHandler.getMaxWandSpellLevel());

		if (PCGenSettings.OPTIONS_CONTEXT.initBoolean(PCGenSettings.OPTION_AUTOCREATE_MW_MAGIC_EQUIP, false))
		{
			autoEquipCreate.setSelected(true);
		}
		else
		{
			noAutoEquipCreate.setSelected(true);
		}
		// Turn off temporarily so we get current setting
		SettingsHandler.setWantToLoadMasterworkAndMagic(false); 
		autoMethod1.setSelected(SettingsHandler.getAutogen(Constants.AUTOGEN_RACIAL));
		autoMethod2.setSelected(SettingsHandler.getAutogen(Constants.AUTOGEN_MASTERWORK));
		autoMethod3.setSelected(SettingsHandler.getAutogen(Constants.AUTOGEN_MAGIC));
		autoMethod4.setSelected(SettingsHandler.getAutogen(Constants.AUTOGEN_EXOTIC_MATERIAL));
		// Reset its state now we are done
		SettingsHandler.setWantToLoadMasterworkAndMagic(noAutoEquipCreate.isSelected());
	}

}
