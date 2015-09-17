'use strict';

module.exports = function (grunt) {
  require('load-grunt-tasks')(grunt);

  var appConfig = {
    app: require('./bower.json').appPath || 'app',
    dist: 'dist'
  };

  grunt.initConfig({
    // Project settings
    changeMe: appConfig
  });

  grunt.registerTask('build', [
    // task list goes here
  ]);
};