import axios from 'axios';




export default {

    uploadPhoto(formData) {
        return axios.post('/upload', formData);
    },
    submitComment(comment) {
        return axios.post('/comment', {
            photoId: comment.photoId,
            comment: comment.comment
        });
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