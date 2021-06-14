<template>
  <b-container id="mainImage">
    <div class="regist" id="font">
      <div v-if="this.modifyComment != null" class="regist_form">
        <textarea
          id="comment"
          name="comment"
          v-model="modifyComment.comment"
          cols="35"
          rows="2"
        ></textarea>
        <button class="small btn" @click="updateCommentCancel">취소</button>
        <button class="small btn" @click="updateComment">수정</button>
      </div>
      <div v-else class="regist_form">
        <textarea
          id="comment"
          name="comment"
          v-model="comment"
          cols="35"
          rows="2"
        ></textarea>
        <button @click="registComment" class="btn">등록</button>
      </div>
    </div>
  </b-container>
</template>

<script>
import http from "@/util/http-common";

export default {
  name: "bcommentwrite",
  data() {
    return {
      // 차후 작성자 이름은 로그인 구현후 로그인한 사용자로 바꾼다.
      user_name: this.$store.state.user.name,
      comment: "",
    };
  },
  props: {
    isbn: { type: String },
    modifyComment: { type: Object },
  },
  methods: {
    registComment() {
      http
        .post("/bcomment/", {
          user_name: this.user_name,
          comment: this.comment,
          isbn: this.isbn,
        })
        .then(({ data }) => {
          let msg = "등록 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "등록이 완료되었습니다.";
          }
          alert(msg);

          // 작성글 지우기
          this.comment = "";

          // 도서평(댓글) 얻기.
          this.$store.dispatch("getBComments", `/bcomment/${this.isbn}`);
        });
    },
    updateComment() {
      http
        .put(`/bcomment`, {
          comment_no: this.modifyComment.comment_no,
          comment: this.modifyComment.comment,
        })
        .then(({ data }) => {
          let msg = "수정 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "수정이 완료되었습니다.";
          }
          alert(msg);

          // 도서평(댓글) 얻기.
          this.$store.dispatch(
            "getBComments",
            `/bcomment/${this.modifyComment.isbn}`
          );
          this.$emit("modify-comment-cancel", false);
        });
    },
    moveList() {
      this.$router.push("/board");
    },
    updateCommentCancel() {
      this.$emit("modify-comment-cancel", false);
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
  background-color: #d6e7fa;
  padding: 20px;
}

textarea {
  width: 90%;
  padding: 10px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  color: #787878;
  font-size: large;
}

button {
  float: right;
}

button.small {
  width: 60px;
  font-size: small;
  font-weight: bold;
}
</style>
