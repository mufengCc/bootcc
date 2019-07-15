$(document).ready(function () {
    validateRule();

});
$.validator.setDefaults({
    submitHandler: function() {
        alert("提交事件!");
        save();
    }
});

function getCheckedRoles() {
    var adIds = "";
    $("input:checkbox[name=role]:checked").each(function(i) {
        if (0 == i) {
            adIds = $(this).val();
        } else {
            adIds += ("," + $(this).val());
        }
    });
    return adIds;
}


function save() {
    //$("#roleIds").val(getCheckedRoles());
    debugger;
    $.ajax({
        cache : true,
        type : "POST",
        url : "/system/user/save",
        data : $('#signupForm').serialize(),// 你的formid
        async : false,
        error : function(request) {
            parent.layer.alert("Connection error");
        },
        success : function(data) {
            debugger;
            if (data.code == 0) {
                parent.layer.msg("操作成功");
                parent.reLoad();
                var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
                parent.layer.close(index);

            } else {
                parent.layer.alert(data.msg)
            }

        }
    });

}


function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#signupForm").validate({
        rules : {
            name : {
                required : true
            },
            username : {
                required : false,
                minlength : 2,
                /*remote : {
                    url : "/system/user/exit", // 后台处理程序
                    type : "post", // 数据发送方式
                    dataType : "json", // 接受数据格式
                    data : { // 要传递的数据
                        username : function() {
                            return $("#username").val();
                        }
                    }
                }*/
            },
            password : {
                required : true,
                minlength : 6
            },
            confirm_password : {
                required : true,
                minlength : 6,
                equalTo : "#password"
            },
            email : {
                required : false,
                email : true
            },
            topic : {
                required : "#newsletter:checked",
                minlength : 2
            },
            agree : "required"
        },
        messages : {

            name : {
                required : icon + "请输入姓名"
            },
            username : {
                required : icon + "请输入您的用户名",
                minlength : icon + "用户名必须两个字符以上",
                remote : icon + "用户名已经存在"
            },
            password : {
                required : icon + "请输入您的密码",
                minlength : icon + "密码必须6个字符以上"
            },
            confirm_password : {
                required : icon + "请再次输入密码",
                minlength : icon + "密码必须6个字符以上",
                equalTo : icon + "两次输入的密码不一致"
            },
            email : icon + "请输入您的E-mail",
        }
    })
}

var openDept = function(){
    layer.open({
        type:2,
        title:"选择部门",
        area : [ '300px', '450px' ],
        content:"/system/dept/deptTreeView"
    })
}

function loadDept( deptId,deptName){
    $("#deptId").val(deptId);
    $("#deptName").val(deptName);
}
