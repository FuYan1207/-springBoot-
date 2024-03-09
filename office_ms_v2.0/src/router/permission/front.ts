/**
 * 前端路由管理
 **/

/** 路由类型 */
import type { Route } from '../index.type'

/** 引入需要权限的Modules */
import Dashboard from '../modules/dashboard'
import Document from '../modules/document'
import Component from '../modules/component'
import Directive from '../modules/directive'
import Chart from '../modules/chart'
import Print from '../modules/print'

import Employee from '../modules/employee'
import Todo from '../modules/todo'
import Chat from '../modules/chat'

/** 登录后需要动态加入的本地路由 */
const FrontRoutes: Route[] = [
  ...Dashboard,
  ...Todo,
  ...Chat,
  ...Employee,
  ...Document,
  ...Component,
  ...Chart,
  ...Directive,
  ...Print,
]

export default FrontRoutes