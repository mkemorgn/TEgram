<template>
  <div class="upload">
    <input type="file" @change="onFileSelected">
  </div>
</template>

<script>
export default {
    methods: {
        onFileSelected(event) {
            console.log(event)
        }
    }
}
</script>

<style>

</style>