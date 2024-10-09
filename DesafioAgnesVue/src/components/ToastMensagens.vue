<template>
  <div class="toast-container position-fixed top-0 end-0 p-3" style="z-index: 11" aria-live="polite" aria-atomic="true">
    <div v-for="(toast, index) in toasts" :key="index" class="toast show align-items-center text-white"
         :class="{'bg-success': toast.type === 'success', 'bg-danger': toast.type === 'error'}"
         role="alert" aria-live="assertive" aria-atomic="true">
      <div class="d-flex">
        <div class="toast-body">{{ toast.message }}</div>
        <button type="button" class="btn-close btn-close-white me-2 m-auto" @click="removeToast(index)"></button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return { toasts: [] };
  },
  methods: {
    showToast(message, type) {
      this.toasts.push({ message, type });
      setTimeout(() => { this.toasts.shift(); }, 3000);
    },
    removeToast(index) { this.toasts.splice(index, 1); }
  }
};
</script>

<style scoped>
.toast-container { position: fixed; top: 1rem; right: 1rem; z-index: 9999; }
</style>
