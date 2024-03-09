import request from '@/utils/system/request'

// 获取任务
export function getData(data: object) {
  return request({
    url: '/work/list',
    method: 'post',
    data
  })
}

// 修改任务状态
export function updateStatus(data: object) {
  return request({
    url: '/work/updateStatus',
    method: 'put',
    data
  })
}

//添加任务
export function add(data:object){
  return request({
    url:'/work/add',
    method:'post',
    data
  })
}
