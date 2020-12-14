<template>
  <div class="dropdown">
    <p class="dropbtn badge badge-pill badge-success">
      <font-awesome-icon icon="star" /> {{ averageRating(this.ratings) }}
    </p>
    <div class="dropdown-content">
      <p
        class="dropdown-elements"
        v-for="rating in ratings"
        v-bind:key="rating"
      >
        {{ rating.byUser }} rated: {{ rating.rating }}
        <font-awesome-icon icon="star" />
      </p>
    </div>
  </div>
</template>


<script>
export default {
  props: ["ratings"],
  methods: {
    averageRating(ratings) {
      let sum = 0;
      let avg = 0;
      if (ratings) {
        ratings.forEach((rate) => {
          sum = sum + rate.rating;
        });
        avg = (sum / ratings.length).toFixed(2);
      }
      return avg;
    },
  },
};
</script>

<style>
@import "../../style/dropdownStyle.css";
</style>