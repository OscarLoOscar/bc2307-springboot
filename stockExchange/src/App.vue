<script setup>
import { RouterLink, RouterView } from 'vue-router'
import Testing2 from './components/Testing2.vue'

</script>

<template>
  <div>
    <header>
      <img alt="Vue logo" class="logo" src="@/assets/logo.svg" width="125" height="125" />
      <!-- Apply the v-drag directive to the "trading" div -->
     <div class="dragDirective" v-drag style="position: relative;">
      <div class="trading" >      
        <OneClickTrading msg="TESTing Trading class " />
        <Testing2 msg="Testing2" />
        </div>
        <nav>
          <RouterLink to="/">Home</RouterLink>
          <RouterLink to="/about">About</RouterLink>
        </nav>
      </div>
    </header>

    <RouterView />
  </div>
</template>

<style scoped>
.dragDirective {
  width: auto;
  height: auto;
  margin: 80px;
  background-color: lightblue;
  padding:65px;
  cursor: move; /* Optional: Change the cursor to indicate draggability */
  position: absolute; /* Ensure relative positioning for drag to work */

}

header {
  line-height: 1.5;
  max-height: 100vh;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

nav {
  width: 100%;
  font-size: 12px;
  text-align: center;
  margin-top: 2rem;
}

nav a.router-link-exact-active {
  color: var(--color-text);
}

nav a.router-link-exact-active:hover {
  background-color: transparent;
}

nav a {
  display: inline-block;
  padding: 0 1rem;
  border-left: 1px solid var(--color-border);
}

nav a:first-of-type {
  border: 0;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .trading {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
      width: auto;
  height: auto;
  margin: 80px;
  background-color: lightblue;
  padding:65px;
  cursor: move; /* Optional: Change the cursor to indicate draggability */
  position: absolute; /* Ensure relative positioning for drag to work */

  }

  nav {
    text-align: left;
    margin-left: -1rem;
    font-size: 1rem;

    padding: 1rem 0;
    margin-top: 1rem;
  }
}
</style>
