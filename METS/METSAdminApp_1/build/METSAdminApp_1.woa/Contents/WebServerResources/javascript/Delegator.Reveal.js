/*
---
description: Provides methods to display context menu
provides: [Delegator.reveal]
requires: [Behavior/Delegator, Core/Element]
script: Delegator.Reveal.js
name: Delegator.Reveal

...
*/

(function(){
	
	Delegator.register('click', 'reveal', {

		defaults: {
			'openClassName' : 'open-leaf',
			'closedClassName' : 'close-leaf'
		},
		
		handler: function(event, link, api) {

			event.preventDefault();
			var parent = link.getParent();
			if(link.hasClass(api.get('openClassName'))) {
				link.removeClass(api.get('openClassName'));
				link.addClass(api.get('closedClassName'));
			} else {
				link.removeClass(api.get('closedClassName'));
				link.addClass(api.get('openClassName'));
			}

		}

	});
		
})();