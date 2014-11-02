'use strict';

angular.module('bookangular',['ngRoute','ngResource'])
  .config(['$routeProvider', function($routeProvider) {
    $routeProvider
      .when('/',{templateUrl:'views/landing.html',controller:'LandingPageController'})
      .when('/Books',{templateUrl:'views/Book/search.html',controller:'SearchBookController'})
      .when('/Books/new',{templateUrl:'views/Book/detail.html',controller:'NewBookController'})
      .when('/Books/edit/:BookId',{templateUrl:'views/Book/detail.html',controller:'EditBookController'})
      .otherwise({
        redirectTo: '/'
      });
  }])
  .controller('LandingPageController', function LandingPageController() {
  })
  .controller('NavController', function NavController($scope, $location) {
    $scope.matchesRoute = function(route) {
        var path = $location.path();
        return (path === ("/" + route) || path.indexOf("/" + route + "/") == 0);
    };
  });
