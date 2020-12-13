<template>
  <photo-feed v-bind:photos="this.$store.state.photos"/> 
</template>

<script>
import PhotoFeed from "./PhotoFeed.vue";
export default {
  components: { 
    PhotoFeed,
  },
};
</script>
