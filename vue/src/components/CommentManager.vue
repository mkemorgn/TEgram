<template>
    <div class="addcomment">
        <div>
            <b-form-input @submit.prevent="submit" type ="text" v-model="text" placeholder="add comment..."></b-form-input>
        </div>
        <div>
            <b-button type="submit" @click="submit">Submit</b-button>
        </div>
    </div>
</template>

<script>
import photoService from "@/services/PhotoService";
import axios from 'axios';
export default {
    methods: {
        submit() {
            axios({
                method: 'post',
                url: '/comment',
                data: {
                    "pictureId": ,
                    "comment": "" 
                }
            })
        .then((res) => {
          if (res.status === 201) {
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