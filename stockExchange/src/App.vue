<script>
import { RouterLink, RouterView } from 'vue-router'
import Testing2 from './components/Testing2.vue'
import { ref } from 'vue'

export default {
  setup() {
    const listUtils = {
      items: ref([
        { id: 0, title: 'Item A', list: 1 },
        { id: 1, title: 'Item B', list: 2 },
        { id: 2, title: 'Item C', list: 3 },
      ]),

      getList: (list) => {
        return listUtils.items.value.filter((item) => item.list == list);
      },
    };

    const startDrag = (event, item) => {
      console.log(item);
      event.dataTransfer.dropEffect = 'move';
      event.dataTransfer.effectAllowed = 'move';
      event.dataTransfer.setData('itemID', item.id);
    };

    const onDrop = (event, list) => {
      const itemID = event.dataTransfer.getData('itemID');
      const item = listUtils.items.value.find((item) => item.id == itemID);
      item.list = list;
    };

    // Add a new method to handle the `dragend` event
    const onDragEnd = (event) => {
      // Update the CSS class of the dragged element to remove the highlight
      event.target.classList.remove('dragging');
    };

    return {
      listUtils,
      startDrag,
      onDrop,
      onDragEnd,
    };
  },
};
</script>

<template>
  <div class = "Testing2">
    
  </div>
  <div class="drop-zone" 
  @drop="onDrop($event,1)"
  @dragenter.prevent
  @dragover.prevent
  >
    <div v-for="item in getList(1)" :key="item.id" class="drag-el" draggable="true">
    {{ item.title }}
    </div>

  </div>
  <div class="drop-zone" 
  @drop="onDrop($event,2)"
  @dragenter.prevent
  @dragover.prevent
  >   
   <div v-for="item in getList(2)" :key="item.id" class="drag-el" draggable="true" @dragstart="startDrag($event,item)">
    {{ item.title }}
    </div>
    </div>
    <div class="drop-zone" 
  @drop="onDrop($event,)"
  @dragenter.prevent
  @dragover.prevent
  >    <div v-for="item in getList(3)" :key="item.id" class="drag-el" draggable="true">
    {{ item.title }}
    </div>
  </div>
  <br>
  <div>
    <header>
      <img alt="Vue logo" class="logo" src="@/assets/logo.svg" width="125" height="125" />
      <!-- Apply the v-drag directive to the "trading" div -->
     <div class="dragDirective" v-drag style="position: relative;">
      <div class="trading"  >      
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
.v-drag {
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
header .StockInfo{
  display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
      width: auto;
  height: auto;
  margin: 120px;
  background-color: lightblue;
  padding:165px;
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
.drop-zone {
  width: 50%;
  margin:50px auto;
  background-color: #ecf0f1;
  padding: 10px;
  min-height: 10px;
}

.drag-el{
  background-color: #3498db;
  color: white;
  padding: 5px;
  margin-bottom: 10px;
}
</style>
