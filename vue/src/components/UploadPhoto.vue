<template>
  <div>
    <vue-dropzone
      id="dropzone"
      class="mt-3"
      v-bind:options="dropzoneOptions"
      v-on:vdropzone-sending="addFormData"
      v-on:vdropzone-success="getSuccess"
      :useCustomDropzoneOptions="true"
    ></vue-dropzone>
  </div>
</template>

<script>

</script>

<style>
.image-div {
    display: flex;
    margin: 25px;
}
.image {
    max-width: 250px;
    margin: 15px;
}
</style>