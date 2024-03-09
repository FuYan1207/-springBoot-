<template>
  <div class="layout-container">
    <el-alert type="success">请尝试左右拖动模块，以改变任务状态</el-alert>
    <div class="layout-container-table">
      <System @addTask="clickEven"></System>
      <div class="list">
        <Block v-for="(block, key) in list" :key="key" :data="block" />
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent, ref, watch } from 'vue'
import Block from './block.vue'
import System from './system.vue'
import store from '@/store'
import { getData } from '@/api/work'
export default defineComponent({
  components: {
    Block,
    System
  },
  setup() {
    let list = ref([])
    function clickEven(){
      getList()
    }

    const getList = () => {
      let params = {
        employeeId: store.state.user.info.user.employeeId
      }
      getData(params)
        .then(res => {
          list.value = res.data
        })
    }
    watch(list, (newValue) => {
      //console.log(newValue)
    }, { deep: true })
    getList()
    return {
      list,
      clickEven
    }
  }
})
</script>

<style lang="scss" scoped>
.layout-container-table {
  white-space: nowrap;
  padding: 15px 0 0 0;
  position: relative;
  display: flex;

  :deep(.el-scrollbar__view) {
    height: 100%;
  }

  &::before,
  &::after {
    content: '';
    width: 15px;
    height: calc(100% - 20px);
    position: absolute;
    background: #fff;
    top: 0;
  }

  &::before {
    left: 0;
  }

  &::after {
    right: 0;
  }

  .list {
    box-sizing: border-box;
    overflow-y: hidden;
    overflow-x: auto;
    text-align: left;
    height: 100%;
    width: 83%;
    padding: 0 15px;
    background: #fff;

    .block {
      margin-right: 20px;
    }

    .block:last-child {
      margin-right: 0;
    }
  }
}
</style>