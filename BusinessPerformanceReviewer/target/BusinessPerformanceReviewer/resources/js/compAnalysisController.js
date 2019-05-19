bprApp
		.controller(
				'compAnalysisController',
				[
						'$scope',
						'$http',
						'$location',
						'$rootScope',
						'$timeout',
						function($scope, $http, $location, $rootScope, $timeout) {

							$scope.flag = false;
							$scope.loadResults = function() {

								$scope.flag = false;

								var dataParam = {
									query : $("#searchQuery").val()
								}

								$http(
										{
											method : 'POST',
											url : 'findTopCompetitors',
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
										})
										.success(
												function(data) {

													$http(
															{
																url : "https://api.linkpreview.net?key=5cde56b6c18ff30e78bbe90e4fa00b725dbc54f11cf91&q"
																		+ data,
																method : "GET",

															})
															.success(
																	function(
																			data) {
																		$scope.flag = true;
																		document
																				.getElementById("linkDesc").innerText = data.description;
																		document
																				.getElementById("linkTitle").innerText = data.title;
																		document
																				.getElementById("linkUrl").href = data.url;
																		document
																				.getElementById("linkImg").src = data.image;
																	});

												});

							}

						} ]);