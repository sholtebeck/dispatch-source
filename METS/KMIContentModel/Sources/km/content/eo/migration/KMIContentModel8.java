package km.content.eo.migration;

import com.webobjects.eoaccess.EOModel;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationTable;
import er.extensions.migration.ERXModelVersion;
import er.extensions.migration.IERXPostMigration;

public class KMIContentModel8 extends ERXMigrationDatabase.Migration implements IERXPostMigration {

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

		ERXMigrationTable kmihtmlNodeTable = database.existingTableNamed("Node");
		kmihtmlNodeTable.newStringColumn("identifier", 50, true);

		ERXMigrationTable kmiWebSiteTestimonialTable = database.newTableNamed("Testimonial");
		kmiWebSiteTestimonialTable.newStringColumn("attester", 100, true);
		kmiWebSiteTestimonialTable.newTimestampColumn("create_date", true);
		kmiWebSiteTestimonialTable.newIntegerColumn("id", false);
		kmiWebSiteTestimonialTable.newStringColumn("testimonial", 1000, true);
		kmiWebSiteTestimonialTable.newTimestampColumn("testimonial_date", true);
		kmiWebSiteTestimonialTable.newIntegerColumn("web_site_id", false);
		kmiWebSiteTestimonialTable.create();
	 	kmiWebSiteTestimonialTable.setPrimaryKey("id");

		kmiWebSiteTestimonialTable.addForeignKey("web_site_id", "WebSite", "id");		
		
	}

	public void postUpgrade(EOEditingContext editingContext, EOModel model) throws Throwable {
			
	}
	
	

}