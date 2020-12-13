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
        <like-list :likes="photo.likes" />

        <div class="comments">
          <div
            class="card-text"
            id=":commentbox"
            v-for="comment in photo.comments"
            v-bind:key="comment"
          >
            <b-table-simple responsive outlined>
              <b-thead>
                <b-tr>
                  <b-th>{{ comment.byUser }}: {{ comment.comment }}</b-th>
                </b-tr>
              </b-thead>
            </b-table-simple>
          </div>
          <br />
          <b-input
            type="text"
            id="commentbox"
            placeholder="add comment..."
          ></b-input>
          <b-button>Submit</b-button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import PhotoService from "@/services/PhotoService";
import LikeList from "./LikeList.vue";
export default {
  components: { LikeList },
  name: "photo-feed",
  components: {
    
  },
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
<<<<<<< HEAD
/* do not revome this styles */
=======
.comments {
  margin-top: 10px;
}
>>>>>>>b4a42fc2e67f1c995eaf300893fb9b842320e8cf #feedbox {
  margin: 10px;
  max-width: 400px;
}
#image {
  height: 300px;
  width: 100%;
  object-fit: cover;
}
</style>
