<template id="font">
  <tr>
    <td>{{ isbn }}</td>
    <td>{{ title }}</td>
    <td>
      <router-link :to="`/board/view?isbn=${isbn}`">{{ author }}</router-link>
    </td>
    <td>{{ writtendate }}</td>
    <td>{{ hit }}</td>
  </tr>
</template>

<script>
export default {
  name: "listrow",
  props: {
    isbn: Number,
    title: String,
    author: String,
    writtendate: String,
    content: String,
    hit: Number,
  },
  methods: {
    numberWithCommas(x) {
      return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
  },
};
</script>
<style scope>
td {
  text-align: center;
  border-bottom: 1px solid #ddd;
  height: 50px;
}
</style>
