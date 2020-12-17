<template>
<div> Rating <font-awesome-icon icon="star-half-alt" />
  <select id="rating" @change="onChange(this.value)" class="dropdown-elements">
    
        <option value="1">1 Star</option>
        <option value="2">2 Stars</option>
        <option value="3">3 Stars</option>
        <option value="4">4 Stars</option>
        <option value="5">5 Stars</option>
</select>
    
        <!-- class="dropdown-elements">
        <select id="rating" v-model.number="photo.rating">
        <option value="1">1 Star</option>
        <option value="2">2 Stars</option>
        <option value="3">3 Stars</option>
        <option value="4">4 Stars</option>
        <option value="5">5 Stars</option>
      </select>
      > -->
      <!-- <label for="rating">Rating</label>
      <select id="rating" v-model.number="photo.rating">
        <option value="1">1 Star</option>
        <option value="2">2 Stars</option>
        <option value="3">3 Stars</option>
        <option value="4">4 Stars</option>
        <option value="5">5 Stars</option>
      </select> -->
    <!-- </button>
    <button
      v-else
      type="button"
      class="btn btn-primary btn-sm"
      @click="changeRating"
    >
      Change Rating <font-awesome-icon icon="star-half-alt" /> -->
      <!-- <label for="rating">Rating</label>
      <select id="rating" v-model.number="photo.rating">
        <option value="1">1 Star</option>
        <option value="2">2 Stars</option>
        <option value="3">3 Stars</option>
        <option value="4">4 Stars</option>
        <option value="5">5 Stars</option>
      </select> -->
    
  </div>
</template>

<script>
import photoService from "@/services/PhotoService";

export default {
  props: ["ratings", "pictureId"],
  data() {
    return {
      rated: false,
    };
  },
  created() {
    this.isRated(this.ratings);
  },

  methods: {
    isRated(rate) {
      if (rate) {
        this.rated = rate.find((r) => r.userId == this.$store.state.user.id);
      }
    },
    addRating(pictureId) {
      photoService
        .addRating(pictureId)
        .then((response) => {
          if (response.status === 200) {
            
            this.$router.push("/");
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    changeRating(pictureId) {
      photoService
        .changeRating(pictureId)
        .then((response) => {
          if (response.status === 200) {
            
            this.$router.push("/");
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>
