<template>
  <div>
    <button
      v-if="!liked"
      type="button"
      class="fas fa-star"
      @click="addLike(pictureId)"
    >
      Like <font-awesome-icon icon="thumbs-" />
    </button>
    <button
      v-else
      type="button"
      class="btn btn-primary btn-sm"
      @click="removeLike(pictureId)"
    >
      Unlike <font-awesome-icon icon="thumbs-down" />
    </button>
  </div>
</template>

<script>
import photoService from "@/services/PhotoService";

export default {
  props: ["likes", "pictureId"],
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
        this.liked = lks.find((l) => l.userId == this.$store.state.user.id);
      }
    },
    addLike(pictureId) {
      photoService
        .addLike(pictureId)
        .then((res) => {
          if (res.status === 201) {
            this.$store.commit("ADD_LIKE", res.data);
            this.isLiked(this.likes);
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    removeLike(pictureId) {
      photoService
        .removeLike(pictureId)
        .then((res) => {
          if (res.status === 204) {
            this.$store.commit("REMOVE_LIKE", pictureId);
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};
</script>