bprApp
		.controller(
				'authenticationController',
				[
						'$scope',
						'$http',
						'$location',
						'$rootScope',
						'$timeout',
						'Auth',
						function($scope, $http, $location, $rootScope,
								$timeout, Auth) {

							$rootScope.regSuccessMsg = null;
						

							$scope.login = function() {
								$rootScope.regSuccessMsg = null;

								$scope.success = false;
								var dataParam = {
									username : $("#username").val(),
									password : $("#password").val(),

								}
								$http(
										{
											method : 'POST',
											url : 'doLogin',
											headers : {
												'Content-Type' : 'application/x-www-form-urlencoded'
											},
											transformRequest : function(obj) {
												var str = [];
												for ( var p in obj)
													str
															.push(encodeURIComponent(p)
																	+ "="
																	+ encodeURIComponent(obj[p]));
												return str.join("&");
											},
											data : dataParam
										}).success(
										function(data) {

											$rootScope.userProfile = data;
											sessionStorage.setItem("userP",
													JSON.stringify(data));
											Auth.setUser($rootScope.UserData);

											if (data.message == 'LoggedIn')
												$location.path('/dashboard');
											else
												$scope.error = true;

										});

							}

							$scope.register = function() {

								$scope.success = false;

								var companyInfo = {
									"compName" : $("#companyName").val(),
									"compAdd" : $("#companyAddress").val(),
									"compMailId" : $("#contactMail").val(),
									"compContactNumber" : $("#contactNumber")
											.val(),
									"typeOfService" : $("#typeOfService").val(),
									"employeeCount" : $("#totalEmployees")
											.val(),
									"username" : $("#username").val(),
									"password" : $("#password").val()
								}

								var config = {
									headers : {
										'Content-Type' : 'application/json'
									}
								}

								$http
										.post('addUser',
												JSON.stringify(companyInfo),
												config)
										.success(
												function(data, status, headers,
														config) {

													$rootScope.regSuccessMsg = "Registartion Successful!!!"
													$location.path('/');
												});

							}

							$scope.logout = function() {

								$http({
									method : 'POST',
									url : 'doLogOut'
										
								}).success(function(data) {
									jsUserData = null;
									$rootScope.UserData = null;
									$rootScope.userProfile = null;
									sessionStorage.clear();

									Auth.setUser(null);
									$location.path('/');
								});

							}

							$scope.init = function() {

								var userdata = jsUserData;
								if (jsUserData) {
									$rootScope.UserData = jsUserData;
								}
							}

							$scope.init();

						} ]);