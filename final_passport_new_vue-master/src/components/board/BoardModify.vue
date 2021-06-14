<template>
  <b-container id="mainImage">
    <div id="font">
      <write-form type="modify" />
    </div>
  </b-container>
</template>

<script>
import WriteForm from "@/components/board/WriteForm.vue";

export default {
  name: "boardmodify",
  components: {
    WriteForm,
  },
};
</script>
