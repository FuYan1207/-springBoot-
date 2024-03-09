import type { Route } from '../index.type'
import Layout from '@/layout/index.vue'
import { createNameComponent } from '../createNode'
const route: Route[] = [
  {
    path: '/employee',
    component: Layout,
    redirect: '/employee/info',
    meta: { title: 'message.menu.employee.name', icon: 'sfont system-document',roles: ['admin'] },
    alwayShow: true,
    children: [
      {
        path: 'info',
        component: createNameComponent(() => import('@/views/myViews/employee/employeeInfo/index.vue')),
        meta: { title: 'message.menu.employee.info',cache: true, }
      },
      {
        path: 'account',
        component: createNameComponent(() => import('@/views/myViews/employee/accountInfo/index.vue')),
        meta: { title: 'message.menu.employee.account',cache: true, }
      }
    ]
  }
]

export default route