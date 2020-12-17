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
    getUserPhotos() {
        return axios.get('/photos');
    },
    getPhotos() {
        return axios.get('/');
    },
    getPhotoDetails(pictureId) {
        return axios.get(`/details/${pictureId}`);
    },
    addLike(pictureId) {
        return axios.post(`/like/${pictureId}`);

    },
    removeLike(pictureId) {
        return axios.delete(`/rlike/${pictureId}`);

    },
    getPhotosByUserId(userId) {
        return axios.get(`/users/${userId}`);
    },
    editFavorite(photo) {
        return axios.put("/editfav", photo)
    },
    addRating(rating) {
        return axios.post('/rate', rating);
    },
    editRating(rating) {
        return axios.put('/editrate', rating);
    },

}