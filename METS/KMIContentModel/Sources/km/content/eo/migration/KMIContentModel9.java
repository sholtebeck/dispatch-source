package km.content.eo.migration;

import km.content.eo.KMIHTMLNode;
import km.content.eo.KMIWebDocument;

import com.webobjects.eoaccess.EOModel;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXModelVersion;
import er.extensions.migration.IERXPostMigration;

public class KMIContentModel9 extends ERXMigrationDatabase.Migration implements IERXPostMigration {

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

	@SuppressWarnings("unchecked")
	public void postUpgrade(EOEditingContext editingContext, EOModel model) throws Throwable {

		NSArray<KMIWebDocument> documents = KMIWebDocument.fetchAllKMIWebDocuments(editingContext);
		for(KMIWebDocument document : documents) {
			NSArray<KMIHTMLNode> nodes =  KMIHTMLNode.fetchKMIHTMLNodes(editingContext, 
					KMIHTMLNode.DOCUMENT.eq(document), KMIHTMLNode.CREATE_DATE.ascs());
			for(KMIHTMLNode node : nodes) {
				node.setPosition(nodes.indexOf(node));
				editingContext.saveChanges();
			}
			
		}
		
	}
	
	

}