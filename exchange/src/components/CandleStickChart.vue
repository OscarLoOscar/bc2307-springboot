<template>
  <div>
    <Card>
      <CardHeader title="CandleStickChart" />
      <Divider />
      <CardContent>
        <apexchart :options="options" :series="series" type="candlestick" height="400" />
      </CardContent>
    </Card>
  </div>
</template>

<script>
import VueApexCharts from "vue3-apexcharts";

export default {
  components: {
    apexchart: VueApexCharts,
  },
  data() {
    return {
      options: {
        xaxis: {
          type: "datetime",
        },
        plotOptions: {
    candlestick: {
      colors: {
        upward: '#00C853', // Color for "up" candlesticks (green)
        downward: '#FF1744', // Color for "down" candlesticks (red)
      }
    }
  }
      },
      series: [
        {
          data: [
                //数据模型 time0 open1 close2 min3 max4 vol5 tag6 macd7 dif8 dea9
    //['2015-10-19',18.56,18.25,18.19,18.56,55.00,0,-0.00,0.08,0.09] 

            {
              x: '2015-10-16', // Corrected the typo 'Data' to 'Date'
              y: [18.4, 18.58, 18.33, 18.79, 67.00, 1, 0.04, 0.11, 0.09],
            },
            {
              x: '2015-10-19',
              y: [ 18.56, 18.25, 18.19, 18.56, 55.00, 0, -0.00, 0.08, 0.09],
            },
            {
              x: '2015-10-20',
  y: [ 18.3, 18.22, 18.05, 18.41, 37.00, 0, 0.01, 0.09, 0.09],

},
{
  x: '2015-10-21',
y: [   18.18, 18.69, 18.02, 18.98, 89.00, 0, 0.03, 0.10, 0.08],
},
{
  x: '2015-10-22',
  y:[ 18.42, 18.29, 18.22, 18.48, 43.00, 0, -0.06, 0.05, 0.08],

},
{
  x: '2015-10-23',
  y:[ 18.26, 18.19, 18.08, 18.36, 46.00, 0, -0.10, 0.03, 0.09],
},
{
  x: '2015-10-26',
  y: [ 18.33, 18.07, 17.98, 18.35, 65.00, 0, -0.15, 0.03, 0.10],
},
{
  x:'2015-10-27',
  y:[ 18.08, 18.04, 17.88, 18.13, 37.00, 0, -0.19, 0.03, 0.12],
},
{
  x:'2015-10-28',
  y:[17.96, 17.86, 17.82, 17.99, 35.00, 0, -0.24, 0.03, 0.15],
},
{
  x: '2015-10-29', 
  y:[17.85, 17.81, 17.8, 17.93, 27.00, 0, -0.24, 0.06, 0.18],
},
{
  x: '2015-10-30',
  y:[ 17.79, 17.93, 17.78, 18.08, 43.00, 0, -0.22, 0.11, 0.22],
},
{
  x: '2015-11-02',
  y:[ 17.78, 17.83, 17.78, 18.04, 27.00, 0, -0.20, 0.15, 0.25],
},
{
  x: '2015-11-03',
  y:[ 17.84, 17.9, 17.84, 18.06, 34.00, 0, -0.12, 0.22, 0.28],
},
{
  x:'2015-11-04',
  y:[ 17.97, 18.36, 17.85, 18.39, 62.00, 0, -0.00, 0.30, 0.30],
},
{
  x: '2015-11-05',
  y:[ 18.23, 18.45, 18.2, 18.00, 47.00, 0, 0.13, 0.25, 0.19],

}
          ],
        },
      ],
    };
  },
};
</script>

<style scoped>
/* Add your component-specific styles here */
</style>