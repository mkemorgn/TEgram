<template>
<div>
    <photo-feed v-bind:photos="this.$store.state.photos"/>
    <comment/>
</div>  
</template>

<script>
import PhotoFeed from "./PhotoFeed.vue";
import Comment from "./Comment";
export default {
  components: { 
    PhotoFeed,
    Comment
  },
};
</script>


