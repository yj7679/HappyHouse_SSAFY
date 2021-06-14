<template>
  <b-container id="mainImage">
    <div id="font">
      <div class="back">
        <br />
        <div class="underline top white title">공지사항</div>
        <div style="text-align: right">
          <button @click="movePage" class="margin-10 btn white">글쓰기</button>
        </div>
      </div>
      <div>
        <table id="book-list">
          <colgroup>
            <col style="width: 15%" />
            <col style="width: 30%" />
            <col style="width: 20%" />
            <col style="width: 15%" />
            <col style="width: 20%" />
          </colgroup>
          <thead>
            <tr>
              <th>번호</th>
              <th>제목</th>
              <th>글쓴이</th>
              <th>작성일</th>
              <th>조회수</th>
            </tr>
          </thead>
          <tbody>
            <list-row
              v-for="(board, index) in boards"
              :key="index"
              :isbn="board.isbn"
              :title="board.title"
              :author="board.author"
              :writtendate="board.writtendate"
              :content="board.content"
              :hit="board.hit"
            />
          </tbody>
        </table>
      </div>
    </div>
  </b-container>
</template>

<script>
import { mapGetters } from "vuex";
import ListRow from "@/components/board/ListRow.vue";

export default {
  name: "boardlist",
  components: {
    ListRow,
  },
  computed: {
    ...mapGetters(["boards"]),
  },
  created() {
    this.$store.dispatch("getBoards");
  },
  methods: {
    movePage() {
      this.$router.push({ name: "Board-create" });
    },
  },
};
</script>
<style>
@keyframes tracking-in-expand {
  0% {
    letter-spacing: -0.5em;
    opacity: 0;
  }
  40% {
    opacity: 0.6;
  }
  100% {
    opacity: 1;
  }
}
@font-face {
  font-family: "CookieRunOTF-Bold";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.0/CookieRunOTF-Bold00.woff")
    format("woff");
  font-weight: normal;
  font-style: normal;
}
.margin-10 {
  margin: 10px;
}

#font {
  font-family: CookieRunOTF-Bold;
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

.top {
  margin-top: 80px;
}
.top1 {
  margin-top: 60px;
  margin-bottom: 20px;
}
.back {
  background-image: url("https://t1.daumcdn.net/cfile/tistory/214DCD42594CC40625");
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
}

.white {
  color: white;
}

h1 {
  font-weight: 700;
  flex: 1;
  position: relative;
  text-align: center;
  margin: 0;
  -webkit-text-fill-color: transparent;

  background-image: url("https://i.pinimg.com/originals/ff/f9/fa/fff9fabc3c9b30df37fe6351631386d5.gif");
  background-size: cover;
  -webkit-background-clip: text;
  background-repeat: no-repeat;
}

.title {
  animation: tracking-in-expand 0.7s cubic-bezier(0.215, 0.61, 0.355, 1) both;
  color: white;
  font-size: 40px;
  text-shadow: 5px 5px #558abb;
}
</style>