/**
 * Created with JetBrains WebStorm.
 * User: johnnymiller
 * Date: 4/4/13
 * Time: 10:11 AM
 * To change this template use File | Settings | File Templates.
 */
/*
 ---
 description: Used by a The Home Page's Inbound Marketing Graphic.
 provides: [Delegator.contextMenu]
 requires: [Behavior/Delegator, Core/Element, More/Measure, More/Mask]
 script: Delegator.ContextMenu.js
 name: Delegator.FirstLetterSelector

 ...
 */

var periodicalInboundMarketingUpdaterTimer;

(function() {

    Delegator.register('click', 'inboundMarketing', {

        defaults: {
            'textSection': 'ServiceText',
            'activeClassName' : 'active'
        },

        handler: function(event, link, api) {
            event.preventDefault();
            if(! link.hasClass('active')) {
                clearInterval(periodicalInboundMarketingUpdaterTimer);
                updateInboundMarketing(link);
            }
        }

    });

})();

var updateInboundMarketing = function(link) {
    var textSection = $('ServiceText');
    var activeClassName = 'active';
    var className = link.get('class');

    var myFx = new Fx.Tween(textSection, {
        property: 'opacity'
    }).start(1.0, 0.1).chain(function(){
        textSection.set('class', className);
        link.getParent().getFirst('a.active').removeClass(activeClassName);
        link.addClass(activeClassName);
        var position = link.getAllPrevious().length;
        textSection.getFirst('section.active').removeClass(activeClassName);
        textSection.getChildren()[position].set('class', activeClassName);
        this.start(0.1, 1.0);
    });

}

var periodicalInboundMarketingUpdater = function() {

    var currentPosition = -1;

    for(var i = 0; i < this.links.length; i++) {
        if(this.links[i].hasClass('active')) {
            currentPosition = i;
            break;
        }
    }

    currentPosition = currentPosition + 1;
    if(currentPosition === this.links.length) {
        currentPosition = 0;
    }

    updateInboundMarketing(this.links[currentPosition]);

}

window.addEvent('domready', function() {
    var links = {
        links: $$('a[data-trigger=inboundMarketing]')
    };
    periodicalInboundMarketingUpdaterTimer = periodicalInboundMarketingUpdater.periodical(10000, links);
});
