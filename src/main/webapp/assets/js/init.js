(function ($) {
   
    $('.dropdown-trigger').dropdown();

    $(document).ready(function () {
        Spark.init();
    });

    $(document).ready(function () {
        $('.sidenav').sidenav();
    });

    $(document).ready(function () {
        $('.collapsible').collapsible();
    });
    $(document).ready(function () {
        $('.tooltipped').tooltip();
    });
    $(document).ready(function () {
        $('select').formSelect();
    });
    $(document).ready(function () {
        $('.tabs').tabs({
            'swipeable':true
        });
        $(document).ready(function () {
            $('.fixed-action-btn').floatingActionButton();
        });
      
    });




  $(function(){

    $('.sidenav').sidenav();

  }); // end of document ready
})(jQuery); // end of jQuery name space
