<template>
  <photo-feed v-bind:photos="this.$store.state.photos"/> 
</template>

<script>
import FavoritesFeed from "./FavoritesFeed.vue";
export default {
  components: { 
    FavoritesFeed,
  },
};
</script>