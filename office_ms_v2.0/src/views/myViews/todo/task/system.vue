<template>
    <div class="box">
        <div class="block">
            <div class="title">
                <el-input 
                v-model="task.content" 
                style="width: 90%; 
                margin-top: 15%;
                margin-left: 5%;" 
                size="large" 
                placeholder="添加任务"
                :prefix-icon="Plus"
                @keyup.enter.native="addTask()"
                >
                <template #suffix>
                    <el-date-picker
                    class="noBorder"
                        style="width: 100px"
                        v-model="task.deadline"
                        type="date"
                        placeholder="选择日期"
                        :size="size"
                        @keyup.enter.native="addTask()"
                    />
                </template>
                </el-input>
            </div>
            <div class="body">
                <div>
                    <p style="margin: 0 0 0 20px;font-size: 50px;">My Day</p>
                    <p style="margin: 5px 0 0 20px;font-size: 20px;">{{date}}</p>
                </div>
            </div>
            <div class="foot"></div>
        </div>
    </div>
</template>

<script lang="ts" setup>
import {reactive,ref,defineEmits} from 'vue'
import { Plus} from '@element-plus/icons-vue'
import store from '@/store'
import { add } from '@/api/work'
const emits=defineEmits(['addTask'])
const task = reactive({
    content:'',
    deadline:'',
})
const date = ref('')
  //格式化时间的函数  。它接受一个数字类型的参数 time，表示需要格式化的时间。
  //如果 time 小于10，则返回一个带有前导零的字符串表示；
  //否则，将 time 转换为字符串后返回。
function formatTime(time: number) {
    return time < 10 ? `0${time}` : time
}
function updateTime() {
    const now = new Date()
    const year = now.getFullYear()  //年
    const month = now.getMonth() + 1 //月
    const day = now.getDate()    //日
    const hours = now.getHours()  //小时数
    const minutes = now.getMinutes()  //分钟数
    const seconds = now.getSeconds()  //秒数
    const week = ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"][now.getDay()]  //星期
  //想展示什么  对应的展示即可 
  date.value = `${formatTime(month)}月${formatTime(day)}日 ${week}`
}

updateTime()

function addTask(){
    let params = {
        taskContent:task.content,
        responsiblePerson:store.state.user.info.user.employeeId,
        deadline:task.deadline,
        publisher:store.state.user.info.user.employeeId
    }
    add(params)
    .then(res =>{
        emits('addTask')
    })
    task.content = ''
    task.deadline = ''
}
</script>

<style scoped>
.box {
    box-sizing: border-box;
    overflow-y: hidden;
    overflow-x: auto;
    text-align: left;
    margin-left: 10px;
    height: 100%;
    width: 450px;
    padding: 0 15px;
    background: #fff;
    

    .block {
        width: 98%;
        height: calc(100% - 10px);
        /* background: #efefef; */
        border: 1px solid #e3e3e3;
        border-radius: 4px;
        display: inline-flex;
        flex-direction: column;
        background-image:url('../../../../assets/todo_background.jpg');
        background-position: center center;
        background-size: cover;

        .title {
            height: 30%;
            width: 100%;
        }

        .body {
            height: 60%;
            width: 100%;
            color:#fff;
        }

        .foot {
            height: 20%;
            width: 100%;
        }
    }
}
.el-input {
  border: none;
}
</style>