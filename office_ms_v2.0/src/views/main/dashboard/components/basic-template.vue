<template>
  <el-card class="box-card">
    <h5>模块一</h5>
  </el-card>
</template>

<script lang="ts">
import { defineComponent } from 'vue'
export default defineComponent({
  setup() {

  }
})
</script>

<style lang="scss" scoped>
  .box-card {
    .card-header{
      text-align: left;
    }
    .box {
      .item {
        display: flex;
        align-items: center;
        * {
          margin-right: 20px;
        }
      }
    }
  }
</style>