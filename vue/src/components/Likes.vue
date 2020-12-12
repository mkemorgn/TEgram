<template>
  <div id="likes">
    <div @change="addLike">
      Add Like
      <img src="../assets/thumbsUp.png" />
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      likeId: null,
      count: null,
    };
  },

  methods: {
    addLike() {
      let sum = this.likes.reduce((currentSum, like) => {
        return currentSum + like;
      }, 0);
      return sum;
    },
    removeLike() {
      let sum = this.likes.reduce((currentSum, like) => {
        return currentSum - like;
      }, 0);
      return sum;
    },
    }
  };

</script>

<style>
</style>