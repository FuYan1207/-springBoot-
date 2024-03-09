import type { Route } from '../index.type'
import Layout from '@/layout/index.vue'
import { createNameComponent } from '../createNode'
const route: Route[] = [
  {
    path: '/work',
    component: Layout,
    redirect: '/work/todo',
    meta: { title: 'message.menu.work.todo', icon: 'sfont system-document' },
    children: [
      {
        path: 'todo',
        component: createNameComponent(() => import('@/views/myViews/todo/task/index.vue')),
        meta: { title: 'message.menu.work.task' }
      },
      {
        path:'calendar',
        component:createNameComponent(() => import('@/views/myViews/todo/calendar/index.vue')),
        meta:{title: 'message.menu.work.calendar'}
      }
    ]
  }
]

export default route