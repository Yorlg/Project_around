<!-- 注册 -->
<template>
  <div class="main">
    <div class="main-form">
      <H2 style="text-align: center">注册</H2>
      <el-form ref="form" :model="form">
        <el-form-item label="用户名">
          <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="form.password" type="password"></el-input>
        </el-form-item>
        <el-form-item>
          <div
            style="
              display: flex;
              flex-direction: row;
              flex-wrap: nowrap;
              justify-content: space-between;
            "
          >
            <el-button type="primary" @click="onRegister">立即注册</el-button>

            <router-link to="login" style="text-decoration: none">
              <span style="color: red; cursor: pointer">
                有账号，立即登入
              </span>
            </router-link>
          </div>
        </el-form-item>
      </el-form>
    </div>
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
      form: {
        name: '',
        password: '',
      },
    };
  },
  //监听属性 类似于data概念
  computed: {},
  //监控data中的数据变化
  watch: {},
  //方法集合
  methods: {
    onRegister () {
      let vm = this;
      let { name, password } = vm.form;
      this.$axios({
        method: 'GET',
        url: `http://10.8.9.56:8081/user/register?name=${name}&password=${password}`,
        data: {    //这里是发送给后台的数据

        }
      }).then((response) => {

        if (response.data == "注册成功") {
          this.$router.push({ path: '/login' });

          this.$message({
            message: response.data,
            type: 'success'
          });
        } else {
          this.$message({
            message: response.data,
            type: 'error'
          });
        }

      }).catch((error) => {
        this.$message({
          message: error,
          type: 'error'
        });
      })
    }
  },
  //生命周期 - 创建完成（可以访问当前this实例）
  created () {

  },
  //生命周期 - 挂载完成（可以访问DOM元素）
  mounted () {

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

.main {
  width: 100%;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;

  .main-form {
    width: 20%;
  }
}
</style>