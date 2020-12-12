<template>
  <div class="form-group" id="upload">
    <h1>Upload Photos</h1>
    <div>
      <input class="form-control-file" type="file" @change="onFileSelected" />
    </div>
    <div id="preview" v-if="url">
      <img :src="url" />
    </div>

    <div>
      <input
        id="description"
        type="text"
        name="desc"
        v-model="description"
        placeholder="Add description"
      />
    </div>
    <div class="form-check">
      <label class="form-check-label" for="public">
        <input
          class="form-check-input"
          id="public"
          type="radio"
          name="isPrivate"
          value="false"
          checked
          v-model="isPrivate"
        />Public</label
      >
    </div>
    <div class="form-check">
      <label class="form-check-label" for="private"
        ><input
          class="form-check-input"
          id="private"
          type="radio"
          name="isPrivate"
          value="true"
          v-model="isPrivate"
        />Private</label
      >
    </div>
    <div class="btn-group">
      <button class="btn btn-success" @click="onUpload">Upload</button>
      <button class="btn btn-success" @click="cancelUpload">Cancel</button>
    </div>
  </div>
</template>

<script>
import photoService from "@/services/PhotoService";

export default {
  data() {
    return {
      url: null,
      selectedFile: null,
      description: null,
      isPrivate: false,
    };
  },
  methods: {
    onFileSelected(event) {
      this.selectedFile = event.target.files[0];
      this.url = URL.createObjectURL(this.selectedFile);
    },
    onUpload() {
      const fd = new FormData();
      if (this.selectedFile) fd.append("file", this.selectedFile);
      if (this.description) fd.append("desc", this.description);
      fd.append("isPrivate", this.isPrivate);
      photoService
        .uploadPhoto(fd)
        .then((res) => {
          if (res.status === 201) {
            this.$router.push("/");
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    cancelUpload() {
      this.url = null;
      this.selectedFile = null;
      this.description = null;
      this.isPrivate = false;
      this.$router.push("/");
    },
  },
};
</script>
<style >
/* #upload {
  margin: 10px;
}

#preview {
  margin-top: 10px;
  padding: 15px;
  background-color: rgba(44, 142, 233, 0.486);
  border-radius: 5px;
  max-width: 300px;
}
#preview img {
  max-width: 100%;
  border-radius: 5px;
}
#description {
  margin-top: 5px;
  margin-bottom: 5px;
} */
</style>