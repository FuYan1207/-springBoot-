import request from '@/utils/system/request'

/** 登录api -- */
export function loginApi(data: object) {
  return request({
    url: '/user/login',
    method: 'post',
    data
  })
}

/** 获取用户信息Api -- */
export function getInfoApi() {
  return request({
    url: '/user/info',
    method: 'get'
  })
}

/** 退出登录Api */
export function loginOutApi(data:string) {
  return request({
    url: '/user/logout',
    method: 'post',
    data
  })
}

/** 获取用户信息Api */
export function passwordChange(data: object) {
  return request({
    url: '/user/passwordChange',
    method: 'post',
    baseURL: '/mock',
    data
  })
}

/** 获取登录后需要展示的菜单 */
export function getMenuApi() {
  return request({
    url: '/menu/list',
    method: 'post',
    baseURL: '/mock'
  })
}