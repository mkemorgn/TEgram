<template>
  <div>
    <div v-if="!pageLoaded" id="loading">
      <p>
        <span class="spinner-grow text-primary"></span> &nbsp;
        <span class="spinner-grow text-success"></span>&nbsp;
        <span class="spinner-grow text-secondary"></span>&nbsp;
        <span>Loading...</span>
      </p>
    </div>
    <div v-else class="d-flex flex-wrap justify-content-center">
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
        <div class="pic-info">
          <rate-lists v-bind:ratings="photo.ratings" /> &nbsp; &nbsp;
          <like-list v-bind:likes="photo.likes" /> &nbsp; &nbsp;
          <comment v-bind:comments="photo.comments" />
        </div>
        <div class="card-body" id="idcard-body">
          <h5 class="card-title">{{ photo.description }}</h5>
          <p class="card-text">Posted By: {{ photo.userName }}</p>
          <like-manager />

          <CommentManager />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import PhotoService from "@/services/PhotoService";
import LikeList from "./LikeList.vue";
import Comment from "./Comment.vue";
import CommentManager from "./CommentManager";
import LikeManager from "./LikeManager.vue";
import RateLists from "./RateLists.vue";

export default {
  name: "photo-feed",
  props: ["photos"],

  components: {
    LikeList,
    Comment,
    CommentManager,
    LikeManager,
    RateLists,
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

<style>
/* do not revome this styles */

#feedbox {
  margin: 10px;
  max-width: 400px;
  box-shadow: 2px 2px 6px #2cb1eab9;
  padding: 0px;
}
#image {
  height: 300px;
  width: 100%;
  object-fit: cover;
}
.card-text {
  font-size: 8pt;
}
.pic-info {
  display: inline-flex;
  justify-content: flex-end;
  margin: 3px 10px;
}
#idcard-body > * {
  margin-bottom: 5px;
}
#loading {
  margin-top: auto;
  margin-bottom: auto;
  text-align: center;
}
</style>
