<template id="font">
  <tr>
    <td>
      <router-link :to="`/fiction/view?isbn=${isbn}`">{{ title }}</router-link>
    </td>
  </tr>
</template>

<script>
export default {
  name: "listrow",
  props: {
    isbn: Number,
    title: String,
    src: String,
  },
  methods: {},
};
</script>
<style scope>
td {
  text-align: center;
  border-bottom: 1px solid #ddd;
  height: 50px;
}
</style>
