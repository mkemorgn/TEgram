<template>
  <div>
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
  </div>
</template>

<script>
export default {
  props: ["likes"],
  data() {
    return {
      liked: false,
      currenUserId: this.$store.state.loggedUserId,
    };
  },
  created() {
    this.isLiked(this.likes);
  },

  methods: {
    isLiked(lks) {
      if (lks) {
        this.liked = lks.includes((l) => l.userId == currenUserId);
      }
    },
    addLike() {},
  },
};
</script>