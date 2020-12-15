<template>
  <div class="input-group mb-3 input-group-sm">
    <input
      type="text"
      class="form-control"
      v-model="theComment.comment"
      placeholder="add comment..."
    />
    <div>
      <button
        class="btn btn-outline-primary btn-sm"
        type="button"
        v-on:click="submit"
      >
        <font-awesome-icon icon="comment" />
      </button>
      <button
        class="btn btn-outline-danger btn-sm"
        type="button"
        v-on:click="reset"
      >
        <font-awesome-icon icon="ban" />
      </button>
    </div>
  </div>
</template>

<script>
import photoService from "@/services/PhotoService";
export default {
  props: ["pictureId"],

  data() {
    return {
      theComment: {
        comment: "",
        pictureId: null,
      },
    };
  },
  methods: {
    submit() {
      this.theComment.pictureId = this.pictureId;
      photoService
        .submitComment(this.theComment)
        .then((res) => {
          if (res.status === 201) {
            this.$store.commit("ADD_COMMENT", res.data);
            this.reset();
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    reset() {
      this.theComment = {
        comment: "",
        pictureId: null,
      };
    },
  },
};
</script>