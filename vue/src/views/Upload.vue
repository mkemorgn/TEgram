<template>
  <div>
    <p id="go-back" @click="$router.go(-1)">
      <font-awesome-icon icon="arrow-circle-left" />
    </p>
    <upload-photo />
  </div>
</template>

<script>
import UploadPhoto from "@/components/UploadPhoto.vue";
export default {
  components: { UploadPhoto },
};
</script>