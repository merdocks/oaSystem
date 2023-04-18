<template>
  <div class="app-container">
    <!--查询表单-->
    <div class="search-div">
      <el-form label-width="70px" size="small">
        <el-row>
          <el-col :span="24">
            <el-form-item label="角色名称">
              <el-input
                style="width: 100%"
                v-model="searchObj.roleName"
                placeholder="角色名称"
              ></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row style="display: flex">
          <el-button
            type="primary"
            icon="el-icon-search"
            size="mini"
            :loading="loading"
            @click="fetchData()"
            >搜索</el-button
          >
          <el-button icon="el-icon-refresh" size="mini" @click="resetData"
            >重置</el-button
          >
        </el-row>
      </el-form>
    </div>
    <!-- 表格 -->
    
    <el-table
      v-loading="listLoading"
      :data="list"
      stripe
      border
      style="width: 100%; margin-top: 10px"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" />

      <el-table-column label="序号" width="70" align="center">
        <template slot-scope="scope">
          {{ (page - 1) * limit + scope.$index + 1 }}
        </template>
      </el-table-column>

      <el-table-column prop="roleName" label="角色名称" />
      <el-table-column prop="roleCode" label="角色编码" />
      <el-table-column prop="createTime" label="创建时间" width="160" />
      <el-table-column label="操作" width="200" align="center">
        <template slot-scope="scope">
          <el-button
            type="primary"
            icon="el-icon-edit"
            size="mini"
            @click="edit(scope.row.id)"
            title="修改"
          />
          <el-button
            type="danger"
            icon="el-icon-delete"
            size="mini"
            @click="removeDataById(scope.row.id)"
            title="删除"
          />
          <el-button type="warning" icon="el-icon-baseball" size="mini" @click="showAssignAuth(scope.row)" title="分配权限"/>
        </template>
      </el-table-column>
    </el-table>
    <!-- 工具条 -->
    <div class="tools-div">
          <!-- <el-button type="success" icon="el-icon-plus" size="mini" @click="add">添 加</el-button> -->
          <el-button type="success" icon="el-icon-plus" size="mini" @click="add" :disabled="$hasBP('bnt.sysRole.add')  === false">添 加</el-button>
          <el-button class="btn-add" size="mini" @click="batchRemove()" >批量删除</el-button>
    </div>
    <!-- 分页组件 -->
    <el-pagination
      :current-page="page"
      :total="total"
      :page-size="limit"
      style="padding: 30px 0; text-align: center"
      layout="total, prev, pager, next, jumper"
      @current-change="fetchData"
    />
    <el-dialog title="添加/修改" :visible.sync="dialogVisible" width="40%" >
      <el-form ref="dataForm" :model="sysRole" label-width="150px" size="small" style="padding-right: 40px;">
        <el-form-item label="角色名称">
          <el-input v-model="sysRole.roleName"/>
        </el-form-item>
        <el-form-item label="角色编码">
          <el-input v-model="sysRole.roleCode"/>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false" size="small" icon="el-icon-refresh-right">取 消</el-button>
        <el-button type="primary" icon="el-icon-check" @click="saveOrUpdate()" size="small">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
//引入定义接口js文件
import api from "@/api/system/sysRole";
export default {
  //vue代码结构
  //初始值
  data() {
    return {
      list: [], //角色列表
      page: 1, //当前页
      limit: 3, //每页显示记录数
      total: 0, //总记录数
      searchObj: {}, //条件对象

      selections:[],
      sysRole:{},
      dialogVisible:false//是否弹框
    };
  },
  created() {
    //渲染之前执行
    this.fetchData();
  },
  methods: {//操作方法
    //跳转到分配菜单的页面
    showAssignAuth(row) {
       this.$router.push('/system/assignAuth?id='+row.id+'&roleName='+row.roleName);
    },
    handleSelectionChange(selection) {
       this.selections=selection
       console.log(this.selections)
    },
    //批量删除
    batchRemove(){
      if(this.selections.length == 0){
        this.$message.warning('选一下要删除的数据！')
        return
      }
      this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
       confirmButtonText: '确定',
       cancelButtonText: '取消',
       type: 'warning'
    }).then(response => {
       var idList = []
       this.selections.forEach(item => {
        var id = item.id
        idList.push(id)
       });
       return api.batchRemove(idList)
    }).then(response => {
      this.$message.success(response.message)
      this.fetchData()
    })
  },
    //点击修改，弹出框，根据id查询数据显示
    edit(id){
      this.dialogVisible = true
      this.fetchDataById(id)
    },
    fetchDataById(id){
      api.getById(id)
         .then(response => {
          this.sysRole = response.data
        })
    },
    //点击添加弹出框
    add(){
      this.dialogVisible=true
    },
    saveOrUpdate(){
       if(!this.sysRole.id) {
        this.save()
       }else {
        this.update()
       }
    },
    save(){
       api.saveRole(this.sysRole)
          .then(response => {
            this.$message.success(response.message || "操作成功")
            this.dialogVisible = false
            this.fetchData()
          })
    },
    update(){
     api.updateById(this.sysRole)
        .then(response => {
          this.$message.success(response.message || "操作成功")
          this.dialogVisible = false
          this.fetchData()
        })
    },
    //条件分页查询
    fetchData(current = 1) {
      this.page = current;
      api
        .getPageList(this.page, this.limit, this.searchObj)
        .then((response) => {
          this.list = response.data.records;
          this.total = response.data.total;
        });
    },
    removeDataById(id) {
      this.$confirm("此操作将永久删除该记录, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          return api.removeById(id);
        })
        .then((response) => {
          this.fetchData();
          this.$message.success(response.message || "删除成功");
        });
    },
    
  },
};
</script>