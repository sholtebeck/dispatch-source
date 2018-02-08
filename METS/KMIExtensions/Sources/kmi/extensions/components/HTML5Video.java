package kmi.extensions.components;

import com.webobjects.appserver.WOContext;

import er.extensions.components.ERXStatelessComponent;

/*
 * author Johnny Miller
 * 
 * @binding autoplay Specifies whether or not to start playing the video as soon as it can do so without stopping.
 * @binding crossorigin This attribute is a CORS settings attribute. CORS stands for Cross-Origin Resource Sharing. The purpose of the crossorigin attribute is to allow you to configure the CORS requests for the element's fetched data. The values for the crossorigin attribute are enumerated.
 * @binding filename if you plan on using the src attribute and you want the resource manager to find the file
 * @binding framework the framework that will be used the resource manager to find the file specified by filename defaults to app
 * @binding height
 * @binding loop Specifies whether to keep re-playing the video once it has finished.  This attribute is a boolean attribute. Therefore, the mere presence of this attribute equates to a true value. You can also specify a value that is a case-insensitive match for the attribute's canonical name, with no leading or trailing whitespace (i.e. either loop or loop="loop").
 * @binding mediagroup For synchronizing playback of videos (or media elements). Allows you to specify media elements to link together. The value is a string of text, for example: mediagroup=movie. Videos/media elements with the same value are automatically linked by the user agent/browser.
 * @binding muted Controls the default state of the video's audio output. If present, this attribute results in the audio output being muted (i.e. there is no sound) upon loading. This attribute will override the users' preferences. The user can then choose to turn on the sound if he/she so wishes. This helps users from being annoyed by loud sounds coming from the video as soon as the page/video starts loading. Users often close their browser when this happens. The 'mute' attribute aims to overcome this issue by having the video start off silently instead of loudly.
 * @binding posterFilename
 * @binding posterFramework
 * @binding posterSrc
 * @binding preload Specifies whether the video should be preloaded or not, and if so, how it should be preloaded. This attribute allows the author to provide a hint to the browser/user agent about what the author thinks will lead to the best user experience. This attribute may be ignored in some instances. For example, if the user has disabled preloading or if there are network connectivity issues.
 * @binding src a url i.e. http://cdn.mywebsite.com/movie.mp4
 * @binding width
 * 
 */

public class HTML5Video extends ERXStatelessComponent {

	public HTML5Video(WOContext context) {
        super(context);
    }
	
	public boolean controls() {
		return booleanValueForBinding("controls", true);
	}

	public String poster() {

		String poster = null;
		
		if(hasBinding("posterSrc")) {
			poster = stringValueForBinding("posterSrc");
		} else if(hasBinding("posterFileName")) {
			String posterFileName = stringValueForBinding("posterFileName");
			String posterFramework = stringValueForBinding("posterFramework", "app");
			poster = application().resourceManager().urlForResourceNamed(posterFileName, posterFramework, null, context().request());
		}
		
		return poster;

	}

	public String src() {
		String src = null;
		if(hasBinding("src")) {
			src = stringValueForBinding("src");
		} else if(hasBinding("fileName")) {
			String fileName = stringValueForBinding("fileName");
			String framework = stringValueForBinding("framework", "app");
			src = application().resourceManager().urlForResourceNamed(fileName, framework, null, context().request());
		}
		return src;
	}

}