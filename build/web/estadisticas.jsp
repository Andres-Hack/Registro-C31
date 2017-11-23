<style type="text/css">
    ${demo.css}
        </style>
        <script type="text/javascript">
    $(function () {
        Highcharts.chart('container', {
            chart: {
                type: 'area',
                inverted: true
            },
            title: {
                text: 'Estadisticas de Ejecucion por Año'
            },
            subtitle: {
                style: {
                    position: 'absolute',
                    right: '0px',
                    bottom: '10px'
                }
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'top',
                x: -150,
                y: 100,
                floating: true,
                borderWidth: 1,
                backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
            },
            xAxis: {
                categories: [
                    '2013',
                    '2014',
                    '2015',
                    '2016',
                    '2017',
                    '2018'
                ]
            },
            yAxis: {
                title: {
                    text: 'Importe en : Millones $us'
                },
                labels: {
                    formatter: function () {
                        return this.value;
                    }
                },
                min: 0
            },
            plotOptions: {
                area: {
                    fillOpacity: 0.5
                }
            },
            series: [{
                name: 'Ejecucion',
                data: [0.26, 0.509, 5.141, 5.566, 0.01, null]
            }]
        });
    });
    </script>

		<script type="text/javascript">
$(function () {
    Highcharts.chart('container2', {
        chart: {
            type: 'bar'
        },
        title: {
            text: 'Estadisticas Historicos por Municipio y por Gestiones'
        },
        subtitle: {
            text: 'Fuente: <a href="https://pmgm.oopp.gob.bo">Programa de Mejora de la Gestion Municipal</a>'
        },
        xAxis: {
            categories: ['UEP', 'Cochabamba', 'Cobija', 'El Alto', 'El Torno','Oruro', 'Potosi', 'Sucre', 'Sacaba', 'Trinidad', 'Tarija', 'Viacha'],
            title: {
                text: null
            }
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Importe  (Milliones de $us)',
                align: 'high'
            },
            labels: {
                overflow: 'justify'
            }
        },
        tooltip: {
            valueSuffix: ' millions'
        },
        plotOptions: {
            bar: {
                dataLabels: {
                    enabled: true
                }
            }
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'top',
            x: -40,
            y: 80,
            floating: true,
            borderWidth: 1,
            backgroundColor: ((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'),
            shadow: true
        },
        credits: {
            enabled: false
        },
        series: [{
            name: 'Año 2013',
            data: [158, 107, 31, 635, 203, 2, 107, 31, 635, 203, 2, 107]
        }, {
            name: 'Año 2014',
            data: [245, 133, 156, 947, 408, 6, 133, 156, 947, 408, 6, 50]
        }, {
            name: 'Año 2015',
            data: [321, 1052, 954, 4250, 740, 38, 133, 156, 947, 408, 6, 50]
        }, {
            name: 'Año 2016',
            data: [455, 1052, 954, 4250, 740, 38, 133, 156, 947, 408, 6, 50]
        }]
    });
});
</script>