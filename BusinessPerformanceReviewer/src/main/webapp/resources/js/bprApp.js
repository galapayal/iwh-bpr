var bprApp = angular.module('bprApp', [ 'ngRoute' ]);

bprApp.config([ '$routeProvider', '$locationProvider', '$httpProvider',
		function($routeProvider, $locationProvider, $httpProvider) {
			$routeProvider.when('/', {
				title : 'Login',
				templateUrl : 'resources/templates/login.html',
				controller : 'authenticationController',
				requireAuth : false

			}).when('/register', {
				templateUrl : 'resources/templates/registration.html',
				controller : 'authenticationController',
				requireAuth : false

			}).when('/dashboard', {
				templateUrl : 'resources/templates/dashboard.html',
				controller : 'authenticationController',
				requireAuth : true

			}).when('/dataFinance', {
				templateUrl : 'resources/templates/dataInput-Finance.html',
				controller : 'financeController',
				requireAuth : true

			}).when('/financeAnalysis', {
				templateUrl : 'resources/templates/financeAnalysis.html',
				controller : 'financeController',
				requireAuth : true

			}).when('/data1', {
				templateUrl : 'resources/templates/compAnalysis1.html',
				controller : 'compAnalysisController',
				requireAuth : true

			}).when('/about', {
				templateUrl : 'resources/templates/aboutUs.html',
				controller : '',
				requireAuth : true

			}).otherwise({
				redirectTo : '/'
			});

		} ]);

bprApp.run([ '$rootScope', '$location', 'Auth',
		function($rootScope, $location, Auth) {
			$rootScope.$on('$routeChangeStart', function(event, newUrl) {
				if (!newUrl) {
					$location.path('/');
				}else if (newUrl.$$route) {
					if (jsUserData == null) {
					
						$location.path('/');
					}
					if (newUrl.$$route.isUser) {
						
						var user = jsUserData; 
						if (!newUrl.$$route.isUser(user)) {
							$location.path('/');
						}
						else{
							$location.path('/dashboard');
						}
					}
				}

			});
		} ]);

bprApp.factory('Auth', function() {
	var user;

	return {
		setUser : function(aUser) {
			user = aUser;
		},
		isLoggedIn : function(user) {
			return (user) ? user : false;
		}
	}
});
