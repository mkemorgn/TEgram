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
      <dir class="pic-info">
        <like-list :likes="photo.likes" /> &nbsp; &nbsp;
        <comment v-bind:comments="photo.comments" />
      </dir>
      <div class="card-body" id="idcard-body">
        <h5 class="card-title">{{ photo.description }}</h5>
        <p class="card-text">Posted By: {{ photo.userName }}</p>
        <like-manager />
        <rating
          v-for="r in photo.rating"
          v-bind:key="r"
          v-bind:rating="rating"
        />
        <CommentManager />
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
import Rating from "./Rating.vue";

export default {
  components: {
    LikeList,
    Comment,
    CommentManager,
    LikeManager,
    Rating,
  },

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
  },
};
</script>

<style>
/* do not revome this styles */
.comments {
  margin-top: 10px;
}
#feedbox {
  margin: 10px;
  max-width: 400px;
  box-shadow: 2px 2px 6px #2cb1eab9;
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
</style>
