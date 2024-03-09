/*
 * @Date: 2023-03-10 19:34:30
 * @Description: 
 */
import { createNameComponent } from '../createNode';

/** 首页系列 */
const dashboard = {
  /** 首页 */
  dashboard: createNameComponent(() => import('@/views/main/dashboard/index.vue')),
}

/** 文档 */
const document = {
  /** 使用说明 */
  intro: createNameComponent(() => import('@/views/main/document/intro.vue')),
  /** 功能说明 */
  function: createNameComponent(() => import('@/views/main/document/function.vue')),
  /** 路由菜单配置 */
  menu: createNameComponent(() => import('@/views/main/document/menu.vue')),
  /** keepAlive使用说明 */
  keepAlive: createNameComponent(() => import('@/views/main/document/keepAlive.vue')),
  /** 数据表格的增删改查 */
  crud: createNameComponent(() => import('@/views/main/document/crud.vue')),
  /** 自定义主题 */
  theme: createNameComponent(() => import('@/views/main/document/theme.vue')),
  /** 项目图标的说明 */
  systemfont: createNameComponent(() => import('@/views/main/document/systemfont.vue')),
  /** 接口说明文档 */
  api: createNameComponent(() => import('@/views/main/document/api.vue')),
}

/** 组件 */
const component = {
  /** 按钮 */
  button: createNameComponent(() => import('@/views/main/components/button/index.vue')),
  /** 文本编辑器 */
  wordEditor: createNameComponent(() => import('@/views/main/components/wordEditor/index.vue')),
  /** md编辑器 */
  mdEditor: createNameComponent(() => import('@/views/main/components/mdEditor/index.vue')),
  /** 代码编辑器 */
  codeEditor: createNameComponent(() => import('@/views/main/components/codeEditor/index.vue')),
  /** json编辑器 */
  jsonEditor: createNameComponent(() => import('@/views/main/components/jsonEditor/index.vue')),
  /** 可拖拽面板 */
  dragPane: createNameComponent(() => import('@/views/main/components/dragPane/index.vue')),
  /** 地图 */
  map: createNameComponent(() => import('@/views/main/components/map/index.vue')),
  /** 图片裁剪 */
  cutPhoto: createNameComponent(() => import('@/views/main/components/cutPhoto/index.vue')),
  /** 右键菜单 */
  rightMenu: createNameComponent(() => import('@/views/main/components/rightMenu/index.vue')),
  /** 导出excel */
  exportExcel: createNameComponent(() => import('@/views/main/components/exportExcel/index.vue')),
}


/** 自定义指令 */
const directive = {
  /** 拖拽指令：v-dragable */
  dragable: createNameComponent(() => import('@/views/main/directive/dragable.vue')),
  /** 复制指令：v-copy */
  copy: createNameComponent(() => import('@/views/main/directive/copy.vue')),
  /** 水印指令：v-waterMarker */
  waterMarker: createNameComponent(() => import('@/views/main/directive/waterMarker.vue')),
  /** 长按指令：v-longpress */
  longpress: createNameComponent(() => import('@/views/main/directive/longpress.vue')),
  /** 按钮防抖指令：v-debounce */
  debounce: createNameComponent(() => import('@/views/main/directive/debounce.vue')),
  /** 下拉加载指令：v-infinite-scroll */
  scroll: createNameComponent(() => import('@/views/main/directive/infiniteScroll.vue')),
  /** 点击外部区域：v-click-outside */
  clickOutside: createNameComponent(() => import('@/views/main/directive/clickOutside.vue')),
}

/** echarts图表 */
const echarts = {
  /** 柱状图 */
  bar: createNameComponent(() => import('@/views/main/echarts/bar.vue')),
  /** 折线图 */
  line: createNameComponent(() => import('@/views/main/echarts/line.vue')),
  /** 饼图 */
  pie: createNameComponent(() => import('@/views/main/echarts/pie.vue')),
  /** 雷达图 */
  radar: createNameComponent(() => import('@/views/main/echarts/radar.vue')),
  /** 地图 */
  map: createNameComponent(() => import('@/views/main/echarts/map.vue')),
}

/** JS打印事件 */
const print = {
  /** 打印 */
  print: createNameComponent(() => import('@/views/main/print/index.vue')),
}


/** 导出所有路由，供后端配置使用 */
const allRoutes = {
  dashboard,
  document,
  component,
  directive,
  echarts,
  print,
}

export default allRoutes