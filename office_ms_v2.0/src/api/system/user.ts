import request from '@/utils/system/request'

// 获取数据api
export function getData(data: object) {
  return request({
    url: '/user/list',
    method: 'post',
    data
  })
}

// 编辑
export function update(data: object) {
  return request({
    url: '/user/updatePermission',
    method: 'patch',
    data
  })
}

// 状态变更
export function updateStatus(data: object) {
  return request({
    url: 'user/updateStatus',
    method: 'patch',
    data
  })
}