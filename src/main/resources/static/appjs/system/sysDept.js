var prefix = "/sys/user"
$(function () {
    alert(111);
    getTreeData();
})
/*$(document).ready(function () {

});*/
function getTreeData(){
    $.ajax({
        type : "post",
        url : "/sys/dept/tree",
        success : function(tree) {
            loadTree(tree);
        }
    });
}
function loadTree(tree) {
    $('#jsTree').jstree({
        'core' : {
            'data' : tree
        },
        "plugins" : [ "search"]
    });
    //$('#jsTree').jstree().open_all();
}
$('#jsTree').on("changed.jstree", function (e, data) {
    debugger
    console.log(data.selected);
    console.log(e);
    console.log(data);
});