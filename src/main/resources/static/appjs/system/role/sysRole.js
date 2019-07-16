/*$(document).ready(function () {

});*/
var prefix = "/system/role";
$(function () {
    load("");       //加载用户数据Grid
});
function reLoad() {
    $('#exampleTable').bootstrapTable('refresh');
}
function load(id) {
    $('#exampleTable').bootstrapTable(
            {
                method : 'get', // 服务器数据的请求方式 get or post
                url : prefix + "/list", // 服务器数据的加载地址
                showRefresh : true,
                 //showToggle : true,
                iconSize : 'outline',
                toolbar : '#exampleToolbar',
                striped : true, // 设置为true会有隔行变色效果
                dataType : "json", // 服务器返回的数据类型
                pagination : true, // 设置为true会在底部显示分页条
                // queryParamsType : "limit",
                // //设置为limit则会发送符合RESTFull格式的参数
                singleSelect : false, // 设置为true将禁止多选
                // contentType : "application/x-www-form-urlencoded",
                // //发送到服务器的数据编码类型
                pageSize : 10, // 如果设置了分页，每页数据条数
                pageNumber : 1, // 如果设置了分布，首页页码
                // search : true, // 是否显示搜索框
                showColumns : false, // 是否显示内容下拉框（选择显示的列）
                sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者
                // "server"
                queryParams : function(params) {
                    return {
                        // 说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        limit : params.limit,
                        offset : params.offset,
                        name : $('#searchName').val(),
                        deptId : id
                    };
                },
                columns : [
                    {
                        checkbox : true
                    },
                    {
                      field : 'id',
                      title : '主键ID',
                      visible : false,
                    },
                    {
                        field : 'Number',
                        title : '序号',
                        align: 'center',
                        width: 20,
                        formatter : function(value, row, index) {
                            //return index + 1;
                            var pageSize=$('#exampleTable').bootstrapTable('getOptions').pageSize;//通过表的#id 可以得到每页多少条
                            var pageNumber=$('#exampleTable').bootstrapTable('getOptions').pageNumber;//通过表的#id 可以得到当前第几页
                            return pageSize * (pageNumber - 1) + index + 1;//返回每条的序号： 每页条数 * （当前页 - 1 ）+ 序号
                        }
                    },
                    {
                        field : 'name',
                        title : '姓名'
                    },
                    {
                        field : 'username',
                        title : '用户名'
                    },
                    {
                        field : 'email',
                        title : '邮箱'
                    },
                    {
                        field : 'status',
                        title : '状态',
                        align : 'center',
                        formatter : function(value, row, index) {
                            if (value == '0') {
                                return '<span class="label label-danger">禁用</span>';
                            } else if (value == '1') {
                                return '<span class="label label-primary">正常</span>';
                            }
                        }
                    },
                    {
                        title : '操作',
                        field : 'id',
                        align : 'center',
                        formatter : function(value, row, index) {
                            var e = '<a  class="btn btn-primary btn-sm " href="#" mce_href="#" title="编辑" onclick="edit(\''
                                + row.id
                                + '\')"><i class="fa fa-edit "></i></a> ';
                            var d = '<a class="btn btn-warning btn-sm " href="#" title="删除"  mce_href="#" onclick="remove(\''
                                + row.id
                                + '\')"><i class="fa fa-remove"></i></a> ';
                            var f = '<a class="btn btn-success btn-sm " href="#" title="重置密码"  mce_href="#" onclick="resetPwd(\''
                                + row.id
                                + '\')"><i class="fa fa-key"></i></a> ';
                            return e + d + f;
                        }
                    } ]
            });
}

function add() {
    // iframe层
    layer.open({
        type : 2,
        title : '增加用户',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : prefix + '/add'
    });
}