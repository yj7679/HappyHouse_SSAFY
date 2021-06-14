<template>
  <div id="font">
    <b-row class="mt-4 mb-4">
      <b-col class="sm-3" align="left">
        <b-form-input
          v-model.trim="dongCode"
          placeholder="아파트이름 입력...(예 : 현대)"
          @keypress.enter="sendKeyword"
        ></b-form-input>
      </b-col>
      <b-col class="sm-3" align="left">
        <b-button variant="outline-primary" @click="sendKeyword">검색</b-button>
      </b-col>
    </b-row>
  </div>
</template>

<script>
import { mapActions } from "vuex";

export default {
  name: "SearchBar",
  data() {
    return {
      dongCode: "",
    };
  },
  methods: {
    ...mapActions(["getAptList"]),
    sendKeyword() {
      // this.$emit('send-keyword', this.dongCode);
      if (this.dongCode) this.getAptList(this.dongCode);
      // this.$store.dispatch('getAptList', this.dongCode);
      this.dongCode = "";
    },
  },
};
</script>

<style></style>
