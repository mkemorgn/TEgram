<template>
  <div>
    <div v-if="!pageLoaded" id="loading">
      <p>
        <span class="spinner-grow text-primary"></span> &nbsp;
        <span class="spinner-grow text-success"></span>&nbsp;
        <span class="spinner-grow text-danger"></span>&nbsp;
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
        <router-link
          v-bind:to="{
            name: 'photo-detail',
            params: { pictureId: photo.pictureId },
          }"
        >
          <img
            class="card-img-top"
            id="image"
            v-bind:src="photo.picUrl"
            v-bind:alt="photo.picName"
          />
        </router-link>
        <div class="pic-info">
          <rate-lists v-bind:ratings="photo.ratings" /> &nbsp; &nbsp;
          <like-list v-bind:likes="photo.likes" /> &nbsp; &nbsp;
          <comment v-bind:comments="photo.comments" />
        </div>
        <div class="card-body">
          <div style="heigth: 30px">
            <h5 class="card-title">{{ photo.description }}</h5>
          </div>
          <router-link
            v-bind:to="{ name: 'user-posts', params: { userId: photo.userId } }"
          >
            <p class="card-text">Posted By: {{ photo.userName }}</p>
<<<<<<< HEAD
          </router-link>  
          <like-manager
            v-bind:likes="photo.likes"
            v-bind:pictureId="photo.pictureId"
          />
          <comment-list v-bind:comments="photo.comments"/>
          <comment-manager v-bind:pictureId="photo.pictureId" />
          <rating-manager
            v-bind:ratings="photo.ratings"
            v-bind:pictureId="photo.pictureId"
          />
          <details v-bind:pictureId="photo.pictureId"/>
||||||| merged common ancestors
          </router-link>  
          <like-manager
            v-bind:likes="photo.likes"
            v-bind:pictureId="photo.pictureId"
          />
          <comment-manager v-bind:pictureId="photo.pictureId" />
          <rating-manager
            v-bind:ratings="photo.ratings"
            v-bind:pictureId="photo.pictureId"
          />
          <details v-bind:pictureId="photo.pictureId"/>
=======
          </router-link>
          <div v-if="$store.state.token != ''" id="piccard-edits">
            <like-manager
              v-bind:likes="photo.likes"
              v-bind:pictureId="photo.pictureId"
            />
            <comment-manager v-bind:pictureId="photo.pictureId" />
            <rating-manager
              v-bind:ratings="photo.ratings"
              v-bind:pictureId="photo.pictureId"
            />
          </div>
          <details v-bind:pictureId="photo.pictureId" />
>>>>>>> 60b394d01e56e01b68c830feb8618084fd91ba1e
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import LikeList from "./LikeList.vue";
import Comment from "./Comment.vue";
import CommentManager from "./CommentManager";
import LikeManager from "./LikeManager.vue";
import RatingManager from "./RatingManager.vue";
import RateLists from "./RateLists.vue";
import CommentList from "./CommentList.vue";


export default {
  name: "photo-feed",
  props: ["photos", "pageLoaded"],

  components: {
    LikeList,
    Comment,
    CommentManager,
    LikeManager,
    RateLists,
    RatingManager,
<<<<<<< HEAD

    CommentList

||||||| merged common ancestors
    
=======
>>>>>>> 60b394d01e56e01b68c830feb8618084fd91ba1e
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
#piccard-edits > * {
  margin-bottom: 5px;
  margin-top: 5px;
}
#loading {
  margin-top: auto;
  margin-bottom: auto;
  text-align: center;
}
</style>
