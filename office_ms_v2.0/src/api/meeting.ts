import request from '@/utils/system/request'

// 获取会议
export function getData() {
    return request({
      url: '/meeting/getAll',
      method: 'post'
    })
}

export function add(data:object){
    return request({
        url:'/meeting/add',
        method:'post',
        data
    })
}