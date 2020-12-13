<<<<<<< HEAD
<<<<<<< HEAD
<template>
  <div class="background">
    <div class="home">
      <div class="header">
        <!-- Logo -->
        <!-- <router-link v-bind:to="{ name: 'home' }">
          <img id="logo" src="../assets/TeGram-logo.png" alt="TE-Gram Logo" />
        </router-link> -->
        <!-- End Logo -->

        <!-- Navbar icons -->

        <!-- End nav --> 

        <!-- End nav --> 
      </div>
    </div>
  </div>
</template>
=======
<template><photo-feed /></template>
=======
<template>
  <photo-feed v-bind:photos="this.$store.state.photos"/> 
</template>
>>>>>>> 863e7caba969072ce3213b560137d23b892e429b

<script>
import PhotoFeed from "./PhotoFeed.vue";
export default {
  components: { 
    PhotoFeed,
  },
};
</script>
>>>>>>> f5f7e07a48cdc6394be0d9960864dfbdacfa876a


