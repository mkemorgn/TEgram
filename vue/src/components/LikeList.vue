<template>
  <div class="dropdown">
    <p class="dropbtn badge badge-pill badge-success">
      <font-awesome-icon icon="thumbs-up" />
      {{ likeCount(this.likes) }}
    </p>
    <div class="dropdown-content">
      <p
        class="dropdown-elements"
        v-for="like in likes"
        v-bind:key="like.likeId"
      >
        {{ like.byUser }}
      </p>
    </div>
  </div>
</template>

<script>
export default {
  props: ["likes"],
  methods: {
    likeCount(likes) {
      if (likes) {
        return likes.length;
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