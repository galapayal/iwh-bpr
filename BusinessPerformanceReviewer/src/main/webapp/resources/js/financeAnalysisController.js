bprApp
		.controller(
				'financeAnalysisController',
				[
						'$scope',
						'$http',
						'$location',
						'$rootScope',
						'$timeout',
						function($scope, $http, $location, $rootScope, $timeout) {

							

							$scope.loadStatistics = function() {


								var dataParam = {
									compName : $rootScope.UserData.compName
								}
								$http(
										{
											method : 'POST',
											url : 'calculateFinanceResult',
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
													$scope.obj = data;

													var profitData = [];
													for ( var key in $scope.obj.profit) {
														if ($scope.obj.profit
																.hasOwnProperty(key)) {
															profitData
																	.push($scope.obj.profit[key]);

														}
													}

													var workingCapitalData = [];
													for ( var key in $scope.obj.wcRatio) {
														if ($scope.obj.wcRatio
																.hasOwnProperty(key)) {
															workingCapitalData
																	.push($scope.obj.wcRatio[key]);

														}
													}

													var roaData = [];
													for ( var key in $scope.obj.roa) {
														if ($scope.obj.roa
																.hasOwnProperty(key)) {
															roaData
																	.push($scope.obj.roa[key]);

														}
													}

													var roeData = [];
													for ( var key in $scope.obj.roe) {
														if ($scope.obj.roe
																.hasOwnProperty(key)) {
															roeData
																	.push($scope.obj.roe[key]);

														}
													}

													var derData = [];
													for ( var key in $scope.obj.der) {
														if ($scope.obj.der
																.hasOwnProperty(key)) {
															derData
																	.push($scope.obj.der[key]);

														}
													}

													// bar chart
													var ctx = document
															.getElementById("netIncome");
													// ctx.height = 200;
													var myChart = new Chart(
															ctx,
															{
																type : 'bar',
																data : {
																	labels : $scope.obj.year,
																	datasets : [
																			{
																				label : "PROFIT IN "
																						+ $scope.obj.currencyType
																						+ "("
																						+ $scope.obj.currency
																						+ ")",
																				data : profitData,
																				borderColor : "rgba(0, 194, 146, 0.9)",
																				borderWidth : "0",
																				backgroundColor : "rgba(0, 194, 146, 0.5)"
																			},

																	]
																},
																options : {
																	scales : {
																		yAxes : [ {
																			ticks : {
																				beginAtZero : true
																			}
																		} ]
																	}
																}
															});

													// Sales chart
													var ctx = document
															.getElementById("workingCapital");
													ctx.height = 150;
													var myChart = new Chart(
															ctx,
															{
																type : 'line',
																data : {
																	labels : $scope.obj.year,
																	type : 'line',
																	defaultFontFamily : 'Montserrat',
																	datasets : [ {
																		label : "wcRatio",
																		data : workingCapitalData,
																		backgroundColor : 'transparent',
																		borderColor : 'rgba(40,167,69,0.75)',
																		borderWidth : 3,
																		pointStyle : 'circle',
																		pointRadius : 5,
																		pointBorderColor : 'transparent',
																		pointBackgroundColor : 'rgba(40,167,69,0.75)',
																	} ]
																},
																options : {
																	responsive : true,

																	tooltips : {
																		mode : 'index',
																		titleFontSize : 12,
																		titleFontColor : '#000',
																		bodyFontColor : '#000',
																		backgroundColor : '#fff',
																		titleFontFamily : 'Montserrat',
																		bodyFontFamily : 'Montserrat',
																		cornerRadius : 3,
																		intersect : false,
																	},
																	legend : {
																		display : false,
																		labels : {
																			usePointStyle : true,
																			fontFamily : 'Montserrat',
																		},
																	},
																	scales : {
																		xAxes : [ {
																			display : true,
																			gridLines : {
																				display : false,
																				drawBorder : false
																			},
																			scaleLabel : {
																				display : false,
																				labelString : 'Month'
																			}
																		} ],
																		yAxes : [ {
																			display : true,
																			gridLines : {
																				display : false,
																				drawBorder : false
																			},
																			scaleLabel : {
																				display : true,
																				labelString : 'Value'
																			}
																		} ]
																	},
																	title : {
																		display : false,
																		text : 'Normal Legend'
																	}
																}
															});

													// Sales chart
													var ctx = document
															.getElementById("der");
													ctx.height = 150;
													var myChart = new Chart(
															ctx,
															{
																type : 'line',
																data : {
																	labels : $scope.obj.year,
																	type : 'line',
																	defaultFontFamily : 'Montserrat',
																	datasets : [ {
																		label : "der",
																		data : derData,
																		backgroundColor : 'transparent',
																		borderColor : 'rgba(40,167,69,0.75)',
																		borderWidth : 3,
																		pointStyle : 'circle',
																		pointRadius : 5,
																		pointBorderColor : 'transparent',
																		pointBackgroundColor : 'rgba(40,167,69,0.75)',
																	} ]
																},
																options : {
																	responsive : true,

																	tooltips : {
																		mode : 'index',
																		titleFontSize : 12,
																		titleFontColor : '#000',
																		bodyFontColor : '#000',
																		backgroundColor : '#fff',
																		titleFontFamily : 'Montserrat',
																		bodyFontFamily : 'Montserrat',
																		cornerRadius : 3,
																		intersect : false,
																	},
																	legend : {
																		display : false,
																		labels : {
																			usePointStyle : true,
																			fontFamily : 'Montserrat',
																		},
																	},
																	scales : {
																		xAxes : [ {
																			display : true,
																			gridLines : {
																				display : false,
																				drawBorder : false
																			},
																			scaleLabel : {
																				display : false,
																				labelString : 'Month'
																			}
																		} ],
																		yAxes : [ {
																			display : true,
																			gridLines : {
																				display : false,
																				drawBorder : false
																			},
																			scaleLabel : {
																				display : true,
																				labelString : 'Value'
																			}
																		} ]
																	},
																	title : {
																		display : false,
																		text : 'Normal Legend'
																	}
																}
															});

													// line chart
													var ctx = document
															.getElementById("roe");
													ctx.height = 150;
													var myChart = new Chart(
															ctx,
															{
																type : 'line',
																data : {
																	labels : $scope.obj.year,
																	datasets : [

																	{
																		label : "RoE",
																		borderColor : "rgba(0, 194, 146, 0.9)",
																		borderWidth : "1",
																		backgroundColor : "rgba(0, 194, 146, 0.5)",
																		pointHighlightStroke : "rgba(26,179,148,1)",
																		data : roeData
																	} ]
																},
																options : {
																	responsive : true,
																	tooltips : {
																		mode : 'index',
																		intersect : false
																	},
																	hover : {
																		mode : 'nearest',
																		intersect : true
																	}

																}
															});

													// bar chart
													var ctx = document
															.getElementById("roa");
													// ctx.height = 200;
													var myChart = new Chart(
															ctx,
															{
																type : 'bar',
																data : {
																	labels : $scope.obj.year,
																	datasets : [ {
																		label : "RoA",
																		data : roaData,
																		borderColor : "rgba(0, 194, 146, 0.9)",
																		borderWidth : "0",
																		backgroundColor : "rgba(0, 194, 146, 0.5)"
																	} ]
																},
																options : {
																	scales : {
																		yAxes : [ {
																			ticks : {
																				beginAtZero : true
																			}
																		} ]
																	}
																}
															});

												});

							}

						} ]);