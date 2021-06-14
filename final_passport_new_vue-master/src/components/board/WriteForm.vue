<template id="font">
  <b-container id="mainImage">
    <div class="regist">
      <h1 class="underline top1">공지사항 쓰기</h1>
      <div class="regist_form">
        <label for="title">제목</label>
        <input
          type="text"
          id="title"
          name="title"
          v-model="title"
          ref="title"
        /><br />
        <label for="author">글쓴이</label>
        <input
          type="text"
          id="author"
          name="author"
          v-model="author"
          ref="author"
          readonly
        /><br />
        <label for="writtendate">작성일</label>
        <input
          type="date"
          id="writtendate"
          name="writtendate"
          v-model="writtendate"
          ref="writtendate"
        /><br />
        <label for="content">내용</label><br />
        <textarea
          id="content"
          name="content"
          v-model="content"
          ref="content"
          cols="35"
          rows="5"
        ></textarea
        ><br />
        <button v-if="type == 'create'" @click="checkValue" class="btn">
          등록
        </button>
        <button v-else @click="checkValue" class="btn" id="btn_group">
          수정
        </button>
        <button @click="moveList" class="btn" id="btn_group">목록</button>
      </div>
    </div>
  </b-container>
</template>

<script>
import http from "@/util/http-common";

export default {
  name: "writeform",
  props: {
    type: { type: String },
  },
  data() {
    return {
      isbn: "",
      title: "",
      author: this.$store.state.user.name,
      writtendate: "",
      content: "",
    };
  },
  created() {
    if (this.type === "modify") {
      http.get(`/board/${this.$route.params.isbn}`).then(({ data }) => {
        this.isbn = data.isbn;
        this.title = data.title;
        this.author = data.author;
        this.writtendate = data.writtendate;
        this.content = data.content;
      });
    }
  },
  methods: {
    // 입력값 체크하기 - 체크가 성공하면 registBook 호출
    checkValue() {
      // 사용자 입력값 체크하기
      // isbn, 제목, 저자, 가격, 설명이 없을 경우 각 항목에 맞는 메세지를 출력
      let err = true;
      let msg = "";
      err &&
        !this.title &&
        ((msg = "제목을 입력해주세요"),
        (err = false),
        this.$refs.title.focus());
      err &&
        !this.author &&
        ((msg = "로그인을 해주세요"), (err = false), this.$refs.author.focus());
      err &&
        !this.writtendate &&
        ((msg = "작성일을 입력해주세요"),
        (err = false),
        this.$refs.writtendate.focus());
      err &&
        !this.content &&
        ((msg = "내용을 입력해주세요"),
        (err = false),
        this.$refs.content.focus());

      if (!err) alert(msg);
      // 만약, 내용이 다 입력되어 있다면 registBook 호출
      else this.type == "create" ? this.registBook() : this.modifyBook();
    },
    registBook() {
      http
        .post("/board/", {
          isbn: this.isbn,
          title: this.title,
          author: this.author,
          writtendate: this.writtendate,
          content: this.content,
        })
        .then(({ data }) => {
          let msg = "등록 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "등록이 완료되었습니다.";
          }
          alert(msg);
          this.moveList();
        });
    },
    modifyBook() {
      http
        .put(`/board/${this.isbn}`, {
          isbn: this.isbn,
          title: this.title,
          author: this.author,
          writtendate: this.writtendate,
          content: this.content,
        })
        .then(({ data }) => {
          let msg = "수정 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "수정이 완료되었습니다.";
          }
          alert(msg);
          this.$router.push("/board");
        });
    },
    moveList() {
      this.$router.push("/board");
    },
  },
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
  margin: 10px;
}

#btn_group:hover {
  color: white;
  background-color: skyblue;
}
</style>
