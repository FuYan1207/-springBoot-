<template>
  <Layer :layer="layer" @confirm="submit" ref="layerDom">
    <el-form :model="form" :rules="rules" ref="ruleForm" label-width="120px" style="margin-right:30px;">
      <el-form-item label="姓名" prop="name">
        <el-input v-model="form.name" placeholder="请输入名称"></el-input>
      </el-form-item>
      <el-form-item label="性别" prop="gender">
        <el-radio-group v-model="form.gender">
          <el-radio v-for="item in radioData" :key="item.value" :label="item.label">{{ item.label }}</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="年龄" prop="age">
        <el-input v-model="form.age" oninput="value=value.replace(/[^\d]/g,'')" placeholder="请输入年龄"></el-input>
      </el-form-item>
      <el-form-item label="电话" prop="contactInfo">
        <el-input v-model="form.contactInfo" oninput="value=value.replace(/[^\d]/g,'')" placeholder="请输入电话"></el-input>
      </el-form-item>
			<el-form-item label="职位" prop="position">
			  <el-select v-model="form.position" placeholder="请选择" clearable>
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
import { add, update } from '@/api/table'
import { selectData, radioData } from './enum'
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
    const ruleForm: Ref<ElFormItemContext|null> = ref(null)
    const layerDom: Ref<LayerType|null> = ref(null)
    let form = ref({
      name: '',
      gender: '',
      age: '',
      contactInfo: '',
      position:''
    })
    const rules = {
      name: [{ required: true, message: '请输入姓名', trigger: 'blur' }],
      gender: [{ required: true, message: '请选择性别', trigger: 'blur' }],
      age: [{ required: true, message: '请输入年龄', trigger: 'blur' }],
      contactInfo: [{ required: true, message: '请输入联系方式', trigger: 'blur' }],
      position: [{ required: true, message: '请选择职位', trigger: 'blur' }]
    }
    init()
    function init() { // 用于判断新增还是编辑功能
      if (props.layer.row) {
        form.value = JSON.parse(JSON.stringify(props.layer.row)) // 数量量少的直接使用这个转
      } else {

      }
    }
    return {
      form,
      rules,
      layerDom,
      ruleForm,
      selectData,
      radioData
    }
  },
  methods: {
    submit() {
      if (this.ruleForm) {
        this.ruleForm.validate((valid) => {
          if (valid) {
            let params = this.form
            console.log(params);
            
            if (this.layer.row) {
              this.updateForm(params)
            } else {
              this.addForm(params)
            }
          } else {
            return false;
          }
        });
      }
    },
    // 新增提交事件
    addForm(params: object) {
      add(params)
      .then(res => {
        this.$message({
          type: 'success',
          message: '新增成功'
        })
        this.$emit('getTableData', true)
        this.layerDom && this.layerDom.close()
      })
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

<style lang="scss" scoped>
  
</style>