<template>
  <photo-feed
    v-bind:photos="this.$store.state.photos"
    v-bind:pageLoaded="this.pageLoaded"
  />
</template>

<script>
import PhotoService from "@/services/PhotoService";
import PhotoFeed from "../components/PhotoFeed";


export default {
  name: "homeview",
  components: {
    PhotoFeed,
  },
  data() {
    return {
      pageLoaded: false,
    };
  },
  created() {
    this.retrievePhotos();
  },
  methods: {
    retrievePhotos() {
      PhotoService.getPhotos()
        .then((response) => {
          this.$store.commit("SET_PHOTOS", response.data);
          this.pageLoaded = true;
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
