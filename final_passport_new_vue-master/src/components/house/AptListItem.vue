<template>
  <div id="font">
    <b-row
      class="m-2"
      @click="chooseApt"
      @mouseover="colorChange(true)"
      @mouseout="colorChange(false)"
      :class="{ 'mouse-over-bgcolor': isColor }"
    >
      <!--<b-col cols="10"> [{{ this.apt.일련번호 }}] {{ this.apt.아파트 }}</b-col>-->
      <b-col cols="10">{{ this.apt.아파트 }}</b-col>
    </b-row>
  </div>
</template>

<script>
import { mapActions } from "vuex";

export default {
  name: "AptListItem",
  data() {
    return {
      isColor: false,
    };
  },
  props: {
    apt: Object,
  },
  methods: {
    // chooseApt() {
    //   // this.$emit('select-apt', this.apt);
    //   this.$store.dispatch('selectApt', this.apt);
    // },
    ...mapActions(["selectApt"]),
    chooseApt() {
      this.selectApt(this.apt);
    },
    colorChange(flag) {
      this.isColor = flag;
    },
  },
};
</script>

<style scoped>
.img-list {
  width: 50px;
}
.mouse-over-bgcolor {
  background-color: lightblue;
}
</style>
