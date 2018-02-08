/*
---
name: Behavior.ResizeColumn
description: Resizes two perpendicular columns
requires: [Behavior/Behavior, Behavior/Element.Data, More/Object.Extras]
script: Behavior.ResizeColumn.js
...
*/


Behavior.addGlobalFilter('ResizeColumn', {

  setup : function(element, api) {

    var options = {
	    otherColumn : ''
    };
    
	var otherColumn = $(api.get('otherColumn'));    
    var pad = element.getStyle('width').toInt();
    var w_total = -1; 
    var w_min = 150;
    
    var storedElementWidth = Cookie.read(element.get('id'));
    var storedOtherColumnWidth = Cookie.read(otherColumn.get('id'));

    if(storedElementWidth) {
	    element.setStyle('minWidth', storedElementWidth + 'px');
	    element.setStyle('width', storedElementWidth + 'px');
    }

    if(storedOtherColumnWidth) {
//	    otherColumn.setStyle('minWidth', storedOtherColumnWidth + 'px');
	    otherColumn.setStyle('width', storedOtherColumnWidth + 'px');
    }

    var draggable = element.makeResizable({
	   
	    handle: element.getElements('.prg-handle')[0],
	    modifiers: {x: 'width', y: false},
	    limit: {x: [w_min,null]},

	    snap: 0,

	    onStart : function(el) {
		    //    get available width - total width minus right column - minimum col width
		    w_total = otherColumn.getSize().x + element.getSize().x;
		    
	    },

	    onDrag: function(el) {

		    if(el.getSize().x >= (w_total - w_min)){
			    //    max width reached - stop drag (force max widths)
			    el.setStyle("width", w_total);
			    return false;
		    }
		    
		    var w_center = w_total - el.getSize().x;

		    otherColumn.setStyles({
		    	'width': w_center
		    });


	    },
	    
	    onComplete: function(el) {
		    el.setStyle('minWidth', w_min);
		    otherColumn.setStyle('minWidth', w_min);
	    	Cookie.write(el.get('id'), el.getSize().x);
	    	Cookie.write(otherColumn.get('id'), otherColumn.getSize().x);
	    }	    
    });

  }


});