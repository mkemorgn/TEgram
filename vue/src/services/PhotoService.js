import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
});


export default {

    uploadPhoto(formData) {
        return http.post('/upload', formData);
    },
    getUserPhotos() {
        return http.get('/photos');
    },
    getUserFav(favoriteId) {
        return http.get(`/photos/${favoriteId}`);
    },
    getPhotos() {
        return http.get('/');
    },
}