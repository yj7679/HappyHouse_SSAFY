<template>
  <div id="font">
    <view-detail />
    <comment-write :isbn="this.isbn" />
    <comment-write
      v-if="isModifyShow && this.modifyComment != null"
      :modifyComment="this.modifyComment"
      @modify-comment-cancel="onModifyCommentCancel"
    />
    <comment
      v-for="(comment, index) in bcomments"
      :key="index"
      :comment="comment"
      @modify-comment="onModifyComment"
    />
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import ViewDetail from "@/components/board/ViewDetail.vue";
import CommentWrite from "@/components/board/comment/CommentWrite.vue";
import Comment from "@/components/board/comment/Comment.vue";

export default {
  name: "boardview",
  data() {
    return {
      isbn: "",
      isModifyShow: false,
      modifyComment: Object,
    };
  },
  computed: {
    ...mapGetters(["bcomments"]),
  },
  components: {
    ViewDetail,
    CommentWrite,
    Comment,
  },
  created() {
    this.isbn = this.$route.query.isbn;
    this.$store.dispatch("getBoard", `/board/${this.isbn}`);
    this.$store.dispatch("getBComments", `/bomment/${this.isbn}`);
  },
  methods: {
    onModifyComment(comment) {
      this.modifyComment = comment;
      this.isModifyShow = true;
    },
    onModifyCommentCancel(isShow) {
      this.isModifyShow = isShow;
    },
  },
};
</script>

<style>
</style>