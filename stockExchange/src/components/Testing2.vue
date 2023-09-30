<template>
  <div class="testing">
    <h1>Stock Exchange System</h1>
    <!-- Order Form -->
    <form @submit.prevent="placeOrder">
      <label for="orderType">類型 Order Type : </label>
      <select v-model="orderRequest.orderType">
        <option value="buy-stop">Buy Stop</option>
        <option value="sell-stop">Sell Stop</option>
        <option value="buy-limit">Buy Limit</option>
        <option value="sell-limit">Sell Limit</option>
        <option value="ask">Ask</option>
        <option value="bid">Bid</option>
      </select>
      <br> <!-- 隔行用-->
      <label for="Symbol">代碼 Symbol : </label>
      <input type="Symbol" v-model="orderRequest.Symbol" required>
      <br>
      <label for="price">價格 Price : </label>
      <button @click="decreasePrice">-</button>
      <input type="price" v-model="orderRequest.price">
      <button @click="increasePrice">+</button>
      <br>
      <label for="size">數量 Size : </label>
      <button @click="decreaseSize">-</button>
      <input type="size" v-model="orderRequest.size">
      <button @click="increaseSize">+</button>
      <br>
      <br>
      <br>
      <button type="submit">Place Order</button>
    </form>

    <!-- Order Book -->
    <!-- <h2>Order Book</h2>
    <ul>
      <li v-for="order in orderBook" :key="order.id">
        {{ order.orderType }} - Size: {{ order.size }} - Item: {{ order.item }} - Price: {{ order.price }}
      </li>
    </ul> 
   <div id="zline" :style="{width: '100vw',height: '7rem'}"></div> -->
  </div>
</template>

<script>
import dragDirective from './drag'; // Import the dragDirective
export default {
  directives: {
    drag: dragDirective, // Register the drag directive
  },
  data() {
    return {
      orderRequest: {
        orderType: "",
        Symbol: "00700",
        size: 100,
        price: "",
        item: "",
      },
      orderBook: [],
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
    increaseSize() {
      // Increase the size by 1 when the + button is clicked
      this.orderRequest.size++;
    },
    decreaseSize() {
      // Decrease the size by 1 when the - button is clicked
      if (this.orderRequest.size > 0) {
        this.orderRequest.size--;
      }
    },
    increasePrice() {
      // Increase the price by 1 when the + button is clicked
      this.orderRequest.price++;
    },
    decreasePrice() {
      // Decrease the price by 1 when the - button is clicked
      if (this.orderRequest.price > 0) {
        this.orderRequest.price--;
      }
    },
  },
  created() {
    // Fetch initial order book data
    this.updateOrderBook();
  },
};
</script>
