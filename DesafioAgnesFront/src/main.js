// eslint-disable-next-line
import { createApp } from 'vue'
import App from './App.vue'
import router from './router';

// Importar o CSS do Bootstrap
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap-icons/font/bootstrap-icons.css';

import 'bootstrap/dist/js/bootstrap.bundle.min.js';


createApp(App).use(router).mount('#app')
