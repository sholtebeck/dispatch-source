package com.mauishuttle.legacy.eo.migration;
import com.mauishuttle.eo.MESAccount;
import com.mauishuttle.eo.MESHub;
import com.mauishuttle.legacy.eo.Accounts;
import com.webobjects.eoaccess.EOModel;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSValidation;

import er.extensions.foundation.ERXStringUtilities;
import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXModelVersion;
import er.extensions.migration.IERXPostMigration;

public class KETSLegacyModel7 extends ERXMigrationDatabase.Migration implements IERXPostMigration {

	@Override
	public NSArray<ERXModelVersion> modelDependencies() {
		return null;
	}
  
	@Override
	public void downgrade(EOEditingContext editingContext, ERXMigrationDatabase database) throws Throwable {
		// DO NOTHING
	}

	@Override
	public void upgrade(EOEditingContext editingContext, ERXMigrationDatabase database) throws Throwable {
	}

	public void postUpgrade(EOEditingContext editingContext, EOModel model)
			throws Throwable {

		NSArray<Accounts> accounts = Accounts.fetchAccountses(editingContext, null, null);
		MESHub hub = MESHub.fetchRequiredMESHub(editingContext, MESHub.NAME.eq("The Big Island"));
		
		for(Accounts account : accounts) {

			if(ERXStringUtilities.stringIsNullOrEmpty(account.accountname()) == false) {

				try {
					
					MESAccount newAccount = MESAccount.createMESAccount(editingContext, hub);
					newAccount.setActive(account.accountactive().equalsIgnoreCase("Yes"));
					newAccount.setAddressOne(account.accountaddress());
					newAccount.setCity(account.accountcity());
					newAccount.setContactOne(account.accountcontact1());
					newAccount.setContactThree(account.accountcontact3());
					newAccount.setContactTwo(account.accountcontact2());
					newAccount.setFaxNumber(account.accountfaxnumber());
					newAccount.setName(account.accountname());
					newAccount.setPhoneNumber(account.accountphonenumber());
					newAccount.setType(account.accounttype());

					editingContext.saveChanges();
				
				} catch (NSValidation.ValidationException e) {
					e.printStackTrace();
				}
				
			}

		}
		
	}



}