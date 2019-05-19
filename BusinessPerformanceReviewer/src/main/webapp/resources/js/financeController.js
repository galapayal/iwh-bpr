bprApp.controller('financeController', [
		'$scope',
		'$http',
		'$location',
		'$rootScope',
		'$timeout',
		'$window',
		function($scope, $http, $location, $rootScope, $timeout, $window) {

			$scope.balCurrSel1 = 'thousand';
			$scope.balCurrSel2 = 'INR';
			$scope.balYear = 2019;
			$scope.pnlCurrSel1 = 'thousand';
			$scope.pnlCurrSel2 = 'INR';
			$scope.pnlYear = 2019;

			$scope.sumiited = false;

			$scope.resetForm = function(formName) {
				$("#" + formName)[0].reset();
			};

			$scope.submitBalaceSheet = function() {

				var balanceSheetInfo = {
					"shareCapital" : $("#shareCapital").val(),
					"reservesnSurplus" : $("#reserves").val(),
					"DefTaxLiabilities" : $("#dtln").val(),
					"longTermLiabilities" : $("#oltl").val(),
					"tradePayables" : $("#tradepay").val(),
					"currentLiabilities" : $("#currliab").val(),
					"shortTermProvisions" : $("#stp").val(),
					"tangibleAssets" : $("#tangAssets").val(),
					"intangibleAssets" : $("#intangAssets").val(),
					"capitalWIP" : $("#cwip").val(),
					"nCurrentInvestments" : $("#nci").val(),
					"defTaxAssets" : $("#dtan").val(),
					"longTermLoansnAdvances" : $("#ltla").val(),
					"ncurrentAssets" : $("#onca").val(),
					"currentInvestments" : $("#curr-inv").val(),
					"tradeReceivables" : $("#trade-rec").val(),
					"cashEqui" : $("#cace").val(),
					"shortTermLoansnAdvances" : $("#stla").val(),
					"currency" : $scope.balCurrSel1,
					"currencyType" : $scope.balCurrSel2,
					"year" : $scope.balYear,
					"compName" : $rootScope.UserData.compName

				}

				var config = {
					headers : {
						'Content-Type' : 'application/json'
					}
				}

				$http.post('addBalanceSheet', JSON.stringify(balanceSheetInfo),
						config).success(
						function(data, status, headers, config) {

							if (data != null) {
								$scope.sumiited = true;
								$("#PNLSheetForm")[0].reset();

							}

							$("#balanceSheetForm")[0].reset();

							$window.location.reload();
						});

			}

			$scope.submitPNLSheet = function() {

				var pnlSheetInfo = {
					"softServnprodCost" : $("#ifssp").val(),
					"otherIncome" : $("#otherIncome").val(),
					"empBenefitexpenses" : $("#empBE").val(),
					"defacquisition" : $("#dcpta").val(),
					"subContractorsCost" : $("#ctsc").val(),
					"travelExpenses" : $("#travExp").val(),
					"softackagesCosts" : $("#cspo").val(),
					"comExpenses" : $("#commExp").val(),
					"profCharges" : $("#profCharge").val(),
					"deprecnAmortxpense" : $("#daae").val(),
					"expense" : $("#otrExp").val(),
					"currentTax" : $("#currTax").val(),
					"defTax" : $("#defTax").val(),

					"currency" : $scope.pnlCurrSel1,
					"currencyType" : $scope.pnlCurrSel2,
					"year" : $scope.pnlYear,
					"compName" : $rootScope.UserData.compName

				}

				var config = {
					headers : {
						'Content-Type' : 'application/json'
					}
				}

				$http.post('addProftLossnote', JSON.stringify(pnlSheetInfo),
						config).success(
						function(data, status, headers, config) {
							if (data != null) {
								$scope.sumiited = true;
								$("#PNLSheetForm")[0].reset();

							}

							$location.path('/dataFinance');
						});

			}

		} ]);