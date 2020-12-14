<template>
  <div>
    <button
      v-if="!liked"
      type="button"
      class="btn btn-primary btn-sm"
      @click="addLike"
    >
      Like <font-awesome-icon icon="thumbs-up" />
    </button>
    <button v-else type="button" class="btn btn-primary btn-sm">
      Unlike <font-awesome-icon icon="thumbs-down" />
    </button>
  </div>
</template>

<script>
export default {
  props: ["likes"],
  data() {
    return {
      liked: false,
    };
  },
  created() {
    this.isLiked(this.likes);
  },

  methods: {
    isLiked(lks) {
      if (lks) {
        this.liked = lks.find(
          (l) => l.userId == this.$store.state.loggedUserId
        );
      }
    },
    addLike() {},
  },
};
</script>