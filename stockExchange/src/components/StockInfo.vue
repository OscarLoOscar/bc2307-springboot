<template>
  <div>
    <h1>Stock Information</h1>
    <div v-if="stockData">
      <div>
        <strong>Symbol:</strong> {{ stockData.data.symbol }}
      </div>
      <div>
        <strong>Company Name:</strong> {{ stockData.data.companyProfile.companyName }}
      </div>
      <div>
        <strong>Country:</strong> {{ stockData.data.companyProfile.country }}
      </div>
      <div>
        <strong>IPO Date:</strong> {{ stockData.data.companyProfile.ipoDate }}
      </div>
      <div>
        <strong>Market Cap:</strong> {{ stockData.data.companyProfile.marketCap }}
      </div>
      <div>
        <strong>Currency:</strong> {{ stockData.data.companyProfile.currency }}
      </div>
      <div>
        <strong>Current Price:</strong> {{ stockData.data.currentPrice }}
      </div>
      <div>
        <strong>Day High:</strong> {{ stockData.data.dayHigh }}
      </div>
      <div>
        <strong>Day Low:</strong> {{ stockData.data.dayLow }}
      </div>
      <div>
        <strong>Day Open:</strong> {{ stockData.data.dayOpen }}
      </div>
      <div>
        <strong>Previous Day Close:</strong> {{ stockData.data.prevDayClose }}
      </div>
    </div>
    <div v-else>
      Loading...
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      stockData: null,
    };
  },
  mounted() {
    // Fetch the JSON data from your API or source here
    // For example, you can use axios or the Fetch API
    // Replace the URL with your actual API endpoint
    fetch('localhost:8095/api/v1/stock?symbol=AAPL')
      .then((response) => response.json())
      .then((data) => {
        this.stockData = data;
      })
      .catch((error) => {
        console.error('Error fetching data:', error);
      });
  },
};
</script>

<style scoped>
/* Add your component-specific styles here */
</style>
