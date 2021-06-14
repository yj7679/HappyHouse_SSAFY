<template>
  <b-container id="mainImage">
    <div id="font">
      <write-form type="create" />
    </div>
  </b-container>
</template>

<script>
import WriteForm from "@/components/board/WriteForm.vue";

export default {
  name: "boardcreate",
  components: {
    WriteForm,
  },
};
</script>
<style>
</style>