package km.content.eo.migration;

import km.content.eo.KMIHTMLNode;

import com.webobjects.eoaccess.EOModel;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;

import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationTable;
import er.extensions.migration.ERXModelVersion;
import er.extensions.migration.IERXPostMigration;

public class KMIContentModel7 extends ERXMigrationDatabase.Migration implements IERXPostMigration {

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

		ERXMigrationTable nodeAttributeTable = database.existingTableNamed("NodeAttribute");
		nodeAttributeTable.drop();
		
		ERXMigrationTable kmihtmlNodeTable = database.existingTableNamed("Node");
		kmihtmlNodeTable.newStringColumn("attributes", true);
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void postUpgrade(EOEditingContext editingContext, EOModel model) throws Throwable {
	
		NSArray<KMIHTMLNode> nodes = KMIHTMLNode.fetchAllKMIHTMLNodes(editingContext);
		
		NSDictionary defaultDictionary = new NSDictionary(new NSArray<String>(new String[] {"", "", ""}), 
				new NSArray<String>(new String[] { "id", "class", "style" }));

		for(KMIHTMLNode node : nodes) {
			node.setAttributes(defaultDictionary);
			editingContext.saveChanges();
		}
		
	}
	
	

}