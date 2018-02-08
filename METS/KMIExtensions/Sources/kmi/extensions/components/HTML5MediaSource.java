package kmi.extensions.components;

import com.webobjects.appserver.WOContext;

import er.extensions.components.ERXStatelessComponent;

public class HTML5MediaSource extends ERXStatelessComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HTML5MediaSource(WOContext context) {
        super(context);
    }

	public String src() {
		
		String src = null;
		
		if(hasBinding("src")) {
			src = stringValueForBinding("src");
		} else if(hasBinding("filename")) {
			String fileName = stringValueForBinding("filename");
			String framework = stringValueForBinding("framework", "app");
			src = application().resourceManager().urlForResourceNamed(fileName, framework, null, context().request());
		}

		return src;

	}

}