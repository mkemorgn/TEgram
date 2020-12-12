<template>
  <div>
    <div class="card" v-for="photo in this.$store.state.photos" v-bind:key="photo.photo_id">
      <img v-bind:src="photo.picUrl" v-bind:alt="photo.description" />
      <div class="container">
        <h4>
          <b class="description">{{ photo.description }}</b>
        </h4>
        <div class="details">
          <p class="username">Posted By: {{ photo.userId }}</p>
          <p class="date-posted">Date: {{ photo.date_added }}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import PhotoService from "@/services/PhotoService";
export default {
  name: "photo-feed",
  data() {
    return {

    };
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
  },
};
</script>

<style>
.card {
  margin: auto;
}
</style>