<template>
  
</template>

<script>
import LikeList from "./LikeList.vue";
import Comment from "./Comment.vue";
import CommentManager from "./CommentManager";
import LikeManager from "./LikeManager.vue";
import RatingManager from "./RatingManager.vue"
import RateLists from "./RateLists.vue";
export default {
name: "photo-feed",
  props: ["photos", "pageLoaded"],

  components: {
    LikeList,
    Comment,
    CommentManager,
    LikeManager,
    RateLists,
    RatingManager
  },
}
</script>

<style>

</style>