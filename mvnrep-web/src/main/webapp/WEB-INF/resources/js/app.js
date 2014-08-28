;(function($,window,document,undefined){
    $.fn.scollTop = function(options){
        var defaults = {
            scrollDuration:2000,
            scrollTop:400
        }

        opt = $.extend({},defaults,options)

        return this.each(function(){

            $(this).click(function(event){
                $("html, body").animate({scrollTop: 0}, opt.scrollDuration);
                event.preventDefault();
            });

            // element must have such attributes
            //data-position="fixed"
            //data-bottom="20px"
            //data-left="20px"
            $(this).css($(this).data());

            $(this).hide();// hide the link default;
            var link = $(this);

            $(window).scroll(function(){
                if ($(window).scrollTop() > opt.scrollTop) {
                    link.fadeIn();
                }else{
                    link.hide();
                };
            });
        })
    }
}(jQuery,window,document));
/*!
 * jQuery Scrollspy Plugin
 * Author: @sxalexander
 * Licensed under the MIT license
 */
;(function ( $, window, document, undefined ) {
    $.fn.extend({
        scrollspy: function ( options ) {

            var defaults = {
                min: 0,
                max: 0,
                mode: 'vertical',
                buffer: 0,
                container: window,
                onEnter: options.onEnter ? options.onEnter : [],
                onLeave: options.onLeave ? options.onLeave : [],
                onTick: options.onTick ? options.onTick : []
            }

            var options = $.extend( {}, defaults, options );

            return this.each(function (i) {

                var element = this;
                var o = options;
                var $container = $(o.container);
                var mode = o.mode;
                var buffer = o.buffer;
                var enters = leaves = 0;
                var inside = false;

                /* add listener to container */
                $container.bind('scroll', function(e){
                    var position = {top: $(this).scrollTop(), left: $(this).scrollLeft()};
                    var xy = (mode == 'vertical') ? position.top + buffer : position.left + buffer;
                    var max = o.max;
                    var min = o.min;

                    /* fix max */
                    if($.isFunction(o.max)){
                        max = o.max();
                    }

                    /* fix max */
                    if($.isFunction(o.min)){
                        min = o.min();
                    }

                    if(max == 0){
                        max = (mode == 'vertical') ? $container.height() : $container.outerWidth() + $(element).outerWidth();
                    }

                    /* if we have reached the minimum bound but are below the max ... */
                    if(xy >= min && xy <= max){
                        /* trigger enter event */
                        if(!inside){
                            inside = true;
                            enters++;

                            /* fire enter event */
                            $(element).trigger('scrollEnter', {position: position})
                            if($.isFunction(o.onEnter)){
                                o.onEnter(element, position);
                            }

                        }

                        /* triger tick event */
                        $(element).trigger('scrollTick', {position: position, inside: inside, enters: enters, leaves: leaves})
                        if($.isFunction(o.onTick)){
                            o.onTick(element, position, inside, enters, leaves);
                        }
                    }else{

                        if(inside){
                            inside = false;
                            leaves++;
                            /* trigger leave event */
                            $(element).trigger('scrollLeave', {position: position, leaves:leaves})

                            if($.isFunction(o.onLeave)){
                                o.onLeave(element, position);
                            }
                        }
                    }
                });

            });
        }

    })


})( jQuery, window );

$.v5mr = {
    maven:function(gav){
        var mvn = "<pre><code>&lt;dependency&gt;<br/>"+
            "&nbsp;&nbsp;&lt;groupId&gt;"+gav[0]+"&lt;/groupId&gt;<br/>"+
        "&nbsp;&nbsp;&lt;artifactId&gt;"+gav[1]+"&lt;/artifactId&gt;<br/>"+
        "&nbsp;&nbsp;&lt;version&gt;"+gav[2]+"&lt;/version&gt;<br/>"+
        "&lt;/dependency&gt;</code></pre>";
        return mvn;
    },
    buildr:function(gav){
        var builder = "<pre><code>'"+gav[0]+":"+gav[1]+":jar:"+gav[2]+"'</code></pre>";
        return builder;
    },
    ivy:function(gav){
        var ivy = '<pre><code>&lt;dependency org="'+gav[0]+'" name="'+gav[1]+'" rev="'+gav[2]+'" /&gt;</code></pre>';
        return ivy;
    },
    grape:function(gav){
        var grape = "<pre><code>@Grapes( <br/>"+
        "@Grab(group='tw.hyl.common', module='jackson', version='2.3.3')<br/>"+
        ")</code></pre>";
        return grape;
    },
    gradle:function(gav){
        var gradle = "compile '"+gav[0]+":"+gav[1]+":"+gav[2]+"'";
        return gradle;
    },
    sbt:function(gav){
        var sbt = 'libraryDependencies += "'+gav[0]+'" % "'+gav[1]+'" % "'+gav[2]+'"';
        return sbt;
    },
    leiningen:function(gav){
        var leiningen = '['+gav[0]+'/'+gav[1]+' "'+gav[2]+'"]';
        return leiningen;
    }
};