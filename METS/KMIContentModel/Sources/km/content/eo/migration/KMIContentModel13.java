package km.content.eo.migration;

import km.content.eo.KMIWebDocument;

import com.webobjects.eoaccess.EOModel;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationTable;
import er.extensions.migration.ERXModelVersion;
import er.extensions.migration.IERXPostMigration;

public class KMIContentModel13 extends ERXMigrationDatabase.Migration implements IERXPostMigration {

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
		ERXMigrationTable kmiWebDocumentTable = database.existingTableNamed("Document");
		kmiWebDocumentTable.newStringColumn("author", 50, true);
	}

	public void postUpgrade(EOEditingContext editingContext, EOModel model) throws Throwable {
		for(KMIWebDocument document : KMIWebDocument.fetchAllKMIWebDocuments(editingContext)) {
			document.setAuthor("jlmiller");
			editingContext.saveChanges();
		}
	}

}