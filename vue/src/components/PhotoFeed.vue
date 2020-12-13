<template>
  <div class="d-flex flex-wrap">
    <div
      class="card"
      id="feedbox"
      v-for="photo in photos"
      v-bind:key="photo.pictureId"
    >
      <img
        class="card-img-top"
        id="image"
        v-bind:src="photo.picUrl"
        v-bind:alt="photo.picName"
      />
      <div class="card-body">
        <h4 class="card-title">{{ photo.description }}</h4>
        <p class="card-text">Posted By: {{ photo.userName }}</p>
        <span class="badge badge-pill badge-primary"
          >Likes {{ likeCount(photo) }}</span
        >

        <!-- <p class="card-text">Comment: {{ photo.comments }}</p> -->
      </div>
    </div>
  </div>
</template>

<script>
import PhotoService from "@/services/PhotoService";
export default {
  name: "photo-feed",
  props: ["photos"],
  data() {
    return {};
  },
  created() {
    this.retrievePhotos();
  },
  methods: {
    toggleLike(id) {
      if (this.isFavoritePhoto(id)) {
        this.removeFromFavorites(id);
      } else {
        this.addToFavorites(id);
      }
    },
    retrievePhotos() {
      PhotoService.getPhotos()
        .then((response) => {
          this.$store.commit("SET_PHOTOS", response.data);
        })
        .catch((error) => {
          if (error.response) {
            this.errorMsg =
              "Error. Response received was '" +
              error.response.statusText +
              "'.";
          } else if (error.request) {
            this.errorMsg = "Error. Server could not be reached.";
          } else {
            this.errorMsg = "Error. Request could not be created.";
          }
        });
    },
    likeCount(photo) {
      if (photo.likes) {
        return photo.likes.length;
      } else {
        return 0;
      }
    },
  },
};
</script>

<style>
#feedbox {
  margin: 10px;
  max-width: 400px;
}
#image {
  min-height: 300px;
  max-height: 350px;
  width: auto;
}
/* .main {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-template-areas:
    ".    .       .          ."
    ". main-cards main-login ."
    ". footer     footer     .";
  grid-gap: 12px;
  margin-top: 50px;
}
.main #login {
  grid-area: main-login;
}
.card-container {
  grid-area: main-cards;
}
#login form h1 {
  font: 25px;
  text-align: center;
}
.card {
  margin: auto;
} */
</style>