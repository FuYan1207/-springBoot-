<template>
  <div class="card-list">
    <Row v-for="row in list" :key="row.id" :row="row" />
  </div>
</template>

<script lang="ts">
import { defineComponent,ref } from 'vue'
import Row from './row.vue'
import { getEmployeeNum,getMeetingNum,getTaskNum } from '@/api/card'
import store from '@/store'

export default defineComponent({
  components: {
    Row
  },
  setup() {
    const list = ref([
      { id: 1, name: '公司人数', data: '100', color: '#4e73df', icon: 'sfont system-yonghu' },
      { id: 2, name: '通知', data: '30', color: '#1cc88a', icon: 'sfont system-xiaoxi' },
      { id: 3, name: '会议', data: '5', color: '#36b9cc', icon: 'sfont system-shuliang_mianxing' },
      { id: 4, name: '已完成', data: '1130', color: '#f6c23e', icon: 'sfont system-jindutiaoshouyidaozhang' }
    ])
    getcount()
    function getcount(){
      getEmployeeNum()
      .then(res => {
        list.value[0].data = res.data
      })




      getMeetingNum()
      .then(res => {
        list.value[2].data = res.data
      })
      let params = {
        employeeId:store.state.user.info.user.employeeId
      }
      getTaskNum(params)
      .then(res => {
        list.value[3].data = res.data
      })
    }

    return {
      list
    }
  }
})
</script>

<style lang="scss" scoped>
.card-list {
  width: calc(100% + 20px);
  margin-left: -10px;
  display: flex;
  flex-wrap: wrap;
}
</style>