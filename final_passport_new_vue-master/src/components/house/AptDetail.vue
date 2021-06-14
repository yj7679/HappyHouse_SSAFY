<template>
  <div id="font">
    <b-table-simple hover small caption-top stacked>
      <b-thead head-variant="dark">
        <b-tr>
          <b-th>일련번호</b-th>
          <b-th>아파트명</b-th>
          <b-th>법정동</b-th>
          <b-th>층</b-th>
          <b-th>거래금액</b-th>
        </b-tr>
      </b-thead>

      <b-tbody>
        <b-tr>
          <b-th stacked-heading="일련번호" class="text-left">{{
            apt.일련번호
          }}</b-th>
          <b-td stacked-heading="아파트명">{{ apt.아파트 }}</b-td>
          <b-td stacked-heading="법정동">{{ apt.법정동 }}</b-td>
          <b-td stacked-heading="층">{{ apt.층 }}층</b-td>
          <b-td stacked-heading="거래금액"
            >{{ (apt.거래금액.replace(",", "") * 10000) | price }}원</b-td
          >
        </b-tr>
      </b-tbody>
    </b-table-simple>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "AptDetail",
  computed: {
    ...mapState(["apt"]),
  },
  filters: {
    price(value) {
      if (!value) return value;
      return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
  },
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

#font {
  font-family: CookieRunOTF-Bold;
}
</style>
