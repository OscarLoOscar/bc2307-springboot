import './assets/main.css';
import { createApp } from 'vue'; // Import createApp from Vue 3
import App from './App.vue';
import drag from './components/drag';
import router from './router';

const app = createApp(App);
// const dragDirective = createApp(dragDirective);
app.config.productionTip = false;
app.directive('drag', drag);
app.use(router); // Use the Vue Router
app.use(dragDirective);
app.mount('#app');
