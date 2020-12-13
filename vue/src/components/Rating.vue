<template>
  <div class="rating">
      <button
      v-if="rated"
      type="button"
      @click="addRating"
    >
      Add Rating <font-awesome-icon icon="star" />
    </button>
    <button v-else type="button" class="btn btn-primary btn-sm">
      Change Rating <font-awesome-icon icon="star-half-alt" />
    </button>
    <select id="rating" v-model.number="photo.rating">
          <option value="1">1 Star</option>
          <option value="2">2 Stars</option>
          <option value="3">3 Stars</option>
          <option value="4">4 Stars</option>
          <option value="5">5 Stars</option>
        </select>
    <p>Average Rating: {{ averageRating }}  </p>
  </div>    
</template>

<script>
export default {
  name: 'rating',
  props: ["rating"],
  data() {
    return {
      rated: false,
      ratingId: null
    }
  },
  methods: {
  addRating() {
      let sum = this.rating.reduce((currentSum, r) => {
        return currentSum + r;
      }, 0);
      return sum;
    },
},

      computed: {
    averageRating() {
      let sum = this.photo.reduce((currentSum, rating) => {
        return currentSum + rating;
      }, 0);
      return (sum / this.rating.length).toFixed(2);
    },

}
}

</script>

<style>

</style>