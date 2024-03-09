import request from '@/utils/system/request'

// 获取员工数
export function getEmployeeNum() {
  return request({
    url: '/employee/count',
    method: 'get',
  })
}

// 获取会议数
export function getMeetingNum() {
  return request({
    url: '/meeting/count',
    method: 'get',
  })
}

// 获取已经完成的我任务数
export function getTaskNum(data:Object) {
  return request({
    url: '/work/count',
    method: 'post',
    data
  })
}

// 删除
export function del(data: object) {
  return request({
    url: '/card/del',
    method: 'post',
    baseURL: '/mock',
    data
  })
}