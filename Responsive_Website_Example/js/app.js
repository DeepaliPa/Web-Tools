$(function () {
    'use strict';

    /* Home page template js starts*/
    $('#avail-panel').show().siblings('div').hide();
    // $('#FLOW_BOOKING_AVAILABILITY').click();

    $('.row .tabs li a').eq(0).attr('aria-selected','true');
    $('.row .tabs li').eq(0).addClass('is-active');
    $('.row .tabs li').eq(0).addClass('selected');

    $('.left-sidebar-panel .tabs li a').eq(0).attr('aria-selected','true');
    $('.left-sidebar-panel .tabs li').eq(0).addClass('is-active');

    var x = $(window).height()*0.91;// was 0.85
    $('#container').css('max-height',x+'px');


    $('.tabs').click(function(e){
        $('#container form').show();
    });

    $('.wds-parameter').click(function(e){
        $(this).next().slideToggle( "slow", function() {
        });
    });

    $('.wds-parameter').next().toggle();

    $(".tabs-title a").click(function (e){
        e.preventDefault();
        $("#" + $(this).attr("class")).show().siblings('div').hide();
        if($('#left-sidebar-panel').css("margin-left") == "0px"){
            $('#left-sidebar').hide();
            $('#left-sidebar-panel').animate({"margin-left": '-='+$(window).width()});
            $('.left-sidebar').removeClass('is-active-lsidebar');
        }
        var index = $(this).parent().index();
        if($(this).parent().hasClass('dmenu')){
            $('.left-sidebar-panel .tabs li a').removeAttr('aria-selected');
            $('.left-sidebar-panel .tabs li').removeClass('is-active');
            $('.left-sidebar-panel .tabs li a').eq(index).attr('aria-selected','true');
            $('.left-sidebar-panel .tabs li').eq(index).addClass('is-active');
        }else{
            $('.row .tabs li a').removeAttr('aria-selected');
            $('.row .tabs li').removeClass('is-active');
            $('.row .tabs li a').eq(index).attr('aria-selected','true');
            $('.row .tabs li').eq(index).addClass('is-active');

            $('.left-sidebar-panel .tabs li a').removeAttr('aria-selected');
            $('.left-sidebar-panel .tabs li').removeClass('is-active');
            $('.left-sidebar-panel .tabs li a').eq(index).attr('aria-selected','true');
            $('.left-sidebar-panel .tabs li').eq(index).addClass('is-active');
        }
    });

    $(window).resize(function(){
        if($('#left-sidebar-panel').css('margin-left') != '0px'){
            $('#left-sidebar-panel').css("margin-left",'-'+$(window).width()+'px');
        }
        /*
         For automatic height adjusting.
         */
        var x = $(window).height()*0.91;
        $('#container').css('max-height',x+'px');

        /*
         Hack for slider issue : from mobile view screen re-sized to I-pad view.
         */
        if($(window).width() < 1024 && $(window).width() > 640){
            if($('#right-sidebar-panel').css('margin-right') == '0px' ){
                //alert($('#right-sidebar-panel').css('margin-right'));
                $('#sidebar-btn').css("right",$('.right-sidebar-panel').css('width'));
            }else{
                $('#sidebar-btn').css("right",'0px');
            }
        }

        /*
         Hack for slider issue : from ipad view screen resized to desktop view.

         */
        if($(window).width() > 1024){
            //desktop
            $('#right-sidebar').css('display','block');
            $('#right-sidebar').addClass('is-active-rsidebar');
            $('#right-sidebar-panel').css('margin-right','0px');
        }
    });

    $('.top-bar-right .menu-icon').click(function(){
        if($('#right-sidebar-panel').css("margin-right") == "0px"){
            $('#right-sidebar').hide();
            $('#right-sidebar-panel').css("margin-right",'-'+$(window).width()+'px');
        }else{
            $('#left-sidebar').hide();
            $('#left-sidebar').removeClass('is-active-lsidebar');
            $('#left-sidebar-panel').css("margin-left",'-'+$(window).width()+'px');
            $('#right-sidebar').show();
            $('#right-sidebar-panel').animate({"margin-right": '0px'});
        }
    });

    $('.top-bar-left .menu-icon').click(function(){
        if($('#left-sidebar-panel').css("margin-left") == "0px"){
            $('#left-sidebar').hide();
            $('#left-sidebar-panel').css("margin-left",'-'+$(window).width()+'px');
        }else{
            $('#right-sidebar').hide();
            $('#right-sidebar').removeClass('is-active-rsidebar');
            $('#right-sidebar-panel').css("margin-right",'-'+$(window).width()+'px');
            $('#left-sidebar').show();
            $('#left-sidebar-panel').animate({"margin-left": '0px'});
        }
    });

    $('#sidebar-btn').click(function(){
        if($('#right-sidebar-panel').css("margin-right") == "0px"){
            $(this).find('span').text('<<')
            $('#right-sidebar').hide();
            $('#right-sidebar-panel').css("margin-right",'-'+$('.right-sidebar-panel').css('width'));
            $('#sidebar-btn').css('right','0px');
        }else{
            $(this).find('span').text('>>')
            $('#right-sidebar').show();
            $('#right-sidebar-panel').animate({"margin-right": '0px'});
            $('#sidebar-btn').animate({"right": $('.right-sidebar-panel').css('width')});
        }
    });

    $('#left-close-sidebar').click(function(){
        $('#left-sidebar').hide();
        $('#left-sidebar-panel').css("margin-left",'-'+$('.left-sidebar-panel').css('width'));

    });
    /* Home page template js ends*/


});