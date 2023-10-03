<template>
<img alt="Vlab_logo" src="./assets/Vlab-logo.png" width="600" height="80" style="margin: 0 auto;">
  <br>
  <img alt="VenturenixLAB" src="./assets/VenturenixLAB.png" width="200" height="200" style="margin: 0 auto;">
  <!-- <HelloWorld msg="Welcome to Your Vue.js App"/> -->
  <div>
    <h2>At-Auction Orders Preview</h2>
    <label for="stockSelect">Select Stock : </label>
    <select id="stockSelect" v-model="selectedStock">
      <option value="AAPL">AAPL</option>
      <option value="TSLA">TSLA</option>
      <option value="MSFT">MSFT</option>
    </select>
    <br>
    <table v-if="atAuctionOrders[selectedStock]" class="table table-striped">
      <!-- Table content -->
    </table>
    <div v-else-if="isLoading">
      <span>Loading...</span>
    </div>
    <div v-else>
      <span>Error fetching at-auction orders.</span>
    </div>
  </div>
    <br>
<div class="fl">
      <div class="a1">
          <!-- <CardHeader title="CandleStickChart" />
          <Divider /> -->
            <CandleStickChart/>
            <!-- <apexchart :options="options"  type="candlestick" height="400" auto/> -->
      </div>
    </div>
</template>

<script>
import { ref, onMounted, watch } from 'vue';
import CandleStickChart from './components/CandleStickChart.vue';
//  import EchartsComponent from './components/EchartsComponent.vue';

async function fetchAtAuctionOrders() {
  try {
    const response = await fetch('http://localhost:8081/transactions/atAuctionOrders?stockId=TSLA');
    if (!response.ok) {
      throw new Error(`Network response was not ok: ${response.statusText}`);
    }
    const data = await response.json();
    return data;
  } catch (error) {
    console.error('Error fetching data:', error);
    throw error; // Rethrow the error for further handling
  }
}

export default {
  name: 'App',
  components: {
    CandleStickChart,
    //  EchartsComponent,
  },
  props: {},
  setup() {
    const atAuctionOrders = ref({});
    const isLoading = ref(true);
    const selectedStock = ref('TSLA');

    const loadStockData = async () => {
  isLoading.value = true;
  try {
    atAuctionOrders.value[selectedStock.value] = await fetchAtAuctionOrders(selectedStock.value);
  } catch (error) {
    console.log('Error fetching data:', error);
  }
  isLoading.value = false;
};

    onMounted(() => {
      loadStockData();
    });

    watch(selectedStock, () => {
      loadStockData();
    });

    return {
      atAuctionOrders,
      isLoading,
      selectedStock,
    };
  },
};


</script>

<style>
 /* Add your global CSS styles here */
 #app {
   font-family: Avenir, Helvetica, Arial, sans-serif;
   -webkit-font-smoothing: antialiased;
   -moz-osx-font-smoothing: grayscale;
   text-align: center;
   color: #2c3e50;
   margin-top: 60px;
 }
.fl{
    display: flex;
    justify-content: space-around;
  }
  .a1{
    border: 1px rgb(158, 16, 16) ridge auto;
    width: 200px auto;
    height: 200px auto;
  }
 .atAuctionOrders {
   /* Apply the cryptocurrency style to the container */
   padding: 20px;
   background-color: #f0f0f0; /* Add your desired background color */
 } 
 </style>