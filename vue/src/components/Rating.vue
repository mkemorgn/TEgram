<template>
  <div class="rating">
      <button
      v-if="rated"
      type="button"
      @click="addRating"
    >
      Add Rating <font-awesome-icon icon="rating" />
    </button>
  </div>    
</template>

<script>
export default {

}
</script>

<style>

</style>