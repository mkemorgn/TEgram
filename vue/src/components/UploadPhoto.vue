<template>
  <div class="card" style="max-width: 700px">
    <div v-if="!uploading" class="form-group">
      <h1>Upload Photos</h1>
      <div>
        <input class="form-control-file" type="file" @change="onFileSelected" />
      </div>
      <div id="preview" v-if="url">
        <img :src="url" />
      </div>

      <div>
        <input
          class="form-control-plaintext"
          type="text"
          name="desc"
          v-model="description"
          placeholder="Add description"
        />
      </div>
      <div>
        <div class="form-check-inline">
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
        <div class="form-check-inline">
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
      </div>

      <div class="btn-group">
        <button class="btn btn-primary" @click="onUpload">Upload</button>
        <button class="btn btn-danger" @click="cancelUpload">Cancel</button>
      </div>
    </div>
    <button v-else class="btn btn-primary" disabled>
      <span class="spinner-border spinner-border-sm"></span>
      Uploading...
    </button>
  </div>
</template>

<script>
import photoService from "@/services/PhotoService";

export default {
  data() {
    return {
      uploading: false,
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
      this.uploading = true;
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
/* do not revome this styles */
#preview {
  margin-top: 10px;
  padding: 15px;
  background-color: #2cb1eaa7;
  border-radius: 5px;
  max-width: 300px;
}
#preview img {
  max-width: 100%;
  border-radius: 5px;
}
</style>
