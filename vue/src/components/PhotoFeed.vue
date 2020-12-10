
<template>
  <div>
    <div class="card" v-for="photo in this.$store.state.photos" v-bind:key="photo.photo_id">
      <img class="cardImg" v-bind:src="photo.photo_url" v-bind:alt="photo.description" />
      <div class="container">
        
        <img
          class="favBtn"
          v-on:click="toggleLike(photo.id)"
          v-bind:src="require('../assets/' + getLikeImg(photo.id))"
          alt="Like image"
        />
        <h4>
          <b class="description">{{ photo.description }}</b>
        </h4>
        <div class="details">
          <p class="username">Posted By: {{ photo.username }}</p>
          <p class="date-posted">Date: {{ photo.date_added }}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Photo from "@/services/Photo";
export default {
    name: "photo-feed",
    data() {
        return {
            like: false,
        };
    },
    created() {
        this.retrievePhotos();
    },
    methods: {
       retrievePhotos() {
        Photo.getPhotos()
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
    }
}
}
</script>

<style scoped>
.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  transition: 0.3s;
  border-radius: 5px;
  height: 614px;
  width: 700px;
  margin-bottom: 50px;
  background-color: white;
}
.card:hover {
  box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
}
.cardImg {
  border-radius: 5px 5px 0 0;
  margin: auto;
  height: 75%;
  width: 100%;
}
.favBtn {
  height: 32px;
  width: 32px;
  padding: 2px 16px;
}
.details {
  background-color: rgba(0, 120, 163, 0.1);
  padding: 2px 16px;
  margin-top: -4px;
}
.description {
  padding: 2px 16px;
  font-size: x-large;
}
.details {
  background-color: white;
  
}
.username {
  font-size: larger;
}
.date-posted {
  font-size: 18px;
}
</style>