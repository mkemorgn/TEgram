<template>
  <div id="favbtn2">
    <div v-if="isUsersPic">
      <a v-if="!favorited" @click="editFavorite(photo)"
        >&nbsp;<font-awesome-icon :icon="['far', 'heart']" />&nbsp;
      </a>
      <a v-else @click="editFavorite(photo)"
        >&nbsp;<font-awesome-icon :icon="['fas', 'heart']" />&nbsp;
      </a>
    </div>
  </div>
</template>

<script>
import photoService from "@/services/PhotoService";

export default {
  props: ["photo"],
  data() {
    return {
      favorited: this.photo.favorite,
      isUsersPic: this.photo.userId == this.$store.state.user.id,
    };
  },
  // created() {
  //   this.isFavorited(this.favorites);
  // },

  methods: {
    // isFav(fvs) {
    //   if (fvs) {
    //     this.favorited = favs.find(
    //       (f) => f.userId == this.$store.state.user.id
    //     );
    //   }
    // },
    editFavorite(photo) {
      photo.favorite = !photo.favorite;
      photoService
        .editFavorite(photo)
        .then((res) => {
          if (res.status === 201) {
            this.$store.commit("EDIT_FAVORITE", res.data);
            this.favorited = this.photo.favorite;
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};
</script>

<style >
#favbtn2 {
  position: absolute;
  top: 5px;
  right: 5px;
  border: 1px solid gold;
  border-radius: 20px;
  font-size: 13pt;
  color: gold;
}

#favbtn2:hover {
  -webkit-filter: drop-shadow(5px 5px 5px rgba(34, 34, 34, 0.904));
  filter: drop-shadow(5px 5px 5px rgba(34, 34, 34, 0.959));
  transform: scale(1.2, 1.2);
}
</style>