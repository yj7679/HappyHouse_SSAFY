<template>
  <b-container id="mainImage">
    <div class="regist" id="font">
      <br />
      <h1 class="underline title top1">기사 정보</h1>
      <br />
      <div class="regist_form">
        <h1>{{ fiction.title }} <br /></h1>
      </div>
      <div>
        <br />
        <img v-bind:src="fiction.src" />

        <!-- <a v-bind:href="singlenews.link">{{ singlenews.link }}</a> -->
      </div>
      <br />
      <div class="content">
        <div>{{ fiction.content }}</div>
      </div>
      <br />
      <br />
      <router-link to="/" class="btn">
        <div><button id="btn_group">목록</button></div>
      </router-link>
    </div>
  </b-container>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  name: "fictiondetial",
  computed: {
    ...mapGetters(["fiction"]),
  },

  data() {
    return {
      isbn: "",
      title: "",
      src: "",
    };
  },
  created() {
    this.isbn = this.$route.query.isbn;
    this.$store.dispatch("getFiction", `/fiction/${this.isbn}`);
  },
  methods: {},
};
</script>
<style scoped>
.regist {
  padding: 10px;
}
.regist_form {
  text-align: left;
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
input,
textarea,
.view {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  color: #787878;
  font-size: medium;
}
#btn_group {
  border: 1px solid skyblue;
  background-color: rgba(0, 0, 0, 0);
  color: skyblue;
  padding: 5px;
  width: 150px;
}

#btn_group:hover {
  color: white;
  background-color: skyblue;
}

h1 {
  text-align: center;
}

h3 {
  text-align: right;
}

.content {
  text-align: center;
  width: 50%;
  display: inline-block;
}
</style>
