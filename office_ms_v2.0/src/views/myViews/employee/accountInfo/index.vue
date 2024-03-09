<template>
  <div class="layout-container">
    <div class="layout-container-form flex space-between">
      <div class="layout-container-form-handle">
      </div>
      <div class="layout-container-form-search">
        <el-input
          v-model="query.input"
          :placeholder="$t('message.common.searchTip')"
        ></el-input>
        <el-button
          type="primary"
          :icon="Search"
          class="search-btn"
          @click="getTableData(true)"
          >{{ $t("message.common.search") }}</el-button
        >
      </div>
    </div>
    <div class="layout-container-table">
      <Table
        ref="table"
        v-model:page="page"
        v-loading="loading"
        :showIndex="true"
        :data="tableData"
        @getTableData="getTableData"
      >
        <el-table-column prop="userId" label="账户id" align="center" width="80" />
        <el-table-column prop="username" label="用户名" align="center" />
        <el-table-column prop="employeeId" label="所属人" align="center" />
        <el-table-column prop="createDate" label="创建时间" align="center" />
        <el-table-column prop="permission" label="权限" align="center">
          <!-- <template #default="scope">
            <span class="statusName">{{ scope.row.isAdmin === 1 ? "是" : "否" }}</span>
          </template> -->
        </el-table-column>
        <el-table-column prop="status" label="状态" align="center">
          <template #default="scope">
            <span class="statusName">{{ scope.row.status === "1" ? "启用" : "禁用" }}</span>
            <el-switch
              v-model="scope.row.status"
              active-color="#13ce66"
              inactive-color="#ff4949"
              active-value="1"
              inactive-value="0"
              :loading="scope.row.loading"
              @change="handleUpdateStatus(scope.row)"
              :disabled="scope.row.username === 'root'"
            ></el-switch>
          </template>
        </el-table-column>
        <el-table-column
          :label="$t('message.common.handle')"
          align="center"
          fixed="right"
          width="200"
        >
          <template #default="scope">
            <el-button 
            @click="handleEdit(scope.row)"
            :disabled="scope.row.username === 'root'"
            >
            {{
              $t("message.common.status")
            }}
            </el-button>
          </template>
        </el-table-column>
      </Table>
      <Layer :layer="layer" @getTableData="getTableData" v-if="layer.show" />
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent, ref, reactive } from "vue";
import { Page } from "@/components/table/type";
import { getData, updateStatus } from "@/api/system/user";
import { LayerInterface } from "@/components/layer/index.vue";
import { ElMessage } from "element-plus";
import Table from "@/components/table/index.vue";
import Layer from "./layer.vue";
import { Plus, Delete, Search } from '@element-plus/icons'
export default defineComponent({
  components: {
    Table,
    Layer,
  },
  setup() {
    // 存储搜索用的数据
    const query = reactive({
      input: "",
    });
    // 弹窗控制器
    const layer: LayerInterface = reactive({
      show: false,
      title: "新增",
      showButton: true,
    });
    // 分页参数, 供table使用
    const page: Page = reactive({
      index: 1,
      size: 20,
      total: 0,
    });
    const loading = ref(true);
    const tableData = ref([]);
    const chooseData = ref([]);
    // 获取表格数据
    // params <init> Boolean ，默认为false，用于判断是否需要初始化分页
    const getTableData = (init: Boolean) => {
      loading.value = true
      if (init) {
        page.index = 1
      }
      let params = {
        page: page.index,
        pageSize: page.size,
        ...query
      }
      getData(params)
        .then((res) => {
          let data = res.data.items
          data.forEach((d: any) => {
            d.loading = false
          })
          tableData.value = data
          page.total = Number(res.data.total);
        })
        .catch((error) => {
          tableData.value = [];
          page.index = 1;
          page.total = 0;
        })
        .finally(() => {
          loading.value = false;
        });
    }
    // 编辑弹窗功能
    const handleEdit = (row: any) => {
      layer.title = "更改权限";
      layer.row = row;
      layer.show = true;
    }
    // 状态编辑功能
    const handleUpdateStatus = (row: any) => {
      if (!row.userId) {
        return
      }
      row.loading = true
      let params = {
        userId: row.userId,
        status: row.status
      }
      updateStatus(params)      
      .then(res => {
        ElMessage({
          type: 'success',
          message: '状态变更成功'
        })
      })
      .catch(err => {
        ElMessage({
          type: 'error',
          message: '状态变更失败'
        })
      })
      .finally(() => {
        row.loading = false
      })
    }
    getTableData(true)
    return {
      Plus,
      Delete,
      Search,
      query,
      tableData,
      chooseData,
      loading,
      page,
      layer,
      getTableData,
      handleEdit,
      handleUpdateStatus
    };
  }
});
</script>

<style lang="scss" scoped>
.statusName {
  margin-right: 10px;
}
</style>
