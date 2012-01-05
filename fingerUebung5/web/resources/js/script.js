$(document).ready(function(){
   $(".kommentar-form").hide();
   $(".kommentar-toggle").click(function(){
       $(".kommentar-form").toggle();
   });
   setTimeout(function(){ jQuery("#messagePanel").fadeOut("slow"); }, 5000);
});