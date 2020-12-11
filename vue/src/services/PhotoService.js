import axios from 'axios';



export default {

    uploadPhoto(formData) {
        return axios.post('/upload', formData);
    },
    getUserPhotos() {
        return axios.get('/photos');
    },
    getUserFav(favoriteId) {
        return axios.get(`/photos/${favoriteId}`);
    },
    getAllPhotos() {
        return axios.get('/');
    }
}