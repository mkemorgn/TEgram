<template>
  <div class="dropdown">
    <p class="dropbtn badge badge-pill badge-success">
      <font-awesome-icon icon="comments" />
      {{ commentCount(this.comments) }}
    </p>
    <div class="dropdown-content">
      <p
        class="dropdown-elements"
        v-for="comment in comments"
        v-bind:key="comment.commentId"
      >
        <i @click="deleteComment(comment)" style="color: red">
          <font-awesome-icon
            icon="comment-slash"
            v-if="comment.userId == userd"
        /></i>
        {{ comment.byUser }}: {{ comment.comment }}
      </p>
    </div>
  </div>
</template>

<script>
import photoService from "@/services/PhotoService";
export default {
  props: ["comments"],
  data() {
    return {
      userd: this.$store.state.user.id,
    };
  },

  methods: {
    commentCount(comments) {
      if (comments) {
        return comments.length;
      } else {
        return 0;
      }
    },
    deleteComment(comment) {
      photoService
        .deleteComment(comment)
        .then(() => {
          this.$store.commit("REMOVE_COMMENT", comment);
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};
</script>


<style>
@import "../../style/dropdownStyle.css";
</style>