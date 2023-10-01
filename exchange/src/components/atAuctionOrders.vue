<template>
  <div>
    <h2>At-Auction Orders Preview</h2>
    <input type="text" v-model="stockId" />
    <table v-if="atAuctionOrders" class="table table-striped">
      <thead>
        <tr>
          <th>Bid Price</th>
          <th>Bid Quantity</th>
          <th>Ask Price</th>
          <th>Ask Quantity</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="order in atAuctionOrders" :key="order.orderId">
          <td>{{ order.bidPrice }}</td>
          <td>{{ order.bidQuantity }}</td>
          <td>{{ order.askPrice }}</td>
          <td>{{ order.askQuantity }}</td>
        </tr>
      </tbody>
    </table>
    <div v-else-if="isLoading">
      <span>Loading...</span>
    </div>
    <div v-else>
      <span>Error fetching at-auction orders.</span>
    </div>
  </div>
</template>

<script>
import { ref, onMounted } from 'vue';

async function fetchAtAuctionOrders(stockId) {
  const response = await fetch('localhost:8089/transactions/atAuctionOrders?stockId=' + stockId);
  const data = await response.json();
  return data;
}

export default {
  props: {},
  setup() {
    const atAuctionOrders = ref(null);
    const isLoading = ref(true);
    const stockId = ref('');

    onMounted(async () => {
      isLoading.value = true;
      atAuctionOrders.value = await fetchAtAuctionOrders(stockId.value);
      isLoading.value = false;
    });

    return {
      atAuctionOrders,
      isLoading,
      stockId,
    };
  },
};
</script>
