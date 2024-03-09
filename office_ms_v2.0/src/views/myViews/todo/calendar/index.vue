<template>
  <el-calendar>
    <template #date-cell="{ data }">
      <p :class="data.isSelected ? 'is-selected' : ''" @click="todyInfo(data.day)" style="height: 100%; width: 100%;">
        {{ data.day.split('-').slice(1).join('-') }}
        <span v-if="isShow(data.day)">
          ✔️
        </span>
      </p>
    </template>
  </el-calendar>
  <el-drawer v-model="drawer" title="添加会议" :with-header="true">

    <template #default>
      <el-form :model="form" label-width="auto" style="max-width: 600px">
        <el-form-item label="会议主题">
          <el-input v-model="form.meetingTopic" />
        </el-form-item>
        <el-form-item label="主持人">
          <el-input v-model="form.president" />
        </el-form-item>
        <el-form-item label="会议时间">
          <el-date-picker v-model="form.meetingDate" type="datetime" placeholder="Select date and time"
            :default-time="defaultTime" />
        </el-form-item>
        <el-form-item label="会议地点">
          <el-input v-model="form.meetingPlace" />
        </el-form-item>
        <el-form-item label="参会人员">
          <el-input v-model="form.participants" type="textarea" />
        </el-form-item>
      </el-form>

      <div style="flex: auto">
        <el-button @click="cancelClick">取消</el-button>
        <el-button type="primary" @click="confirmClick">添加</el-button>
      </div>
      <el-divider />

      <el-descriptions style="margin-top: 10px;" v-for="item, index in getTodyMeeting()" :key="index" :title="'会议'+index" :column="3" border>
        <el-descriptions-item label="会议主题" label-align="center" align="center" label-class-name="my-label"
          class-name="my-content" width="40px">{{ item.meetingTopic }}</el-descriptions-item>
        <el-descriptions-item label="会议主持" label-align="center" align="center" width="40px">{{ item.president
          }}</el-descriptions-item>
        <el-descriptions-item label="参会人员" label-align="center" align="center" width="60px">{{ item.participants
          }}</el-descriptions-item>
        <el-descriptions-item label="会议时间" label-align="center" align="center">
          <el-tag size="small">{{ item.meetingDate }}</el-tag>
        </el-descriptions-item>
        <el-descriptions-item label="会议地址" label-align="center" align="center">{{ item.meetingPlace
          }}</el-descriptions-item>
      </el-descriptions>
    </template>

    <template #footer>

    </template>
  </el-drawer>
</template>

<script lang="ts" setup>
import { ref, reactive, watch } from 'vue'
import { ElMessageBox, ElMessage } from 'element-plus'
import { getData, add } from '@/api/meeting';
const drawer = ref(false)
let resDate = reactive([])
const tody = ref()
const defaultTime = new Date(2000, 1, 1, 12, 0, 0)
const form = reactive({
  meetingTopic: '',
  president: '',
  meetingDate: '',
  meetingPlace: '',
  participants: ''
})
//显示日历上的沟
const showGOU: any = reactive([])

function getMeeting() {
  getData()
    .then(res => {
      resDate = res.data
      for (let index = 0; index < resDate.length; index++) {
        showGOU.push(resDate[index].meetingDate.split('T'))
      }
    })
}

function addMeeting() {
  add(form)
    .then(res => {
      getMeeting()
      ElMessage({
        message: "添加成功",
        type: 'success',
      })
    })
}

getMeeting()

watch(() => drawer.value, () => {
  form.meetingTopic = '',
    form.president = '',
    form.meetingDate = '',
    form.meetingPlace = '',
    form.participants = ''
})

function getTodyMeeting() {
  let list = []
  for (let index = 0; index < resDate.length; index++) {
    var date = resDate[index].meetingDate.split('T')
    if (date[0] == tody.value) {
      list.push(resDate[index])
    }
  }
  return list
}

function todyInfo(data) {
  tody.value = data
  drawer.value = true;

}

function isShow(d){
  for (let index = 0; index < showGOU.length; index++) {
    if (showGOU[index][0] == d) {
      return true
    }
  }
  return false
}

function cancelClick() {
  drawer.value = false
  console.log(form.meetingDate);

}
function confirmClick() {
  ElMessageBox.confirm('确定添加此会议吗？')
    .then(() => {
      addMeeting()
      drawer.value = false
      ElMessage({
        message: "添加成功",
        type: 'success',
      })
    })
    .catch(() => {
      ElMessage({
        message: "添加失败",
        type: 'warning',
      })
    })
}
</script>

<style scoped>
.is-selected {
  color: #1989fa;
}

.el-popper.is-customized {
  /* Set padding to ensure the height is 32px */
  padding: 6px 12px;
  background: linear-gradient(90deg, rgb(159, 229, 151), rgb(204, 229, 129));
}

.el-popper.is-customized .el-popper__arrow::before {
  background: linear-gradient(45deg, #b2e68d, #bce689);
  right: 0;
}
</style>