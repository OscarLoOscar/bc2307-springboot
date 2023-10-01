<template>
<img alt="Vlab_logo" src="./assets/Vlab-logo.png" width="600" height="80" style="margin: 0 auto;">
  <br>
  <img alt="VenturenixLAB" src="./assets/VenturenixLAB.png" width="200" height="200" style="margin: 0 auto;">
  <!-- <HelloWorld msg="Welcome to Your Vue.js App"/> -->
  <div>
    <atAuctionOrders stock-id="TSLA"/>
  </div>
</template>

<script>
// import HelloWorld from './components/HelloWorld.vue'
import atAuctionOrders from './components/atAuctionOrders.vue';

export default {
  name: 'App',
  components: {//記住template 入面都要有
    // HelloWorld,
    atAuctionOrders,
 }
}
</script>
<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>

