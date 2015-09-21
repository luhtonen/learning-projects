module.exports = function (grunt) {
  'use strict';

  require('load-grunt-tasks')(grunt);

  var appConfig = {
    app: require('./bower.json').appPath || 'app',
    dist: 'dist'
  };

  grunt.initConfig({
    // Project settings
    kmConfig: appConfig,

    // Metadata
    pkg: grunt.file.readJSON('package.json'),
    banner: [
      '/*!',
      ' * <%= pkg.name %> - <%= pkg.version %> - <%= grunt.template.today("yyyy-mm-dd") %>',
      ' * <%= pkg.homepage ? " * " + pkg.homepage : "" %>',
      ' * Copyright (c) <%= grunt.template.today("yyyy") %> <%= pkg.author %>',
      ' * License: <%= pkg.license %>',
      ' */\n'
    ].join('\n'),

    // Task configuration
    clean: {
      dist: ['dist/*']
    },
    concat: {
      options: {
        separator: ';'
      },
      dist: {
        src: ['<%= kmConfig.app %>/js/*.js'],
        dest: '<%= kmConfig.dist %>/js/<%= pkg.name %>.js'
      }
    },
    jshint: {
      options: {
        reporter: require('jshint-stylish'),
        globals: {
          module: true,
          require: true,
          jQuery: true,
          console: true
        }
      },
      build: ['Gruntfile.js', '<%= kmConfig.app %>/js/*.js']
    },
    uglify: {
      options: {
        banner: '<%= banner %>'
      },
      build: {
        src: '<%= kmConfig.dist %>/js/<%= pkg.name %>.js',
        dest: '<%= kmConfig.dist %>/js/<%= pkg.name %>.min.js'
      }
    },
    cssmin: {
      options: {
        banner: '<%= banner %>'
      },
      build: {
        src: '<%= kmConfig.app %>/css/<%= pkg.name %>.css',
        dest: '<%= kmConfig.dist %>/css/<%= pkg.name %>.min.css'
      }
    }
  });

  grunt.registerTask('build', [
    'clean:dist',
    'jshint',
    'concat',
    'uglify',
    'cssmin'
  ]);
};