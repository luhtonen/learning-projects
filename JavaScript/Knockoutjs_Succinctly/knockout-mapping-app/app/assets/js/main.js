'use strict';

/* global define:true*/
define(['jquery',
    'knockout',
    '../../assets/js/models/appViewModel.js',
    'knockout.mapping',
    'jquery.bootstrap'
    ], function ($) {

  $(function () {
    $('[data-toggle="tooltip"]').tooltip();
  });

});
