<!-- 查询 -->
<template>
  <div class="main">
    <div style="text-align: center">
      <el-button @click="handleAdd()" size="small">添加</el-button>
    </div>
    <el-table :data="tableData" style="width: 100%">
      <el-table-column prop="id" label="日期"> </el-table-column>
      <el-table-column prop="name" label="用户名"> </el-table-column>
      <el-table-column prop="password" label="密码"> </el-table-column>
      <el-table-column fixed="right" label="操作" width="100">
        <template slot-scope="scope">
          <el-button @click="handleEdit(scope.row)" type="text" size="small"
            >编辑</el-button
          >
          <el-button @click="handleDel(scope.row)" type="text" size="small"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>

    <el-drawer
      :title="title"
      :visible.sync="dialog"
      direction="rtl"
      custom-class="demo-drawer"
      ref="drawer"
    >
      <div class="demo-drawer__content">
        <el-form :model="form" ref="form">
          <el-form-item
            label="用户名"
            prop="name"
            :label-width="formLabelWidth"
          >
            <el-input v-model="form.name" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item
            label="密码"
            prop="password"
            :label-width="formLabelWidth"
          >
            <el-input v-model="form.password" autocomplete="off"></el-input>
          </el-form-item>
        </el-form>
        <div class="demo-drawer__footer">
          <el-button @click="dialog = false">取 消</el-button>
          <el-button
            type="primary"
            @click="Submit('ruleForm')"
            :loading="loading"
            >{{ loading ? "提交中 ..." : "确 定" }}</el-button
          >
        </div>
      </div>
    </el-drawer>
  </div>
</template>

<script>
//这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
//例如：import 《组件名称》 from '《组件路径》';

export default {
  // 当前页面的名字，用于路由跳转以及keep-live缓存
  name: 'pagename',
  // 接收父组件传来的数据
  props: {},
  // mixin混入后注册使用
  mixins: [],
  //import引入的组件需要注入到对象中才能使用
  components: {},
  data () {
    //这里存放数据
    return {
      tableData: [],
      dialog: false,
      form: {
        name: '',
        password: '',
        id: '',
      },
      formLabelWidth: '80px',
      loading: false,

      title: "添加一个用户",
    };
  },
  //监听属性 类似于data概念
  computed: {},
  //监控data中的数据变化
  watch: {},
  //方法集合
  methods: {
    handleAdd () {
      this.dialog = true;
      this.title = "添加一个用户";
      this.$nextTick(() => {
        this.$refs["form"].resetFields();
      })
    },
    Submit () {
      let vm = this;
      let { id, name, password } = vm.form;
      vm.loading = true;
      if (id == '') {
        this.$axios({
          method: 'GET',
          url: `http://10.8.9.56:8081/user/register?name=${name}&password=${password}`,
          data: {    //这里是发送给后台的数据

          }
        }).then((response) => {

          if (response.data == "注册成功") {
            this.$message({
              message: response.data,
              type: 'success'
            });
            vm.gettabledata();
            vm.dialog = false;
            vm.loading = false;
          } else {
            this.$message({
              message: response.data,
              type: 'error'
            });
            vm.dialog = false;
            vm.loading = false;
          }

        }).catch((error) => {
          this.$message({
            message: error,
            type: 'error'
          });
        })
      } else {
        this.$axios({
          method: 'GET',
          url: `http://10.8.9.56:8081/user/edituser?id=${id}&name=${name}&password=${password}`,
          data: {    //这里是发送给后台的数据

          }
        }).then((response) => {
          // console.log('response :>> ', response);
          if (response.data.code == 200) {
            this.$message({
              message: response.data.msg,
              type: 'success'
            });
            vm.gettabledata();
            vm.dialog = false;
            vm.loading = false;
          } else {
            this.$message({
              message: response.data.msg,
              type: 'error'
            });
            vm.dialog = false;
            vm.loading = false;
          }

        }).catch((error) => {
          this.$message({
            message: error,
            type: 'error'
          });
        })
      }
    },

    handleEdit (row) {
      this.title = "修改一个用户";
      this.dialog = true;
      this.form.id = row.id;
      this.form.name = row.name;
      this.form.password = row.password;
    },

    handleDel (row) {
      // console.log('row :>> ', row);
      this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$axios({
          method: 'GET',
          url: `http://10.8.9.56:8081/user/deluser?id=${row.id}`,
          data: {    //这里是发送给后台的数据

          }
        }).then(response => {
          // console.log('res :>> ', response);
          this.gettabledata();
          this.$message({
            message: response.data.msg,
            type: 'success'
          });
        }).catch(error => {
          this.$message({
            message: error,
            type: 'error'
          });
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },

    // 获取所有数据
    gettabledata () {
      this.$axios({
        method: 'GET',
        url: `http://10.8.9.56:8081/user/alluser`,
        data: {    //这里是发送给后台的数据

        }
      }).then(response => {
        this.tableData = response.data.data;
      }).catch(error => {
        this.$message({
          message: error,
          type: 'error'
        });
      })
    },
  },
  //生命周期 - 创建完成（可以访问当前this实例）
  created () {

  },
  //生命周期 - 挂载完成（可以访问DOM元素）
  mounted () {
    this.gettabledata();
  },
  beforeCreate () { }, //生命周期 - 创建之前
  beforeMount () { }, //生命周期 - 挂载之前
  beforeUpdate () { }, //生命周期 - 更新之前
  updated () { }, //生命周期 - 更新之后
  beforeDestroy () { }, //生命周期 - 销毁之前
  destroyed () { }, //生命周期 - 销毁完成
  activated () { }, //如果页面有keep-alive缓存功能，这个函数会触发
}
</script>
<style lang='scss' scoped>
//@import url(); 引入公共css类
</style>