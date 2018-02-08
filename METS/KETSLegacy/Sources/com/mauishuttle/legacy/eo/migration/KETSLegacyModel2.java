package com.mauishuttle.legacy.eo.migration;
import com.mauishuttle.eo.MESHub;
import com.mauishuttle.eo.MESRole;
import com.mauishuttle.eo.MESUser;
import com.mauishuttle.legacy.eo.User;
import com.webobjects.eoaccess.EOModel;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSValidation;

import er.extensions.foundation.ERXStringUtilities;
import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXModelVersion;
import er.extensions.migration.IERXPostMigration;

public class KETSLegacyModel2 extends ERXMigrationDatabase.Migration implements IERXPostMigration {

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

		MESHub hub = MESHub.fetchRequiredMESHub(editingContext, MESHub.NAME.eq("Maui"));
		MESRole superUser = MESRole.fetchRequiredMESRole(editingContext, MESRole.CODE_NAME.eq("817847133"));

		NSArray<User> legacyUsers = User.fetchUsers(editingContext, null, null);
		for(User user : legacyUsers) {

			try {
				
				String firstName = ERXStringUtilities.stringIsNullOrEmpty(user.fname()) ? "Unknown" : user.fname();
				String lastName = ERXStringUtilities.stringIsNullOrEmpty(user.lname()) ? "Unknown" : user.lname();
				
				MESUser newUser = MESUser.createMESUser(editingContext);
				newUser.setFirstName(firstName);
				newUser.setLastName(lastName);
				newUser.setLastLogin(user.lastlog());
				newUser.setActive(true);
				newUser.setUserName(user.loginid());
				newUser.validateAndSetPassword(user.password(), user.password());
				newUser.addToRolesRelationship(hub.role());
				if(ERXStringUtilities.stringIsNullOrEmpty(user.level()) == false && 
						user.level().equalsIgnoreCase("administrator")) {
					newUser.addToRolesRelationship(superUser);
				}
				editingContext.saveChanges();
				
				
			} catch (NSValidation.ValidationException e) {
				e.printStackTrace();
			}

		}
		
	}



}