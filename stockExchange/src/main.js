import './assets/main.css';
import { createApp } from 'vue'; // Import createApp from Vue 3
import App from './App.vue';
import dragDirective from './components/dragDirective';
import router from './router';

const app = createApp(App);
// const dragDirective = createApp(dragDirective);
app.config.productionTip = false;
app.directive('drag', dragDirective);
app.use(router); // Use the Vue Router
app.use(dragDirective);
app.mount('#app');
