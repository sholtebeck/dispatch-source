package km.content.eo;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;

import com.webobjects.eoaccess.EOObjectNotAvailableException;
import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSValidation;

import er.attachment.model.ERAttachment;
import er.attachment.model.ERFileAttachment;
import er.attachment.processors.ERAttachmentProcessor;
import er.attachment.thumbnail.ERImageProcessor;
import er.extensions.foundation.ERXStringUtilities;
import er.extensions.validation.ERXValidationException;
import er.extensions.validation.ERXValidationFactory;

public class KMIImageAsset extends _KMIImageAsset {

	private static final long serialVersionUID = 8785989988247368579L;
	private static Logger log = Logger.getLogger(KMIImageAsset.class);

	public void willInsert() {
		super.willInsert();
		log.debug("---------------------------------------------");
		log.debug("will insert entity with global id: " + editingContext().globalIDForObject(this));
		log.debug("---------------------------------------------");
	}

	public void willUpdate() {
		super.willUpdate();
		log.debug("---------------------------------------------");
		log.debug("will update entity with global id: " + editingContext().globalIDForObject(this));
		log.debug("---------------------------------------------");
	}

	public void didUpdate() {
		super.didUpdate();
		log.debug("---------------------------------------------");
		log.debug("Did Update");
		log.debug("---------------------------------------------");
	}

	public void didInsert() {
		super.didInsert();
		log.debug("---------------------------------------------");
		log.debug("did insert entity with global id: " + editingContext().globalIDForObject(this));
		log.debug("---------------------------------------------");
	}

	public void mightDelete() {
		super.mightDelete();
		log.debug("---------------------------------------------");
		log.debug("might delete entity with global id: " + editingContext().globalIDForObject(this));
		log.debug("---------------------------------------------");	
	}

	public void willDelete() {
		super.willDelete();
		log.debug("---------------------------------------------");
		log.debug("will delete entity with global id: " + editingContext().globalIDForObject(this));
		log.debug("---------------------------------------------");
	}

	public void didDelete(EOEditingContext ec) {
		super.didDelete(ec);
		log.debug("---------------------------------------------");
		log.debug("did delete entity with global id: " + ec.globalIDForObject(this));
		log.debug("---------------------------------------------");
	}	

	public static KMIImageAsset imageAssetFromURL(EOEditingContext editingContext, String path) throws MalformedURLException, EOObjectNotAvailableException, NumberFormatException {

		KMIImageAsset imageAsset = null;

		URL url = new URL(path);
		
		if(url.getQuery() != null) {

			String[] params = url.getQuery().split("&");  
			if(params.length > 0) {
				for(String param : params) {
					
					String name = param.split("=")[0];
					if(name.equals("id")) {
						imageAsset = (KMIImageAsset) EOUtilities.objectWithPrimaryKeyValue(editingContext, 
								KMIImageAsset.ENTITY_NAME,  Integer.valueOf(param.split("=")[1]));
						break;
					}

				}
			}
			
			
			
		} else {
			imageAsset = KMIImageAsset.fetchRequiredKMIImageAsset(editingContext, KMIImageAsset.ATTACHMENT.dot(ERAttachment.WEB_PATH.eq(url.getPath())));
		}
		
		return imageAsset;
					
	}
	
	public ERFileAttachment thumbnailAttachment(String thumbnailIdentifier, int width, int height) throws IOException, NSValidation.ValidationException {

		ERFileAttachment thumbnailAttachment = null;
		
		try {

			thumbnailAttachment = ERFileAttachment.fetchRequiredERFileAttachment(editingContext(), 
					ERFileAttachment.PARENT_ATTACHMENT.eq(attachment()).and(ERFileAttachment.THUMBNAIL.eq(thumbnailIdentifier)));

		} catch(NoSuchElementException e) {

			File inputFile = new File(attachment().filesystemPath());
			File outputFile = File.createTempFile("erattachment-thumb", inputFile.getName().substring(inputFile.getName().lastIndexOf('.')));
			ERImageProcessor.imageProcessor().thumbnail(width, height, inputFile, outputFile);
			thumbnailAttachment = (ERFileAttachment)ERAttachmentProcessor.processorForType(attachment().storageType()).process(editingContext(), outputFile, null, null, attachment().configurationName(), null);
			thumbnailAttachment.setThumbnail(thumbnailIdentifier);
			attachment().addToChildrenAttachments(thumbnailAttachment);
			editingContext().saveChanges();
			
		}
		
		return thumbnailAttachment;

	}
	
	
	public String validateName(String value) throws ERXValidationException {
		if(ERXStringUtilities.stringIsNullOrEmpty(value)) {
			throw ERXValidationFactory.defaultFactory().createException(this, NAME_KEY, value, ERXValidationException.NullPropertyException);
		}
		return value;
	}
	
}
