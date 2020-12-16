<template>
  <div>
    <button
      v-if="!liked"
      type="button"
      class="btn btn-primary btn-sm"
      @click="addLike(pictureId)"
    >
      Like <font-awesome-icon :icon="['far', 'thumbs-up']" />
    </button>
    <button
      v-else
      type="button"
      class="btn btn-primary btn-sm"
      @click="removeLike(pictureId)"
    >
      Unlike <font-awesome-icon :icon="['far', 'thumbs-down']" />
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
      if (lks && lks.length > 0) {
        this.liked = lks.find((l) => l.userId == this.$store.state.user.id);
      }
    },
    addLike(pictureId) {
      photoService
        .addLike(pictureId)
        .then((res) => {
          if (res.status === 201) {
            this.$store.commit("ADD_LIKE", res.data);
            this.liked = true;
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
            this.liked = false;
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};
</script>