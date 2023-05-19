/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package org.compiere.models;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for RED_asset_assignment
 *  @author iDempiere (generated) 
 *  @version Release 10 - $Id$ */
@org.adempiere.base.Model(table="RED_asset_assignment")
public class X_RED_asset_assignment extends PO implements I_RED_asset_assignment, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20230519L;

    /** Standard Constructor */
    public X_RED_asset_assignment (Properties ctx, int RED_asset_assignment_ID, String trxName)
    {
      super (ctx, RED_asset_assignment_ID, trxName);
      /** if (RED_asset_assignment_ID == 0)
        {
			setName (null);
			setred_asset_assignment_ID (0);
        } */
    }

    /** Standard Constructor */
    public X_RED_asset_assignment (Properties ctx, int RED_asset_assignment_ID, String trxName, String ... virtualColumns)
    {
      super (ctx, RED_asset_assignment_ID, trxName, virtualColumns);
      /** if (RED_asset_assignment_ID == 0)
        {
			setName (null);
			setred_asset_assignment_ID (0);
        } */
    }

    /** Load Constructor */
    public X_RED_asset_assignment (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuilder sb = new StringBuilder ("X_RED_asset_assignment[")
        .append(get_ID()).append(",Name=").append(getName()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_A_Asset getA_Asset() throws RuntimeException
	{
		return (org.compiere.model.I_A_Asset)MTable.get(getCtx(), org.compiere.model.I_A_Asset.Table_ID)
			.getPO(getA_Asset_ID(), get_TrxName());
	}

	/** Set Asset.
		@param A_Asset_ID Asset used internally or by customers
	*/
	public void setA_Asset_ID (int A_Asset_ID)
	{
		if (A_Asset_ID < 1)
			set_ValueNoCheck (COLUMNNAME_A_Asset_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_A_Asset_ID, Integer.valueOf(A_Asset_ID));
	}

	/** Get Asset.
		@return Asset used internally or by customers
	  */
	public int getA_Asset_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_A_Asset_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_AD_User getAD_User() throws RuntimeException
	{
		return (org.compiere.model.I_AD_User)MTable.get(getCtx(), org.compiere.model.I_AD_User.Table_ID)
			.getPO(getAD_User_ID(), get_TrxName());
	}

	/** Set User/Contact.
		@param AD_User_ID User within the system - Internal or Business Partner Contact
	*/
	public void setAD_User_ID (int AD_User_ID)
	{
		if (AD_User_ID < 1)
			set_ValueNoCheck (COLUMNNAME_AD_User_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_AD_User_ID, Integer.valueOf(AD_User_ID));
	}

	/** Get User/Contact.
		@return User within the system - Internal or Business Partner Contact
	  */
	public int getAD_User_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_User_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Assignment_Date.
		@param Assignment_Date Assignment_Date
	*/
	public void setAssignment_Date (Timestamp Assignment_Date)
	{
		set_ValueNoCheck (COLUMNNAME_Assignment_Date, Assignment_Date);
	}

	/** Get Assignment_Date.
		@return Assignment_Date	  */
	public Timestamp getAssignment_Date()
	{
		return (Timestamp)get_Value(COLUMNNAME_Assignment_Date);
	}

	public org.compiere.model.I_C_Activity getC_Activity() throws RuntimeException
	{
		return (org.compiere.model.I_C_Activity)MTable.get(getCtx(), org.compiere.model.I_C_Activity.Table_ID)
			.getPO(getC_Activity_ID(), get_TrxName());
	}

	/** Set Activity.
		@param C_Activity_ID Business Activity
	*/
	public void setC_Activity_ID (int C_Activity_ID)
	{
		if (C_Activity_ID < 1)
			set_Value (COLUMNNAME_C_Activity_ID, null);
		else
			set_Value (COLUMNNAME_C_Activity_ID, Integer.valueOf(C_Activity_ID));
	}

	/** Get Activity.
		@return Business Activity
	  */
	public int getC_Activity_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Activity_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_C_Location getC_Location() throws RuntimeException
	{
		return (I_C_Location)MTable.get(getCtx(), I_C_Location.Table_ID)
			.getPO(getC_Location_ID(), get_TrxName());
	}

	/** Set Address.
		@param C_Location_ID Location or Address
	*/
	public void setC_Location_ID (int C_Location_ID)
	{
		if (C_Location_ID < 1)
			set_Value (COLUMNNAME_C_Location_ID, null);
		else
			set_Value (COLUMNNAME_C_Location_ID, Integer.valueOf(C_Location_ID));
	}

	/** Get Address.
		@return Location or Address
	  */
	public int getC_Location_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Location_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Description.
		@param Description Optional short description of the record
	*/
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription()
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set Comment/Help.
		@param Help Comment or Hint
	*/
	public void setHelp (String Help)
	{
		set_Value (COLUMNNAME_Help, Help);
	}

	/** Get Comment/Help.
		@return Comment or Hint
	  */
	public String getHelp()
	{
		return (String)get_Value(COLUMNNAME_Help);
	}

	/** Set Name.
		@param Name Alphanumeric identifier of the entity
	*/
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName()
	{
		return (String)get_Value(COLUMNNAME_Name);
	}

	/** Set red_asset_assignment.
		@param red_asset_assignment_ID red_asset_assignment
	*/
	public void setred_asset_assignment_ID (int red_asset_assignment_ID)
	{
		if (red_asset_assignment_ID < 1)
			set_ValueNoCheck (COLUMNNAME_red_asset_assignment_ID, null);
		else
			set_ValueNoCheck (COLUMNNAME_red_asset_assignment_ID, Integer.valueOf(red_asset_assignment_ID));
	}

	/** Get red_asset_assignment.
		@return red_asset_assignment	  */
	public int getred_asset_assignment_ID()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_red_asset_assignment_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set red_asset_assignment_UU.
		@param red_asset_assignment_UU red_asset_assignment_UU
	*/
	public void setred_asset_assignment_UU (String red_asset_assignment_UU)
	{
		set_Value (COLUMNNAME_red_asset_assignment_UU, red_asset_assignment_UU);
	}

	/** Get red_asset_assignment_UU.
		@return red_asset_assignment_UU	  */
	public String getred_asset_assignment_UU()
	{
		return (String)get_Value(COLUMNNAME_red_asset_assignment_UU);
	}

	/** Set Search Key.
		@param Value Search key for the record in the format required - must be unique
	*/
	public void setValue (String Value)
	{
		set_Value (COLUMNNAME_Value, Value);
	}

	/** Get Search Key.
		@return Search key for the record in the format required - must be unique
	  */
	public String getValue()
	{
		return (String)get_Value(COLUMNNAME_Value);
	}
}