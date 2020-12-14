<template>
  <div class="dropdown">
    <p class="dropbtn badge badge-pill badge-success">
      <font-awesome-icon icon="comments" />
      {{ commentCount(this.comments) }}
    </p>
    <div class="dropdown-content">
      <p
        class="dropdown-elements"
        v-for="comment in comments"
        v-bind:key="comment"
      >
        <i @click="deleteComment"><font-awesome-icon icon="comment-slash" /></i>
        {{ comment.byUser }}: {{ comment.comment }}
      </p>
    </div>
  </div>
</template>

<script>
export default {
  props: ["comments"],

  methods: {
    commentCount(comments) {
      if (comments) {
        return comments.length;
      } else {
        return 0;
      }
    },
    deleteComment() {},
  },
};
</script>


<style>
@import "../../style/dropdownStyle.css";
</style>