'use strict';

require.config({
  paths: {
    'bower_components': '../../bower_components',
    'jquery': '../../bower_components/jquery/dist/jquery',
    'jquery.bootstrap': '../../bower_components/bootstrap-sass-official/assets/javascripts/bootstrap'
  },
  shim: {
    'jquery.bootstrap': {
      deps: ['jquery']
    }
  },
  map: {
    '*': {
      'knockout': '../../bower_components/knockout/dist/knockout',
      'ko': '../../bower_components/knockout/dist/knockout',
      'knockout.mapping': '../../bower_components/bower-knockout-mapping/dist/knockout.mapping.min'
    }
  }
});

// Use the debug version of knockout in development only
/* global window:true*/
if (window.knockoutBootstrapDebug) {
  require.config({
    map: {
      '*': {
        'knockout': '../../bower_components/knockout/dist/knockout.debug.js',
        'ko': '../../bower_components/knockout/dist/knockout.debug.js',
        'knockout.mapping': '../../bower_components/bower-knockout-mapping/dist/knockout.mapping.js'
      }
    }
  });
}

if (!window.requireTestMode) {
  require(['main'], function () { });
}
