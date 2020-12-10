<template>
  <div class="upload">
    <h1>Upload Photos</h1>
    <p>Upload photos here.</p>
    <input type="file" @change="onFileSelected">
    <button @click="onUpload">Upload</button>
  </div>
</template>

<script>
import axios from 'axios'
export default {
    data() {
        return {
            selectedFile: null
        }
    },
    methods: {
        onFileSelected(event) {
            this.selectedFile = event.target.files[0]
        },
        onUpload() {
            const fd = new FormData();
            fd.append('image', this.selectedFile, this.selectedFile.name)
             axios.post('http://127.0.0.1:8080/upload', fd)
                .then(res => {
                    console.log(res)
                })
        }
    }
}
</script>