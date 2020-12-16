<template>
<div id="favbtn2">
  <div>
    <button
      v-if="!favorited"
      type="button"
      class="btn btn-info btn-sm"
      @click="addFavorite(pictureId)"
    >
      Favorite <font-awesome-icon icon="heart" />
    </button>
    <button
      v-else
      type="button"
      class="btn btn-info btn-sm"
      @click="removeFavorite(pictureId)"
    >
      Unfavorite <font-awesome-icon icon="heart-broken" />
    </button>
  </div>
</div>
</template>

<script>
import photoService from "@/services/PhotoService";

export default {
  props: ["favorites", "pictureId"],
  data() {
    return {
      favorite: true,
    };
  },
  created() {
    this.isFavorited(this.favorites);
  },

  methods: {
    isFav(favs) {
      if (favs) {
        this.favorited = favs.find((f) => f.userId == this.$store.state.user.id);
      }
    },
    addFavorite(pictureId) {
      photoService
        .addFavorite(pictureId)
        .then((res) => {
          if (res.status === 201) {
            this.$store.commit("ADD_FAVORITE", res.data);
            this.isFavorited(this.favorites);
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    removeFavorite(pictureId) {
      photoService
        .removeFavorite(pictureId)
        .then((res) => {
          if (res.status === 204) {
            this.$store.commit("REMOVE_FAVORITE", pictureId);
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};
</script>