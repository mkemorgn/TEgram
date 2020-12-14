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
export default {
    props: ["pictureId","comments"],
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
                if (response.status == 201) {
                    this.$store.commit('ADD_COMMENT', theComment)
                }
            })
            .catch((err) => {
            console.log(err);
        });
        }
    }
}
</script>