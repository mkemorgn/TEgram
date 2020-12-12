<template>
  <form class="new-comment" v-on:submit.prevent="postComment" autocomplete="off">
    <input
      type="text"
      name="comment"
      id="comment"
      placeholder="Add a comment..."
      v-model="comment"
    />
    <button v-bind:disabled="!comment">Post</button>
  </form>
</template>

