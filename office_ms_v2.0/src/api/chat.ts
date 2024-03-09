import request from '@/utils/system/request'

// 获取在线人数
export function getOnlineUser(data:Object) {
    return request({
      url: '/chat/onlineUserList',
      method: 'post',
      data
    })
}

//获取聊天信息
export function getChattingRecords(data:Object){
  return request({
    url:'/chat/chattingRecords',
    method:'post',
    data
  })
}
