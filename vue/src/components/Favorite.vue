<template>
  <div id="favbtn">
    <div class="dropdown">
      <p class="dropbtn badge badge-pill badge-info">
        <font-awesome-icon :icon="['far', 'heart']" />
        {{ favCount(this.favorites) }}
      </p>
      <div class="dropdown-content">
        <p
          class="dropdown-elements"
          v-for="favorite in favorites"
          v-bind:key="favorite.favoriteId"
        >
          {{ favorite.byUser }}
        </p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: ["favorites"],
  methods: {
    favCount(favorites) {
      if (favorites) {
        return favorites.length;
      } else {
        return 0;
      }
    },
  },
};
</script>

<style>
@import "../../style/dropdownStyle.css";
</style>