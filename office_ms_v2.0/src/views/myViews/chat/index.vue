<template>
    <div class="full">
        <div class="left">
            <el-scrollbar max-height="100%">
                <Item @click="setValue(-3,'工作组')" data="工作组"></Item>
                <Item v-show="employeeId != -1" @click="setValue(-1,'管理员')" data="管理员"></Item>
                <Item @click="setValue(item.employeeId,item.name)" v-for="(item, index) in nameList" :key="index" :data="item" :employeeId="conversation"></Item>
            </el-scrollbar>
        </div>
        <div class="content">
            <div class="head">{{ name }}</div>
            <div class="body">
                <el-scrollbar max-height="100%">
                    <div class="message" v-show="isShwoMessage(item)" v-for="(item, index) in messages" :key="index">
                    <div class="left1" v-if="item.received"><el-avatar shape="square" :size="35">{{
                    item.sender == -1 ? '管' : item.sender}}</el-avatar></div>
                    <div :class="{ 'midL': item.received, 'midR': !item.received }">{{ item.content }}</div>
                    <div class="right" v-if="!item.received"><el-avatar shape="square" :size="35">{{ employeeName.charAt(0) }}</el-avatar></div>
                </div>
                </el-scrollbar>
            </div>
            <div class="input">
                <div class="title"></div>
                <div class="middle">
                    <el-input class="text_input" v-model="inputData" :autosize="{ minRows: 2, maxRows: 4 }"
                        type="textarea" />
                </div>
                <div class="foot">
                    <el-button type="info" @click="sendMessage()">发送</el-button>
                </div>
            </div>
        </div>
    </div>
</template>

<script lang="ts" setup>
import { ElMessage } from "element-plus"
import { reactive, ref } from "vue"
import store from '@/store'

import Item from "./item.vue";
import { getOnlineUser,getChattingRecords } from "@/api/chat";
import { getNames } from "@/api/table";


const employeeId = store.state.user.info.user.employeeId
const employeeName = store.state.user.info.name


let message = reactive({
    fromWho: "",
    toWho: "",
    text: "",
    date: new Date()
})

//当前在线人数
const accountSet = reactive(new Set())


//当前要聊天窗口的id
const conversation = ref()
conversation.value = -3
//当前要聊天窗口的name
const name = ref('工作组')
//要发送的数据
const inputData = ref('')
//存联系人列表
const nameList = ref([]);
//当前对话
const messages = ref([]);

getEmployeeList()
getMessages()
function getEmployeeList() {
    let params = {
        employeeId: employeeId
    }
    getNames(params)
        .then(res => {           
            nameList.value = res.data;
        })

}
//绑定各个用户的信息
function setValue(employeeId1,name1){
    conversation.value = employeeId1;
    name.value = name1;  
}
//显示对应的消息
function isShwoMessage(i){
    if ((i.sender == conversation.value || i.recipient == conversation.value )&&i.recipient != -3) {
        return true
    }else{
        if((i.sender == conversation.value || i.recipient == conversation.value )&&conversation.value == -3){
            return true
        }
        return false
    }
}


const ws = new WebSocket("ws://localhost:8080/webSocket/" + employeeId)

//发送消息
function sendMessage() {
    message.fromWho = employeeId
    message.text = inputData.value
    message.toWho = conversation.value
    message.date = new Date()
    if (message.toWho && message.text) {
        ws.send(JSON.stringify(message))
        let isMe = message.fromWho == employeeId ? false : true
        const msg = { sender: message.fromWho,recipient:message.toWho, time: message.date, content: message.text, received: isMe }
        messages.value.push(msg)
        inputData.value = ""
    }
}

//获取聊天记录
function getMessages(){
    let params={
        employeeId:employeeId
    }
    getChattingRecords(params)
    .then(res=>{
        console.log(res);
        res.data.forEach(message => {
            let isMe = message.fromWho == employeeId ?  false: true
            let msg = { sender: message.fromWho,recipient:message.toWho, time: message.date, content: message.text, received: isMe }
            messages.value.push(msg)          
        });

    })

}


//连接建立时
ws.onopen = function (evt) {
    let params = {
        employeeId: employeeId
    }
    getOnlineUser(params).then(res => {
        const nameSet = res.data
        if (nameSet) {
            for (let valueAccount of nameSet) {
                if (!accountSet.has(valueAccount)) {
                    accountSet.add(valueAccount)
                }
            }
        }
    })

}

//接收到服务器消息时
ws.onmessage = function (evt) {
    message = JSON.parse(evt.data)
    if (message.fromWho == -2) {
        if (message.text != employeeId) {
            ElMessage.info(message.text + "上线了")
            accountSet.add(message.text)
        }
    } else if (message.fromWho == -4) {
        ElMessage.info(message.text + "下线了")
        accountSet.delete(message.text)
    } else {
        let isMe = message.fromWho == employeeId ? false : true
        const msg = { sender: message.fromWho,recipient:message.toWho,time: new Date(), content: message.text, received: isMe }
        messages.value.push(msg)     
        
    }

}
//连接断开时
ws.onclose = function (evt) {
    console.log("close")
}
//发生错误时
ws.onerror = function (evt) {
    console.log("error")
}

</script>

<style lang="less" scoped>
.element::-webkit-scrollbar {
    display: none
}

.full {
    width: 100%;
    height: 100%;
    padding: 10px;
    box-sizing: border-box;
    display: flex;
    background-color: #fff;

    .left {
        width: 300px;
        background-color: #efefef;
        padding: 5px;
        margin-right: 10px;
        overflow: auto;

    }

    .content {
        flex: 1;
        width: calc(100% - 300px);
        height: 100%;
        padding: 5px;
        background-color: #efefef;

        .head {
            height: 10%;
            line-height: 60px;
            font-weight: bolder;
            font-size: 20px;
            text-align: left;
            padding-left: 10px;
            background-color: #fff;
        }

        .body {
            height: 65%;
            border-top: 1px solid rgb(218, 217, 217);
            border-bottom: 1px solid rgb(218, 217, 217);
            background-color: #fff;
            padding-bottom: 10px;

            .message {
                //height: 40px;
                display: flex;
                margin-top: 10px;

                .left1 {
                    width: 10%;
                    //height: 100%;
                }

                .midL {
                    width: 90%;
                    //height: 100%;
                    text-align: left;
                    padding-left: 10px;
                }

                .midR {
                    width: 90%;
                    //height: 100%;
                    text-align: right;
                    padding-right: 10px;
                }


                .right {
                    width: 10%;
                    //height: 100%;
                }
            }
        }

        .input {
            height: 24%;
            background-color: #fff;

            .title {
                height: 20%;
            }

            .middle {
                height: calc(55% - 10px);
                padding: 5px;

                .text_input {
                    :deep(.el-textarea__inner) {
                        box-shadow: 0 0 0 0px var(--el-input-border-color, var(--el-border-color)) inset;
                        cursor: default;
                        resize: none;

                        .el-input__inner {
                            cursor: default !important;
                        }
                    }
                }
            }

            .foot {
                height: 25%;
                padding-left: 85%;
                //background-color: aqua;
            }
        }
    }
}
</style>