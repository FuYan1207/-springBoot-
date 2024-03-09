<template>
  <Layer :layer="layer" @confirm="submit" ref="layerDom">
    <el-form :model="form" :rules="rules" ref="ruleForm" label-width="120px" style="margin-right:30px;">
      <el-form-item label="权限" prop="permission">
        <el-select v-model="form.permission" placeholder="请选择" clearable>
          <el-option v-for="item in selectData" :key="item.value" :label="item.label" :value="item.label"></el-option>
        </el-select>
      </el-form-item>
    </el-form>
  </Layer>
</template>

<script lang="ts">
import type { LayerType } from '@/components/layer/index.vue'
import type { Ref } from 'vue'
import type { ElFormItemContext } from 'element-plus/lib/el-form/src/token'
import { defineComponent, ref } from 'vue'
import {update } from '@/api/system/user'
import Layer from '@/components/layer/index.vue'
export default defineComponent({
  components: {
    Layer
  },
  props: {
    layer: {
      type: Object,
      default: () => {
        return {
          show: false,
          title: '',
          showButton: true
        }
      }
    }
  },
  setup(props, ctx) {
    const ruleForm: Ref<ElFormItemContext | null> = ref(null)
    const layerDom: Ref<LayerType | null> = ref(null)
    let form = ref({
      permission: props.layer.row.permission
    })
    const selectData = [
      { value: 1, label: '管理员' },
      { value: 2, label: '普通用户' },
    ]
    const rules = {
      permission: [{ required: true, message: '请选择权限', trigger: 'blur' }]
    }
    init()
    function init() {
      if (props.layer.row) {
        form.value = JSON.parse(JSON.stringify(props.layer.row)) // 数量量少的直接使用这个转
      } else {

      }
    }
    return {
      form,
      selectData,
      rules,
      layerDom,
      ruleForm,
    }
  },
  methods: {
    submit() {
      if (this.ruleForm) {
        this.ruleForm.validate((valid) => {
          if (valid) {
            let params = {
              userId:this.form.userId,
              permission:this.form.permission
            }
            this.updateForm(params)
          } else {
            return false;
          }
        });
      }
    },
    // 编辑提交事件
    updateForm(params: object) {
      update(params)
        .then(res => {
          this.$message({
            type: 'success',
            message: '编辑成功'
          })
          this.$emit('getTableData', false)
          this.layerDom && this.layerDom.close()
        })
    }
  }
})
</script>

<style lang="scss" scoped></style>