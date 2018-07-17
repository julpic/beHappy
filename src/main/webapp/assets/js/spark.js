var Spark = {
  removeNoJs: function(){
    $('html:first').removeClass('no-js');
    },

  removeLoadingScreen: function(){
    $(document).ready(function() {
      $('.splash').removeClass('active');
    });
    },

  //Esto es la funcion animacion de como carga la pantalla principal y todas las demas pantallas.
  animateWidgetsAfterPageLoad: function(){
    $(document).ready(function() {
      var speed = 8000;
      var delay = 0;
      var container = $('.page-content');
      container.each(function() {
          var elements = $(this).find('.widget');
          elements.each(function() {
              var elementOffset = $(this).offset();
              var offset = elementOffset.left * 0.8 + elementOffset.top;
              var delay = (parseFloat(offset / speed) - 0.3).toFixed(2);
              $(this)
                .css('-webkit-animation-delay', delay + 's')
                .css('-o-animation-delay', delay + 's')
                .css('animation-delay', delay + 's');
              $(this).addClass('animated');
          });
      });
    });
    },

  //barra de borrar y ocultar pantalla (hay que solucionar el problema de que no te cierra la pestaña, por lo que luego no te deja abrirla)
  createSidebar: function(){
    $('.sidebar-collapse').on('click', function(){
      $('.page-body').toggleClass('collapsed');
    });
    $('.sidebar-open').on('click', function(){
      $('.page-sidebar').removeClass('toggled');
    });
    $('.sidebar-close').on('click', function(){
      $('.page-sidebar').addClass('toggled');
    });

    $('.nav-stacked').on('show.bs.collapse', function () {
        $('.nav-stacked .in').collapse('hide');
    });
    },

  //callOnResize: [],
  //handleElementsOnResizing: function() {
  //  var resizing;
  //  $(window).resize(function() {
  //    if (resizing) {
  //      clearTimeout(resizing);
  //    }
  //    resizing = setTimeout(function() {
  //      for (var i = 0; i < Spark.callOnResize.length; i++) {
  //        Spark.callOnResize[i].call();
  //      }
  //    }, 300);
  //  });
  //  },
    
  init: function(){
    this.removeNoJs();
    this.removeLoadingScreen();
    this.animateWidgetsAfterPageLoad();
    this.createSidebar();
    //this.handleElementsOnResizing();
  }
}