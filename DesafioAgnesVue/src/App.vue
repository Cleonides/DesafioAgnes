<!-- src/App.vue -->
<template>
    <div id="app">
        <Menu />
    </div>
</template>

<script>
import Menu from './components/Menu.vue'; // Importa o componente

export default {
    components: {
        Menu, // Registra o componente
    },
};
</script>

<style>
/* Estilos globais, se necessário */
</style>
