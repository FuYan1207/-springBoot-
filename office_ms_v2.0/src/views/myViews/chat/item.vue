<template>
  <div class="item">
    <div class="avatar">
      <el-avatar shape="square" :size="40">{{ data != '工作组' && data != '管理员' ? data.name.charAt(0) :
        data.charAt(0) }}</el-avatar>
    </div>
    <div class="name">{{ data != '工作组' && data != '管理员' ? data.name : data }}</div>
    <div class="num"></div>
  </div>
</template>

<script lang="ts">
import { defineComponent, computed, watch } from 'vue'
export default defineComponent({
  props: {
    data: {
      required: true,
    },
    employeeId: {
      required: true,
      default: -3
    }
  },
  setup(props) {
    watch(() => props.employeeId, (newVlue) => {
    })
    const colorInit = computed(() => {
      return (tag: string) => {
        const array = [
          { color: '#67a4dc', tag: 'boss' },
          { color: '#57c05d', tag: 'me' }
        ]
        const obj = array.find(obj => {
          return obj.tag === tag
        })
        return obj && obj.tag ? obj.color : '#67a4dc'
      }
    })
    return {
      colorInit
    }
  }
})
</script>

<style lang="scss" scoped>
.item:hover {
  background: #dbdee1;
}

.item {
  background: #fff;
  width: calc(100% - 30px);
  height: 40px;
  padding: 10px 5px;
  display: flex;
  overflow: hidden;
  white-space: normal;
  cursor: pointer;

  .avatar {
    width: calc(30% - 20px);
  }

  .name {
    width: calc(60%);
    margin-left: 25px;
    line-height: 40px;
    text-align: left;
    font-size: 15px;
  }

  .num {}
}
</style>