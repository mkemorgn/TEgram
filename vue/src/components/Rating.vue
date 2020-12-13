<template>
  <div class="rating">
      <button
      v-if="rated"
      type="button"
      @click="addRating"
    >
      Add Rating <font-awesome-icon icon="rating" />
    </button>
    <button v-else type="button" class="btn btn-primary btn-sm">
      Change Rating <font-awesome-icon icon="rating" />
    </button>
  </div>    
</template>

<script>
export default {

}
</script>

<style>

</style>