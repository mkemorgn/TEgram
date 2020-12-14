<template>
    <div class="addcomment">
        <div>
            <form v-on:submit.prevent>
                <input class="form-control" id="newComment" type ="text" name="newComment" placeholder="add comment..."/>
                <b-button type="submit" class="btn" value="submit" v-on:click="submit">Submit</b-button>
            </form>
        </div>    
    </div>
</template>

<script>
import photoService from "@/services/PhotoService";
import PhotoFeed from "./PhotoFeed";
export default {
    components: {
        PhotoFeed,
    },
    data() {
        return {
            pictureId: null,
            comment: null,
        };
    },
    methods: {
        submit() {
             if (this.$store.state.token === '') {
                this.$modal.show('alert');
            } else {
                let comment = {
                    photoId: PhotoFeed.photo.photoId,
                    comment: this.newComment,
                }
        if (comment.contents !== '') {
          photoService.addComment(comment)
            .then(res => {
              if (res.status === 200) {
                this.comments.push(comment)
                this.newComment = '';
              }
            })
            .catch(err => {
                console.log(err);
            })
        }
    }
    }
    }
}
</script>