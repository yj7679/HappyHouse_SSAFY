<template>
  <b-container id="mainImage">
    <div id="font">
      <tr>
        <div>
          <table id="book-list">
            <colgroup></colgroup>
            <thead>
              <tr></tr>
            </thead>
            <tbody>
              <list-row
                v-for="(list, index) in fictions"
                :key="index"
                :isbn="list.isbn"
                :title="list.title"
                :src="list.src"
              />
            </tbody>
          </table>
        </div>
      </tr>
    </div>
  </b-container>
</template>

<script>
import { mapGetters } from "vuex";
import ListRow from "@/components/fiction/ListRow.vue";

export default {
  name: "fictionlist",
  components: {
    ListRow,
  },
  computed: {
    ...mapGetters(["fictions"]),
  },
  created() {
    this.$store.dispatch("getFictions");
  },
  methods: {},
};
</script>

<style>
@font-face {
  font-family: "CookieRunOTF-Bold";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.0/CookieRunOTF-Bold00.woff")
    format("woff");
  font-weight: normal;
  font-style: normal;
}
#book-list {
  border-collapse: collapse;
  width: 100%;
}

#book-list thead {
  background-color: skyblue;
  font-weight: bold;
  color: white;
}

#book-list td,
#book-list th {
  text-align: center;
  border-bottom: 1px solid #ddd;
  height: 50px;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}
</style>