import request from '@/utils/system/request'

// 获取数据api
export function getData(data: object) {
  return request({
    url: '/employee/list',
    method: 'post',
    data
  })
}

//获取所有员工姓名
export function getNames(data:object){
  return request({
    url:'employee/names',
    method:'post',
    data
  })
}

// 获取分类数据
export function getCategory(data: object) {
  return request({
    url: '/table/category',
    method: 'post',
    baseURL: '/mock',
    data
  })
}

// 获取树组织数据
export function getTree(data: object) {
  return request({
    url: '/table/tree',
    method: 'post',
    baseURL: '/mock',
    data
  })
}

// 新增
export function add(data: object) {
  return request({
    url: '/employee/add',
    method: 'post',
    data
  })
}

// 编辑
export function update(data: object) {
  return request({
    url: '/employee/update',
    method: 'put',
    data
  })
}

// 删除
export function del(data: object) {
  return request({
    url: '/employee',
    method: 'delete',
    data
  })
}