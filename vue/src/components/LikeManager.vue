<template>
  <div>
    <button
      v-if="liked"
      type="button"
      class="btn btn-primary btn-sm"
      @click="addLike"
    >
      Like <font-awesome-icon icon="thumbs-up" />
    </button>
    <button v-else type="button" class="btn btn-primary btn-sm">
      Unlike <font-awesome-icon icon="thumbs-down" />
    </button>
  </div>
</template>

<script>
export default {
  props: ["picture"],
  data() {
    return {
      liked: true,
    };
  },

  methods: {
    addLike() {},
  },
};
</script>