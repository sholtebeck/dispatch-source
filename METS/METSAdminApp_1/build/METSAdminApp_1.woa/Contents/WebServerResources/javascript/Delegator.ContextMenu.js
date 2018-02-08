/*
---
description: Provides methods to display context menu
provides: [Delegator.contextMenu]
requires: [Behavior/Delegator, Core/Element, More/Measure, More/Mask]
script: Delegator.ContextMenu.js
name: Delegator.ContextMenu

...
*/

(function(){
	
	Delegator.register('click', 'contextMenu', {

		defaults: {
			display: 'below',
			left: '0px',
			top: '0px'
		},
		
		handler: function(event, link, api) {

			event.preventDefault();

			var contextMenu = link.getNext('ul');
			
			var size = contextMenu.measure(function(){
			    return this.getSize();
			});

			var coords = link.getPosition();
			var display = api.get('display');
			
			if(contextMenu.getStyle('display') == 'none') {
				
				document.body.get('mask').addEvent('click', function() {
					contextMenu.setStyle('display', 'none');
					link.getParent().grab(contextMenu);	
					document.body.unmask();
				});

				document.body.mask();
				document.body.grab(contextMenu);
				contextMenu.setStyle('display', 'block');
				var offsetTop = api.get('top').toInt();
				var top = display == "below" ? coords.y + link.getSize().y + offsetTop : coords.y - contextMenu.getSize().y + offsetTop;
				var left = link.getPosition().x + api.get('left').toInt();

				contextMenu.setStyles({
					left: left,
					top: top
				});

			}

		}

	});
		
})();