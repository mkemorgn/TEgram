<template>
    <div class="addcomment">
        <div>
            <form v-on:submit.prevent>
                <input v-model="comments" class="form-control" id="newComment" type ="text" name="newComment" placeholder="add comment..."/>
                <b-button type="submit" class="btn" value="submit" v-on:click="submit">Submit</b-button>
            </form>
        </div>    
    </div>
</template>

<script>
import photoService from "@/services/PhotoService";
import PhotoFeed from './PhotoFeed';
export default {
    props: ["pictureId"],
    components: {       
    },
    data() {
        return {
            comment: '',
                   
        };
    },
    methods: {        
        submit() {
            console.log(this.pictureId)
            console.log(this.comments)
            const theComment = {
                comment: this.comments,
                pictureId: this.pictureId
            };
            photoService.submitComment(theComment)
            .then(response => {
                PhotoFeed.forceRerender()//method to re render page after comment is posted
                if (response.status == 201) {
                    this.$router.push("/");
                }
            })
            .catch((err) => {
            console.log(err);
        });
        }
    }
}
</script>