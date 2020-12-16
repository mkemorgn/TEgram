import axios from 'axios';




export default {

    uploadPhoto(formData) {
        return axios.post('/upload', formData);
    },
    submitComment(comment) {
        return axios.post('/comment', comment);
    },
    deleteComment(comment) {
        return axios.delete(`/comment/${comment.commentId}`);
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
    addLike(pictureId) {
        return axios.post(`/like/${pictureId}`)

    },
    removeLike(pictureId) {
        return axios.delete(`/rlike/${pictureId}`)

    },
    addFavorite(pictureId) {
        return axios.post(`/favorite/${pictureId}`)

    },
    removeFavorite(pictureId) {
        return axios.delete(`/rfavorite/${pictureId}`)
    },
}