var PRGPortal = new Class({

	Implements: [Options, Events],
	
	windowHeight: 0,
	options: {
		columnCssName: '.prg-static-column',
		contextMenuLinksCssName: '.prg-ctx-menu-link'
	},
	
	initialize: function(options) {
		this.setOptions(options);
		this.setColumnHeights();
		window.addEvent('resize', this.setColumnHeights.bind(this));
	},
	
	setColumnHeights: function() {

		var windowDimensions = window.getSize();

		if(this.windowHeight != windowDimensions.y) {

			this.windowHeight = windowDimensions.y;

			$$(this.options.columnCssName).each(function(el) {
				var elementCoordinates = el.getPosition();
				el.setStyle('height', this.windowHeight - elementCoordinates.y - parseInt(el.getStyle('paddingTop')));
				el.setStyle('maxHeight', this.windowHeight - elementCoordinates.y - parseInt(el.getStyle('paddingTop')));
				el.setStyle('overflowY', 'auto');
			}.bind(this));
		
		}		
	
	},
	
});

var PRGPortalUtilities = {

	setColumnHeight: function(element) {
		var el = $(element).getParents('.prg-static-column')[0];
		if(el) {
			var windowHeight = window.getSize().y;
			var elementCoordinates = el.getPosition();
			el.setStyle('height', this.windowHeight - elementCoordinates.y - parseInt(el.getStyle('paddingTop')));
			el.setStyle('maxHeight', this.windowHeight - elementCoordinates.y - parseInt(el.getStyle('paddingTop')));
			el.setStyle('overflowY', 'auto');
		}
	},
	
	setColumnHeights: function() {

		var windowHeight = window.getSize().y;

		$$('.prg-static-column').each(function(el) {
			var elementCoordinates = el.getPosition();
			var columnHeight = windowHeight - elementCoordinates.y - parseInt(el.getStyle('paddingTop'));
			el.setStyle('height', columnHeight);
			el.setStyle('maxHeight', columnHeight);
			el.setStyle('overflowY', 'auto');
		}.bind(this));
	
	},
	
}

function checkAll(frm, checkedOn) {

	// have we been passed an ID
	if (typeof frm == "string") {
		frm = document.forms[frm];
	}
	
	// Get all of the inputs that are in this form
	var inputs = frm.getElementsByTagName("input");

	// for each input in the form, check if it is a checkbox
	for (var i = 0; i < inputs.length; i++) {
		if (inputs[i].type == "checkbox") {
			inputs[i].checked = checkedOn;
		}
	}
	
}

/* 
Native FullScreen JavaScript API
-------------
Assumes Mozilla naming conventions instead of W3C for now
*/

(function() {
	var 
		fullScreenApi = { 
			supportsFullScreen: false,
			isFullScreen: function() { return false; }, 
			requestFullScreen: function() {}, 
			cancelFullScreen: function() {},
			fullScreenEventName: '',
			prefix: ''
		},
		browserPrefixes = 'webkit moz o ms khtml'.split(' ');
	
	// check for native support
	if (typeof document.cancelFullScreen != 'undefined') {
		fullScreenApi.supportsFullScreen = true;
	} else {	 
		// check for fullscreen support by vendor prefix
		for (var i = 0, il = browserPrefixes.length; i < il; i++ ) {
			fullScreenApi.prefix = browserPrefixes[i];
			
			if (typeof document[fullScreenApi.prefix + 'CancelFullScreen' ] != 'undefined' ) {
				fullScreenApi.supportsFullScreen = true;
				
				break;
			}
		}
	}
	
	// update methods to do something useful
	if (fullScreenApi.supportsFullScreen) {
		fullScreenApi.fullScreenEventName = fullScreenApi.prefix + 'fullscreenchange';
		
		fullScreenApi.isFullScreen = function() {
			switch (this.prefix) {	
				case '':
					return document.fullScreen;
				case 'webkit':
					return document.webkitIsFullScreen;
				default:
					return document[this.prefix + 'FullScreen'];
			}
		}
		fullScreenApi.requestFullScreen = function(el) {
			return (this.prefix === '') ? el.requestFullScreen() : el[this.prefix + 'RequestFullScreen']();
		}
		fullScreenApi.cancelFullScreen = function(el) {
			return (this.prefix === '') ? document.cancelFullScreen() : document[this.prefix + 'CancelFullScreen']();
		}		
	}

	// jQuery plugin
	if (typeof jQuery != 'undefined') {
		jQuery.fn.requestFullScreen = function() {
	
			return this.each(function() {
				var el = jQuery(this);
				if (fullScreenApi.supportsFullScreen) {
					fullScreenApi.requestFullScreen(el);
				}
			});
		};
	}

	// export api
	window.fullScreenApi = fullScreenApi;	
})();

// do something interesting with fullscreen support

window.addEvent('domready', function(){
	var fsButton = $('fsButton'),
		fsElement = $('BodyPageWrapper');
	
	console.log(fsButton);
	
	if (window.fullScreenApi.supportsFullScreen && fsButton) {
		
		// handle button click
		fsButton.addEvent('click', function() {
			window.fullScreenApi.requestFullScreen(fsElement);
		});
		
	}

});
