( function ( $ ) {
    "use strict";

    $(window).load(function() {
        console.log( "ready!" );
       


        //Sales chart
        var ctx = document.getElementById( "workingCapital" );
        ctx.height = 150;
        var myChart = new Chart( ctx, {
            type: 'line',
            data: {
                labels: [ "2012", "2013", "2014", "2015", "2016", "2017", "2018" ],
                type: 'line',
                defaultFontFamily: 'Montserrat',
                datasets: [ {
                    label: "Foods",
                    data: [ 0, 30, 15, 110, 50, 63, 120 ],
                    backgroundColor: 'transparent',
                    borderColor: 'rgba(220,53,69,0.75)',
                    borderWidth: 3,
                    pointStyle: 'circle',
                    pointRadius: 5,
                    pointBorderColor: 'transparent',
                    pointBackgroundColor: 'rgba(220,53,69,0.75)',
                        }, {
                    label: "Electronics",
                    data: [ 0, 50, 40, 80, 35, 99, 80 ],
                    backgroundColor: 'transparent',
                    borderColor: 'rgba(40,167,69,0.75)',
                    borderWidth: 3,
                    pointStyle: 'circle',
                    pointRadius: 5,
                    pointBorderColor: 'transparent',
                    pointBackgroundColor: 'rgba(40,167,69,0.75)',
                        } ]
            },
            options: {
                responsive: true,

                tooltips: {
                    mode: 'index',
                    titleFontSize: 12,
                    titleFontColor: '#000',
                    bodyFontColor: '#000',
                    backgroundColor: '#fff',
                    titleFontFamily: 'Montserrat',
                    bodyFontFamily: 'Montserrat',
                    cornerRadius: 3,
                    intersect: false,
                },
                legend: {
                    display: false,
                    labels: {
                        usePointStyle: true,
                        fontFamily: 'Montserrat',
                    },
                },
                scales: {
                    xAxes: [ {
                        display: true,
                        gridLines: {
                            display: false,
                            drawBorder: false
                        },
                        scaleLabel: {
                            display: false,
                            labelString: 'Month'
                        }
                            } ],
                    yAxes: [ {
                        display: true,
                        gridLines: {
                            display: false,
                            drawBorder: false
                        },
                        scaleLabel: {
                            display: true,
                            labelString: 'Value'
                        }
                            } ]
                },
                title: {
                    display: false,
                    text: 'Normal Legend'
                }
            }
        } );


      //Sales chart
        var ctx = document.getElementById( "der" );
        ctx.height = 150;
        var myChart = new Chart( ctx, {
            type: 'line',
            data: {
                labels: [ "2012", "2013", "2014", "2015", "2016", "2017", "2018" ],
                type: 'line',
                defaultFontFamily: 'Montserrat',
                datasets: [ {
                    label: "Foods",
                    data: [ 0, 30, 15, 110, 50, 63, 120 ],
                    backgroundColor: 'transparent',
                    borderColor: 'rgba(220,53,69,0.75)',
                    borderWidth: 3,
                    pointStyle: 'circle',
                    pointRadius: 5,
                    pointBorderColor: 'transparent',
                    pointBackgroundColor: 'rgba(220,53,69,0.75)',
                        }, {
                    label: "Electronics",
                    data: [ 0, 50, 40, 80, 35, 99, 80 ],
                    backgroundColor: 'transparent',
                    borderColor: 'rgba(40,167,69,0.75)',
                    borderWidth: 3,
                    pointStyle: 'circle',
                    pointRadius: 5,
                    pointBorderColor: 'transparent',
                    pointBackgroundColor: 'rgba(40,167,69,0.75)',
                        } ]
            },
            options: {
                responsive: true,

                tooltips: {
                    mode: 'index',
                    titleFontSize: 12,
                    titleFontColor: '#000',
                    bodyFontColor: '#000',
                    backgroundColor: '#fff',
                    titleFontFamily: 'Montserrat',
                    bodyFontFamily: 'Montserrat',
                    cornerRadius: 3,
                    intersect: false,
                },
                legend: {
                    display: false,
                    labels: {
                        usePointStyle: true,
                        fontFamily: 'Montserrat',
                    },
                },
                scales: {
                    xAxes: [ {
                        display: true,
                        gridLines: {
                            display: false,
                            drawBorder: false
                        },
                        scaleLabel: {
                            display: false,
                            labelString: 'Month'
                        }
                            } ],
                    yAxes: [ {
                        display: true,
                        gridLines: {
                            display: false,
                            drawBorder: false
                        },
                        scaleLabel: {
                            display: true,
                            labelString: 'Value'
                        }
                            } ]
                },
                title: {
                    display: false,
                    text: 'Normal Legend'
                }
            }
        } );


        


        //line chart
        var ctx = document.getElementById( "roe" );
        ctx.height = 150;
        var myChart = new Chart( ctx, {
            type: 'line',
            data: {
                labels: [ "January", "February", "March", "April", "May", "June", "July" ],
                datasets: [
                    {
                        label: "My First dataset",
                        borderColor: "rgba(0,0,0,.09)",
                        borderWidth: "1",
                        backgroundColor: "rgba(0,0,0,.07)",
                        data: [ 20, 47, 35, 43, 65, 45, 35 ]
                                },
                    {
                        label: "My Second dataset",
                        borderColor: "rgba(0, 194, 146, 0.9)",
                        borderWidth: "1",
                        backgroundColor: "rgba(0, 194, 146, 0.5)",
                        pointHighlightStroke: "rgba(26,179,148,1)",
                        data: [ 16, 32, 18, 27, 42, 33, 44 ]
                                }
                            ]
            },
            options: {
                responsive: true,
                tooltips: {
                    mode: 'index',
                    intersect: false
                },
                hover: {
                    mode: 'nearest',
                    intersect: true
                }

            }
        } );


        //bar chart
        var ctx = document.getElementById( "roa" );
        //    ctx.height = 200;
        var myChart = new Chart( ctx, {
            type: 'bar',
            data: {
                labels: [ "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul" ],
                datasets: [
                    {
                        label: "My First dataset",
                        data: [ 65, 59, 80, 81, 56, 55, 45 ],
                        borderColor: "rgba(0, 194, 146, 0.9)",
                        borderWidth: "0",
                        backgroundColor: "rgba(0, 194, 146, 0.5)"
                                },
                    {
                        label: "My Second dataset",
                        data: [ 28, 48, 40, 19, 86, 27, 76 ],
                        borderColor: "rgba(0,0,0,0.09)",
                        borderWidth: "0",
                        backgroundColor: "rgba(0,0,0,0.07)"
                                }
                            ]
            },
            options: {
                scales: {
                    yAxes: [ {
                        ticks: {
                            beginAtZero: true
                        }
                                    } ]
                }
            }
        } );

      

       
        
    });
    
    
   




} )( jQuery );