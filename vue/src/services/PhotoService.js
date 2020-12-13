import axios from 'axios';




export default {

    uploadPhoto(formData) {
        return axios.post('/upload', formData);
    },
    submitComment(formData) {
        return axios.post('/comment', formData);
    },
    rating(formData) {
        return axios.post('/rating', formData);
    },
    getUserPhotos() {
        return axios.get('/photos');
    },
    getUserFav(favoriteId) {
        return axios.get(`/photos/${favoriteId}`);
    },
    getPhotos() {
        return axios.get('/');
    },
}