package km.content.eo.components;

import java.io.IOException;

import km.content.eo.KMIImageAsset;
import kmi.foundation.extensions.KMIStringUtilities;

import org.apache.log4j.Logger;

import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSValidation;

import er.attachment.model.ERAttachment;
import er.extensions.components.ERXStatelessComponent;
import er.extensions.eof.ERXEC;

@SuppressWarnings("serial")
public class KMIImageAssetView extends ERXStatelessComponent {

	Logger log = Logger.getLogger(KMIImageAssetView.class);
	
	public KMIImageAssetView(WOContext context) {
        super(context);
    }

	public String path() {
		return stringValueForBinding("path");
	}
	
	public KMIImageAsset asset() {
	
		KMIImageAsset asset = null;
		
		try {
			asset = KMIImageAsset.imageAssetFromURL(editingContext(), path());
		} catch(Exception e) {
			
		}
		
		return asset;

	}

	public ERAttachment attachment() {

		ERAttachment attachment = null;
		
		try {
		
			if(thumbnailIdentifier() != null && width() > 0 && height() > 0) {
				attachment = asset().thumbnailAttachment(thumbnailIdentifier(), width(), height());
			} else {
				attachment = asset().attachment();
			}

		} catch(IOException e) {
			log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
			log.error("Unable to create thumbnail for attachment with IO exception: " + e.getMessage());
			log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
			e.printStackTrace();
		} catch (NSValidation.ValidationException e) {
			log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
			log.error("Unable to create thumbnail for attachment with validation exception: " + e.getMessage());
			log.error(KMIStringUtilities.ERROR_STRING_DIVIDER);
			e.printStackTrace();
		}
		
		
		return attachment;

	}
	
	public int width() {
		return intValueForBinding("width", -1);
	}
	
	public int height() {
		return intValueForBinding("height", -1);
	}
	
	public EOEditingContext editingContext() {
		return (EOEditingContext) objectValueForBinding("editingContext", ERXEC.newEditingContext());
	}
	
	public String thumbnailIdentifier() {
		return stringValueForBinding("thumbnailIdentifier", null);
	}

	
	
}