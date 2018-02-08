package km.content.eo.migration;

import km.content.eo.KMIWebDocument;
import km.content.eo.KMIWebDocumentCategory;

import com.webobjects.eoaccess.EOModel;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationTable;
import er.extensions.migration.ERXModelVersion;
import er.extensions.migration.IERXPostMigration;

public class KMIContentModel10 extends ERXMigrationDatabase.Migration implements IERXPostMigration {

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
		kmiWebDocumentTable.newBooleanColumn("is_published", true);
	}

	@SuppressWarnings("unchecked")
	public void postUpgrade(EOEditingContext editingContext, EOModel model) throws Throwable {

		NSArray<KMIWebDocument> documents = KMIWebDocument.fetchAllKMIWebDocuments(editingContext);

		for(KMIWebDocument document : documents) {

			if(document.category() == null) {

				KMIWebDocumentCategory category = null;
				
				if(document.site().categories() != null && document.site().categories().size() > 0) {
					category = document.site().categories().get(0);
				} else {
					category = KMIWebDocumentCategory.createKMIWebDocumentCategory(editingContext, document.site());					
					category.setName("Default");
				}
				
				document.setCategoryRelationship(category);

			}

			document.setCommentsEnabled(false);
			document.setIsPublished(false);
			editingContext.saveChanges();

		}
		
	}
	
	

}