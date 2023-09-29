<!-- <script setup>
defineProps({
  msg: {
    type: String,
    required: true
  }
})
</script>

<template>
  <div class="testing">
    <h2>One-Click Trading</h2>
    <form @submit.prevent="placeOrder">
      <label for="orderType">Order Type:</label>
      <select v-model="orderRequest.orderType">
        <option value="buy-stop">Buy Stop</option>
        <option value="sell-stop">Sell Stop</option>
        <option value="buy-limit">Buy Limit</option>
        <option value="sell-limit">Sell Limit</option>
        <option value="ask">Ask</option>
        <option value="bid">Bid</option>
      </select>
    
      <label for="volume">Volume:</label>
      <input type="number" v-model="volume" required />

      <label for="price">Price:</label>
      <input type="number" v-model="price" required />

      <label for="stopLoss">Stop Loss:</label>
      <input type="number" v-model="stopLoss" />

      <label for="takeProfit">Take Profit:</label>
      <input type="number" v-model="takeProfit" />

      <button type="submit">Place Order</button>
    </form>
    <div v-if="message">{{ message }}</div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      orderRequest: '',
      volume: 0,
      price: 0,
      stopLoss: null,
      takeProfit: null,
      message: '',
    };
  },
  methods: {
    async placeOrder() {
      try {
        const response = await fetch("/transactions/" + this.orderRequest.orderType, {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(this.orderRequest),
        });
        if (response.ok) {
          // Order placed successfully, update the order book
          this.updateOrderBook();
        } else {
          console.error("Failed to place order");
        }
      } catch (error) {
        console.error("Error placing order:", error);
      }
    },
    async updateOrderBook() {
      try {
        const response = await fetch("/transactions/updateOrderBook");
        if (response.ok) {
          const data = await response.json();
          this.orderBook = data;
        } else {
          console.error("Failed to update order book");
        }
      } catch (error) {
        console.error("Error updating order book:", error);
      }
    },
  },
  created() {
    // Fetch initial order book data
    this.updateOrderBook();
  },
};
</script>

<style scoped>
h1 {
  font-weight: 500;
  font-size: 2.6rem;
  position: relative;
  top: -10px;
}

h3 {
  font-size: 1.2rem;
}

.testing h1,
.testing h3 {
  text-align: center;
}

@media (min-width: 1024px) {
  .testing h1,
  .testing h3 {
    text-align: left;
  }
}
</style> -->
