<template>
  <div id="comment-list">
    <div v-if="hasComments(comments)">
      <p id="show" v-on:click="toggleComments">
        {{ isOpen ? "Hide" : "Show" }} Comments ({{ comments.length }})
      </p>
      <div v-if="isOpen">
        <div v-for="comment in comments" v-bind:key="comment.commentId">
          <div class="Comment">
            <div class="User">{{ comment.byUser }}:</div>
            <div class="CommentBody">{{ comment.comment }}</div>
          </div>
        </div>
      </div>
    </div>
    <div v-else>No Comments</div>
  </div>
</template>

<script>
export default {
  data() {
    return { isOpen: false };
  },
  props: ["comments"],
  methods: {
    hasComments(comments) {
      return Array.isArray(comments);
    },
    toggleComments() {
      this.isOpen = !this.isOpen;
    },
  },
};
</script>

<style>
.Comment {
  background-color: #f9f9f9;
  margin: 0.5rem;
  padding: 0.5rem;
  border-radius: 3px;
}
.User {
  color: black;
}
#comment-list {
  font-size: 8pt;
}
#show {
  text-align: right;
  font-style: normal;
  color: #2cb2ea;
  font-size: 9pt;
}
#show:hover {
  color: #116b92;
}
</style>