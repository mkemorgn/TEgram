<template>
  <div class="home">
    <home />
    <photo-feed />
    
  </div>
</template>

<script>
import Home from "../components/Home";
import PhotoFeed from "../components/PhotoFeed";
export default {
  components: {
    Home,
    PhotoFeed,
  }
};
</script>
