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
import vue2Dropzone from 'vue2-dropzone';
import "vue2-dropzone/dist/vue2Dropzone.min.css";
require('dotenv').config()

export default {
    components: {
        vueDropzone: vue2Dropzone
    },
    data() {
       return {
           dropzoneOptions: {
               url: "CLOUDINARY_URL=cloudinary://161245727836791:LoV1DETf3UEmK_HExvX7R6icYDM@dzidymehh",
               thumbnailWidth: 150,
               thumbnailHeight: 150,
               maxFilesize: 5.0,
               acceptedFiles: ".jpg, .jpeg, .png, .gif",
               uploadMultiple: false,
               addRemoveLinks: true,
               dictDefaultMessage: `<p class='text-default'><i class='fa fa-cloud-upload mr-2'></i> Drag Images or Click Here</p>
          <p class="form-text">Allowed Files: .jpg, .jpeg, .png, .gif</p>`
           },
           images: []
       };
    },
    methods: {
        addFormData(file, xhr, formData) {
            formData.append("api_key", "process.env.VUE_APP_CLOUDINARY_API_KEY");
            formData.append("uplod_preset",);
            formData.append("timestamp", (Date.now() / 1000) | 0);
            formData.append("tags", "vue-app");
        },
        getSuccess(file, response) {
            const imgUrl = response.secure_url; //stores url for image
            this.$emit("image-upload", imgUrl);
        },
    },
};
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