<template>
  <div class="user-posts">
    <p id="go-back" @click="$router.go(-1)">
      <font-awesome-icon icon="arrow-circle-left" />
    </p>
    <photo-feed
      v-bind:photos="this.$store.state.photos"
      v-bind:pageLoaded="this.pageLoaded"
    />
  </div>
</template>

<script>
import PhotoService from "@/services/PhotoService";
import PhotoFeed from "../components/PhotoFeed";

export default {
  name: "PhotoDetails",
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
      const userId = this.$route.params.userId;
      console.log("here " + userId);
      PhotoService.getPhotosByUserId(userId)
        .then((response) => {
          console.log("success");
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