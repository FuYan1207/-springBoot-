import type { Route } from '../index.type'
import Layout from '@/layout/index.vue'
import { createNameComponent } from '../createNode'
const route: Route[] = [
  {
    path: '/chat',
    component: Layout,
    redirect: '/chat/index',
    meta: { title: 'message.menu.chat.group', icon: 'sfont system-document' },
    alwayShow: true,
    children: [
      {
        path: 'index',
        component: createNameComponent(() => import('@/views/myViews/chat/index.vue')),
        meta: { title: 'message.menu.chat.group',cache: true, }
      },
    ]
  }
]

export default route