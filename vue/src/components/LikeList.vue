<template>
  <div class="d-flex justify-content-between">
    <button
      v-if="liked"
      type="button"
      class="btn btn-primary btn-sm"
      @click="addLike"
    >
      Like <font-awesome-icon icon="thumbs-up" />
    </button>
    <button v-else type="button" class="btn btn-primary btn-sm">
      Unlike <font-awesome-icon icon="thumbs-down" />
    </button>
    <p class="badge badge-pill badge-success">
      Total Likes <font-awesome-icon icon="thumbs-up" />
      {{ likeCount(this.likes) }}
    </p>
    <ul class="list-group">
      <li class="list-group-item" v-for="like in likes" v-bind:key="like">
        {{ like.byUser }}
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  props: ["likes"],
  data() {
    return {
      liked: true,
      likeId: null,
      count: null,
    };
  },

  methods: {
    likeCount(likes) {
      if (likes) {
        return likes.length;
      } else {
        return 0;
      }
    },
    addLike() {
      let sum = this.likes.reduce((currentSum, like) => {
        return currentSum + like;
      }, 0);
      return sum;
    },
  },
};
</script>

<style>
</style>