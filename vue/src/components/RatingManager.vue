<template>
  <div>
    <button v-if="rated" type="button" @click="addRating">
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
  </div>
</template>

<script>
export default {
  props: ["ratings"],
  data() {
    return {
      rated: false,
      ratingId: null,
    };
  },
  methods: {
    addRating() {},
  },
};
</script>

<style>
</style>