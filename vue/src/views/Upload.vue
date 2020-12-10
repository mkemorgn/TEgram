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
import store from '../store/index.js'
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
            fd.append('file', store.currentUser, this.selectedFile, this.selectedFile.name)
            axios({
                method: 'post',
                url: 'http://localhost:8080/upload',
                data: fd,
                headers: {'Content-Type': 'multipart/form-data' }
            })
            .then(res => {
                //handle success
                console.log(res);
            })
            .catch(res => {
                console.log(res);
            });
        }
    }
}
</script>